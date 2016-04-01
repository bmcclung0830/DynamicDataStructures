import java.util.HashMap;

/**
 * Created by Brittany on 3/31/16.
 */
public class Member {
    private static String name;
    private String selection;
    static HashMap<String, Double> sums = new HashMap<>();


    public Member() {

    }

    public Member(String name, String selection, int amount, HashMap sums) {
        this.name = name;
        this.selection = selection;



            sums.put("BrittanyC", 934.00);
            sums.put("BrittanyS", 1987.00);
            sums.put("BrianC", 7.00);
            sums.put("BrianS", 900.00);

    }


    // chooseName is designed to accept account name
    public void chooseName() throws Exception {
        Bank.print("What is your name?");
        this.name = Bank.scanner.nextLine();

        if (name.length() >= 1) {
            System.out.println("WELCOME!!!!" + name);
        } else {
            throw new Exception("Please enter your name");
        }
    }

    public void chooseSelection() throws Exception {
        Bank.print("What would you like to do? [Check Balance/Withdraw Funds/Cancel/Add Account]");
        this.selection = Bank.scanner.nextLine();

        if (selection.equalsIgnoreCase("Check Balance")) {
            Bank.print("Your balance is $100");
        } else if (selection.equalsIgnoreCase("Cancel")) {
            Bank.print("Thank you, please come again");
        } else if (selection.equalsIgnoreCase("Withdraw Funds")) {
            Bank.print("How much money would you like to withdraw?");
            int withdraw = Bank.scanner.nextInt();

            if (withdraw > 100) {
                throw new Exception("Invalid amount, exceeds ATM maximum limit. Please enter new amount");
            } else if (withdraw < 0) {
                throw new Exception("Invalid amount, less than ATM minimum. Please enter new amount");
            } else {
                Bank.print("Thank you, please take your money");
            }
        } else if (selection.equalsIgnoreCase("Add Account")) {
            Bank.print("Please select type of account you would like to enter [Checking/Savings]");
            String account = Bank.scanner.nextLine();

            if (account.equalsIgnoreCase("Checking")) {
                Bank.print("Checking added");
            } else if (account.equalsIgnoreCase("Savings")) {
                Bank.print("Savings added");
            }

        }

        if (selection.equalsIgnoreCase("Cancel"));

    }

    // I want this method to accept the members name and see if their account is stored on this ATM
    // 1. prompt and accept account name
    // 2. check the hashMap for the account name
    // 3. if its not in the hashMap then it needs to be added
    public void acceptName() {
        Bank.print("Please enter the name of the account you are trying to access.");
        String account = Bank.scanner.nextLine();

        // need to know what type of value whether empty or stored account sum
        // if account is not in the hashMap then it needs to be added
        // if its already there it needs to continue as normal
        if (sums.containsKey(account) ) {
            Bank.print("Great we already have all of your account information! Please follow next steps.");
        }
        else {
            Bank.print("What is the total amount of currency in this account?");
            double amount = Bank.scanner.nextDouble();
            sums.put(account, amount);

        }
    }

    public String getSelection() {
        return selection;
    }

}
