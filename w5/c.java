package W5;

import Q5.j;
import X5.d;
import android.app.job.JobInfo.Builder;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.zip.Adler32;

public final class c {
    public final Context a;
    public final d b;
    public final a c;

    public c(Context context0, d d0, a a0) {
        this.a = context0;
        this.b = d0;
        this.c = a0;
    }

    public final void a(j j0, int v, boolean z) {
        Long long0;
        ComponentName componentName0 = new ComponentName(this.a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler0 = (JobScheduler)this.a.getSystemService("jobscheduler");
        Adler32 adler320 = new Adler32();
        adler320.update("com.iloen.melon".getBytes(Charset.forName("UTF-8")));
        Charset charset0 = Charset.forName("UTF-8");
        adler320.update(j0.a.getBytes(charset0));
        adler320.update(ByteBuffer.allocate(4).putInt(a6.a.a(j0.c)).array());
        byte[] arr_b = j0.b;
        if(arr_b != null) {
            adler320.update(arr_b);
        }
        int v1 = (int)adler320.getValue();
        if(!z) {
            for(Object object0: jobScheduler0.getAllPendingJobs()) {
                int v2 = ((JobInfo)object0).getExtras().getInt("attemptNumber");
                if(((JobInfo)object0).getId() == v1) {
                    if(v2 < v) {
                        break;
                    }
                    Q1.c.s("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", j0);
                    return;
                }
                if(false) {
                    break;
                }
            }
        }
        SQLiteDatabase sQLiteDatabase0 = ((X5.j)this.b).h();
        String s = String.valueOf(a6.a.a(j0.c));
        try(Cursor cursor0 = sQLiteDatabase0.rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{j0.a, s})) {
            long0 = cursor0.moveToNext() ? cursor0.getLong(0) : 0L;
        }
        long v3 = (long)long0;
        JobInfo.Builder jobInfo$Builder0 = new JobInfo.Builder(v1, componentName0);
        N5.d d0 = j0.c;
        a a0 = this.c;
        jobInfo$Builder0.setMinimumLatency(a0.a(d0, v3, v));
        Set set0 = ((b)a0.b.get(d0)).c;
        if(set0.contains(W5.d.a)) {
            jobInfo$Builder0.setRequiredNetworkType(2);
        }
        else {
            jobInfo$Builder0.setRequiredNetworkType(1);
        }
        if(set0.contains(W5.d.c)) {
            jobInfo$Builder0.setRequiresCharging(true);
        }
        if(set0.contains(W5.d.b)) {
            jobInfo$Builder0.setRequiresDeviceIdle(true);
        }
        PersistableBundle persistableBundle0 = new PersistableBundle();
        persistableBundle0.putInt("attemptNumber", v);
        persistableBundle0.putString("backendName", j0.a);
        persistableBundle0.putInt("priority", a6.a.a(d0));
        byte[] arr_b1 = j0.b;
        if(arr_b1 != null) {
            persistableBundle0.putString("extras", Base64.encodeToString(arr_b1, 0));
        }
        jobInfo$Builder0.setExtras(persistableBundle0);
        Object[] arr_object = {j0, v1, a0.a(d0, v3, v), long0, v};
        if(Log.isLoggable("TRuntime.JobInfoScheduler", 3)) {
            Log.d("TRuntime.JobInfoScheduler", String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", arr_object));
        }
        jobScheduler0.schedule(jobInfo$Builder0.build());
    }
}

