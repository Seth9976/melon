package androidx.work.impl;

import B4.a;
import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/work/impl/WorkMigration9To10;", "LB4/a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class WorkMigration9To10 extends a {
    public final Context a;

    public WorkMigration9To10(@NotNull Context context0) {
        q.g(context0, "context");
        super(9, 10);
        this.a = context0;
    }

    @Override  // B4.a
    public final void migrate(H4.a a0) {
        q.g(a0, "db");
        a0.u("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        Context context0 = this.a;
        SharedPreferences sharedPreferences0 = context0.getSharedPreferences("androidx.work.util.preferences", 0);
        if(sharedPreferences0.contains("reschedule_needed") || sharedPreferences0.contains("last_cancel_all_time_ms")) {
            long v = 0L;
            long v1 = sharedPreferences0.getLong("last_cancel_all_time_ms", 0L);
            if(sharedPreferences0.getBoolean("reschedule_needed", false)) {
                v = 1L;
            }
            a0.t();
            try {
                a0.L(new Object[]{"last_cancel_all_time_ms", v1});
                a0.L(new Object[]{"reschedule_needed", v});
                sharedPreferences0.edit().clear().apply();
                a0.x();
            }
            catch(Throwable throwable0) {
                a0.z();
                throw throwable0;
            }
            a0.z();
        }
        SharedPreferences sharedPreferences1 = context0.getSharedPreferences("androidx.work.util.id", 0);
        if(!sharedPreferences1.contains("next_job_scheduler_id") && !sharedPreferences1.contains("next_job_scheduler_id")) {
            return;
        }
        int v2 = sharedPreferences1.getInt("next_job_scheduler_id", 0);
        int v3 = sharedPreferences1.getInt("next_alarm_manager_id", 0);
        a0.t();
        try {
            a0.L(new Object[]{"next_job_scheduler_id", v2});
            a0.L(new Object[]{"next_alarm_manager_id", v3});
            sharedPreferences1.edit().clear().apply();
            a0.x();
        }
        catch(Throwable throwable1) {
            a0.z();
            throw throwable1;
        }
        a0.z();
    }
}

