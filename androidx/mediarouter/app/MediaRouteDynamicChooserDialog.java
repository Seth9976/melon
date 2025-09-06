package androidx.mediarouter.app;

import B.a;
import Bb.e;
import De.I;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import l4.G;
import l4.O;
import l4.Q;

public class MediaRouteDynamicChooserDialog extends AppCompatDialog {
    public final Q f;
    public final D g;
    public final Context h;
    public G i;
    public ArrayList j;
    public x k;
    public RecyclerView l;
    public boolean m;
    public O n;
    public final long o;
    public long r;
    public final e w;

    public MediaRouteDynamicChooserDialog(Context context0) {
        ContextThemeWrapper contextThemeWrapper0 = I.w(context0, false);
        int v = I.L(contextThemeWrapper0, 0x7F04043A);  // attr:mediaRouteTheme
        if(v == 0) {
            v = I.J(contextThemeWrapper0);
        }
        super(contextThemeWrapper0, v);
        this.i = G.c;
        this.w = new e(this, 9);
        Context context1 = this.getContext();
        this.f = Q.d(context1);
        this.g = new D(this, 4);
        this.h = context1;
        this.o = (long)context1.getResources().getInteger(0x7F0B003E);  // integer:mr_update_routes_delay_ms
    }

    public final void d() {
        if(this.n == null && this.m) {
            this.f.getClass();
            ArrayList arrayList0 = new ArrayList(Q.f());
            for(int v = arrayList0.size(); v > 0; --v) {
                O o0 = (O)arrayList0.get(v - 1);
                if(o0.d() || !o0.g || !o0.h(this.i)) {
                    arrayList0.remove(v - 1);
                }
            }
            Collections.sort(arrayList0, c.c);
            long v1 = SystemClock.uptimeMillis();
            long v2 = this.o;
            if(v1 - this.r >= v2) {
                this.r = SystemClock.uptimeMillis();
                this.j.clear();
                this.j.addAll(arrayList0);
                this.k.a();
                return;
            }
            this.w.removeMessages(1);
            Message message0 = this.w.obtainMessage(1, arrayList0);
            this.w.sendMessageAtTime(message0, this.r + v2);
        }
    }

    public final void e(G g0) {
        if(g0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if(!this.i.equals(g0)) {
            this.i = g0;
            if(this.m) {
                this.f.j(this.g);
                this.f.a(g0, this.g, 1);
            }
            this.d();
        }
    }

    @Override  // android.app.Dialog
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = true;
        this.f.a(this.i, this.g, 1);
        this.d();
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.setContentView(0x7F0D052A);  // layout:mr_picker_dialog
        View view0 = this.getWindow().getDecorView();
        int v = I.N(this.h) ? 0x7F0603FE : 0x7F0603FD;  // color:mr_dynamic_dialog_background_light
        view0.setBackgroundColor(P1.c.getColor(this.h, v));
        this.j = new ArrayList();
        ((ImageButton)this.findViewById(0x7F0A085B)).setOnClickListener(new B(this, 2));  // id:mr_picker_close_button
        this.k = new x(this);
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A085D);  // id:mr_picker_list
        this.l = recyclerView0;
        recyclerView0.setAdapter(this.k);
        this.l.setLayoutManager(new LinearLayoutManager(this.h));
        int v1 = -1;
        int v2 = this.h.getResources().getBoolean(0x7F050009) ? a.z(this.h) : -1;  // bool:is_tablet
        if(this.h.getResources().getBoolean(0x7F050009)) {  // bool:is_tablet
            v1 = -2;
        }
        this.getWindow().setLayout(v2, v1);
    }

    @Override  // android.app.Dialog
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = false;
        this.f.j(this.g);
        this.w.removeMessages(1);
    }
}

