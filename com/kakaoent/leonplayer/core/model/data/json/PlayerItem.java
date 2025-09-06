package com.kakaoent.leonplayer.core.model.data.json;

import A7.d;
import Vd.i;
import Vd.l;
import com.kakaoent.leonplayer.core.common.MoshiKt;
import com.kakaoent.leonplayer.core.common.MoshiParseException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0001>B\u009B\u0001\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001A\u00020\u0007\u0012\n\b\u0001\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\u0010\b\u0001\u0010\f\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\r\u0012\n\b\u0001\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\u000E\b\u0001\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\r\u0012\u000E\b\u0001\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00140\r\u0012\u000E\b\u0001\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00160\r\u0012\u0010\b\u0001\u0010\u0017\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\r\u00A2\u0006\u0002\u0010\u0019J\t\u0010,\u001A\u00020\u0003H\u00C6\u0003J\u000F\u0010-\u001A\b\u0012\u0004\u0012\u00020\u00160\rH\u00C6\u0003J\u0011\u0010.\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\rH\u00C6\u0003J\t\u0010/\u001A\u00020\u0005H\u00C6\u0003J\t\u00100\u001A\u00020\u0007H\u00C6\u0003J\u000B\u00101\u001A\u0004\u0018\u00010\tH\u00C6\u0003J\u000B\u00102\u001A\u0004\u0018\u00010\u000BH\u00C6\u0003J\u0011\u00103\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\rH\u00C6\u0003J\u000B\u00104\u001A\u0004\u0018\u00010\u0010H\u00C6\u0003J\u000F\u00105\u001A\b\u0012\u0004\u0012\u00020\u00120\rH\u00C6\u0003J\u000F\u00106\u001A\b\u0012\u0004\u0012\u00020\u00140\rH\u00C6\u0003J\u009F\u0001\u00107\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00052\b\b\u0003\u0010\u0006\u001A\u00020\u00072\n\b\u0003\u0010\b\u001A\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0010\b\u0003\u0010\f\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\r2\n\b\u0003\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u000E\b\u0003\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\r2\u000E\b\u0003\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00140\r2\u000E\b\u0003\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00160\r2\u0010\b\u0003\u0010\u0017\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\rH\u00C6\u0001J\u0013\u00108\u001A\u0002092\b\u0010:\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010;\u001A\u00020<H\u00D6\u0001J\t\u0010=\u001A\u00020\u0003H\u00D6\u0001R\u0017\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00160\r\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0013\u0010\n\u001A\u0004\u0018\u00010\u000B\u00A2\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u0011\u0010\u0006\u001A\u00020\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0017\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\r\u00A2\u0006\b\n\u0000\u001A\u0004\b$\u0010\u001BR\u0013\u0010\b\u001A\u0004\u0018\u00010\t\u00A2\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0019\u0010\u0017\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\r\u00A2\u0006\b\n\u0000\u001A\u0004\b\'\u0010\u001BR\u0019\u0010\f\u001A\n\u0012\u0004\u0012\u00020\u000E\u0018\u00010\r\u00A2\u0006\b\n\u0000\u001A\u0004\b(\u0010\u001BR\u0011\u0010\u0002\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b)\u0010*R\u0017\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00140\r\u00A2\u0006\b\n\u0000\u001A\u0004\b+\u0010\u001B\u00A8\u0006?"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/PlayerItem;", "", "title", "", "documentInfo", "Lcom/kakaoent/leonplayer/core/model/data/json/DocumentInfo;", "mediaProperties", "Lcom/kakaoent/leonplayer/core/model/data/json/MediaProperties;", "qoeInfo", "Lcom/kakaoent/leonplayer/core/model/data/json/QoeInfo;", "mediaMetadata", "Lcom/kakaoent/leonplayer/core/model/data/json/MediaMetadata;", "thumbnailInfo", "", "Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailInfo;", "drmInfo", "Lcom/kakaoent/leonplayer/core/model/data/json/DrmInfo;", "playbackUrls", "Lcom/kakaoent/leonplayer/core/model/data/json/PlaybackUrl;", "videoTracks", "Lcom/kakaoent/leonplayer/core/model/data/json/VideoTrack;", "audioTracks", "Lcom/kakaoent/leonplayer/core/model/data/json/AudioTrack;", "subtitleTracks", "Lcom/kakaoent/leonplayer/core/model/data/json/SubtitleTrack;", "(Ljava/lang/String;Lcom/kakaoent/leonplayer/core/model/data/json/DocumentInfo;Lcom/kakaoent/leonplayer/core/model/data/json/MediaProperties;Lcom/kakaoent/leonplayer/core/model/data/json/QoeInfo;Lcom/kakaoent/leonplayer/core/model/data/json/MediaMetadata;Ljava/util/List;Lcom/kakaoent/leonplayer/core/model/data/json/DrmInfo;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAudioTracks", "()Ljava/util/List;", "getDocumentInfo", "()Lcom/kakaoent/leonplayer/core/model/data/json/DocumentInfo;", "getDrmInfo", "()Lcom/kakaoent/leonplayer/core/model/data/json/DrmInfo;", "getMediaMetadata", "()Lcom/kakaoent/leonplayer/core/model/data/json/MediaMetadata;", "getMediaProperties", "()Lcom/kakaoent/leonplayer/core/model/data/json/MediaProperties;", "getPlaybackUrls", "getQoeInfo", "()Lcom/kakaoent/leonplayer/core/model/data/json/QoeInfo;", "getSubtitleTracks", "getThumbnailInfo", "getTitle", "()Ljava/lang/String;", "getVideoTracks", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PlayerItem {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/PlayerItem$Companion;", "", "()V", "parse", "Lcom/kakaoent/leonplayer/core/model/data/json/PlayerItem;", "jsonString", "", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final PlayerItem parse(@NotNull String s) {
            q.g(s, "jsonString");
            try {
                return (PlayerItem)MoshiKt.getMoshi().a(PlayerItem.class).fromJson(s);
            }
            catch(Exception exception0) {
                String s1 = exception0.getMessage();
                if(s1 == null) {
                    s1 = "Moshi parse exception";
                }
                throw new MoshiParseException(s1);
            }
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final List audioTracks;
    @NotNull
    private final DocumentInfo documentInfo;
    @Nullable
    private final DrmInfo drmInfo;
    @Nullable
    private final MediaMetadata mediaMetadata;
    @NotNull
    private final MediaProperties mediaProperties;
    @NotNull
    private final List playbackUrls;
    @Nullable
    private final QoeInfo qoeInfo;
    @Nullable
    private final List subtitleTracks;
    @Nullable
    private final List thumbnailInfo;
    @NotNull
    private final String title;
    @NotNull
    private final List videoTracks;

    static {
        PlayerItem.Companion = new Companion(null);
    }

    public PlayerItem(@i(name = "title") @NotNull String s, @i(name = "document_info") @NotNull DocumentInfo documentInfo0, @i(name = "media_properties") @NotNull MediaProperties mediaProperties0, @i(name = "qoe_info") @Nullable QoeInfo qoeInfo0, @i(name = "media_metadata") @Nullable MediaMetadata mediaMetadata0, @i(name = "thumbnail_info") @Nullable List list0, @i(name = "drm_info") @Nullable DrmInfo drmInfo0, @i(name = "playback_urls") @NotNull List list1, @i(name = "video_tracks") @NotNull List list2, @i(name = "audio_tracks") @NotNull List list3, @i(name = "subtitle_tracks") @Nullable List list4) {
        q.g(s, "title");
        q.g(documentInfo0, "documentInfo");
        q.g(mediaProperties0, "mediaProperties");
        q.g(list1, "playbackUrls");
        q.g(list2, "videoTracks");
        q.g(list3, "audioTracks");
        super();
        this.title = s;
        this.documentInfo = documentInfo0;
        this.mediaProperties = mediaProperties0;
        this.qoeInfo = qoeInfo0;
        this.mediaMetadata = mediaMetadata0;
        this.thumbnailInfo = list0;
        this.drmInfo = drmInfo0;
        this.playbackUrls = list1;
        this.videoTracks = list2;
        this.audioTracks = list3;
        this.subtitleTracks = list4;
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List component10() {
        return this.audioTracks;
    }

    @Nullable
    public final List component11() {
        return this.subtitleTracks;
    }

    @NotNull
    public final DocumentInfo component2() {
        return this.documentInfo;
    }

    @NotNull
    public final MediaProperties component3() {
        return this.mediaProperties;
    }

    @Nullable
    public final QoeInfo component4() {
        return this.qoeInfo;
    }

    @Nullable
    public final MediaMetadata component5() {
        return this.mediaMetadata;
    }

    @Nullable
    public final List component6() {
        return this.thumbnailInfo;
    }

    @Nullable
    public final DrmInfo component7() {
        return this.drmInfo;
    }

    @NotNull
    public final List component8() {
        return this.playbackUrls;
    }

    @NotNull
    public final List component9() {
        return this.videoTracks;
    }

    @NotNull
    public final PlayerItem copy(@i(name = "title") @NotNull String s, @i(name = "document_info") @NotNull DocumentInfo documentInfo0, @i(name = "media_properties") @NotNull MediaProperties mediaProperties0, @i(name = "qoe_info") @Nullable QoeInfo qoeInfo0, @i(name = "media_metadata") @Nullable MediaMetadata mediaMetadata0, @i(name = "thumbnail_info") @Nullable List list0, @i(name = "drm_info") @Nullable DrmInfo drmInfo0, @i(name = "playback_urls") @NotNull List list1, @i(name = "video_tracks") @NotNull List list2, @i(name = "audio_tracks") @NotNull List list3, @i(name = "subtitle_tracks") @Nullable List list4) {
        q.g(s, "title");
        q.g(documentInfo0, "documentInfo");
        q.g(mediaProperties0, "mediaProperties");
        q.g(list1, "playbackUrls");
        q.g(list2, "videoTracks");
        q.g(list3, "audioTracks");
        return new PlayerItem(s, documentInfo0, mediaProperties0, qoeInfo0, mediaMetadata0, list0, drmInfo0, list1, list2, list3, list4);
    }

    public static PlayerItem copy$default(PlayerItem playerItem0, String s, DocumentInfo documentInfo0, MediaProperties mediaProperties0, QoeInfo qoeInfo0, MediaMetadata mediaMetadata0, List list0, DrmInfo drmInfo0, List list1, List list2, List list3, List list4, int v, Object object0) {
        if((v & 1) != 0) {
            s = playerItem0.title;
        }
        if((v & 2) != 0) {
            documentInfo0 = playerItem0.documentInfo;
        }
        if((v & 4) != 0) {
            mediaProperties0 = playerItem0.mediaProperties;
        }
        if((v & 8) != 0) {
            qoeInfo0 = playerItem0.qoeInfo;
        }
        if((v & 16) != 0) {
            mediaMetadata0 = playerItem0.mediaMetadata;
        }
        if((v & 0x20) != 0) {
            list0 = playerItem0.thumbnailInfo;
        }
        if((v & 0x40) != 0) {
            drmInfo0 = playerItem0.drmInfo;
        }
        if((v & 0x80) != 0) {
            list1 = playerItem0.playbackUrls;
        }
        if((v & 0x100) != 0) {
            list2 = playerItem0.videoTracks;
        }
        if((v & 0x200) != 0) {
            list3 = playerItem0.audioTracks;
        }
        if((v & 0x400) != 0) {
            list4 = playerItem0.subtitleTracks;
        }
        return playerItem0.copy(s, documentInfo0, mediaProperties0, qoeInfo0, mediaMetadata0, list0, drmInfo0, list1, list2, list3, list4);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PlayerItem)) {
            return false;
        }
        if(!q.b(this.title, ((PlayerItem)object0).title)) {
            return false;
        }
        if(!q.b(this.documentInfo, ((PlayerItem)object0).documentInfo)) {
            return false;
        }
        if(!q.b(this.mediaProperties, ((PlayerItem)object0).mediaProperties)) {
            return false;
        }
        if(!q.b(this.qoeInfo, ((PlayerItem)object0).qoeInfo)) {
            return false;
        }
        if(!q.b(this.mediaMetadata, ((PlayerItem)object0).mediaMetadata)) {
            return false;
        }
        if(!q.b(this.thumbnailInfo, ((PlayerItem)object0).thumbnailInfo)) {
            return false;
        }
        if(!q.b(this.drmInfo, ((PlayerItem)object0).drmInfo)) {
            return false;
        }
        if(!q.b(this.playbackUrls, ((PlayerItem)object0).playbackUrls)) {
            return false;
        }
        if(!q.b(this.videoTracks, ((PlayerItem)object0).videoTracks)) {
            return false;
        }
        return q.b(this.audioTracks, ((PlayerItem)object0).audioTracks) ? q.b(this.subtitleTracks, ((PlayerItem)object0).subtitleTracks) : false;
    }

    @NotNull
    public final List getAudioTracks() {
        return this.audioTracks;
    }

    @NotNull
    public final DocumentInfo getDocumentInfo() {
        return this.documentInfo;
    }

    @Nullable
    public final DrmInfo getDrmInfo() {
        return this.drmInfo;
    }

    @Nullable
    public final MediaMetadata getMediaMetadata() {
        return this.mediaMetadata;
    }

    @NotNull
    public final MediaProperties getMediaProperties() {
        return this.mediaProperties;
    }

    @NotNull
    public final List getPlaybackUrls() {
        return this.playbackUrls;
    }

    @Nullable
    public final QoeInfo getQoeInfo() {
        return this.qoeInfo;
    }

    @Nullable
    public final List getSubtitleTracks() {
        return this.subtitleTracks;
    }

    @Nullable
    public final List getThumbnailInfo() {
        return this.thumbnailInfo;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final List getVideoTracks() {
        return this.videoTracks;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.d(d.d(d.d((((((this.mediaProperties.hashCode() + (this.documentInfo.hashCode() + this.title.hashCode() * 0x1F) * 0x1F) * 0x1F + (this.qoeInfo == null ? 0 : this.qoeInfo.hashCode())) * 0x1F + (this.mediaMetadata == null ? 0 : this.mediaMetadata.hashCode())) * 0x1F + (this.thumbnailInfo == null ? 0 : this.thumbnailInfo.hashCode())) * 0x1F + (this.drmInfo == null ? 0 : this.drmInfo.hashCode())) * 0x1F, 0x1F, this.playbackUrls), 0x1F, this.videoTracks), 0x1F, this.audioTracks);
        List list0 = this.subtitleTracks;
        if(list0 != null) {
            v = list0.hashCode();
        }
        return v1 + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "PlayerItem(title=" + this.title + ", documentInfo=" + this.documentInfo + ", mediaProperties=" + this.mediaProperties + ", qoeInfo=" + this.qoeInfo + ", mediaMetadata=" + this.mediaMetadata + ", thumbnailInfo=" + this.thumbnailInfo + ", drmInfo=" + this.drmInfo + ", playbackUrls=" + this.playbackUrls + ", videoTracks=" + this.videoTracks + ", audioTracks=" + this.audioTracks + ", subtitleTracks=" + this.subtitleTracks + ')';
    }
}

