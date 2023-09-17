package com.shellhacks.genedubackend.controller;

import com.shellhacks.genedubackend.model.Module;
import com.shellhacks.genedubackend.model.Topic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ContentController {

    ResponseEntity<?> getEduPath(String p);

    ResponseEntity<?> getModuleTopics(Module module);

    ResponseEntity<?> getTopicContent(@RequestBody Topic topic);

    ResponseEntity<?> getTopicQuiz(@RequestBody Topic topic);

}
