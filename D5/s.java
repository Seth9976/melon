package d5;

import E9.w;
import P4.a;
import U4.D;
import U4.d;
import U4.i;
import android.database.Cursor;
import androidx.room.O;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import k8.Y;

public final class s {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public Object i;
    public Object j;
    public Object k;
    public Object l;
    public Object m;
    public Object n;

    public s() {
        this.a = "CL";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
    }

    public s(WorkDatabase_Impl workDatabase_Impl0) {
        this.a = workDatabase_Impl0;
        this.b = new b(workDatabase_Impl0, false, 5);
        new h(workDatabase_Impl0, 12);
        this.c = new h(workDatabase_Impl0, 13);
        this.d = new h(workDatabase_Impl0, 14);
        this.e = new h(workDatabase_Impl0, 15);
        this.f = new h(workDatabase_Impl0, 16);
        this.g = new h(workDatabase_Impl0, 17);
        this.h = new h(workDatabase_Impl0, 18);
        this.i = new h(workDatabase_Impl0, 19);
        this.j = new h(workDatabase_Impl0, 4);
        new h(workDatabase_Impl0, 5);
        this.k = new h(workDatabase_Impl0, 6);
        this.l = new h(workDatabase_Impl0, 7);
        this.m = new h(workDatabase_Impl0, 8);
        new h(workDatabase_Impl0, 9);
        new h(workDatabase_Impl0, 10);
        this.n = new h(workDatabase_Impl0, 11);
    }

