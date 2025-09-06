package com.google.android.material.datepicker;

import E9.h;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import e1.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class SingleDateSelector implements DateSelector {
    public static final Parcelable.Creator CREATOR;
    public Long a;

    static {
        SingleDateSelector.CREATOR = new u(4);
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final ArrayList G() {
        return new ArrayList();
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final View W(LayoutInflater layoutInflater0, ViewGroup viewGroup0, CalendarConstraints calendarConstraints0, r r0) {
        View view0 = layoutInflater0.inflate(0x7F0D054B, viewGroup0, false);  // layout:mtrl_picker_text_input_date
        View view1 = view0.findViewById(0x7F0A087C);  // id:mtrl_picker_text_input_date
        EditText editText0 = ((TextInputLayout)view1).getEditText();
        String s = Build.MANUFACTURER;
        String s1 = "";
        if((s == null ? "" : s.toLowerCase(Locale.ENGLISH)).equals("lge")) {
            editText0.setInputType(17);
        }
        else {
            if(s != null) {
                s1 = s.toLowerCase(Locale.ENGLISH);
            }
            if(s1.equals("samsung")) {
                editText0.setInputType(17);
            }
        }
        SimpleDateFormat simpleDateFormat0 = E.d();
        String s2 = E.e(view0.getResources(), simpleDateFormat0);
        ((TextInputLayout)view1).setPlaceholderText(s2);
        Long long0 = this.a;
        if(long0 != null) {
            editText0.setText(simpleDateFormat0.format(long0));
        }
        editText0.addTextChangedListener(new B(this, s2, simpleDateFormat0, ((TextInputLayout)view1), calendarConstraints0, r0, ((TextInputLayout)view1)));
        DateSelector.Q(new EditText[]{editText0});
        return view0;
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final boolean X() {
        return this.a != null;
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final ArrayList Z() {
        ArrayList arrayList0 = new ArrayList();
        Long long0 = this.a;
        if(long0 != null) {
            arrayList0.add(long0);
        }
        return arrayList0;
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final Object c0() {
        return this.a;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final String f(Context context0) {
        Resources resources0 = context0.getResources();
        return this.a == null ? resources0.getString(0x7F1306E8, new Object[]{"none"}) : resources0.getString(0x7F1306E8, new Object[]{h.M(((long)this.a), Locale.getDefault())});  // string:mtrl_picker_announce_current_selection "Current selection: %1$s"
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final int g(Context context0) {
        return m.A(context0, 0x7F040402, s.class.getCanonicalName()).data;  // attr:materialCalendarTheme
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final void i0(long v) {
        this.a = v;
    }

    @Override  // com.google.android.material.datepicker.DateSelector
    public final String l(Context context0) {
        Resources resources0 = context0.getResources();
        return this.a == null ? "Selected date" : resources0.getString(0x7F1306EC, new Object[]{h.M(((long)this.a), Locale.getDefault())});  // string:mtrl_picker_date_header_selected "%1$s"
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeValue(this.a);
    }
}

