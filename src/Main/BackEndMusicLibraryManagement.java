/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import controllers.PlayListControllers;
import java.io.IOException;
public class BackEndMusicLibraryManagement {
        public static void main(String[] args) throws IOException {

        PlayListControllers playlistController = new PlayListControllers();

        playlistController.playlistChoice();
    }
    }
