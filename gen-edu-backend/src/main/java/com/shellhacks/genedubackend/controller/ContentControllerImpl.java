package com.shellhacks.genedubackend.controller;

import com.shellhacks.genedubackend.constant.UriConstant;
import com.shellhacks.genedubackend.exception.InvalidInputException;
import com.shellhacks.genedubackend.model.EduPath;
import com.shellhacks.genedubackend.service.ContentService;
import com.shellhacks.genedubackend.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ContentControllerImpl {

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

}
