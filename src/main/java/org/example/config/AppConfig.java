package org.example.config;

import io.jaegertracing.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class AppConfig {

    @Bean
    public io.opentracing.Tracer getTracer() {
        Configuration.SamplerConfiguration samplerConfig = new Configuration.SamplerConfiguration()
                .withType("const").withParam(1);
        return Configuration.fromEnv("E Shop")
                .withSampler(samplerConfig).getTracer();
    }

}
