/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import Models.Playlist;
import Models.Song;
import java.util.LinkedList;
import java.util.Scanner;


public class PlayListView {
    
    private Scanner createPlaylist = new Scanner(System.in);
    public String playlistCreateName(){
        System.out.println("Nhap ten cho playlist: ");
        return createPlaylist.nextLine();
    }
    
    public void showPlayList(LinkedList<Playlist> playlist){
        System.out.println("====PLAYLIST====");
        
        int index = 1;
        
        for(Playlist playlists : playlist){
            System.out.println(index + "." + playlists.getPlayListName());
            index++;
        }
        System.out.println("0.Quay lai.");
    }
    Scanner choice = new Scanner(System.in);
    
    public int getPlayListChoice(){
        System.out.println("Chon Playlist: ");
        return choice.nextInt();
    }
    public void showSong(LinkedList<Song> songs){
        System.out.println("====SONG====");
        
        for(Song song : songs){
            System.out.println(song.getSongID() + "|" + song.getTitle() + "|" +
                             song.getArtist() + "|" + song.getGenre() + "|" +
                             song.getAlbum() + "|" + song.getDuration() + "|" +
                             song.getFilePath());
        }
    }
    Scanner choiceSong = new Scanner(System.in);
    public int getSongByID(){
        System.out.println("Chon nhac(Nhap ID nhac): ");
        return choiceSong.nextInt();
    }
    Scanner choiceToDeletePlayList = new Scanner (System.in);
    public int getPlayListDeleteByID(){
        System.out.println("Chon PlayList muon xoa: ");
        return choiceToDeletePlayList.nextInt();
    }
}
