import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToDoTest {
    static WebDriver driver;
    static TodoPage todoPage;
    
    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://todomvc.com/examples/react/dist/");
        todoPage = new TodoPage(driver);
    }
    
    @AfterClass
    public static void tearDown() {
        // Close the browser after tests
        driver.quit();
    }
    
    @Step("Acceptance Criteria 001")
    @Test
    public void AC1_AddTodo() throws InterruptedException {
        String todoText = "AC1_Cognizant Tech Challenge";
        todoPage.addTodo(todoText);
        
        // Validate the todo is added
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains(todoText), "Todo was not added!");
    }
    
    @Step("Acceptance Criteria 002")
    @Test
    public void AC2_ToggleTodo() throws InterruptedException {
        todoPage.addTodo("AC2_Toggle todo");
        
        // Toggle the first todo
        todoPage.toggleTodoCompletion(0);
        
        // Validate that the todo is marked as completed
        Thread.sleep(2000);
        
        String todoCountText = todoPage.getTodoCount();
        Thread.sleep(2000);
        Assert.assertTrue(todoCountText.contains("1"), "Todo was not toggled as completed!");
        
    }
    
    @Step("Acceptance Criteria 003")
    @Test
    public void AC3_DeleteTodo() throws InterruptedException {
        todoPage.addTodo("AC3_Delete ToDo");
        
        // Delete the first todo
        Thread.sleep(2000);
        todoPage.toggleAllTodos();
        
        // Validate that the todo is deleted
        String todoCountText = todoPage.getTodoCount();
        Thread.sleep(2000);
        Assert.assertTrue(todoCountText.contains("0"), "Todo was not deleted!");
    }
    
    @Step("Acceptance Criteria 004")
    @Test
    public void AC4_ToggleAllTodos() throws InterruptedException {
        todoPage.addTodo("AC4_Tech Challenge Task 1");
        todoPage.addTodo("AC4_Tech Challenge Task 2");
        
        // Toggle all todos
        todoPage.toggleAllTodos();
        
        // Validate all todos are marked as completed
        String todoCountText = todoPage.getTodoCount();
        Thread.sleep(2000);
        
        Assert.assertTrue(todoCountText.contains("0"), "Not all todos were toggled as completed!");
        Thread.sleep(2000);
        
    }
    
    @Step("Acceptance Criteria 005")
    @Test
    public void AC5_ClearCompletedTodos() throws InterruptedException {
        todoPage.addTodo("AC5_Tech Challenge Task 3");
        todoPage.addTodo("AC5_Tech Challenge Task 4");
        
        // Mark the first todo as completed
        todoPage.toggleTodoCompletion(0);
        
        // Clear completed todos
        todoPage.clearCompleted();
        
        // Validate that completed todos are cleared
        String todoCountText = todoPage.getTodoCount();
        Thread.sleep(2000);
        
        Assert.assertTrue(todoCountText.contains("3"), "Completed todos were not cleared!");
        
    }
    
    @Step("Acceptance Criteria 006")
    @Test
    public void AC6_FilterTodos() throws InterruptedException {
        todoPage.addTodo("AC6_Tech Challenge Task 5");
        todoPage.addTodo("AC6_Tech Challenge Task 6");
        todoPage.addTodo("AC6_Tech Challenge Task 7");
        
        // Mark some todos as completed
        todoPage.toggleTodoCompletion(0);
        todoPage.toggleTodoCompletion(1);
        
        // Filter by all todos
        todoPage.filterAll();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("AC6_Tech Challenge Task 5"), "All filter not working!");
        
        // Filter by active todos
        todoPage.filterActive();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("AC6_Tech Challenge Task 6"), "Active filter not working!");
        
    }
}
