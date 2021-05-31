package at.ac.fhcampuswien;
import java.lang.*;

public class MyPasswordValidator {

    //Da gibt's doch sicher eine bessere Lösung dazu oder? ^^'
    public boolean checkPassword(String password){
        return checkPasswordLength(password)
                && checkUpperLower(password)
                && checkNumber(password)
                && checkSymbolsNeeded(password)
                && checkNoOtherSymbols(password)
                && checkChainOfNumbers(password)
                && checkAscendingNumbers(password);
    }

    public boolean checkPasswordLength(String password){
        return password.length() >= 8 && 25 >= password.length();
    }

    public boolean checkUpperLower(String password){
        boolean hasUpper = false;
        boolean hasLower = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))){
                hasUpper = true;
            }
            if (Character.isLowerCase(password.charAt(i))){
                hasLower = true;
            }
            if (hasUpper && hasLower){
                return true;
            }
        }
        return false;
    }

    public boolean checkNumber(String password){
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public boolean checkSymbolsNeeded(String password){
        for (int i = 0; i < password.length(); i++) {
            if (password.matches(".*[()#$?!%/@].*")){
                return true;
            }
        }
        return false;
    }

    public boolean checkNoOtherSymbols(String password){
        for (int i = 0; i < password.length(); i++) {
            if (password.matches(".*[/*^&\"{}_\\[\\]|<>,.\\\\].*")){
                return false;
            }
        }
        return true;
    }

    public boolean checkChainOfNumbers(String password){
        int count = 0;
        char lastChar = password.charAt(0);
        char charToCheck;

        for (int i = 0; i < password.length(); i++) {
            charToCheck = password.charAt(i);

            if (charToCheck == lastChar && Character.isDigit(charToCheck)){
                count++;
            }
            else{
                lastChar = charToCheck;
                count = 1;
            }
            if(count >= 4){
                return false;
            }
        }
        return true;
    }

    public boolean checkAscendingNumbers(String password){
        int count = 0;
        char lastChar = password.charAt(0);
        char charToCheck;

        for (int i = 0; i < password.length(); i++) {
            charToCheck = password.charAt(i);
            if(Character.isDigit(charToCheck) && charToCheck == lastChar + 1){
                count++;
            }
            else{
                count = 1;
            }
            lastChar = charToCheck;

            if(count >= 3){
                return false;
            }
        }
        return true;
    }
}
