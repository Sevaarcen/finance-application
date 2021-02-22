package com.cmplxsoftsys.team3.financeapplication.payload.response;

/**
 * Class for the response given to a user when they perform an action. This can be a sucess or error message.
 */
public class MessageResponse {

    /**
     * Enum for various priority and types of messages being exchanged. Useful for determining how it should be displayed to the user.
     */
    public enum MESSAGE_TYPE {
        INFORMATIONAL,
        WARNING,
        ERROR
    }

    private String message;
    private MESSAGE_TYPE type;

    
    /**
     * Returns the message to display to the user about their request.
     * @return a String containing the message to display.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * This returns the type of message it is, useful for determining how to show the message.
     * @return the MESSAGE_TYPE of the message
     */
    public MESSAGE_TYPE type() {
        return this.type;
    }
}
