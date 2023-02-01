package com.example.GoogleKeepAssignment.controller;

import com.example.GoogleKeepAssignment.models.FolderModel;
import com.example.GoogleKeepAssignment.service.FolderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
//@RequestMapping("/note")
public class FolderController {
    @Autowired
    private FolderService service;
    @Autowired
    private WebClient.Builder webClient;
    Logger logger = LoggerFactory.getLogger(FolderController.class);
    @PostMapping("/folder")
    public ResponseEntity<FolderModel> createFolder(@RequestBody FolderModel folderModel){
        logger.info("post(/folder) api has called");
        ResponseEntity<FolderModel> response = webClient
                .baseUrl("http://localhost:8081")
                .build()
                .post()
                .uri("/folder")
                .bodyValue(folderModel)
                .retrieve().toEntity(FolderModel.class).block();
        return response;
//        return new ResponseEntity<>(service.saveFolder(folderModel), HttpStatus.CREATED);
    }
    @GetMapping("/folder/{id}")
    public FolderModel getFolderById(@PathVariable String id){
        logger.info("get(/folder) api has called");
        ResponseEntity<FolderModel> response = webClient
                .baseUrl("http://localhost:8081")
                .build()
                .get()
                .uri("/folder/{id}",id)
                .retrieve().toEntity(FolderModel.class).block();
        return response.getBody();
//        return service.findFolderById(id);
    }
    @PutMapping("/folder/{id}")
    public ResponseEntity<FolderModel> updateFolderById(@RequestBody FolderModel folderModel,@PathVariable String id){
        logger.info("put(/folder) api has called");

        ResponseEntity<FolderModel> response = webClient
                .baseUrl("http://localhost:8081")
                .build()
                .put()
                .uri("/folder/{id}",id)
                .bodyValue(folderModel)
                .retrieve().toEntity(FolderModel.class).block();
        return response;

//        return new ResponseEntity<>(service.updateFolderById(model,id),HttpStatus.OK);
    }
    @DeleteMapping("/folder/{id}")
    public ResponseEntity<String> deleteFolderById(@PathVariable String id){
        logger.info("delete(/folder) api has called");

        ResponseEntity<String> response = webClient
                .baseUrl("http://localhost:8081")
                .build()
                .delete()
                .uri("/folder/{id}",id)
                .retrieve().toEntity(String.class).block();
        return response;

//        return new ResponseEntity<>(service.deleteFolderById(id),HttpStatus.OK);
    }
}

