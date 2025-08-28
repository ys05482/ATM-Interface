import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Successfully deposited: ₹" + amount);
        } else {
            System.out.println("⚠️ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("💸 Successfully withdrawn: ₹" + amount);
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance. Transaction failed.");
        } else {
            System.out.println("⚠️ Invalid withdrawal amount.");
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n================== 🏦 ATM MACHINE 🏦 ==================");
            System.out.println("1️⃣  Check Balance");
            System.out.println("2️⃣  Deposit Money");
            System.out.println("3️⃣  Withdraw Money");
            System.out.println("4️⃣  Exit");
            System.out.println("=======================================================");
            System.out.print("👉 Please select an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("💰 Your current balance is: ₹" + account.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("👋 Thank you for using our ATM. Have a great day!");
                    break;
                default:
                    System.out.println("⚠️ Invalid option. Please try again.");
            }
        } while (choice != 4);
    }
}

public class atmInterface {
    public static void main(String[] args) {
        // Create bank account with initial balance
        BankAccount myAccount = new BankAccount(5000.0);

        // Connect ATM with bank account
        ATM atm = new ATM(myAccount);
        atm.start();
    }
}
