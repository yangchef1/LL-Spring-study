package com.likelion.springsession.controller;
import com.likelion.springsession.dto.request.BoxCreateRequest;
import com.likelion.springsession.dto.response.BoxGetResponse;
import com.likelion.springsession.service.BoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/box")
@RequiredArgsConstructor
public class BoxController {

    private final BoxService boxService;
    @PostMapping
    public ResponseEntity<Void> createLetterBox(@RequestBody BoxCreateRequest request, Long memberId) {
        URI location = URI.create("/api/box/" + boxService.create(request, memberId));
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{boxCode}")
    public ResponseEntity<BoxGetResponse> getBox(@PathVariable String boxCode) {
        return ResponseEntity.ok(boxService.getByCode(boxCode));
    }
}
