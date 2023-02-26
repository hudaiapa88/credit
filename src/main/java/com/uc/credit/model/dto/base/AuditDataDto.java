package com.uc.credit.model.dto.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuditDataDto extends BaseDto{
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
