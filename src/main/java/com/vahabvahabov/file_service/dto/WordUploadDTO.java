package com.vahabvahabov.file_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordUploadDTO {

    private String word;

    private String synonyms;

    private String antonyms;

    private String usageFrequency;

    private List<String> definitions = new ArrayList<>();

    private List<String> examples = new ArrayList<>();

    private String contextParagraph;

    private String imageUrl;

    private boolean hasEmptySlot;


}
