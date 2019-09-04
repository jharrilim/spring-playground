package com.example.demo.repository;

import com.example.demo.entities.Floop;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * FloopRepository
 */
public interface FloopRepository extends MongoRepository<Floop, String> {

        public Floop findByFlap(int flap);

}