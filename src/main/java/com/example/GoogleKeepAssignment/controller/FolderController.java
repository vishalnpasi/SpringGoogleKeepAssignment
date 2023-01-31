package com.example.GoogleKeepAssignment.controller;

import com.example.GoogleKeepAssignment.models.FolderModel;
import com.example.GoogleKeepAssignment.service.FolderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FolderController {
    @Autowired
    private FolderService service;
    Logger logger = LoggerFactory.getLogger(FolderController.class);
    @PostMapping("/folder")
    public ResponseEntity<FolderModel> createFolder(@RequestBody FolderModel model){
        logger.info("post(/folder) api has called");
        return new ResponseEntity<>(service.saveFolder(model), HttpStatus.CREATED);
    }
    @GetMapping("/folder/{id}")
    public ResponseEntity<FolderModel> getFolderById(@PathVariable String id){
        logger.info("get(/folder) api has called");
        return new ResponseEntity<>(service.findFolderById(id),HttpStatus.OK);
    }
    @PutMapping("/folder/{id}")
    public ResponseEntity<FolderModel> updateFolderById(@RequestBody FolderModel model,@PathVariable String id){
        logger.info("put(/folder) api has called");

        return new ResponseEntity<>(service.updateFolderById(model,id),HttpStatus.OK);
    }
    @DeleteMapping("/folder/{id}")
    public ResponseEntity<String> deleteFolderById(@PathVariable String id){
        logger.info("delete(/folder) api has called");

        return new ResponseEntity<>(service.deleteFolderById(id),HttpStatus.OK);
    }
}
