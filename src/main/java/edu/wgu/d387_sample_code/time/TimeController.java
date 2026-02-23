package edu.wgu.d387_sample_code.time;

import java.time.LocalTime;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class TimeController {
    @GetMapping("/presentation-time")
    public String getPresentationTime() {
        LocalTime presentationTimeET = LocalTime.of(19, 30);

        String etTime = TimeConverter.convertTime(presentationTimeET, "America/New_York", "America/New_York");
        String mtTime = TimeConverter.convertTime(presentationTimeET, "America/New_York", "America/Denver");
        String utcTime = TimeConverter.convertTime(presentationTimeET, "America/New_York", "UTC");

        return "Presentation Times:<br> ET: " + etTime + "<br>" + "MT: " + mtTime + "<br>"  + "UTC: " + utcTime;
    }
}
