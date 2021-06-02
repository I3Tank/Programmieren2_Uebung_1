package at.ac.fhcampuswien;
import java.lang.*;

public class MyPasswordValidator {

    public boolean checkPassword(String password){
        //return true if all methods are true => password is valid
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
            //checks if char is uppercase
            if (Character.isUpperCase(password.charAt(i))){
                hasUpper = true;
            }
            //checks if char is lowercase
            if (Character.isLowerCase(password.charAt(i))){
                hasLower = true;
            }
            //only if both have been set to true once, the method returns true
            if (hasUpper && hasLower){
                return true;
            }
        }
        return false;
    }

    public boolean checkNumber(String password){
        for (int i = 0; i < password.length(); i++) {
            //returns true if there is at least one number
            if (Character.isDigit(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public boolean checkSymbolsNeeded(String password){
        //returns true if one of the symbols inside the [] appears at least once in the password
        return password.matches(".*[()#$?!%/@].*");
    }

    public boolean checkNoOtherSymbols(String password){
        //returns true if the symbols in the [] are NOT in the password
        return !password.matches(".*[/*^&\"{}_\\[\\]|<>,.\\\\].*");
    }

    public boolean checkChainOfNumbers(String password){
        //is 0 in the beginning, because first iteration is always true because it checks charAt(0) with charAt(0)
        int count = 0;
        //the char that was the previous one
        char lastChar = password.charAt(0);
        //the current char
        char charToCheck;

        for (int i = 0; i < password.length(); i++) {
            charToCheck = password.charAt(i);
            //if the char we are looking at the moment is the last char, we increase our counter
            if (charToCheck == lastChar && Character.isDigit(charToCheck)){
                count++;
            }
            //if not, we reset the counter and set the lastChar to the current one for the next iteration
            else{
                lastChar = charToCheck;
                count = 1;
            }
            //once the counter is more than 3, we return false, since 1111 is not allowed
            if(count > 3){
                return false;
            }
        }
        return true;
    }

    public boolean checkAscendingNumbers(String password){
        //like the method "checkChainOfNumbers"
        int count = 0;
        char lastChar = password.charAt(0);
        char charToCheck;

        for (int i = 0; i < password.length(); i++) {
            charToCheck = password.charAt(i);
            //the difference is, that we check, if the current char is 1 higher than the last char, we need to check if it is a digit, since abc would be true as well
            if(Character.isDigit(charToCheck) && charToCheck == lastChar + 1){
                count++;
            }
            else{
                count = 1;
            }
            //this time we always have to update the lastChar, since we need to check
            lastChar = charToCheck;
            //can't be more than 2 ascending numbers
            if(count > 2){
                return false;
            }
        }
        return true;
    }
}
