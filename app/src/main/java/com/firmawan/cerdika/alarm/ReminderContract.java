package com.firmawan.cerdika.alarm;

import com.firmawan.cerdika.BasePresenter;
import com.firmawan.cerdika.BaseView;
import com.firmawan.cerdika.data.source.History;
import com.firmawan.cerdika.data.source.MedicineAlarm;

/**
 * Created by gautam on 13/07/17.
 */

public interface ReminderContract {

    interface View extends BaseView<Presenter> {

        void showMedicine(MedicineAlarm medicineAlarm);

        void showNoData();

        boolean isActive();

        void onFinish();

    }

    interface Presenter extends BasePresenter {

        void finishActivity();

        void onStart(long id);

        void loadMedicineById(long id);

        void addPillsToHistory(History history);

    }
}
