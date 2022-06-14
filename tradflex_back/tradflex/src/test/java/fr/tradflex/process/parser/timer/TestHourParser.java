package fr.tradflex.process.parser.timer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TestHourParser {
    @ParameterizedTest
    @CsvSource(delimiterString = " -> ", textBlock = """
             0      -> 00
             1      -> 00
             1.2    -> 00
             60     -> 00
             65     -> 00
             120    -> 00
             3600   -> 01
             3678   -> 01
             666    -> 00
             7200   -> 02
             8945   -> 02
             360000 -> 100
             """)
    void when_time_code_is_0_then_return_0_as_srt(double timeCode, String resultat) {
        Assertions.assertThat(new HourParser().parse(timeCode)).isEqualTo(resultat);
    }
}