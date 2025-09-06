package com.melon.ui;

import A8.M;
import Ac.Z1;
import Bb.b;
import com.iloen.melon.custom.L0;
import com.iloen.melon.fragments.detail.DetailLikePersonListFragment;
import com.iloen.melon.fragments.melonchart.StreamingCardFragment;
import com.iloen.melon.fragments.settings.SettingSongFragment;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.NameValuePairList;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.player.SongMetaParser;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.interfaces.StringProviderImpl;
import d9.j;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import jd.d1;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import ob.z;
import oe.i;
import pc.l1;
import qb.I;
import we.k;

public final class b3 {
    public final I a;
    public final z b;
    public final StringProviderImpl c;

    public b3(I i0, z z0, StringProviderImpl stringProviderImpl0) {
        this.a = i0;
        this.b = z0;
        this.c = stringProviderImpl0;
    }

    public static final Object a(b3 b30, Flow flow0, k k0, CoroutineScope coroutineScope0, i i0) {
        b30.getClass();
        Object object0 = flow0.collect(new a3(k0, b30, coroutineScope0), i0);
        return object0 == a.a ? object0 : H.a;
    }

    public final void b(L2 l20, T2.a a0, boolean z, k k0, L0 l00) {
        q.g(l20, "event");
        q.g(l00, "progressUpdatable");
        s4 s40 = s4.a;
        if(l20 instanceof s2) {
            if(!z) {
                k0.invoke(s40);
                return;
            }
            List list0 = e.k.z(((s2)l20).a);
            NameValuePairList nameValuePairList0 = b.b(b.a, "", list0);
            Navigator.openUrl("", M.v, OpenType.FullScreen, nameValuePairList0);
            return;
        }
        if(l20 instanceof t2) {
            BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getIO(), null, new O2(l20, z, k0, l00, this, a0, null), 2, null);
            return;
        }
        if(!(l20 instanceof F2)) {
            if(l20 instanceof C2) {
                BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getIO(), null, new P2(a0, l20, this, null, k0), 2, null);
                return;
            }
            if(l20 instanceof n2) {
                BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getIO(), null, new Q2(a0, l20, this, null, k0), 2, null);
                return;
            }
            if(l20 instanceof o2) {
                BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getIO(), null, new S2(a0, l20, this, null, k0), 2, null);
                return;
            }
            if(l20 instanceof H2) {
                Navigator.openSongInfo(((H2)l20).a);
                return;
            }
            StringProviderImpl stringProviderImpl0 = this.c;
            if(l20 instanceof v2) {
                if(!z) {
                    k0.invoke(s40);
                    return;
                }
                String s = ((v2)l20).b;
                String s1 = ((v2)l20).a;
                if(s1 == null || s1.length() == 0 || s == null || s.length() == 0) {
                    return;
                }
                String s2 = ((v2)l20).c;
                if(s2 == null || s2.length() == 0) {
                    return;
                }
                k0.invoke(new r4(stringProviderImpl0.a(0x7F1304C5), String.format(stringProviderImpl0.a(0x7F1304C4), Arrays.copyOf(new Object[]{s}, 1)), null, new N2(a0, this, l20, k0, 0), null, null, 108));  // string:kakao_profile_music_set_title "카카오톡 프로필뮤직 설정"
                return;
            }
            if(l20 instanceof G2) {
                Navigator.openSimilarSongList(((G2)l20).a, "N10001");
                return;
            }
            if(l20 instanceof w2) {
                Navigator.open(DetailLikePersonListFragment.newInstance(((w2)l20).b, "N20001", ((w2)l20).a));
                return;
            }
            if(l20 instanceof K2) {
                MelonLinkExecutor.open(((K2)l20).a, ((K2)l20).b);
                return;
            }
            if(l20 instanceof J2) {
                Navigator.open(StreamingCardFragment.Companion.newInstance(((J2)l20).a));
                return;
            }
            if(l20 instanceof y2) {
                l1 l10 = new l1(((y2)l20).a, ((y2)l20).b, ((y2)l20).c, null);
                k0.invoke(new x4(((y2)l20).d, l10, false));
                return;
            }
            if(l20 instanceof p2) {
                boolean z1 = "Y".equals(((p2)l20).b);
                Navigator.openUserMain(((p2)l20).a, z1);
                return;
            }
            if(l20 instanceof q2) {
                k0.invoke(new r4(stringProviderImpl0.a(0x7F1300D0), stringProviderImpl0.a(0x7F13008D), null, new N2(a0, this, l20, k0, 1), null, null, 108));  // string:alert_dlg_title_info "안내"
                return;
            }
            if(l20 instanceof r2) {
                Navigator.openDjPlaylistDetail(((r2)l20).a);
                return;
            }
            if(l20 instanceof u2) {
                Navigator.openDjPlaylistEdit(((u2)l20).a, null);
                return;
            }
            if(l20 instanceof x2) {
                if(!z) {
                    k0.invoke(s40);
                }
                Playable playable0 = ((x2)l20).a;
                File file0 = SongMetaParser.getLyricFile(playable0);
                if(file0 != null && file0.exists()) {
                    ToastManager.show(stringProviderImpl0.a(0x7F130508));  // string:localplaylist_download_lyric_already "이미 다운로드한 가사가 있습니다."
                    return;
                }
                q.g(playable0, "playable");
                j.a().f(playable0, true);
                return;
            }
            if(l20 instanceof D2) {
                Navigator.INSTANCE.openPlaylistDetail(((D2)l20).a);
                return;
            }
            if(l20 instanceof z2) {
                k0.invoke(new r4("", stringProviderImpl0.a(0x7F130728), null, new Z1(a0, this, k0), null, null, 108));  // string:music_wave_delete_my_channel_alert_message "내 채널을 삭제 하시겠습니까?\n선곡표와 채널에 남아있는 
                                                                                                                        // 채팅이 모두 삭제됩니다."
                return;
            }
            if(l20 instanceof A2) {
                Navigator.INSTANCE.openCreateMusicWaveChannel();
                return;
            }
            if(l20 instanceof B2) {
                k0.invoke(d1.a);
                return;
            }
            if(l20 instanceof E2) {
                Navigator.INSTANCE.openStationProgram(((E2)l20).a);
                return;
            }
            if(!(l20 instanceof I2)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            Playable playable1 = ((I2)l20).a;
            if(playable1 != null && !playable1.isOriginLocal() && !playable1.isTypeOfVoice()) {
                SettingSongFragment.newInstance().open();
            }
        }
    }
}