    public void a(HashMap hashMap0) {
        Set set0 = hashMap0.keySet();
        if(set0.isEmpty()) {
            return;
        }
        if(hashMap0.size() > 999) {
            a.A(hashMap0, new r(this, 1));
            return;
        }
        StringBuilder stringBuilder0 = Y.p("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int v = set0.size();
        a.a.k(v, stringBuilder0);
        stringBuilder0.append(")");
        O o0 = O.c(v, stringBuilder0.toString());
        int v1 = 1;
        for(Object object0: set0) {
            o0.k(v1, ((String)object0));
            ++v1;
        }
        try(Cursor cursor0 = w.R(((WorkDatabase_Impl)this.a), o0, false)) {
            int v2 = E9.h.x(cursor0, "work_spec_id");
            if(v2 != -1) {
                while(true) {
                    if(!cursor0.moveToNext()) {
                        break;
                    }
                    ArrayList arrayList0 = (ArrayList)hashMap0.get(cursor0.getString(v2));
                    if(arrayList0 != null) {
                        arrayList0.add(i.a(cursor0.getBlob(0)));
                    }
                }
            }
        }
    }

    public void b(HashMap hashMap0) {
        Set set0 = hashMap0.keySet();
        if(set0.isEmpty()) {
            return;
        }
        if(hashMap0.size() > 999) {
            a.A(hashMap0, new r(this, 0));
            return;
        }
        StringBuilder stringBuilder0 = Y.p("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int v = set0.size();
        a.a.k(v, stringBuilder0);
        stringBuilder0.append(")");
        O o0 = O.c(v, stringBuilder0.toString());
        int v1 = 1;
        for(Object object0: set0) {
            o0.k(v1, ((String)object0));
            ++v1;
        }
        try(Cursor cursor0 = w.R(((WorkDatabase_Impl)this.a), o0, false)) {
            int v2 = E9.h.x(cursor0, "work_spec_id");
            if(v2 != -1) {
                while(true) {
                    if(!cursor0.moveToNext()) {
                        break;
                    }
                    ArrayList arrayList0 = (ArrayList)hashMap0.get(cursor0.getString(v2));
                    if(arrayList0 != null) {
                        arrayList0.add(cursor0.getString(0));
                    }
                }
            }
        }
    }

    public void c(String s) {
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        h h0 = (h)this.c;
        H4.h h1 = h0.a();
        h1.k(1, s);
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

    public ArrayList d() {
        O o0 = O.c(1, "SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?");
        o0.a(1, 200L);
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        Cursor cursor0 = w.R(workDatabase_Impl0, o0, false);
        try {
            int v1 = E9.h.y(cursor0, "id");
            int v2 = E9.h.y(cursor0, "state");
            int v3 = E9.h.y(cursor0, "worker_class_name");
            int v4 = E9.h.y(cursor0, "input_merger_class_name");
            int v5 = E9.h.y(cursor0, "input");
            int v6 = E9.h.y(cursor0, "output");
            int v7 = E9.h.y(cursor0, "initial_delay");
            int v8 = E9.h.y(cursor0, "interval_duration");
            int v9 = E9.h.y(cursor0, "flex_duration");
            int v10 = E9.h.y(cursor0, "run_attempt_count");
            int v11 = E9.h.y(cursor0, "backoff_policy");
            int v12 = E9.h.y(cursor0, "backoff_delay_duration");
            int v13 = E9.h.y(cursor0, "last_enqueue_time");
            int v14 = E9.h.y(cursor0, "minimum_retention_duration");
            int v15 = E9.h.y(cursor0, "schedule_requested_at");
            int v16 = E9.h.y(cursor0, "run_in_foreground");
            int v17 = E9.h.y(cursor0, "out_of_quota_policy");
            int v18 = E9.h.y(cursor0, "period_count");
            int v19 = E9.h.y(cursor0, "generation");
            int v20 = E9.h.y(cursor0, "next_schedule_time_override");
            int v21 = E9.h.y(cursor0, "next_schedule_time_override_generation");
            int v22 = E9.h.y(cursor0, "stop_reason");
            int v23 = E9.h.y(cursor0, "trace_tag");
            int v24 = E9.h.y(cursor0, "required_network_type");
            int v25 = E9.h.y(cursor0, "required_network_request");
            int v26 = E9.h.y(cursor0, "requires_charging");
            int v27 = E9.h.y(cursor0, "requires_device_idle");
            int v28 = E9.h.y(cursor0, "requires_battery_not_low");
            int v29 = E9.h.y(cursor0, "requires_storage_not_low");
            int v30 = E9.h.y(cursor0, "trigger_content_update_delay");
            int v31 = E9.h.y(cursor0, "trigger_max_content_delay");
            int v32 = E9.h.y(cursor0, "content_uri_triggers");
            ArrayList arrayList0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                String s = cursor0.getString(v1);
                D d0 = d5.w.J(cursor0.getInt(v2));
                String s1 = cursor0.getString(v3);
                String s2 = cursor0.getString(v4);
                i i0 = i.a(cursor0.getBlob(v5));
                i i1 = i.a(cursor0.getBlob(v6));
                long v33 = cursor0.getLong(v7);
                long v34 = cursor0.getLong(v8);
                long v35 = cursor0.getLong(v9);
                int v36 = cursor0.getInt(v10);
                int v37 = d5.w.G(cursor0.getInt(v11));
                long v38 = cursor0.getLong(v12);
                long v39 = cursor0.getLong(v13);
                long v40 = cursor0.getLong(v14);
                long v41 = cursor0.getLong(v15);
                boolean z = cursor0.getInt(v16) != 0;
                int v42 = d5.w.I(cursor0.getInt(v17));
                int v43 = cursor0.getInt(v18);
                int v44 = cursor0.getInt(v19);
                long v45 = cursor0.getLong(v20);
                int v46 = cursor0.getInt(v21);
                int v47 = cursor0.getInt(v22);
                String s3 = cursor0.isNull(v23) ? null : cursor0.getString(v23);
                int v48 = d5.w.H(cursor0.getInt(v24));
                arrayList0.add(new q(s, d0, s1, s2, i0, i1, v33, v34, v35, new d(d5.w.U(cursor0.getBlob(v25)), v48, cursor0.getInt(v26) != 0, cursor0.getInt(v27) != 0, cursor0.getInt(v28) != 0, cursor0.getInt(v29) != 0, cursor0.getLong(v30), cursor0.getLong(v31), d5.w.q(cursor0.getBlob(v32))), v36, v37, v38, v39, v40, v41, z, v42, v43, v44, v45, v46, v47, s3));
            }
            return arrayList0;
        }
        finally {
            cursor0.close();
            o0.release();
        }
    }

    public ArrayList e(int v) {
        O o0 = O.c(1, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))");
        o0.a(1, ((long)v));
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        Cursor cursor0 = w.R(workDatabase_Impl0, o0, false);
        try {
            int v2 = E9.h.y(cursor0, "id");
            int v3 = E9.h.y(cursor0, "state");
            int v4 = E9.h.y(cursor0, "worker_class_name");
            int v5 = E9.h.y(cursor0, "input_merger_class_name");
            int v6 = E9.h.y(cursor0, "input");
            int v7 = E9.h.y(cursor0, "output");
            int v8 = E9.h.y(cursor0, "initial_delay");
            int v9 = E9.h.y(cursor0, "interval_duration");
            int v10 = E9.h.y(cursor0, "flex_duration");
            int v11 = E9.h.y(cursor0, "run_attempt_count");
            int v12 = E9.h.y(cursor0, "backoff_policy");
            int v13 = E9.h.y(cursor0, "backoff_delay_duration");
            int v14 = E9.h.y(cursor0, "last_enqueue_time");
            int v15 = E9.h.y(cursor0, "minimum_retention_duration");
            int v16 = E9.h.y(cursor0, "schedule_requested_at");
            int v17 = E9.h.y(cursor0, "run_in_foreground");
            int v18 = E9.h.y(cursor0, "out_of_quota_policy");
            int v19 = E9.h.y(cursor0, "period_count");
            int v20 = E9.h.y(cursor0, "generation");
            int v21 = E9.h.y(cursor0, "next_schedule_time_override");
            int v22 = E9.h.y(cursor0, "next_schedule_time_override_generation");
            int v23 = E9.h.y(cursor0, "stop_reason");
            int v24 = E9.h.y(cursor0, "trace_tag");
            int v25 = E9.h.y(cursor0, "required_network_type");
            int v26 = E9.h.y(cursor0, "required_network_request");
            int v27 = E9.h.y(cursor0, "requires_charging");
            int v28 = E9.h.y(cursor0, "requires_device_idle");
            int v29 = E9.h.y(cursor0, "requires_battery_not_low");
            int v30 = E9.h.y(cursor0, "requires_storage_not_low");
            int v31 = E9.h.y(cursor0, "trigger_content_update_delay");
            int v32 = E9.h.y(cursor0, "trigger_max_content_delay");
            int v33 = E9.h.y(cursor0, "content_uri_triggers");
            ArrayList arrayList0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                String s = cursor0.getString(v2);
                D d0 = d5.w.J(cursor0.getInt(v3));
                String s1 = cursor0.getString(v4);
                String s2 = cursor0.getString(v5);
                i i0 = i.a(cursor0.getBlob(v6));
                i i1 = i.a(cursor0.getBlob(v7));
                long v34 = cursor0.getLong(v8);
                long v35 = cursor0.getLong(v9);
                long v36 = cursor0.getLong(v10);
                int v37 = cursor0.getInt(v11);
                int v38 = d5.w.G(cursor0.getInt(v12));
                long v39 = cursor0.getLong(v13);
                long v40 = cursor0.getLong(v14);
                long v41 = cursor0.getLong(v15);
                long v42 = cursor0.getLong(v16);
                boolean z = cursor0.getInt(v17) != 0;
                int v43 = d5.w.I(cursor0.getInt(v18));
                int v44 = cursor0.getInt(v19);
                int v45 = cursor0.getInt(v20);
                long v46 = cursor0.getLong(v21);
                int v47 = cursor0.getInt(v22);
                int v48 = cursor0.getInt(v23);
                String s3 = cursor0.isNull(v24) ? null : cursor0.getString(v24);
                int v49 = d5.w.H(cursor0.getInt(v25));
                arrayList0.add(new q(s, d0, s1, s2, i0, i1, v34, v35, v36, new d(d5.w.U(cursor0.getBlob(v26)), v49, cursor0.getInt(v27) != 0, cursor0.getInt(v28) != 0, cursor0.getInt(v29) != 0, cursor0.getInt(v30) != 0, cursor0.getLong(v31), cursor0.getLong(v32), d5.w.q(cursor0.getBlob(v33))), v37, v38, v39, v40, v41, v42, z, v43, v44, v45, v46, v47, v48, s3));
            }
            return arrayList0;
        }
        finally {
            cursor0.close();
            o0.release();
        }
    }

