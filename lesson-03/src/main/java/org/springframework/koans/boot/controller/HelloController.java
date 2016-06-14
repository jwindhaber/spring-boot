package org.springframework.koans.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author juergen.windhaber on 14.06.2016.
 * @since 1.0.0
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    String home() {
        return "Hello World!";
    }
}
