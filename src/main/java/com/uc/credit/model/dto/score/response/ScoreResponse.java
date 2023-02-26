package com.uc.credit.model.dto.score.response;

import com.uc.credit.model.dto.base.BaseDto;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
public class ScoreResponse extends BaseDto {
    private Long amount;
}
