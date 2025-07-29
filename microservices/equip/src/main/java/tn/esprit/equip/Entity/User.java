package tn.esprit.equip.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String registrationNumber;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String cin;
    private String grade;
    private String employment;
    private String college;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startingDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date recruitmentDate;

    @ManyToOne
    private Position position;

    @ManyToOne
    private Job job;

    @ManyToOne
    private Harbor harbor;

    @JsonIgnore
    @ManyToOne
    private Status status;

    // Keep existing authentication fields for backward compatibility
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String role;

    // Helper method to get full name
    public String getFullName() {
        return (firstName != null ? firstName : "") + " " + (lastName != null ? lastName : "");
    }
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
            @OnDelete(action = OnDeleteAction.CASCADE)
    List<Affectation> affectations;



}
