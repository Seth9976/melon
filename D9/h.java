package d9;

import Ma.m;
import Ub.q;
import android.app.Application;
import android.content.Context;
import androidx.lifecycle.L;
import androidx.lifecycle.a;
import androidx.lifecycle.f0;
import com.google.firebase.b;
import com.iloen.melon.fragments.artistchannel.viewholder.e;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import k8.o;
import kc.d3;
import kc.s2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import oe.i;
import org.jetbrains.annotations.NotNull;

public final class h extends a {
    public final Application a;
    public final LogU b;
    public final CoroutineDispatcher c;
    public final CoroutineDispatcher d;
    public final q e;
    public final s2 f;
    public Job g;
    public final L h;
    public boolean i;
    public boolean j;
    public final L k;
    public List l;
    public Playable m;
    public Playable n;
    public long o;
    public long p;
    public int q;
    public long r;
    public boolean s;

    public h(@NotNull Application application0) {
        kotlin.jvm.internal.q.g(application0, "application");
        super(application0);
        this.a = application0;
        this.b = new LogU("LyricViewModel");
        this.c = Dispatchers.getDefault();
        this.d = Dispatchers.getIO();
        Context context0 = application0.getApplicationContext();
        kotlin.jvm.internal.q.f(context0, "getApplicationContext(...)");
        Context context1 = context0.getApplicationContext();
        kotlin.jvm.internal.q.d(context1);
        this.e = (q)((o)(((m)b.B(context1, m.class)))).u.get();
        Context context2 = application0.getApplicationContext();
        kotlin.jvm.internal.q.f(context2, "getApplicationContext(...)");
        Context context3 = context2.getApplicationContext();
        kotlin.jvm.internal.q.d(context3);
        s2 s20 = (s2)((o)(((m)b.B(context3, m.class)))).w.get();
        this.f = s20;
        this.h = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.k = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.l = new ArrayList();
        this.m = ((d3)s20).f();
    }

    public final void b() {
        Playable playable0 = this.m;
        if(playable0 != null && playable0.isTypeOfSong() && playable0.isOriginLocal() && playable0.hasLocalFile()) {
            T2.a a0 = f0.h(this);
            d d0 = new d(playable0, "", "", this, null);
            BuildersKt__Builders_commonKt.launch$default(a0, this.d, null, d0, 2, null);
        }
    }

    public final void c() {
        LogU.debug$default(this.b, "reset()", null, false, 6, null);
        synchronized(this) {
            this.r = 0L;
            this.q = 0;
            this.o = 0L;
            this.p = 0L;
        }
    }

    public final void d() {
        Job job0 = this.g;
        boolean z = true;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        if(((fc.a)FlowKt.asStateFlow(this.e.b).getValue()).b) {
            PlaylistId playlistId0 = ((d3)this.f).j();
            if(playlistId0 == null || !playlistId0.isAudioType()) {
                z = false;
            }
        }
        else {
            z = false;
        }
        LogU.Companion.d("LyricViewModelProvider", "isActive() " + j.a.size());
        if(j.a.size() > 0 && z) {
            this.g = BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new f(this, null), 3, null);
        }
    }

    public final void e(Playable playable0) {
        LogU.debug$default(this.b, "set playable, songName = " + (playable0 == null ? null : ""), null, false, 6, null);
        L l0 = this.k;
        if(playable0 == null) {
            LogU.debug$default(this.b, "set playable, playable is null so lyric clear", null, false, 6, null);
            this.l.clear();
            l0.postValue(this.l);
            this.n = null;
        }
        else {
            this.f(playable0, false);
            if(!kotlin.jvm.internal.q.b(this.n, playable0)) {
                this.l.clear();
                l0.postValue(this.l);
            }
        }
        this.m = playable0;
        this.h.postValue(-1);
    }

    public final void f(Playable playable0, boolean z) {
        Playable playable1 = null;
        if(kotlin.jvm.internal.q.b(this.n, playable0) && (kotlin.jvm.internal.q.b((this.n == null ? null : ""), (playable0 == null ? null : "")) && !z)) {
            return;
        }
        LogU.debug$default(this.b, "startFetchLyric(), perform", null, false, 6, null);
        x8.f.execute$default(new d9.b(playable0, z, new e(6, playable0, this)), null, 1, null);
        if(kotlin.jvm.internal.q.b(this.m, playable0)) {
            playable1 = Playable.copyValueOf(playable0);
        }
        this.n = playable1;
    }

    public final Object g(i i0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getMain(), new g(this, null), i0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    @Override  // androidx.lifecycle.m0
    public final void onCleared() {
        this.c();
        Job job0 = this.g;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        if(this.s) {
            this.s = false;
        }
        super.onCleared();
    }
}

