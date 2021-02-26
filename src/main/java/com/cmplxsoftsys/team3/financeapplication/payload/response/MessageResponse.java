package com.cmplxsoftsys.team3.financeapplication.payload.response;

/**
 * Class for the response given to a user when they perform an action. This can be a sucess or error message.
 */
public class MessageResponse {

    private String message;

    /**
     * Full Constructor
     *
     * @param message message to be returned in the response body
     */
    public MessageResponse(String message) {
        this.message = message;
    }

    /**
     * Returns the message to display to the user about their request.
     *
     * @return a String containing the message to display.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message to be displayed
     *
     * @param message a String containing a message
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
