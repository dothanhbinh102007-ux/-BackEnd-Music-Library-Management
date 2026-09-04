/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Store;

import Models.Playlist;
import Models.Song;
import Store.SongStore;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


public class PlayListStore {
    public int getNextID() throws IOException{
    int maxID = 0;

    BufferedReader reader = new BufferedReader(
            new FileReader("src/Data/PlayList.txt")
    );
    String line;
    while ((line = reader.readLine()) != null) {
        
        String[] data = line.split("\\|", - 1);
        
        if (data.length == 0 || data[0].trim().isEmpty()) {
            continue;
        }

        int playlistID = Integer.parseInt(data[0].trim());

        
        if (playlistID > maxID) {
            maxID = playlistID;
        }
    }
    reader.close();

    return maxID + 1;
    }
    public void saveFile(Playlist playlist) throws IOException{
        FileWriter fileWriter = new FileWriter("src/Data/Playlist.txt", true); // dung de ghi len file
        BufferedWriter writer = new BufferedWriter(fileWriter);
        
        StringBuilder songID = new StringBuilder(); //StringBuilder dung de noi nhieu chuoi trong vong lap
        
        for(Song song : playlist.getSongs()){ // no lay cai bai trong playlist
            
            if(songID.length() > 0){
                songID.append(","); // sau moi ID cua song thi them dau ,
            }
            songID.append(song.getSongID()); // sau song ID dau tien thi them phia sau song ID tiep theo
        }
        String data = playlist.getPlayListID()
                    + "|" + playlist.getPlayListName()
                    + "|" + songID;
           writer.write(data);
           writer.newLine();
           writer.close();         
    }
    public LinkedList<Playlist> getPlayList() throws IOException{ //dung de doc lai file khi mo lai chuong trinh
        LinkedList<Playlist> playlist = new LinkedList<>();
        
        SongStore songStore = new SongStore();
        LinkedList<Song> allSongs = songStore.getAllSongs();
        
        BufferedReader readingPlayList = new BufferedReader(
        new FileReader("src/Data/PlayList.txt") // doc file
        ); 
        String lineRead; // tao 1 bien de doc file
        
        while ((lineRead = readingPlayList.readLine()) != null){
            
            if(lineRead.trim().isEmpty()){ // khi doc thi bo qua space
                continue;
            }
            
            String[] data = lineRead.split("\\|", - 1); // bo qua |
            
            int playlistID = Integer.parseInt(data[0]); // chuyen string sang int
            String playlistName = data[1];
            String songID = data[2];
            
            Playlist newPlayList = new Playlist(
            playlistID,
            playlistName
            );
            
            String playlistSongID = data[2];
            
            String[] songIDs = playlistSongID.split(",");
            
            for(String songId : songIDs){
                int id = Integer.parseInt(songId);
                
            for(Song song : allSongs){
                if(song.getSongID() == id){
                newPlayList.addSong(song);
                    }
                }
            }
            playlist.add(newPlayList);
        }
        readingPlayList.close();
        return playlist;
    }
}
