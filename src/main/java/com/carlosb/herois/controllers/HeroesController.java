package com.carlosb.herois.controllers;

import com.carlosb.herois.domain.Heroes;
import com.carlosb.herois.servicies.HeroesServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/heroes")
public class HeroesController {

    @Autowired
    private HeroesServicies service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Heroes> findById(@PathVariable Integer id){
        Heroes obj = service.findBy(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Heroes obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Heroes obj, @PathVariable Integer id){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Heroes>> findAll(){
        List<Heroes> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

}
