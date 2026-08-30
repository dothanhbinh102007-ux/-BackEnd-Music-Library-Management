/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import java.util.Scanner;

public class RegisterView {
    
        private Scanner registerUser = new Scanner(System.in); // tao de nhap
    
        public String getUsername(){
            System.out.println("Nhap UserName: ");
            return registerUser.nextLine();
        }
        public String getPassword(){
            System.out.println("Nhap mat khau: ");
            return registerUser.nextLine();
        }
    }
