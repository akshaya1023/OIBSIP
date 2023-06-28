import java.util.Scanner;

class UserBankAccount {
    private String name;
    private String userName;
    private String password;
    private String accountNo;
    private float balance = 100000f;
    private int transactions = 0;
    private String transactionHistory = "";

    public String getName() {
        return name;
    }

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name: ");
        this.name = sc.nextLine();
        System.out.print("Enter Your Username: ");
        this.userName = sc.nextLine();
        System.out.print("Enter Your Password: ");
        this.password = sc.nextLine();
        System.out.print("Enter Your Account Number: ");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration completed. Kindly login.");
    }

    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.print("\nEnter Your Username"+" "+name+":");
            String username = sc.nextLine();
            if (username.equals(userName)) {
                while (!isLogin) {
                    System.out.print("Enter Your Password: ");
                    String password = sc.nextLine();
                    if (password.equals(this.password)) {
                        System.out.println("\nLogin successful!");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect Password.");
                    }
                }
            } else {
                System.out.println("\nUsername not found.");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter amount to withdraw: ");
        float amount = sc.nextFloat();
        if (balance >= amount) {
            transactions++;
            balance -= amount;
            System.out.println("\nWithdrawal Successful.");
            String str = amount + " Rs Withdrawn\n";
            transactionHistory = transactionHistory.concat(str);
        } else {
            System.out.println("\nInsufficient Balance.");
        }
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter amount to deposit: ");
        float amount = sc.nextFloat();
        if (amount <= 100000f) {
            transactions++;
            balance += amount;
            System.out.println("\nDeposit Successful.");
            String str = amount + " Rs Deposited\n";
            transactionHistory = transactionHistory.concat(str);
        } else {
            System.out.println("\nSorry, the deposit limit is 100000.00.");
        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter recipient's name: ");
        String recipient = sc.nextLine();
        System.out.print("Enter amount to transfer: ");
        float amount = sc.nextFloat();
        if (balance >= amount) {
            if (amount <= 50000f) {
                transactions++;
                balance -= amount;
                System.out.println("\nSuccessfully Transferred to " + recipient);
                String str = amount + " Rs transferred to " + recipient + "\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nSorry, the transfer limit is 50000.00.");
            }
        } else {
            System.out.println("\nInsufficient Balance.");
        }
    }

    public void checkBalance() {
        System.out.println("\nBalance: " + balance + " Rs");
    }

    public void transHistory() {
        if (transactions == 0) {
            System.out.println("\nEmpty Transaction History.");
        } else {
            System.out.println("\nTransaction History:\n" + transactionHistory);
        }
    }
}

public class Atm_Interface {
    private static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && (input > limit || input < 1)) {
                    System.out.println("Choose a number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter an integer value only.");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\n....................! WELCOME TO SBI(State Bank of India) ATM SYSTEM ..............  :)\n");
        System.out.println("1. Register");
        System.out.println("2. Quit");
        System.out.print("Enter Your Choice: ");
        int choice = takeIntegerInput(2);

        if (choice == 1) {
            UserBankAccount b = new UserBankAccount();
            b.register();
            while (true) {
                System.out.println("\n1. Login");
                System.out.println("2. Quit");
                System.out.print("Enter Your Choice: ");
                int ch = takeIntegerInput(2);
                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("\n\n....................! WELCOME BACK " + b.getName() + " .................... :)\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1. Withdraw");
                            System.out.println("2. Deposit");
                            System.out.println("3. Transfer");
                            System.out.println("4. Check Balance");
                            System.out.println("5. Transaction History");
                            System.out.println("6. Quit");
                            System.out.print("\nEnter Your Choice: ");
                            int c = takeIntegerInput(6);
                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
