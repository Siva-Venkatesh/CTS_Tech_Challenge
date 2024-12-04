import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TodoPage {
    
    WebDriver driver;
    
    // Web elements
    By todoInput = By.cssSelector("input.new-todo");
    By toggleAllCheckbox = By.cssSelector("input.toggle-all");
    By todoList = By.cssSelector("ul.todo-list");
    By todoItems = By.cssSelector("ul.todo-list li");
    By todoCheckbox = By.cssSelector("input.toggle");
    By todoLabel = By.cssSelector("label");
    By deleteButton = By.cssSelector("button.destroy");
    By clearCompletedButton = By.cssSelector("button.clear-completed");
    By allFilterLink = By.linkText("All");
    By activeFilterLink = By.linkText("Active");
    By completedFilterLink = By.linkText("Completed");
    By todoCount = By.cssSelector("span.todo-count");
    
    public TodoPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Add a new todo
    public void addTodo(String todoText) {
        WebElement inputField = driver.findElement(todoInput);
        inputField.sendKeys(todoText);
        inputField.sendKeys(Keys.ENTER);
      //  inputField.submit();  // Press enter to add the todo
    }
    
    // Mark a todo as completed
    public void toggleTodoCompletion(int todoIndex) {
        List<WebElement> todos = driver.findElements(todoItems);
        WebElement todoCheckbox = todos.get(todoIndex).findElement(this.todoCheckbox);
        todoCheckbox.click();
    }
    
    // Delete a todo
    public void deleteTodo(int todoIndex) {
        List<WebElement> todos = driver.findElements(todoItems);
        WebElement deleteButton = todos.get(todoIndex).findElement(this.deleteButton);
        deleteButton.click();
    }
    
    // Toggle all todos
    public void toggleAllTodos() {
        WebElement toggleAllCheckbox = driver.findElement(this.toggleAllCheckbox);
        toggleAllCheckbox.click();
    }
    
    // Filter todos by "All"
    public void filterAll() {
        WebElement allFilter = driver.findElement(allFilterLink);
        allFilter.click();
    }
    
    // Filter todos by "Active"
    public void filterActive() {
        WebElement activeFilter = driver.findElement(activeFilterLink);
        activeFilter.click();
    }
    
    // Filter todos by "Completed"
    public void filterCompleted() {
        WebElement completedFilter = driver.findElement(completedFilterLink);
        completedFilter.click();
    }
    
    // Clear completed todos
    public void clearCompleted() {
        WebElement clearCompletedBtn = driver.findElement(clearCompletedButton);
        clearCompletedBtn.click();
    }
    
    // Get the count of todos left
    public String getTodoCount() {
        WebElement todoCount = driver.findElement(this.todoCount);
        return todoCount.getText();
    }


}
