package repository;

import data.Issue;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class RepositoryTest {
    private Repository repo = new Repository();

    @Test
    void shouldAddAllIssue() {
        List<Issue> issues =  new ArrayList<>();
        issues.add(new Issue());
        issues.add(new Issue());
        issues.add(new Issue());
        issues.add(new Issue());
        issues.add(new Issue());

        repo.saveAll(issues);
        System.out.println(repo.getAll().size());
        assertEquals(5,repo.getAll().size());
    }
    @Test
    void shouldRemoveAllIssue() {
        List<Issue> issues =  new ArrayList<>();
        issues.add(new Issue());
        issues.add(new Issue());
        issues.add(new Issue());
        issues.add(new Issue());
        issues.add(new Issue());
        repo.removeAll(issues);

        System.out.println(repo.getAll().size());
        assertEquals(0,repo.getAll().size());
    }
    @Test
    void shouldAddMultipleIssue(){
        repo.saveAll(List.of(new Issue(),new Issue(), new Issue()));
        System.out.println(repo.getAll().size());
        assertEquals(3,repo.getAll().size());
    }
}