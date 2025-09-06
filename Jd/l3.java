package jd;

import Bd.m;
import Na.d;
import Na.e;
import android.util.Log;
import androidx.lifecycle.f0;
import com.iloen.melon.constants.CType;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v6x.response.MusicWaveSongListRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MusicWaveSongListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta.Builder;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.F4;
import com.melon.ui.L2;
import com.melon.ui.N3;
import com.melon.ui.Q;
import com.melon.ui.b3;
import com.melon.ui.g1;
import com.melon.ui.k1;
import com.melon.ui.m3;
import com.melon.ui.musicwave.ChannelInfoData;
import com.melon.ui.n4;
import com.melon.ui.q3;
import com.melon.ui.q4;
import com.melon.ui.t3;
import d5.n;
import e.k;
import gd.R7;
import hd.h0;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.w;
import kb.s;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted.Companion;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.c;
import p8.f;
import p8.g;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Ljd/l3;", "Lcom/melon/ui/k1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class l3 extends k1 {
    public final s2 a;
    public final s b;
    public final t3 c;
    public final b3 d;
    public final Q e;
    public final n4 f;
    public ChannelInfoData g;
    public List h;
    public final StateFlow i;
    public static final int j;

    public l3(s2 s20, s s0, t3 t30, b3 b30, Q q0, n4 n40) {
        q.g(s20, "playlistManager");
        super();
        this.a = s20;
        this.b = s0;
        this.c = t30;
        this.d = b30;
        this.e = q0;
        this.f = n40;
        this.h = w.a;
        this.i = FlowKt.stateIn(FlowKt.callbackFlow(new i3(this, null)), f0.h(this), Companion.WhileSubscribed$default(SharingStarted.Companion, 0L, 0L, 3, null), null);
    }

    public final ChannelInfoData c() {
        ChannelInfoData channelInfoData0 = this.g;
        if(channelInfoData0 != null) {
            return channelInfoData0;
        }
        q.m("chanelInfo");
        throw null;
    }

    public final f d() {
        String s = null;
        if(this.getTiaraProperty() == null) {
            return null;
        }
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        p8.s s1 = this.getTiaraProperty();
        f0.b = s1 == null ? null : s1.a;
        p8.s s2 = this.getTiaraProperty();
        f0.c = s2 == null ? null : s2.b;
        p8.s s3 = this.getTiaraProperty();
        if(s3 != null) {
            s = s3.c;
        }
        f0.I = s;
        f0.c0 = new Builder().id(this.c().e).type("").name(this.c().b).build();
        return f0;
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        List list0;
        j3 j30;
        if(continuation0 instanceof j3) {
            j30 = (j3)continuation0;
            int v = j30.B;
            if((v & 0x80000000) == 0) {
                j30 = new j3(this, ((c)continuation0));
            }
            else {
                j30.B = v ^ 0x80000000;
            }
        }
        else {
            j30 = new j3(this, ((c)continuation0));
        }
        Object object0 = j30.r;
        a a0 = a.a;
        switch(j30.B) {
            case 0: {
                n.D(object0);
                this.updateTiaraProperty("", "", "1000003041");
                String s = this.c().f;
                String s1 = "";
                if(s == null) {
                    s = "";
                }
                String s2 = this.c().a;
                if(s2 != null) {
                    s1 = s2;
                }
                j30.B = 1;
                object0 = this.b.j(s, s1, j30);
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
        if(((Na.f)object0) instanceof e) {
            RESPONSE musicWaveSongListRes$RESPONSE0 = ((MusicWaveSongListRes)((e)(((Na.f)object0))).a).getResponse();
            if(musicWaveSongListRes$RESPONSE0 == null) {
                list0 = w.a;
            }
            else {
                list0 = musicWaveSongListRes$RESPONSE0.getSongList();
                if(list0 == null) {
                    list0 = w.a;
                }
            }
            this.h = list0;
            Log.e("SongListPopupViewModel", "currentSongIndex: " + (musicWaveSongListRes$RESPONSE0 == null ? null : musicWaveSongListRes$RESPONSE0.getCurrentSongIndex()));
            if(!this.h.isEmpty()) {
                this.updateUiState(new R7(19, this, musicWaveSongListRes$RESPONSE0));
                return H.a;
            }
            this.updateUiState(new h0(21));
            this.sendUiEvent(new q4(12, "", "", null, new e3(this, 0)));
            return H.a;
        }
        if(!(((Na.f)object0) instanceof d)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        Log.e("SongListPopupViewModel", "fetch error: " + ((Na.f)object0));
        return H.a;
    }

    @Override  // com.melon.ui.k1
    public final void onUserEvent(Pc.e e0) {
        q.g(e0, "userEvent");
        if(e0 instanceof com.melon.ui.q) {
            T2.a a0 = f0.h(this);
            N2 n20 = new N2(1, this, l3.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 2);
            this.e.d(((com.melon.ui.q)e0), a0, n20);
            return;
        }
        if(e0 instanceof Z2) {
            this.sendUiEvent(W2.a);
            return;
        }
        if(e0 instanceof X2) {
            Iterable iterable0 = this.h;
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: iterable0) {
                CType cType0 = CType.get(((SongInfoBase)object0).cType);
                Playable playable0 = q.b(CType.VOICE, cType0) ? null : Playable.from(((SongInfoBase)object0), this.getMenuId(), this.getStatsElements());
                if(playable0 != null) {
                    arrayList0.add(playable0);
                }
            }
            this.sendUiEvent(new m3("1000003041", "", arrayList0));
            f f0 = this.d();
            if(f0 == null) {
                return;
            }
            f0.a = "";
            f0.y = "";
            f0.F = "";
            f0.b0 = new Builder().id(this.c().e).type("").name(this.c().b).build();
            f0.a().track();
            return;
        }
        if(e0 instanceof Y2) {
            SongInfoBase songInfoBase0 = ((Y2)e0).a;
            this.sendUiEvent(new m3("1000003041", "", k.z(Playable.from(songInfoBase0, this.getMenuId(), this.getStatsElements()))));
            f f1 = this.d();
            if(f1 == null) {
                return;
            }
            f1.a = "";
            f1.y = "";
            f1.F = "";
            f1.b0 = new Builder().id(songInfoBase0.songId).type("").name(songInfoBase0.songName).build();
            f1.a().track();
            return;
        }
        if(e0 instanceof d3) {
            Navigator.openAlbumInfo(((d3)e0).a.albumId);
            return;
        }
        if(e0 instanceof jd.b3) {
            SongInfoBase songInfoBase1 = ((jd.b3)e0).a;
            Playable playable1 = Playable.from(songInfoBase1, "1000003041", this.getStatsElements());
            q.f(playable1, "from(...)");
            this.sendUiEvent(new F4(playable1, "1000003041"));
            f f2 = this.d();
            if(f2 == null) {
                return;
            }
            f2.d = ActionKind.ClickContent;
            f2.a = "";
            f2.y = "";
            f2.F = "";
            f2.b0 = new Builder().id(songInfoBase1.songId).type("").name(songInfoBase1.songName).build();
            f2.a().track();
            return;
        }
        if(e0 instanceof a3) {
            Navigator.INSTANCE.openCreateMusicWaveChannel();
            return;
        }
        if(e0 instanceof c3) {
            SongInfoBase songInfoBase2 = ((c3)e0).b;
            this.updateUiState(new m(((c3)e0).a, 7));
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new f3(this, ((c3)e0).a, null), 2, null);
            f f3 = this.d();
            if(f3 != null) {
                f3.d = ActionKind.PlayMusic;
                f3.a = "";
                f3.y = "";
                f3.F = "";
                f3.b0 = new Builder().id(songInfoBase2.songId).type("").name(songInfoBase2.songName).build();
                f3.a().track();
            }
            return;
        }
        if(e0 instanceof q3) {
            T2.a a1 = f0.h(this);
            boolean z = ((e0)o.a()).m();
            N2 n21 = new N2(1, this, l3.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 3);
            L0 l00 = this.getProgressUpdater();
            this.c.a(((q3)e0), a1, z, n21, l00);
            return;
        }
        if(e0 instanceof L2) {
            T2.a a2 = f0.h(this);
            boolean z1 = ((e0)o.a()).m();
            N2 n22 = new N2(1, this, l3.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 4);
            L0 l01 = this.getProgressUpdater();
            this.d.b(((L2)e0), a2, z1, n22, l01);
            return;
        }
        if(e0 instanceof N3) {
            T2.a a3 = f0.h(this);
            boolean z2 = ((e0)o.a()).m();
            N2 n23 = new N2(1, this, l3.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 5);
            L0 l02 = this.getProgressUpdater();
            this.f.b(((N3)e0), a3, z2, n23, l02);
            return;
        }
        super.onUserEvent(e0);
    }
}

