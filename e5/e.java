package e5;

import E9.w;
import U4.D;
import V4.s;
import Y4.a;
import Y4.d;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.O;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.utils.ForceStopRunnable.BroadcastReceiver;
import com.google.android.material.internal.F;
import d5.h;
import d5.i;
import d5.j;
import d5.m;
import d5.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jeb.synthetic.FIN;

public final class e implements Runnable {
    public final Context a;
    public final s b;
    public final g c;
    public int d;
    public static final String e;
    public static final long f;

    static {
        e.e = "WM-ForceStopRunnable";
        e.f = TimeUnit.DAYS.toMillis(3650L);
    }

    public e(Context context0, s s0) {
        this.a = context0.getApplicationContext();
        this.b = s0;
        this.c = s0.n;
        this.d = 0;
    }

    public final void a() {
        g g0 = this.c;
        s s0 = this.b;
        WorkDatabase workDatabase0 = s0.j;
        Context context0 = this.a;
        JobScheduler jobScheduler0 = a.b(context0);
        ArrayList arrayList0 = d.e(context0, jobScheduler0);
        i i0 = workDatabase0.d();
        i0.getClass();
        int v = 0;
        O o0 = O.c(0, "SELECT DISTINCT work_spec_id FROM SystemIdInfo");
        WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)i0.a;
        workDatabase_Impl0.assertNotSuspendingTransaction();
        Cursor cursor0 = w.R(workDatabase_Impl0, o0, false);
        try {
            ArrayList arrayList1 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                arrayList1.add(cursor0.getString(0));
            }
        }
        finally {
            cursor0.close();
            o0.release();
        }
        HashSet hashSet0 = new HashSet((arrayList0 == null ? 0 : arrayList0.size()));
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            for(Object object0: arrayList0) {
                JobInfo jobInfo0 = (JobInfo)object0;
                j j0 = d.f(jobInfo0);
                if(j0 == null) {
                    d.a(jobScheduler0, jobInfo0.getId());
                }
                else {
                    hashSet0.add(j0.a);
                }
            }
        }
        boolean z = false;
        for(Object object1: arrayList1) {
            if(!hashSet0.contains(((String)object1))) {
                U4.w.e().a("WM-SystemJobScheduler", "Reconciling jobs");
                z = true;
                break;
            }
        }
        if(z) {
            workDatabase0.beginTransaction();
            try {
                d5.s s1 = workDatabase0.g();
                for(Object object2: arrayList1) {
                    s1.l(-1L, ((String)object2));
                }
                workDatabase0.setTransactionSuccessful();
            }
            finally {
                workDatabase0.endTransaction();
            }
        }
        WorkDatabase workDatabase1 = s0.j;
        d5.s s2 = workDatabase1.g();
        m m0 = workDatabase1.f();
        workDatabase1.beginTransaction();
        try {
            ArrayList arrayList2 = s2.g();
            boolean z1 = arrayList2.isEmpty();
            if(!z1) {
                for(Object object3: arrayList2) {
                    s2.p(D.a, ((q)object3).a);
                    s2.q(((q)object3).a, 0xFFFFFE00);
                    s2.l(-1L, ((q)object3).a);
                }
            }
            WorkDatabase_Impl workDatabase_Impl1 = (WorkDatabase_Impl)m0.b;
            workDatabase_Impl1.assertNotSuspendingTransaction();
            h h0 = (h)m0.d;
            H4.h h1 = h0.a();
            try {
                workDatabase_Impl1.beginTransaction();
                try {
                    h1.w();
                    workDatabase_Impl1.setTransactionSuccessful();
                }
                finally {
                    workDatabase_Impl1.endTransaction();
                }
            }
            catch(Throwable throwable0) {
                h0.n(h1);
                throw throwable0;
            }
            h0.n(h1);
            workDatabase1.setTransactionSuccessful();
        }
        finally {
            workDatabase1.endTransaction();
        }
        Long long0 = s0.n.a.c().i("reschedule_needed");
        long v5 = 0L;
        if(long0 != null && ((long)long0) == 1L) {
            U4.w.e().a("WM-ForceStopRunnable", "Rescheduling Workers.");
            s0.f0();
            s0.n.getClass();
            d5.d d0 = new d5.d("reschedule_needed", 0L);
            s0.n.a.c().m(d0);
            return;
        }
        try {
            int v6 = Build.VERSION.SDK_INT;
            Intent intent0 = new Intent();
            intent0.setComponent(new ComponentName(context0, ForceStopRunnable.BroadcastReceiver.class));
            intent0.setAction("ACTION_FORCE_STOP_RESCHEDULE");
            PendingIntent pendingIntent0 = PendingIntent.getBroadcast(context0, -1, intent0, (v6 < 0x1F ? 0x20000000 : 0x22000000));
            if(v6 >= 30) {
                if(pendingIntent0 != null) {
                    pendingIntent0.cancel();
                }
                List list0 = F.p(((ActivityManager)context0.getSystemService("activity")));
                if(list0 != null && !list0.isEmpty()) {
                    Long long1 = g0.a.c().i("last_force_stop_ms");
                    if(long1 != null) {
                        v5 = (long)long1;
                    }
                    while(v < list0.size()) {
                        ApplicationExitInfo applicationExitInfo0 = F.f(list0.get(v));
                        if(F.b(applicationExitInfo0) == 10 && F.e(applicationExitInfo0) >= v5) {
                            goto label_124;
                        }
                        ++v;
                    }
                }
            }
            else if(pendingIntent0 == null) {
                e.c(context0);
                goto label_124;
            }
            goto label_131;
        }
        catch(SecurityException | IllegalArgumentException securityException0) {
        }
        if(U4.w.e().a <= 5) {
            Log.w("WM-ForceStopRunnable", "Ignoring exception", securityException0);
        }
    label_124:
        U4.w.e().a("WM-ForceStopRunnable", "Application was force-stopped, rescheduling.");
        s0.f0();
        s0.i.d.getClass();
        g0.getClass();
        d5.d d1 = new d5.d("last_force_stop_ms", System.currentTimeMillis());
        g0.a.c().m(d1);
        return;
    label_131:
        if(!z1 || z) {
            U4.w.e().a("WM-ForceStopRunnable", "Found unfinished work, scheduling it.");
            V4.j.b(s0.i, s0.j, s0.l);
        }
    }

    public final boolean b() {
        U4.a a0 = this.b.i;
        a0.getClass();
        if(TextUtils.isEmpty(null)) {
            U4.w.e().a("WM-ForceStopRunnable", "The default process name was not specified.");
            return true;
        }
        boolean z = k.a(this.a, a0);
        U4.w.e().a("WM-ForceStopRunnable", "Is default app process = " + z);
        return z;
    }

    public static void c(Context context0) {
        AlarmManager alarmManager0 = (AlarmManager)context0.getSystemService("alarm");
        int v = Build.VERSION.SDK_INT < 0x1F ? 0x8000000 : 0xA000000;
        Intent intent0 = new Intent();
        intent0.setComponent(new ComponentName(context0, ForceStopRunnable.BroadcastReceiver.class));
        intent0.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent pendingIntent0 = PendingIntent.getBroadcast(context0, -1, intent0, v);
        long v1 = System.currentTimeMillis() + e.f;
        if(alarmManager0 != null) {
            alarmManager0.setExact(0, v1, pendingIntent0);
        }
    }

    @Override
    public final void run() {
        int v = FIN.finallyOpen$NT();
        Context context0 = this.a;
        s s0 = this.b;
        if(!this.b()) {
            FIN.finallyCodeBegin$NT(v);
            s0.e0();
            FIN.finallyCodeEnd$NT(v);
            return;
        }
        while(true) {
            try {
                P4.a.v(context0);
            }
            catch(SQLiteException sQLiteException0) {
                U4.w.e().c("WM-ForceStopRunnable", "Unexpected SQLite exception during migrations");
                IllegalStateException illegalStateException0 = new IllegalStateException("Unexpected SQLite exception during migrations", sQLiteException0);
                s0.i.getClass();
                FIN.finallyExec$NT(v);
                throw illegalStateException0;
            }
            U4.w.e().a("WM-ForceStopRunnable", "Performing cleanup operations.");
            try {
                this.a();
                FIN.finallyExec$NT(v);
                return;
            }
            catch(SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteFullException | SQLiteTableLockedException sQLiteAccessPermException0) {
                int v1 = this.d + 1;
                this.d = v1;
                if(v1 >= 3) {
                    String s1 = x1.a.H(context0) ? "The file system on the device is in a bad state. WorkManager cannot access the app\'s internal data store." : "WorkManager can\'t be accessed from direct boot, because credential encrypted storage isn\'t accessible.\nDon\'t access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                    U4.w.e().d("WM-ForceStopRunnable", s1, sQLiteAccessPermException0);
                    IllegalStateException illegalStateException1 = new IllegalStateException(s1, sQLiteAccessPermException0);
                    s0.i.getClass();
                    FIN.finallyExec$NT(v);
                    throw illegalStateException1;
                }
                U4.w.e().b("WM-ForceStopRunnable", "Retrying after " + ((long)v1) * 300L, sQLiteAccessPermException0);
                try {
                    Thread.sleep(((long)this.d) * 300L);
                }
                catch(InterruptedException unused_ex) {
                }
            }
        }
    }
}

