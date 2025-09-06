package td;

import Ac.F2;
import Pc.e;
import Tf.o;
import Ub.t;
import android.net.Uri;
import androidx.lifecycle.c0;
import androidx.lifecycle.f0;
import androidx.media3.session.legacy.V;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.AppUtils;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.track.Event;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.playlist.interfaces.SetRepeatResult.Success;
import com.melon.playlist.interfaces.SetRepeatResult;
import com.melon.playlist.interfaces.SetShuffleResult;
import com.melon.ui.J4;
import com.melon.ui.K4;
import com.melon.ui.L2;
import com.melon.ui.N3;
import com.melon.ui.Q;
import com.melon.ui.b3;
import com.melon.ui.i;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.n0;
import com.melon.ui.n4;
import com.melon.ui.q3;
import com.melon.ui.s4;
import com.melon.ui.t3;
import d3.g;
import d5.n;
import d9.j;
import e1.b;
import e1.m;
import e3.h;
import hc.l;
import ie.H;
import ie.r;
import java.util.List;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted.Companion;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mb.k;
import ob.a;
import ob.z;
import oc.w;
import oe.c;
import pc.l1;
import pc.z0;
import qb.d;
import qd.K;
import qd.M;
import qd.N;
import qd.O;
import qd.P;
import qd.W;
import va.e0;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Ltd/t1;", "Lcom/melon/ui/n0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class t1 extends n0 {
    public final MutableStateFlow A;
    public final MutableStateFlow B;
    public final MutableStateFlow C;
    public final MutableStateFlow D;
    public final MutableStateFlow E;
    public final MutableStateFlow F;
    public final MutableStateFlow G;
    public final r H;
    public final r I;
    public final r J;
    public final r K;
    public static final int L;
    public final CoroutineDispatcher a;
    public final StringProviderImpl b;
    public final s2 c;
    public final z d;
    public final a e;
    public final k f;
    public final V g;
    public final Q h;
    public final t3 i;
    public final b3 j;
    public final n4 k;
    public final W l;
    public final LogU m;
    public final StateFlow n;
    public final StateFlow o;
    public final StateFlow p;
    public final StateFlow q;
    public final StateFlow r;
    public final StateFlow s;
    public final StateFlow t;
    public final StateFlow u;
    public final MutableStateFlow v;
    public final MutableStateFlow w;
    public final MutableStateFlow x;
    public final MutableStateFlow y;
    public final MutableStateFlow z;

    public t1(c0 c00, CoroutineDispatcher coroutineDispatcher0, CoroutineDispatcher coroutineDispatcher1, CoroutineDispatcher coroutineDispatcher2, StringProviderImpl stringProviderImpl0, s2 s20, z z0, a a0, l l0, k k0, V v0, Q q0, t3 t30, b3 b30, n4 n40, W w0) {
        q.g(c00, "savedStateHandle");
        q.g(s20, "playlistManager");
        q.g(k0, "loginUseCase");
        super();
        this.a = coroutineDispatcher2;
        this.b = stringProviderImpl0;
        this.c = s20;
        this.d = z0;
        this.e = a0;
        this.f = k0;
        this.g = v0;
        this.h = q0;
        this.i = t30;
        this.j = b30;
        this.k = n40;
        this.l = w0;
        this.m = new LogU("NewMusicPlayerViewModel");
        Flow flow0 = FlowKt.flowOn(FlowKt.transformLatest(FlowKt.filterNotNull(((d3)s20).i()), new d(null, this)), coroutineDispatcher1);
        T2.a a1 = f0.h(this);
        SharingStarted sharingStarted0 = Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null);
        PlaylistId playlistId0 = ((d3)s20).j();
        w w1 = ((d3)s20).k();
        StateFlow stateFlow0 = FlowKt.stateIn(flow0, a1, sharingStarted0, t1.g(playlistId0, (w1 == null ? null : w1.getState())));
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), coroutineDispatcher0, null, new a1(stateFlow0, this, null), 2, null);
        this.n = stateFlow0;
        this.o = FlowKt.stateIn(z0.h(), f0.h(this), Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), Boolean.valueOf(z0.n()));
        this.p = FlowKt.stateIn(z.k(z0), f0.h(this), Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), z0.j());
        this.q = FlowKt.stateIn(FlowKt.transformLatest(FlowKt.filterNotNull(((d3)s20).i()), new V0(null, this, 0)), f0.h(this), Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), null);
        this.r = FlowKt.stateIn(FlowKt.transformLatest(FlowKt.filterNotNull(((d3)s20).i()), new V0(null, this, 1)), f0.h(this), Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), null);
        this.s = FlowKt.stateIn(FlowKt.distinctUntilChanged(new F2(FlowKt.asStateFlow(z0.c.b), 24)), f0.h(this), Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), z0.c.a().j);
        T2.a a2 = f0.h(this);
        SharingStarted sharingStarted1 = Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null);
        this.t = FlowKt.stateIn(((t)l0.b).i, a2, sharingStarted1, null);
        this.u = FlowKt.stateIn(FlowKt.transformLatest(FlowKt.filterNotNull(((d3)s20).i()), new W0(null, this)), f0.h(this), Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), v1.d);
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(j.b("NewMusicPlayerViewModel"));
        this.v = mutableStateFlow0;
        this.w = mutableStateFlow0;
        MutableStateFlow mutableStateFlow1 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.x = mutableStateFlow1;
        this.y = mutableStateFlow1;
        MutableStateFlow mutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this.z = mutableStateFlow2;
        this.A = mutableStateFlow2;
        MutableStateFlow mutableStateFlow3 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.B = mutableStateFlow3;
        this.C = mutableStateFlow3;
        Integer integer0 = (Integer)c00.a("arg_display_type");
        MutableStateFlow mutableStateFlow4 = StateFlowKt.MutableStateFlow(Boolean.valueOf(integer0 != null && ((int)integer0) == 2));
        this.D = mutableStateFlow4;
        this.E = mutableStateFlow4;
        MutableStateFlow mutableStateFlow5 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.F = mutableStateFlow5;
        this.G = mutableStateFlow5;
        this.H = g.Q(new L0(this, 0));
        this.I = g.Q(new L0(this, 1));
        this.J = g.Q(new L0(this, 2));
        this.K = g.Q(new L0(this, 3));
        this.updateTiaraProperty(stringProviderImpl0.a(0x7F130E53), stringProviderImpl0.a(0x7F130E44), "1000000543");  // string:tiara_common_section_music_player "곡플레이어"
    }

    public static final Object b(t1 t10, PlaylistId playlistId0, oc.Q q0, c c0) {
        pb.r r0;
        long v2;
        K4 k41;
        K4 k40;
        long v1;
        S0 s00;
        if(c0 instanceof S0) {
            s00 = (S0)c0;
            int v = s00.E;
            if((v & 0x80000000) == 0) {
                s00 = new S0(t10, c0);
            }
            else {
                s00.E = v ^ 0x80000000;
            }
        }
        else {
            s00 = new S0(t10, c0);
        }
        Enum enum0 = s00.B;
        ne.a a0 = ne.a.a;
        switch(s00.E) {
            case 0: {
                n.D(enum0);
                v1 = System.currentTimeMillis();
                k40 = t1.g(playlistId0, q0);
                if(!(k40 instanceof p0)) {
                    return J4.a;
                }
                Playable playable0 = ((p0)k40).b;
                if(playable0 == null) {
                    k41 = k40;
                    r0 = pb.r.a;
                    v2 = v1;
                    break;
                }
                else {
                    boolean z = playable0.isOriginLocal();
                    U0 u00 = new U0(t10, playable0, null);
                    boolean z1 = playable0.isTypeOfSong();
                    s00.r = k40;
                    s00.w = v1;
                    s00.E = 1;
                    t10.e.getClass();
                    Enum enum1 = new h().r(z, u00, z1, playable0.getDurationLimit(), "", "", s00);  // 初始化器: Ljava/lang/Object;-><init>()V
                    if(enum1 == a0) {
                        return a0;
                    }
                    k41 = k40;
                    enum0 = enum1;
                    v2 = v1;
                    goto label_37;
                }
                break;
            }
            case 1: {
                v2 = s00.w;
                k41 = s00.r;
                n.D(enum0);
            label_37:
                if(((pb.r)enum0) == null) {
                    v1 = v2;
                    k40 = k41;
                    k41 = k40;
                    r0 = pb.r.a;
                    v2 = v1;
                }
                else {
                    r0 = (pb.r)enum0;
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        q.g(((p0)k41).a, "playlistId");
        p0 p00 = new p0(((p0)k41).a, ((p0)k41).b, ((p0)k41).c, ((p0)k41).d, ((p0)k41).e, ((p0)k41).f, ((p0)k41).g, ((p0)k41).h, ((p0)k41).i, ((p0)k41).j, ((p0)k41).k, r0);
        LogConstantsKt.debug(t10.m, "makeUiState", v2);
        return p00;
    }

    public static final Object c(t1 t10, c c0) {
        o1 o10;
        if(c0 instanceof o1) {
            o10 = (o1)c0;
            int v = o10.B;
            if((v & 0x80000000) == 0) {
                o10 = new o1(t10, c0);
            }
            else {
                o10.B = v ^ 0x80000000;
            }
        }
        else {
            o10 = new o1(t10, c0);
        }
        Object object0 = o10.r;
        ne.a a0 = ne.a.a;
        switch(o10.B) {
            case 0: {
                n.D(object0);
                o10.B = 1;
                object0 = t10.d.E(o10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((SetRepeatResult)object0) instanceof Success) {
            t10.l.c(((Success)(((SetRepeatResult)object0))));
        }
        return H.a;
    }

    public static final Object d(t1 t10, c c0) {
        p1 p10;
        if(c0 instanceof p1) {
            p10 = (p1)c0;
            int v = p10.B;
            if((v & 0x80000000) == 0) {
                p10 = new p1(t10, c0);
            }
            else {
                p10.B = v ^ 0x80000000;
            }
        }
        else {
            p10 = new p1(t10, c0);
        }
        Object object0 = p10.r;
        ne.a a0 = ne.a.a;
        switch(p10.B) {
            case 0: {
                n.D(object0);
                p10.B = 1;
                object0 = t10.d.F(p10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((SetShuffleResult)object0) instanceof com.melon.playlist.interfaces.SetShuffleResult.Success) {
            t10.l.d(((com.melon.playlist.interfaces.SetShuffleResult.Success)(((SetShuffleResult)object0))));
        }
        return H.a;
    }

    public final String e() {
        if(((Boolean)this.C.getValue()).booleanValue()) {
            return "connViewmore";
        }
        return ((Boolean)this.E.getValue()).booleanValue() ? "playerLyric" : "playerPlaying";
    }

    public final td.n0 f() {
        return (td.n0)this.H.getValue();
    }

    public static K4 g(PlaylistId playlistId0, oc.Q q0) {
        boolean z5;
        Uri uri0;
        String s3;
        String s1;
        if(playlistId0 != null && q0 != null) {
            PlayableData playableData0 = b.z(q0);
            Playable playable0 = playableData0 == null ? null : playableData0.a;
            if(playableData0 == null) {
                s1 = "";
            }
            else {
                String s = playableData0.h;
                s1 = s == null ? "" : s;
            }
            if(playableData0 == null) {
                s3 = "";
            }
            else {
                String s2 = playableData0.i;
                s3 = s2 == null ? "" : s2;
            }
            if(playableData0 == null) {
                uri0 = Uri.EMPTY;
            }
            else {
                uri0 = playableData0.n;
                if(uri0 == null) {
                    uri0 = Uri.EMPTY;
                }
            }
            q.d(uri0);
            boolean z = false;
            boolean z1 = playable0 == null ? false : playable0.isMelonSong();
            boolean z2 = playable0 == null ? false : playable0.hasSongId();
            boolean z3 = playableData0 == null ? false : playableData0.k;
            int v = playableData0 == null ? -1 : playableData0.l;
            boolean z4 = true;
            if(playable0 == null) {
                z5 = false;
            }
            else {
                if(playable0.getBgVideo() == null || !o.H0("") != 1) {
                    List list0 = playable0.getBgImgs();
                    if(list0 == null || !list0.isEmpty() != 1) {
                        z4 = false;
                    }
                }
                z5 = z4;
            }
            if(playable0 != null) {
                z = playable0.isOriginLocal();
            }
            return new p0(playlistId0, playable0, s1, s3, uri0, z1, z2, z3, v, z5, z, pb.r.a);
        }
        return J4.a;
    }

    public final Playable getCurrentPlayable() {
        Object object0 = this.getUiState().getValue();
        p0 p00 = object0 instanceof p0 ? ((p0)object0) : null;
        return p00 == null ? null : p00.b;
    }

    // 去混淆评级： 低(20)
    public final boolean h() {
        return !((Boolean)this.C.getValue()).booleanValue() && !((Boolean)this.E.getValue()).booleanValue();
    }

    public final boolean i(z0 z00) {
        boolean z = z00.c instanceof pc.a;
        if(!z) {
            LogU.debug$default(this.m, "invalid MixUpPlaylistState: " + z00, null, false, 6, null);
        }
        return z;
    }

    public final boolean isLoginUser() {
        return ((e0)this.f).m();
    }

    public final void j() {
        Boolean boolean0 = Boolean.valueOf(MelonSettingInfo.isEqualizerStatusOn());
        this.F.setValue(boolean0);
        String s = androidx.appcompat.app.o.m(this.F.getValue(), "updateEqOn - isEqOn: ");
        LogU.debug$default(this.m, s, null, false, 6, null);
    }

    @Override  // com.melon.ui.n0
    public final void onUserEvent(e e0) {
        q.g(e0, "userEvent");
        boolean z = e0.equals(B0.a);
        MutableStateFlow mutableStateFlow0 = this.D;
        if(z) {
            mutableStateFlow0.setValue(Boolean.FALSE);
            td.n0 n00 = this.f();
            Playable playable0 = (Playable)n00.b.invoke();
            q8.d d0 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n00.b(d0, ActionKind.ClickContent, playable0);
            ((q8.h)d0.b).a = n00.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d0.b(new k0(n00, 18));
            d0.e(new td.f0(20, playable0));
            ((Event)d0.p()).track();
            return;
        }
        boolean z1 = e0.equals(t0.a);
        MutableStateFlow mutableStateFlow1 = this.B;
        if(z1) {
            mutableStateFlow1.setValue(Boolean.TRUE);
            td.n0 n01 = this.f();
            Playable playable1 = (Playable)n01.b.invoke();
            q8.d d1 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n01.b(d1, ActionKind.ClickContent, playable1);
            ((q8.h)d1.b).a = n01.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d1.b(new k0(n01, 23));
            d1.e(new td.f0(27, playable1));
            ((Event)d1.p()).track();
            return;
        }
        boolean z2 = e0.equals(K0.a);
        z z3 = this.d;
        if(z2) {
            z3.e.t(true);
            td.n0 n02 = this.f();
            Playable playable2 = (Playable)n02.b.invoke();
            q8.d d2 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n02.b(d2, ActionKind.ClickContent, playable2);
            ((q8.h)d2.b).a = n02.a(0x7F130DD3);  // string:tiara_common_action_swipe "스와이프"
            d2.b(new k0(n02, 3));
            d2.e(new td.f0(6, playable2));
            ((Event)d2.p()).track();
            return;
        }
        if(e0.equals(J0.a)) {
            z3.e.q();
            td.n0 n03 = this.f();
            Playable playable3 = (Playable)n03.b.invoke();
            q8.d d3 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n03.b(d3, ActionKind.ClickContent, playable3);
            ((q8.h)d3.b).a = n03.a(0x7F130DD3);  // string:tiara_common_action_swipe "스와이프"
            d3.b(new k0(n03, 24));
            d3.e(new td.f0(28, playable3));
            ((Event)d3.p()).track();
            return;
        }
        if(e0.equals(r0.a) || e0.equals(s0.a)) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new f1(this, e0, null), 3, null);
            return;
        }
        boolean z4 = e0.equals(v0.a);
        Q q0 = this.h;
        if(z4) {
            Playable playable4 = this.getCurrentPlayable();
            if(playable4 == null) {
                return;
            }
            q.f("", "getSongidString(...)");
            q.f("", "getSongName(...)");
            l1 l10 = new l1("", "", playable4.getArtistid(), null);
            q0.d(new i(this.getMenuId(), l10), f0.h(this), new L(1, this, t1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 7));
            td.n0 n04 = this.f();
            n04.getClass();
            m.F(new com.iloen.melon.player.playlist.mixup.composables.c(n04, ((Playable)n04.b.invoke()), l10, 29)).track();
            return;
        }
        MutableStateFlow mutableStateFlow2 = this.z;
        if(e0 instanceof H0) {
            mutableStateFlow2.setValue(((long)((H0)e0).a));
            return;
        }
        if(e0 instanceof I0) {
            z3.z(((long)((I0)e0).a));
            mutableStateFlow2.setValue(null);
            return;
        }
        if(e0 instanceof G0) {
            z3.z(((long)((G0)e0).a));
            return;
        }
        if(e0.equals(F0.a)) {
            z.D(z3, 2);
            return;
        }
        if(e0.equals(E0.a)) {
            z.B(z3, 2);
            return;
        }
        if(e0.equals(A0.a)) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new e1(null, this), 3, null);
            td.n0 n05 = this.f();
            Playable playable5 = (Playable)n05.b.invoke();
            q8.d d4 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n05.b(d4, ActionKind.ClickContent, playable5);
            ((q8.h)d4.b).a = n05.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d4.b(new k0(n05, 5));
            d4.e(new td.f0(8, playable5));
            ((Event)d4.p()).track();
            return;
        }
        if(e0.equals(td.z0.a)) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new c1(null, this), 3, null);
            td.n0 n06 = this.f();
            Playable playable6 = (Playable)n06.b.invoke();
            q8.d d5 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n06.b(d5, ActionKind.ClickContent, playable6);
            ((q8.h)d5.b).a = n06.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d5.b(new k0(n06, 20));
            d5.e(new td.f0(22, playable6));
            ((Event)d5.p()).track();
            return;
        }
        if(e0.equals(w0.a)) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new h1(null, this), 3, null);
            return;
        }
        if(e0.equals(x0.a)) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new i1(null, this), 3, null);
            td.n0 n07 = this.f();
            Playable playable7 = (Playable)n07.b.invoke();
            q8.d d6 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n07.b(d6, ActionKind.ClickContent, playable7);
            ((q8.h)d6.b).a = n07.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d6.b(new k0(n07, 14));
            d6.e(new td.f0(16, playable7));
            ((Event)d6.p()).track();
            return;
        }
        if(e0.equals(u0.a)) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new j1(null, this), 3, null);
            td.n0 n08 = this.f();
            Playable playable8 = (Playable)n08.b.invoke();
            q8.d d7 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n08.b(d7, ActionKind.ClickContent, playable8);
            ((q8.h)d7.b).a = n08.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d7.b(new k0(n08, 4));
            d7.e(new td.f0(7, playable8));
            ((Event)d7.p()).track();
            return;
        }
        if(e0 instanceof D0) {
            z3.y(((D0)e0).a, ((D0)e0).b);
            if(((D0)e0).a != 0) {
                return;
            }
            td.n0 n09 = this.f();
            Playable playable9 = (Playable)n09.b.invoke();
            q8.d d8 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n09.b(d8, ActionKind.ClickContent, playable9);
            ((q8.h)d8.b).a = n09.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d8.b(new k0(n09, 9));
            d8.e(new td.f0(12, playable9));
            ((Event)d8.p()).track();
            return;
        }
        if(e0 instanceof C0) {
            z3.c(((C0)e0).a, ((C0)e0).b);
            if(((C0)e0).a != 0) {
                return;
            }
            td.n0 n010 = this.f();
            Playable playable10 = (Playable)n010.b.invoke();
            q8.d d9 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n010.b(d9, ActionKind.ClickContent, playable10);
            ((q8.h)d9.b).a = n010.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d9.b(new k0(n010, 7));
            d9.e(new td.f0(11, playable10));
            ((Event)d9.p()).track();
            return;
        }
        if(e0.equals(qd.Q.a)) {
            if(((Boolean)this.E.getValue()).booleanValue()) {
                if(!AppUtils.isAccessibilityTalkbackOn()) {
                    mutableStateFlow0.setValue(Boolean.FALSE);
                }
                return;
            }
            td.n0 n011 = this.f();
            Playable playable11 = (Playable)n011.b.invoke();
            q8.d d10 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n011.b(d10, ActionKind.ClickContent, playable11);
            ((q8.h)d10.b).a = n011.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d10.b(new k0(n011, 1));
            d10.e(new td.f0(4, playable11));
            ((Event)d10.p()).track();
            ((d9.h)this.v.getValue()).b();
            mutableStateFlow0.setValue(Boolean.TRUE);
            return;
        }
        if(e0 instanceof O) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new k1(this, e0, null), 3, null);
            return;
        }
        if(e0.equals(P.a)) {
            td.n0 n012 = this.f();
            Playable playable12 = (Playable)n012.b.invoke();
            q8.d d11 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n012.b(d11, ActionKind.ClickContent, playable12);
            ((q8.h)d11.b).a = n012.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d11.b(new k0(n012, 19));
            d11.e(new td.f0(21, playable12));
            ((Event)d11.p()).track();
            return;
        }
        if(e0 instanceof N) {
            td.n0 n013 = this.f();
            n013.getClass();
            q.g(((N)e0).a, "newLyricSizeStr");
            Playable playable13 = (Playable)n013.b.invoke();
            q8.d d12 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n013.b(d12, ActionKind.ClickContent, playable13);
            ((q8.h)d12.b).a = n013.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d12.b(new m9.l(15, n013, ((N)e0).a));
            d12.e(new td.f0(24, playable13));
            ((Event)d12.p()).track();
            return;
        }
        if(e0.equals(qd.L.a)) {
            td.n0 n014 = this.f();
            Playable playable14 = (Playable)n014.b.invoke();
            q8.d d13 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n014.b(d13, ActionKind.ClickContent, playable14);
            ((q8.h)d13.b).a = n014.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d13.b(new k0(n014, 15));
            d13.e(new td.f0(17, playable14));
            ((Event)d13.p()).track();
            return;
        }
        if(e0.equals(K.a)) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new m1(null, this), 3, null);
            td.n0 n015 = this.f();
            Playable playable15 = (Playable)n015.b.invoke();
            q8.d d14 = new q8.d();  // 初始化器: LQb/h;-><init>()V
            n015.b(d14, ActionKind.ClickContent, playable15);
            ((q8.h)d14.b).a = n015.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            d14.b(new k0(n015, 21));
            d14.e(new td.f0(23, playable15));
            ((Event)d14.p()).track();
            return;
        }
        if(e0.equals(M.a)) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n1(null, this), 3, null);
            return;
        }
        if(e0.equals(y0.a)) {
            if(!this.isLoginUser()) {
                this.sendUiEvent(s4.a);
                return;
            }
            Playable playable16 = this.getCurrentPlayable();
            if(playable16 != null) {
                Object object0 = this.getUiState().getValue();
                PlaylistId playlistId0 = null;
                p0 p00 = object0 instanceof p0 ? ((p0)object0) : null;
                if(p00 != null) {
                    playlistId0 = p00.a;
                }
                int v = playlistId0 == null ? -1 : M0.a[playlistId0.ordinal()];
                if(v != 1 && v != 2) {
                    this.sendUiEvent(new o0(playable16, false));
                    return;
                }
                if(!((e0)this.f).j().getIsDj()) {
                    this.onUserEvent(new q3("M20001", e.k.z(playable16), ""));
                    return;
                }
                this.sendUiEvent(new o0(playable16, true));
            }
            return;
        }
        if(e0.equals(q0.a)) {
            mutableStateFlow1.setValue(Boolean.FALSE);
            return;
        }
        if(e0 instanceof com.melon.ui.q) {
            q0.d(((com.melon.ui.q)e0), f0.h(this), new L(1, this, t1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 10));
            return;
        }
        if(e0 instanceof q3) {
            T2.a a0 = f0.h(this);
            boolean z5 = this.isLoginUser();
            L l0 = new L(1, this, t1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 11);
            com.iloen.melon.custom.L0 l00 = this.getProgressUpdater();
            this.i.a(((q3)e0), a0, z5, l0, l00);
            return;
        }
        if(e0 instanceof L2) {
            T2.a a1 = f0.h(this);
            boolean z6 = this.isLoginUser();
            L l1 = new L(1, this, t1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 8);
            com.iloen.melon.custom.L0 l01 = this.getProgressUpdater();
            this.j.b(((L2)e0), a1, z6, l1, l01);
            return;
        }
        if(e0 instanceof N3) {
            T2.a a2 = f0.h(this);
            boolean z7 = this.isLoginUser();
            L l2 = new L(1, this, t1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 9);
            com.iloen.melon.custom.L0 l02 = this.getProgressUpdater();
            this.k.b(((N3)e0), a2, z7, l2, l02);
            return;
        }
        super.onUserEvent(e0);
    }
}

