package command;

/**
 * Defines an operation that can be executed and reversed.
 *
 * <p>Activity: replace this interface with an abstract class and store
 * the execution date in a shared field. Keep both operation names.</p>
 */
public interface Command {
    /** Executes the operation. */
    void execute();

    /** Reverses the operation after a successful execution. */
    void unExecute();
}
