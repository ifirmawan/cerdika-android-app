package com.firmawan.cerdika.utils;

import static com.firmawan.cerdika.utils.PreferencesUtility.*;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class BloodSharedPreferences {
    static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setBloodMeasure(Context context, Integer sistolik, Integer diastolik, String sistolik_date, String diastolik_date) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putInt(BLOOD_SISTOLIK, sistolik);
        editor.putInt(BLOOD_DIASTOLIK, diastolik);
        editor.putString(BLOOD_SIS_DATE, sistolik_date);
        editor.putString(BLOOD_DIAS_DATE, diastolik_date);
        editor.apply();
    }

    public static Integer getSistolik(Context context) {
        return getPreferences(context).getInt(BLOOD_SISTOLIK, 0);
    }

    public static Integer getDiastolik(Context context) {
        return getPreferences(context).getInt(BLOOD_DIASTOLIK, 0);
    }

    public static String getSistolikDate(Context context) {
        return getPreferences(context).getString(BLOOD_SIS_DATE, "");
    }

    public static String getDiastolikDate(Context context) {
        return getPreferences(context).getString(BLOOD_DIAS_DATE, "");
    }
}
