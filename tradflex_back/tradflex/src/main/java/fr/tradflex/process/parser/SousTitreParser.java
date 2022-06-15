package fr.tradflex.process.parser;

import fr.tradflex.model.sousTitre.SousTitre;
import fr.tradflex.process.parser.timer.TimerParser;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
final class SousTitreParser {
    private final TimerParser timerParser;

    @Autowired
    SousTitreParser(TimerParser timerParser) {
        this.timerParser = timerParser;
    }

    String parse(SousTitre sousTitre, int numeroSousTitre) {
        return new StringSubstitutor(Map.of(
                "numero", numeroSousTitre,
                "timeCodeBegin", timerParser.parse(sousTitre.timeCodeBegin()),
                "timeCodeEnd", timerParser.parse(sousTitre.timeCodeEnd()),
                "body", sousTitre.body())
        ).replace("""
                ${numero}
                ${timeCodeBegin} --> ${timeCodeEnd}
                ${body}""");
    }
}
