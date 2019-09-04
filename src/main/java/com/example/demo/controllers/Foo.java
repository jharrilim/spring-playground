package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Floop;
import com.example.demo.repository.FloopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Foo
 */
@RestController
@RequestMapping("/foo")
public class Foo {

    private final FloopRepository floopRepo;

    @Autowired
    public Foo(FloopRepository floopRepo) {
        this.floopRepo = floopRepo;
    }


    @GetMapping(value = "/")
    public HashMap<String, String> index() {
        final var map = new HashMap<String, String>();
        map.put("foo", "fooooo");
        return map;
    }

    @GetMapping(value = "yeet/{who}")
    public String yeet(@PathVariable Optional<String> who) {
        if (who.isPresent())
            return "Yeeted " + who.get();
        return "Yote";
    }


    @GetMapping(value="yote")
    public Floop yote(@RequestBody Floop floop) {
        var f = new Floop() {{
            id = floop.id.toUpperCase();
        }};

        return f;
    }
    
    /**
     * Create a Floop with the given number of dabs
     * eg.
     * [GET] localhost:8080/foo/dab?dabs=10
     * 
     * ID is automatically generated
     * 
     * @param dabs
     * @return new Floop
     */
    @GetMapping(value="dab")
    public Floop dab(@RequestParam int dabs) {
        return this.floopRepo.insert(new Floop(null, 2020));
    }
    
    /**
     * Get all the Floops
     * 
     * #Thanks #dab
     * @return
     */
    @GetMapping(value="dabs")
    public List<Floop> dabs() {
        return this.floopRepo.findAll();
    }
}
