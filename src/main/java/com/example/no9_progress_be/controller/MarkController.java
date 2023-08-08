package com.example.no9_progress_be.controller;

import com.example.no9_progress_be.model.StudentSubject;
import com.example.no9_progress_be.payload.request.MarkRequest;
import com.example.no9_progress_be.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/marks")
public class MarkController {

    @Autowired
    private MarkRepository markRepository;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<StudentSubject>> getStudentsByMark(@RequestParam double mark){
        return ResponseEntity.ok(markRepository.findByMark(mark));
    }

//    public ResponseEntity<> addMarkForStudent(@RequestBody MarkRequest markRequest){
//
//    }

}
