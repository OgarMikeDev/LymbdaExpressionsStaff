import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

public class Employee {
    private String name;
    private Integer salary;
    private Date workStart;

    public Employee(String name, Integer salary, Date workStart) {
        this.name = name;
        this.salary = salary;
        this.workStart = workStart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getWorkStart() {
        return workStart;
    }

    public void setWorkStart(Date workStart) {
        this.workStart = workStart;
    }

    @Override
    public String toString() {
        return "Name \"" + name +
                "\", Salary \"" + salary +
                "\", Work start \"" + workStart + "\"";
    }
}
