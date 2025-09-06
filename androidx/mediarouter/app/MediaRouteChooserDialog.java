package androidx.mediarouter.app;

import Bb.e;
import De.I;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.method.LinkMovementMethod;
import android.view.ContextThemeWrapper;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l4.G;
import l4.O;
import l4.Q;
import ye.a;

public class MediaRouteChooserDialog extends AppCompatDialog {
    public ListView B;
    public b D;
    public final z E;
    public boolean G;
    public long I;
    public final e M;
    public static final int N;
    public final Q f;
    public final D g;
    public G h;
    public ArrayList i;
    public TextView j;
    public TextView k;
    public RelativeLayout l;
    public TextView m;
    public TextView n;
    public LinearLayout o;
    public Button r;
    public ProgressBar w;

    public MediaRouteChooserDialog(Context context0) {
        ContextThemeWrapper contextThemeWrapper0 = I.w(context0, false);
        int v = I.L(contextThemeWrapper0, 0x7F04043A);  // attr:mediaRouteTheme
        if(v == 0) {
            v = I.J(contextThemeWrapper0);
        }
        super(contextThemeWrapper0, v);
        this.h = G.c;
        this.M = new e(this, 8);
        this.f = Q.d(this.getContext());
        this.g = new D(this, 2);
        this.E = new z(this, 2);
    }

