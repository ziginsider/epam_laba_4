package io.github.ziginsider.epam_laba_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check();
    }

    private void check() {
        Log.d(TAG, "check: start check MyArrayList with Integer elements");
        List<Integer> myIntArray = new MyArrayList<>();
        for (int i = 1; i < 25; i++) {
            Log.d(TAG, "check: add integer element = " + i);
            myIntArray.add(i);
        }
        for (int i = 0; i < 24; i++) {
            Log.d(TAG, "check: get integer element with index "
                    + i + " = " + myIntArray.get(i).toString());
        }

        Log.d(TAG, "check: start check MyArrayList with String elements");
        List<String> myStringArray = new MyArrayList<>();
        String[] strings = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven", "Twelve"};
        for (int i = 0; i < 12; i++) {
            Log.d(TAG, "check: add string element = " + strings[i]);
            myStringArray.add(strings[i]);
        }
        for (int i = 0; i < 12; i++) {
            Log.d(TAG, "check: get string element with index "
                    + i + " = " + myStringArray.get(i));
        }
    }
}
