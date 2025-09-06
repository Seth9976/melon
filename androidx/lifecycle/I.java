package androidx.lifecycle;

import android.view.View;
import c2.B0;
import com.google.android.material.bottomappbar.b;
import com.google.android.material.internal.B;
import com.google.android.material.internal.D;
import com.google.android.material.internal.E;
import java.util.ArrayDeque;

public final class i implements D {
    public boolean a;
    public boolean b;
    public boolean c;
    public final Object d;

    public i() {
        this.a = true;
        this.d = new ArrayDeque();
    }

    public i(boolean z, boolean z1, boolean z2, b b0) {
        this.a = z;
        this.b = z1;
        this.c = z2;
        this.d = b0;
    }

    public void a() {
        ArrayDeque arrayDeque0 = (ArrayDeque)this.d;
        if(this.c) {
            return;
        }
        try {
            this.c = true;
            while(!arrayDeque0.isEmpty() && (this.b || !this.a)) {
                Runnable runnable0 = (Runnable)arrayDeque0.poll();
                if(runnable0 != null) {
                    runnable0.run();
                }
            }
        }
        finally {
            this.c = false;
        }
    }

    @Override  // com.google.android.material.internal.D
    public B0 k(View view0, B0 b00, E e0) {
        if(this.a) {
            int v = e0.d;
            e0.d = b00.a() + v;
        }
        boolean z = B.l(view0);
        if(this.b) {
            if(z) {
                int v1 = e0.c;
                e0.c = b00.b() + v1;
            }
            else {
                int v2 = e0.a;
                e0.a = b00.b() + v2;
            }
        }
        if(this.c) {
            if(z) {
                int v3 = e0.a;
                e0.a = b00.c() + v3;
            }
            else {
                int v4 = e0.c;
                e0.c = b00.c() + v4;
            }
        }
        view0.setPaddingRelative(e0.a, e0.b, e0.c, e0.d);
        ((b)this.d).k(view0, b00, e0);
        return b00;
    }
}

