package samramg.flutter.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter@Setter
@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue
    public int id;
    public String firstName;

    public String lastName;

    public EmployeeEntity() {

    }

}
