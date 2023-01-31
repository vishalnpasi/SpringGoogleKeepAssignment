package com.example.GoogleKeepAssignment.repositories;

import com.example.GoogleKeepAssignment.models.FolderModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface FolderRepository extends MongoRepository<FolderModel,String> {
    @Query("{id:?0}")
    List<FolderModel> findFolderById(String id);
}
