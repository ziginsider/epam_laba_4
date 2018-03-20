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

    private void checkIsEmptyMyHashMap() {
        Log.d(TAG, "checkIsEmptyMyHashMap: " + myHashMap.isEmpty());
    }

    private void checkSizeMyHashMap() {
        Log.d(TAG, "checkSizeMyHashMap: size = " + myHashMap.size());
    }

    private void checkPutMyHashMap() {
        Log.d(TAG, "checkPutMyHashMap: begin");
        Log.d(TAG, "checkPutMyHashMap: put(\"key1\", \"One\") = " + myHashMap.put("key1", "One"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key2\", \"Two\") = " + myHashMap.put("key2", "Two"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key3\", \"Three\") = " + myHashMap.put("key3", "Three"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key4\", \"Four\") = " + myHashMap.put("key4", "Four"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key5\", \"Five\") = " + myHashMap.put("key5", "Five"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key6\", \"Six\") = " + myHashMap.put("key6", "Six"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key7\", \"Seven\")= " + myHashMap.put("key7", "Seven"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key8\", \"Eight\") = " + myHashMap.put("key8", "Eight"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key9\", \"Nine\") = " + myHashMap.put("key9", "Nine"));
        Log.d(TAG, "checkPutMyHashMap: put(\"key10\",\"Ten\") = " + myHashMap.put("key10", "Ten"));
        Log.d(TAG, "checkPutMyHashMap: put(null, \"First Null\") = " + myHashMap.put(null, "First Null"));
        Log.d(TAG, "checkPutMyHashMap: put(null, \"Second Null\") = " + myHashMap.put(null, "Second Null"));
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
        Log.d(TAG, "checkContainsKeyMyHashMap: key = \"key1\" = " + myHashMap.containsKey("key1"));
        Log.d(TAG, "checkContainsKeyMyHashMap: key = \"key5\" = " + myHashMap.containsKey("key5"));
        Log.d(TAG, "checkContainsKeyMyHashMap: key = \"key10\" = " + myHashMap.containsKey("key10"));
        Log.d(TAG, "checkContainsKeyMyHashMap: key = \"key12\" = " + myHashMap.containsKey("key12"));
        Log.d(TAG, "checkContainsKeyMyHashMap: key = \"key20\" = " + myHashMap.containsKey("key20"));
        Log.d(TAG, "checkContainsKeyMyHashMap: key = null = " + myHashMap.containsKey(null));
        Log.d(TAG, "checkContainsKeyMyHashMap: end");
    }

    private void checkContainsValueKeyMyHashMap() {
        Log.d(TAG, "checkContainsValueKeyMyHashMap: begin");
        Log.d(TAG, "checkContainsValueKeyMyHashMap: value = \"One\" = " + myHashMap.containsValue("One"));
        Log.d(TAG, "checkContainsValueKeyMyHashMap: value = \"Two\" = " + myHashMap.containsValue("Two"));
        Log.d(TAG, "checkContainsValueKeyMyHashMap: value = \"Three\" = " + myHashMap.containsValue("Three"));
        Log.d(TAG, "checkContainsValueKeyMyHashMap: value = \"Forty\" = " + myHashMap.containsValue("Forty"));
        Log.d(TAG, "checkContainsValueKeyMyHashMap: value = \"Zero\" = " + myHashMap.containsValue("Zero"));
        Log.d(TAG, "checkContainsValueKeyMyHashMap: value = null = " + myHashMap.containsValue(null));
        Log.d(TAG, "checkContainsValueKeyMyHashMap: end");
    }

    private void checkRemoveMyHashMap() {
        Log.d(TAG, "checkRemoveMyHashMap: begin");
        Log.d(TAG, "checkRemoveMyHashMap: key = \"One\" = " + myHashMap.remove(""));
        Log.d(TAG, "checkRemoveMyHashMap: key = \"Two\" = " + myHashMap.remove("Two"));
        Log.d(TAG, "checkRemoveMyHashMap: key = \"Five\" = " + myHashMap.remove("Five"));
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


}
