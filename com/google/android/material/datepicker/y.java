package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.j0;
import java.util.Calendar;

public final class y extends j0 {
    public final CalendarConstraints a;
    public final DateSelector b;
    public final DayViewDecorator c;
    public final m d;
    public final int e;

    public y(ContextThemeWrapper contextThemeWrapper0, DateSelector dateSelector0, CalendarConstraints calendarConstraints0, DayViewDecorator dayViewDecorator0, m m0) {
        Month month0 = calendarConstraints0.b;
        Month month1 = calendarConstraints0.d;
        if(calendarConstraints0.a.a.compareTo(month1.a) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if(month1.a.compareTo(month0.a) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.e = contextThemeWrapper0.getResources().getDimensionPixelSize(0x7F070358) * v.g + (s.o(contextThemeWrapper0, 0x101020D) ? contextThemeWrapper0.getResources().getDimensionPixelSize(0x7F070358) : 0);  // dimen:mtrl_calendar_day_height
        this.a = calendarConstraints0;
        this.b = dateSelector0;
        this.c = dayViewDecorator0;
        this.d = m0;
        this.setHasStableIds(true);
    }

    @Override  // androidx.recyclerview.widget.j0
    public final int getItemCount() {
        return this.a.g;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final long getItemId(int v) {
        Calendar calendar0 = E.c(this.a.a.a);
        calendar0.add(2, v);
        return new Month(calendar0).a.getTimeInMillis();
    }

    @Override  // androidx.recyclerview.widget.j0
    public final void onBindViewHolder(O0 o00, int v) {
        CalendarConstraints calendarConstraints0 = this.a;
        Calendar calendar0 = E.c(calendarConstraints0.a.a);
        calendar0.add(2, v);
        Month month0 = new Month(calendar0);
        String s = month0.d();
        ((x)o00).a.setText(s);
        MaterialCalendarGridView materialCalendarGridView0 = (MaterialCalendarGridView)((x)o00).b.findViewById(0x7F0A0811);  // id:month_grid
        if(materialCalendarGridView0.a() == null || !month0.equals(materialCalendarGridView0.a().a)) {
            v v2 = new v(month0, this.b, calendarConstraints0, this.c);
            materialCalendarGridView0.setNumColumns(month0.d);
            materialCalendarGridView0.setAdapter(v2);
        }
        else {
            materialCalendarGridView0.invalidate();
            v v1 = materialCalendarGridView0.a();
            DateSelector dateSelector0 = v1.b;
            for(Object object0: v1.c) {
                v1.e(materialCalendarGridView0, ((long)(((Long)object0))));
            }
            if(dateSelector0 != null) {
                for(Object object1: dateSelector0.Z()) {
                    v1.e(materialCalendarGridView0, ((long)(((Long)object1))));
                }
                v1.c = dateSelector0.Z();
            }
        }
        materialCalendarGridView0.setOnItemClickListener(new w(this, materialCalendarGridView0));
    }

    @Override  // androidx.recyclerview.widget.j0
    public final O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        LinearLayout linearLayout0 = (LinearLayout)o.e(viewGroup0, 0x7F0D053B, viewGroup0, false);  // layout:mtrl_calendar_month_labeled
        if(s.o(viewGroup0.getContext(), 0x101020D)) {
            linearLayout0.setLayoutParams(new LayoutParams(-1, this.e));
            return new x(linearLayout0, true);
        }
        return new x(linearLayout0, false);
    }
}

