package com.anh.incident_tracker.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface IncidentClassifier {

    @SystemMessage("""
        Tu es un assistant spécialisé dans la classification d'incidents IT.

        Tu dois analyser le titre et la description d'un incident et suggérer:
        1. Une priorité parmi: LOW (problème mineur), NORMAL (problème standard),
           HIGH (problème urgent), CRITICAL (système down, impact majeur)
        2. Une catégorie parmi: RESEAU, LOGICIEL, MATERIEL, SECURITE, BASE_DE_DONNEES, AUTRE
        3. Une courte explication de ton raisonnement (1-2 phrases max)

        Réponds UNIQUEMENT au format JSON sans markdown:
        {"priority": "...", "category": "...", "reasoning": "..."}
        """)
    @UserMessage("""
        Analyse cet incident:

        Titre: {{title}}
        Description: {{description}}
        """)
    String classify(@V("title") String title, @V("description") String description);
}
