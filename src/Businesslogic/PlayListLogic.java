/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Businesslogic;

import Models.Playlist;
import Store.PlayListStore;
import java.io.IOException;

public class PlayListLogic {
    private PlayListStore playlistStore;
    
    public PlayListLogic(){
        this.playlistStore = new PlayListStore();
    }
    public void createPlayList(String playlistName) throws IOException{
        
        int playlistID = playlistStore.getNextID();
        
        Playlist playlist = new Playlist(playlistID, playlistName);
        
        playlistStore.saveFile(playlist);
    }
}
