/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import com.mycompany.chatapp.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ST10503724
 */
public class TestLogin {
    
    public TestLogin() {
    }
    //correct username
    @Test
    public void testCheckUsernameTue(){
    Login user = new Login("kyl_1","Ch&&sec@ke99!","+27838968976");
    assertTrue(user .checkUserName());
    }
    //Incorrect username
    @Test
    public void testCheckUsernameFalse(){
    Login user = new Login("kyl_1","Ch&&sec@ke99!","+27838968976");
    assertFalse(user .checkUserName());
    }
    
    //when password requirements are met 
    @Test
    public void testCheckPasswordComplexityTrue(){
    Login user =new Login("kyl_1","Ch&&sec@ke99!", "+27838968976");
    assertTrue(user.checkpasswordComplexity());
    }
    //when password requirements are not met
    @Test
    public void testCheckPasswordComplexityFalse(){
    Login user =new Login("kyl_1","Ch&&sec@ke99!", "+27838968976");
    assertFalse(user.checkpasswordComplexity());
    }
    //If the phone number is correct 
    @Test
    public void testCheckPhoneNumberTrue(){
     Login user =new Login("kyl_1","Ch&&sec@ke99!", "+27838968976");
    assertTrue(user.checkphoneNumber());
    }
    //If the phone number is incorrect
    @Test
    public void testCheckPhoneNumberFalse(){
    Login user =new Login("kyl_1","Ch&&sec@ke99!", "+27838968976");
    assertFalse(user.checkphoneNumber());
    }
    //Successful login
    @Test
    public void testLoginUserSuccessful(){
     Login user =new Login("kyl_1","Ch&&sec@ke99!", "+27838968976");
    assertTrue(user.loginUser("kyl_1","Ch&&sec@ke99!"));
    }
    //If user fails to login 
    @Test
    public void testLoginUserFailed(){
     Login user =new Login("kyl_1","Ch&&sec@ke99!", "+27838968976");
    assertFalse(user.loginUser("IncorrectUser","IncorectPassword!"));
    }   
    
}