    public ArrayList f() {
        O o0 = O.c(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time");
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        Cursor cursor0 = w.R(workDatabase_Impl0, o0, false);
        try {
            int v1 = E9.h.y(cursor0, "id");
            int v2 = E9.h.y(cursor0, "state");
            int v3 = E9.h.y(cursor0, "worker_class_name");
            int v4 = E9.h.y(cursor0, "input_merger_class_name");
            int v5 = E9.h.y(cursor0, "input");
            int v6 = E9.h.y(cursor0, "output");
            int v7 = E9.h.y(cursor0, "initial_delay");
            int v8 = E9.h.y(cursor0, "interval_duration");
            int v9 = E9.h.y(cursor0, "flex_duration");
            int v10 = E9.h.y(cursor0, "run_attempt_count");
            int v11 = E9.h.y(cursor0, "backoff_policy");
            int v12 = E9.h.y(cursor0, "backoff_delay_duration");
            int v13 = E9.h.y(cursor0, "last_enqueue_time");
            int v14 = E9.h.y(cursor0, "minimum_retention_duration");
            int v15 = E9.h.y(cursor0, "schedule_requested_at");
            int v16 = E9.h.y(cursor0, "run_in_foreground");
            int v17 = E9.h.y(cursor0, "out_of_quota_policy");
            int v18 = E9.h.y(cursor0, "period_count");
            int v19 = E9.h.y(cursor0, "generation");
            int v20 = E9.h.y(cursor0, "next_schedule_time_override");
            int v21 = E9.h.y(cursor0, "next_schedule_time_override_generation");
            int v22 = E9.h.y(cursor0, "stop_reason");
            int v23 = E9.h.y(cursor0, "trace_tag");
            int v24 = E9.h.y(cursor0, "required_network_type");
            int v25 = E9.h.y(cursor0, "required_network_request");
            int v26 = E9.h.y(cursor0, "requires_charging");
            int v27 = E9.h.y(cursor0, "requires_device_idle");
            int v28 = E9.h.y(cursor0, "requires_battery_not_low");
            int v29 = E9.h.y(cursor0, "requires_storage_not_low");
            int v30 = E9.h.y(cursor0, "trigger_content_update_delay");
            int v31 = E9.h.y(cursor0, "trigger_max_content_delay");
            int v32 = E9.h.y(cursor0, "content_uri_triggers");
            ArrayList arrayList0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                String s = cursor0.getString(v1);
                D d0 = d5.w.J(cursor0.getInt(v2));
                String s1 = cursor0.getString(v3);
                String s2 = cursor0.getString(v4);
                i i0 = i.a(cursor0.getBlob(v5));
                i i1 = i.a(cursor0.getBlob(v6));
                long v33 = cursor0.getLong(v7);
                long v34 = cursor0.getLong(v8);
                long v35 = cursor0.getLong(v9);
                int v36 = cursor0.getInt(v10);
                int v37 = d5.w.G(cursor0.getInt(v11));
                long v38 = cursor0.getLong(v12);
                long v39 = cursor0.getLong(v13);
                long v40 = cursor0.getLong(v14);
                long v41 = cursor0.getLong(v15);
                boolean z = cursor0.getInt(v16) != 0;
                int v42 = d5.w.I(cursor0.getInt(v17));
                int v43 = cursor0.getInt(v18);
                int v44 = cursor0.getInt(v19);
                long v45 = cursor0.getLong(v20);
                int v46 = cursor0.getInt(v21);
                int v47 = cursor0.getInt(v22);
                String s3 = cursor0.isNull(v23) ? null : cursor0.getString(v23);
                int v48 = d5.w.H(cursor0.getInt(v24));
                arrayList0.add(new q(s, d0, s1, s2, i0, i1, v33, v34, v35, new d(d5.w.U(cursor0.getBlob(v25)), v48, cursor0.getInt(v26) != 0, cursor0.getInt(v27) != 0, cursor0.getInt(v28) != 0, cursor0.getInt(v29) != 0, cursor0.getLong(v30), cursor0.getLong(v31), d5.w.q(cursor0.getBlob(v32))), v36, v37, v38, v39, v40, v41, z, v42, v43, v44, v45, v46, v47, s3));
            }
            return arrayList0;
        }
        finally {
            cursor0.close();
            o0.release();
        }
    }

