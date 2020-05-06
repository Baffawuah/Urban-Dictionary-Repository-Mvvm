package com.example.urbandic.datasource.events;

import com.example.urbandic.model.WordResponse;

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
