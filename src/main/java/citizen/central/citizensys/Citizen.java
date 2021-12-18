package citizen.central.citizensys;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "citizen")
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cnic", nullable = false, unique = true)
    private String cnic;

    @Column(name = "password", nullable = false)
    private String password;

    public Citizen() {
    }

    public Citizen( String cnic, String password) {

        this.cnic = cnic;
        this.password = password;
    }

    boolean validatePassword(String password){
        return Objects.equals(this.password, password);
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}