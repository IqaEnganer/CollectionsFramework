package repository;

import data.Issue;
import org.junit.jupiter.api.Test;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    private Repository repo = new Repository();

    @Test
    void shouldAddAllIssue() {
        Collection<Issue> issues =  new ArrayList<>();
        issues.add(new Issue());
        issues.add(new Issue());
        issues.add(new Issue());
        issues.add(new Issue());
        issues.add(new Issue());

        repo.saveAll(issues);
        System.out.println(repo.getAll().size());
    }
    @Test
    void shouldRemoveAllIssue() {
        Collection<Issue> issues =  new ArrayList<>();
        issues.add(new Issue());
        issues.add(new Issue());
        issues.add(new Issue());
        issues.add(new Issue());
        issues.add(new Issue());


        System.out.println(repo.getAll().size());
    }
    @Test
    void shouldAddMultipleIssue(){
        repo.saveAll(List.of(new Issue(),new Issue(), new Issue()));
        System.out.println(repo.getAll().size());
    }
}