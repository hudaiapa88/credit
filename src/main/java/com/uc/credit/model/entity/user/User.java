package com.uc.credit.model.entity.user;

import com.uc.credit.model.entity.Address;
import com.uc.credit.model.entity.base.AuditData;
import lombok.Data;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "user")
@Data
public class User extends AuditData {
    private String firstname;
    private String lastname;
    @Indexed(unique = true)
    private String citizenId;
    @Indexed(unique = true)
    private String phone;
    private LocalDate birthDate;
    private Address address;
}
