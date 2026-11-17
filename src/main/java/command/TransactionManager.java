package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Invoker that executes commands and keeps the active transaction history.
 *
 * <p>Use a fresh command object for each transaction. In this example,
 * account changes go through this manager and undo follows LIFO order.</p>
 */
public class TransactionManager {
    private final List<Command> transactionHistory = new ArrayList<>();

    /** Adds the command to history only after successful execution. */
    public void executeCommand(Command command) {
        Objects.requireNonNull(command, "command");
        command.execute();
        transactionHistory.add(command);
    }

    /** Returns active transactions in execution order. */
    public String showTransactionHistory() {
        String str = "Transaction History:\n";
        for (Command command : transactionHistory) {
            // TODO (activity): use the concrete command's toString().
            str += "- " + command.getClass().getSimpleName() + "\n";
        }
        return str;
    }

    /**
     * Reverses the last active transaction. Does nothing if history is empty.
     * A failed reversal leaves the history unchanged.
     */
    public void undo() {
        if (transactionHistory.isEmpty()) return;
        int last = transactionHistory.size() - 1;
        transactionHistory.get(last).unExecute();
        transactionHistory.remove(last);
    }
}
