package I8;

import Td.b;
import android.content.Context;
import com.iloen.melon.eventbus.EventAudioSync.Finish;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.playback.TaskUpdateLocalPlaylists;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import com.iloen.melon.utils.preference.MelonPrefs;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class c extends i implements n {
    public final String B;
    public final Context r;
    public final boolean w;

    public c(Context context0, boolean z, String s, Continuation continuation0) {
        this.r = context0;
        this.w = z;
        this.B = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((c)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        p p0;
        d5.n.D(object0);
        e e0 = f.b;
        Context context0 = this.r;
        boolean z = this.w;
        String s = this.B;
        q.g(context0, "context");
        f f0 = f.d;
        if(f0 == null) {
            synchronized(e0) {
                f0 = f.d;
                if(f0 == null) {
                    Context context1 = context0.getApplicationContext();
                    q.f(context1, "getApplicationContext(...)");
                    f0 = new f(context1);
                    f.d = f0;
                }
            }
        }
        q.g("android.permission.READ_MEDIA_AUDIO", "permission");
        if(b.e(context0, "android.permission.READ_MEDIA_AUDIO")) {
            synchronized(f0) {
                p0 = f.a(f0, z);
                if(p0.a() > 0) {
                    new TaskUpdateLocalPlaylists().updateFromSyncResultAsync(p0);
                }
                if(!StorageUtils.isScopedStorage()) {
                    if(!MelonPrefs.getInstance().getBoolean("MELON_MEDIA_STORE_MIGRATION", false)) {
                        LogU.debug$default(f.c, "syncImmediately() Start migrate local contents.", null, false, 6, null);
                        G8.f.a(context0);
                    }
                    MusicUtils.cleanupJunkDataSafety(context0);
                }
                if(z || p0.a() > 0) {
                    DevLog.Companion.get("Local Audio").put("syncImmediately(" + s + "), " + p0);
                }
            }
        }
        else {
            LogU.warn$default(f.c, "syncImmediately() Check storage permission.", null, false, 6, null);
            p0 = p.d;
        }
        int v2 = p0.a();
        LogU.debug$default(f.c, "sync() type : SyncType[All], updateItems: " + v2, null, false, 6, null);
        EventBusHelper.post(new Finish(0, p0.a()));
        return H.a;
    }
}

