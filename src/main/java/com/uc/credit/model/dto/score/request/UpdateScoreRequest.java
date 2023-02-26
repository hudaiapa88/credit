package com.uc.credit.model.dto.score.request;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class UpdateScoreRequest {
    private Long amount;

}
