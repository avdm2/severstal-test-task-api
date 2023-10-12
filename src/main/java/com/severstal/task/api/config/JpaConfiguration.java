package com.severstal.task.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("com.severstal.task.api.domain.entities")
public class JpaConfiguration {
}
