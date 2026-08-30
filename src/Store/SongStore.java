/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Store;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.BufferedWriter;
import Models.Song;
import java.io.BufferedReader;
import java.io.FileReader;

public class SongStore {
    
    public int getNextID() throws IOException{
    int maxID = 0;

    BufferedReader reader = new BufferedReader(
            new FileReader("src/Data/Song.txt")
    );
    String line;
    while ((line = reader.readLine()) != null) {
        
        String[] data = line.split("\\|");
        
        if (data.length == 0 || data[0].trim().isEmpty()) {
            continue;
        }

        int songID = Integer.parseInt(data[0].trim());

        
        if (songID > maxID) {
            maxID = songID;
        }
    }
    reader.close();

    return maxID + 1;
} 
    public void createFile() throws IOException{
            Path filePath = Paths.get("src/Data/Song.txt"); // Huong file toi file Song.txt 
            File fileSave = filePath.toFile(); 
            System.out.println(fileSave);
        
        if (fileSave.exists()) {  // kiem tra xem file co ton tai chua, neu chua se tao 1 file moi
            System.out.println("File adrealy create"); 
        } else { fileSave.createNewFile(); 
            System.out.println("File is created"); } 
    }
    public void saveFile(Song song){
        try {
           FileWriter fileWriter = new FileWriter("src/Data/Song.txt", true); // dung de ghi len file
           BufferedWriter writer = new BufferedWriter(fileWriter);
           
           String data = song.getSongID() + 
                        "|" + song.getTitle() + 
                        "|" + song.getArtist() +
                        "|" + song.getGenre() + 
                        "|" + song.getDuration() + 
                        "|" + song.getFilePath();
           writer.write(data);
           writer.newLine();
           writer.close();
         } catch (IOException e) {
        System.out.println("Error when write: " + e.getMessage());
        }
    }
}