package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT s FROM Person p")
    , @NamedQuery(name = "Person.findById", query = "SELECT s FROM Person p WHERE p.id = :id")
    , @NamedQuery(name = "Person.bySemester", query = "SELECT s FROM Person p WHERE p.semesterId = :semesterId")
    , @NamedQuery(name = "Person.findByFirstname", query = "SELECT s FROM Person p WHERE p.firstname = :firstname")
    , @NamedQuery(name = "Person.findByLastname", query = "SELECT s FROM Person p WHERE p.lastname = :lastname")})
public class Person extends InfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    @ManyToMany
    private List<Hobby> hobbies;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

}
