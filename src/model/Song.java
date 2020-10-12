package model;

public class Song {
    private int AlbumId;
    private String track;
    private String title;
    private int albumId;

    public Song(int albumId, String track, String title, int albumId1) {
        AlbumId = albumId;
        this.track = track;
        this.title = title;
        this.albumId = albumId1;
    }

    public int getAlbumId() {
        return AlbumId;
    }

    public void setAlbumId(int albumId) {
        AlbumId = albumId;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
