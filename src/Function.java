/**
 * Created by Brittany on 4/1/16.
 */
public class Function {

    private static String selection;
    private static double withdraw;
    public double amount;

    public static double getWithdraw(){
        return withdraw;
    }

    public static String getSelection() {
        return selection;
    }

    public void Function(){

    }

    //scannerFunction

    /*
    chooseSelection is designed to ask the person what they would like to do (Check balance, withdraw funds,
    cancel or add an account. Based on what they select, it takes them to that screen and when they are done with that
    screen they will return back to the selection menu until they choose to cancel.
     */
    public void chooseSelection() {

            Print.print("What would you like to do? Select 1, 2, 3, 4 or 5. " +
                    "[1 Check Balance/2 Withdraw Funds/3 Cancel/4 Add Account/5 Deposit]");
            this.selection = Print.scannerFunction.nextLine();

        if (selection.equalsIgnoreCase("1")) {
            Print.print("Please tell me the name of the account you want to check.");
            String account = Print.scannerFunction.nextLine();
            Print.print("Ok great, let me check your account.");
            Print.print( Member.sums.get(account).toString() );

        } else if (selection.equalsIgnoreCase("2")) {
            Print.print("Please enter the name of the account you want to withdraw from");
            String account = Print.scannerFunction.nextLine();
            Print.print("How much money would you like to withdraw from " + account);
            double withdraw = Print.scanner.nextDouble();
            double amount = ( Member.sums.get(account) );
            double remaining = amount - withdraw;
            Member.sums.replace(account, amount, remaining);

            if (withdraw > 100) {
                Print.print("Invalid amount, exceeds ATM maximum limit. Please enter new amount");
            } else if (withdraw < 0) {
                Print.print("Invalid amount, less than ATM minimum. Please enter new amount");
            } else {
                Print.print("Thank you, please take your money");
            }

        } else if (selection.equalsIgnoreCase("3")) {
            Print.print("Thank you, please come again");

        } else if (selection.equalsIgnoreCase("4")) {
            Print.print("Please select one of the following [Checking/Savings]");
            String accountType = Print.scannerFunction.nextLine();

            if (accountType.equalsIgnoreCase("Checking")) {
                Print.print("Please enter the name of the account as follows NameC");
                String account = Print.scannerFunction.nextLine();
                Print.print("Please enter the amount that will be in this account.");
                double amount = Print.scanner.nextDouble();
                Member.sums.put(account, amount);
                Print.print("Great we added that account for you!");

            } else if (accountType.equalsIgnoreCase("Savings")) {
                Print.print("Please enter the name of the account as follows NameS");
                String account = Print.scannerFunction.nextLine();
                Print.print("Please enter the amount that will be putting in the account");
                double amount = Print.scanner.nextDouble();
                Member.sums.put(account, amount);
                Print.print("Great we added that account for you!!");
            }

        } else if (selection.equalsIgnoreCase("5")) {
            Print.print("Please enter the name of the account you would like to make a deposit to");
            String account = Print.scannerFunction.nextLine();
            Print.print("Please enter amount you want to deposit into " + account);
            double amount = Member.sums.get(account);
            double deposit = Print.scanner.nextDouble() + amount;
            Member.sums.replace(account, amount, deposit);
        }
    }
}
