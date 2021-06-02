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

    //Test with assertFalse()
    @Test
    @DisplayName("Password has valid length of 8-25 characters.")
    public void checkPasswordLengthTest(){
        MyPasswordValidator password = new MyPasswordValidator();
        boolean actual = password.checkPasswordLength("validLengthPassword");
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password has minimum of one lowercase and one uppercase letter.")
    public void checkUpperLowerTest(){
        MyPasswordValidator password = new MyPasswordValidator();
        boolean actual = password.checkUpperLower("ValidUpperLowerPassword");
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password has minimum of one number.")
    public void checkNumberTest_singleNumber(){
        MyPasswordValidator password = new MyPasswordValidator();
        boolean actual = password.checkNumber("ValidNumberPassword1");
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password has minimum of one special Symbol.")
    public void specialSymbolsNeededTest(){
        MyPasswordValidator password = new MyPasswordValidator();
        boolean actual = password.checkSymbolsNeeded("ValidSymbolsPassword$");
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password has no invalid symbols.")
    public void checkNoOtherSymbolsTest(){
        MyPasswordValidator password = new MyPasswordValidator();
        boolean actual = password.checkNoOtherSymbols("ValidSymbolsPassword$!");
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password has no more than 2 ascending numbers in a row.")
    public void checkAscendingNumbersTest(){
        MyPasswordValidator password = new MyPasswordValidator();
        boolean actual = password.checkAscendingNumbers("ValidAscendPassword1245");
        assertTrue(actual);
    }

    @Test
    @DisplayName("Password has no more than 4 of the same number in a row.")
    public void checkChainOfNumbersTest(){
        MyPasswordValidator password = new MyPasswordValidator();
        boolean actual = password.checkChainOfNumbers("ValidChainPassword111");
        assertTrue(actual);
    }
}
