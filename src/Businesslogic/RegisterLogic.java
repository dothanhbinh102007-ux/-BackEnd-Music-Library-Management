/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Businesslogic;
import Models.User;
import Store.UserStore;

public class RegisterLogic {
    private UserStore userStore;
    public RegisterLogic(){
        userStore = new UserStore();
}
    public void Register(String username, String password){
        
        int userID = userStore.getNextID();
        
        User user = new User(userID ,username, password); // tao user
        
        userStore.saveFile(user); // de no save user
    }
}
