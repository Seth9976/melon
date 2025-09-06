package k;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.view.menu.MenuBuilder;

public class u {
    public final Context a;
    public final MenuBuilder b;
    public final boolean c;
    public final int d;
    public View e;
    public int f;
    public boolean g;
    public v h;
    public s i;
    public PopupWindow.OnDismissListener j;
    public final t k;

    public u(Context context0, MenuBuilder menuBuilder0, View view0, boolean z, int v, int v1) {
        this.f = 0x800003;
        this.k = () -> {
            this.i = null;
            PopupWindow.OnDismissListener popupWindow$OnDismissListener0 = this.j;
            if(popupWindow$OnDismissListener0 != null) {
                popupWindow$OnDismissListener0.onDismiss();
            }
        };
        this.a = context0;
        this.b = menuBuilder0;
        this.e = view0;
        this.c = z;
        this.d = v;
    }

    public final s a() {
        if(this.i == null) {
            Context context0 = this.a;
            Display display0 = ((WindowManager)context0.getSystemService("window")).getDefaultDisplay();
            Point point0 = new Point();
            display0.getRealSize(point0);
            f f0 = Math.min(point0.x, point0.y) >= context0.getResources().getDimensionPixelSize(0x7F070016) ? new f(context0, this.e, this.d, this.c) : new B(this.a, this.b, this.e, this.d, this.c);  // dimen:abc_cascading_menus_min_smallest_width
            f0.l(this.b);
            f0.s(this.k);
            f0.o(this.e);
            f0.h(this.h);
            f0.p(this.g);
            f0.q(this.f);
            this.i = f0;
        }
        return this.i;
    }

    public final boolean b() {
        return this.i != null && this.i.a();
    }

    // 检测为 Lambda 实现
    public void c() [...]

    public final void d(int v, int v1, boolean z, boolean z1) {
        s s0 = this.a();
        s0.t(z1);
        if(z) {
            if((Gravity.getAbsoluteGravity(this.f, this.e.getLayoutDirection()) & 7) == 5) {
                v -= this.e.getWidth();
            }
            s0.r(v);
            s0.u(v1);
            int v2 = (int)(this.a.getResources().getDisplayMetrics().density * 48.0f / 2.0f);
            s0.a = new Rect(v - v2, v1 - v2, v + v2, v1 + v2);
        }
        s0.show();
    }
}

