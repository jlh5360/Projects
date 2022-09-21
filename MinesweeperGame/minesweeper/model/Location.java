package minesweeper.model;

public class Location {
    private int row;
    private int col;
    //Field variables from the Cell class
    private boolean covered;
    private char currentView;
    private char value;
    private boolean isMine;
    // What I added for "Beyond The Project"
    // =======================
    private boolean isFlagged;
    // =======================

    //Original constructor
    // public Location(int row, int col) {

    //New constructor
    public Location(int row, int col, char value) {
        this.row = row;
        this.col = col;
        //Below are from Cell class
        this.covered = true;
        this.currentView = value;
        this.value = '-';
        this.isMine = false;
        // What I added for "Beyond The Project"
        // ====================
        this.isFlagged = false;
        // ====================
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location other = (Location)obj;
            
            if (this.row == other.row && this.col == other.col) {
                return true;
            }
        }
        return false;
    }

    //Added these functions/modified them below from the Cell class
    public void uncover() {
        this.covered = false;
        this.currentView = this.value;
    }

    public char getValue(){
        return this.value;
    }

    public boolean isCovered() {
        return this.covered;
    }

    public boolean isMine() {
        return this.isMine;
    }

    // What I added for "Beyond The Project"
    public boolean isFlagged() {
        return this.isFlagged;
    }

    public void setAsMine() {
        if(this.covered) {
            this.isMine = true;
            this.value = 'M';
        }
    }

    // What I added for "Beyond The Project"
    // =====================================
    public void setAsFlag() {
        if(this.covered == true) {
            this.isFlagged = true;
            this.currentView = 'F';
        }
    }

    public void removeFlag() {
        if (this.currentView == 'F') {
            this.currentView = '-';
            this.isFlagged = false;
            this.covered = true;
        }
    }
    // =====================================

    public void setValue(char value) {
        if(this.value == '-') {
            this.value = value;
        }
    }

    public char getCurrentView() {
        return this.currentView;
    }

    @Override
    public String toString() {
        return "" + this.currentView;
    }
}
