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
        public TextView blood_date;
        public TextView blood_value;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View vi = convertView;
        ViewHolder holder;
        if (convertView == null)
        {
            vi = inflater.inflate(R.layout.row_blood_pressure, null);
            holder = new ViewHolder();
            holder.blood_date = (TextView) vi.findViewById(R.id.blood_date);
            holder.blood_value = (TextView) vi.findViewById(R.id.blood_value);
            vi.setTag(holder);
        }
        else
            holder = (ViewHolder) vi.getTag();
        if (arrayList.size() > 0)
        {
            tempValues = null;
            tempValues = (BloodModel) arrayList.get(position);
            holder.blood_date.setText(tempValues.getCompanyname());
            holder.blood_value.setText(tempValues.getid());
        }
        return vi;
    }
}
