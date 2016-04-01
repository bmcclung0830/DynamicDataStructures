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

            Bank.print("What would you like to do? Select 1, 2, 3, 4 or 5. " +
                    "[1 Check Balance/2 Withdraw Funds/3 Cancel/4 Add Account/5 Deposit]");
            this.selection = Bank.scannerFunction.nextLine();

        if (selection.equalsIgnoreCase("1")) {
            Bank.print("Please tell me the name of the account you want to check.");
            String account = Bank.scannerFunction.nextLine();
            Bank.print("Ok great, let me check your account.");
            Bank.print( Member.sums.get(account).toString() );

        } else if (selection.equalsIgnoreCase("2")) {
            Bank.print("Please enter the name of the account you want to withdraw from");
            String account = Bank.scannerFunction.nextLine();
            Bank.print("How much money would you like to withdraw from " + account);
            double withdraw = Bank.scanner.nextDouble();
            double amount = ( Member.sums.get(account) );
            double remaining = amount - withdraw;
            Member.sums.replace(account, amount, remaining);

            if (withdraw > 100) {
                Bank.print("Invalid amount, exceeds ATM maximum limit. Please enter new amount");
            } else if (withdraw < 0) {
                Bank.print("Invalid amount, less than ATM minimum. Please enter new amount");
            } else {
                Bank.print("Thank you, please take your money");
            }

        } else if (selection.equalsIgnoreCase("3")) {
            Bank.print("Thank you, please come again");

        } else if (selection.equalsIgnoreCase("4")) {
            Bank.print("Please select one of the following [Checking/Savings]");
            String accountType = Bank.scannerFunction.nextLine();

            if (accountType.equalsIgnoreCase("Checking")) {
                Bank.print("Please enter the name of the account as follows NameC");
                String account = Bank.scannerFunction.nextLine();
                Bank.print("Please enter the amount that will be in this account.");
                double amount = Bank.scanner.nextDouble();
                Member.sums.put(account, amount);
                Bank.print("Great we added that account for you!");

            } else if (accountType.equalsIgnoreCase("Savings")) {
                Bank.print("Please enter the name of the account as follows NameS");
                String account = Bank.scannerFunction.nextLine();
                Bank.print("Please enter the amount that will be putting in the account");
                double amount = Bank.scanner.nextDouble();
                Member.sums.put(account, amount);
                Bank.print("Great we added that account for you!!");
            }

        } else if (selection.equalsIgnoreCase("5")) {
            Bank.print("Please enter the name of the account you would like to make a deposit to");
            String account = Bank.scannerFunction.nextLine();
            Bank.print("Please enter amount you want to deposit into " + account);
            double deposit = Bank.scanner.nextDouble() + Member.sums.get(account);
            Member.sums.replace(account, amount, deposit);
        }
    }
}
