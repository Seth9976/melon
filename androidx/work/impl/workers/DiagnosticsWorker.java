package androidx.work.impl.workers;

import E9.h;
import E9.w;
import U4.D;
import U4.d;
import U4.t;
import U4.u;
import V4.s;
import android.content.Context;
import android.database.Cursor;
import androidx.room.O;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase_Impl;
import d5.i;
import d5.l;
import d5.v;
import g5.a;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/work/impl/workers/DiagnosticsWorker;", "Landroidx/work/Worker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "parameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class DiagnosticsWorker extends Worker {
    public DiagnosticsWorker(@NotNull Context context0, @NotNull WorkerParameters workerParameters0) {
        q.g(context0, "context");
        q.g(workerParameters0, "parameters");
        super(context0, workerParameters0);
    }

    @Override  // androidx.work.Worker
    public final t c() {
        ArrayList arrayList0;
        s s0 = s.c0(this.a);
        q.f(s0.j, "workManager.workDatabase");
        d5.s s1 = s0.j.g();
        l l0 = s0.j.e();
        v v0 = s0.j.h();
        i i0 = s0.j.d();
        s0.i.d.getClass();
        long v1 = TimeUnit.DAYS.toMillis(1L);
        s1.getClass();
        O o0 = O.c(1, "SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC");
        o0.a(1, System.currentTimeMillis() - v1);
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)s1.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        Cursor cursor0 = w.R(workDatabase_Impl0, o0, false);
        try {
            int v3 = h.y(cursor0, "id");
            int v4 = h.y(cursor0, "state");
            int v5 = h.y(cursor0, "worker_class_name");
            int v6 = h.y(cursor0, "input_merger_class_name");
            int v7 = h.y(cursor0, "input");
            int v8 = h.y(cursor0, "output");
            int v9 = h.y(cursor0, "initial_delay");
            int v10 = h.y(cursor0, "interval_duration");
            int v11 = h.y(cursor0, "flex_duration");
            int v12 = h.y(cursor0, "run_attempt_count");
            int v13 = h.y(cursor0, "backoff_policy");
            int v14 = h.y(cursor0, "backoff_delay_duration");
            int v15 = h.y(cursor0, "last_enqueue_time");
            int v16 = h.y(cursor0, "minimum_retention_duration");
            int v17 = h.y(cursor0, "schedule_requested_at");
            int v18 = h.y(cursor0, "run_in_foreground");
            int v19 = h.y(cursor0, "out_of_quota_policy");
            int v20 = h.y(cursor0, "period_count");
            int v21 = h.y(cursor0, "generation");
            int v22 = h.y(cursor0, "next_schedule_time_override");
            int v23 = h.y(cursor0, "next_schedule_time_override_generation");
            int v24 = h.y(cursor0, "stop_reason");
            int v25 = h.y(cursor0, "trace_tag");
            int v26 = h.y(cursor0, "required_network_type");
            int v27 = h.y(cursor0, "required_network_request");
            int v28 = h.y(cursor0, "requires_charging");
            int v29 = h.y(cursor0, "requires_device_idle");
            int v30 = h.y(cursor0, "requires_battery_not_low");
            int v31 = h.y(cursor0, "requires_storage_not_low");
            int v32 = h.y(cursor0, "trigger_content_update_delay");
            int v33 = h.y(cursor0, "trigger_max_content_delay");
            int v34 = h.y(cursor0, "content_uri_triggers");
            arrayList0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                String s2 = cursor0.getString(v3);
                D d0 = d5.w.J(cursor0.getInt(v4));
                String s3 = cursor0.getString(v5);
                String s4 = cursor0.getString(v6);
                U4.i i1 = U4.i.a(cursor0.getBlob(v7));
                U4.i i2 = U4.i.a(cursor0.getBlob(v8));
                long v35 = cursor0.getLong(v9);
                long v36 = cursor0.getLong(v10);
                long v37 = cursor0.getLong(v11);
                int v38 = cursor0.getInt(v12);
                int v39 = d5.w.G(cursor0.getInt(v13));
                long v40 = cursor0.getLong(v14);
                long v41 = cursor0.getLong(v15);
                long v42 = cursor0.getLong(v16);
                long v43 = cursor0.getLong(v17);
                boolean z = cursor0.getInt(v18) != 0;
                int v44 = d5.w.I(cursor0.getInt(v19));
                int v45 = cursor0.getInt(v20);
                int v46 = cursor0.getInt(v21);
                long v47 = cursor0.getLong(v22);
                int v48 = cursor0.getInt(v23);
                int v49 = cursor0.getInt(v24);
                String s5 = cursor0.isNull(v25) ? null : cursor0.getString(v25);
                int v50 = d5.w.H(cursor0.getInt(v26));
                arrayList0.add(new d5.q(s2, d0, s3, s4, i1, i2, v35, v36, v37, new d(d5.w.U(cursor0.getBlob(v27)), v50, cursor0.getInt(v28) != 0, cursor0.getInt(v29) != 0, cursor0.getInt(v30) != 0, cursor0.getInt(v31) != 0, cursor0.getLong(v32), cursor0.getLong(v33), d5.w.q(cursor0.getBlob(v34))), v38, v39, v40, v41, v42, v43, z, v44, v45, v46, v47, v48, v49, s5));
            }
        }
        finally {
            cursor0.close();
            o0.release();
        }
        ArrayList arrayList1 = s1.g();
        ArrayList arrayList2 = s1.d();
        if(!arrayList0.isEmpty()) {
            U4.w.e().f("WM-DiagnosticsWrkr", "Recently completed work:\n\n");
            U4.w.e().f("WM-DiagnosticsWrkr", a.a(l0, v0, i0, arrayList0));
        }
        if(!arrayList1.isEmpty()) {
            U4.w.e().f("WM-DiagnosticsWrkr", "Running work:\n\n");
            U4.w.e().f("WM-DiagnosticsWrkr", a.a(l0, v0, i0, arrayList1));
        }
        if(!arrayList2.isEmpty()) {
            U4.w.e().f("WM-DiagnosticsWrkr", "Enqueued work:\n\n");
            U4.w.e().f("WM-DiagnosticsWrkr", a.a(l0, v0, i0, arrayList2));
        }
        return u.a();
    }
}

