package com.shellhacks.genedubackend.constant;

public interface CommonConstants {

    String OPEN_AI_MODEL        = "gpt-3.5-turbo";
    String OPEN_AI_API_KEY      = "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";
    // String OPEN_AI_API_KEY      = "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";
    String OPEN_AI_ROLE         = "user";
    String OPEN_AI_URL          = "https://api.openai.com/v1/chat/completions";


    // Prompts
    String eduPath = "Give me a learning path with 5 topics that I should follow in order to learn %s with output as a list of just the topic name and a one line description in the following json format: {\"modules\": [{\"name\": \"\", \"description\": \"\"}]}";
    String moduleTopics = "On a scale of 1 to 5, I have a %d level of understanding on %s. To learn %s for my level of knowledge, give me a list of ordered topic names that are essential to learn in the following json format: {\"topics\": [\"\", \"\"]}";

    String topicContent = "Give a comprehensive explanation of %s in %s with appropriate examples. Give your explanation in the following json format: {\"content\": \"\"}. In addition, give the value for content as a well-formatted html markup that can be used for direct rendering.";

    String topicQuiz    = "Give a list of 4 multiple choice quiz on %s in %s in the following json format: [\"quizzes\": {\"question\": \"\", choices:[\"\", \"\", \"\"], answer},]. answer should be the index number of the correct choice.";

}
