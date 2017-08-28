package com.epam.zakharchenya.task.model.exception;

/** Exception class, serves for signaling of bad situations during working with command layer classes.
 * @author Vadim Zakharchenya
 * @version 1.0
 */
public class CommandException extends Exception {

    public CommandException() {
    }

    public CommandException(String s) {
        super(s);
    }

    public CommandException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CommandException(Throwable throwable) {
        super(throwable);
    }
}
