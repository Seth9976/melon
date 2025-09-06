package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.view.LayoutInflater;

public class ContextThemeWrapper extends ContextWrapper {
    public int a;
    public Resources.Theme b;
    public LayoutInflater c;
    public Configuration d;
    public Resources e;
    public static Configuration f;

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context context0, int v) {
        super(context0);
        this.a = v;
    }

    public final void a(Configuration configuration0) {
        if(this.e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if(this.d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.d = new Configuration(configuration0);
    }

    @Override  // android.content.ContextWrapper
    public final void attachBaseContext(Context context0) {
        super.attachBaseContext(context0);
    }

    public final void b() {
        if(this.b == null) {
            this.b = this.getResources().newTheme();
            Resources.Theme resources$Theme0 = this.getBaseContext().getTheme();
            if(resources$Theme0 != null) {
                this.b.setTo(resources$Theme0);
            }
        }
        this.b.applyStyle(this.a, true);
    }

    @Override  // android.content.ContextWrapper
    public final AssetManager getAssets() {
        return this.getResources().getAssets();
    }

    @Override  // android.content.ContextWrapper
    public final Resources getResources() {
        if(this.e == null) {
            Configuration configuration0 = this.d;
            if(configuration0 != null) {
                if(ContextThemeWrapper.f == null) {
                    Configuration configuration1 = new Configuration();
                    configuration1.fontScale = 0.0f;
                    ContextThemeWrapper.f = configuration1;
                }
                if(!configuration0.equals(ContextThemeWrapper.f)) {
                    this.e = this.createConfigurationContext(this.d).getResources();
                    return this.e;
                }
            }
            this.e = super.getResources();
        }
        return this.e;
    }

    @Override  // android.content.ContextWrapper
    public final Object getSystemService(String s) {
        if("layout_inflater".equals(s)) {
            if(this.c == null) {
                this.c = LayoutInflater.from(this.getBaseContext()).cloneInContext(this);
            }
            return this.c;
        }
        return this.getBaseContext().getSystemService(s);
    }

    @Override  // android.content.ContextWrapper
    public final Resources.Theme getTheme() {
        Resources.Theme resources$Theme0 = this.b;
        if(resources$Theme0 != null) {
            return resources$Theme0;
        }
        if(this.a == 0) {
            this.a = 0x7F14029D;  // style:Theme.AppCompat.Light
        }
        this.b();
        return this.b;
    }

    @Override  // android.content.ContextWrapper
    public final void setTheme(int v) {
        if(this.a != v) {
            this.a = v;
            this.b();
        }
    }
}

