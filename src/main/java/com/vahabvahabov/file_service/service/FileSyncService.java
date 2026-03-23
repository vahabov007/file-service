package com.vahabvahabov.file_service.service;

import com.vahabvahabov.file_service.dto.PhraseUploadDTO;
import com.vahabvahabov.file_service.dto.WordUploadDTO;
import com.vahabvahabov.file_service.exception.exceptions.FileSyncException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service @RequiredArgsConstructor
public class FileSyncService {

    private final WordClient wordClient;
    private final PhraseClient phraseClient;

    @Value("${app.dict.words.file-path}") private String wordsFilePath;
    @Value("${app.dict.phrases.file-path}") private String phrasesFilePath;

    public void syncFromFile(boolean isPhrase) {
        try {
            if (isPhrase) {
                Path path = Paths.get(phrasesFilePath);
                List<String> lines = Files.readAllLines(path);
                var response  = phraseClient.parseLines(lines);

                if(response.getBody() == null || response.getBody().getData() == null) {
                    throw new FileSyncException("Phrase Service returned an empty result.");
                }
                List<PhraseUploadDTO> wrappedLines = response.getBody().getData().getLines();

                if (wrappedLines == null) {
                    throw new FileSyncException("ParsePhraseResultDTO contains no lines");
                }

                phraseClient.saveAllStrict(wrappedLines);
            } else {
                Path path = Paths.get(wordsFilePath);
                List<String> lines = Files.readAllLines(path);
                var response  = wordClient.parseLines(lines);

                if(response.getBody() == null || response.getBody().getData() == null) {
                    throw new FileSyncException("Word Service returned an empty result.");
                }
                List<WordUploadDTO> wrappedLines = response.getBody().getData().getLines();

                if (wrappedLines == null) {
                    throw new FileSyncException("ParseWordResultDTO contains no lines");
                }
                for (WordUploadDTO word : wrappedLines) {
                    word.setHasEmptySlot(false);
                    wordClient.saveStrict(word);
                }
            }
        }catch (IOException e) {
            throw new FileSyncException("Could not read the source file for sync.");
        }catch (Exception e) {
            throw new FileSyncException("Error occurred during the communication with Word Service: " + e.getMessage());
        }
    }

}