    public final void d(List list0) {
        this.I = SystemClock.uptimeMillis();
        this.i.clear();
        this.i.addAll(list0);
        this.D.notifyDataSetChanged();
        e e0 = this.M;
        e0.removeMessages(3);
        e0.removeMessages(2);
        if(list0.isEmpty()) {
            this.g(0);
            e0.sendMessageDelayed(e0.obtainMessage(2), 5000L);
            return;
        }
        this.g(1);
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void dismiss() {
        try {
            this.getContext().unregisterReceiver(this.E);
        }
        catch(IllegalArgumentException unused_ex) {
        }
        super.dismiss();
    }

    public final void e() {
        if(this.G) {
            this.f.getClass();
            ArrayList arrayList0 = new ArrayList(Q.f());
            for(int v = arrayList0.size(); v > 0; --v) {
                O o0 = (O)arrayList0.get(v - 1);
                if(o0.d() || !o0.g || !o0.h(this.h)) {
                    arrayList0.remove(v - 1);
                }
            }
            Collections.sort(arrayList0, c.b);
            if(SystemClock.uptimeMillis() - this.I >= 300L) {
                this.d(arrayList0);
                return;
            }
            this.M.removeMessages(1);
            Message message0 = this.M.obtainMessage(1, arrayList0);
            this.M.sendMessageAtTime(message0, this.I + 300L);
        }
    }

    public final void f(G g0) {
        if(g0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if(!this.h.equals(g0)) {
            this.h = g0;
            if(this.G) {
                this.f.j(this.g);
                this.f.a(g0, this.g, 1);
            }
            this.e();
        }
    }

    public final void g(int v) {
        switch(v) {
            case 0: {
                this.setTitle(0x7F1306B7);  // string:mr_chooser_title "Cast to"
                this.B.setVisibility(8);
                this.k.setVisibility(0);
                this.w.setVisibility(0);
                this.o.setVisibility(8);
                this.r.setVisibility(8);
                this.n.setVisibility(8);
                this.l.setVisibility(8);
                return;
            }
            case 1: {
                this.setTitle(0x7F1306B7);  // string:mr_chooser_title "Cast to"
                this.B.setVisibility(0);
                this.k.setVisibility(8);
                this.w.setVisibility(8);
                this.o.setVisibility(8);
                this.r.setVisibility(8);
                this.n.setVisibility(8);
                this.l.setVisibility(8);
                return;
            }
            case 2: {
                this.setTitle(0x7F1306B7);  // string:mr_chooser_title "Cast to"
                this.B.setVisibility(8);
                this.k.setVisibility(8);
                this.w.setVisibility(0);
                this.o.setVisibility(8);
                this.r.setVisibility(8);
                this.n.setVisibility(4);
                this.l.setVisibility(0);
                return;
            }
            case 3: {
                this.setTitle(0x7F1306BF);  // string:mr_chooser_zero_routes_found_title "No devices available"
                this.B.setVisibility(8);
                this.k.setVisibility(8);
                this.w.setVisibility(8);
                this.o.setVisibility(0);
                this.r.setVisibility(0);
                this.n.setVisibility(0);
                this.l.setVisibility(0);
            }
        }
    }

    @Override  // android.app.Dialog
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.G = true;
        this.f.a(this.h, this.g, 1);
        this.e();
        this.M.removeMessages(2);
        this.M.removeMessages(3);
        this.M.removeMessages(1);
        Message message0 = this.M.obtainMessage(2);
        this.M.sendMessageDelayed(message0, 5000L);
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void onCreate(Bundle bundle0) {
        String s;
        boolean z1;
        super.onCreate(bundle0);
        this.setContentView(0x7F0D0526);  // layout:mr_chooser_dialog
        this.i = new ArrayList();
        this.D = new b(this.getContext(), this.i);
        this.j = (TextView)this.findViewById(0x7F0A0848);  // id:mr_chooser_title
        this.k = (TextView)this.findViewById(0x7F0A0847);  // id:mr_chooser_searching
        this.l = (RelativeLayout)this.findViewById(0x7F0A084B);  // id:mr_chooser_wifi_warning_container
        this.m = (TextView)this.findViewById(0x7F0A084C);  // id:mr_chooser_wifi_warning_description
        this.n = (TextView)this.findViewById(0x7F0A0849);  // id:mr_chooser_wifi_learn_more
        this.o = (LinearLayout)this.findViewById(0x7F0A0841);  // id:mr_chooser_ok_button_container
        this.r = (Button)this.findViewById(0x7F0A0840);  // id:mr_chooser_ok_button
        this.w = (ProgressBar)this.findViewById(0x7F0A0846);  // id:mr_chooser_search_progress_bar
        Context context0 = this.getContext();
        boolean z = false;
        if(a.f == null) {
            if(a.M(context0)) {
                z1 = false;
            }
            else {
                PackageManager packageManager0 = context0.getPackageManager();
                if(a.j == null) {
                    a.j = Boolean.valueOf(packageManager0.hasSystemFeature("android.hardware.type.watch"));
                }
                if(a.j.booleanValue()) {
                    z1 = false;
                }
                else {
                    PackageManager packageManager1 = context0.getPackageManager();
                    if(a.k == null) {
                        a.k = Boolean.valueOf(packageManager1.hasSystemFeature("android.hardware.type.automotive"));
                    }
                    z1 = a.k.booleanValue() || a.N(context0) ? false : true;
                }
            }
            a.f = Boolean.valueOf(z1);
        }
        if(a.f.booleanValue()) {
            s = "Make sure the other device is on the same Wi-Fi network as this phone";
        }
        else {
            if(a.h == null) {
                SensorManager sensorManager0 = (SensorManager)context0.getSystemService("sensor");
                if(Build.VERSION.SDK_INT >= 30 && sensorManager0 != null && sensorManager0.getDefaultSensor(36) != null) {
                    z = true;
                }
                a.h = Boolean.valueOf(z);
            }
            if(a.h.booleanValue()) {
                s = "Make sure the other device is on the same Wi-Fi network as this phone";
            }
            else if(a.M(context0) || a.L(context0.getResources())) {
                s = "Make sure the other device is on the same Wi-Fi network as this tablet";
            }
            else if(a.N(context0)) {
                s = "Make sure the other device is on the same Wi-Fi network as this tv";
            }
            else {
                PackageManager packageManager2 = context0.getPackageManager();
                if(a.j == null) {
                    a.j = Boolean.valueOf(packageManager2.hasSystemFeature("android.hardware.type.watch"));
                }
                if(a.j.booleanValue()) {
                    s = "Make sure the other device is on the same Wi-Fi network as this watch";
                }
                else {
                    PackageManager packageManager3 = context0.getPackageManager();
                    if(a.k == null) {
                        a.k = Boolean.valueOf(packageManager3.hasSystemFeature("android.hardware.type.automotive"));
                    }
                    s = a.k.booleanValue() ? "Make sure the other device is on the same Wi-Fi network as this car" : "Make sure the other device is on the same Wi-Fi network as this device";
                }
            }
        }
        this.m.setText(s);
        this.n.setMovementMethod(LinkMovementMethod.getInstance());
        this.r.setOnClickListener(new A6.b(this, 18));
        ListView listView0 = (ListView)this.findViewById(0x7F0A083F);  // id:mr_chooser_list
        this.B = listView0;
        listView0.setAdapter(this.D);
        this.B.setOnItemClickListener(this.D);
        this.B.setEmptyView(this.findViewById(0x1020004));
        this.getWindow().setLayout(B.a.z(this.getContext()), -2);
        IntentFilter intentFilter0 = new IntentFilter("android.intent.action.SCREEN_OFF");
        this.getContext().registerReceiver(this.E, intentFilter0);
    }

    @Override  // android.app.Dialog
    public final void onDetachedFromWindow() {
        this.G = false;
        this.f.j(this.g);
        this.M.removeMessages(1);
        this.M.removeMessages(2);
        this.M.removeMessages(3);
        super.onDetachedFromWindow();
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void setTitle(int v) {
        this.j.setText(v);
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void setTitle(CharSequence charSequence0) {
        this.j.setText(charSequence0);
    }
}

