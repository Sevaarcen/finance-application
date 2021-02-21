package com.cmplxsoftsys.team3.financeapplication.payload.response;

public class MessageResponse {

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
