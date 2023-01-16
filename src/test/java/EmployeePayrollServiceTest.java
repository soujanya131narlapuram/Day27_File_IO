import org.junit.Test;
import static org.junit.Assert.*;
import com.bridgelabz.Employee;
import java.io.File;
import java.io.IOException;


public class EmployeePayrollServiceTest {
    private Employee employee;

    @Test
    public void testEmployeeCreation() {
        employee = new Employee(1, "John Doe", 50000);
        assertEquals(1, employee.getId());
        assertEquals("John Doe", employee.getName());
        assertEquals(50000, employee.getSalary(), 0);
    }

    @Test
    public void testDirectoryCreation() {
        String directoryName = "employee_payroll";
        File directory = new File(directoryName);
        assertTrue(directory.mkdir());
        assertTrue(directory.exists());
    }

    @Test
    public void testFileCreation() {
        String directoryName = "employee_payroll";
        String fileName = "John Doe.txt";
        File file = new File(directoryName + "/" + fileName);
        try {
            assertTrue(file.createNewFile());
            assertTrue(file.exists());
        } catch (IOException e) {
            fail("Failed to create file");
        }
    }

    @Test
    public void testFileDeletion() {
        String directoryName = "employee_payroll";
        String fileName = "John Doe.txt";
        File file = new File(directoryName + "/" + fileName);
        assertTrue(file.delete());
        assertFalse(file.exists());
    }
}
