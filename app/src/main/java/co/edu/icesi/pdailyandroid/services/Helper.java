package co.edu.icesi.pdailyandroid.services;

import android.content.res.Resources;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import co.edu.icesi.pdailyandroid.R;
import co.edu.icesi.pdailyandroid.app.App;


public final class Helper {

    private static final String TAG = "Helper";
    public static String getConfigValue(String name) {
        Resources resources = App.getAppContext().getResources();
        try {
            InputStream rawResource = resources.openRawResource(R.raw.config);
            Properties properties = new Properties();
            properties.load(rawResource);
            return properties.getProperty(name);
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Unable to find the config file: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "Failed to open config file.");
        }

        return null;
    }
}
