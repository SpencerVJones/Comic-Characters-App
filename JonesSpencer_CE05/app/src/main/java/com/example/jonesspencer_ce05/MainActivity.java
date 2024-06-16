// Spencer Jones
// MDV3832-0 - 062024
// MainActivity.java

package com.example.jonesspencer_ce05;

// Imports
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private Spinner spinner;
    private List<ComicCharacter> characters;
    private LinearLayout detailsView;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        characters = getCharacters(); // Method to populate character list

        listView = findViewById(R.id.list_view);
        spinner = findViewById(R.id.spinner);
        detailsView = findViewById(R.id.details_view);
        imageView = findViewById(R.id.character_image);

        CharacterAdapter adapter = new CharacterAdapter(this, characters); // Create adapter

        if (listView != null) {
            listView.setAdapter(adapter);
            // Select first character in list (default)
            listView.setSelection(0);
            populateDetailsView(characters.get(0)); // Populate details for first character
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    populateDetailsView(characters.get(position)); // Populate details when list item clicked
                }
            });
        }

        if (spinner != null) {
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getCharacterNames());
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(spinnerAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    populateDetailsView(characters.get(position));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            });
        }
    }

    // Method to populate list of ComicCharacter objects
    private List<ComicCharacter> getCharacters() {
        List<ComicCharacter> characters = new ArrayList<>();
        characters.add(new ComicCharacter("SpiderMan", "06/05/1962", 900, R.drawable.spiderman, "Spider-Man comics are about Peter Parker, an orphan who is bitten by a radioactive spider and gains arachnid powers. Peter uses his powers to fight crime and help others as Spider-Man, while also dealing with the challenges of his personal life."));
        characters.add(new ComicCharacter("Batman", "05/01/1939", 1000, R.drawable.batman, "Batman, also known as Bruce Wayne, is a billionaire playboy who becomes the vigilante protector of Gotham City after witnessing the murder of his parents. He uses his vast wealth, intellect, and physical prowess to fight crime and bring justice to the city."));
        characters.add(new ComicCharacter("Iron Man", "03/01/1963", 600, R.drawable.ironman, "Iron Man, also known as Tony Stark, is a genius billionaire inventor who creates a powered suit of armor to save his own life and fight evil. He uses his suit, equipped with advanced technology, to protect the world as Iron Man."));
        characters.add(new ComicCharacter("Spawn", "05/01/1992", 300, R.drawable.spawn, "Spawn, also known as Al Simmons, is a former government assassin who is killed and sent to Hell. He makes a deal with a demon to return to Earth as a Hellspawn, with supernatural powers and a thirst for vengeance against his enemies."));
        characters.add(new ComicCharacter("Lobo", "06/20/1983", 150, R.drawable.lobo, "Lobo is an alien bounty hunter and mercenary known for his irreverent attitude, extreme violence, and love of mayhem. Despite his rough exterior, he occasionally shows a sense of honor and loyalty."));
        characters.add(new ComicCharacter("Blade", "07/10/1973", 100, R.drawable.blade, "Blade, also known as Eric Brooks, is a human-vampire hybrid with enhanced strength, speed, and senses. He hunts vampires to avenge his mother's death and protect humanity from the undead."));
        characters.add(new ComicCharacter("Deadpool", "02/01/1991", 250, R.drawable.deadpool, "Deadpool, also known as Wade Wilson, is a mentally unstable mercenary with a superhuman healing factor and a penchant for breaking the fourth wall. He uses his regenerative abilities and combat skills to take down bad guys with his signature sense of humor."));
        characters.add(new ComicCharacter("Moon Knight", "08/01/1975", 200, R.drawable.moonknight, "Moon Knight, also known as Marc Spector, is a former Marine turned mercenary who becomes the avatar of the Egyptian moon god Khonshu. He fights crime and supernatural threats as the vigilante Moon Knight."));
        characters.add(new ComicCharacter("Orion", "05/09/1971", 180, R.drawable.orion, "Orion is a New God from the planet New Genesis, raised by Highfather and trained in combat by the gods. He possesses superhuman strength, speed, and durability, and wields a powerful weapon called the Astro-Harness."));
        characters.add(new ComicCharacter("Punisher", "02/01/1974", 320, R.drawable.punisher, "Punisher, also known as Frank Castle, is a former Marine who becomes a vigilante after his family is killed by the mob. He wages a one-man war on crime, using his military training and arsenal of weapons to take down criminals with lethal force."));
        return characters;
    }

    // Method to get list of character names
    private List<String> getCharacterNames() {
        List<String> names = new ArrayList<>();
        for (ComicCharacter character : characters) {
            names.add(character.getName());
        }
        return names;
    }

    // Method to populate details view with character's details
    private void populateDetailsView(ComicCharacter character) {
        TextView nameView = detailsView.findViewById(R.id.character_name);
        TextView firstAppearanceView = detailsView.findViewById(R.id.character_first_appearance);
        TextView issuesView = detailsView.findViewById(R.id.character_issues);
        TextView descriptionView = detailsView.findViewById(R.id.character_description);

        if (imageView != null) {
            imageView.setImageResource(character.getImage());
        }
        if (nameView != null) {
            nameView.setText(character.getName());
        }
        if (firstAppearanceView != null) {
            firstAppearanceView.setText(character.getFirstAppearance());
        }
        if (issuesView != null) {
            issuesView.setText(String.valueOf(character.getIssues()));
        }
        if (descriptionView != null) {
            descriptionView.setText(character.getDescription());
        }
    }
}