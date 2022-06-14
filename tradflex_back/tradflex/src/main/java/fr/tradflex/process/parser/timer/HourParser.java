package fr.tradflex.process.parser.timer;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
class HourParser {

    String parse(double timeCode) {
        var hour = (int) timeCode / 3600;
        var formater = new DecimalFormat("00");
        return formater.format(hour);
    }
}
