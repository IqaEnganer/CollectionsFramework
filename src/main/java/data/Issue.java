package data;

import lombok.Data;

import java.util.*;

@Data
public class Issue implements List<Issue> {
    private int id;
    private int number;
    private String author;
    private String topic;
    private String assignee;
    private HashSet<String> tags = new HashSet<String>();
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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Issue> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Issue issue) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Issue> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Issue> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Issue get(int index) {
        return null;
    }

    @Override
    public Issue set(int index, Issue element) {
        return null;
    }

    @Override
    public void add(int index, Issue element) {

    }

    @Override
    public Issue remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Issue> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Issue> listIterator(int index) {
        return null;
    }

    @Override
    public List<Issue> subList(int fromIndex, int toIndex) {
        return null;
    }


}