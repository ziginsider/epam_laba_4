package io.github.ziginsider.epam_laba_4;

import android.util.Log;

import java.util.List;
import java.util.Map;

/**
 * Created by zigin on 20.03.2018.
 */

public class CheckImplementations {
    private static final String TAG = CheckImplementations.class.getSimpleName();

    Map<String, String> myHashMap = new MyHashMap<>();
    List<Integer> myIntArray = new MyArrayList<>();
    List<String> myStringArray = new MyArrayList<>();
    List<Integer> myIntLinkedList = new MyLinkedList<>();

    public void launchCkekingMyHashMap() {
        checkIsEmptyMyHashMap();
        checkSizeMyHashMap();
        checkPutMyHashMap();
        checkIsEmptyMyHashMap();
        checkSizeMyHashMap();
        checkGetMyHashMap();
        checkContainsKeyMyHashMap();
        checkContainsValueKeyMyHashMap();
        checkSizeMyHashMap();
        checkRemoveMyHashMap();
        checkSizeMyHashMap();
        checkGetMyHashMap();
        checkValuesMyHashMap();
        checkClearMyHashMap();
        checkValuesMyHashMap();
    }

    public void launchCkekingMyLinkedList() {
        checkISEmptyMyLinkedList();
        checkAddMyLinkedList();
        checkGetMyLinkedList();
        checkSetMyLinkedList();
        checkAddIndexMyLinkedList();
        checkRemoveMyLinkedList();
        checkRemoveObjectMyLinkedList();
        checkIteratorMyLinkedList();
        checkClearMyLinkedList();
    }

    public void launchCkekingMyArrayList() {
        checkIsEmptyMyArrayList();
        checkAddMyArrayList();
        checkGetMyArrayList();
        checkSetMyArrayList();
        checkAddIndexMyArrayList();
        checkAddStringMyArrayList();
        checkGetStringMyArrayList();
        checkIteratorMyArrayList();
        checkClearMyArrayList();
    }

    private void checkISEmptyMyLinkedList() {
        Log.d(TAG, "checkISEmptyMyLinkedList: isEmpty = " + myIntLinkedList.isEmpty());
    }

    private void checkAddMyLinkedList() {
        Log.d(TAG, "checkAddMyLinkedList: begin");
        for (int i = 1; i < 25; i++) {
            Log.d(TAG, "checkAddMyLinkedList: element = " + i);
            myIntLinkedList.add(i);
        }
        Log.d(TAG, "checkAddMyLinkedList: end");
    }

    private void checkGetMyLinkedList() {
        Log.d(TAG, "checkGetMyLinkedList: begin");
        for (int i = 0; i < myIntLinkedList.size(); i++) {
            Log.d(TAG, "checkGetMyLinkedList: index = " + i
                    + ", element = " + myIntLinkedList.get(i).toString());
        }
        Log.d(TAG, "checkGetMyLinkedList: end");
    }

    private void checkSetMyLinkedList() {
        Log.d(TAG, "checkSetMyLinkedList: begin");
        myIntLinkedList.set(4, 20);
        myIntLinkedList.set(23, 33);
        for (int i = 0; i < myIntLinkedList.size(); i++) {
            Log.d(TAG, "checkSetMyLinkedList: index = " + i
                    + ", element = " + myIntLinkedList.get(i).toString());
        }
        Log.d(TAG, "checkSetMyLinkedList: end");
    }

    private void checkAddIndexMyLinkedList() {
        Log.d(TAG, "checkAddIndexMyLinkedList: begin");
        myIntLinkedList.add(0, 55);
        myIntLinkedList.add(0, 66);
        myIntLinkedList.add(0, 77);
        myIntLinkedList.add(10, 111);
        myIntLinkedList.add(10, 222);
        myIntLinkedList.add(10, 333);
        for (int i = 0; i < myIntLinkedList.size(); i++) {
            Log.d(TAG, "checkAddIndexMyLinkedList: index = " + i
                    + ", element = " + myIntLinkedList.get(i).toString());
        }
        Log.d(TAG, "checkAddIndexMyLinkedList: end");
    }

