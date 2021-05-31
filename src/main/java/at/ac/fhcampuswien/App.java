package at.ac.fhcampuswien;

public class App {
    public static void main (String[] args){
        MyPasswordValidator myPasswordValidator = new MyPasswordValidator();
        System.out.println(myPasswordValidator.checkPassword("IsThisVal1d?"));
    }
}
