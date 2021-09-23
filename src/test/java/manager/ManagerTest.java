package manager;

import comparators.SortByHowManyDaysAgoWasItCreated;
import comparators.SortById;
import comparators.SortByNumber;
import data.Issue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Repository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Repository repository = new Repository();
    Manager manager = new Manager(repository);

    Issue i1 = new Issue(1, 1, "Danil", "Master", "Sveta", new HashSet<String>(Arrays.asList("set", "Smola")), "Text", 4, false);
    Issue i2 = new Issue(2, 2, "Jin", "Master", "Sveta", new HashSet<String>(Arrays.asList("set", "Smola")), "Text", 6, true);
    Issue i3 = new Issue(3, 3, "Madara", "Master", "Sveta", new HashSet<String>(Arrays.asList("Sumr", "Smola", "Killer")), "Text", 9, false);
    Issue i4 = new Issue(4, 4, "Sveta", "Robson", "Kiril", new HashSet<String>(Arrays.asList("set", "Son")), "Text", 7, false);
    Issue i5 = new Issue(5, 5, "Maga", "David", "Sveta", new HashSet<String>(Arrays.asList("Kill", "Smegl")), "Text", 8, true);
    Issue i6 = new Issue(6, 6, "Omar", "Master", "Poncho", new HashSet<String>(Arrays.asList("set", "Smola")), "Text", 2, false);
    Issue i7 = new Issue(7, 7, "Armen", "Master", "Sveta", new HashSet<String>(Arrays.asList("set", "Smola")), "Text", 1, false);


    @BeforeEach
    void setup() throws Exception {
        manager.save(i1);
        manager.save(i2);
        manager.save(i3);
        manager.save(i4);
        manager.save(i5);
        manager.save(i6);
        manager.save(i7);
        manager.removeById(1);
        manager.removeByNumber(5);
        manager.openIssueById(2);
        manager.closeIssueById(2);
        manager.closeIssueById(6);

    }


    //Поиск по Id
    @Test
    void shouldFindId() {
        assertArrayEquals(new Issue[]{i7}, manager.searchById(7));
    }

    // Сортировка по статусу.
    // Поиск по Assignee (на кого назначено).
    @Test
    void shouldFindAssignee() {
        assertArrayEquals(new Issue[]{i7, i2, i3}, manager.searchByAssignee("Sveta", new SortByHowManyDaysAgoWasItCreated()));

    }

    // Сортировка по Id.
    // Показывает открытые Issue.
    @Test
    void shouldFindOpenIssues() {
        assertArrayEquals(new Issue[]{i3, i4, i7}, manager.searchOpenIssues(new SortById()));
    }

    // Сортировка по номеру Issue.
    // Показывает закрытые Issue.
    @Test
    void shouldFindCloseIssues() {
        assertArrayEquals(new Issue[]{i2, i6}, manager.searchCloseIssues(new SortByNumber()));
    }

    @Test
    void shouldRemoveAll() {
        assertArrayEquals(new Issue[]{i2}, manager.getAll());
    }

    // Количество элементов
    @Test
    void shouldFindSizeElements(){
        assertEquals(5, repository.size());
    }
    @Test
    void shouldOpenIssue(){
        manager.openIssueById(8);
        assertArrayEquals(new Issue[0], manager.getAll());
    }


}