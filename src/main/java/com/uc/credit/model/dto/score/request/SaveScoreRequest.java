package com.uc.credit.model.dto.score.request;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class SaveScoreRequest {
    @Positive(message = "Lütfen geçerli bir miktar giriniz.")
    private Long amount;
}
