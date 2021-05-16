package android.provider;

import android.content.ContentResolver;
import android.provider.Settings;
public class MiuiSettings {

    public static final class SettingsCloudData {
        private SettingsCloudData() {
        }

        public static String getCloudDataString(ContentResolver contentResolver, String str, String str2, String str3) {
            return str3;
        }

        public static int getCloudDataInt(ContentResolver contentResolver, String str, String str2, int i) {
            return i;
        }
    }

    public static class System {
        private System() {
        }

        public static String getString(ContentResolver contentResolver, String str) {
            return Settings.System.getString(contentResolver, str);
        }
    }

    public static class Global {
        private Global() {
        }

        public static boolean getBoolean(ContentResolver contentResolver, String str) {
            return Settings.Global.getInt(contentResolver, str, 0) != 0;
        }
    }
}
