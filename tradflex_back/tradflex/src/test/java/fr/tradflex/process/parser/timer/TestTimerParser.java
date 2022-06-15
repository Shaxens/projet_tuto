package fr.tradflex.process.parser.timer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestTimerParser {

    @Autowired
    private TimerParser timerParser;

    @ParameterizedTest
    @CsvSource(delimiterString = " -> ", textBlock = """
             0    -> 00:00:00,000
             1    -> 00:00:01,000
             1.2  -> 00:00:01,200
             60   -> 00:01:00,000
             3600 -> 01:00:00,000
             """)
    void when_time_code_is_0_then_return_0_as_srt(double timeCode, String resultat) {
        Assertions.assertThat(timerParser.parse(timeCode)).isEqualTo(resultat);
    }
}