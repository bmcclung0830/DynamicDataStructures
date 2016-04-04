import java.util.HashMap;

/** Member class is for holding all of the information that is getting pulled
 * **/
public class Member {
    private String name;

    private double withdraw;
    public static HashMap<String, Double> sums = new HashMap<String, Double>();


    public String getChooseName(){
        return name;
    }

    public double getWithdraw(){
        return withdraw;
    }

    public Member() {

        sums.put("TristanC", 78.98);
        sums.put("TristanS", 4567.32);
        sums.put("BrittanyC", 934.00);
        sums.put("BrittanyS", 1987.00);
        sums.put("BrianC", 7890.00);
        sums.put("BrianS", 900.00);
        sums.put("RobS", 87.39);
        sums.put("RobC", 576.76);


    }

    public Member(String name, String selection) {
        this.name = name;





    }

    // chooseName is designed to get a person's name
    public void chooseName() {
        Print.print("What is your name?");
        this.name = Print.scanner.nextLine();

        if (name.length() >= 1) {
            System.out.println("WELCOME " + name + "!!!!");
        } else {
            while (getChooseName().isEmpty()) {

                Print.print("Please enter your name");
                this.name = Print.scanner.nextLine();

            }
        }
    }



    //
    public void acceptAccount() {
        Print.print("Please enter the name of the account you are trying to access.");
        String account = Print.scanner.nextLine();

        if (sums.containsKey(account) ) {
            Print.print("Great we already have all of your account information! Please follow next steps.");
        }
        else {
            Print.print("What is the total amount of currency in this account?");
            double amount = Print.scanner.nextDouble();
            sums.put(account, amount);

        }
    }


}
