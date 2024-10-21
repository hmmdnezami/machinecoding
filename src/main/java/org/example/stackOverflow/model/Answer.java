package org.example.stackOverflow.model;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    private String description ;
    private  String userName;
    private String postName ;
    private int upvote ;
    private int downvote ;
    private List<Comments> commentsList;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public int getDownvote() {
        return downvote;
    }

    public void setDownvote(int downvote) {
        this.downvote = downvote;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public Answer(String description, String userName, String postName) {
        this.description = description;
        this.userName = userName;
        this.postName = postName;
        this.upvote = 0 ;
        this.downvote = 0 ;
        this.commentsList = new ArrayList<>();
    }

    public void addCommentsOnAnswer(Comments comments) {
        this.commentsList.add(comments) ;
    }

}
