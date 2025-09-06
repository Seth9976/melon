package com.google.android.material.datepicker;

import A6.b;
import G.I0;
import H0.e;
import S1.c;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.l0;
import androidx.fragment.app.w;
import c2.C0;
import c2.D0;
import c2.E0;
import c2.M;
import c2.W;
import com.google.android.material.internal.CheckableImageButton;
import d6.a;
import e1.m;
import e1.n;
import java.util.LinkedHashSet;
import z6.i;

public final class s extends w {
    public CharSequence B;
    public int D;
    public CharSequence E;
    public int G;
    public CharSequence I;
    public TextView M;
    public TextView N;
    public CheckableImageButton S;
    public i T;
    public Button V;
    public boolean W;
    public CharSequence X;
    public CharSequence Y;
    public final LinkedHashSet a;
    public final LinkedHashSet b;
    public final LinkedHashSet c;
    public final LinkedHashSet d;
    public int e;
    public DateSelector f;
    public z g;
    public CalendarConstraints h;
    public DayViewDecorator i;
    public p j;
    public int k;
    public CharSequence l;
    public boolean m;
    public int n;
    public int o;
    public CharSequence r;
    public int w;

    public s() {
        this.a = new LinkedHashSet();
        this.b = new LinkedHashSet();
        this.c = new LinkedHashSet();
        this.d = new LinkedHashSet();
    }

    public final DateSelector m() {
        if(this.f == null) {
            this.f = (DateSelector)this.getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f;
    }

    public static int n(Context context0) {
        Resources resources0 = context0.getResources();
        int v = resources0.getDimensionPixelOffset(0x7F070356);  // dimen:mtrl_calendar_content_padding
        Month month0 = new Month(E.f());
        int v1 = resources0.getDimensionPixelSize(0x7F07035C);  // dimen:mtrl_calendar_day_width
        int v2 = resources0.getDimensionPixelOffset(0x7F07036A);  // dimen:mtrl_calendar_month_horizontal_padding
        return (month0.d - 1) * v2 + (v1 * month0.d + v * 2);
    }

    public static boolean o(Context context0, int v) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(m.A(context0, 0x7F040401, p.class.getCanonicalName()).data, new int[]{v});  // attr:materialCalendarStyle
        boolean z = typedArray0.getBoolean(0, false);
        typedArray0.recycle();
        return z;
    }

    @Override  // androidx.fragment.app.w
    public final void onCancel(DialogInterface dialogInterface0) {
        for(Object object0: this.c) {
            ((DialogInterface.OnCancelListener)object0).onCancel(dialogInterface0);
        }
        super.onCancel(dialogInterface0);
    }

