/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Businesslogic;

import Store.SongStore;
import Models.Song;
import java.io.IOException;
import java.util.LinkedList;
import SystemAlgorithm.SongSearchByName;
import SystemAlgorithm.GetSongByID;

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
    public LinkedList<Song> searchSong(String titleKeyWord) throws IOException{
        
        SongStore songStore = new SongStore(); 
        
        LinkedList<Song> allSongs = songStore.getAllSongs();        
        
        SongSearchByName songSearch = new SongSearchByName();
        
        LinkedList<Song> results = songSearch.search(allSongs, titleKeyWord);
        
        return results;
    }
    public Song getSongByID(int songID) throws IOException{
        
        SongStore songStore = new SongStore();
        
        LinkedList<Song> allSongs = songStore.getAllSongs();
        
        GetSongByID getSongByID = new GetSongByID();
        
        Song song = getSongByID.search(allSongs, songID);
        
        return song;
    }
    public void songUpdate(int songID, 
                           String title, 
                           String artist, 
                           String genre, 
                           int duration,
                           String filePath) throws IOException {
        Song song = new Song(
                songID,
                title,
                artist,
                genre,
                duration,
                filePath
        );
        songStore.updateSong(song);
    }
    public void songDelete(Song deleteSong) throws IOException{
        
        songStore.deleteSong(deleteSong);
    }
}
