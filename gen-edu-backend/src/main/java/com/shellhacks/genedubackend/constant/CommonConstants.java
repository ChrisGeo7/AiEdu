package com.shellhacks.genedubackend.constant;

public interface CommonConstants {

    String OPEN_AI_MODEL        = "gpt-3.5-turbo";
    String OPEN_AI_API_KEY      = "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";
    String OPEN_AI_ROLE         = "user";
    String OPEN_AI_URL          = "https://api.openai.com/v1/chat/completions";


    // Prompts
    String eduPath = "Give me a list of 5 topics to learn %s in the following json format: {\"modules\": []}";

}
