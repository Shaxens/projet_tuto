package fr.tradflex.process.parser.timer;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.NumberFormat;

@Component
class SecondParser {

    String parse(double timeCode) {
        var second = (int) timeCode % 60;
        var formater = new DecimalFormat("00");
        return formater.format(second);
    }
}
