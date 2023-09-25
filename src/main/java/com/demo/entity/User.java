package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
    private Integer id;

    private String name;
    private String address;
    private String phNo;
    
    @Column(unique = true)
   
    private String email;
    private String password;
    @Column(columnDefinition = "boolean default 'true'")
    private Boolean status;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<UserRole> userRoles;

    

	public User(Integer userId2) {
		this.id=userId2;
	}

    
}
