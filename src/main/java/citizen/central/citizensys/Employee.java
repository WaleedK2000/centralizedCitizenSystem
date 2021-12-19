package citizen.central.citizensys;


import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empid", nullable = false)
    private Long empid;

    @Column(name = "emp_name", nullable = false, unique = true)
    private String emp_name;

    @Column(name = "designation", nullable = false)
    private String designation;


    public Employee() {
    }

    public Employee(String emp_name, String designation) {

        this.emp_name = emp_name;
        this.designation = designation;
    }


    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
