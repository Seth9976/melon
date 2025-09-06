package u0;

import P0.C0;
import P0.f;
import android.view.DragEvent;
import android.view.View.OnDragListener;
import android.view.View;
import androidx.collection.b;
import androidx.collection.g;
import androidx.compose.foundation.w;
import androidx.compose.ui.draganddrop.AndroidDragAndDropManager.modifier.1;
import kotlin.jvm.internal.C;
import pc.t;

public final class a implements View.OnDragListener, c {
    public final e a;
    public final g b;
    public final AndroidDragAndDropManager.modifier.1 c;

    public a() {
        e e0 = new e();  // 初始化器: Lr0/p;-><init>()V
        e0.c = 0L;
        this.a = e0;
        this.b = new g(0);
        this.c = new AndroidDragAndDropManager.modifier.1(this);
    }

    @Override  // android.view.View$OnDragListener
    public final boolean onDrag(View view0, DragEvent dragEvent0) {
        t t0 = new t(dragEvent0, 21);
        int v = dragEvent0.getAction();
        g g0 = this.b;
        e e0 = this.a;
        switch(v) {
            case 1: {
                C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                J0.e e1 = new J0.e(t0, e0, c0);
                if(e1.invoke(e0) == C0.a) {
                    f.z(e0, e1);
                }
                boolean z = c0.a;
                g0.getClass();
                b b0 = new b(g0);
                while(b0.hasNext()) {
                    ((e)b0.next()).q0(t0);
                }
                return z;
            }
            case 2: {
                e0.p0(t0);
                return false;
            }
            case 3: {
                return e0.m0(t0);
            }
            case 4: {
                w w0 = new w(t0, 20);
                if(w0.invoke(e0) == C0.a) {
                    f.z(e0, w0);
                }
                g0.clear();
                return false;
            }
            case 5: {
                e0.n0(t0);
                return false;
            }
            case 6: {
                e0.o0(t0);
                return false;
            }
            default: {
                return false;
            }
        }
    }
}

