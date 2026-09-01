/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SystemAlgorithm;

import Models.Song;
import java.util.LinkedList;

public class GetSongByID {
    
    public Song search(LinkedList<Song> allSongs, int SongID){
        
        LinkedList<Song> result = new LinkedList<>(); // tim song bang ID
        
        for(Song song : allSongs){
            if(song.getSongID() == SongID){
                return song;
            }
        }
        return null;
    }
}
