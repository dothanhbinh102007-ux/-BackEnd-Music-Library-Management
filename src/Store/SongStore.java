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
import java.util.LinkedList;

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
                        "|" + song.getAlbum() +
                        "|" + song.getDuration() + 
                        "|" + song.getFilePath();
           writer.write(data);
           writer.newLine();
           writer.close();
         } catch (IOException e) {
        System.out.println("Error when write: " + e.getMessage());
        }
    }
    public LinkedList<Song> getAllSongs() throws IOException{ // dung de lay 1 lan tat ca nhac ben trong Song.txt
        LinkedList<Song> songs = new LinkedList<>();
        
        BufferedReader readingSong = new BufferedReader(
        new FileReader("src/Data/Song.txt") // doc file
        );
        String lineRead; // tao 1 bien de doc file
        
        while ((lineRead = readingSong.readLine()) != null){
            
            if(lineRead.trim().isEmpty()){ // khi doc thi bo qua space
                continue;
            }
            
            String[] data = lineRead.split("\\|", - 1); // bo qua |
            
            int songID = Integer.parseInt(data[0]); // chuyen string sang int
            String title = data[1];
            String artist = data[2];
            String genre = data[3];
            String album = data[4];
            int duration = Integer.parseInt(data[5]); // chuyen string sang int
            String filePath = data[6];
            
            Song song = new Song(
            songID,
            title,
            artist,
            genre,
            album,
            duration,
            filePath
            );
            songs.add(song); // tao 1 cho de hien thi Song
        }
        
        readingSong.close();
        
        return songs;
    }
    public void updateSong(Song updateSong) throws IOException{
        
        BufferedReader readingSong = new BufferedReader(
            new FileReader("src/Data/Song.txt") // doc file
        );
        
        LinkedList<Song> song = new LinkedList<>();
        
        String lineRead; // tao 1 bien de doc file
        
        
        while ((lineRead = readingSong.readLine()) != null){
            
            if(lineRead.trim().isEmpty()){ //Giong van GetAllSong
                continue;
            }
            
            String[] data = lineRead.split("\\|", - 1);
            
        int oldSongID = Integer.parseInt(data[0]);
        
        if(oldSongID == updateSong.getSongID()){
            song.add(updateSong);
        } else{
            String oldTitle = data[1];
            String oldArtist = data[2];
            String oldGenre = data[3];
            String oldAlbum = data[4];
            int oldDuration = Integer.parseInt(data[5]);
            String oldfilePath = data[6];
            
        Song oldSong = new Song(
                oldSongID,
                oldTitle,
                oldArtist,
                oldGenre,
                oldAlbum,
                oldDuration,
                oldfilePath
            );
        
        song.add(oldSong);
        }
        }
        readingSong.close();
        
        BufferedWriter writingSong = new BufferedWriter(
                new FileWriter("src/Data/Song.txt")
        );
        
        for(Song n : song){
            writingSong.write(
                n.getSongID() + "|" +
                n.getTitle()  + "|" +
                n.getArtist() + "|" +
                n.getGenre()  + "|" +
                n.getDuration() + "|" +
                n.getFilePath()
            );
            writingSong.newLine();
        }
        writingSong.close();
    }
    public void deleteSong(Song deleteSong) throws IOException{
        
        BufferedReader readingSong = new BufferedReader(
            new FileReader("src/Data/Song.txt") // doc file
        );
        String lineRead; // tao 1 bien de doc file
        
        StringBuilder songData = new StringBuilder();
        
        while ((lineRead = readingSong.readLine()) != null){
            
            if(lineRead.trim().isEmpty()){ //Giong van GetAllSong
                continue;
            }
            String[] data = lineRead.split("\\|", - 1);
            
            int currentID = Integer.parseInt(data[0]);
            
            if(currentID != deleteSong.getSongID()){ // neu nhu bien khac voi ID can xoa thi giu
               songData.append(lineRead).append("\n");
            } 
        }
            FileWriter writtingSong = new FileWriter("src/Data/Song.txt");
            BufferedWriter writer = new BufferedWriter(writtingSong);
             
            writer.write(songData.toString()); // du lieu moi de len file cu
            writer.close();  
            readingSong.close();
        
    }
}
        
