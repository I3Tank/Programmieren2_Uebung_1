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

    @Test
    public void checkUpperLowerTest(){
        myPassword password = new myPassword("ValidUpperLowerPassword");
        boolean actual = password.checkUpperLower();
        assertTrue(actual);
    }

    @Test
    public void checkNumberTest_singleNumber(){
        myPassword password = new myPassword("ValidNumberPassword1");
        boolean actual = password.checkNumber();
        assertTrue(actual);
    }
    @Test
    public void specialSymbolsNeededTest(){
        myPassword password = new myPassword("ValidSymbolsPassword$");
        boolean actual = password.checkSymbolsNeeded();
        assertTrue(actual);
    }
    @Test
    public void checkNoOtherSymbolsTest(){
        myPassword password = new myPassword("ValidSymbolsPassword$!");
        boolean actual = password.checkNoOtherSymbols();
        assertTrue(actual);
    }
    @Test
    public void checkAscendingNumbersTest(){
        myPassword password = new myPassword("ValidSymbolsPassword1245");
        boolean actual = password.checkAscendingNumbers();
        assertTrue(actual);
    }
    @Test
    public void checkChainOfNumbersTest(){
        myPassword password = new myPassword("1222111");
        boolean actual = password.checkChainOfNumbers();
        assertTrue(actual);
    }

}
