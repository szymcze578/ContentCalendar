package pl.szymcze.contentcalendar.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szymcze.contentcalendar.config.ContentCalendarProperties;

import java.util.Map;

@RestController
public class HomeController {

    private final ContentCalendarProperties calendarProperties;

    public HomeController(ContentCalendarProperties calendarProperties) {
        this.calendarProperties = calendarProperties;
    }

    @GetMapping
    public ContentCalendarProperties hello(){
        return calendarProperties;
    }
}
