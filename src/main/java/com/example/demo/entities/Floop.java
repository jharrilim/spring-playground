package com.example.demo.entities;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Floop
 */
@AllArgsConstructor
@NoArgsConstructor
public class Floop {

    @Id
    public String id;

    public int flap;
}