package net.thetechstack.springh2project.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id private String number;
    private String firstName;
    private String lastName;
    private Double balance;
}
