import java.util.Scanner;

public class Bank {

    public static Scanner scanner = new Scanner(System.in);
    public static Member member = new Member();

    public static void main(String[] args)  throws Exception {

        Bank.print("Welcome money needing human!");
        member.chooseName();
        member.acceptName();
        // make the prompts loop unti cancel is selected, and then return the Welcome screen
        while (!"Cancel".equalsIgnoreCase(member.getSelection())) {



            member.chooseSelection();



        }

    }

    public static void print(String anyString) {
        System.out.println(anyString);
    }
}