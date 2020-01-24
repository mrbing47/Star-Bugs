package garg.sarthik.starbugs.POJO;

public class User {

    String userName;
    String userEmail;
    String userNumber;
    String userId;
    String userBranch;

    public User() {
    }

    public User(String userName, String userEmail, String userNumber, String userId, String userBranch) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userNumber = userNumber;
        this.userId = userId;
        this.userBranch = userBranch;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserBranch() {
        return userBranch;
    }
}
