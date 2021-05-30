package at.ac.fhcampuswien;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {



    /*
    password 8-25 Chars
    Uppercase/Lowercase needed
    Numbers needed
    ()#$?!%/@ needed
    cant have other special symbols
     */


    @Test
    public void checkLengthTest(){
        myPassword password = new myPassword("validLengthPassword");
        boolean actual = password.checkPasswordLength();
        assertTrue(actual);
    }
}
