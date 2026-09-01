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
            System.out.println("Khong tim thay ten nhac nao nhu vay.");
        }
        
        for(Song song : results){
        System.out.println(
            song.getSongID() + " | " +
            song.getTitle() + " | " +
            song.getArtist() + " | " +
            song.getGenre() + " | " +
            song.getDuration() + " | " +
            song.getFilePath()
        );
        }
    }
}
