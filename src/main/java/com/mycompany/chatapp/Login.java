/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @ST10503724
 */
public class Login {

private String username;
private String password; 
private String phoneNumber;

//User details
public Login(String username,String password, String phoneNumber){
this.username= username;
this.password= password;
this.phoneNumber= phoneNumber;

}

//Username contains an underscore and is no more  than 5 charaters long.

public boolean checkUserName(){
    return username.contains("_")&& username.length() <=5;
    
}

//Password restriction complexity 
public boolean passwordComplexity(){
return password.length()>= 8&&
        password.matches(".*[A-Z].*")&&
        password.matches(".*\\d.*")&&
        password.matches(".*[!@#$%^$*()_+=|<>?{}\\[\\]~-].*");
}

public boolean checkphoneNumber(){
    return phoneNumber.matches("\\+27\\d{9}$");
    
}
//Registration Unsuccessful 
public String registerUser(){
    if(!checkUserName()){
      return"Incorrect Username format, Please ensure it conintins an underscore and is no more than five character in length";
    }
    if (!passwordComplexity()){
       return "Incorrect password format: please ensure that the password contains at least eight characters, a capital letter, a number, and special character.";
    }
    if (!checkphoneNumber()){
        return "Phone number incorrect or doesn't contain international code";
    }
    return "User successfully registered";
}
//userName & password correct 
public boolean loginUser(String inputUsername,String inputPassword){
    return this.username.equals(inputUsername)&& this.password.equals(inputPassword);
}
public String returnLoginStatus(String firstName,String surname,boolean isloggedIn){
    return isLoggedIn? "Welcom" + firstName + "," + surname + "it is great to see you again" : "username or password incorrect, Please try again ";}
}
