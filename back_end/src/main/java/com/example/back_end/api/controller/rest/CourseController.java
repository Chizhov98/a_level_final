package com.example.back_end.api.controller.rest;

import com.example.back_end.api.dto.request.CourseRequestDto;
import com.example.back_end.api.dto.response.CourseResponseDto;
import com.example.back_end.api.dto.response.DataContainer;
import com.example.back_end.facade.CourseFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseFacade courseFacade;

    public CourseController(CourseFacade courseFacade) {
        this.courseFacade = courseFacade;
    }

    @GetMapping("/all")
    public ResponseEntity<DataContainer<List<CourseResponseDto>>> getAllCourses() {
        List<CourseResponseDto> courses = courseFacade.findAll();
        return ResponseEntity.ok(new DataContainer(courses));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataContainer<CourseResponseDto>> getById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(new DataContainer(courseFacade.findById(id)));
    }

    @PostMapping
    public ResponseEntity<DataContainer<Boolean>> create(@RequestBody CourseRequestDto dto) {
        courseFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DataContainer(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> update(@RequestBody CourseRequestDto dto, @PathVariable Long id) {
        courseFacade.update(id, dto);
        return ResponseEntity.ok(new DataContainer(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataContainer<Boolean>> delete(@PathVariable Long id) {
        courseFacade.delete(id);
        return ResponseEntity.ok(new DataContainer<>(true));
    }

    @GetMapping("/all/{title}")
    public ResponseEntity<DataContainer<CourseResponseDto>> getByTitle(@PathVariable String title) {
        return ResponseEntity.ok(new DataContainer(courseFacade.findAllByTitleIsLike(title)));
    }

}
