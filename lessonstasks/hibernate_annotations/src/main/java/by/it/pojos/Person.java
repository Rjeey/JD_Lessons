package by.it.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person implements Serializable {


    private static final long serialVersionUID = 28233677103389384L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String secondName;
    @Column
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecoundName() {
        return secondName;
    }

    public void setSecoundName(String secoundName) {
        this.secondName = secoundName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) return false;
        Person that = (Person) o;
        return new EqualsBuilder()
                .append(this.id, that.id)
                .append(that.name, that.name)
                .append(this.secondName, that.secondName)
                .append(this.age, that.age)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .append(secondName)
                .append(age)
                .toHashCode();
    }
}
