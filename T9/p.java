package t9;

import android.content.Context;
import android.net.Uri;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableAlbum;
import com.iloen.melon.sns.model.SharableArtist;
import com.iloen.melon.sns.model.SharableDJCollection;
import com.iloen.melon.sns.model.SharableHighlight;
import com.iloen.melon.sns.model.SharableMemorialCard;
import com.iloen.melon.sns.model.SharablePlaylist;
import com.iloen.melon.sns.model.SharableSong;
import com.iloen.melon.sns.model.SharableStreamingCard;
import com.iloen.melon.sns.model.SharableTemperatureCard;
import com.iloen.melon.sns.target.SnsManager.PostParam;
import com.iloen.melon.sns.target.SnsPostListener;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.ToastManager;
import k8.t;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

public final class p implements SnsTarget {
    @Override  // com.iloen.melon.sns.target.SnsTarget
    public final void a(SnsManager.PostParam snsManager$PostParam0, SnsPostListener snsPostListener0) {
        int v;
        Sharable sharable0 = snsManager$PostParam0.c;
        if(sharable0 == null) {
            LogU.Companion.w("FacebookStory", "sendPostingLink() - Sharable object is null");
            if(snsPostListener0 != null) {
                snsPostListener0.onError("facebook", null, null);
            }
            return;
        }
        try {
            if(sharable0 instanceof SharableSong || sharable0 instanceof Playable) {
                v = 0;
            }
            else if(sharable0 instanceof SharableAlbum) {
                v = 1;
            }
            else if(sharable0 instanceof SharableArtist) {
                v = 3;
            }
            else if(sharable0 instanceof SharablePlaylist || sharable0 instanceof SharableDJCollection) {
                v = 2;
            }
            else if(sharable0 instanceof SharableStreamingCard) {
                v = 4;
            }
            else if(sharable0 instanceof SharableTemperatureCard) {
                v = 5;
            }
            else if(sharable0 instanceof SharableMemorialCard) {
                v = 6;
            }
            else {
                if(!(sharable0 instanceof SharableHighlight)) {
                    throw new IllegalArgumentException("Unknown share type");
                }
                v = 7;
            }
            String s = p.d(sharable0);
            String s1 = p.c(sharable0);
            String s2 = sharable0.getShareImageUrl(this);
            q.f(s2, "getShareImageUrl(...)");
            if(sharable0 instanceof SharableStreamingCard) {
                o o0 = new o(v, s, s1);
                MelonAppBase.Companion.getClass();
                Context context0 = t.a().getContext();
                int v1 = ((SharableStreamingCard)sharable0).h;
                String s3 = ((SharableStreamingCard)sharable0).g;
                if(s3 == null) {
                    s3 = "";
                }
                q.g(context0, "context");
                if(AppUtils.checkExistApplication(context0, "com.facebook.katana")) {
                    Uri uri0 = Uri.parse(s3);
                    q.f(uri0, "parse(...)");
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new n(context0, uri0, o0, v1, null), 3, null);
                }
                else {
                    ToastManager.show(0x7F13106A);  // string:toast_message_facebook_need_install "페이스북이 설치되어 있지 않습니다."
                }
            }
            else {
                o o1 = new o(v, s, s1);
                MelonAppBase.Companion.getClass();
                Context context1 = t.a().getContext();
                q.g(context1, "context");
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new k(context1, s2, o1, null), 3, null);
            }
            pc.t.E(this, sharable0);
        }
        catch(Exception exception0) {
            LogU.Companion.w("FacebookStory", "sendPostingLink() - " + exception0);
            ToastManager.show(0x7F13106B);  // string:toast_message_facebook_send_fail "페이스북 공유에 실패하였습니다."
        }
    }

    @Override  // com.iloen.melon.sns.target.SnsTarget
    public final boolean b() {
        return true;
    }

    public static String c(Sharable sharable0) {
        if(sharable0 instanceof SharableSong) {
            String s = ((SharableSong)sharable0).g;
            q.f(s, "getArtist(...)");
            return s;
        }
        if(sharable0 instanceof SharableAlbum) {
            String s1 = ((SharableAlbum)sharable0).g;
            q.f(s1, "getArtistName(...)");
            return s1;
        }
        if(sharable0 instanceof SharableArtist) {
            return Z.m(MelonAppBase.Companion, 0x7F130A45, "getString(...)");  // string:sns_share_artist "아티스트"
        }
        if(!(sharable0 instanceof SharablePlaylist) && !(sharable0 instanceof SharableDJCollection)) {
            if(sharable0 instanceof Playable) {
                String s2 = ((Playable)sharable0).getArtistNames();
                q.f(s2, "getArtistNames(...)");
                return s2;
            }
            return "";
        }
        return Z.m(MelonAppBase.Companion, 0x7F130A4E, "getString(...)");  // string:sns_share_playlist "플레이리스트"
    }

    public static String d(Sharable sharable0) {
        if(sharable0 instanceof SharableSong) {
            String s = ((SharableSong)sharable0).b;
            q.f(s, "getSongName(...)");
            return s;
        }
        if(sharable0 instanceof SharableAlbum) {
            String s1 = ((SharableAlbum)sharable0).d;
            q.f(s1, "getAlbumName(...)");
            return s1;
        }
        if(sharable0 instanceof SharableArtist) {
            String s2 = ((SharableArtist)sharable0).b;
            q.f(s2, "getArtistName(...)");
            return s2;
        }
        if(sharable0 instanceof SharablePlaylist) {
            q.f(((SharablePlaylist)sharable0).f, "getPlaylistName(...)");
            return ((SharablePlaylist)sharable0).f;
        }
        if(sharable0 instanceof SharableDJCollection) {
            String s3 = ((SharableDJCollection)sharable0).b;
            q.f(s3, "getPlaylistName(...)");
            return s3;
        }
        if(sharable0 instanceof Playable) {
            String s4 = ((Playable)sharable0).getSongName();
            q.f(s4, "getSongName(...)");
            return s4;
        }
        return "";
    }

    @Override  // com.iloen.melon.sns.target.SnsTarget
    public final String getId() {
        return "facebook";
    }
}

