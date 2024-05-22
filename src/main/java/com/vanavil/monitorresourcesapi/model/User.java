// User.java
package com.vanavil.monitorresourcesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "user")
public class User {
    @Id
    private String id; // Changing ID field to ensure uniqueness
    private String mobileNumber;
    private String password;

    // Constructors, getters, and setters
}
