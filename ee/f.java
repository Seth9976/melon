package ee;

import De.d;
import S2.c;
import ae.a;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q0;
import de.e;
import fe.b;
import kotlin.jvm.internal.q;

public final class f implements b {
    public final AppCompatActivity a;
    public final AppCompatActivity b;
    public volatile a c;
    public final Object d;

    public f(AppCompatActivity appCompatActivity0) {
        this.d = new Object();
        this.a = appCompatActivity0;
        this.b = appCompatActivity0;
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        if(this.c == null) {
            Object object0 = this.d;
            synchronized(object0) {
                if(this.c == null) {
                    e e0 = new e(this.b, 1);
                    q0 q00 = this.a.getViewModelStore();
                    c c0 = this.a.getDefaultViewModelCreationExtras();
                    q.g(q00, "store");
                    q.g(c0, "defaultCreationExtras");
                    o9.b b0 = new o9.b(q00, e0, c0);
                    d d0 = df.d.y(ee.d.class);
                    String s = d0.l();
                    if(s == null) {
                        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                    }
                    this.c = ((ee.d)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s)).a;
                }
            }
        }
        return this.c;
    }
}

