/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.LinkedList;

public class Playlist {
    private int playlistID;
    private String playlistName;
    LinkedList<Song> songs;
    
    public  Playlist (int playlistID, String playlistName){
        this.playlistID = playlistID;
        this.playlistName = playlistName;
        this.songs = new LinkedList<>();
    }
    
    public int getPlayListID(){
        return playlistID;
    }
    public String getPlayListName(){
        return playlistName;
    }
    public LinkedList<Song> getSongs(){
        return songs;
    }
    
    public void setPlayListName(String playlistName){
        this.playlistName = playlistName;
    }
    public void addSong(Song song){
        songs.add(song);
    }
}
