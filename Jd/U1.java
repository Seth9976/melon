package jd;

import Ac.m4;
import Na.d;
import Na.e;
import Na.f;
import androidx.lifecycle.f0;
import com.iloen.melon.constants.CType;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v6x.response.MusicWaveChannelListRes.RESPONSE.CHANNELINFO.HOST;
import com.iloen.melon.net.v6x.response.MusicWaveChannelListRes.RESPONSE.CHANNELINFO;
import com.iloen.melon.net.v6x.response.MusicWaveChannelListRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MusicWaveHostMessageRes.Response;
import com.iloen.melon.net.v6x.response.MusicWaveHostMessageRes;
import com.iloen.melon.net.v6x.response.MusicWaveSongListRes;
import com.iloen.melon.net.v6x.response.MusicWaveStaticsRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta.Builder;
import com.kakao.tiara.data.Meta;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.F2;
import com.melon.ui.K4;
import com.melon.ui.L2;
import com.melon.ui.N3;
import com.melon.ui.Q;
import com.melon.ui.Z0;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.b3;
import com.melon.ui.c1;
import com.melon.ui.d1;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import com.melon.ui.musicwave.ChannelInfoData;
import com.melon.ui.n0;
import com.melon.ui.n4;
import com.melon.ui.q3;
import com.melon.ui.t2;
import com.melon.ui.t3;
import d5.n;
import d5.w;
import h7.u0;
import hd.U1;
import hd.i;
import hd.z1;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import je.p;
import k8.Y;
import kb.A;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ne.a;
import oe.c;
import p8.g;
import p8.s;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Ljd/u1;", "Lcom/melon/ui/k1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class u1 extends k1 {
    public final A a;
    public final b3 b;
    public final n4 c;
    public final t3 d;
    public final Q e;
    public final StringProviderImpl f;
    public String g;
    public String h;
    public String i;
    public int j;
    public final MutableStateFlow k;
    public final MutableStateFlow l;
    public final LogU m;
    public int n;
    public static final int o;

    public u1(s2 s20, A a0, b3 b30, n4 n40, t3 t30, Q q0, StringProviderImpl stringProviderImpl0) {
        q.g(s20, "playlistManager");
        super();
        this.a = a0;
        this.b = b30;
        this.c = n40;
        this.d = t30;
        this.e = q0;
        this.f = stringProviderImpl0;
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(0);
        this.k = mutableStateFlow0;
        this.l = mutableStateFlow0;
        LogU logU0 = new LogU("MusicWaveChannelViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.m = logU0;
        n0.updateTiaraProperty$default(this, null, null, "1000003041", 3, null);
    }

    public static m4 c(u1 u10, d1 d10) {
        q.g(d10, "fetchResult");
        if(d10 instanceof c1) {
            RESPONSE musicWaveChannelListRes$RESPONSE0 = (RESPONSE)((c1)d10).a;
            K4 k40 = (K4)u10.getUiState().getValue();
            int v = k40 instanceof j1 ? ((j1)k40).b + 1 : 0;
            u10.updateTiaraProperty(u10.f.a(0x7F130E54), u10.f.a(0x7F130E47), "1000003041");  // string:tiara_common_section_music_wave "뮤직웨이브"
            w.e = musicWaveChannelListRes$RESPONSE0.getHeartsImgUrl();
            List list0 = musicWaveChannelListRes$RESPONSE0.getChannelList();
            if(list0 != null) {
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
                for(Object object0: list0) {
                    String s = ((CHANNELINFO)object0).getId();
                    String s1 = ((CHANNELINFO)object0).getTitle();
                    String s2 = ((CHANNELINFO)object0).getM();
                    String s3 = ((CHANNELINFO)object0).getKey();
                    boolean z = ((CHANNELINFO)object0).isChatAvail();
                    String s4 = ((CHANNELINFO)object0).getType();
                    HOST musicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST0 = ((CHANNELINFO)object0).getHost();
                    HOST musicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST1 = ((CHANNELINFO)object0).getHost();
                    HOST musicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST2 = ((CHANNELINFO)object0).getHost();
                    arrayList0.add(new ChannelInfoData(s, s1, s2, z, s3, s4, (musicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST0 == null ? null : musicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST0.getHostId()), (musicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST1 == null ? null : musicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST1.getName()), (musicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST2 == null ? null : musicWaveChannelListRes$RESPONSE$CHANNELINFO$HOST2.getImgUrl()), ((CHANNELINFO)object0).getBgImgUrl(), ((CHANNELINFO)object0).getBgColor(), ((CHANNELINFO)object0).getArtistChatBgColor(), musicWaveChannelListRes$RESPONSE0.getChatCleanUrl(), musicWaveChannelListRes$RESPONSE0.getProfileCleanUrl()));
                }
                return new j1(arrayList0, v);
            }
            return new j1(je.w.a, v);
        }
        if(d10 instanceof Z0) {
            return new h1(((Z0)d10).a);
        }
        if(d10 instanceof a1) {
            u10.cancelFetch();
            return null;
        }
        if(!(d10 instanceof b1)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return new i1(((b1)d10).a);
    }

    public static ChannelInfoData d(u1 u10) {
        int v = u10.j;
        K4 k40 = (K4)u10.getUiState().getValue();
        return k40 instanceof j1 ? ((ChannelInfoData)p.n0(v, ((List)((j1)k40).a))) : null;
    }

    public final Serializable e(c c0) {
        o1 o10;
        if(c0 instanceof o1) {
            o10 = (o1)c0;
            int v = o10.B;
            if((v & 0x80000000) == 0) {
                o10 = new o1(this, c0);
            }
            else {
                o10.B = v ^ 0x80000000;
            }
        }
        else {
            o10 = new o1(this, c0);
        }
        Object object0 = o10.r;
        Serializable serializable0 = a.a;
        switch(o10.B) {
            case 0: {
                n.D(object0);
                ChannelInfoData channelInfoData0 = u1.d(this);
                String s = channelInfoData0 == null ? null : channelInfoData0.f;
                String s1 = "";
                if(s == null) {
                    s = "";
                }
                String s2 = channelInfoData0 == null ? null : channelInfoData0.a;
                if(s2 != null) {
                    s1 = s2;
                }
                o10.B = 1;
                object0 = this.a.f(s, s1, o10);
                if(object0 == serializable0) {
                    return serializable0;
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
        if(((f)object0) instanceof e) {
            com.iloen.melon.net.v6x.response.MusicWaveSongListRes.RESPONSE musicWaveSongListRes$RESPONSE0 = ((MusicWaveSongListRes)((e)(((f)object0))).a).getResponse();
            if(musicWaveSongListRes$RESPONSE0 != null) {
                List list0 = musicWaveSongListRes$RESPONSE0.getSongList();
                if(list0 != null) {
                    Serializable serializable1 = new ArrayList();
                    for(Object object1: list0) {
                        SongInfoBase songInfoBase0 = (SongInfoBase)object1;
                        Playable playable0 = q.b(CType.get(songInfoBase0.cType), CType.VOICE) ? null : Playable.from(songInfoBase0, this.getMenuId(), this.getStatsElements());
                        if(playable0 != null) {
                            ((ArrayList)serializable1).add(playable0);
                        }
                    }
                    return serializable1;
                }
            }
        }
        return je.w.a;
    }

    public final p8.f f() {
        ChannelInfoData channelInfoData0 = u1.d(this);
        String s = null;
        if(this.getTiaraProperty() == null) {
            return null;
        }
        p8.f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        s s1 = this.getTiaraProperty();
        f0.b = s1 == null ? null : s1.a;
        s s2 = this.getTiaraProperty();
        f0.c = s2 == null ? null : s2.b;
        s s3 = this.getTiaraProperty();
        f0.I = s3 == null ? null : s3.c;
        Builder meta$Builder0 = new Builder().id((channelInfoData0 == null ? null : channelInfoData0.e)).type(this.f.a(0x7F130E42));  // string:tiara_common_page_meta_type_music_wave "뮤직웨이브"
        if(channelInfoData0 != null) {
            s = channelInfoData0.b;
        }
        f0.c0 = meta$Builder0.name(s).build();
        return f0;
    }

    public final Object g(String s, String s1, c c0) {
        p1 p10;
        if(c0 instanceof p1) {
            p10 = (p1)c0;
            int v = p10.B;
            if((v & 0x80000000) == 0) {
                p10 = new p1(this, c0);
            }
            else {
                p10.B = v ^ 0x80000000;
            }
        }
        else {
            p10 = new p1(this, c0);
        }
        Object object0 = p10.r;
        a a0 = a.a;
        switch(p10.B) {
            case 0: {
                n.D(object0);
                p10.B = 1;
                object0 = this.a.c(s, s1, "1757130017", p10);
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
        if(((f)object0) instanceof e) {
            com.iloen.melon.net.v6x.response.MusicWaveStaticsRes.RESPONSE musicWaveStaticsRes$RESPONSE0 = ((MusicWaveStaticsRes)((e)(((f)object0))).a).getResponse();
            if(musicWaveStaticsRes$RESPONSE0 != null) {
                String s2 = musicWaveStaticsRes$RESPONSE0.getViewCount();
                return s2 == null ? "" : s2;
            }
        }
        return "";
    }

    public final Object h(String s, c c0) {
        t1 t10;
        if(c0 instanceof t1) {
            t10 = (t1)c0;
            int v = t10.B;
            if((v & 0x80000000) == 0) {
                t10 = new t1(this, c0);
            }
            else {
                t10.B = v ^ 0x80000000;
            }
        }
        else {
            t10 = new t1(this, c0);
        }
        Object object0 = t10.r;
        a a0 = a.a;
        switch(t10.B) {
            case 0: {
                n.D(object0);
                String s1 = this.h;
                String s2 = "";
                if(s1 == null) {
                    s1 = "";
                }
                String s3 = this.g;
                if(s3 != null) {
                    s2 = s3;
                }
                t10.B = 1;
                object0 = this.a.g(s1, s2, s, t10);
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
        if(((f)object0) instanceof e) {
            Response musicWaveHostMessageRes$Response0 = ((MusicWaveHostMessageRes)((e)(((f)object0))).a).getResponse();
            if(musicWaveHostMessageRes$Response0 != null && q.b(musicWaveHostMessageRes$Response0.getStatus(), "0")) {
                return H.a;
            }
            LogU.error$default(this.m, "Host message sent but response is null", null, false, 6, null);
            return H.a;
        }
        if(!(((f)object0) instanceof d)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        LogU.error$default(this.m, va.e.b("Failed to send host message: ", ((d)(((f)object0))).a.getMessage()), null, false, 6, null);
        return H.a;
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        K4 k40;
        String s;
        L0 l01;
        Throwable throwable1;
        Object object1;
        q1 q10;
        if(continuation0 instanceof q1) {
            q10 = (q1)continuation0;
            int v = q10.E;
            if((v & 0x80000000) == 0) {
                q10 = new q1(this, ((c)continuation0));
            }
            else {
                q10.E = v ^ 0x80000000;
            }
        }
        else {
            q10 = new q1(this, ((c)continuation0));
        }
        Object object0 = q10.B;
        a a0 = a.a;
        switch(q10.E) {
            case 0: {
                n.D(object0);
                L0 l00 = this.getProgressUpdater();
                if(l00 == null) {
                    Deferred deferred0 = u0.j(this, Dispatchers.getDefault(), new r1(this, null), 2);
                    q10.r = null;
                    q10.w = null;
                    q10.E = 1;
                    object0 = deferred0.await(q10);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_42;
                }
                else {
                    l00.a("MusicWaveChannelViewModel true", true);
                    try {
                        Deferred deferred1 = u0.j(this, Dispatchers.getDefault(), new r1(this, null), 2);
                        q10.r = l00;
                        q10.w = "MusicWaveChannelViewModel";
                        q10.E = 2;
                        object1 = deferred1.await(q10);
                    }
                    catch(Throwable throwable0) {
                        throwable1 = throwable0;
                        l01 = l00;
                        s = "MusicWaveChannelViewModel";
                        Y.v(s, " false", l01, false);
                        throw throwable1;
                    }
                    if(object1 == a0) {
                        return a0;
                    }
                    try {
                        l01 = l00;
                        s = "MusicWaveChannelViewModel";
                        k40 = this.handleDefaultHttpResponseResult(((f)object1), new i(this, 10));
                        goto label_50;
                    }
                    catch(Throwable throwable1) {
                        Y.v(s, " false", l01, false);
                        throw throwable1;
                    }
                }
                break;
            }
            case 1: {
                n.D(object0);
            label_42:
                K4 k41 = this.handleDefaultHttpResponseResult(((f)object0), new i(this, 10));
                if(k41 != null) {
                    this.updateUiState(new z1(k41, 7));
                    return H.a;
                }
                break;
            }
            case 2: {
                try {
                    s = q10.w;
                    l01 = q10.r;
                    n.D(object0);
                    k40 = this.handleDefaultHttpResponseResult(((f)object0), new i(this, 10));
                label_50:
                    if(k40 != null) {
                        this.updateUiState(new z1(k40, 7));
                    }
                }
                catch(Throwable throwable1) {
                    Y.v(s, " false", l01, false);
                    throw throwable1;
                }
                Y.v(s, " false", l01, false);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    @Override  // com.melon.ui.k1
    public final void onUserEvent(Pc.e e0) {
        q.g(e0, "userEvent");
        String s = null;
        StringProviderImpl stringProviderImpl0 = this.f;
        if(e0 instanceof jd.k1) {
            this.sendUiEvent(jd.b1.a);
            ChannelInfoData channelInfoData0 = u1.d(this);
            p8.f f0 = this.f();
            if(f0 == null) {
                return;
            }
            f0.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = stringProviderImpl0.a(0x7F130F7B);  // string:tiara_music_wave_channel_detail_click_layer1_gnb "GNB"
            f0.F = stringProviderImpl0.a(0x7F130F62);  // string:tiara_music_wave_channel_detail_click_copy_minimize "플레이어 최소화"
            Builder meta$Builder0 = new Builder().id((channelInfoData0 == null ? null : channelInfoData0.e)).type(stringProviderImpl0.a(0x7F130EFD));  // string:tiara_meta_type_music_wave "뮤직웨이브"
            if(channelInfoData0 != null) {
                s = channelInfoData0.b;
            }
            f0.b0 = meta$Builder0.name(s).build();
            f0.a().track();
            return;
        }
        if(e0 instanceof m1) {
            Navigator.INSTANCE.openMusicWaveSearch();
            p8.f f1 = this.f();
            if(f1 == null) {
                return;
            }
            f1.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f1.y = stringProviderImpl0.a(0x7F130F7B);  // string:tiara_music_wave_channel_detail_click_layer1_gnb "GNB"
            f1.F = stringProviderImpl0.a(0x7F130F6D);  // string:tiara_music_wave_channel_detail_click_copy_search "검색"
            f1.a().track();
            return;
        }
        if(e0 instanceof l1) {
            this.sendUiEvent(e1.a);
            ChannelInfoData channelInfoData1 = u1.d(this);
            p8.f f2 = this.f();
            if(f2 == null) {
                return;
            }
            f2.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f2.d = ActionKind.ClickContent;
            f2.y = stringProviderImpl0.a(0x7F130F7B);  // string:tiara_music_wave_channel_detail_click_layer1_gnb "GNB"
            f2.F = stringProviderImpl0.a(0x7F130F63);  // string:tiara_music_wave_channel_detail_click_copy_more "채널 더보기"
            Builder meta$Builder1 = new Builder().id((channelInfoData1 == null ? null : channelInfoData1.e)).type(stringProviderImpl0.a(0x7F130EFD));  // string:tiara_meta_type_music_wave "뮤직웨이브"
            if(channelInfoData1 != null) {
                s = channelInfoData1.b;
            }
            f2.b0 = meta$Builder1.name(s).build();
            f2.a().track();
            return;
        }
        if(e0 instanceof n1) {
            p8.f f3 = this.f();
            if(f3 != null) {
                ActionKind actionKind0 = ((n1)e0).a;
                if(actionKind0 != null) {
                    f3.d = actionKind0;
                }
                String s1 = ((n1)e0).b;
                if(s1 != null) {
                    f3.a = s1;
                }
                String s2 = ((n1)e0).c;
                if(s2 != null) {
                    f3.y = s2;
                }
                String s3 = ((n1)e0).d;
                if(s3 != null) {
                    f3.F = s3;
                }
                Meta meta0 = ((n1)e0).e;
                if(meta0 != null) {
                    f3.b0 = meta0;
                }
                f3.a().track();
            }
            return;
        }
        if(e0 instanceof L2) {
            if(((L2)e0) instanceof t2) {
                BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getMain(), null, new s1(this, null), 2, null);
                return;
            }
            if(((L2)e0) instanceof F2) {
                this.sendUiEvent(f1.a);
                return;
            }
            T2.a a0 = f0.h(this);
            boolean z = ((e0)o.a()).m();
            U1 u10 = new U1(1, this, u1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 19);
            L0 l00 = this.getProgressUpdater();
            this.b.b(((L2)e0), a0, z, u10, l00);
            return;
        }
        if(e0 instanceof N3) {
            T2.a a1 = f0.h(this);
            boolean z1 = ((e0)o.a()).m();
            U1 u11 = new U1(1, this, u1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 20);
            L0 l01 = this.getProgressUpdater();
            this.c.b(((N3)e0), a1, z1, u11, l01);
            return;
        }
        if(e0 instanceof q3) {
            T2.a a2 = f0.h(this);
            boolean z2 = ((e0)o.a()).m();
            U1 u12 = new U1(1, this, u1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 21);
            L0 l02 = this.getProgressUpdater();
            this.d.a(((q3)e0), a2, z2, u12, l02);
            return;
        }
        if(e0 instanceof com.melon.ui.q) {
            T2.a a3 = f0.h(this);
            U1 u13 = new U1(1, this, u1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 22);
            this.e.d(((com.melon.ui.q)e0), a3, u13);
            return;
        }
        super.onUserEvent(e0);
    }
}

