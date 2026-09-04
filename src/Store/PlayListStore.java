/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Store;

import Models.Playlist;
import Models.Song;
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
    );//doc file
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
    
    public void fileUpdate(Playlist playlist) throws IOException{
        LinkedList<String> lines = new LinkedList<>();
        
            BufferedReader reader = new BufferedReader(
                new FileReader("src/Data/PlayList.txt")
                                   );
        String line;
        //doc file
        while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        reader.close();
        //tim playlist r sua cai playlist do
        for (int i = 0; i < lines.size(); i++) {
            String[] data = lines.get(i).split("\\|", -1);
        
            if (data[0].trim().isEmpty()) {
                continue;
            }   

        int playlistID = Integer.parseInt(data[0]);

        if (playlistID == playlist.getPlayListID()) {
           StringBuilder songID = new StringBuilder();

        for (Song song : playlist.getSongs()) {
            if (songID.length() > 0) {
                songID.append(",");
            }
        songID.append(song.getSongID());
                }
        String newData = playlist.getPlayListID()
            + "|" + playlist.getPlayListName()
            + "|" + songID;

        lines.set(i, newData);
            }
        }
        //dung de ghi de cai cu
        FileWriter fileWriter = new FileWriter("src/Data/PlayList.txt");
        BufferedWriter writer = new BufferedWriter(fileWriter);

        for (String data : lines) {
            writer.write(data);
            writer.newLine();
            }

        writer.close();
    }
}



