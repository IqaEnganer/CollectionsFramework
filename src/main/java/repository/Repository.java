package repository;

import data.Issue;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<Issue> issues = new ArrayList<>();

    public void add(Issue issue) {
        issues.add(issue);
    }

    public List<Issue> getAll() {
        return issues;
    }

    public void removeById(int id) {
        issues.removeIf(issue -> issue.getId() == id);
    }

    public void removeByNumber(int number) {
        issues.removeIf(issue -> issue.getNumber() == number);
    }

    public int size() {
        return issues.size();
    }

    public boolean remove(Issue issue) {
        return issues.remove(issue);
    }

    public void saveAll(List<? extends Issue> issues) {
        this.issues.addAll(issues);
    }

    public void removeAll(List<? extends Issue> issues) {
        this.issues.removeAll(issues);
    }

    public Issue[] findById(int id) {
        Issue[] result = new Issue[1];
        int i = 0;
        for (Issue issue : getAll()) {
            if (issue.getId() == id) {
                result[i] = issue;
                i++;
            }
        }
        return result;
    }


}



