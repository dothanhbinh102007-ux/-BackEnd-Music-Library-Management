 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


public class User {
    private int userID;
    private String username;
    private String password;
    
    public User(int userID,String username, String password){
        this.userID = userID;
        this.username = username;
        this.password = password;
    }
    
    public int getUserID(){
        return userID;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
