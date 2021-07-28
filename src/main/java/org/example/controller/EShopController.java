package org.example.controller;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EShopController {

    @Autowired
    private Tracer tracer;

    public EShopController(Tracer tracer) {
        this.tracer = tracer;
    }

    @GetMapping("/checkout")
    public String checkout() throws InterruptedException {
        Span span = tracer.buildSpan("checkout").start();
        Thread.sleep(3000);
        span.finish();
        return "You have successfully checked out your shopping cart.";
    }
}
