package command;

import java.util.Objects;

/** Concrete command that delegates a withdraw operation to its receiver. */
public class WithdrawCommand implements Command {
    private final BankAccount account;
    private final double amount;

    public WithdrawCommand(BankAccount account, double amount) {
        this.account = Objects.requireNonNull(account, "account");
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.withdraw(amount);
        // TODO (activity): record the execution date after a successful operation.
    }

    @Override
    public void unExecute() {
        account.deposit(amount);
    }

    // TODO (activity): implement toString() with the operation, amount and date.
}
