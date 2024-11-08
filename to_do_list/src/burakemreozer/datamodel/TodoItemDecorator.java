package burakemreozer.datamodel;

import java.time.LocalDate;

public abstract class TodoItemDecorator extends TodoItem {
    protected TodoItem decoratedTodoItem;

    public TodoItemDecorator(TodoItem decoratedTodoItem) {
        super(decoratedTodoItem.getShortDescription(), decoratedTodoItem.getDetails(), decoratedTodoItem.getDeadline());
        this.decoratedTodoItem = decoratedTodoItem;
    }

    public abstract String getShortDescription();
}
