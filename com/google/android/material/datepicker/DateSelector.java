package com.google.android.material.datepicker;

import Fd.k;
import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import c2.B;
import java.util.ArrayList;

public interface DateSelector extends Parcelable {
    ArrayList G();

    static void Q(EditText[] arr_editText) {
        if(arr_editText.length == 0) {
            return;
        }
        k k0 = new k(arr_editText, 1);
        for(int v = 0; v < arr_editText.length; ++v) {
            arr_editText[v].setOnFocusChangeListener(k0);
        }
        EditText editText0 = arr_editText[0];
        editText0.postDelayed(new B(editText0, 2), 100L);
    }

    View W(LayoutInflater arg1, ViewGroup arg2, CalendarConstraints arg3, r arg4);

    boolean X();

    ArrayList Z();

    Object c0();

    String f(Context arg1);

    int g(Context arg1);

    void i0(long arg1);

    String l(Context arg1);
}

