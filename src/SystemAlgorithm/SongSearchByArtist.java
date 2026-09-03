/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SystemAlgorithm;

import Models.Song;
import java.util.LinkedList;

public class SongSearchByArtist {
    public LinkedList<Song> search(LinkedList<Song> allSongs, String Artist){
        
        LinkedList<Song> results = new LinkedList<>();
        
        for(Song song : allSongs){
            if (song.getArtist().trim().toLowerCase() // trim dung de xoa khoang trong
                .contains(Artist.trim().toLowerCase())){
                results.add(song);
            }
        }
        return results;
    }
}
