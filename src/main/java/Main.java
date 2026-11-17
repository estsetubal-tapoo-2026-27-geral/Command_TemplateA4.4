import command.BankAccount;
import command.Command;
import command.DepositCommand;
import command.TransactionManager;
import command.WithdrawCommand;

/** Client that creates the receiver, concrete commands and invoker. */
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John Doe", 1000.0);
        Command depositCommand = new DepositCommand(account, 500.0);
        Command withdrawCommand = new WithdrawCommand(account, 200.0);
        TransactionManager manager = new TransactionManager();

        // Execute commands and show the history.
        manager.executeCommand(depositCommand);
        manager.executeCommand(withdrawCommand);
        System.out.println(manager.showTransactionHistory());
        System.out.println("Balance: " + account.getBalance());

        // Undo the last command and show the updated history.
        manager.undo();
        System.out.println(manager.showTransactionHistory());
        System.out.println("Balance after undo: " + account.getBalance());

        // TODO (activity 2): demonstrate the transfer requirements from the README.
    }
}
