package com.uc.credit.model.entity.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.UUID;

@Getter
public class BaseEntity {
    @Id
    private String id = UUID.randomUUID().toString();
}
