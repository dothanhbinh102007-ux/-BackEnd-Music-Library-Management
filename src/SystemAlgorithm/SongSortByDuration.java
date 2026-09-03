/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SystemAlgorithm;

import Models.Song;
import java.util.LinkedList;


public class SongSortByDuration {
    public LinkedList<Song> sort(LinkedList<Song> allSongs, int choice){
        
        LinkedList<Song> results = new LinkedList<>(allSongs);
        
        for (int i = 0; i < results.size() - 1; i++){
            for (int j = 0; j < results.size() - i -1; j++){
                
              if(choice == 1){
                  if(results.get(j).getDuration() > results.get(j + 1).getDuration()){
                      
                    Song temp = results.get(j);
                    results.set(j, results.get(j + 1));
                    results.set(j + 1, temp);                      
                  }
              }
              else if(choice == 2){
                  if(results.get(j).getDuration() < results.get(j + 1).getDuration()){
                      
                    Song temp = results.get(j);
                    results.set(j, results.get(j + 1));
                    results.set(j + 1, temp);                      
                  }                  
              }
            }
        }   
        return results;
    }
}
