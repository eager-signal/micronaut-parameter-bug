package com.example;

import io.micronaut.context.annotation.Property;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
@Property(name ="config.summer.cities", value = "barcelona,atlanta,sydney")
@Property(name = "config.winter.cities", value = "albertville,lillehammer,nagano")
public class ConfigurationTest {

    @Inject
    private List<Configuration> configs;

    @Test
    void testEnumParameter() {
        assertEquals(2, configs.size());
        assertTrue(configs.contains(new Configuration(Configuration.MyEnum.SUMMER, List.of("barcelona", "atlanta", "sydney"))));
        assertTrue(configs.contains(new Configuration(Configuration.MyEnum.WINTER, List.of("albertville", "lillehammer", "nagano"))));
    }
}
