package at.ac.fhcampuswien;

public class myPassword {
    private String password;

    public myPassword(String password){
        this.password = password;
    }

    public boolean checkPasswordLength(){
        return password.length() > 8 && 25 > password.length();
    }
}
