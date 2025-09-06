package Cc;

import H0.d;
import android.view.KeyEvent;
import kotlin.jvm.internal.q;
import we.k;

public final class n1 implements k {
    public final int a;
    public static final n1 b;
    public static final n1 c;

    static {
        n1.b = new n1(0);
        n1.c = new n1(1);
    }

    public n1(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            boolean z = true;
            KeyEvent keyEvent0 = ((d)object0).a;
            q.g(keyEvent0, "keyEvent");
            if(keyEvent0.getKeyCode() != 62 || keyEvent0.getAction() != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        boolean z1 = true;
        KeyEvent keyEvent1 = ((d)object0).a;
        q.g(keyEvent1, "keyEvent");
        if(keyEvent1.getKeyCode() != 62 || keyEvent1.getAction() != 1) {
            z1 = false;
        }
        return Boolean.valueOf(z1);
    }
}

