package com.vahabvahabov.file_service.controller;

import com.vahabvahabov.file_service.exception.ApiResponse;
import com.vahabvahabov.file_service.service.FileSyncService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/v1/file")
@Tag(name = "File API",
    description = "All actions related to file")
public class FileController {

    private final FileSyncService fileSyncService;

    @PostMapping
    @Operation(summary = "File sync: every word stores in word.txt file.")
    public ResponseEntity<ApiResponse<Void>> syncWordsFromFile(@RequestParam boolean isPhrase,
                                                               HttpServletRequest request) {
        fileSyncService.syncFromFile(isPhrase);

        return ResponseEntity.ok(ApiResponse.success("File sync process has successfully finished!",
                                                         null, 200,
                                                              request.getRequestURI()));
    }

}
