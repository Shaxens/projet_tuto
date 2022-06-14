package fr.tradflex.process.parser.timer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TestTimerParser {

    @ParameterizedTest
    @CsvSource(delimiterString = " -> ", textBlock = """
             0    -> 00:00:00,000
             1    -> 00:00:01,000
             1.2  -> 00:00:01,200
             60   -> 00:01:00,000
             3600 -> 01:00:00,000
             """)
    void when_time_code_is_0_then_return_0_as_srt(double timeCode, String resultat) {
        Assertions.assertThat(new TimerParser(new HourParser(), new MinuteParser(), new SecondParser(), new MillisecondParser()).parse(timeCode)).isEqualTo(resultat);
    }
}