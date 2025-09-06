package V4;

import U4.a;
import U4.w;
import W4.c;
import Y4.d;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import b5.j;
import e.k;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import we.r;

public final class t extends n implements r {
    public static final t b;

    static {
        t.b = new t(6, u.class, "createSchedulers", "createSchedulers(Landroid/content/Context;Landroidx/work/Configuration;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Landroidx/work/impl/WorkDatabase;Landroidx/work/impl/constraints/trackers/Trackers;Landroidx/work/impl/Processor;)Ljava/util/List;", 1);  // 初始化器: Lkotlin/jvm/internal/n;-><init>(ILjava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // we.r
    public final Object c(Object object0, Object object1, Object object2, Object object3, Object object4, Object object5) {
        q.g(((Context)object0), "p0");
        q.g(((a)object1), "p1");
        q.g(((f5.a)object2), "p2");
        q.g(((WorkDatabase)object3), "p3");
        q.g(((j)object4), "p4");
        d d0 = new d(((Context)object0), ((WorkDatabase)object3), ((a)object1));
        e5.j.a(((Context)object0), SystemJobService.class, true);
        w.e().a("WM-Schedulers", "Created SystemJobScheduler and enabled SystemJobService");
        return k.A(new h[]{d0, new c(((Context)object0), ((a)object1), ((j)object4), ((f)object5), new ea.a(((f)object5), ((f5.a)object2)), ((f5.a)object2))});
    }
}

