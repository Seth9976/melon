package com.iloen.melon.utils.player;

import A9.f;
import android.net.Uri;
import com.google.gson.n;
import com.iloen.melon.video.TimedMeta;
import com.kakaoent.leonplayer.core.model.data.configuration.LeonConfiguration;
import com.kakaoent.leonplayer.core.model.data.configuration.LeonPlayerItem.Companion;
import com.kakaoent.leonplayer.core.model.data.configuration.LeonPlayerItem;
import com.kakaoent.leonplayer.core.model.data.json.Media;
import com.kakaoent.leonplayer.core.model.data.json.PlaybackUrl;
import com.kakaoent.leonplayer.core.model.data.json.PlayerItem;
import com.kakaoent.leonplayer.core.model.data.player.LeonTimedMeta;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0011\u0010\u0002\u001A\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001A\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/net/Uri;", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonConfiguration;", "toConfiguration", "(Landroid/net/Uri;)Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonConfiguration;", "Lcom/kakaoent/leonplayer/core/model/data/player/LeonTimedMeta;", "Lcom/iloen/melon/video/TimedMeta;", "toTimedMeta", "(Lcom/kakaoent/leonplayer/core/model/data/player/LeonTimedMeta;)Lcom/iloen/melon/video/TimedMeta;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class LeonPlayerHelperKt {
    public static final Media a(PlaybackUrl playbackUrl0) {
        Object object0 = null;
        for(Object object1: playbackUrl0.getMedia()) {
            if(((Media)object1).getSelectionTags().contains("cast-chromecast")) {
                object0 = object1;
                break;
            }
        }
        if(((Media)object0) == null) {
            for(Object object2: playbackUrl0.getMedia()) {
                if(((Media)object2).getSelectionTags().contains("safe-default")) {
                    return (Media)object2;
                }
                if(false) {
                    break;
                }
            }
            return null;
        }
        return (Media)object0;
    }

    public static final Media access$findChromecastMedia(PlayerItem playerItem0) {
        for(Object object0: playerItem0.getPlaybackUrls()) {
            Iterable iterable0 = ((PlaybackUrl)object0).getMedia();
            if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
                continue;
            }
            Iterator iterator1 = iterable0.iterator();
        label_6:
            if(!iterator1.hasNext()) {
                continue;
            }
            Object object1 = iterator1.next();
            if(!((Media)object1).getSelectionTags().contains("cast-chromecast")) {
                goto label_6;
            }
            goto label_11;
        }
        object0 = null;
    label_11:
        PlaybackUrl playbackUrl0 = (PlaybackUrl)object0;
        if(playbackUrl0 == null) {
            Object object2 = null;
            for(Object object3: playerItem0.getPlaybackUrls()) {
                if(LeonPlayerHelperKt.a(((PlaybackUrl)object3)) != null) {
                    object2 = object3;
                    break;
                }
            }
            playbackUrl0 = (PlaybackUrl)object2;
        }
        return playbackUrl0 == null ? null : LeonPlayerHelperKt.a(playbackUrl0);
    }

    public static final PlayerItem access$toPlayerItem(String s) {
        return PlayerItem.Companion.parse(s);
    }

    @NotNull
    public static final LeonConfiguration toConfiguration(@NotNull Uri uri0) {
        q.g(uri0, "<this>");
        String s = uri0.toString();
        q.f(s, "toString(...)");
        LeonPlayerItem leonPlayerItem0 = Companion.of$default(LeonPlayerItem.Companion, null, s, 0, null, null, null, 61, null);
        return LeonConfiguration.Companion.of(leonPlayerItem0);
    }

    @Nullable
    public static final TimedMeta toTimedMeta(@NotNull LeonTimedMeta leonTimedMeta0) {
        q.g(leonTimedMeta0, "<this>");
        String s = leonTimedMeta0.getData();
        q.g(s, "data");
        return (TimedMeta)((n)f.b.getValue()).e(s, TimedMeta.class);
    }
}

