package main.java.com.example.gamesapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import main.java.com.example.gamesapp.adapters.GameListAdapter;
import main.java.com.example.gamesapp.R;
import main.java.com.example.gamesapp.models.Game;




public class GameListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        Game[] games = {
            new Game("Blackjack", R.drawable.blackjack_icon),
            new Game("Poker", R.drawable.poker_icon),
            // Add other games
        };

        ListView listView = findViewById(R.id.gameListView);
        GameListAdapter adapter = new GameListAdapter(this, games);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Game selectedGame = games[position];
                Intent intent = new Intent(GameListActivity.this, GameDetailActivity.class);
                intent.putExtra("selectedGame", selectedGame);
                startActivity(intent);
            }
        });
    }
}
