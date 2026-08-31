/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Businesslogic;

import Store.SongStore;
import Models.Song;
import java.io.IOException;
import java.util.LinkedList;

public class SongLogic {
    private SongStore songStore;
    
    public SongLogic(){
        songStore = new SongStore();
    }
    public void createSong(String title, String artist,
                           String genre, int duration,
                           String filePath) throws IOException{
    try {

        int songID = songStore.getNextID();

        Song song = new Song(
            songID,
            title,
            artist,
            genre,
            duration,
            filePath
        );

        songStore.saveFile(song);

        } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
        }
    }
    public LinkedList<Song> getAllSongs() throws IOException{
        return songStore.getAllSongs();
    }
    
}
