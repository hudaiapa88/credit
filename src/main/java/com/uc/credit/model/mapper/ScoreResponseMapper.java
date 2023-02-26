package com.uc.credit.model.mapper;

import com.uc.credit.model.dto.score.response.ScoreResponse;
import com.uc.credit.model.entity.Score;
import com.uc.credit.model.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScoreResponseMapper extends BaseMapper<Score, ScoreResponse> {
}
