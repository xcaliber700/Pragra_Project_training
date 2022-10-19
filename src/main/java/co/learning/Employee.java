package co.learning;

import lombok.Data;

@Data
public class Employee {
    private final int employeeId;
    private final String name;
    enum Type {FULLTIME, PARTTIME, CONTRACT}
    private final Type type;
    private final double salary;
}
