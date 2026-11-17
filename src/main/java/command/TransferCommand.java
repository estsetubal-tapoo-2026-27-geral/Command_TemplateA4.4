package command;

/**
 * Activity skeleton: transfer an amount between two account receivers.
 *
 * <p>After replacing Command with an abstract class, update this declaration
 * to extend it. Complete this class in activity step 7.</p>
 */
public class TransferCommand implements Command {
    private final BankAccount source;
    private final BankAccount destination;
    private final double amount;

    public TransferCommand(BankAccount source, BankAccount destination, double amount) {
        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }

    @Override
    public void execute() {
        // TODO (activity): validate both receivers and the amount.
        // TODO (activity): perform the transfer without partial balance changes.
        // TODO (activity): record the execution date after success.
        throw new UnsupportedOperationException("TODO: implement transfer execution");
    }

    @Override
    public void unExecute() {
        // TODO (activity): reverse the transfer without partial balance changes.
        // TODO (activity): preserve the original execution date.
        throw new UnsupportedOperationException("TODO: implement transfer undo");
    }

    // TODO (activity): override toString() with both holders, amount and date.
}
