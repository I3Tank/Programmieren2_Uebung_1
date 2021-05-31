package at.ac.fhcampuswien;

import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Password has valid length.")
    public void checkLengthTest(){
        myPassword password = new myPassword("validLengthPassword");
        boolean actual = password.checkPasswordLength();
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password has minimum of one lowercase and one uppercase letter.")
    public void checkUpperLowerTest(){
        myPassword password = new myPassword("ValidUpperLowerPassword");
        boolean actual = password.checkUpperLower();
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password has minimum of one number.")
    public void checkNumberTest_singleNumber(){
        myPassword password = new myPassword("ValidNumberPassword1");
        boolean actual = password.checkNumber();
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password has minimum of one special Symbol.")
    public void specialSymbolsNeededTest(){
        myPassword password = new myPassword("ValidSymbolsPassword$");
        boolean actual = password.checkSymbolsNeeded();
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password has no invalid symbols.")
    public void checkNoOtherSymbolsTest(){
        myPassword password = new myPassword("ValidSymbolsPassword$!");
        boolean actual = password.checkNoOtherSymbols();
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password has no more than 2 ascending numbers in a row.")
    public void checkAscendingNumbersTest(){
        myPassword password = new myPassword("ValidAscendPassword1245");
        boolean actual = password.checkAscendingNumbers();
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password has no more than 4 of the same number in a row.")
    public void checkChainOfNumbersTest(){
        myPassword password = new myPassword("ValidChainPassword111");
        boolean actual = password.checkChainOfNumbers();
        assertTrue(actual);
    }
}
