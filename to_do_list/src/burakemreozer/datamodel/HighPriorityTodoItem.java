package burakemreozer.datamodel;

public class HighPriorityTodoItem extends TodoItemDecorator {

    public HighPriorityTodoItem(TodoItem decoratedTodoItem) {
        super(decoratedTodoItem);
    }

    @Override
    public String getShortDescription() {
        return "[High Priority] " + decoratedTodoItem.getShortDescription();
    }
}
