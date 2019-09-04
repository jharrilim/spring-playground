package com.example.demo.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FooTests {

    @Autowired
    private Foo foo;

    @Test
    public void doStuff() {
        var yeeter = Optional.of("yeeter");
        var actual = foo.yeet(yeeter);
        var expected = "Yeeted yeeter";
        assertEquals(expected, actual);
    }
}
