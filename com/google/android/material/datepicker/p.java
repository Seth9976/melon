package com.google.android.material.datepicker;

import A6.c;
import E8.a;
import P0.d0;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.widget.f;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f0;
import c2.W;
import com.google.android.material.button.MaterialButton;

public final class p extends z {
    public int b;
    public DateSelector c;
    public CalendarConstraints d;
    public DayViewDecorator e;
    public Month f;
    public int g;
    public d0 h;
    public RecyclerView i;
    public RecyclerView j;
    public View k;
    public View l;
    public View m;
    public View n;

    @Override  // com.google.android.material.datepicker.z
    public final void l(r r0) {
        this.a.add(r0);
    }

    public final void m(Month month0) {
        y y0 = (y)this.j.getAdapter();
        int v = y0.a.a.e(month0);
        int v1 = v - y0.a.a.e(this.f);
        boolean z = false;
        boolean z1 = Math.abs(v1) > 3;
        if(v1 > 0) {
            z = true;
        }
        this.f = month0;
        if(z1 && z) {
            this.j.scrollToPosition(v - 3);
            this.j.post(new k(this, v));
            return;
        }
        if(z1) {
            this.j.scrollToPosition(v + 3);
            this.j.post(new k(this, v));
            return;
        }
        this.j.post(new k(this, v));
    }

    public final void n(int v) {
        this.g = v;
        if(v == 2) {
            this.i.getLayoutManager().scrollToPosition(this.f.c - ((H)this.i.getAdapter()).a.d.a.c);
            this.m.setVisibility(0);
            this.n.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            return;
        }
        if(v == 1) {
            this.m.setVisibility(8);
            this.n.setVisibility(0);
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            this.m(this.f);
        }
    }

    @Override  // androidx.fragment.app.I
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        this.b = bundle0.getInt("THEME_RES_ID_KEY");
        this.c = (DateSelector)bundle0.getParcelable("GRID_SELECTOR_KEY");
        this.d = (CalendarConstraints)bundle0.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.e = (DayViewDecorator)bundle0.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f = (Month)bundle0.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override  // androidx.fragment.app.I
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        int v1;
        int v;
        ContextThemeWrapper contextThemeWrapper0 = new ContextThemeWrapper(this.getContext(), this.b);
        this.h = new d0(contextThemeWrapper0);
        LayoutInflater layoutInflater1 = layoutInflater0.cloneInContext(contextThemeWrapper0);
        Month month0 = this.d.a;
        if(s.o(contextThemeWrapper0, 0x101020D)) {
            v = 0x7F0D053E;  // layout:mtrl_calendar_vertical
            v1 = 1;
        }
        else {
            v = 0x7F0D0539;  // layout:mtrl_calendar_horizontal
            v1 = 0;
        }
        View view0 = layoutInflater1.inflate(v, viewGroup0, false);
        Resources resources0 = this.requireContext().getResources();
        int v2 = resources0.getDimensionPixelSize(0x7F07036D);  // dimen:mtrl_calendar_navigation_height
        int v3 = resources0.getDimensionPixelOffset(0x7F07036E);  // dimen:mtrl_calendar_navigation_top_padding
        int v4 = resources0.getDimensionPixelOffset(0x7F07036C);  // dimen:mtrl_calendar_navigation_bottom_padding
        int v5 = resources0.getDimensionPixelSize(0x7F07035D);  // dimen:mtrl_calendar_days_of_week_height
        int v6 = resources0.getDimensionPixelSize(0x7F070358);  // dimen:mtrl_calendar_day_height
        int v7 = resources0.getDimensionPixelOffset(0x7F07036B);  // dimen:mtrl_calendar_month_vertical_padding
        int v8 = resources0.getDimensionPixelOffset(0x7F070355);  // dimen:mtrl_calendar_bottom_padding
        view0.setMinimumHeight(v4 + (v3 + v2) + v5 + (v7 * (v.g - 1) + v6 * v.g) + v8);
        GridView gridView0 = (GridView)view0.findViewById(0x7F0A086C);  // id:mtrl_calendar_days_of_week
        W.o(gridView0, new f(1));
        int v9 = this.d.e;
        gridView0.setAdapter((v9 <= 0 ? new i() : new i(v9)));
        gridView0.setNumColumns(month0.d);
        gridView0.setEnabled(false);
        this.j = (RecyclerView)view0.findViewById(0x7F0A086F);  // id:mtrl_calendar_months
        this.getContext();
        l l0 = new l(this, v1, v1);
        this.j.setLayoutManager(l0);
        this.j.setTag("MONTHS_VIEW_GROUP_TAG");
        y y0 = new y(contextThemeWrapper0, this.c, this.d, this.e, new m(this));
        this.j.setAdapter(y0);
        int v10 = contextThemeWrapper0.getResources().getInteger(0x7F0B0044);  // integer:mtrl_calendar_year_selector_span
        RecyclerView recyclerView0 = (RecyclerView)view0.findViewById(0x7F0A0872);  // id:mtrl_calendar_year_selector_frame
        this.i = recyclerView0;
        if(recyclerView0 != null) {
            recyclerView0.setHasFixedSize(true);
            this.i.setLayoutManager(new GridLayoutManager(v10));
            this.i.setAdapter(new H(this));
            this.i.addItemDecoration(new n(this));
        }
        if(view0.findViewById(0x7F0A0813) != null) {  // id:month_navigation_fragment_toggle
            MaterialButton materialButton0 = (MaterialButton)view0.findViewById(0x7F0A0813);  // id:month_navigation_fragment_toggle
            materialButton0.setTag("SELECTOR_TOGGLE_TAG");
            W.o(materialButton0, new c(this, 2));
            View view1 = view0.findViewById(0x7F0A0815);  // id:month_navigation_previous
            this.k = view1;
            view1.setTag("NAVIGATION_PREV_TAG");
            View view2 = view0.findViewById(0x7F0A0814);  // id:month_navigation_next
            this.l = view2;
            view2.setTag("NAVIGATION_NEXT_TAG");
            this.m = view0.findViewById(0x7F0A0872);  // id:mtrl_calendar_year_selector_frame
            this.n = view0.findViewById(0x7F0A086B);  // id:mtrl_calendar_day_selector_frame
            this.n(1);
            materialButton0.setText(this.f.d());
            this.j.addOnScrollListener(new o(this, y0, materialButton0));
            materialButton0.setOnClickListener(new a(this, 2));
            this.l.setOnClickListener(new j(this, y0, 1));
            this.k.setOnClickListener(new j(this, y0, 0));
        }
        if(!s.o(contextThemeWrapper0, 0x101020D)) {
            new f0().a(this.j);
        }
        this.j.scrollToPosition(y0.a.a.e(this.f));
        W.o(this.j, new f(2));
        return view0;
    }

    @Override  // androidx.fragment.app.I
    public final void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("THEME_RES_ID_KEY", this.b);
        bundle0.putParcelable("GRID_SELECTOR_KEY", this.c);
        bundle0.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.d);
        bundle0.putParcelable("DAY_VIEW_DECORATOR_KEY", this.e);
        bundle0.putParcelable("CURRENT_MONTH_KEY", this.f);
    }
}

