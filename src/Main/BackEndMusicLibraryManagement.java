/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;
import java.io.IOException;
import controllers.SongControllers;

public class BackEndMusicLibraryManagement {


    public static void main(String[] args) throws IOException{        

        SongControllers songController = new SongControllers();


        songController.songSortByArtist();

    }
}
