/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import views.SongView;
import Businesslogic.SongLogic;
import java.io.IOException;

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
}
