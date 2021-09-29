package com.example.back_end.api.controller.rest;

import com.example.back_end.api.dto.request.LessonRequestDto;
import com.example.back_end.api.dto.response.DataContainer;
import com.example.back_end.api.dto.response.LessonResponseDto;
import com.example.back_end.facade.LessonFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course/lesson")
public class LessonController {
    private final LessonFacade lessonFacade;

    public LessonController(LessonFacade lessonFacade) {
        this.lessonFacade = lessonFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<LessonResponseDto>> getLesson(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(new DataContainer(lessonFacade.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> update(@RequestBody LessonRequestDto dto, @PathVariable Long id) {
        lessonFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> delete(@PathVariable Long id) {
        lessonFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }
}
