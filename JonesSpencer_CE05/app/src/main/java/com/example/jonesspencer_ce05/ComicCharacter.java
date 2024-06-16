// Spencer Jones
// MDV3832-0 - 062024
// ComicCharacter.java

package com.example.jonesspencer_ce05;

// Class to represent comic book character
public class ComicCharacter {
    private String name;
    private String firstAppearance;
    private int issues;
    private int image;
    private String description;

    // Constructor
    public ComicCharacter(String name, String firstAppearance, int issues, int image, String description) {
        this.name = name;
        this.firstAppearance = firstAppearance;
        this.issues = issues;
        this.image = image;
        this.description = description;
    }

    // Getters
    public String getName() { return name; }
    public String getFirstAppearance() { return firstAppearance; }
    public int getIssues() { return issues; }
    public String getDescription() { return description; }
    public int getImage() { return image; }
}