package com.firmawan.cerdika;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BloodAdapter extends BaseAdapter {
    Activity activity;
    LayoutInflater inflater;
    ArrayList arrayList;
    Resources resource;
    BloodModel tempValues;

    BloodAdapter(Activity activity, ArrayList arrayList, Resources resource)
    {
        this.activity = activity;
        this.arrayList = arrayList;
        this.resource = resource;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        if (arrayList.size() <= 0)
            return 1;
        return arrayList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    public static class ViewHolder
    {
        public TextView blood_date_sistolik;
        public TextView blood_date_diastolik;
        public TextView blood_sistolik;
        public TextView blood_diastolik;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View vi = convertView;
        ViewHolder holder;
        if (convertView == null)
        {
            vi = inflater.inflate(R.layout.row_blood_pressure, null);
            holder = new ViewHolder();
            holder.blood_date_sistolik = (TextView) vi.findViewById(R.id.blood_date_sistolik);
            holder.blood_date_diastolik = (TextView) vi.findViewById(R.id.blood_date_diastolik);
            holder.blood_sistolik = (TextView) vi.findViewById(R.id.blood_sistolik);
            holder.blood_diastolik = (TextView) vi.findViewById(R.id.blood_diastolik);
            vi.setTag(holder);
        }
        else
            holder = (ViewHolder) vi.getTag();
        if (arrayList.size() > 0)
        {
            tempValues = null;
            tempValues = (BloodModel) arrayList.get(position);
            holder.blood_date_sistolik.setText(tempValues.getBloodDateSistolik());
            holder.blood_date_diastolik.setText(tempValues.getBloodDateDiastolik());
            holder.blood_sistolik.setText(tempValues.getSistolik());
            holder.blood_diastolik.setText(tempValues.getDiastolik());
        }
        return vi;
    }
}
