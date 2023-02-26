package com.uc.credit.model.entity.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
public class AuditData extends BaseEntity{
    @CreatedDate
    private LocalDateTime createdDate=LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime lastModifiedDate =LocalDateTime.now();
}
