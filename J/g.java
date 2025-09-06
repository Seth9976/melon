package j;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.view.ActionProvider;
import com.iloen.melon.utils.a;
import java.lang.reflect.Constructor;
import k.m;
import k.r;

public final class g {
    public CharSequence A;
    public CharSequence B;
    public ColorStateList C;
    public PorterDuff.Mode D;
    public final SupportMenuInflater E;
    public final Menu a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public CharSequence k;
    public CharSequence l;
    public int m;
    public char n;
    public int o;
    public char p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public String x;
    public String y;
    public ActionProvider z;

    public g(SupportMenuInflater supportMenuInflater0, Menu menu0) {
        this.E = supportMenuInflater0;
        this.C = null;
        this.D = null;
        this.a = menu0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = true;
        this.g = true;
    }

    public final Object a(String s, Class[] arr_class, Object[] arr_object) {
        try {
            Constructor constructor0 = Class.forName(s, false, this.E.c.getClassLoader()).getConstructor(arr_class);
            constructor0.setAccessible(true);
            return constructor0.newInstance(arr_object);
        }
        catch(Exception exception0) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + s, exception0);
            return null;
        }
    }

    public final void b(MenuItem menuItem0) {
        boolean z = false;
        menuItem0.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
        int v = this.v;
        if(v >= 0) {
            menuItem0.setShowAsAction(v);
        }
        SupportMenuInflater supportMenuInflater0 = this.E;
        if(this.y != null) {
            if(supportMenuInflater0.c.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if(supportMenuInflater0.d == null) {
                supportMenuInflater0.d = SupportMenuInflater.a(supportMenuInflater0.c);
            }
            Object object0 = supportMenuInflater0.d;
            String s = this.y;
            f f0 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
            f0.a = object0;
            Class class0 = object0.getClass();
            try {
                f0.b = class0.getMethod(s, f.c);
            }
            catch(Exception exception0) {
                StringBuilder stringBuilder0 = a.n("Couldn\'t resolve menu item onClick handler ", s, " in class ");
                stringBuilder0.append(class0.getName());
                InflateException inflateException0 = new InflateException(stringBuilder0.toString());
                inflateException0.initCause(exception0);
                throw inflateException0;
            }
            menuItem0.setOnMenuItemClickListener(f0);
        }
        if(this.r >= 2) {
            if(menuItem0 instanceof m) {
                ((m)menuItem0).f(true);
            }
            else if(menuItem0 instanceof r) {
                r r0 = (r)menuItem0;
                U1.a a0 = r0.c;
                try {
                    if(r0.d == null) {
                        r0.d = a0.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    r0.d.invoke(a0, Boolean.TRUE);
                    goto label_39;
                }
                catch(Exception exception1) {
                }
                Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", exception1);
            }
        }
    label_39:
        String s1 = this.x;
        if(s1 != null) {
            menuItem0.setActionView(((View)this.a(s1, SupportMenuInflater.e, supportMenuInflater0.a)));
            z = true;
        }
        int v1 = this.w;
        if(v1 > 0) {
            if(z) {
                Log.w("SupportMenuInflater", "Ignoring attribute \'itemActionViewLayout\'. Action view already specified.");
            }
            else {
                menuItem0.setActionView(v1);
            }
        }
        ActionProvider actionProvider0 = this.z;
        if(actionProvider0 != null) {
            if(menuItem0 instanceof U1.a) {
                ((U1.a)menuItem0).b(actionProvider0);
            }
            else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence0 = this.A;
        if(menuItem0 instanceof U1.a) {
            ((U1.a)menuItem0).setContentDescription(charSequence0);
        }
        else {
            menuItem0.setContentDescription(charSequence0);
        }
        CharSequence charSequence1 = this.B;
        if(menuItem0 instanceof U1.a) {
            ((U1.a)menuItem0).setTooltipText(charSequence1);
        }
        else {
            menuItem0.setTooltipText(charSequence1);
        }
        int v2 = this.n;
        int v3 = this.o;
        if(menuItem0 instanceof U1.a) {
            ((U1.a)menuItem0).setAlphabeticShortcut(((char)v2), v3);
        }
        else {
            menuItem0.setAlphabeticShortcut(((char)v2), v3);
        }
        int v4 = this.p;
        int v5 = this.q;
        if(menuItem0 instanceof U1.a) {
            ((U1.a)menuItem0).setNumericShortcut(((char)v4), v5);
        }
        else {
            menuItem0.setNumericShortcut(((char)v4), v5);
        }
        PorterDuff.Mode porterDuff$Mode0 = this.D;
        if(porterDuff$Mode0 != null) {
            if(menuItem0 instanceof U1.a) {
                ((U1.a)menuItem0).setIconTintMode(porterDuff$Mode0);
            }
            else {
                menuItem0.setIconTintMode(porterDuff$Mode0);
            }
        }
        ColorStateList colorStateList0 = this.C;
        if(colorStateList0 != null) {
            if(menuItem0 instanceof U1.a) {
                ((U1.a)menuItem0).setIconTintList(colorStateList0);
                return;
            }
            menuItem0.setIconTintList(colorStateList0);
        }
    }
}

