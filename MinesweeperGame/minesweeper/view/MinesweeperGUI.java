package minesweeper.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import minesweeper.model.GameState;
import minesweeper.model.Location;
import minesweeper.model.Minesweeper;
import minesweeper.model.MinesweeperException;
import minesweeper.model.MinesweeperSolver;


public class MinesweeperGUI extends Application{
    private static final Image MINE = new Image("file:MinesweeperGame/media/images/mine24.png");
    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final int MINES = 13;
    
    private Minesweeper minesweeper;
    private Button[][] buttons;
    private Label feedback;
    private Label number_of_mines;
    private Button reset;
    private Label moves_made;
    private GridPane grid;


    @Override
    public void start(Stage stage) throws Exception {
        this.minesweeper = new Minesweeper(ROWS, COLS, MINES);
        this.buttons = new Button[ROWS][COLS];
        minesweeper.register(new SquareChanger(this));

        VBox vbox = new VBox();


        HBox topBar = new HBox();
        number_of_mines = new Label();
        number_of_mines.setText("Mines:  " + minesweeper.getMineCount());


        reset = new Button();
        reset.setText("Reset");
        reset.setOnAction(new Resetter(this));
        
        moves_made = new Label();
        moves_made.setText("Moves:  " + 0);
        
        // add mines label (number of mines), reset game button, and moves label (number of moves made)
        GridPane topBarPane = new GridPane();

        topBarPane.add(number_of_mines, 0, 0);
        topBarPane.add(reset, 1, 0);
        topBarPane.add(moves_made, 2, 0);
        topBarPane.setHgap(100);

        topBar.getChildren().addAll(topBarPane);


        // GridPane grid = new GridPane();
        // for(int row=0; row<ROWS; row++) {
        //     for(int col=0; col<COLS; col++) {
        //         Button button = makeButton(row, col);
        //         buttons[row][col] = button;
        //         grid.add(button, col, row);
        //     }
        // }
        grid = new GridPane();
        fillGridPane();


        Button hintButton = new Button();
        hintButton.setText("Hint");
        hintButton.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        hintButton.setOnAction(new HintChanger(this));

        Button solveButton = new Button();
        solveButton.setText("Solve");
        solveButton.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        solveButton.setOnAction(new Solver(this));

        
        feedback = new Label();
        feedback.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        feedback.setAlignment(Pos.CENTER);
        updateStatus();

        vbox.getChildren().addAll(topBar, grid, hintButton, solveButton, feedback);
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Minesweeper");
        stage.show();
    }

    private void fillGridPane() {
        for(int row=0; row<ROWS; row++) {
            for(int col=0; col<COLS; col++) {
                Button button = makeButton(row, col);
                buttons[row][col] = button;
                grid.add(button, col, row);
            }
        }
    }

    private Button makeButton(int row, int col){
        Button button = new Button();
        button.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(2), new Insets(1))));
        button.setPrefSize(40, 40);
        button.setOnAction(new SquareObserver(new Location(row, col, '-'), this));
        return button;
    }

    public void updateButton(Location location) {
        Button button = buttons[location.getRow()][location.getCol()];
        
        try {
            if (minesweeper.isCovered(location)) {
                button.setText("");
                // button.setGraphic(arg0);
                button.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(2), new Insets(1))));
            }
            else {
                button.setText("" + minesweeper.getSymbol(location));
                if(button.getText().equals("M")){
                    button.setGraphic(new ImageView(MINE));
                    button.setText(null);
                }
                button.setBackground(new Background(new BackgroundFill(Color.GRAY, new CornerRadii(2), new Insets(1))));
            }
        }
        catch (MinesweeperException e) {
            // Squash
        }
        updateStatus();
        setMovesMade();
    }

    public void solveMinesweeper(){
        MinesweeperSolver solution = (MinesweeperSolver)MinesweeperSolver.createSolver(minesweeper);
        if(solution != null) {
            for(Location location : solution.getSelections()) {
                makeMove(location);
            }
        }
    }

    public void makeMove(Location location) {
        if(minesweeper.getGameState() == GameState.IN_PROGRESS || minesweeper.getGameState() == GameState.NOT_STARTED) {
            try {
                minesweeper.makeSelection(location);
            } catch(MinesweeperException e) {
                feedback.setText(e.getMessage());
            } 
        }
    }

    public void updateHint(){
        for(Location location : minesweeper.getPossibleSelections()){
            if(!location.isMine()){
                Button button = buttons[location.getRow()][location.getCol()];
                button.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(2), new Insets(1))));
                break;
            }
        }
    }

    public void updateStatus() {
        if(minesweeper.getGameState() == GameState.IN_PROGRESS) {
            feedback.setText("Game in progress...");
            feedback.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        } else if(minesweeper.getGameState() == GameState.WON) {
            feedback.setText("Congratulations! You win!");
            feedback.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        } else if(minesweeper.getGameState() == GameState.LOST) {
            feedback.setText("BOOM! You Lose!");
            feedback.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            minesweeper.gameOver();
            
        } else if(minesweeper.getGameState() == GameState.NOT_STARTED) {
            feedback.setText("Welcome to Minesweeper!");
            feedback.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    public void setMinesRemaining(int mines) {
        number_of_mines.setText("Mines: " + mines);
    }

    public void resetGame() {
        this.minesweeper = new Minesweeper(ROWS, COLS, MINES);
        minesweeper.register(new SquareChanger(this));
        setMinesRemaining(MINES);
        setMovesMade();
        updateStatus();

        grid.getChildren().clear();
        fillGridPane();
    }

    public void setMovesMade() {
        moves_made.setText("Moves: " + minesweeper.getMoveCount());
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
