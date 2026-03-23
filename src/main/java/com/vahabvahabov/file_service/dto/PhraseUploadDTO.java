package com.vahabvahabov.file_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhraseUploadDTO {

    private String phrase;

    private String synonyms;

    private String usageFrequency;

    private List<String> definitions = new ArrayList<>();

    private List<String> examples = new ArrayList<>();


}

