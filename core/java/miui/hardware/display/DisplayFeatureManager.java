package miui.hardware.display;

public class DisplayFeatureManager {
    private static volatile DisplayFeatureManager sInstance;

    public static DisplayFeatureManager getInstance() {
        if (sInstance == null) {
            synchronized (DisplayFeatureManager.class) {
                if (sInstance == null) {
                    sInstance = new DisplayFeatureManager();
                }
            }
        }
        return sInstance;
    }

    private DisplayFeatureManager() {
    }

    public void setScreenEffect(int i, int i2) {
    }
}
