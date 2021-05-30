package at.ac.fhcampuswien;
import java.lang.*;

public class myPassword {
    private final String password;

    public myPassword(String password){
        this.password = password;
    }

    public boolean checkPasswordLength(){
        return password.length() >= 8 && 25 >= password.length();
    }

    public boolean checkUpperLower(){
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

    public boolean checkNumber(){
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public boolean checkSymbolsNeeded(){
        for (int i = 0; i < password.length(); i++) {
            if (password.matches(".*[()#$?!%/@].*")){
                return true;
            }
        }
        return false;
    }

    public boolean checkNoOtherSymbols(){
        for (int i = 0; i < password.length(); i++) {
            if (password.matches(".*[/*^&\"{}_\\[\\]|<>,.\\\\].*")){
                return false;
            }
        }
        return true;
    }

    public boolean checkChainOfNumbers(){
        int count = 1;
        char lastChar = password.charAt(0);

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == lastChar && Character.isDigit(password.charAt(i))){
                count++;
            }
            else{
                lastChar = password.charAt(i);
                count = 1;
            }
            if(count <= 4){
                return false;
            }
        }
        return true;
    }

    public boolean checkAscendingNumbers(){
        return false;
    }
}
