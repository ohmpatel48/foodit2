package com.example.userservices.Entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "userdetails")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Userid;

    @Column(unique=true,nullable = false)
    private String username;

    private String firstname;

    private String lastname;

    @Column(unique=true,nullable = false)
    private String Email;

    @Column(nullable = false)
    private String Password;

    @Column(nullable = false)
    private role User_role;

}
