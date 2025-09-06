package p8;

import E9.w;
import Ma.g;
import Ma.i;
import com.gaudiolab.sol.android.SolMusicOne.Feature;
import com.gaudiolab.sol.android.SolMusicOne.LoudnessType;
import com.gaudiolab.sol.android.SolMusicOne.SpatialUpmixGenre;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.analytics.MelonTiaraUserInfoRemoteDataSourceImpl;
import com.iloen.melon.api.data.local.ResponseCacheDatabase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ToastManager;
import com.kakao.sdk.auth.TokenManager;
import com.kakao.sdk.user.UserApiClient;
import d5.t;
import e.k;
import e1.F;
import ea.d;
import ie.H;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import k8.Y;
import k8.o;
import kotlin.jvm.internal.q;
import qd.U;
import we.a;
import y8.f;
import y8.l;

public final class e implements a {
    public final int a;

    public e(int v) {
        this.a = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        LoudnessType solMusicOne$LoudnessType1;
        switch(this.a) {
            case 0: {
                o o0 = (o)(((i)Y.f(MelonAppBase.Companion, i.class)));
                t.e(o0.a.a);
                return new K(new MelonTiaraUserInfoRemoteDataSourceImpl(o0.a.a), new d(((l2.i)o0.J.get())));
            }
            case 1: {
                return DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.of("GMT+09:00"));
            }
            case 2: {
                return "handlePlaybackUiEvent()";
            }
            case 3: {
                return "handlePlaybackUiEvent() Skip";
            }
            case 4: {
                return new U();
            }
            case 5: {
                return "dislike";
            }
            case 6: {
                return "like";
            }
            case 7: {
                return Y.i(ContsTypeCode.VIDEO, "code(...)");
            }
            case 8: {
                return Y.i(ContsTypeCode.DJ_MALRANG, "code(...)");
            }
            case 9: {
                return "1000003234";
            }
            case 10: {
                return "1000003236";
            }
            case 11: {
                return k.A(new PlaylistId[]{PlaylistId.MUSIC, PlaylistId.SMART, PlaylistId.DRAWER, PlaylistId.MIX_UP, PlaylistId.MUSIC_WAVE});
            }
            case 12: {
                return "1000003149";
            }
            case 13: {
                return "1000000543";
            }
            case 14: {
                return new U();
            }
            case 15: {
                return "1000000543";
            }
            case 16: {
                return "1000002908";
            }
            case 17: {
                return H.a;
            }
            case 18: {
                F f0 = ResponseCacheDatabase.a;
                ResponseCacheDatabase responseCacheDatabase0 = ResponseCacheDatabase.b;
                if(responseCacheDatabase0 == null) {
                    synchronized(f0) {
                        MelonAppBase.Companion.getClass();
                        responseCacheDatabase0 = (ResponseCacheDatabase)w.o(k8.t.a().getContext(), ResponseCacheDatabase.class, "response_cache_db").b();
                        ResponseCacheDatabase.b = responseCacheDatabase0;
                    }
                    return responseCacheDatabase0.b();
                }
                return responseCacheDatabase0.b();
            }
            case 19: {
                return new t8.a();  // 初始化器: Ljava/lang/Object;-><init>()V
            }
            case 20: {
                return UserApiClient.Companion.getInstance();
            }
            case 21: {
                return TokenManager.Companion.getInstance();
            }
            case 22: {
                return (mb.k)((o)(((g)Y.f(MelonAppBase.Companion, g.class)))).m.get();
            }
            case 23: {
                ToastManager.showShort(0x7F130688);  // string:miniplayer_playlist_empty "곡 목록이 없습니다."
                return H.a;
            }
            case 24: {
                return H.a;
            }
            case 25: {
                Navigator.openAlbumInfo("2319008");
                return H.a;
            }
            case 26: {
                Navigator.openAlbumInfo("2319008");
                return H.a;
            }
            case 27: {
                Navigator.openAlbumInfo("2319008");
                return H.a;
            }
            case 28: {
                Navigator.openAlbumInfo("2319008");
                return H.a;
            }
            default: {
                if(l.e() || l.b().c.upmixGenre == SpatialUpmixGenre.k3D) {
                    if(y8.a.a()) {
                        q.g(Feature.kSpatialUpmix, "features");
                        f.e(Feature.kSpatialUpmix);
                    }
                    else {
                        q.g(Feature.kSpatialUpmix, "features");
                        f.f(Feature.kSpatialUpmix);
                    }
                }
                int v = MelonSettingInfo.getAudioLoudnessType();
                LoudnessType solMusicOne$LoudnessType0 = LoudnessType.kOff;
                if(v != solMusicOne$LoudnessType0.ordinal()) {
                    if(y8.a.a()) {
                        solMusicOne$LoudnessType1 = LoudnessType.kLSC_Transparent;
                    }
                    else {
                        int v1 = MelonSettingInfo.getAudioLoudnessType();
                        if(v1 != solMusicOne$LoudnessType0.ordinal()) {
                            solMusicOne$LoudnessType0 = LoudnessType.kLSC_QualitySecure;
                            if(v1 != solMusicOne$LoudnessType0.ordinal()) {
                                LoudnessType solMusicOne$LoudnessType2 = LoudnessType.kLSC_Transparent;
                                if(v1 == solMusicOne$LoudnessType2.ordinal()) {
                                    solMusicOne$LoudnessType0 = solMusicOne$LoudnessType2;
                                }
                            }
                        }
                        solMusicOne$LoudnessType1 = solMusicOne$LoudnessType0;
                    }
                    f.g(solMusicOne$LoudnessType1);
                    f.b().c.targetLoudness = MelonSettingInfo.getAudioTargetLoudness();
                    f.b().d.compareAndSet(false, true);
                }
                y8.a.b("onPreConditionCheck() ");
                return H.a;
            }
        }
    }
}

