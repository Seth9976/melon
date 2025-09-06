package B2;

import E9.w;
import K2.a;
import K2.c;
import U4.D;
import U4.d;
import U4.i;
import X0.u;
import X0.x;
import android.database.Cursor;
import androidx.room.O;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import com.iloen.melon.fragments.musicmessage.e;
import d5.p;
import ie.H;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.k;

public final class s extends r implements k {
    public final int f;
    public final String g;

    public s(String s, int v) {
        this.f = v;
        this.g = s;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        ArrayList arrayList0;
        switch(this.f) {
            case 0: {
                List list0 = e.k.z(this.g);
                ((a)object0).a.put(c.a, list0);
                return H.a;
            }
            case 1: {
                u.h(((x)object0), this.g);
                return H.a;
            }
            case 2: {
                u.h(((x)object0), this.g);
                u.k(((x)object0), 5);
                return H.a;
            }
            default: {
                q.g(((WorkDatabase)object0), "db");
                e e0 = d5.q.y;
                d5.s s0 = ((WorkDatabase)object0).g();
                s0.getClass();
                O o0 = O.c(1, "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
                o0.k(1, this.g);
                WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)s0.a;
                workDatabase_Impl0.assertNotSuspendingTransaction();
                workDatabase_Impl0.beginTransaction();
                try {
                    Cursor cursor0 = w.R(workDatabase_Impl0, o0, true);
                    try {
                        HashMap hashMap0 = new HashMap();
                        HashMap hashMap1 = new HashMap();
                        while(cursor0.moveToNext()) {
                            String s1 = cursor0.getString(0);
                            if(!hashMap0.containsKey(s1)) {
                                hashMap0.put(s1, new ArrayList());
                            }
                            String s2 = cursor0.getString(0);
                            if(!hashMap1.containsKey(s2)) {
                                hashMap1.put(s2, new ArrayList());
                            }
                        }
                        cursor0.moveToPosition(-1);
                        s0.b(hashMap0);
                        s0.a(hashMap1);
                        arrayList0 = new ArrayList(cursor0.getCount());
                        while(cursor0.moveToNext()) {
                            String s3 = cursor0.getString(0);
                            D d0 = d5.w.J(cursor0.getInt(1));
                            i i0 = i.a(cursor0.getBlob(2));
                            int v2 = cursor0.getInt(3);
                            int v3 = cursor0.getInt(4);
                            long v4 = cursor0.getLong(14);
                            long v5 = cursor0.getLong(15);
                            long v6 = cursor0.getLong(16);
                            int v7 = d5.w.G(cursor0.getInt(17));
                            long v8 = cursor0.getLong(18);
                            long v9 = cursor0.getLong(19);
                            int v10 = cursor0.getInt(20);
                            long v11 = cursor0.getLong(21);
                            int v12 = cursor0.getInt(22);
                            int v13 = d5.w.H(cursor0.getInt(5));
                            arrayList0.add(new p(s3, d0, i0, v4, v5, v6, new d(d5.w.U(cursor0.getBlob(6)), v13, cursor0.getInt(7) != 0, cursor0.getInt(8) != 0, cursor0.getInt(9) != 0, cursor0.getInt(10) != 0, cursor0.getLong(11), cursor0.getLong(12), d5.w.q(cursor0.getBlob(13))), v2, v7, v8, v9, v10, v3, v11, v12, ((ArrayList)hashMap0.get(cursor0.getString(0))), ((ArrayList)hashMap1.get(cursor0.getString(0)))));
                        }
                        workDatabase_Impl0.setTransactionSuccessful();
                    }
                    finally {
                        cursor0.close();
                        o0.release();
                    }
                }
                finally {
                    workDatabase_Impl0.endTransaction();
                }
                Object object1 = e0.apply(arrayList0);
                q.f(object1, "WORK_INFO_MAPPER.apply(d…kStatusPojoForName(name))");
                return (List)object1;
            }
        }
    }
}

