package fr.tradflex.process.parser.timer;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
class MillisecondParser {

    String parse(double timeCode) {
        var timeCodeAsInt = (int) timeCode;
        var millisecond   = (1000*timeCode)-(1000*timeCodeAsInt);
        var formater = new DecimalFormat("000");
        return formater.format(millisecond);
    }
}
