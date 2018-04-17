package org.springframework.koans.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @see RestController
 *
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    String home() {
        return "Hello World!";
    }
}
