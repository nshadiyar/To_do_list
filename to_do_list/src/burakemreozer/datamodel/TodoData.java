package burakemreozer.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String filename = "TodoListItems.txt";

    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter formatter;

    // List to hold all registered observers
    private List<TodoObserver> observers;

    public static TodoData getInstance() {
        return instance;
    }

    private TodoData() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        observers = new ArrayList<>(); // Initialize the observer list
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    // Add an observer to the list
    public void addObserver(TodoObserver observer) {
        observers.add(observer);
    }

    // Notify all observers
    private void notifyObservers() {
        for (TodoObserver observer : observers) {
            observer.update();
        }
    }

    public void addTodoItem(TodoItem item) {
        todoItems.add(item);
        notifyObservers();  // Notify observers when an item is added
    }

    public void loadTodoItems() throws IOException {
        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");

                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];

                LocalDate date = LocalDate.parse(dateString, formatter);
                TodoItem todoItem = new TodoItem(shortDescription, details, date);
                todoItems.add(todoItem);
            }

        } finally {
            if(br != null) {
                br.close();
            }
        }
        notifyObservers();  // Notify observers after loading items
    }

    public void storeTodoItems() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<TodoItem> iter = todoItems.iterator();
            while(iter.hasNext()) {
                TodoItem item = iter.next();
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline().format(formatter)));
                bw.newLine();
            }
        } finally {
            if(bw != null) {
                bw.close();
            }
        }
        notifyObservers();  // Notify observers after saving items
    }

    public void deleteTodoItem(TodoItem item) {
        todoItems.remove(item);
        notifyObservers();  // Notify observers when an item is deleted
    }
}
