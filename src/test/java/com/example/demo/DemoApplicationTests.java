package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import com.example.demo.controllers.Foo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private Foo foo;

	@Test
	public void yeetus() {
        assertNotNull(foo);
	}

    @Test
    public void doStuff() {
        var yeeter = Optional.of("yeeter");
        var actual = foo.yeet(yeeter);
        var expected = "Yeeted yeeter";
        assertEquals(expected, actual);
    }
}
