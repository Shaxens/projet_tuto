package fr.tradflex.process.parser;

import fr.tradflex.model.sousTitre.SousTitre;
import fr.tradflex.process.parser.timer.TimerParser;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public final class SousTitresParser {
    private final SousTitreParser sousTitreParser;

    @Autowired
    public SousTitresParser(SousTitreParser sousTitreParser) {
        this.sousTitreParser = sousTitreParser;
    }

    public String parse(Collection<SousTitre> sousTitres) {
        if (sousTitres == null) {
            throw new IllegalArgumentException("SousTitre Collection is null.");
        }
        var i = new AtomicInteger(1);
        return sousTitres.stream()
                .sorted(Comparator.comparing(SousTitre::timeCodeBegin).thenComparing(SousTitre::timeCodeEnd))
                .map(sousTitre -> new SousTitreAsParser(i.getAndIncrement(), sousTitre))
                .map(sousTitreAsParser -> sousTitreAsParser.parse(sousTitreParser))
                .collect(Collectors.joining("\n\n"));
    }

    private record SousTitreAsParser(int numero, SousTitre sousTitre) {

        private String parse(SousTitreParser sousTitreParser) {
            return sousTitreParser.parse(sousTitre, numero);
        }
    }
}
