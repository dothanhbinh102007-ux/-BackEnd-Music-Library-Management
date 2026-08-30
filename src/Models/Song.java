/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

public class Song {
    private int songID;
    private String title;
    private String artist;
    private String genre;
    private int duration;
    private String filePath;
    
    public Song(int songID, String title, String artist,
                String genre, int duration, String filePath) {

        this.songID = songID;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
    }
    public int getSongID() {
        return songID;
    }
        public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getFilePath() {
        return filePath;
    }
}