    @Override  // androidx.fragment.app.w
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        this.e = bundle0.getInt("OVERRIDE_THEME_RES_ID");
        this.f = (DateSelector)bundle0.getParcelable("DATE_SELECTOR_KEY");
        this.h = (CalendarConstraints)bundle0.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.i = (DayViewDecorator)bundle0.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.k = bundle0.getInt("TITLE_TEXT_RES_ID_KEY");
        this.l = bundle0.getCharSequence("TITLE_TEXT_KEY");
        this.n = bundle0.getInt("INPUT_MODE_KEY");
        this.o = bundle0.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.r = bundle0.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.w = bundle0.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.B = bundle0.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.D = bundle0.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.E = bundle0.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.G = bundle0.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.I = bundle0.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence charSequence0 = this.l == null ? this.requireContext().getResources().getText(this.k) : this.l;
        this.X = charSequence0;
        if(charSequence0 == null) {
            charSequence0 = null;
        }
        else {
            String[] arr_s = TextUtils.split(String.valueOf(charSequence0), "\n");
            if(arr_s.length > 1) {
                charSequence0 = arr_s[0];
            }
        }
        this.Y = charSequence0;
    }

    @Override  // androidx.fragment.app.w
    public final Dialog onCreateDialog(Bundle bundle0) {
        Context context0 = this.requireContext();
        Context context1 = this.requireContext();
        Dialog dialog0 = new Dialog(context0, (this.e == 0 ? this.m().g(context1) : this.e));
        Context context2 = dialog0.getContext();
        this.m = s.o(context2, 0x101020D);
        this.T = new i(context2, null, 0x7F040401, 0x7F1404AA);  // attr:materialCalendarStyle
        TypedArray typedArray0 = context2.obtainStyledAttributes(null, a.C, 0x7F040401, 0x7F1404AA);  // attr:materialCalendarStyle
        int v = typedArray0.getColor(1, 0);
        typedArray0.recycle();
        this.T.k(context2);
        this.T.m(ColorStateList.valueOf(v));
        this.T.l(M.e(dialog0.getWindow().getDecorView()));
        return dialog0;
    }

    @Override  // androidx.fragment.app.I
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        View view0 = layoutInflater0.inflate((this.m ? 0x7F0D0545 : 0x7F0D0544), viewGroup0);  // layout:mtrl_picker_fullscreen
        Context context0 = view0.getContext();
        if(this.m) {
            view0.findViewById(0x7F0A086D).setLayoutParams(new LinearLayout.LayoutParams(s.n(context0), -2));  // id:mtrl_calendar_frame
        }
        else {
            view0.findViewById(0x7F0A086E).setLayoutParams(new LinearLayout.LayoutParams(s.n(context0), -1));  // id:mtrl_calendar_main_pane
        }
        TextView textView0 = (TextView)view0.findViewById(0x7F0A0879);  // id:mtrl_picker_header_selection_text
        this.N = textView0;
        textView0.setAccessibilityLiveRegion(1);
        this.S = (CheckableImageButton)view0.findViewById(0x7F0A087B);  // id:mtrl_picker_header_toggle
        this.M = (TextView)view0.findViewById(0x7F0A087F);  // id:mtrl_picker_title_text
        this.S.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton0 = this.S;
        StateListDrawable stateListDrawable0 = new StateListDrawable();
        Drawable drawable0 = d5.w.B(context0, 0x7F0806B3);  // drawable:material_ic_calendar_black_24dp
        stateListDrawable0.addState(new int[]{0x10100A0}, drawable0);
        Drawable drawable1 = d5.w.B(context0, 0x7F0806B5);  // drawable:material_ic_edit_black_24dp
        stateListDrawable0.addState(new int[0], drawable1);
        checkableImageButton0.setImageDrawable(stateListDrawable0);
        this.S.setChecked(this.n != 0);
        W.o(this.S, null);
        this.q(this.S);
        this.S.setOnClickListener(new b(this, 22));
        this.V = (Button)view0.findViewById(0x7F0A0311);  // id:confirm_button
        if(this.m().X()) {
            this.V.setEnabled(true);
        }
        else {
            this.V.setEnabled(false);
        }
        this.V.setTag("CONFIRM_BUTTON_TAG");
        CharSequence charSequence0 = this.r;
        if(charSequence0 == null) {
            int v = this.o;
            if(v != 0) {
                this.V.setText(v);
            }
        }
        else {
            this.V.setText(charSequence0);
        }
        CharSequence charSequence1 = this.B;
        if(charSequence1 != null) {
            this.V.setContentDescription(charSequence1);
        }
        else if(this.w != 0) {
            this.V.setContentDescription(this.getContext().getResources().getText(this.w));
        }
        this.V.setOnClickListener(new q(this, 0));
        Button button0 = (Button)view0.findViewById(0x7F0A01F5);  // id:cancel_button
        button0.setTag("CANCEL_BUTTON_TAG");
        CharSequence charSequence2 = this.E;
        if(charSequence2 == null) {
            int v1 = this.D;
            if(v1 != 0) {
                button0.setText(v1);
            }
        }
        else {
            button0.setText(charSequence2);
        }
        CharSequence charSequence3 = this.I;
        if(charSequence3 != null) {
            button0.setContentDescription(charSequence3);
        }
        else if(this.G != 0) {
            button0.setContentDescription(this.getContext().getResources().getText(this.G));
        }
        button0.setOnClickListener(new q(this, 1));
        return view0;
    }

    @Override  // androidx.fragment.app.w
    public final void onDismiss(DialogInterface dialogInterface0) {
        for(Object object0: this.d) {
            ((DialogInterface.OnDismissListener)object0).onDismiss(dialogInterface0);
        }
        ViewGroup viewGroup0 = (ViewGroup)this.getView();
        if(viewGroup0 != null) {
            viewGroup0.removeAllViews();
        }
        super.onDismiss(dialogInterface0);
    }

    @Override  // androidx.fragment.app.w
    public final void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("OVERRIDE_THEME_RES_ID", this.e);
        bundle0.putParcelable("DATE_SELECTOR_KEY", this.f);
        CalendarConstraints calendarConstraints0 = this.h;
        com.google.android.material.datepicker.b b0 = new com.google.android.material.datepicker.b();  // 初始化器: Ljava/lang/Object;-><init>()V
        new DateValidatorPointForward(0x8000000000000000L);
        long v = calendarConstraints0.a.f;
        long v1 = calendarConstraints0.b.f;
        b0.a = calendarConstraints0.d.f;
        int v2 = calendarConstraints0.e;
        DateValidator calendarConstraints$DateValidator0 = calendarConstraints0.c;
        b0.b = calendarConstraints$DateValidator0;
        Month month0 = this.j == null ? null : this.j.f;
        if(month0 != null) {
            b0.a = month0.f;
        }
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("DEEP_COPY_VALIDATOR_KEY", calendarConstraints$DateValidator0);
        bundle0.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(Month.b(v), Month.b(v1), ((DateValidator)bundle1.getParcelable("DEEP_COPY_VALIDATOR_KEY")), (b0.a == null ? null : Month.b(((long)b0.a))), v2));
        bundle0.putParcelable("DAY_VIEW_DECORATOR_KEY", this.i);
        bundle0.putInt("TITLE_TEXT_RES_ID_KEY", this.k);
        bundle0.putCharSequence("TITLE_TEXT_KEY", this.l);
        bundle0.putInt("INPUT_MODE_KEY", this.n);
        bundle0.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.o);
        bundle0.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.r);
        bundle0.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.w);
        bundle0.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.B);
        bundle0.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.D);
        bundle0.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.E);
        bundle0.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.G);
        bundle0.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.I);
    }

    @Override  // androidx.fragment.app.w
    public final void onStart() {
        D0 d01;
        D0 d00;
        super.onStart();
        Window window0 = this.requireDialog().getWindow();
        if(this.m) {
            window0.setLayout(-1, -1);
            window0.setBackgroundDrawable(this.T);
            if(!this.W) {
                View view0 = this.requireView().findViewById(0x7F0A04E5);  // id:fullscreen_header
                ColorStateList colorStateList0 = e2.a.F(view0.getBackground());
                Integer integer0 = colorStateList0 == null ? null : colorStateList0.getDefaultColor();
                int v = Build.VERSION.SDK_INT;
                boolean z = false;
                int v1 = n.o(window0.getContext(), 0x1010031, 0xFF000000);
                if(integer0 == null || ((int)integer0) == 0) {
                    integer0 = v1;
                }
                e.W(window0, false);
                window0.getContext();
                int v2 = v >= 27 ? 0 : c.k(n.o(window0.getContext(), 0x1010452, 0xFF000000), 0x80);
                window0.setStatusBarColor(0);
                window0.setNavigationBarColor(v2);
                boolean z1 = n.x(((int)integer0));
                boolean z2 = n.x(0) || z1;
                androidx.lifecycle.b b0 = new androidx.lifecycle.b(window0.getDecorView());
                if(v >= 35) {
                    d00 = new E0(window0, b0);  // 初始化器: Lc2/D0;-><init>(Landroid/view/Window;Landroidx/lifecycle/b;)V
                }
                else if(v >= 30) {
                    d00 = new D0(window0, b0);
                }
                else {
                    d00 = new C0(window0, b0);
                }
                d00.Q(z2);
                boolean z3 = n.x(v1);
                if(n.x(v2) || v2 == 0 && z3) {
                    z = true;
                }
                androidx.lifecycle.b b1 = new androidx.lifecycle.b(window0.getDecorView());
                int v3 = Build.VERSION.SDK_INT;
                if(v3 >= 35) {
                    d01 = new E0(window0, b1);  // 初始化器: Lc2/D0;-><init>(Landroid/view/Window;Landroidx/lifecycle/b;)V
                }
                else if(v3 >= 30) {
                    d01 = new D0(window0, b1);
                }
                else {
                    d01 = new C0(window0, b1);
                }
                d01.P(z);
                int v4 = view0.getPaddingTop();
                M.n(view0, new I0(view0, view0.getLayoutParams().height, v4));
                this.W = true;
            }
        }
        else {
            window0.setLayout(-2, -2);
            int v5 = this.getResources().getDimensionPixelOffset(0x7F07035E);  // dimen:mtrl_calendar_dialog_background_inset
            Rect rect0 = new Rect(v5, v5, v5, v5);
            window0.setBackgroundDrawable(new InsetDrawable(this.T, v5, v5, v5, v5));
            window0.getDecorView().setOnTouchListener(new o6.a(this.requireDialog(), rect0));
        }
        this.p();
    }

    @Override  // androidx.fragment.app.w
    public final void onStop() {
        this.g.a.clear();
        super.onStop();
    }

    public final void p() {
        Context context0 = this.requireContext();
        int v = this.e == 0 ? this.m().g(context0) : this.e;
        DateSelector dateSelector0 = this.m();
        CalendarConstraints calendarConstraints0 = this.h;
        DayViewDecorator dayViewDecorator0 = this.i;
        p p0 = new p();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("THEME_RES_ID_KEY", v);
        bundle0.putParcelable("GRID_SELECTOR_KEY", dateSelector0);
        bundle0.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints0);
        bundle0.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator0);
        bundle0.putParcelable("CURRENT_MONTH_KEY", calendarConstraints0.d);
        p0.setArguments(bundle0);
        this.j = p0;
        if(this.n == 1) {
            DateSelector dateSelector1 = this.m();
            CalendarConstraints calendarConstraints1 = this.h;
            t t0 = new t();
            Bundle bundle1 = new Bundle();
            bundle1.putInt("THEME_RES_ID_KEY", v);
            bundle1.putParcelable("DATE_SELECTOR_KEY", dateSelector1);
            bundle1.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints1);
            t0.setArguments(bundle1);
            p0 = t0;
        }
        this.g = p0;
        this.M.setText((this.n != 1 || this.getResources().getConfiguration().orientation != 2 ? this.X : this.Y));
        String s = this.m().l(this.getContext());
        this.N.setContentDescription(this.m().f(this.requireContext()));
        this.N.setText(s);
        l0 l00 = this.getChildFragmentManager();
        l00.getClass();
        androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
        a0.g(0x7F0A086D, this.g, null);  // id:mtrl_calendar_frame
        a0.m();
        this.g.l(new r(this, 0));
    }

    public final void q(CheckableImageButton checkableImageButton0) {
        this.S.setContentDescription((this.n == 1 ? "Switch to calendar input mode" : "Switch to text input mode"));
    }
}

