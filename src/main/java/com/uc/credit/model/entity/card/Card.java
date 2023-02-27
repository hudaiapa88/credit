package com.uc.credit.model.entity.card;

import com.uc.credit.model.entity.base.AuditData;
import com.uc.credit.model.enums.CardType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "card")
public class Card extends AuditData {
         private String number;
         private String cvv;
         private LocalDate validityDate;
         private CardType cardType;
}
