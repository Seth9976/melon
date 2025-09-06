package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import c2.H;

public final class x extends O0 {
    public final TextView a;
    public final MaterialCalendarGridView b;

    public x(LinearLayout linearLayout0, boolean z) {
        super(linearLayout0);
        TextView textView0 = (TextView)linearLayout0.findViewById(0x7F0A0816);  // id:month_title
        this.a = textView0;
        new H(0x7F0A0B20, Boolean.class, 0, 28, 3).h(textView0, Boolean.TRUE);  // id:tag_accessibility_heading
        this.b = (MaterialCalendarGridView)linearLayout0.findViewById(0x7F0A0811);  // id:month_grid
        if(!z) {
            textView0.setVisibility(8);
        }
    }
}

