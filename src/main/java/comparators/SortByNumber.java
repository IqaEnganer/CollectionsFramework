package comparators;

import data.Issue;

import java.util.Comparator;

public class SortByNumber implements Comparator<Issue> {
    public int compare(Issue o1, Issue o2) {
        return o1.getNumber() - o2.getNumber();
    }
}