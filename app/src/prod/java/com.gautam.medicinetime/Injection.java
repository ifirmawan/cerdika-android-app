package com.firmawan.cerdika;

import android.content.Context;
import androidx.annotation.NonNull;


import com.firmawan.cerdika.data.source.MedicineRepository;
import com.firmawan.cerdika.data.source.local.MedicinesLocalDataSource;


/**
 * Created by gautam on 13/05/17.
 */

public class Injection {

    public static MedicineRepository provideMedicineRepository(@NonNull Context context) {
        return MedicineRepository.getInstance(MedicinesLocalDataSource.getInstance(context));
    }
}