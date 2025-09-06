package ee;

import De.d;
import E9.w;
import S2.c;
import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q0;
import k8.e;
import k8.g;
import kotlin.jvm.internal.q;

public final class b implements fe.b {
    public volatile e a;
    public final Object b;
    public final AppCompatActivity c;
    public final f d;

    public b(AppCompatActivity appCompatActivity0) {
        this.b = new Object();
        this.c = appCompatActivity0;
        this.d = new f(appCompatActivity0);
    }

    public final e a() {
        AppCompatActivity appCompatActivity0 = this.c;
        if(!(appCompatActivity0.getApplication() instanceof fe.b)) {
            Class class0 = appCompatActivity0.getApplication().getClass();
            throw new IllegalStateException("Hilt Activity must be attached to an @HiltAndroidApp Application. " + (Application.class.equals(class0) ? "Did you forget to specify your Application\'s class name in your manifest\'s <application />\'s android:name attribute?" : "Found: " + appCompatActivity0.getApplication().getClass()));
        }
        g g0 = (g)(((a)w.s(this.d, a.class)));
        z6.f f0 = new z6.f(23);
        return new e(g0.a, g0.b, f0, appCompatActivity0);
    }

    public final j b() {
        de.e e0 = new de.e(this.d.b, 1);
        q0 q00 = this.d.a.getViewModelStore();
        c c0 = this.d.a.getDefaultViewModelCreationExtras();
        q.g(q00, "store");
        q.g(c0, "defaultCreationExtras");
        o9.b b0 = new o9.b(q00, e0, c0);
        d d0 = df.d.y(ee.d.class);
        String s = d0.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return ((ee.d)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s)).b;
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        if(this.a == null) {
            Object object0 = this.b;
            synchronized(object0) {
                if(this.a == null) {
                    this.a = this.a();
                }
            }
        }
        return this.a;
    }
}

