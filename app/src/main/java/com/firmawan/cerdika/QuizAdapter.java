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

public class QuizAdapter extends BaseAdapter {
    Activity activity;
    LayoutInflater inflater;
    ArrayList arrayList;
    Resources resource;
    QuizModel tempValues;

    QuizAdapter(Activity activity, ArrayList arrayList, Resources resource)
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
        public TextView quiz;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View vi = convertView;
        QuizAdapter.ViewHolder holder;
        if (convertView == null)
        {
            vi = inflater.inflate(R.layout.row_quiz, null);
            holder = new QuizAdapter.ViewHolder();
            holder.quiz = (TextView) vi.findViewById(R.id.tv_quiz);
            vi.setTag(holder);
        }
        else
            holder = (QuizAdapter.ViewHolder) vi.getTag();
        if (arrayList.size() > 0)
        {
            tempValues = null;
            tempValues = (QuizModel) arrayList.get(position);
            holder.quiz.setText(tempValues.getQuiz());
        }
        return vi;
    }
}
