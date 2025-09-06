package com.google.android.material.datepicker;

import E9.h;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import b2.b;
import com.google.android.material.textfield.TextInputLayout;
import e1.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class RangeDateSelector implements DateSelector {
    public static final Parcelable.Creator CREATOR;
    public String a;
    public Long b;
    public Long c;
    public Long d;
    public Long e;

    static {
        RangeDateSelector.CREATOR = new u(3);
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final ArrayList G() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(new b(this.b, this.c));
        return arrayList0;
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final View W(LayoutInflater layoutInflater0, ViewGroup viewGroup0, CalendarConstraints calendarConstraints0, r r0) {
        View view0 = layoutInflater0.inflate(0x7F0D054C, viewGroup0, false);  // layout:mtrl_picker_text_input_date_range
        View view1 = view0.findViewById(0x7F0A087E);  // id:mtrl_picker_text_input_range_start
        View view2 = view0.findViewById(0x7F0A087D);  // id:mtrl_picker_text_input_range_end
        EditText editText0 = ((TextInputLayout)view1).getEditText();
        EditText editText1 = ((TextInputLayout)view2).getEditText();
        String s = Build.MANUFACTURER;
        String s1 = "";
        if((s == null ? "" : s.toLowerCase(Locale.ENGLISH)).equals("lge")) {
            editText0.setInputType(17);
            editText1.setInputType(17);
        }
        else {
            if(s != null) {
                s1 = s.toLowerCase(Locale.ENGLISH);
            }
            if(s1.equals("samsung")) {
                editText0.setInputType(17);
                editText1.setInputType(17);
            }
        }
        this.a = "Invalid range.";
        SimpleDateFormat simpleDateFormat0 = E.d();
        Long long0 = this.b;
        if(long0 != null) {
            editText0.setText(simpleDateFormat0.format(long0));
            this.d = this.b;
        }
        Long long1 = this.c;
        if(long1 != null) {
            editText1.setText(simpleDateFormat0.format(long1));
            this.e = this.c;
        }
        String s2 = E.e(view0.getResources(), simpleDateFormat0);
        ((TextInputLayout)view1).setPlaceholderText(s2);
        ((TextInputLayout)view2).setPlaceholderText(s2);
        editText0.addTextChangedListener(new A(this, s2, simpleDateFormat0, ((TextInputLayout)view1), calendarConstraints0, ((TextInputLayout)view1), ((TextInputLayout)view2), r0, 0));
        editText1.addTextChangedListener(new A(this, s2, simpleDateFormat0, ((TextInputLayout)view2), calendarConstraints0, ((TextInputLayout)view1), ((TextInputLayout)view2), r0, 1));
        DateSelector.Q(new EditText[]{editText0, editText1});
        return view0;
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final boolean X() {
        return this.b != null && this.c != null && ((long)this.b) <= ((long)this.c);
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final ArrayList Z() {
        ArrayList arrayList0 = new ArrayList();
        Long long0 = this.b;
        if(long0 != null) {
            arrayList0.add(long0);
        }
        Long long1 = this.c;
        if(long1 != null) {
            arrayList0.add(long1);
        }
        return arrayList0;
    }

    public static void a(RangeDateSelector rangeDateSelector0, TextInputLayout textInputLayout0, TextInputLayout textInputLayout1, r r0) {
        Long long0 = rangeDateSelector0.d;
        if(long0 == null || rangeDateSelector0.e == null) {
            if(textInputLayout0.getError() != null && rangeDateSelector0.a.contentEquals(textInputLayout0.getError())) {
                textInputLayout0.setError(null);
            }
            if(textInputLayout1.getError() != null && " ".contentEquals(textInputLayout1.getError())) {
                textInputLayout1.setError(null);
            }
            r0.a();
        }
        else if(((long)long0) <= ((long)rangeDateSelector0.e)) {
            rangeDateSelector0.b = rangeDateSelector0.d;
            rangeDateSelector0.c = rangeDateSelector0.e;
            r0.b(new b(rangeDateSelector0.d, rangeDateSelector0.e));
        }
        else {
            textInputLayout0.setError(rangeDateSelector0.a);
            textInputLayout1.setError(" ");
            r0.a();
        }
        if(!TextUtils.isEmpty(textInputLayout0.getError())) {
            return;
        }
        TextUtils.isEmpty(textInputLayout1.getError());
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final Object c0() {
        return new b(this.b, this.c);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final String f(Context context0) {
        Resources resources0 = context0.getResources();
        b b0 = h.A(this.b, this.c);
        String s = b0.a == null ? "none" : ((String)b0.a);
        return b0.b == null ? resources0.getString(0x7F1306E7, new Object[]{s, "none"}) : resources0.getString(0x7F1306E7, new Object[]{s, ((String)b0.b)});  // string:mtrl_picker_announce_current_range_selection "Start date selection: %1$s 
                                                                                                                                                              // – End date selection: %2$s"
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final int g(Context context0) {
        Resources resources0 = context0.getResources();
        DisplayMetrics displayMetrics0 = resources0.getDisplayMetrics();
        int v = resources0.getDimensionPixelSize(0x7F070369);  // dimen:mtrl_calendar_maximum_default_fullscreen_minor_axis
        return Math.min(displayMetrics0.widthPixels, displayMetrics0.heightPixels) <= v ? m.A(context0, 0x7F0403F7, s.class.getCanonicalName()).data : m.A(context0, 0x7F040402, s.class.getCanonicalName()).data;  // attr:materialCalendarFullscreenTheme
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final void i0(long v) {
        Long long0 = this.b;
        if(long0 == null) {
            this.b = v;
            return;
        }
        if(this.c == null && ((long)long0) <= v) {
            this.c = v;
            return;
        }
        this.c = null;
        this.b = v;
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final String l(Context context0) {
        Resources resources0 = context0.getResources();
        Long long0 = this.b;
        if(long0 == null && this.c == null) {
            return "Start date – End date";
        }
        Long long1 = this.c;
        if(long1 == null) {
            return resources0.getString(0x7F1306F9, new Object[]{h.B(((long)long0))});  // string:mtrl_picker_range_header_only_start_selected "%1$s – End date"
        }
        if(long0 == null) {
            return resources0.getString(0x7F1306F8, new Object[]{h.B(((long)long1))});  // string:mtrl_picker_range_header_only_end_selected "Start date – %1$s"
        }
        b b0 = h.A(long0, long1);
        return resources0.getString(0x7F1306FA, new Object[]{b0.a, b0.b});  // string:mtrl_picker_range_header_selected "%1$s – %2$s"
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeValue(this.b);
        parcel0.writeValue(this.c);
    }
}