    private void checkRemoveMyLinkedList() {
        Log.d(TAG, "checkRemoveMyLinkedList: begin");
        myIntLinkedList.remove(5);
        myIntLinkedList.remove(20);
        for (int i = 0; i < myIntLinkedList.size(); i++) {
            Log.d(TAG, "checkRemoveMyLinkedList: index = " + i
                    + ", element = " + myIntLinkedList.get(i).toString());
        }
        Log.d(TAG, "checkRemoveMyLinkedList: end");
    }

    private void checkRemoveObjectMyLinkedList() {
        Log.d(TAG, "checkRemoveObjectMyLinkedList: begin");
        myIntLinkedList.remove((Integer) 77);
        myIntLinkedList.remove((Integer) 333);
        myIntLinkedList.remove((Integer) 4444);
        for (int i = 0; i < myIntLinkedList.size(); i++) {
            Log.d(TAG, "checkRemoveObjectMyLinkedList: index = " + i
                    + ", element = " + myIntLinkedList.get(i).toString());
        }
        Log.d(TAG, "checkRemoveObjectMyLinkedList: end");
    }

    private void checkIteratorMyLinkedList() {
        Log.d(TAG, "checkIteratorMyLinkedList: begin");
        for (Integer element : myIntLinkedList) {
            Log.d(TAG, "checkIteratorMyLinkedList: element = " + element);
        }
        Log.d(TAG, "checkIteratorMyLinkedList: end");
    }

    private void checkClearMyLinkedList() {
        Log.d(TAG, "checkClearMyLinkedList: begin");
        myIntLinkedList.clear();
        for (Integer element : myIntLinkedList) {
            Log.d(TAG, "checkClearMyLinkedList: element = " + element);
        }
        Log.d(TAG, "checkClearMyLinkedList: end");
    }

    private void checkIsEmptyMyHashMap() {
        Log.d(TAG, "checkIsEmptyMyHashMap: " + myHashMap.isEmpty());
    }

    private void checkSizeMyHashMap() {
        Log.d(TAG, "checkSizeMyHashMap: size = " + myHashMap.size());
    }

