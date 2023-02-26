package com.uc.credit.controller;

import com.uc.credit.manager.ScoreManager;
import com.uc.credit.model.dto.score.request.SaveScoreRequest;
import com.uc.credit.model.dto.score.request.UpdateScoreRequest;
import com.uc.credit.model.dto.score.response.ScoreResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("score")
public class ScoreController {
    private final ScoreManager scoreManager;
    @PostMapping("/customer/{customerId}")
    public ResponseEntity<ScoreResponse> save(@PathVariable String customerId, @Valid @RequestBody SaveScoreRequest saveScoreRequest){
        return ResponseEntity.ok(scoreManager.save(customerId,saveScoreRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ScoreResponse> update(@PathVariable String id, @RequestBody @Valid UpdateScoreRequest updateScoreRequest){
        return ResponseEntity.ok(scoreManager.update(id,updateScoreRequest));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        scoreManager.delete(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ScoreResponse> getById(@PathVariable String id){
        return ResponseEntity.ok(scoreManager.getById(id));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ScoreResponse>> getAll(){
        return ResponseEntity.ok(scoreManager.getAll());
    }
}
