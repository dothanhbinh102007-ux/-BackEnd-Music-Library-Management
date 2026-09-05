/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import Businesslogic.PlayListLogic;
import Models.Playlist;
import java.io.IOException;
import java.util.LinkedList;
import views.PlayListView;
import Businesslogic.SongLogic;
import Models.Song;


public class PlayListControllers {
    
    private PlayListView playlistView;
    private PlayListLogic playlistLogic;
    private SongLogic songLogic;

    public PlayListControllers () {
        playlistView = new PlayListView();
        playlistLogic = new PlayListLogic();
        songLogic = new SongLogic();
    }    
    
    public void playlistChoice() throws IOException{
        LinkedList<Playlist> playlist = playlistLogic.getPlayList();
        
        playlistView.showPlayList(playlist);
        
        int choice = playlistView.getPlayListChoice();
        
        if(choice > 0 && choice <= playlist.size()){ // lua chon khong duoc be hon 0 va khong ra ngoai Index
            Playlist selectedPlaylist = playlist.get(choice - 1);
            LinkedList<Song> song = songLogic.getAllSongs();
            playlistView.showSong(song);
            
            LinkedList<Song> songs = songLogic.getAllSongs();
        
            int choiceSong = playlistView.getSongByID();
        
            if(choiceSong > 0 && choiceSong <= songs.size()){
                Song selectedSong = songs.get(choiceSong - 1);
                playlistLogic.addSongToPlayList(selectedPlaylist, selectedSong.getSongID());
            }            
        }
    }
    public void playlistCreate() throws IOException{
        String playlistName = playlistView.playlistCreateName();
        
        playlistLogic.createPlayList(playlistName);
    }
    public void playlistDelete(int playlistID) throws IOException{
        
        LinkedList<Playlist> playlist = playlistLogic.getPlayList();
        
        playlistView.showPlayList(playlist);
        
        int playlistIDs = playlistView.getPlayListDeleteByID();
        
        Playlist deletePlayList = playlistLogic.getPlayListByID(playlistID);
        
        if(playlist == null){
            System.out.println("Khong tim thay playlist.");
            return;            
        }
        System.out.println("Tim thay playlist");
        
        playlistLogic.playlistDelete(deletePlayList);
    }
}
