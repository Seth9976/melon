package E2;

import G.I;
import G.j0;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import androidx.compose.runtime.O0;
import androidx.fragment.app.l0;
import androidx.fragment.app.m;
import androidx.fragment.app.n;
import e0.b;
import ie.H;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kg.d;
import kotlin.jvm.internal.r;
import we.a;

public final class c extends r implements a {
    public final int f;
    public final Object g;
    public final Object h;
    public final Object i;
    public final Object j;

    public c(Object object0, Object object1, Object object2, Object object3, int v) {
        this.f = v;
        this.g = object0;
        this.h = object1;
        this.i = object2;
        this.j = object3;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        int v;
        switch(this.f) {
            case 0: {
                Intent intent0 = (Intent)this.i;
                Activity activity0 = (Activity)this.h;
                String s = (String)this.g;
                if(s == null) {
                    throw new NullPointerException("Name is null");
                }
                if(s.equals("ACTIVITY")) {
                    v = 1;
                }
                else {
                    if(s.equals("BROADCAST")) {
                        v = 2;
                        goto label_25;
                    }
                    if(s.equals("SERVICE")) {
                        v = 3;
                        goto label_25;
                    }
                    if(s.equals("FOREGROUND_SERVICE")) {
                        v = 4;
                    }
                    else if(s.equals("CALLBACK")) {
                        v = 5;
                    }
                    else {
                        throw new IllegalArgumentException("No enum constant androidx.glance.appwidget.action.ActionTrampolineType." + s);
                    }
                }
            label_25:
                switch(b.b(v)) {
                    case 0: {
                        activity0.startActivity(intent0, ((Bundle)this.j));
                        return H.a;
                    }
                    case 2: {
                        activity0.startService(intent0);
                        return H.a;
                    }
                    case 3: {
                        f.a.a(activity0, intent0);
                        return H.a;
                    }
                    case 1: 
                    case 4: {
                        activity0.sendBroadcast(intent0);
                        return H.a;
                    }
                    default: {
                        return H.a;
                    }
                }
            }
            case 1: {
                Number number0 = (Number)this.i;
                Number number1 = (Number)this.g;
                I i0 = (I)this.h;
                if(!number1.equals(i0.a) || !number0.equals(i0.b)) {
                    i0.a = number1;
                    i0.b = number0;
                    i0.e = (G.H)this.j;
                    i0.f = new j0(((G.H)this.j), i0.c, number1, number0, null);
                    ((O0)i0.j.b).setValue(Boolean.TRUE);
                    i0.g = false;
                    i0.h = true;
                }
                return H.a;
            }
            case 2: {
                ViewGroup viewGroup0 = (ViewGroup)this.h;
                n n0 = (n)this.g;
                if(l0.P(2)) {
                    Log.v("FragmentManager", "Attempting to create TransitionSeekController");
                }
                Object object0 = this.i;
                Object object1 = n0.f.i(viewGroup0, object0);
                n0.q = object1;
                if(object1 == null) {
                    if(l0.P(2)) {
                        Log.v("FragmentManager", "TransitionSeekController was not created.");
                    }
                    n0.r = true;
                    return H.a;
                }
                ((kotlin.jvm.internal.H)this.j).a = new m(n0, object0, viewGroup0);
                if(l0.P(2)) {
                    Log.v("FragmentManager", "Started executing operations from " + n0.d + " to " + n0.e);
                }
                return H.a;
            }
            default: {
                try {
                    LinkedHashMap linkedHashMap0 = ((d)this.g).a(((Map)this.i));
                    ((kg.c)this.h).invoke(linkedHashMap0);
                }
                catch(IOException iOException0) {
                    ((kg.c)this.j).invoke(iOException0);
                }
                return H.a;
            }
        }
    }
}