    private void checkPutMyHashMap() {
        Log.d(TAG, "checkPutMyHashMap: begin");
        Log.d(TAG, "checkPutMyHashMap: put(\"key1\", \"One\") = "
                + myHashMap.put("key1", "One"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key2\", \"Two\") = "
                + myHashMap.put("key2", "Two"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key3\", \"Three\") = "
                + myHashMap.put("key3", "Three"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key4\", \"Four\") = "
                + myHashMap.put("key4", "Four"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key5\", \"Five\") = "
                + myHashMap.put("key5", "Five"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key6\", \"Six\") = "
                + myHashMap.put("key6", "Six"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key7\", \"Seven\")= "
                + myHashMap.put("key7", "Seven"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key8\", \"Eight\") = "
                + myHashMap.put("key8", "Eight"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key9\", \"Nine\") = "
                + myHashMap.put("key9", "Nine"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key10\",\"Ten\") = "
                + myHashMap.put("key10", "Ten"));
        Log.d(TAG, "checkPutMyHashMap: put(null, \"First Null\") = "
                + myHashMap.put(null, "First Null"));
        Log.d(TAG, "checkPutMyHashMap: put(null, \"Second Null\") = "
                + myHashMap.put(null, "Second Null"));
        Log.d(TAG, "checkPutMyHashMap: end");
    }

    private void checkGetMyHashMap() {
        Log.d(TAG, "checkGetMyHashMap: begin");
        Log.d(TAG, "checkGetMyHashMap: key1 = " + myHashMap.get("key1"));
        Log.d(TAG, "checkGetMyHashMap: key2 = " + myHashMap.get("key2"));
        Log.d(TAG, "checkGetMyHashMap: key3 = " + myHashMap.get("key3"));
        Log.d(TAG, "checkGetMyHashMap: key4 = " + myHashMap.get("key4"));
        Log.d(TAG, "checkGetMyHashMap: key5 = " + myHashMap.get("key5"));
        Log.d(TAG, "checkGetMyHashMap: key6 = " + myHashMap.get("key6"));
        Log.d(TAG, "checkGetMyHashMap: key7 = " + myHashMap.get("key7"));
        Log.d(TAG, "checkGetMyHashMap: key8 = " + myHashMap.get("key8"));
        Log.d(TAG, "checkGetMyHashMap: key9 = " + myHashMap.get("key9"));
        Log.d(TAG, "checkGetMyHashMap: key10 = " + myHashMap.get("key10"));
        Log.d(TAG, "checkGetMyHashMap: key11 = " + myHashMap.get("key11"));
        Log.d(TAG, "checkGetMyHashMap: key12 = " + myHashMap.get("key12"));
        Log.d(TAG, "checkGetMyHashMap: key13 = " + myHashMap.get("key13"));
        Log.d(TAG, "checkGetMyHashMap: null = " + myHashMap.get(null));
        Log.d(TAG, "checkGetMyHashMap: null = " + myHashMap.get(null));
        Log.d(TAG, "checkGetMyHashMap: end");
    }

    private void checkContainsKeyMyHashMap() {
        Log.d(TAG, "checkContainsKeyMyHashMap: begin");
        Log.d(TAG, "checkContainsKeyMyHashMap: key = \"key1\" = "
                + myHashMap.containsKey("key1"));
        Log.d(TAG, "checkContainsKeyMyHashMap: key = \"key5\" = "
                + myHashMap.containsKey("key5"));
        Log.d(TAG, "checkContainsKeyMyHashMap: key = \"key10\" = "
                + myHashMap.containsKey("key10"));
        Log.d(TAG, "checkContainsKeyMyHashMap: key = \"key12\" = "
                + myHashMap.containsKey("key12"));
        Log.d(TAG, "checkContainsKeyMyHashMap: key = \"key20\" = "
                + myHashMap.containsKey("key20"));
        Log.d(TAG, "checkContainsKeyMyHashMap: key = null = "
                + myHashMap.containsKey(null));
        Log.d(TAG, "checkContainsKeyMyHashMap: end");
    }

    private void checkContainsValueKeyMyHashMap() {
        Log.d(TAG, "checkContainsValueKeyMyHashMap: begin");
        Log.d(TAG, "checkContainsValueKeyMyHashMap: value = \"One\" = "
                + myHashMap.containsValue("One"));
        Log.d(TAG, "checkContainsValueKeyMyHashMap: value = \"Two\" = "
                + myHashMap.containsValue("Two"));
        Log.d(TAG, "checkContainsValueKeyMyHashMap: value = \"Three\" = "
                + myHashMap.containsValue("Three"));
        Log.d(TAG, "checkContainsValueKeyMyHashMap: value = \"Forty\" = "
                + myHashMap.containsValue("Forty"));
        Log.d(TAG, "checkContainsValueKeyMyHashMap: value = \"Zero\" = "
                + myHashMap.containsValue("Zero"));
        Log.d(TAG, "checkContainsValueKeyMyHashMap: value = null = "
                + myHashMap.containsValue(null));
        Log.d(TAG, "checkContainsValueKeyMyHashMap: end");
    }

    private void checkRemoveMyHashMap() {
        Log.d(TAG, "checkRemoveMyHashMap: begin");
        Log.d(TAG, "checkRemoveMyHashMap: key = \"key1\" = " + myHashMap.remove("key1"));
        Log.d(TAG, "checkRemoveMyHashMap: key = \"key2\" = " + myHashMap.remove("key2"));
        Log.d(TAG, "checkRemoveMyHashMap: key = \"key5\" = " + myHashMap.remove("key5"));
        Log.d(TAG, "checkRemoveMyHashMap: key = null = " + myHashMap.remove(null));
        Log.d(TAG, "checkRemoveMyHashMap: end");
    }

    private void checkValuesMyHashMap() {
        Log.d(TAG, "checkValuesMyHashMap: begin");
        List<String> collection = (List<String>) myHashMap.values();
        for (String s : collection) {
            Log.d(TAG, "checkValuesMyHashMap: value = " + s);
        }
        Log.d(TAG, "checkValuesMyHashMap: end");
    }

    private void checkClearMyHashMap() {
        Log.d(TAG, "checkClearMyHashMap: begin");
        myHashMap.clear();
        Log.d(TAG, "checkClearMyHashMap: end");
    }

    private void checkIsEmptyMyArrayList() {
        Log.d(TAG, "checkIsEmptyMyArrayList: " + myIntArray.isEmpty());
    }

    private void checkAddMyArrayList() {
        Log.d(TAG, "checkAddMyArrayList: begin");
        for (int i = 1; i < 25; i++) {
            Log.d(TAG, "checkAddMyArrayList: add element = " + i);
            myIntArray.add(i);
        }
        Log.d(TAG, "checkAddMyArrayList: end");
    }

    private void checkGetMyArrayList() {
        Log.d(TAG, "checkGetMyArrayList: begin");
        for (int i = 0; i < myIntArray.size(); i++) {
            Log.d(TAG, "checkGetMyArrayList: index = " + i
                    + ", element = " + myIntArray.get(i).toString());
        }
        Log.d(TAG, "checkGetMyArrayList: end");
    }

    private void checkSetMyArrayList() {
        Log.d(TAG, "checkSetMyArrayList: begin");
        myIntArray.set(4, 20);
        myIntArray.set(23, 33);
        for (int i = 0; i < myIntArray.size(); i++) {
            Log.d(TAG, "checkSetMyArrayList: index = " + i
                    + ", element = " + myIntArray.get(i).toString());
        }
        Log.d(TAG, "checkSetMyArrayList: end");
    }

    private void checkAddIndexMyArrayList() {
        Log.d(TAG, "checkAddIndexMyArrayList: begin");
        myIntArray.add(0, 55);
        myIntArray.add(0, 66);
        myIntArray.add(0, 77);
        myIntArray.add(10, 111);
        myIntArray.add(10, 222);
        myIntArray.add(10, 333);
        for (int i = 0; i < myIntArray.size(); i++) {
            Log.d(TAG, "checkAddIndexMyArrayList: index = " + i
                    + ", element = " + myIntArray.get(i).toString());
        }
        Log.d(TAG, "checkAddIndexMyArrayList: end");
    }

    private void checkAddStringMyArrayList() {
        Log.d(TAG, "checkAddStringMyArrayList: begin");
        String[] strings = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven", "Twelve"};
        for (int i = 0; i < 12; i++) {
            Log.d(TAG, "checkAddStringMyArrayList: add element = " + strings[i]);
            myStringArray.add(strings[i]);
        }
        Log.d(TAG, "checkAddStringMyArrayList: end");
    }

    private void checkGetStringMyArrayList() {
        Log.d(TAG, "checkGetStringMyArrayList: begin");
        for (int i = 0; i < myStringArray.size(); i++) {
            Log.d(TAG, "checkGetStringMyArrayList: index = " + i
                    + ", element = " + myStringArray.get(i));
        }
        Log.d(TAG, "checkGetStringMyArrayList: end");
    }

    private void checkIteratorMyArrayList() {
        Log.d(TAG, "checkIteratorMyArrayList: begin");
        for (String element : myStringArray) {
            Log.d(TAG, "checkIteratorMyArrayList: element = " + element);
        }
        Log.d(TAG, "checkIteratorMyArrayList: end");
    }

    private void checkClearMyArrayList() {
        Log.d(TAG, "checkClearMyArrayList: begin");
        myStringArray.clear();
        for (String element : myStringArray) {
            Log.d(TAG, "checkClearMyArrayList: element = " + element);
        }
        Log.d(TAG, "checkClearMyArrayList: end");
    }
}