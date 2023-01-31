package com.example.GoogleKeepAssignment.service;

import com.example.GoogleKeepAssignment.models.FolderModel;
import com.example.GoogleKeepAssignment.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FolderService {
    @Autowired
    private FolderRepository repository;

    public FolderModel saveFolder(FolderModel model) {
        return repository.save(model);
    }
    public FolderModel findFolderById(String id){
        return repository.findFolderById(id).get(0);
    }
    public FolderModel updateFolderById(FolderModel model ,String id){
        Optional<FolderModel> list = repository.findById(id);
        if(list.isEmpty()) return null;

        FolderModel newfolder = list.get();
        if(model.getTitle()!=null)newfolder.setTitle(model.getTitle());
        if(model.getDescription()!=null) newfolder.setDescription(model.getDescription());

        return repository.save(newfolder);
    }
    public String deleteFolderById(String id){

        Optional<FolderModel> folder=repository.findById(id);
        if(folder.isEmpty()) return "Data Not Found";

        repository.deleteById(id);
        return "Deleted Successfully";
    }
}
