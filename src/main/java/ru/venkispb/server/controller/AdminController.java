package ru.venkispb.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.venkispb.server.entity.Admin;
import ru.venkispb.server.entity.Product;
import ru.venkispb.server.repository.AdminRepository;

import java.util.ArrayList;
import java.util.List;

@RestController("/admins")
public class AdminController {

    private final AdminRepository repository;

    public AdminController(AdminRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/")
    public List<Admin> getAll() {
        List<Admin> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @PostMapping(value = "/")
    public ResponseEntity create(@RequestBody Admin admin) {
        repository.save(admin);
        return ResponseEntity.ok().build();
    }

}
