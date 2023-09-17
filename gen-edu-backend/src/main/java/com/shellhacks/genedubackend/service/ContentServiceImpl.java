package com.shellhacks.genedubackend.service;

import com.shellhacks.genedubackend.constant.CommonConstants;
import com.shellhacks.genedubackend.exception.InvalidInputException;
import com.shellhacks.genedubackend.model.EduPath;
import com.shellhacks.genedubackend.model.Module;
import com.shellhacks.genedubackend.model.Topic;
import com.shellhacks.genedubackend.requestmodel.*;
import com.shellhacks.genedubackend.util.JsonUtil;
import com.shellhacks.genedubackend.util.RestClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

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
            edupathResponse = JsonUtil.fromJson(jsonString, EdupathResponse.class);
        }
        if (edupathResponse != null) {
            result = new EduPath(StringUtils.upperCase(queryPath), new ArrayList<>());
            for (ModuleRequest module: edupathResponse.getModules()) {
                result.getModules().add(new Module(module.getName(), module.getDescription()));
            }
        }

        return result;
    }

    @Override
    public Module getModuleTopics(Module module) throws Exception {

        if (module == null || StringUtils.isEmpty(module.getName()) || module.getLevel() < 1 || module.getLevel() > 5)
            throw new InvalidInputException("Invalid model entity input.");

        String prompt = String.format(CommonConstants.moduleTopics, module.getLevel(), module.getName(), module.getName());
        OpenAiQuery query = new OpenAiQuery(CommonConstants.OPEN_AI_MODEL,
                Arrays.asList(new Message(CommonConstants.OPEN_AI_ROLE, prompt)));

        RestClient restClient = new RestClient();
        String response  = restClient.sendRequest(CommonConstants.OPEN_AI_URL, RestClient.HttpMethod.POST, null,
                JsonUtil.toJson(query), restClient.getHeadersJson(CommonConstants.OPEN_AI_API_KEY));

        OpenAiResponse openAiResponse = JsonUtil.fromJson(response, OpenAiResponse.class);

        Module moduleResponse = null;

        if (openAiResponse != null) {
            Choice choice = openAiResponse.getChoices().get(0);
            String jsonString = choice.getMessage().getContent();
            moduleResponse = JsonUtil.fromJson(jsonString, Module.class);
        }

        if (moduleResponse != null) {
            moduleResponse.setName(module.getName());
        }

        return moduleResponse;

    }

    @Override
    public Topic getTopicContent(Topic topic) throws Exception{
        if (topic == null || StringUtils.isEmpty(topic.getName()))
            throw new InvalidInputException("Invalid model entity input.");

        String prompt = String.format(CommonConstants.topicContent, topic.getName(), topic.getModuleName());
        OpenAiQuery query = new OpenAiQuery(CommonConstants.OPEN_AI_MODEL,
                Arrays.asList(new Message(CommonConstants.OPEN_AI_ROLE, prompt)));

        RestClient restClient = new RestClient();
        String response  = restClient.sendRequest(CommonConstants.OPEN_AI_URL, RestClient.HttpMethod.POST, null,
                JsonUtil.toJson(query), restClient.getHeadersJson(CommonConstants.OPEN_AI_API_KEY));

        OpenAiResponse openAiResponse = JsonUtil.fromJson(response, OpenAiResponse.class);

        Topic topicResponse = null;

        if (openAiResponse != null) {
            Choice choice = openAiResponse.getChoices().get(0);
            String jsonString = choice.getMessage().getContent();
            topicResponse = JsonUtil.fromJson(jsonString, Topic.class);
        }

        if (topicResponse != null) {
            topicResponse.setName(topic.getName());
        }

        return topicResponse;
    }

}
