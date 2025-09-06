package N4;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import androidx.collection.f;
import androidx.transition.Transition;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class k extends U {
    public final int a;
    public Object b;
    public Object c;

    public k() {
        this.a = 0;
        super();
    }

    public k(V v0, f f0) {
        this.a = 1;
        super();
        this.c = v0;
        this.b = f0;
    }

    @Override  // N4.U
    public void a() {
        if(this.a != 0) {
            return;
        }
        ((w)this.c).setVisibility(4);
    }

    @Override  // N4.U
    public void d() {
        if(this.a != 0) {
            return;
        }
        ((w)this.c).setVisibility(0);
    }

    @Override  // N4.U
    public final void f(Transition transition0) {
        if(this.a != 0) {
            ((ArrayList)((f)this.b).get(((V)this.c).b)).remove(transition0);
            transition0.A(this);
            return;
        }
        transition0.A(this);
        View view0 = (View)this.b;
        if(Build.VERSION.SDK_INT == 28) {
            if(!z.g) {
                try {
                    z.b();
                    Method method0 = z.b.getDeclaredMethod("removeGhost", View.class);
                    z.f = method0;
                    method0.setAccessible(true);
                }
                catch(NoSuchMethodException noSuchMethodException0) {
                    Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", noSuchMethodException0);
                }
                z.g = true;
            }
            Method method1 = z.f;
            if(method1 != null) {
                try {
                    method1.invoke(null, view0);
                    goto label_28;
                }
                catch(IllegalAccessException invocationTargetException0) {
                }
                catch(InvocationTargetException unused_ex) {
                    goto label_28;
                }
                throw new RuntimeException(invocationTargetException0.getCause());
            }
        }
        else {
            A a0 = (A)view0.getTag(0x7F0A04EE);  // id:ghost_view
            if(a0 != null) {
                int v = a0.d - 1;
                a0.d = v;
                if(v <= 0) {
                    ((y)a0.getParent()).removeView(a0);
                }
            }
        }
    label_28:
        view0.setTag(0x7F0A0BE5, null);  // id:transition_transform
        view0.setTag(0x7F0A0903, null);  // id:parent_matrix
    }
}

