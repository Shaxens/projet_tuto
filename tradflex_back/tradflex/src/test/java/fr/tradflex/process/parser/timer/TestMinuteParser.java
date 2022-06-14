package fr.tradflex.process.parser.timer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TestMinuteParser {

    @ParameterizedTest
    @CsvSource(delimiterString = " -> ", textBlock = """
             0    -> 00
             1    -> 00
             1.2  -> 00
             60   -> 01
             65   -> 01
             120  -> 02
             3600 -> 00
             3678 -> 01
             666  -> 11
             """)
    void when_time_code_is_0_then_return_0_as_srt(double timeCode, String resultat) {
        Assertions.assertThat(new MinuteParser().parse(timeCode)).isEqualTo(resultat);
    }
}