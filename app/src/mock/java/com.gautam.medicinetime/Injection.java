package com.ifirmawan.cerdika;

import android.content.Context;
import androidx.annotation.NonNull;

import com.ifirmawan.cerdika.data.source.MedicineRepository;
import com.ifirmawan.cerdika.data.source.local.MedicinesLocalDataSource;

/**
 * Created by gautam on 13/07/17.
 */

public class Injection {

    public static MedicineRepository provideMedicineRepository(@NonNull Context context) {
        return MedicineRepository.getInstance(MedicinesLocalDataSource.getInstance(context));
    }
}
