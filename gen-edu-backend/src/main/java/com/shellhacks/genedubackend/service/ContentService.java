package com.shellhacks.genedubackend.service;

import com.shellhacks.genedubackend.exception.InvalidInputException;
import com.shellhacks.genedubackend.model.EduPath;
import com.shellhacks.genedubackend.model.Module;
import com.shellhacks.genedubackend.model.Topic;

public interface ContentService {
    EduPath getLearningPath(String pathQuery) throws Exception;

    Module getModuleTopics(Module module) throws Exception;

    Topic getTopicContent(Topic topic) throws Exception;

}
