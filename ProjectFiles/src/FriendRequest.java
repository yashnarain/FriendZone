/**
 * The requests are used to view sent and received friend requests.
 *
 * <p>Team 20-1 Project 5 -- CS18000 -- Fall 2020</p>
 *
 * @author Group 20-1
 * @version December 6, 2020
 */

public class FriendRequest {
    private User userFrom;
    private User userTo;
    private String status;
    private int acceptOrReject;  //true if accepted, false if rejected

    /**
     * Constructor to initialize the values
     */
    public FriendRequest(User userFrom, User userTo) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.status = "pending";
        this.acceptOrReject = -1;
    }
    /**
     * Returns the user who sent the request
     */
    public User getUserFrom() {
        return userFrom;
    }

    /**
     * Returns the user who received the request
     */
    public User getUserTo() {
        return userTo;
    }

    /**
     * Sets the status of the request – Pending, Accepted, Rejected
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the status of the request – Pending, Accepted, Rejected
     */
    public int getAcceptOrReject() {
        return acceptOrReject;
    }

    /**
     * Changes the status and the acceptOrReject value to 1
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Changes the status and the acceptOrReject value to 1
     */
    public void accept() {
        this.acceptOrReject = 1;
        this.setStatus("Complete");
    }

    /**
     * Changes the status and the acceptOrReject value to 0
     */
    public void reject() {
        this.acceptOrReject = 0;
        this.setStatus("Completed");
    }
}
