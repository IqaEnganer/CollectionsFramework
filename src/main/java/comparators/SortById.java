package comparators;

import data.Issue;

import java.util.Comparator;

public class SortById implements Comparator<Issue> {
    public int compare(Issue o1, Issue o2) {
        return o1.getId() - o2.getId();
    }
}

