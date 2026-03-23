package com.vahabvahabov.file_service.service;

import com.vahabvahabov.file_service.dto.ParseWordResultDTO;
import com.vahabvahabov.file_service.dto.WordUploadDTO;
import com.vahabvahabov.file_service.exception.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "WORD-SERVICE")
public interface WordClient {

    @PostMapping("/api/v1/words")
    public ResponseEntity<ApiResponse<Void>> saveStrict(@RequestBody WordUploadDTO wordUploadDTO);

    @PostMapping("/api/v1/words/parse")
    public ResponseEntity<ApiResponse<ParseWordResultDTO>> parseLines(@RequestBody List<String> lines);

}
