/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Store;

import Models.User; 
import java.io.File; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.io.IOException; 
import java.io.FileWriter; 
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;

 public class UserStore {
public int getNextID() {
    int maxID = 0;

    try {
        BufferedReader reader = new BufferedReader(
            new FileReader("src/Data/User.txt")
        );

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split("\\|");

            int userID = Integer.parseInt(data[0]);

            if (userID > maxID) {
                maxID = userID;
            }
        }

        reader.close();

    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }

    return maxID + 1;
}
    
    public void createFile() throws IOException{
            Path filePath = Paths.get("src/Data/User.txt"); // Huong file toi file User.txt 
            File fileSave = filePath.toFile(); 
            System.out.println(fileSave);
        
        if (fileSave.exists()) {  // kiem tra xem file co ton tai chua, neu chua se tao 1 file moi
            System.out.println("File adrealy create"); 
        } else { fileSave.createNewFile(); 
            System.out.println("File is created"); } }
    public void saveFile(User user){ 
        try{ 
            FileWriter fileWriterUser = new FileWriter("src/Data/User.txt", true); 
            
            BufferedWriter writer;
            
            writer = new BufferedWriter(fileWriterUser); 
            
            String data = user.getUserID() + "|" + user.getUsername() + "|" + user.getPassword(); // ghi de file save

        writer.write(data);
        
        writer.newLine();
        
        writer.close(); 
            } catch (IOException e) { 
                System.out.println("error when write: " + e.getMessage());
        } 
    }
 }

