package fr.tradflex.process.parser.timer;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
class MinuteParser {

    String parse(double timeCode) {

        var second = (int) timeCode % 60;
        var minute = (int) (timeCode - second) / 60;
        var formater = new DecimalFormat("00");
        return formater.format(minute % 60);
    }
}
