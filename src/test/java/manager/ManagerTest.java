package manager;

import comparators.SortByHowManyDaysAgoWasItCreated;
import comparators.SortById;
import comparators.SortByNumber;
import data.Issue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.Repository;

import java.sql.Struct;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Repository repository = new Repository();
    Manager manager = new Manager(repository);
    Collection<Issue> issues = new ArrayList<>();
    HashSet<String> jin = new HashSet<>();
    HashSet<String> jin1 = new HashSet<>();

    Issue i1 = new Issue(1, 1, "Danil", "Master", "Sveta", new HashSet<String>(Arrays.asList("set", "Smola")), "Text", 4, false);
    Issue i2 = new Issue(2, 2, "Jin", "Master", "Sveta", new HashSet<String>(Arrays.asList("set", "Smola")), "Text", 6, true);
    Issue i3 = new Issue(3, 3, "Madara", "Master", "Sveta", new HashSet<String>(Arrays.asList("Sumr", "Smola", "Killer")), "Text", 9, false);
    Issue i4 = new Issue(4, 4, "Sveta", "Robson", "Kiril", new HashSet<String>(Arrays.asList("set", "Son")), "Text", 7, false);
    Issue i5 = new Issue(5, 5, "Maga", "David", "Sveta", new HashSet<String>(Arrays.asList("Kill", "Smegl")), "Text", 8, true);
    Issue i6 = new Issue(6, 6, "Omar", "Master", "Poncho", new HashSet<String>(Arrays.asList("set", "Smola")), "Text", 2, false);
    Issue i7 = new Issue(7, 7, "Armen", "Master", "Sveta", new HashSet<String>(Arrays.asList("set", "Smola")), "Text", 1, false);


    @BeforeEach
    void setup() throws Exception {
        issues.add(i1);
        issues.add(i2);
        issues.add(i3);
        issues.add(i4);
        issues.add(i5);
        issues.add(i6);
        issues.add(i7);

        manager.saveAll(issues);

        manager.removeById(1);
        manager.removeByNumber(1);
        manager.openIssueById(2);
        manager.closeIssueById(2);
        manager.closeIssueById(6);


    }

    // Показывает все добавленные элементы
    @Test
    void shouldAllElements() {
        assertArrayEquals(new Issue[]{i2, i3, i4, i5, i6, i7}, manager.getAll());
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
        assertArrayEquals(new Issue[]{i7, i2, i5, i3}, manager.searchByAssignee("Sveta", new SortByHowManyDaysAgoWasItCreated()));
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
        assertArrayEquals(new Issue[]{i2, i5, i6}, manager.searchCloseIssues(new SortByNumber()));
    }

    // Показывает удаление всех элементов.
    @Test
    void shouldRemoveAll() {
        manager.removeAll(issues);
        assertEquals(0, repository.size());
    }

    // Количество элементов
    @Test
    void shouldFindSizeElements() {
        assertEquals(6, repository.size());
    }

    // Проверка поиска по тегу
    @Test
    void shouldFindTags() {
        jin.add("Smegl");
        System.out.println(Arrays.stream(manager.searchByTags(jin, new SortById())).count());
        assertEquals(1, Arrays.stream(manager.searchByTags(jin, new SortById())).count());
        assertArrayEquals(new Issue[]{i5}, manager.searchByTags(jin, new SortByHowManyDaysAgoWasItCreated()));
    }

    // Поиск по двум тегам
    @Test
    void shouldFindCountTags() {
        jin.add("Sumr");
        jin.add("Kill");
        assertEquals(2, Arrays.stream(manager.searchByTags(jin, new SortById())).count());
        assertArrayEquals(new Issue[]{i3, i5}, manager.searchByTags(jin, new SortById()));
    }

    // Поиск по несуществующему тегу
    @Test
    void shouldTagsZeroCount() {
        jin1.add("Гомер");
        assertEquals(0, Arrays.stream(manager.searchByTags(jin1, new SortById())).count());
        assertArrayEquals(new Issue[0], manager.searchByTags(jin1, new SortByNumber()));
    }

    // Закрытие существующего Issue
    @Test
    void shouldZeroCloseItem() {
        manager.closeIssueById(4);
        boolean actual = i4.isClose();
        assertTrue(actual);
    }


    // Проверка закрытия Issue по несуществующему id
    @Test
    void shouldCloseByIdIfIssueWithIndexDoesNotExist() {
        assertThrows(RuntimeException.class, () -> {
            manager.closeIssueById(27);
        });
    }

    // Проверка открытия Issue по id
    @Test
    void shouldOpenByIdIfIssueWithIdExist() {
        manager.openIssueById(2);
        boolean actual = i2.isClose();
        assertFalse(actual);
    }

    // Проверка открытия Issue по несуществующему id
    @Test
    void shouldOpenByIdIfIssueWithIndexDoesNotExist() {
        assertThrows(RuntimeException.class, () -> {
            manager.openIssueById(27);
        });
    }


}