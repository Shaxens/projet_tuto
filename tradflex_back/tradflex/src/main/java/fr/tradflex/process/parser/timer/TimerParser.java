package fr.tradflex.process.parser.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimerParser {

    private final HourParser        hour;
    private final MinuteParser      minute;
    private final SecondParser      second;
    private final MillisecondParser millisecond;

    @Autowired
    public TimerParser(HourParser hour, MinuteParser minute, SecondParser second, MillisecondParser millisecond) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.millisecond = millisecond;
    }

    public String parse(double timeCode)
    {
        return hour.parse(timeCode) + ":" + minute.parse(timeCode) + ":" + second.parse(timeCode) + "," + millisecond.parse(timeCode);
    }
}
