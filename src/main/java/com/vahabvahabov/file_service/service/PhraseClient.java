package com.vahabvahabov.file_service.service;

import com.vahabvahabov.file_service.dto.ParsePhraseResultDTO;
import com.vahabvahabov.file_service.dto.ParseWordResultDTO;
import com.vahabvahabov.file_service.dto.PhraseUploadDTO;
import com.vahabvahabov.file_service.exception.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "PHRASE-SERVICE")
public interface PhraseClient {

    @PostMapping("api/v1/phrases/save-all")
    void saveAllStrict(@RequestBody List<PhraseUploadDTO> phrases);

    @PostMapping("/api/v1/phrases")
    public ResponseEntity<ApiResponse<Void>> saveStrict(@RequestBody PhraseUploadDTO phraseUploadDTO);

    @PostMapping("/api/v1/phrases/parse")
    public ResponseEntity<ApiResponse<ParsePhraseResultDTO>> parseLines(@RequestBody List<String> lines);
}
