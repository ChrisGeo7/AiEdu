package com.shellhacks.genedubackend.service;

import com.shellhacks.genedubackend.constant.CommonConstants;
import com.shellhacks.genedubackend.exception.InvalidInputException;
import com.shellhacks.genedubackend.model.EduPath;
import com.shellhacks.genedubackend.model.Module;
import com.shellhacks.genedubackend.requestmodel.*;
import com.shellhacks.genedubackend.util.JsonUtil;
import com.shellhacks.genedubackend.util.RestClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class ContentServiceImpl implements ContentService{

    public EduPath getLearningPath(String queryPath) throws Exception {
        EduPath result = null;

        if (StringUtils.isEmpty(queryPath))
            throw new InvalidInputException("Path query is empty.");

        String prompt = String.format(CommonConstants.eduPath, queryPath);
        OpenAiQuery query = new OpenAiQuery(CommonConstants.OPEN_AI_MODEL,
                Arrays.asList(new Message(CommonConstants.OPEN_AI_ROLE, prompt)));

        RestClient restClient = new RestClient();
        String response  = restClient.sendRequest(CommonConstants.OPEN_AI_URL, RestClient.HttpMethod.POST, null,
                JsonUtil.toJson(query), restClient.getHeadersJson(CommonConstants.OPEN_AI_API_KEY));

        OpenAiResponse openAiResponse = JsonUtil.fromJson(response, OpenAiResponse.class);

        EdupathResponse edupathResponse = null;
        if (openAiResponse != null) {
            Choice choice = openAiResponse.getChoices().get(0);
            String jsonString = choice.getMessage().getContent();
            System.out.println(jsonString);
            edupathResponse = JsonUtil.fromJson(jsonString, EdupathResponse.class);
        }
        result = new EduPath(StringUtils.upperCase(queryPath), new HashSet<>());
        for (String module: edupathResponse.getModules()) {
            result.getModules().add(new Module(module));
        }
        return result;
    }

}
