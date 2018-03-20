package io.github.ziginsider.epam_laba_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

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















        /*MyLinkedList*/


        Log.d(TAG, "check: start check MyLinkedList with Integer elements");
        List<Integer> myIntLinkedList = new MyLinkedList<>();
        if (myIntLinkedList.isEmpty()) {
            Log.d(TAG, "check: myIntLinkedList is empty");
        }
        for (int i = 1; i < 25; i++) {
            Log.d(TAG, "check: Into myIntLinkedList add integer element = " + i);
            myIntLinkedList.add(i);
        }
        for (int i = 0; i < myIntLinkedList.size(); i++) {
            Log.d(TAG, "check: get integer element with index "
                    + i + " = " + myIntLinkedList.get(i).toString());
        }

        Log.d(TAG, "check: MyLinkedList::set(int index, T element)");
        myIntLinkedList.set(4, 20);
        myIntLinkedList.set(23, 33);
        for (int i = 0; i < myIntLinkedList.size(); i++) {
            Log.d(TAG, "check: get integer element with index "
                    + i + " = " + myIntLinkedList.get(i).toString());
        }

        Log.d(TAG, "check: MyLinkedList::add(int index, T element)");
        myIntLinkedList.add(0, 55);
        myIntLinkedList.add(0, 66);
        myIntLinkedList.add(0, 77);
        myIntLinkedList.add(10, 111);
        myIntLinkedList.add(10, 222);
        myIntLinkedList.add(10, 333);
        for (int i = 0; i < myIntLinkedList.size(); i++) {
            Log.d(TAG, "check: get integer element with index "
                    + i + " = " + myIntLinkedList.get(i).toString());
        }

        Log.d(TAG, "check: MyLinkedList::remove(int index)");
        myIntLinkedList.remove(5);
        myIntLinkedList.remove(20);
        for (int i = 0; i < myIntLinkedList.size(); i++) {
            Log.d(TAG, "check: get integer element with index "
                    + i + " = " + myIntLinkedList.get(i).toString());
        }

        Log.d(TAG, "check: MyLinkedList::remove(Object object)");
        myIntLinkedList.remove((Integer) 77);
        myIntLinkedList.remove((Integer) 333);
        myIntLinkedList.remove((Integer) 4444);
        for (int i = 0; i < myIntLinkedList.size(); i++) {
            Log.d(TAG, "check: get integer element with index "
                    + i + " = " + myIntLinkedList.get(i).toString());
        }

        Log.d(TAG, "check: MyLinkedList::Iterator");
        for (Integer integer : myIntLinkedList) {
            Log.d(TAG, "check: iterator integer element = " + integer);
        }

        myIntLinkedList.clear();

        Log.d(TAG, "check: MyLinkedList::clear()");
        for (Integer integer : myIntLinkedList) {
            Log.d(TAG, "check: iterator integer element = " + integer);
        }

        //MyHashMap
        CheckImplementations c = new CheckImplementations();
        c.launchCkekingMyHashMap();
    }
}
