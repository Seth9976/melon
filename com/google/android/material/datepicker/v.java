package com.google.android.material.datepicker;

import P0.d0;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.b;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

public final class v extends BaseAdapter {
    public final Month a;
    public final DateSelector b;
    public Collection c;
    public d0 d;
    public final CalendarConstraints e;
    public final DayViewDecorator f;
    public static final int g;
    public static final int h;

    static {
        v.g = E.g(null).getMaximum(4);
        int v = E.g(null).getMaximum(5);
        v.h = E.g(null).getMaximum(7) + v - 1;
    }

    public v(Month month0, DateSelector dateSelector0, CalendarConstraints calendarConstraints0, DayViewDecorator dayViewDecorator0) {
        this.a = month0;
        this.b = dateSelector0;
        this.e = calendarConstraints0;
        this.f = dayViewDecorator0;
        this.c = dateSelector0.Z();
    }

    public final int a() {
        int v = this.e.e;
        Month month0 = this.a;
        Calendar calendar0 = month0.a;
        int v1 = calendar0.get(7);
        if(v <= 0) {
            v = calendar0.getFirstDayOfWeek();
        }
        int v2 = v1 - v;
        return v2 >= 0 ? v2 : v2 + month0.d;
    }

    public final Long b(int v) {
        if(v >= this.a() && v <= this.c()) {
            int v1 = this.a();
            Calendar calendar0 = E.c(this.a.a);
            calendar0.set(5, v - v1 + 1);
            return calendar0.getTimeInMillis();
        }
        return null;
    }

    public final int c() {
        return this.a() + this.a.e - 1;
    }

    public final void d(TextView textView0, long v, int v1) {
        b b0;
        if(textView0 == null) {
            return;
        }
        boolean z = false;
        textView0.getContext();
        boolean z1 = true;
        boolean z2 = Long.compare(E.f().getTimeInMillis(), v) == 0;
        DateSelector dateSelector0 = this.b;
        for(Object object0: dateSelector0.G()) {
            Object object1 = ((b2.b)object0).a;
            if(object1 != null && ((long)(((Long)object1))) == v) {
                z = true;
                break;
            }
        }
        boolean z3 = false;
        for(Object object2: dateSelector0.G()) {
            Object object3 = ((b2.b)object2).b;
            if(object3 != null && ((long)(((Long)object3))) == v) {
                z3 = true;
                break;
            }
        }
        Calendar calendar0 = E.f();
        Calendar calendar1 = E.g(null);
        calendar1.setTimeInMillis(v);
        String s = calendar0.get(1) == calendar1.get(1) ? E.b("MMMMEEEEd", Locale.getDefault()).format(new Date(v)) : E.b("yMMMMEEEEd", Locale.getDefault()).format(new Date(v));
        if(z2) {
            s = String.format("Today %1$s", s);
        }
        if(z) {
            s = String.format("Start date %1$s", s);
        }
        else if(z3) {
            s = String.format("End date %1$s", s);
        }
        textView0.setContentDescription(s);
        if(this.e.c.i(v)) {
            textView0.setEnabled(true);
            for(Object object4: dateSelector0.Z()) {
                if(E.a(v) != E.a(((long)(((Long)object4))))) {
                    continue;
                }
                goto label_40;
            }
            z1 = false;
        label_40:
            textView0.setSelected(z1);
            if(z1) {
                b0 = (b)this.d.c;
            }
            else if(E.f().getTimeInMillis() == v) {
                b0 = (b)this.d.d;
            }
            else {
                b0 = (b)this.d.b;
            }
        }
        else {
            textView0.setEnabled(false);
            b0 = (b)this.d.h;
        }
        if(this.f != null && v1 != -1) {
            b0.o(textView0);
            textView0.setCompoundDrawables(null, null, null, null);
            textView0.setContentDescription(s);
            return;
        }
        b0.o(textView0);
    }

    public final void e(MaterialCalendarGridView materialCalendarGridView0, long v) {
        Month month0 = Month.b(v);
        Month month1 = this.a;
        if(month0.equals(month1)) {
            Calendar calendar0 = E.c(month1.a);
            calendar0.setTimeInMillis(v);
            int v1 = calendar0.get(5);
            this.d(((TextView)materialCalendarGridView0.getChildAt(materialCalendarGridView0.a().a() + (v1 - 1) - materialCalendarGridView0.getFirstVisiblePosition())), v, v1);
        }
    }

    @Override  // android.widget.Adapter
    public final int getCount() {
        return v.h;
    }

    @Override  // android.widget.Adapter
    public final Object getItem(int v) {
        return this.b(v);
    }

    @Override  // android.widget.Adapter
    public final long getItemId(int v) {
        return (long)(v / this.a.d);
    }

    @Override  // android.widget.Adapter
    public final View getView(int v, View view0, ViewGroup viewGroup0) {
        int v2;
        Context context0 = viewGroup0.getContext();
        if(this.d == null) {
            this.d = new d0(context0);
        }
        View view1 = (TextView)view0;
        if(view0 == null) {
            view1 = (TextView)o.e(viewGroup0, 0x7F0D0536, viewGroup0, false);  // layout:mtrl_calendar_day
        }
        int v1 = v - this.a();
        if(v1 >= 0) {
            Month month0 = this.a;
            if(v1 < month0.e) {
                v2 = v1 + 1;
                view1.setTag(month0);
                ((TextView)view1).setText(String.format(view1.getResources().getConfiguration().locale, "%d", v2));
                view1.setVisibility(0);
                ((TextView)view1).setEnabled(true);
                goto label_19;
            }
            goto label_16;
        }
        else {
        label_16:
            view1.setVisibility(8);
            ((TextView)view1).setEnabled(false);
            v2 = -1;
        }
    label_19:
        Long long0 = this.b(v);
        if(long0 == null) {
            return view1;
        }
        this.d(((TextView)view1), ((long)long0), v2);
        return view1;
    }

    @Override  // android.widget.BaseAdapter
    public final boolean hasStableIds() {
        return true;
    }
}

