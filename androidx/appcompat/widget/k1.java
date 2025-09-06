package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import c2.W;
import d5.m;
import g.a;

public final class k1 implements e0 {
    public final Toolbar a;
    public int b;
    public final View c;
    public Drawable d;
    public Drawable e;
    public Drawable f;
    public boolean g;
    public CharSequence h;
    public CharSequence i;
    public final CharSequence j;
    public Window.Callback k;
    public boolean l;
    public ActionMenuPresenter m;
    public final int n;
    public final Drawable o;

    public k1(Toolbar toolbar0, boolean z) {
        this.n = 0;
        this.a = toolbar0;
        this.h = toolbar0.getTitle();
        this.i = toolbar0.getSubtitle();
        this.g = this.h != null;
        this.f = toolbar0.getNavigationIcon();
        String s = null;
        m m0 = m.r(toolbar0.getContext(), null, a.a, 0x7F040008);  // attr:actionBarStyle
        TypedArray typedArray0 = (TypedArray)m0.c;
        int v = 15;
        this.o = m0.k(15);
        if(z) {
            CharSequence charSequence0 = typedArray0.getText(27);
            if(!TextUtils.isEmpty(charSequence0)) {
                this.g = true;
                Toolbar toolbar1 = this.a;
                this.h = charSequence0;
                if((this.b & 8) != 0) {
                    toolbar1.setTitle(charSequence0);
                    if(this.g) {
                        W.p(toolbar1.getRootView(), charSequence0);
                    }
                }
            }
            CharSequence charSequence1 = typedArray0.getText(25);
            if(!TextUtils.isEmpty(charSequence1)) {
                this.d(charSequence1);
            }
            Drawable drawable0 = m0.k(20);
            if(drawable0 != null) {
                this.e = drawable0;
                this.f();
            }
            Drawable drawable1 = m0.k(17);
            if(drawable1 != null) {
                this.d = drawable1;
                this.f();
            }
            if(this.f == null) {
                Drawable drawable2 = this.o;
                if(drawable2 != null) {
                    this.f = drawable2;
                    Toolbar toolbar2 = this.a;
                    if((this.b & 4) == 0) {
                        toolbar2.setNavigationIcon(null);
                    }
                    else {
                        toolbar2.setNavigationIcon(drawable2);
                    }
                }
            }
            this.c(typedArray0.getInt(10, 0));
            int v1 = typedArray0.getResourceId(9, 0);
            if(v1 != 0) {
                View view0 = LayoutInflater.from(toolbar0.getContext()).inflate(v1, toolbar0, false);
                View view1 = this.c;
                if(view1 != null && (this.b & 16) != 0) {
                    toolbar0.removeView(view1);
                }
                this.c = view0;
                if(view0 != null && (this.b & 16) != 0) {
                    toolbar0.addView(view0);
                }
                this.c(this.b | 16);
            }
            int v2 = typedArray0.getLayoutDimension(13, 0);
            if(v2 > 0) {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = toolbar0.getLayoutParams();
                viewGroup$LayoutParams0.height = v2;
                toolbar0.setLayoutParams(viewGroup$LayoutParams0);
            }
            int v3 = typedArray0.getDimensionPixelOffset(7, -1);
            int v4 = typedArray0.getDimensionPixelOffset(3, -1);
            if(v3 >= 0 || v4 >= 0) {
                toolbar0.d();
                toolbar0.E.a(Math.max(v3, 0), Math.max(v4, 0));
            }
            int v5 = typedArray0.getResourceId(28, 0);
            if(v5 != 0) {
                Context context0 = toolbar0.getContext();
                toolbar0.l = v5;
                AppCompatTextView appCompatTextView0 = toolbar0.b;
                if(appCompatTextView0 != null) {
                    appCompatTextView0.setTextAppearance(context0, v5);
                }
            }
            int v6 = typedArray0.getResourceId(26, 0);
            if(v6 != 0) {
                Context context1 = toolbar0.getContext();
                toolbar0.m = v6;
                AppCompatTextView appCompatTextView1 = toolbar0.c;
                if(appCompatTextView1 != null) {
                    appCompatTextView1.setTextAppearance(context1, v6);
                }
            }
            int v7 = typedArray0.getResourceId(22, 0);
            if(v7 != 0) {
                toolbar0.setPopupTheme(v7);
            }
        }
        else {
            if(toolbar0.getNavigationIcon() == null) {
                v = 11;
            }
            else {
                this.o = toolbar0.getNavigationIcon();
            }
            this.b = v;
        }
        m0.t();
        if(0x7F130001 != this.n) {  // string:abc_action_bar_up_description "Navigate up"
            this.n = 0x7F130001;  // string:abc_action_bar_up_description "Navigate up"
            if(TextUtils.isEmpty(toolbar0.getNavigationContentDescription())) {
                int v8 = this.n;
                if(v8 != 0) {
                    s = toolbar0.getContext().getString(v8);
                }
                this.j = s;
                this.e();
            }
        }
        this.j = toolbar0.getNavigationContentDescription();
        toolbar0.setNavigationOnClickListener(new i1(this));
    }

