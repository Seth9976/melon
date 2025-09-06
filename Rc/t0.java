package Rc;

import A7.d;
import Nc.f;
import Pc.e;
import U4.x;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.media3.session.legacy.V;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.net.v4x.request.UaLogDummyReq;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.DateUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import d3.g;
import d9.j;
import e1.b;
import hc.l;
import ie.H;
import ie.r;
import java.util.ArrayList;
import java.util.Calendar;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ob.z;
import oc.Q;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"LRc/t0;", "Lcom/melon/ui/k1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class t0 extends k1 {
    public final Context a;
    public final StringProviderImpl b;
    public final s2 c;
    public final z d;
    public final V e;
    public final l f;
    public final LogU g;
    public a h;
    public a i;
    public Q j;
    public final r k;
    public boolean l;
    public boolean m;
    public boolean n;
    public String o;
    public String p;
    public String q;
    public long r;
    public final f0 s;
    public final MutableStateFlow t;
    public final MutableStateFlow u;
    public static final int v;

    public t0(Context context0, StringProviderImpl stringProviderImpl0, s2 s20, z z0, V v0, l l0) {
        q.g(s20, "playlistManager");
        super();
        this.a = context0;
        this.b = stringProviderImpl0;
        this.c = s20;
        this.d = z0;
        this.e = v0;
        this.f = l0;
        LogU logU0 = new LogU("LockScreenViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.g = logU0;
        this.h = L.e;
        this.i = D.e;
        this.k = g.Q(new f(this, 9));
        this.n = true;
        this.s = new f0(this);
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(j.b("LockScreenViewModel"));
        this.t = mutableStateFlow0;
        this.u = mutableStateFlow0;
    }

    public static final void c(t0 t00, String s) {
        String s16;
        String s12;
        String s8;
        String s7;
        String s5;
        l l0 = t00.f;
        StringProviderImpl stringProviderImpl0 = t00.b;
        if(t00.j == null) {
            return;
        }
        Calendar calendar0 = Calendar.getInstance();
        boolean z = calendar0.get(9) == 1;
        String s1 = stringProviderImpl0.a((z ? 0x7F13051B : 0x7F130519));  // string:lockscreen_player_pm "오후"
        int v = calendar0.get(10);
        int v1 = !z || v != 0 ? v : 12;
        int v2 = calendar0.get(12);
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(stringProviderImpl0.b(0x7F13051A, new Object[]{((int)(calendar0.get(2) + 1)), calendar0.get(5)}));  // string:lockscreen_player_date "%1$d.%2$d"
        stringBuilder0.append(" ");
        long v3 = calendar0.getTimeInMillis();
        stringBuilder0.append(DateUtils.getDayOfWeek(t00.a, v3));
        Q q0 = t00.j;
        Boolean boolean0 = null;
        if(q0 != null) {
            PlayableData playableData0 = b.z(q0);
            Playable playable0 = playableData0 == null ? null : playableData0.a;
            t00.m = playable0 == null ? false : playable0.isLiked();
            a a0 = t00.h;
            a a1 = t00.i;
            String s2 = stringProviderImpl0.b(0x7F13051C, new Object[]{v1});  // string:lockscreen_player_time "%1$02d"
            String s3 = stringProviderImpl0.b(0x7F13051C, new Object[]{v2});  // string:lockscreen_player_time "%1$02d"
            String s4 = stringBuilder0.toString();
            q.f(s4, "toString(...)");
            M m0 = M.e;
            if(q.b(t00.h, m0)) {
                s5 = t00.o;
                if(s5 == null) {
                    s5 = "";
                }
            }
            else if(playableData0 == null) {
                s5 = "";
            }
            else {
                Uri uri0 = playableData0.n;
                if(uri0 == null) {
                    s5 = "";
                }
                else {
                    s5 = uri0.toString();
                    if(s5 == null) {
                        s5 = "";
                    }
                }
            }
            if(q.b(t00.h, m0)) {
                String s6 = t00.p;
                s7 = s6 == null ? "" : s6;
            }
            else {
                s7 = t0.e(playable0);
            }
            if(q.b(t00.h, m0)) {
                s8 = t00.q;
                if(s8 == null) {
                    s8 = "";
                }
            }
            else {
                s8 = playable0 == null ? null : "";
                String s9 = l0.a();
                if(s9.length() != 0) {
                    s8 = s9;
                }
                else if(s8 == null) {
                    s8 = "";
                }
            }
            String s10 = t00.d() == null ? s3 : s3;
            boolean z1 = true;
            if(q.b(t00.h, m0)) {
                z1 = false;
            }
            else if(playable0 != null && playable0.isOriginLocal() || playable0 != null && playable0.isTypeOfLive()) {
                z1 = false;
            }
            boolean z2 = playable0 == null ? false : playable0.isLiked();
            boolean z3 = t00.n;
            boolean z4 = t00.l;
            if(playableData0 == null) {
                s12 = "";
            }
            else {
                Uri uri1 = playableData0.m;
                if(uri1 == null) {
                    s12 = "";
                }
                else {
                    String s11 = uri1.toString();
                    s12 = s11 == null ? "" : s11;
                }
            }
            String s13 = t0.e(playable0);
            String s14 = playable0 == null ? null : "";
            String s15 = l0.a();
            if(s15.length() != 0) {
                s16 = s15;
            }
            else if(s14 == null) {
                s16 = "";
            }
            else {
                s16 = s14;
            }
            Q q1 = t00.j;
            if(q1 != null) {
                int v4 = q1.b();
                Q q2 = t00.j;
                if(q2 != null) {
                    Iterable iterable0 = q2.c();
                    ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
                    for(Object object0: iterable0) {
                        q.f("", "getTrackId(...)");
                        String s17 = ((PlayableData)object0).m.toString();
                        q.f(s17, "toString(...)");
                        String s18 = t0.e(((PlayableData)object0).a);
                        String s19 = l0.a();
                        arrayList0.add(new Rc.b("", s17, s18, (s19.length() == 0 ? "" : s19), ((PlayableData)object0).a.isAdult()));
                    }
                    O o0 = new O(a0, a1, s2, s10, s1, s4, s5, s7, s8, ((boolean)1), z1, z2, z3, z4, v4, arrayList0, s12, s13, s16);
                    LogU logU0 = t00.g;
                    if(playable0 != null) {
                        boolean0 = Boolean.valueOf(playable0.isLiked());
                    }
                    boolean z5 = t00.n;
                    StringBuilder stringBuilder1 = d.o("refreshData (", s, "): ", (playable0 == null ? null : ""), " : ");
                    stringBuilder1.append(boolean0);
                    stringBuilder1.append(" : ");
                    stringBuilder1.append(z5);
                    stringBuilder1.append(" / ");
                    x.x(stringBuilder1, v1, ":", v2, " ");
                    stringBuilder1.append(s1);
                    LogU.debug$default(logU0, stringBuilder1.toString(), null, false, 6, null);
                    t00.updateUiState(new Mc.q(o0, 18));
                    return;
                }
                q.m("playlistState");
                throw null;
            }
            q.m("playlistState");
            throw null;
        }
        q.m("playlistState");
        throw null;
    }

    public final PlaylistId d() {
        return (PlaylistId)this.k.getValue();
    }

    // 去混淆评级： 低(37)
    public static String e(Playable playable0) {
        if(playable0 != null) {
            boolean z = !playable0.isTypeOfMv();
            boolean z1 = !playable0.isTypeOfLive();
        }
        return "";
    }

    public final void f() {
        Intent intent0;
        Context context0 = this.a;
        if(this.n) {
            intent0 = new Intent("com.iloen.melon.MELON_PLAYER_START");
            intent0.addCategory("android.intent.category.DEFAULT");
            intent0.addFlags(0x10000000);
            intent0.putExtra("activitystartactionname", "player");
        }
        else {
            intent0 = new Intent(context0, MusicBrowserActivity.class);
            intent0.addFlags(0x10000000);
        }
        context0.startActivity(intent0);
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        M m0;
        PlaylistId playlistId0 = this.d();
        H h0 = H.a;
        if(playlistId0 == null) {
            return h0;
        }
        if(this.d() != null && false) {
            m0 = M.e;
        }
        else if(this.d() == null || true) {
            m0 = L.e;
        }
        else {
            m0 = N.e;
        }
        this.h = m0;
        BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.h(this), null, null, new h0(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.h(this), null, null, new k0(this, null), 3, null);
        this.s.start();
        return h0;
    }

    @Override  // com.melon.ui.k1
    public final void onUserEvent(e e0) {
        q.g(e0, "userEvent");
        if(e0 instanceof Rc.Q) {
            this.f();
            return;
        }
        Context context0 = this.a;
        D d0 = D.e;
        if(e0 instanceof c0) {
            if(this.d() != null && false) {
                this.f();
                return;
            }
            if(!(this.i instanceof E)) {
                p8.O.a(new UaLogDummyReq(context0, "lockscreenPlaylist"));
                d0 = E.e;
            }
            this.i = d0;
            BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.h(this), Dispatchers.getDefault(), null, new l0(this, null), 2, null);
            return;
        }
        if(e0 instanceof b0) {
            if(!(this.i instanceof C)) {
                p8.O.a(new UaLogDummyReq(context0, "lockscreenLyric"));
                d0 = C.e;
            }
            this.i = d0;
            BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.h(this), Dispatchers.getDefault(), null, new m0(this, null), 2, null);
            return;
        }
        if(e0 instanceof P) {
            this.i = d0;
            BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.h(this), Dispatchers.getDefault(), null, new n0(this, null), 2, null);
            return;
        }
        if(e0 instanceof S) {
            BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.h(this), Dispatchers.getIO(), null, new o0(this, null), 2, null);
            return;
        }
        if(e0 instanceof X) {
            BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.h(this), Dispatchers.getDefault(), null, new p0(this, null), 2, null);
            return;
        }
        if(e0 instanceof U) {
            BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.h(this), Dispatchers.getDefault(), null, new q0(this, null), 2, null);
            return;
        }
        z z0 = this.d;
        if(e0 instanceof Rc.V) {
            z0.c(((Rc.V)e0).a, ((Rc.V)e0).b);
            return;
        }
        if(e0 instanceof Z) {
            BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.h(this), Dispatchers.getDefault(), null, new r0(this, null), 2, null);
            return;
        }
        if(e0 instanceof a0) {
            z0.y(((a0)e0).a, ((a0)e0).b);
            return;
        }
        if(e0 instanceof T) {
            z.C(z0);
            return;
        }
        if(e0 instanceof Y) {
            z.A(z0);
            return;
        }
        if(e0 instanceof W) {
            BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.h(this), null, null, new s0(e0, this, null), 3, null);
            return;
        }
        super.onUserEvent(e0);
    }
}

