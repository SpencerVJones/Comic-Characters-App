// Spencer Jones
// MDV3832-0 - 062024
// CharacterAdapter.java

package com.example.jonesspencer_ce05;

// Imports
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CharacterAdapter extends ArrayAdapter<ComicCharacter> {

    // Constructor
    public CharacterAdapter(Context context, List<ComicCharacter> characters) {
        super(context, 0, characters);
    }

    // Method to get view for each item in list
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get ComicCharacter at specified position
        ComicCharacter character = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get references to TextViews in layout
        TextView name = convertView.findViewById(R.id.character_name);
        TextView firstAppearance = convertView.findViewById(R.id.character_first_appearance);

        // Set text for  TextViews based on character's attributes
        name.setText(character.getName());
        firstAppearance.setText(character.getFirstAppearance());

        return convertView;
    }
}