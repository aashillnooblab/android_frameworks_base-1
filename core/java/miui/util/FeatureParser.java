package miui.util;

import android.os.Build;
import java.util.ArrayList;
import java.util.HashMap;

public class FeatureParser {
    private static final String ASSET_DIR = "device_features/";
    private static final String SYSTEM_DIR = "/system/etc/device_features";
    private static final String TAG = "FeatureParser";
    private static final String TAG_BOOL = "bool";
    private static final String TAG_FLOAT = "float";
    private static final String TAG_INTEGER = "integer";
    private static final String TAG_INTEGER_ARRAY = "integer-array";
    private static final String TAG_ITEM = "item";
    private static final String TAG_STRING = "string";
    private static final String TAG_STRING_ARRAY = "string-array";
    public static final int TYPE_BOOL = 1;
    public static final int TYPE_FLOAT = 6;
    public static final int TYPE_INTEGER = 2;
    public static final int TYPE_INTEGER_ARRAY = 5;
    public static final int TYPE_STRING = 3;
    public static final int TYPE_STRING_ARRAY = 4;
    private static final String VENDOR_DIR = "/vendor/etc/device_features";
    private static HashMap<String, Boolean> sBooleanMap = new HashMap<>();
    private static HashMap<String, Float> sFloatMap = new HashMap<>();
    private static HashMap<String, ArrayList<Integer>> sIntArrMap = new HashMap<>();
    private static HashMap<String, Integer> sIntMap = new HashMap<>();
    private static HashMap<String, ArrayList<String>> sStrArrMap = new HashMap<>();
    private static HashMap<String, String> sStrMap = new HashMap<>();

    public static boolean getBoolean(String str, boolean z) {
        Boolean bool = sBooleanMap.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return z;
    }

    public static String getString(String str) {
        return sStrMap.get(str);
    }

    public static String getDeviceFeaturesDir() {
        if (Build.VERSION.SDK_INT >= 29) {
            return VENDOR_DIR;
        }
        return SYSTEM_DIR;
    }

    public static int getInteger(String str, int i) {
        Integer num = sIntMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return i;
    }

    public static int[] getIntArray(String str) {
        ArrayList<Integer> arrayList = sIntArrMap.get(str);
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = arrayList.get(i).intValue();
        }
        return iArr;
    }

    public static String[] getStringArray(String str) {
        ArrayList<String> arrayList = sStrArrMap.get(str);
        if (arrayList != null) {
            return (String[]) arrayList.toArray(new String[0]);
        }
        return null;
    }

    public static Float getFloat(String str, float f) {
        Float f2 = sFloatMap.get(str);
        if (f2 != null) {
            f = f2.floatValue();
        }
        return Float.valueOf(f);
    }

    public static boolean hasFeature(String str, int i) {
        switch (i) {
            case 1:
                return sBooleanMap.containsKey(str);
            case 2:
                return sIntMap.containsKey(str);
            case 3:
                return sStrMap.containsKey(str);
            case 4:
                return sStrArrMap.containsKey(str);
            case 5:
                return sIntArrMap.containsKey(str);
            case 6:
                return sFloatMap.containsKey(str);
            default:
                return false;
        }
    }
}
