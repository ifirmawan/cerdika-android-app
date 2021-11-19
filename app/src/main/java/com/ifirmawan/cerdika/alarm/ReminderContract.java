package com.ifirmawan.cerdika.alarm;

import com.ifirmawan.cerdika.BasePresenter;
import com.ifirmawan.cerdika.BaseView;
import com.ifirmawan.cerdika.data.source.History;
import com.ifirmawan.cerdika.data.source.MedicineAlarm;

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
