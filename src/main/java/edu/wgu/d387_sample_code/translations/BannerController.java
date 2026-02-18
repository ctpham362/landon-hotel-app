package edu.wgu.d387_sample_code.translations;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.ResourceBundle;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BannerController {
    @GetMapping("/api/welcome")
    public String getBanner() {
        Locale systemLocale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("banner", systemLocale);
        return rb.getString("welcomeMessage");
    }
}
