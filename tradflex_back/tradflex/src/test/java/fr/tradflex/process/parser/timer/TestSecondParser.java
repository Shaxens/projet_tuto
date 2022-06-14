package fr.tradflex.process.parser.timer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TestSecondParser {

    @ParameterizedTest
    @CsvSource(delimiterString = " -> ", textBlock = """
             0    -> 00
             1    -> 01
             1.2  -> 01
             45   -> 45
             60   -> 00
             75   -> 15
             3600 -> 00
             """)
    void when_time_code_is_0_then_return_0_as_srt(double timeCode, String resultat) {
        Assertions.assertThat(new SecondParser().parse(timeCode)).isEqualTo(resultat);
    }
}