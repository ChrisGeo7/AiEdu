package com.shellhacks.genedubackend.controller;

import com.shellhacks.genedubackend.constant.UriConstant;
import com.shellhacks.genedubackend.exception.InvalidInputException;
import com.shellhacks.genedubackend.model.EduPath;
import com.shellhacks.genedubackend.model.Module;
import com.shellhacks.genedubackend.model.Topic;
import com.shellhacks.genedubackend.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContentControllerImpl implements ContentController{

    @Autowired
    private ContentService contentService;

    @ResponseBody
    @RequestMapping(value = UriConstant.PATH_GET, method = RequestMethod.GET)
    public ResponseEntity<?> getEduPath(@RequestParam String p) {

        EduPath path = null;
        try {
            path = contentService.getLearningPath(p);
        } catch (InvalidInputException e) {
            return new ResponseEntity<>("Invalid input: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println("Exception while fetching ed path.");
            System.out.println(e.getMessage());
        }

        if (path != null) {
            return new ResponseEntity<>(path, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ResponseBody
    @RequestMapping(value = UriConstant.MODULE_TOPICS, method = RequestMethod.POST)
    public ResponseEntity<?> getModuleTopics(@RequestBody Module module) {

        Module result = null;
        try {
            result = contentService.getModuleTopics(module);
        } catch (InvalidInputException e) {
            return new ResponseEntity<>("Invalid input: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println("Exception while fetching module topics.");
            System.out.println(e.getMessage());
        }

        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @ResponseBody
    @RequestMapping(value = UriConstant.TOPIC_GET, method = RequestMethod.POST)
    public ResponseEntity<?> getTopicContent(@RequestBody Topic topic) {

        Topic result = null;
        try {
            result = contentService.getTopicContent(topic);
        } catch (InvalidInputException e) {
            return new ResponseEntity<>("Invalid input: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println("Exception while fetching topic content.");
            System.out.println(e.getMessage());
        }

        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ResponseBody
    @RequestMapping(value = UriConstant.TOPIC_QUIZ, method = RequestMethod.POST)
    public ResponseEntity<?> getTopicQuiz(@RequestBody Topic topic) {

        Topic result = null;
        try {
            result = contentService.getTopicQuiz(topic);
        } catch (InvalidInputException e) {
            return new ResponseEntity<>("Invalid input: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println("Exception while fetching topic content.");
            System.out.println(e.getMessage());
        }

        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
