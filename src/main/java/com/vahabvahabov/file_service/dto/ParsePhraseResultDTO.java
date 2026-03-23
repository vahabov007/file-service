package com.vahabvahabov.file_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParsePhraseResultDTO {
    private List<PhraseUploadDTO> lines;
}

