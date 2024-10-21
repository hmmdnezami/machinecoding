package org.example.stackOverflow.model;

import java.util.List;

public class Post {

    private String name ;
    private String userName;
    private String descriptions ;
    private List<Tag> tagList ;
    private List<Answer> answerList;
    private List<Comments> commentsList;
    private int upvote ;
    private int downvote;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Post(String name, String userName, String descriptions, List<Tag> tagList) {
        this.name = name;
        this.userName = userName;
        this.descriptions = descriptions;
        this.tagList = tagList;
        this.upvote = 0 ;
        this.downvote = 0 ;
    }

    public void addAnswerOnPost(Answer answer) {
        this.answerList.add(answer) ;
    }

    public void addCommentsOnPost(Comments comments) {
        this.commentsList.add(comments) ;
    }

    public void upVoteOrDownVote(int num) {
        if (num < 0) this.downvote ++ ;
        else this.upvote ++ ;
    }

}
