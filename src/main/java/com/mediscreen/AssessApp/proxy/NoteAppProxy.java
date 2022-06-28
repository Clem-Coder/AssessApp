package com.mediscreen.AssessApp.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@FeignClient( contextId = "Note", name="noteApp", url="http://localhost:8082")
public interface NoteAppProxy {

    @GetMapping("/patHistory/notes/get/{id}")
    public List<String> getNotesById(@PathVariable Integer id);

}
