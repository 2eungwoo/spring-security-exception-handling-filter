package com.back2basics.customfilters;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("public/hello")
    public String publicHello() {
        return "Public Hello";
    }

    @GetMapping("secure/hello")
    public String secureHello() {
        return "Secure Hello";
    }

    @GetMapping("secure/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "Admin Only";
    }
}