    public final void a() {
        ActionMenuView actionMenuView0 = this.a.a;
        if(actionMenuView0 != null) {
            ActionMenuPresenter actionMenuPresenter0 = actionMenuView0.E;
            if(actionMenuPresenter0 != null) {
                actionMenuPresenter0.l();
                f f0 = actionMenuPresenter0.G;
                if(f0 != null && f0.b()) {
                    f0.i.dismiss();
                }
            }
        }
    }

    public final boolean b() {
        ActionMenuView actionMenuView0 = this.a.a;
        return actionMenuView0 != null && (actionMenuView0.E != null && actionMenuView0.E.l());
    }

    public final void c(int v) {
        int v1 = this.b ^ v;
        this.b = v;
        if(v1 != 0) {
            if((v1 & 4) != 0) {
                if((v & 4) != 0) {
                    this.e();
                }
                Toolbar toolbar0 = this.a;
                if((this.b & 4) == 0) {
                    toolbar0.setNavigationIcon(null);
                }
                else {
                    toolbar0.setNavigationIcon((this.f == null ? this.o : this.f));
                }
            }
            if((v1 & 3) != 0) {
                this.f();
            }
            Toolbar toolbar1 = this.a;
            if((v1 & 8) != 0) {
                if((v & 8) == 0) {
                    toolbar1.setTitle(null);
                    toolbar1.setSubtitle(null);
                }
                else {
                    toolbar1.setTitle(this.h);
                    toolbar1.setSubtitle(this.i);
                }
            }
            if((v1 & 16) != 0) {
                View view0 = this.c;
                if(view0 != null) {
                    if((v & 16) != 0) {
                        toolbar1.addView(view0);
                        return;
                    }
                    toolbar1.removeView(view0);
                }
            }
        }
    }

    public final void d(CharSequence charSequence0) {
        this.i = charSequence0;
        if((this.b & 8) != 0) {
            this.a.setSubtitle(charSequence0);
        }
    }

    public final void e() {
        if((this.b & 4) != 0) {
            boolean z = TextUtils.isEmpty(this.j);
            Toolbar toolbar0 = this.a;
            if(z) {
                toolbar0.setNavigationContentDescription(this.n);
                return;
            }
            toolbar0.setNavigationContentDescription(this.j);
        }
    }

    public final void f() {
        Drawable drawable0;
        int v = this.b;
        if((v & 2) == 0) {
            drawable0 = null;
        }
        else if((v & 1) != 0) {
            drawable0 = this.e;
            if(drawable0 == null) {
                drawable0 = this.d;
            }
        }
        else {
            drawable0 = this.d;
        }
        this.a.setLogo(drawable0);
    }
}

