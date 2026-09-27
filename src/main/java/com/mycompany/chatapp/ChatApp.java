/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

/**
 *
 * @auther ST10503724
 */
import java.util.Scanner;

public class ChatApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //This section is for registration 
        
        System.out.println("**Registration**");
        System.out.print("Enter username:");
        String username = input.nextLine();
        
        //This session is for password 
        System.out.print("Enter paswoed:");
        String password = input.nextLine();
        
       //This section is for the cellphone number 
       
       System.out.print("Enter Phone Number (+27xxxxxxxxx):");
       String phoneNumber = input.nextLine();
       
       //Login section 
       Login user = new Login(username,password,phoneNumber);
       String registrationMessage = user.registerUser();
       System.out.print(registrationMessage);
       
       //If the registration succeds then login, section 
       if ("User successfully registered.".equals(registrationMessage)){
           System.out.println("\n*** Login***");
           System.out.print("Enter Username:");
           String loginUsername = input.nextLine();
           
           //Password re-enter 
          System.out.print("Enter Password");
          String loginPassword =input.nextLine();
          Boolean isLoggedIn= user.loginUsername(loginUsername, loginPassword);
          
          //Enter First Name 
          System.out.print("Enter Password");
          String firstName =input.nextLine();
          
          //Enter Surname
          System.out.print("Enter surname : ");
          String Surname =input.nextLine();
          
          //Login message displayed 
          String loginMessage = user.returnLoginStatus(firstName, Surname, isLoggedIn);
          System.out.println(loginMessage);
          
       }
       
    }
}
