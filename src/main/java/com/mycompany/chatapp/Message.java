/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
package com.mycompany.chatapp;

/**
 *
 * @author ST10503724
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Message {
//Ignore static fields 
    private static int totalSent =0;
    private static final List <Message> sentMessage = new ArrayList<>();
    private static String storageFile = "message.json";
    
    private final String messageID;
    private final int messageNumber;
    private final String recipient;
    private final String text;
    private final String hash;
    
    //Random ten digit ID
    public Message(int messageNumber ,String recipient, String text){
    this(generateID(), messageNumber, recipient, text);
    
}
//Utilized by hash
Message(String fixedID, int messageNunber, String recipient, String text){
this.messageID=fixedID;
this.messageNumber =messageNumber;
this.recipient=recipient;
this.text=text;
this.hash=createMessageHash();
 }
private static String generateID(){
    Random r = new Random();
    StringBuilder sb= new StringBuilder();
    for (int i = 0 ; i< 10; i++){
        sb.append(r.nextInt(10));
       
    }
    return sb.toString();   
}
//validation 
public boolean checkMessageID(){
return messageID!=null && messageID.length() <=10;

}
//ten character but test 
public String checkRecipientCell(){
if (recipient != null && recipient.matches("^\\+\\d{7,10}$")){
return "Cell phone number successfully captured.";
}
return "cell phone number is incorrectly formatted or does not contain"+ "an international code. Please correct the number and try again";
}
public static String checkMessageLength(String msg){
if (msg.length()<=250){
    return "Message ready to send";
}
return " Message exceeded 250 characters by"+ (msg.length()-250)+ ";please reduce the size.";
}
//Hash 

public String createMessageHash(){
    String[] words=text.trim().split("\\s+");
    String first=words[0].replaceAll("[^A-Za-z0-9]", "");
    String last = words[words.length-1].replaceAll("[^A-Za-z0-9]","");
    return(messageID.substring(0, 2)+":" + messageNumber +":"+first +last).toUpperCase(); 
}
//Discard & store
//option: 1= send, 2=disregard 3= store 
public String sentMessage(int choice){
    switch(choice){
        case 1: 
            totalSent++;
            sentMessage.add(this);
            return "Message successfully sent.";
        case 2:
            return"Press 0 to delete the message.";
        case 3: 
            storeMessage();
            return "Message successfully";
        default:
            return " invalid option";
            
    }
}
public static String printMessage(){
    StringBuilder sb=new StringBuilder();
    for (Message m :sentMessages){
        sb.append("Message ID:").append(m.messageID)
        .append("\nMessage Hash: ").append(m.hash);
           
    }
}

}
