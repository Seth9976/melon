package com.google.android.material.datepicker;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.appcompat.app.o;
import java.util.Calendar;
import java.util.Locale;

public final class i extends BaseAdapter {
    public final Calendar a;
    public final int b;
    public final int c;

    public i() {
        Calendar calendar0 = E.g(null);
        this.a = calendar0;
        this.b = calendar0.getMaximum(7);
        this.c = calendar0.getFirstDayOfWeek();
    }

    public i(int v) {
        Calendar calendar0 = E.g(null);
        this.a = calendar0;
        this.b = calendar0.getMaximum(7);
        this.c = v;
    }

    @Override  // android.widget.Adapter
    public final int getCount() {
        return this.b;
    }

    @Override  // android.widget.Adapter
    public final Object getItem(int v) {
        int v1 = this.b;
        if(v >= v1) {
            return null;
        }
        int v2 = v + this.c;
        return (int)(v2 <= v1 ? v + this.c : v2 - v1);
    }

    @Override  // android.widget.Adapter
    public final long getItemId(int v) {
        return 0L;
    }

    @Override  // android.widget.Adapter
    public final View getView(int v, View view0, ViewGroup viewGroup0) {
        View view1 = (TextView)view0;
        if(view0 == null) {
            view1 = (TextView)o.e(viewGroup0, 0x7F0D0537, viewGroup0, false);  // layout:mtrl_calendar_day_of_week
        }
        int v1 = v + this.c;
        int v2 = this.b;
        if(v1 > v2) {
            v1 -= v2;
        }
        this.a.set(7, v1);
        Configuration configuration0 = view1.getResources().getConfiguration();
        ((TextView)view1).setText(this.a.getDisplayName(7, 4, configuration0.locale));
        Locale locale0 = Locale.getDefault();
        view1.setContentDescription(String.format("%1$s", this.a.getDisplayName(7, 2, locale0)));
        return view1;
    }
}

