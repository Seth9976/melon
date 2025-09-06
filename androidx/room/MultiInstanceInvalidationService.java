package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.LinkedHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/room/MultiInstanceInvalidationService;", "Landroid/app/Service;", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class MultiInstanceInvalidationService extends Service {
    public int a;
    public final LinkedHashMap b;
    public final r c;
    public final q d;

    public MultiInstanceInvalidationService() {
        this.b = new LinkedHashMap();
        this.c = new r(this);
        this.d = new q(this);
    }

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        kotlin.jvm.internal.q.g(intent0, "intent");
        return this.d;
    }
}

