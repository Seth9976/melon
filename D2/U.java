package D2;

import O2.b;
import O2.c;
import O2.d;
import O2.e;
import O2.f;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

public final class u {
    public static final u a;

    static {
        u.a = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final void a(@NotNull RemoteViews remoteViews0, int v, @NotNull f f0) {
        q.g(remoteViews0, "<this>");
        if(Build.VERSION.SDK_INT < 0x1F) {
            throw new IllegalArgumentException(("setClipToOutline is only available on SDK " + 0x1F + " and higher").toString());
        }
        remoteViews0.setBoolean(v, "setClipToOutline", true);
        if(!(f0 instanceof b)) {
            throw new IllegalStateException(("Rounded corners should not be " + f0.getClass().getCanonicalName()).toString());
        }
        remoteViews0.setViewOutlinePreferredRadius(v, ((b)f0).a, 1);
    }

    public final void b(@NotNull RemoteViews remoteViews0, int v, @NotNull f f0) {
        if(f0 instanceof e) {
            remoteViews0.setViewLayoutHeight(v, -2.0f, 0);
            return;
        }
        if(f0 instanceof c) {
            remoteViews0.setViewLayoutHeight(v, 0.0f, 0);
            return;
        }
        if(f0 instanceof b) {
            remoteViews0.setViewLayoutHeight(v, ((b)f0).a, 1);
            return;
        }
        if(!q.b(f0, d.a)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        remoteViews0.setViewLayoutHeight(v, -1.0f, 0);
    }

    public final void c(@NotNull RemoteViews remoteViews0, int v, @NotNull f f0) {
        if(f0 instanceof e) {
            remoteViews0.setViewLayoutWidth(v, -2.0f, 0);
            return;
        }
        if(f0 instanceof c) {
            remoteViews0.setViewLayoutWidth(v, 0.0f, 0);
            return;
        }
        if(f0 instanceof b) {
            remoteViews0.setViewLayoutWidth(v, ((b)f0).a, 1);
            return;
        }
        if(!q.b(f0, d.a)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        remoteViews0.setViewLayoutWidth(v, -1.0f, 0);
    }
}

