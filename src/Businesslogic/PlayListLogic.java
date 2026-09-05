/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Businesslogic;

import Models.Playlist;
import Models.Song;
import Store.PlayListStore;
import Store.SongStore;
import java.io.BufferedReader;
import java.io.FileReader;
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
        
        PlayListStore playlistStore = new PlayListStore();
        
        for(Song song : allSongs){
            if(song.getSongID() == songID){ // them vao PlayList
                playlist.addSong(song);
                break;
            }
        }
        playlistStore.fileUpdate(playlist);
    }
    public void displaySongInPlayList(Playlist playlist){ // hien thi lai Playlist
        
        for(Song song : playlist.getSongs()){
            System.out.println(song.getSongID() + "|" +
                               song.getTitle() + "|" +
                                song.getArtist());
        }
    }
    public LinkedList<Playlist> getPlayList() throws IOException{ //dung de doc lai file khi mo lai chuong trinh
        LinkedList<Playlist> playlist = new LinkedList<>();
        
        SongStore songStore = new SongStore();
        LinkedList<Song> allSongs = songStore.getAllSongs();
        
        BufferedReader readingPlayList = new BufferedReader(
        new FileReader("src/Data/PlayList.txt") // doc file
        ); 
        String lineRead; // tao 1 bien de doc file
        
        while ((lineRead = readingPlayList.readLine()) != null){
            
            if(lineRead.trim().isEmpty()){ // khi doc thi bo qua space
                continue;
            }
            
            String[] data = lineRead.split("\\|", - 1); // bo qua |
            
            int playlistID = Integer.parseInt(data[0]); // chuyen string sang int
            String playlistName = data[1];
            String songID = data[2];
            
            Playlist newPlayList = new Playlist(
            playlistID,
            playlistName
            );
            
            String playlistSongID = data[2];
            
            String[] songIDs = playlistSongID.split(",");
            
            for(String songId : songIDs){
                if(songId.isEmpty()){
                    System.out.println("chua co nhac");
                    continue;
                }
                int id = Integer.parseInt(songId);
                
            for(Song song : allSongs){
                if(song.getSongID() == id){
                newPlayList.addSong(song);
                    }
                }
            }
            playlist.add(newPlayList);
        }
        readingPlayList.close();
        return playlist;
    }
    public void playlistDelete(Playlist deletePlayList) throws IOException{
        playlistStore.deletePlayList(deletePlayList);
    }
    public Playlist getPlayListByID(int playlistID) throws IOException{
        
        LinkedList<Playlist> playlists = getPlayList();
        
        for(Playlist playlist : playlists){
            if(playlist.getPlayListID() == playlistID ){
                return playlist;
            }
        }
        return null;
    }
}
