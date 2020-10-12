package model;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            return;
        }
        ArrayList<Artist> artists = dataSource.queryArtists();
        if (artists != null) {
            for (Artist artist : artists) {
                System.out.println(artist.getId() + ": " + artist.getName());
            }
        } else {
            return;
        }
        dataSource.close();
    }
}
