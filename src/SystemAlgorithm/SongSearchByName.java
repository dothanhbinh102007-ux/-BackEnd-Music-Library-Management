/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SystemAlgorithm;

import Models.Song;
import java.util.LinkedList;

public class SongSearchByName {
    
    public LinkedList<Song> search(LinkedList<Song> allSongs, String titleKeyWord){ // so sanh linear search (giua ten duoc chon voi nhung Title giong voi ten)
        
        LinkedList<Song> results = new LinkedList<>();
        
        for (Song song : allSongs){
            if (song.getTitle().toLowerCase().contains(titleKeyWord.toLowerCase())){ // dung de so sanh khong phan biet hoa thuong
                results.add(song);
            }
        }
        return results;
    }
}
