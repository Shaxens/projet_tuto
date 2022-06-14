package fr.tradflex.process.parser.timer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TestMillisecondParser {


    @ParameterizedTest
    @CsvSource(delimiterString = " -> ", textBlock = """
             0     -> 000
             1     -> 000
             1.2   -> 200
             60.3  -> 300
             0.21  -> 210
             0.123 -> 123
             0.009 -> 009
             """)
    void when_time_code_is_0_then_return_0_as_srt(double timeCode, String resultat) {
        Assertions.assertThat(new MillisecondParser().parse(timeCode)).isEqualTo(resultat);
    }
}