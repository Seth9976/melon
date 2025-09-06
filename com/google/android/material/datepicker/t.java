package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class t extends z {
    public int b;
    public DateSelector c;
    public CalendarConstraints d;

    @Override  // androidx.fragment.app.I
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        this.b = bundle0.getInt("THEME_RES_ID_KEY");
        this.c = (DateSelector)bundle0.getParcelable("DATE_SELECTOR_KEY");
        this.d = (CalendarConstraints)bundle0.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override  // androidx.fragment.app.I
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        LayoutInflater layoutInflater1 = layoutInflater0.cloneInContext(new ContextThemeWrapper(this.getContext(), this.b));
        return this.c.W(layoutInflater1, viewGroup0, this.d, new r(this, 1));
    }

    @Override  // androidx.fragment.app.I
    public final void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("THEME_RES_ID_KEY", this.b);
        bundle0.putParcelable("DATE_SELECTOR_KEY", this.c);
        bundle0.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.d);
    }
}

