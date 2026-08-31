/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import views.SongView;
import Businesslogic.SongLogic;
import java.io.IOException;
import java.util.LinkedList;
import Models.Song;

public class SongControllers {
    
    private SongView songView;
    private SongLogic songLogic;
    
    public SongControllers () {
        songView = new SongView();
        songLogic = new SongLogic();
    }
    
    public void createSong() throws IOException{
        String title = songView.getTitle();
        String artist = songView.getArtist();
        String genre = songView.getGenre();
        int duration = songView.getDuration();
        String filePath = songView.getFilePath();

        songLogic.createSong(
            title,
            artist,
            genre,
            duration,
            filePath
        );
    }
    public void showAllSongs() throws IOException{
        LinkedList<Song> songs = songLogic.getAllSongs();
        
        for (Song song : songs){
            System.out.println(
            song.getSongID() + "|" +
            song.getTitle() + "|"  +
            song.getArtist() + "|" +
            song.getGenre() + "|" +
            song.getDuration() + "|" +
            song.getFilePath()
            );
        }
    }
}
