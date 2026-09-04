/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Businesslogic;

import Models.Playlist;
import Models.Song;
import Store.PlayListStore;
import Store.SongStore;
import java.io.IOException;
import java.util.LinkedList;

public class PlayListLogic {
    private PlayListStore playlistStore;
    
    public PlayListLogic(){
        this.playlistStore = new PlayListStore();
    }
    public void createPlayList(String playlistName) throws IOException{
        
        int playlistID = playlistStore.getNextID();
        
        Playlist playlist = new Playlist(playlistID, playlistName);
        
        playlistStore.saveFile(playlist);
    }
    public void addSongToPlayList(Playlist playlist, int songID) throws IOException{
        
        SongStore songStore = new SongStore();
        
        LinkedList<Song> allSongs = songStore.getAllSongs();
        
        for(Song song : allSongs){
            if(song.getSongID() == songID){ // them vao PlayList
                playlist.addSong(song);
                break;
            }
            PlayListStore playlistStore = new PlayListStore();
            playlistStore.saveFile(playlist);
        }
    }
    public void displaySongInPlayList(Playlist playlist){ // hien thi lai Playlist
        
        for(Song song : playlist.getSongs()){
            System.out.println(song.getSongID() + "|" +
                               song.getTitle() + "|" +
                                song.getArtist());
        }
    }
}
