package com.shellhacks.genedubackend.service;

import com.shellhacks.genedubackend.model.EduPath;

public interface ContentService {
    EduPath getLearningPath(String pathQuery) throws Exception;

}
