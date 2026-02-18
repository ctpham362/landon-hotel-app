package edu.wgu.d387_sample_code.translations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class WelcomeBanner implements CommandLineRunner {
    @Override
    public void run(String... args) {
        Locale systemLocale = Locale.getDefault();
        final String[] messageHolder = new String[1];

        Thread thread1 = new Thread(() -> {
            ResourceBundle rb = ResourceBundle.getBundle("banner", systemLocale);
            messageHolder[0] = rb.getString("welcomeMessage");
        });

        Thread thread2 = new Thread(() -> {
            String temp = messageHolder[0];
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(messageHolder[0]);
    }
}
