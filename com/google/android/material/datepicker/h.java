package com.google.android.material.datepicker;

import P0.d0;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.o;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.j0;
import java.util.Calendar;
import java.util.Locale;

public final class H extends j0 {
    public final p a;

    public H(p p0) {
        this.a = p0;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final int getItemCount() {
        return this.a.d.f;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final void onBindViewHolder(O0 o00, int v) {
        int v1 = this.a.d.a.c + v;
        Locale locale0 = Locale.getDefault();
        ((G)o00).a.setText(String.format(locale0, "%d", v1));
        TextView textView0 = ((G)o00).a;
        textView0.getContext();
        textView0.setContentDescription((E.f().get(1) == v1 ? String.format("Navigate to current year %1$d", v1) : String.format("Navigate to year %1$d", v1)));
        d0 d00 = this.a.h;
        Calendar calendar0 = E.f();
        b b0 = (b)(calendar0.get(1) == v1 ? d00.g : d00.e);
        for(Object object0: this.a.c.Z()) {
            calendar0.setTimeInMillis(((long)(((Long)object0))));
            if(calendar0.get(1) == v1) {
                b0 = (b)d00.f;
            }
        }
        b0.o(textView0);
        textView0.setOnClickListener(new F(this, v1));
    }

    @Override  // androidx.recyclerview.widget.j0
    public final O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        return new G(((TextView)o.e(viewGroup0, 0x7F0D053F, viewGroup0, false)));  // layout:mtrl_calendar_year
    }
}

