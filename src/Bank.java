import java.util.Scanner;

public class Bank {

    public static Scanner scanner = new Scanner(System.in);
    public static Scanner scannerFunction = new Scanner(System.in);
    public static Member member = new Member();
    public static Function function = new Function();


    public static void main(String[] args) throws Exception {

        while (true) {
            //Meant to run each method in the member class
            Print.print("Welcome money needing human!");
            member.chooseName();
            member.acceptAccount();
            function.chooseSelection();
            while (! Function.getSelection().equalsIgnoreCase("3")){
                function.chooseSelection();
            }
        }
    }
}