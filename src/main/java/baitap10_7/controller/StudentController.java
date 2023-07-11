package baitap10_7.controller;

import baitap10_7.model.Student;
import baitap10_7.service.StudentServiceIMPL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;


@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    @Inject
    private StudentServiceIMPL studentServiceIMPL;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(studentServiceIMPL.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Student student) {
        return new ResponseEntity<>(studentServiceIMPL.save(student), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        if (studentServiceIMPL.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        if (studentServiceIMPL.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentServiceIMPL.findById(id), HttpStatus.OK);
    }
}
