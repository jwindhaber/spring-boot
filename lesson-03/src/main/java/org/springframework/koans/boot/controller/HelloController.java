package org.springframework.koans.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @see RestController
 * @see RequestMapping
 *
 */
public class HelloController {

    String home() {
        return "Hello World!";
    }
}
