package data;

import lombok.Data;

import java.util.*;

@Data
public class Issue {
    private int id;
    private int number;
    private String author;
    private String topic;
    private String assignee;
    private Set<String> tags = new HashSet<String>();
    private String text;
    private int howManyDaysAgoWasItCreated;
    private boolean close;

    public Issue(int id, int number, String author, String topic, String assignee, HashSet<String> tags, String text, int howManyDaysAgoWasItCreated, boolean close) {
        this.id = id;
        this.number = number;
        this.author = author;
        this.topic = topic;
        this.assignee = assignee;
        this.tags = tags;
        this.text = text;
        this.howManyDaysAgoWasItCreated = howManyDaysAgoWasItCreated;
        this.close = close;
    }

    public Issue() {
    }

}