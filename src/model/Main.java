package model;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            return;
        }

//        ArrayList<Artist> artists = dataSource.queryArtists(DataSource.ORDER_BY_ASC);
//        if (artists != null) {
//            for (Artist artist : artists) {
//                System.out.println(artist.getId() + ": " + artist.getName());
//            }
//        } else {
//            return;
//        }
        ArrayList<String> albums = dataSource.queryAlbumsForArtist("Pink Floyd", DataSource.ORDER_BY_ASC);
        if(albums != null) {
            for (String album : albums) {
                System.out.println(album);
            }
        }else {
            return;
        }
        dataSource.close();
    }
}
