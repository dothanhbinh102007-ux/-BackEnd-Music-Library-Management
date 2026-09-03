/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SystemAlgorithm;

import Models.Song;
import java.util.LinkedList;

public class SongSearchByAlbum {
    public LinkedList<Song> search(LinkedList<Song> allSongs, String Album){
        
        LinkedList<Song> results = new LinkedList<>();
        
        for(Song song : allSongs){
            if(song.getAlbum().trim().equalsIgnoreCase(Album.trim())){
                results.add(song);
            }
        }
        return results;
    }
}
