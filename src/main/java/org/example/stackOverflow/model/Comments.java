package org.example.stackOverflow.model;

public class Comments {

    private String comments ;
    private String userName ;
    private String postName ;

    private String answerName ;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public Comments(String comments, String userName, String postName, String answerName) {
        this.comments = comments;
        this.userName = userName;
        this.postName = postName;
        this.answerName = answerName;
    }
}
