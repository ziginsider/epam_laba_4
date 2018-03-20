package io.github.ziginsider.epam_laba_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Activity that displays LogCat logs on screen.
 *
 * <p>LogCat consists a result of checking {@link MyHashMap}, {@link MyArrayList},
 * {@link MyLinkedList}
 *
 * @author Alex Kisel
 * @since 2018-03-20
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logCatToScreen();
        check();
    }

    private void logCatToScreen() {
        try {
            Process process = Runtime.getRuntime().exec("logcat -d");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            StringBuilder log = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }
            TextView tv = (TextView) findViewById(R.id.text_view);
            tv.setText("LogCat: " + log.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void check() {
        CheckImplementations c = new CheckImplementations();
        c.launchCkekingMyHashMap();
        c.launchCkekingMyArrayList();
        c.launchCkekingMyLinkedList();
    }
}