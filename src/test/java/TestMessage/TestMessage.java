/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestMessage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
/**
 *
 * @author ST10503724 Lebogang Topola 
 */
public class TestMessage {
    
    public TestMessage() {
    }
    
    private static final String SENDER= "kyl_1";
    
    //Part 2 test data 
    private Message part2Msg1(){
    return new Message ("0012345678",0, SENDER, "+27718693002", "Hi Mike,can you join us for dinner tonight?");
    }
    
    private Message part2Msg2(){
    return new Message("0112345678",1,SENDER,"08575975889", "Hi Keegan,did you receive the payment?");
    }
    
    //Part 3 test data( message 4 uses 0838884567 as both it's ID and recipient, as in the brief)
    private Message msg1(){
    return new Message("1112345678",0,SENDER,"+27834557896", "Did you get the cake?");
    }
    private Message msg2(){
    return new Message("2212345678",1,SENDER,"+27838884567","Where are you? You late! I have asked you to be on time");
    }
    private Message msg3(){
    return new Message("3312345678",2,SENDER,"+278344845567","Yohoooo, I am at your gate");
    }
    private Message msg4(){
    return new Message("0838884567",3,SENDER,"0838884567","It is dinner time!");
    }
    
     private Message msg5(){
    return new Message("5512345678",4,SENDER,"+27838884567","Ok, I am leaving without you.");
    }
     
     //Fills the arrays with the Part 3 information 
     private void loadPart3Data(){
       msg1().addToArrays(Message.SENT);
       msg2().addToArrays(Message.STORED);
       msg3().addToArrays(Message.DISREGARDED);
       msg4().addToArrays(Message.SENT);
       msg5().addToArrays(Message.STORED);    
     }
     
     @BeforeEach
     void reset(){
         Message.clearAll();
     }
     //Part 2 
     @Test
     void messageLengthSuccess(){
     assertEquals("Message ready to send.", Message.checkMessageLength("Hi Mike"));
     }
     
     @Test
     void messageLengthFailure(){
         String longText="a".repeat(260);
         assertEquals("Message exceeds 250 characters by 10; please reduce the size.", Message.checkMessageLength(longText));
     }
     
     @Test
     void recipientCorrectlyFormatted(){
     assertEquals("Cell phone successfully captured.", part2Msg1().checkRecipientCell());
     }
     
     @Test 
     void recipientIncorrectlyFormatted(){
     assertEquals("Cell phone number is incorrectly formatted or does not contain an international code."+"Please correct the number and try again.",part2Msg2().checkRecipientCell());
     part2Msg2().checkRecipientCell();
     
     }
     
    @Test 
    void messageHashCorrect(){
    assertEquals("00:0:HITONIGHT",part2Msg1().createMessageHash());
    }
    
    @Test
    void messageHashesLoop(){
    Message[]message={part2Msg1(),part2Msg2()};
    String[]expected ={"00:0:HITONIGHT","HIPAYMENT"};
    for(int i=0; i< messages.length;i++){
    assertEquals(expected[i],message[i].createMessageHash());
    }
    
    }
    @Test
    void messageIDIsCreated(){
    Message generated= new Message(SENDER, "+27718693002","Hello there");
    assertTrue(generated.checkMessageID());
    assertEquals(10,generated.getMessageID().length());
    assertEquals("Message ID generated: "+ 
            generated.getMessageID());
    }
    @Test
    void sendMessageOptions(){
        assertEquals("Message successfully sent.",
                part2Msg1().sentMessage(1));
         assertEquals("Message successfully sent.",
                part2Msg1().sentMessage(2));
          assertEquals("Message successfully sent.",
                part2Msg1().sentMessage(3));
        
        
        
    }
}
    

    
