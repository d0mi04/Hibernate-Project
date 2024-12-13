package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Używam po to, żeby być w stanie otworzyć konsolę zanim program skończy swoje działanie
public class StatusController {

    // to jest dodanie endpointa
    @GetMapping("/status")
    public String status() {
        return "Application is running";
    }
}
