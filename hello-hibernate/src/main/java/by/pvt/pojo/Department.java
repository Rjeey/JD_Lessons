package by.pvt.pojo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Set;

public class Department {

    private long id;
    private String departmentName;
    private Set<Employee> employees;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(departmentName)
                .append(employees)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Department)) return false;
        Department that = (Department) obj;
        return new EqualsBuilder()
                .append(this.id, that.id)
                .append(this.departmentName, that.departmentName)
                .append(this.employees, that.employees)
                .isEquals();

    }
}
