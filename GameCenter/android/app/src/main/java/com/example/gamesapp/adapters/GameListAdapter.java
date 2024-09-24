package main.java.com.example.gamesapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import main.java.com.example.gamesapp.models.Game;
import main.res.*;




public class GameListAdapter extends ArrayAdapter<Game> {
    public GameListAdapter(Context context, Game[] games) {
        super(context, 0, games);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_game, parent, false);
        }

        Game currentGame = getItem(position);

        ImageView iconImageView = convertView.findViewById(R.id.iconImageView);
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);

        if (currentGame != null) {
            iconImageView.setImageResource(currentGame.getIconResourceId());
            nameTextView.setText(currentGame.getName());
        }


        return convertView;
    }
}
