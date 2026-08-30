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

public class SongStore {
    
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
         } catch (IOException e) {
        System.out.println("Error when write: " + e.getMessage());
        }
    }
}