    public ArrayList g() {
        O o0 = O.c(0, "SELECT * FROM workspec WHERE state=1");
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        Cursor cursor0 = w.R(workDatabase_Impl0, o0, false);
        try {
            int v1 = E9.h.y(cursor0, "id");
            int v2 = E9.h.y(cursor0, "state");
            int v3 = E9.h.y(cursor0, "worker_class_name");
            int v4 = E9.h.y(cursor0, "input_merger_class_name");
            int v5 = E9.h.y(cursor0, "input");
            int v6 = E9.h.y(cursor0, "output");
            int v7 = E9.h.y(cursor0, "initial_delay");
            int v8 = E9.h.y(cursor0, "interval_duration");
            int v9 = E9.h.y(cursor0, "flex_duration");
            int v10 = E9.h.y(cursor0, "run_attempt_count");
            int v11 = E9.h.y(cursor0, "backoff_policy");
            int v12 = E9.h.y(cursor0, "backoff_delay_duration");
            int v13 = E9.h.y(cursor0, "last_enqueue_time");
            int v14 = E9.h.y(cursor0, "minimum_retention_duration");
            int v15 = E9.h.y(cursor0, "schedule_requested_at");
            int v16 = E9.h.y(cursor0, "run_in_foreground");
            int v17 = E9.h.y(cursor0, "out_of_quota_policy");
            int v18 = E9.h.y(cursor0, "period_count");
            int v19 = E9.h.y(cursor0, "generation");
            int v20 = E9.h.y(cursor0, "next_schedule_time_override");
            int v21 = E9.h.y(cursor0, "next_schedule_time_override_generation");
            int v22 = E9.h.y(cursor0, "stop_reason");
            int v23 = E9.h.y(cursor0, "trace_tag");
            int v24 = E9.h.y(cursor0, "required_network_type");
            int v25 = E9.h.y(cursor0, "required_network_request");
            int v26 = E9.h.y(cursor0, "requires_charging");
            int v27 = E9.h.y(cursor0, "requires_device_idle");
            int v28 = E9.h.y(cursor0, "requires_battery_not_low");
            int v29 = E9.h.y(cursor0, "requires_storage_not_low");
            int v30 = E9.h.y(cursor0, "trigger_content_update_delay");
            int v31 = E9.h.y(cursor0, "trigger_max_content_delay");
            int v32 = E9.h.y(cursor0, "content_uri_triggers");
            ArrayList arrayList0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                String s = cursor0.getString(v1);
                D d0 = d5.w.J(cursor0.getInt(v2));
                String s1 = cursor0.getString(v3);
                String s2 = cursor0.getString(v4);
                i i0 = i.a(cursor0.getBlob(v5));
                i i1 = i.a(cursor0.getBlob(v6));
                long v33 = cursor0.getLong(v7);
                long v34 = cursor0.getLong(v8);
                long v35 = cursor0.getLong(v9);
                int v36 = cursor0.getInt(v10);
                int v37 = d5.w.G(cursor0.getInt(v11));
                long v38 = cursor0.getLong(v12);
                long v39 = cursor0.getLong(v13);
                long v40 = cursor0.getLong(v14);
                long v41 = cursor0.getLong(v15);
                boolean z = cursor0.getInt(v16) != 0;
                int v42 = d5.w.I(cursor0.getInt(v17));
                int v43 = cursor0.getInt(v18);
                int v44 = cursor0.getInt(v19);
                long v45 = cursor0.getLong(v20);
                int v46 = cursor0.getInt(v21);
                int v47 = cursor0.getInt(v22);
                String s3 = cursor0.isNull(v23) ? null : cursor0.getString(v23);
                int v48 = d5.w.H(cursor0.getInt(v24));
                arrayList0.add(new q(s, d0, s1, s2, i0, i1, v33, v34, v35, new d(d5.w.U(cursor0.getBlob(v25)), v48, cursor0.getInt(v26) != 0, cursor0.getInt(v27) != 0, cursor0.getInt(v28) != 0, cursor0.getInt(v29) != 0, cursor0.getLong(v30), cursor0.getLong(v31), d5.w.q(cursor0.getBlob(v32))), v36, v37, v38, v39, v40, v41, z, v42, v43, v44, v45, v46, v47, s3));
            }
            return arrayList0;
        }
        finally {
            cursor0.close();
            o0.release();
        }
    }

    public ArrayList h() {
        O o0 = O.c(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        Cursor cursor0 = w.R(workDatabase_Impl0, o0, false);
        try {
            int v1 = E9.h.y(cursor0, "id");
            int v2 = E9.h.y(cursor0, "state");
            int v3 = E9.h.y(cursor0, "worker_class_name");
            int v4 = E9.h.y(cursor0, "input_merger_class_name");
            int v5 = E9.h.y(cursor0, "input");
            int v6 = E9.h.y(cursor0, "output");
            int v7 = E9.h.y(cursor0, "initial_delay");
            int v8 = E9.h.y(cursor0, "interval_duration");
            int v9 = E9.h.y(cursor0, "flex_duration");
            int v10 = E9.h.y(cursor0, "run_attempt_count");
            int v11 = E9.h.y(cursor0, "backoff_policy");
            int v12 = E9.h.y(cursor0, "backoff_delay_duration");
            int v13 = E9.h.y(cursor0, "last_enqueue_time");
            int v14 = E9.h.y(cursor0, "minimum_retention_duration");
            int v15 = E9.h.y(cursor0, "schedule_requested_at");
            int v16 = E9.h.y(cursor0, "run_in_foreground");
            int v17 = E9.h.y(cursor0, "out_of_quota_policy");
            int v18 = E9.h.y(cursor0, "period_count");
            int v19 = E9.h.y(cursor0, "generation");
            int v20 = E9.h.y(cursor0, "next_schedule_time_override");
            int v21 = E9.h.y(cursor0, "next_schedule_time_override_generation");
            int v22 = E9.h.y(cursor0, "stop_reason");
            int v23 = E9.h.y(cursor0, "trace_tag");
            int v24 = E9.h.y(cursor0, "required_network_type");
            int v25 = E9.h.y(cursor0, "required_network_request");
            int v26 = E9.h.y(cursor0, "requires_charging");
            int v27 = E9.h.y(cursor0, "requires_device_idle");
            int v28 = E9.h.y(cursor0, "requires_battery_not_low");
            int v29 = E9.h.y(cursor0, "requires_storage_not_low");
            int v30 = E9.h.y(cursor0, "trigger_content_update_delay");
            int v31 = E9.h.y(cursor0, "trigger_max_content_delay");
            int v32 = E9.h.y(cursor0, "content_uri_triggers");
            ArrayList arrayList0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                String s = cursor0.getString(v1);
                D d0 = d5.w.J(cursor0.getInt(v2));
                String s1 = cursor0.getString(v3);
                String s2 = cursor0.getString(v4);
                i i0 = i.a(cursor0.getBlob(v5));
                i i1 = i.a(cursor0.getBlob(v6));
                long v33 = cursor0.getLong(v7);
                long v34 = cursor0.getLong(v8);
                long v35 = cursor0.getLong(v9);
                int v36 = cursor0.getInt(v10);
                int v37 = d5.w.G(cursor0.getInt(v11));
                long v38 = cursor0.getLong(v12);
                long v39 = cursor0.getLong(v13);
                long v40 = cursor0.getLong(v14);
                long v41 = cursor0.getLong(v15);
                boolean z = cursor0.getInt(v16) != 0;
                int v42 = d5.w.I(cursor0.getInt(v17));
                int v43 = cursor0.getInt(v18);
                int v44 = cursor0.getInt(v19);
                long v45 = cursor0.getLong(v20);
                int v46 = cursor0.getInt(v21);
                int v47 = cursor0.getInt(v22);
                String s3 = cursor0.isNull(v23) ? null : cursor0.getString(v23);
                int v48 = d5.w.H(cursor0.getInt(v24));
                arrayList0.add(new q(s, d0, s1, s2, i0, i1, v33, v34, v35, new d(d5.w.U(cursor0.getBlob(v25)), v48, cursor0.getInt(v26) != 0, cursor0.getInt(v27) != 0, cursor0.getInt(v28) != 0, cursor0.getInt(v29) != 0, cursor0.getLong(v30), cursor0.getLong(v31), d5.w.q(cursor0.getBlob(v32))), v36, v37, v38, v39, v40, v41, z, v42, v43, v44, v45, v46, v47, s3));
            }
            return arrayList0;
        }
        finally {
            cursor0.close();
            o0.release();
        }
    }

    public D i(String s) {
        D d0 = null;
        O o0 = O.c(1, "SELECT state FROM workspec WHERE id=?");
        o0.k(1, s);
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        Cursor cursor0 = w.R(workDatabase_Impl0, o0, false);
        try {
            if(cursor0.moveToFirst()) {
                Integer integer0 = cursor0.isNull(0) ? null : cursor0.getInt(0);
                if(integer0 != null) {
                    d0 = d5.w.J(((int)integer0));
                }
            }
            return d0;
        }
        finally {
            cursor0.close();
            o0.release();
        }
    }

    public q j(String s) {
        O o0 = O.c(1, "SELECT * FROM workspec WHERE id=?");
        o0.k(1, s);
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        Cursor cursor0 = w.R(workDatabase_Impl0, o0, false);
        try {
            int v1 = E9.h.y(cursor0, "id");
            int v2 = E9.h.y(cursor0, "state");
            int v3 = E9.h.y(cursor0, "worker_class_name");
            int v4 = E9.h.y(cursor0, "input_merger_class_name");
            int v5 = E9.h.y(cursor0, "input");
            int v6 = E9.h.y(cursor0, "output");
            int v7 = E9.h.y(cursor0, "initial_delay");
            int v8 = E9.h.y(cursor0, "interval_duration");
            int v9 = E9.h.y(cursor0, "flex_duration");
            int v10 = E9.h.y(cursor0, "run_attempt_count");
            int v11 = E9.h.y(cursor0, "backoff_policy");
            int v12 = E9.h.y(cursor0, "backoff_delay_duration");
            int v13 = E9.h.y(cursor0, "last_enqueue_time");
            int v14 = E9.h.y(cursor0, "minimum_retention_duration");
            int v15 = E9.h.y(cursor0, "schedule_requested_at");
            int v16 = E9.h.y(cursor0, "run_in_foreground");
            int v17 = E9.h.y(cursor0, "out_of_quota_policy");
            int v18 = E9.h.y(cursor0, "period_count");
            int v19 = E9.h.y(cursor0, "generation");
            int v20 = E9.h.y(cursor0, "next_schedule_time_override");
            int v21 = E9.h.y(cursor0, "next_schedule_time_override_generation");
            int v22 = E9.h.y(cursor0, "stop_reason");
            int v23 = E9.h.y(cursor0, "trace_tag");
            int v24 = E9.h.y(cursor0, "required_network_type");
            int v25 = E9.h.y(cursor0, "required_network_request");
            int v26 = E9.h.y(cursor0, "requires_charging");
            int v27 = E9.h.y(cursor0, "requires_device_idle");
            int v28 = E9.h.y(cursor0, "requires_battery_not_low");
            int v29 = E9.h.y(cursor0, "requires_storage_not_low");
            int v30 = E9.h.y(cursor0, "trigger_content_update_delay");
            int v31 = E9.h.y(cursor0, "trigger_max_content_delay");
            int v32 = E9.h.y(cursor0, "content_uri_triggers");
            q q0 = null;
            if(cursor0.moveToFirst()) {
                String s1 = cursor0.getString(v1);
                D d0 = d5.w.J(cursor0.getInt(v2));
                String s2 = cursor0.getString(v3);
                String s3 = cursor0.getString(v4);
                i i0 = i.a(cursor0.getBlob(v5));
                i i1 = i.a(cursor0.getBlob(v6));
                long v33 = cursor0.getLong(v7);
                long v34 = cursor0.getLong(v8);
                long v35 = cursor0.getLong(v9);
                int v36 = cursor0.getInt(v10);
                int v37 = d5.w.G(cursor0.getInt(v11));
                long v38 = cursor0.getLong(v12);
                long v39 = cursor0.getLong(v13);
                long v40 = cursor0.getLong(v14);
                long v41 = cursor0.getLong(v15);
                boolean z = cursor0.getInt(v16) != 0;
                int v42 = d5.w.I(cursor0.getInt(v17));
                int v43 = cursor0.getInt(v18);
                int v44 = cursor0.getInt(v19);
                long v45 = cursor0.getLong(v20);
                int v46 = cursor0.getInt(v21);
                int v47 = cursor0.getInt(v22);
                if(!cursor0.isNull(v23)) {
                    q0 = cursor0.getString(v23);
                }
                int v48 = d5.w.H(cursor0.getInt(v24));
                q0 = new q(s1, d0, s2, s3, i0, i1, v33, v34, v35, new d(d5.w.U(cursor0.getBlob(v25)), v48, cursor0.getInt(v26) != 0, cursor0.getInt(v27) != 0, cursor0.getInt(v28) != 0, cursor0.getInt(v29) != 0, cursor0.getLong(v30), cursor0.getLong(v31), d5.w.q(cursor0.getBlob(v32))), v36, v37, v38, v39, v40, v41, z, v42, v43, v44, v45, v46, v47, ((String)q0));
            }
            return q0;
        }
        finally {
            cursor0.close();
            o0.release();
        }
    }

    public ArrayList k(String s) {
        O o0 = O.c(1, "SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        o0.k(1, s);
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        Cursor cursor0 = w.R(workDatabase_Impl0, o0, false);
        try {
            ArrayList arrayList0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                String s1 = cursor0.getString(0);
                D d0 = d5.w.J(cursor0.getInt(1));
                kotlin.jvm.internal.q.g(s1, "id");
                o o1 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
                o1.a = s1;
                o1.b = d0;
                arrayList0.add(o1);
            }
            return arrayList0;
        }
        finally {
            cursor0.close();
            o0.release();
        }
    }

    public void l(long v, String s) {
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        h h0 = (h)this.l;
        H4.h h1 = h0.a();
        h1.a(1, v);
        h1.k(2, s);
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

    public void m(int v, String s) {
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        h h0 = (h)this.k;
        H4.h h1 = h0.a();
        h1.k(1, s);
        h1.a(2, ((long)v));
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

    public void n(long v, String s) {
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        h h0 = (h)this.h;
        H4.h h1 = h0.a();
        h1.a(1, v);
        h1.k(2, s);
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

    public void o(String s, i i0) {
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        h h0 = (h)this.g;
        H4.h h1 = h0.a();
        h1.O(1, E9.h.X(i0));
        h1.k(2, s);
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

    public void p(D d0, String s) {
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        h h0 = (h)this.d;
        H4.h h1 = h0.a();
        h1.a(1, ((long)d5.w.R(d0)));
        h1.k(2, s);
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

    public void q(String s, int v) {
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)this.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        h h0 = (h)this.n;
        H4.h h1 = h0.a();
        h1.a(1, ((long)v));
        h1.k(2, s);
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
}

