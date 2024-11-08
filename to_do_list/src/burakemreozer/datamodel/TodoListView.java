package burakemreozer.view;

import burakemreozer.datamodel.TodoObserver;
import burakemreozer.datamodel.TodoData;
import burakemreozer.datamodel.TodoItem;

public class TodoListView implements TodoObserver {

    public TodoListView() {
        // Subscribe to TodoData updates
        TodoData.getInstance().addObserver(this);
    }

    @Override
    public void update() {
        // This method will be called whenever TodoData changes
        refreshTodoList();
    }

    private void refreshTodoList() {
        // Code to update the UI or do whatever is needed when data changes
        System.out.println("The Todo list has been updated.");
    }
}
