package com.example;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@EachProperty("config")
public record Configuration(@Parameter MyEnum myEnum,
                            @NotEmpty List<@NotBlank String> cities) {

    public enum MyEnum {
        SUMMER,
        WINTER
    }
}
