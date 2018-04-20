package org.springframework.koans.persistence.entity;

import javax.persistence.*;

/**
 * @author juergen.windhaber on 13.06.2016.
 * @since 1.0.0
 */

@Entity
@Table(name = "PERSON")
public class Person {

    private String personId;
    private String name;

    @Id
    @Column(name = "PERSON_ID")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
