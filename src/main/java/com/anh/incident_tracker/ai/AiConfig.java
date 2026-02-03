package com.anh.incident_tracker.ai;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public IncidentClassifier incidentClassifier(ChatLanguageModel chatLanguageModel) {
        return AiServices.builder(IncidentClassifier.class)
                .chatLanguageModel(chatLanguageModel)
                .build();
    }
}
