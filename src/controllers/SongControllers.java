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
        String album = songView.getAlbum();
        int duration = songView.getDuration();
        String filePath = songView.getFilePath();

        songLogic.createSong(
            title,
            artist,
            genre,
            album,
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
    public void songSearch() throws IOException{
        
        SongView songView = new SongView();
        
        String titleKeyWord = songView.getTitleKeyWord();
        
        LinkedList<Song> results = songLogic.searchSong(titleKeyWord);
        
        songView.displaySearchResults(results);
    }
    public void songUpdate() throws IOException{
        
        showAllSongs(); // hien thi toan bo nhac
        
        SongView songView = new SongView(); 
        
        int songID = songView.getIDSongForUpdate();
        
        Song song = songLogic.getSongByID(songID); 
        
        if(song == null){
            System.out.println("Khong tim thay bai hat");
            return;
        }
        System.out.println("Tim thay bai hat");
        
        String title = songView.getTitle();
        String artist = songView.getArtist();
        String genre = songView.getGenre();
        String album = songView.getAlbum();
        int duration = songView.getDuration();
        String filePath = songView.getFilePath();

        songLogic.songUpdate(
            songID,
            title,
            artist,
            genre,
            album,
            duration,
            filePath
        );
    }
    public void songDelete() throws IOException{
        
        showAllSongs();
        
        SongView songView = new SongView();
        
        int songID = songView.getIDSongForDelete();
        
        Song song = songLogic.getSongByID(songID);
        
        if(song == null){
            System.out.println("Khong tim thay bai hat");
            return;
        }
        System.out.println("Tim thay bai hat");
        
        songLogic.songDelete(song);
    }
    public void songSearchByGenre() throws IOException{
        
        SongView songView = new SongView();
        
        String genre = songView.getGenreForSearch();
        
        LinkedList<Song> results = songLogic.searchByGenre(genre);
        
        songView.displaySearchResults(results);
    }
    public void songSearchByArtist() throws IOException{
        
        SongView songView = new SongView();
        
        String artist = songView.getArtistForSearch();
        
        LinkedList<Song> results = songLogic.searchByArtist(artist);
        
        songView.displaySearchResults(results);
    }    
    public void songSearchByAlbum() throws IOException{
        
        SongView songView = new SongView();
        
        String album = songView.getAlbumForSearch();
        
        LinkedList<Song> results = songLogic.searchByAlbum(album);
        
        songView.displaySearchResults(results);
    }
}
