package com.akatsuki.stackit.controllers;

import com.akatsuki.stackit.domain.dto.CreateTagRequest;
import com.akatsuki.stackit.domain.dto.TagDto;
import com.akatsuki.stackit.domain.entities.Tag;
import com.akatsuki.stackit.mappers.TagMapper;
import com.akatsuki.stackit.service.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagDto>> getAllTags() {
        List<Tag> tags = tagService.getTags();
        List<TagDto> tagResponse = tags.stream()
                .map(tagMapper::toDto)
                .toList();
        return ResponseEntity.ok(tagResponse);
    }

    @PostMapping
    public ResponseEntity<List<TagDto>> createTags(
            @Valid @RequestBody CreateTagRequest createTagRequest) {
        List<Tag> savedTags = tagService.createTags(createTagRequest.getNames());
        List<TagDto> createdTagResponse = savedTags.stream()
                .map(tagMapper::toDto)
                .toList();

        return new ResponseEntity<>(createdTagResponse, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable UUID id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }
}
