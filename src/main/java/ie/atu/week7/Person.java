package ie.atu.week7;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "persons")
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String employeeId;
    private String position;
    private String department;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_person_address"))
    private Address address;

    public Person() {
    }

    public Person(String name, String email, String employeeId, String position, String department, Address address) {
        this.name = name;
        this.email = email;
        this.employeeId = employeeId;
        this.position = position;
        this.department = department;
        this.address = address;
    }

    public Person(Long id, String name, String email, String employeeId, String position, String department, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.employeeId = employeeId;
        this.position = position;
        this.department = department;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
