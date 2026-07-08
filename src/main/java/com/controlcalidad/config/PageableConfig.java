package com.controlcalidad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

@Configuration
public class PageableConfig {

    @Bean
    public Module pageModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Page.class, new JsonSerializer<Page>() {
            @Override
            public void serialize(Page page, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeStartObject();
                gen.writeObjectField("content", page.getContent());
                gen.writeNumberField("totalElements", page.getTotalElements());
                gen.writeNumberField("totalPages", page.getTotalPages());
                gen.writeNumberField("size", page.getSize());
                gen.writeNumberField("number", page.getNumber());
                gen.writeNumberField("numberOfElements", page.getNumberOfElements());
                gen.writeBooleanField("first", page.isFirst());
                gen.writeBooleanField("last", page.isLast());
                gen.writeBooleanField("empty", page.isEmpty());
                gen.writeEndObject();
            }
        });
        return module;
    }
}
