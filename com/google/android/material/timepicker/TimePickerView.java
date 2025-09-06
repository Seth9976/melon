package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

class TimePickerView extends ConstraintLayout {
    public final Chip o;
    public static final int r;

    public TimePickerView(Context context0) {
        this(context0, null);
    }

    public TimePickerView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public TimePickerView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        h h0 = new h(this);
        LayoutInflater.from(context0).inflate(0x7F0D04D5, this);  // layout:material_timepicker
        ClockFaceView clockFaceView0 = (ClockFaceView)this.findViewById(0x7F0A07DA);  // id:material_clock_face
        MaterialButtonToggleGroup materialButtonToggleGroup0 = (MaterialButtonToggleGroup)this.findViewById(0x7F0A07DF);  // id:material_clock_period_toggle
        g g0 = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        materialButtonToggleGroup0.c.add(g0);
        Chip chip0 = (Chip)this.findViewById(0x7F0A07E4);  // id:material_minute_tv
        Chip chip1 = (Chip)this.findViewById(0x7F0A07E1);  // id:material_hour_tv
        this.o = chip1;
        ClockHandView clockHandView0 = (ClockHandView)this.findViewById(0x7F0A07DB);  // id:material_clock_hand
        j j0 = new j(new GestureDetector(this.getContext(), new i(this)));
        chip0.setOnTouchListener(j0);
        chip1.setOnTouchListener(j0);
        chip0.setTag(0x7F0A0A61, 12);  // id:selection_type
        chip1.setTag(0x7F0A0A61, 10);  // id:selection_type
        chip0.setOnClickListener(h0);
        chip1.setOnClickListener(h0);
        chip0.setAccessibilityClassName("android.view.View");
        chip1.setAccessibilityClassName("android.view.View");
    }

    @Override  // android.view.View
    public final void onVisibilityChanged(View view0, int v) {
        super.onVisibilityChanged(view0, v);
        if(view0 == this && v == 0) {
            this.o.sendAccessibilityEvent(8);
        }
    }
}

