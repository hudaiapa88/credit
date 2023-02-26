package com.uc.credit.manager;

import com.uc.credit.exception.EntityNotFoundException;
import com.uc.credit.model.dto.score.request.SaveScoreRequest;
import com.uc.credit.model.dto.score.request.UpdateScoreRequest;
import com.uc.credit.model.dto.score.response.ScoreResponse;
import com.uc.credit.model.entity.Score;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.model.mapper.ScoreResponseMapper;
import com.uc.credit.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ScoreManager {
    private final ScoreRepository scoreRepository;
    private final CustomerManager customerManager;
    private final ScoreResponseMapper scoreResponseMapper;
    public ScoreResponse save(String customerId, SaveScoreRequest saveScoreRequest) {
        Customer customer=customerManager.findById(customerId);
        return scoreResponseMapper.convert(scoreRepository.save(Score.create(saveScoreRequest,customer)));
    }

    public ScoreResponse update(String id, UpdateScoreRequest updateScoreRequest) {
        Score score= findById(id);
        return scoreResponseMapper.convert(scoreRepository.save(score.update(updateScoreRequest)));
    }

    private Score findById(String id) {
        return scoreRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Skor bulunamadı."));
    }

    public void delete(String id) {
        scoreRepository.deleteById(id);
    }

    public ScoreResponse getById(String id) {
        return scoreResponseMapper.convert(findById(id));
    }

    public List<ScoreResponse> getAll() {
        return scoreResponseMapper.convertList(scoreRepository.findAll()) ;
    }

    public Score findByCustomerId(String customerId) {
        return scoreRepository.findByCustomer_Id(customerId).orElseThrow(()->new EntityNotFoundException("Bu müşteriye ait kredi skoru buunamadı."));
    }
}
