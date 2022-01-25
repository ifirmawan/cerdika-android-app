package com.firmawan.cerdika.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import static com.firmawan.cerdika.utils.PreferencesUtility.*;

public class SaveSharedPreference {
    static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * Set the Login Status
     * @param context
     * @param loggedIn
     */
    public static void setLoggedIn(Context context, boolean loggedIn, String token, String uuid) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_PREF, loggedIn);
        editor.putString(LOGGED_HEADER_TOKEN, token);
        editor.putString(LOGGED_UUID, uuid);
        editor.apply();
    }

    /**
     * Get the Login Status
     * @param context
     * @return boolean: login status
     */
    public static boolean getLoggedStatus(Context context) {
        return getPreferences(context).getBoolean(LOGGED_IN_PREF, false);
    }

    /**
     * Get the Login Token
     * @param context
     * @return String: header Token
     */
    public static String getHeaderToken(Context context) {
        return getPreferences(context).getString(LOGGED_HEADER_TOKEN, "");
    }

    /**
     * Get the Login Token
     * @param context
     * @return String: header Token
     */
    public static String getLoggedUuid(Context context) {
        return getPreferences(context).getString(LOGGED_UUID, "");
    }
}
