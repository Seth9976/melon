package X4;

import U4.k;
import U4.w;
import V4.c;
import Z4.l;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import d5.h;
import d5.q;
import d5.t;
import d5.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import je.p;

public final class b implements c {
    public final Context a;
    public final HashMap b;
    public final Object c;
    public final k d;
    public final v e;
    public static final String f;

    static {
        b.f = "WM-CommandHandler";
    }

    public b(Context context0, k k0, v v0) {
        this.a = context0;
        this.d = k0;
        this.e = v0;
        this.b = new HashMap();
        this.c = new Object();
    }

    public final void a(Intent intent0, int v, j j0) {
        List list0;
        Iterator iterator3;
        String s = intent0.getAction();
        if("ACTION_CONSTRAINTS_CHANGED".equals(s)) {
            w.e().a("WM-CommandHandler", "Handling constraints changed " + intent0);
            Context context0 = this.a;
            e e0 = new e(context0, this.d, v, j0);
            ArrayList arrayList0 = j0.e.j.g().h();
            boolean z = false;
            boolean z1 = false;
            boolean z2 = false;
            boolean z3 = false;
            for(Object object0: arrayList0) {
                z |= ((q)object0).j.e;
                z1 |= ((q)object0).j.c;
                z2 |= ((q)object0).j.f;
                z3 |= ((q)object0).j.a != 1;
                if(z && z1 && z2 && z3) {
                    break;
                }
            }
            Intent intent1 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            intent1.setComponent(new ComponentName(context0, ConstraintProxyUpdateReceiver.class));
            intent1.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z1).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z2).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z3);
            context0.sendBroadcast(intent1);
            ArrayList arrayList1 = new ArrayList(arrayList0.size());
            e0.a.getClass();
            long v1 = System.currentTimeMillis();
            for(Iterator iterator1 = arrayList0.iterator(); iterator1.hasNext(); iterator1 = iterator3) {
                Object object1 = iterator1.next();
                q q0 = (q)object1;
                if(v1 < q0.a()) {
                    iterator3 = iterator1;
                }
                else if(q0.b()) {
                    ArrayList arrayList2 = e0.c.a;
                    ArrayList arrayList3 = new ArrayList();
                    for(Object object2: arrayList2) {
                        if(((a5.e)object2).c(q0)) {
                            arrayList3.add(object2);
                        }
                    }
                    if(arrayList3.isEmpty()) {
                        iterator3 = iterator1;
                    }
                    else {
                        iterator3 = iterator1;
                        w.e().a("WM-WorkConstraintsTrack", "Work " + q0.a + " constrained by " + p.q0(arrayList3, null, null, null, l.f, 0x1F));
                    }
                    if(arrayList3.isEmpty()) {
                        arrayList1.add(q0);
                    }
                }
                else {
                    iterator3 = iterator1;
                    arrayList1.add(q0);
                }
            }
            for(Object object3: arrayList1) {
                d5.j j1 = t.i(((q)object3));
                Intent intent2 = new Intent(context0, SystemAlarmService.class);
                intent2.setAction("ACTION_DELAY_MET");
                b.c(intent2, j1);
                w.e().a("WM-ConstraintsCmdHandle", "Creating a delay_met command for workSpec with id (" + ((q)object3).a + ")");
                i i0 = new i(j0, intent2, e0.b, 0);
                j0.b.d.execute(i0);
            }
            return;
        }
        if("ACTION_RESCHEDULE".equals(s)) {
            w.e().a("WM-CommandHandler", "Handling reschedule " + intent0 + ", " + v);
            j0.e.f0();
            return;
        }
        Bundle bundle0 = intent0.getExtras();
        if(bundle0 != null && !bundle0.isEmpty() && bundle0.get("KEY_WORKSPEC_ID") != null) {
            if("ACTION_SCHEDULE_WORK".equals(s)) {
                d5.j j2 = b.b(intent0);
                w.e().a("WM-CommandHandler", "Handling schedule work for " + j2);
                WorkDatabase workDatabase0 = j0.e.j;
                workDatabase0.beginTransaction();
                try {
                    if(workDatabase0.g().j(j2.a) == null) {
                        w.e().h("WM-CommandHandler", "Skipping scheduling " + j2 + " because it\'s no longer in the DB");
                        return;
                    }
                    w.e().h("WM-CommandHandler", "Skipping scheduling " + j2 + "because it is finished.");
                }
                finally {
                    workDatabase0.endTransaction();
                }
                return;
            }
            if("ACTION_DELAY_MET".equals(s)) {
                synchronized(this.c) {
                    d5.j j3 = b.b(intent0);
                    w.e().a("WM-CommandHandler", "Handing delay met for " + j3);
                    if(this.b.containsKey(j3)) {
                        w.e().a("WM-CommandHandler", "WorkSpec " + j3 + " is is already being handled for ACTION_DELAY_MET");
                    }
                    else {
                        V4.k k0 = this.e.U(j3);
                        g g0 = new g(this.a, v, j0, k0);
                        this.b.put(j3, g0);
                        g0.e();
                    }
                }
                return;
            }
            if("ACTION_STOP_WORK".equals(s)) {
                v v4 = this.e;
                Bundle bundle1 = intent0.getExtras();
                String s1 = bundle1.getString("KEY_WORKSPEC_ID");
                if(bundle1.containsKey("KEY_WORKSPEC_GENERATION")) {
                    int v5 = bundle1.getInt("KEY_WORKSPEC_GENERATION");
                    list0 = new ArrayList(1);
                    V4.k k1 = v4.S(new d5.j(s1, v5));
                    if(k1 != null) {
                        ((ArrayList)list0).add(k1);
                    }
                }
                else {
                    list0 = v4.T(s1);
                }
                for(Object object5: list0) {
                    w.e().a("WM-CommandHandler", "Handing stopWork work for " + s1);
                    j0.j.getClass();
                    kotlin.jvm.internal.q.g(((V4.k)object5), "workSpecId");
                    j0.j.y(((V4.k)object5), 0xFFFFFE00);
                    d5.j j4 = ((V4.k)object5).a;
                    Context context1 = this.a;
                    d5.i i1 = j0.e.j.d();
                    d5.g g1 = i1.f(j4);
                    if(g1 != null) {
                        a.a(context1, j4, g1.c);
                        w.e().a("WM-Alarms", "Removing SystemIdInfo for workSpecId (" + j4 + ")");
                        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)i1.a;
                        workDatabase_Impl0.assertNotSuspendingTransaction();
                        h h0 = (h)i1.c;
                        H4.h h1 = h0.a();
                        h1.k(1, j4.a);
                        h1.a(2, ((long)j4.b));
                        try {
                            workDatabase_Impl0.beginTransaction();
                            try {
                                h1.w();
                                workDatabase_Impl0.setTransactionSuccessful();
                            }
                            catch(Throwable throwable0) {
                                workDatabase_Impl0.endTransaction();
                                throw throwable0;
                            }
                            workDatabase_Impl0.endTransaction();
                        }
                        finally {
                            h0.n(h1);
                        }
                    }
                    j0.e(j4, false);
                }
                return;
            }
            if("ACTION_EXECUTION_COMPLETED".equals(s)) {
                d5.j j5 = b.b(intent0);
                boolean z4 = intent0.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
                w.e().a("WM-CommandHandler", "Handling onExecutionCompleted " + intent0 + ", " + v);
                this.e(j5, z4);
                return;
            }
            w.e().h("WM-CommandHandler", "Ignoring intent " + intent0);
            return;
        }
        w.e().c("WM-CommandHandler", "Invalid request for " + s + " , requires KEY_WORKSPEC_ID .");
    }

    public static d5.j b(Intent intent0) {
        return new d5.j(intent0.getStringExtra("KEY_WORKSPEC_ID"), intent0.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static void c(Intent intent0, d5.j j0) {
        intent0.putExtra("KEY_WORKSPEC_ID", j0.a);
        intent0.putExtra("KEY_WORKSPEC_GENERATION", j0.b);
    }

    @Override  // V4.c
    public final void e(d5.j j0, boolean z) {
        synchronized(this.c) {
            g g0 = (g)this.b.remove(j0);
            this.e.S(j0);
            if(g0 != null) {
                g0.f(z);
            }
        }
    }
}

