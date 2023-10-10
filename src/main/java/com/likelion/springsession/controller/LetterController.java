package com.likelion.springsession.controller;

import com.likelion.springsession.dto.request.LetterCreateRequest;
import com.likelion.springsession.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/letter")
@RequiredArgsConstructor
public class LetterController {

    private LetterService letterService;

    @PostMapping
    public ResponseEntity<Void> sendLetter(@RequestBody LetterCreateRequest request) {
        String letterId = letterService.create(request);
        URI location = URI.create("/api/letter/" + letterId);
        return ResponseEntity.created(location).build();
    }
}
