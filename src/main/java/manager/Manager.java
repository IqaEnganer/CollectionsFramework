package manager;

import data.Issue;
import repository.Repository;

import java.util.*;

public class Manager {


    public Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public Issue[] getAll() {
        return repository.getAll().toArray(new Issue[0]);
    }

    public void save(Issue issue) {
        repository.add(issue);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeByNumber(int number) {
        repository.removeByNumber(number);
    }

    public void removeAll(List<Issue> issues) {
        repository.removeAll(issues);
    }

    public void saveAll(List<Issue> issues) {
        repository.saveAll(issues);
    }

    // Поиск по Id
    public Issue[] searchById(int id) {
        return repository.findById(id);
    }


    //Фильтр по открытому Issue
    public Issue[] searchOpenIssues(Comparator<Issue> comparator) {
        Issue[] result = new Issue[0];
        for (Issue issue : repository.getAll()) {
            if (matchesOpen(issue)) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    public boolean matchesOpen(Issue issue) {
        if (issue.isClose()) {
            return true;
        }
        return false;
    }

    //Фильтр по закрытому Issue
    public Issue[] searchCloseIssues(Comparator<Issue> comparator) {
        Issue[] result = new Issue[0];
        for (Issue issue : repository.getAll()) {
            if (matchesClose(issue)) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }


    public boolean matchesClose(Issue issue) {
        if (issue.isClose() == true) {
            return true;
        }
        return false;
    }

    // Фильтр по назначенному на Issue
    public Issue[] searchByAssignee(String assignee, Comparator<Issue> comparator) {
        Issue[] result = new Issue[0];
        for (Issue issue : repository.getAll()) {
            if (matchesAssignee(issue, assignee)) {
                Issue[] tmp = new Issue[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issue;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    public boolean matchesAssignee(Issue issue, String assignee) {
        if (issue.getAssignee().contains(assignee)) {
            return true;
        }
        return false;
    }

    // По тегу
    public Issue[] searchByTags(HashSet<String> searchTags, Comparator<Issue> comparator) {
        ArrayList<Issue> filteredIssues = new ArrayList<Issue>();

        for (Issue issue : repository.getAll()) {
            Set<String> issueTags = issue.getTags();

            for (String searchTag : searchTags) {
                if (issueTags.contains(searchTag)) {
                    filteredIssues.add(issue);
                    continue;
                }
            }
        }
        return filteredIssues.toArray(new Issue[filteredIssues.size()]);
    }

    // Открытие Issue
    public void openIssueById(int id) {
        Issue openedIssues = null;
        for (Issue issue : repository.getAll()) {
            if (issue.getId() == id) {
                openedIssues = issue;
                issue.setClose(false);
            }
        }
        if (openedIssues == null) {
            throw new RuntimeException("Issue с указанным ID не существует");
        }
    }

    // Закрытие Issue
    public void closeIssueById(int id) {
        Issue closedIssues = null;
        for (Issue issue : repository.getAll()) {
            if (issue.getId() == id) {
                closedIssues = issue;
                issue.setClose(true);
            }
        }
        if (closedIssues == null) {
            throw new RuntimeException("Issue c указанным ID не существует");
        }
    }

}
