package ec;

import ac.n;
import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.VolumeUtils;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta.Builder;
import com.kakao.tiara.data.Meta;
import java.util.HashMap;
import kotlin.jvm.internal.q;

public abstract class a {
    public static final LogU a;

    static {
        a.a = Companion.create$default(LogU.Companion, "ContentsAnalyticsHelper", false, null, 6, null);
    }

    public static void a(Context context0, Playable playable0, boolean z, n n0) {
        int v1;
        String s1;
        int v;
        StatsElementsBase statsElementsBase0 = StatsElementsBase.toStatsElementsBase("");
        boolean z1 = statsElementsBase0 != null && TextUtils.equals(statsElementsBase0.parentContsType, "N10082");
        boolean z2 = playable0.isTypeOfSong();
        boolean z3 = playable0.isTypeOfEdu();
        if(playable0.hasCid() && (z1 || z2 || z3)) {
            if(z1) {
                v = 0x7F130CC5;  // string:tiara_1seclog_name_station "스테이션 재생로그"
            }
            else {
                v = z3 ? 0x7F130CC3 : 0x7F130CC4;  // string:tiara_1seclog_name_edu "어학 재생로그"
            }
            String s = context0.getString(v);
            q.f(s, "getString(...)");
            ActionKind actionKind0 = z3 ? ActionKind.PlayAudio : ActionKind.PlayMusic;
            q.f("재생로그", "getString(...)");
            if(z1) {
                q.d(statsElementsBase0);
                s1 = statsElementsBase0.parentContsId;
            }
            else {
                s1 = "";
            }
            q.f("", "getSongName(...)");
            if(z1) {
                v1 = 0x7F130F03;  // string:tiara_meta_type_station "스테이션"
            }
            else {
                v1 = z3 ? 0x7F130EF7 : 0x7F130F01;  // string:tiara_meta_type_edu "어학"
            }
            String s2 = context0.getString(v1);
            q.f(s2, "getString(...)");
            q.f("", (z3 ? "getAlbum(...)" : "getArtistNames(...)"));
            HashMap hashMap0 = p8.q.b();
            hashMap0.put("menuid", "");
            hashMap0.put("orgmenuid", "");
            if(z) {
                hashMap0.put("content_type", "말랑이 믹스업");
                hashMap0.put("volume", String.valueOf(com.iloen.melon.utils.system.VolumeUtils.Companion.getVolume$default(VolumeUtils.Companion, context0, "ContentsAnalyticsHelper", null, 4, null)));
                hashMap0.put("recmd_key", n0.a);
                hashMap0.put("focus_song_ordnum", n0.b);
                hashMap0.put("recmd_offer_timestamp", n0.c);
            }
            Meta meta0 = new Builder().id(s1).type(s2).name("").author("").build();
            q.f(meta0, "build(...)");
            p8.q.c().trackEvent(s).actionKind(actionKind0).page("재생로그").eventMeta(meta0).customProps(hashMap0).adTrackId("2875552754074864296").track();
        }
    }
}

