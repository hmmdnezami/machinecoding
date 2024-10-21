package org.example.stackOverflow.model;

import java.util.List;

public class Tag {

    private String tagName ;
    private List<String> postName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<String> getPostName() {
        return postName;
    }

    public void setPostName(List<String> postName) {
        this.postName = postName;
    }

    public Tag(String tagName, List<String> postName) {
        this.tagName = tagName;
        this.postName = postName;
    }
}
