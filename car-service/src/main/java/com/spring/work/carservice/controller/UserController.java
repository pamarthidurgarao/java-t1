package com.spring.work.carservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.work.carservice.entity.User;
import com.spring.work.carservice.model.Filter;
import com.spring.work.carservice.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/user")
@Api(tags = "User API")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
	return new ResponseEntity<>(service.save(user), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
	return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
	return new ResponseEntity<>(service.save(user), HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<User>> search(@RequestBody Filter filter) {

	return new ResponseEntity<>(service.search(filter), HttpStatus.OK);

    }

    @GetMapping("/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
	return new ResponseEntity<>(service.getByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<List<User>> findByName(@RequestParam String firstName) {
	return new ResponseEntity<>(service.findByFirstName(firstName), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
	service.deleteById(id);
    }

}
