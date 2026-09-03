/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.util.Scanner;
import Models.Song;
import java.util.LinkedList;

public class SongView {
    private Scanner createSong = new Scanner(System.in); // tao de nhap
    
        public String getTitle(){
            System.out.println("Nhap ten nhac: ");
            return createSong.nextLine();
        }
        public String getArtist(){
            System.out.println("Nhap ten nghe si: ");
            return createSong.nextLine();
        }
        public String getGenre(){
            System.out.println("Nhap the loai: ");
            return createSong.nextLine();
        }
        public String getAlbum(){
            System.out.println("Nhap ten album: ");
            return createSong.nextLine();
        }
        public int getDuration(){
            System.out.println("Nhap thoi luong: ");
            return createSong.nextInt();
        }
        public String getFilePath(){
            System.out.println("Nhap lien ket vao: ");
            return createSong.nextLine();
        }
    private Scanner songSearch = new Scanner(System.in);
    
        public String getTitleKeyWord(){
            System.out.println("Nhap ten bai hat can tim: ");
            return songSearch.nextLine();
        }
    public void displaySearchResults(LinkedList<Song> results){
        
        if(results.isEmpty()){
            System.out.println("Khong tim thay bai hat.");
        }
        
        for(Song song : results){
        System.out.println(
            song.getSongID() + " | " +
            song.getTitle() + " | " +
            song.getArtist() + " | " +
            song.getGenre()  + " | " +
            song.getAlbum() + "|" +
            song.getDuration() + " | " +
            song.getFilePath()
        );
        }
    }
    
    private Scanner IDSongForUpdate = new Scanner(System.in); 
    
    public int getIDSongForUpdate(){
        System.out.println("Hay nhap ID nhac can sua: ");
        return IDSongForUpdate.nextInt();
    }
    
    private Scanner IDSongForDelete = new Scanner(System.in);
    
    public int getIDSongForDelete(){
        System.out.println("Hay nhap ID nhac can xoa: ");
        return IDSongForDelete.nextInt();
    }
    
    private Scanner genreForSearch = new Scanner(System.in);
    
    public String getGenreForSearch(){
        System.out.println("Nhap genre can tim: ");
        return genreForSearch.nextLine();
    }
    
    private Scanner artistForSearch = new Scanner(System.in);
    
    
    public String getArtistForSearch(){
        System.out.println("Nhap ten nghe si can tim: ");
        return artistForSearch.nextLine(); 
    }
    
    private Scanner albumForSearch = new Scanner(System.in);
    
    public String getAlbumForSearch(){
        System.out.println("Nhap ten Album can tim: ");
        return albumForSearch.nextLine();
    }
    
    private Scanner songSortByDuration = new Scanner(System.in);
    
    public int getSortChoice(){
        
        System.out.println("Hay chon lua chon sap xep:");
        System.out.println("1.Xep theo tang dan.");
        System.out.println("2.Xep theo giam dan.");
        
        return songSortByDuration.nextInt();
    }
}
