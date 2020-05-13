package com.example.urbandic.model.datasource.events;

import com.example.urbandic.model.WordResponse.WordResponse;

public class WordResponseEvent {
    WordResponse wordResponse;

    public WordResponse getWordResponse() {
        return wordResponse;
    }

    public void setWordResponse(WordResponse wordResponse) {
        this.wordResponse = wordResponse;
    }

    public WordResponseEvent(WordResponse wordResponse) {
        this.wordResponse = wordResponse;
    }
}
