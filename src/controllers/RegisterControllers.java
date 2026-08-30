/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import views.RegisterView;
import Businesslogic.RegisterLogic;
        
public class RegisterControllers {
    
    private RegisterView registerView;
    private RegisterLogic registerLogic;
    
    public RegisterControllers(){
        registerView = new RegisterView();
        registerLogic = new RegisterLogic();
    }
    
    public void Register(){
        String username = registerView.getUsername();
        String password = registerView.getPassword();
        
        registerLogic.Register(username, password);
    }
}
