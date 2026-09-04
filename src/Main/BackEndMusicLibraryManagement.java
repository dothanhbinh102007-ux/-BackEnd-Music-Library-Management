/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Models.Playlist;
import Models.Song;
import Store.PlayListStore;
import java.io.IOException;
import java.util.LinkedList;


public class BackEndMusicLibraryManagement {


    public static void main(String[] args) throws IOException{      
        PlayListStore playlistStore = new PlayListStore();

        LinkedList<Playlist> playlists = playlistStore.getPlayList();

        for (Playlist playlist : playlists) {

            System.out.println("Playlist ID: " + playlist.getPlayListID());
            System.out.println("Playlist Name: " + playlist.getPlayListName());
            System.out.println("Songs:");

            for (Song song : playlist.getSongs()) {
                System.out.println(
                    song.getSongID() + " | "
                    + song.getTitle() + " | "
                    + song.getArtist()
                );
            }

            System.out.println("----------------------");
        }
    }
}
