package org.example.stackOverflow.service;

import org.example.stackOverflow.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class stackOverFlowService {

    private HashMap<String, User> users ; // for storing all users
    private HashMap<String, Post> posts ; // for storing all posts
    private HashMap<String , Answer> answers ;
    private HashMap<Tag, List<String>> postBasedOnTags;

    stackOverFlowService() {
        users = new HashMap<>() ;
        posts = new HashMap<>() ;
        answers = new HashMap<>() ;
        postBasedOnTags = new HashMap<>() ;
    }

    // onboard users
    public String onboardUsers(String name) {
        users.put(name, new User(name)) ;
        return "user onboarded successfully !!" ;
    }

    // for posting any questions on platform
    public String createPostByUser(String postName, String userName, String descriptions, List<Tag> tagList) {
        if (!users.containsKey(userName)) return "please log in first" ;
        posts.put(postName, new Post(postName, userName, descriptions, tagList)) ;
        for (Tag tag : tagList) {
            if (!postBasedOnTags.containsKey(tag)) postBasedOnTags.put(tag, new ArrayList<>());
            postBasedOnTags.get(tag).add(postName);
        }
        return "post added successfully" ;
    }

    // for adding answer on the post
    public String addingAnswerOnPost(String description, String userName, String postName) {
        if (!users.containsKey(userName)) return "please log in first" ;
        if (!posts.containsKey(postName)) return "post not available " ;
        posts.get(postName).addAnswerOnPost(new Answer(description, userName, postName));
        return "answer added successfully.. " ;
    }

    // for adding comment on posts or on answers
    public String addingCommentsOnPostOrAnswer(String comments, String userName, String postName, String answerName) {
        if (!users.containsKey(userName)) return "please log in first" ;

        if (postName.length() == 0 ) {
            if (!answers.containsKey(answerName)) return "no answer available" ;
            answers.get(answerName).addCommentsOnAnswer(new Comments(comments , userName, postName, answerName));
        }

        return "comment added successfully";
    }

    public void upVoteOrDownOnPost(String postName, int num) {
        if (!posts.containsKey(postName)) return ;
        posts.get(postName).upVoteOrDownVote(num) ;
    }



}
