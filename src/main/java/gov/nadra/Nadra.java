package gov.nadra;

import javax.persistence.*;

@Entity
@Table(name = "nadra_db")
public class Nadra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cnic", nullable = false)
    private String cnic;

    @Column(name = "firstname", nullable = false)
    private String first_name;

    @Column(name = "lastname", nullable = false)
    private String last_name;

    @Column(name = "fathercnic")
    private String father_cnic;

    @Column(name = "mothercnic")
    private String mother_cnic;

    @Column(name = "dob", nullable = false)
    private String date_Of_birth;

    @Column(name = "gender", nullable = false)
    private char gender;

    public Nadra(Long id, String cnic, String first_name, String last_name, String father_cnic, String mother_cnic, String date_Of_birth, char gender) {
        this.id = id;
        this.cnic = cnic;
        this.first_name = first_name;
        this.last_name = last_name;
        this.father_cnic = father_cnic;
        this.mother_cnic = mother_cnic;
        this.date_Of_birth = date_Of_birth;
        this.gender = gender;
    }

    public Nadra() {
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFather_cnic() {
        return father_cnic;
    }

    public void setFather_cnic(String father_cnic) {
        this.father_cnic = father_cnic;
    }

    public String getMother_cnic() {
        return mother_cnic;
    }

    public void setMother_cnic(String mother_cnic) {
        this.mother_cnic = mother_cnic;
    }

    public String getDate_Of_birth() {
        return date_Of_birth;
    }

    public void setDate_Of_birth(String date_Of_birth) {
        this.date_Of_birth = date_Of_birth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
