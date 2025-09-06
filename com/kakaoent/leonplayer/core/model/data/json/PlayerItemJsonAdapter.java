package com.kakaoent.leonplayer.core.model.data.json;

import Vd.D;
import Vd.I;
import Vd.k;
import Vd.n;
import Vd.p;
import Vd.v;
import Wd.f;
import java.lang.reflect.Type;
import java.util.List;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0002H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001A\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00190\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001A\u0010\u0018R\u001A\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u001B0\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001C\u0010\u0018R\u001C\u0010\u001E\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001D0\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001E\u0010\u0018R\u001C\u0010 \u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001F0\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b \u0010\u0018R\"\u0010#\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\"\u0018\u00010!0\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b#\u0010\u0018R\u001C\u0010%\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b%\u0010\u0018R \u0010\'\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0!0\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\'\u0010\u0018R \u0010)\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0!0\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b)\u0010\u0018R \u0010+\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0!0\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b+\u0010\u0018R\"\u0010-\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010!0\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b-\u0010\u0018\u00A8\u0006."}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/PlayerItemJsonAdapter;", "LVd/k;", "Lcom/kakaoent/leonplayer/core/model/data/json/PlayerItem;", "LVd/D;", "moshi", "<init>", "(LVd/D;)V", "", "toString", "()Ljava/lang/String;", "LVd/p;", "reader", "fromJson", "(LVd/p;)Lcom/kakaoent/leonplayer/core/model/data/json/PlayerItem;", "LVd/v;", "writer", "value_", "Lie/H;", "toJson", "(LVd/v;Lcom/kakaoent/leonplayer/core/model/data/json/PlayerItem;)V", "LVd/n;", "options", "LVd/n;", "stringAdapter", "LVd/k;", "Lcom/kakaoent/leonplayer/core/model/data/json/DocumentInfo;", "documentInfoAdapter", "Lcom/kakaoent/leonplayer/core/model/data/json/MediaProperties;", "mediaPropertiesAdapter", "Lcom/kakaoent/leonplayer/core/model/data/json/QoeInfo;", "nullableQoeInfoAdapter", "Lcom/kakaoent/leonplayer/core/model/data/json/MediaMetadata;", "nullableMediaMetadataAdapter", "", "Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailInfo;", "nullableListOfThumbnailInfoAdapter", "Lcom/kakaoent/leonplayer/core/model/data/json/DrmInfo;", "nullableDrmInfoAdapter", "Lcom/kakaoent/leonplayer/core/model/data/json/PlaybackUrl;", "listOfPlaybackUrlAdapter", "Lcom/kakaoent/leonplayer/core/model/data/json/VideoTrack;", "listOfVideoTrackAdapter", "Lcom/kakaoent/leonplayer/core/model/data/json/AudioTrack;", "listOfAudioTrackAdapter", "Lcom/kakaoent/leonplayer/core/model/data/json/SubtitleTrack;", "nullableListOfSubtitleTrackAdapter", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PlayerItemJsonAdapter extends k {
    @NotNull
    private final k documentInfoAdapter;
    @NotNull
    private final k listOfAudioTrackAdapter;
    @NotNull
    private final k listOfPlaybackUrlAdapter;
    @NotNull
    private final k listOfVideoTrackAdapter;
    @NotNull
    private final k mediaPropertiesAdapter;
    @NotNull
    private final k nullableDrmInfoAdapter;
    @NotNull
    private final k nullableListOfSubtitleTrackAdapter;
    @NotNull
    private final k nullableListOfThumbnailInfoAdapter;
    @NotNull
    private final k nullableMediaMetadataAdapter;
    @NotNull
    private final k nullableQoeInfoAdapter;
    @NotNull
    private final n options;
    @NotNull
    private final k stringAdapter;

    public PlayerItemJsonAdapter(@NotNull D d0) {
        q.g(d0, "moshi");
        super();
        this.options = n.a(new String[]{"title", "document_info", "media_properties", "qoe_info", "media_metadata", "thumbnail_info", "drm_info", "playback_urls", "video_tracks", "audio_tracks", "subtitle_tracks"});
        this.stringAdapter = d0.b(String.class, y.a, "title");
        this.documentInfoAdapter = d0.b(DocumentInfo.class, y.a, "documentInfo");
        this.mediaPropertiesAdapter = d0.b(MediaProperties.class, y.a, "mediaProperties");
        this.nullableQoeInfoAdapter = d0.b(QoeInfo.class, y.a, "qoeInfo");
        this.nullableMediaMetadataAdapter = d0.b(MediaMetadata.class, y.a, "mediaMetadata");
        this.nullableListOfThumbnailInfoAdapter = d0.b(I.f(new Type[]{ThumbnailInfo.class}), y.a, "thumbnailInfo");
        this.nullableDrmInfoAdapter = d0.b(DrmInfo.class, y.a, "drmInfo");
        this.listOfPlaybackUrlAdapter = d0.b(I.f(new Type[]{PlaybackUrl.class}), y.a, "playbackUrls");
        this.listOfVideoTrackAdapter = d0.b(I.f(new Type[]{VideoTrack.class}), y.a, "videoTracks");
        this.listOfAudioTrackAdapter = d0.b(I.f(new Type[]{AudioTrack.class}), y.a, "audioTracks");
        this.nullableListOfSubtitleTrackAdapter = d0.b(I.f(new Type[]{SubtitleTrack.class}), y.a, "subtitleTracks");
    }

    @NotNull
    public PlayerItem fromJson(@NotNull p p0) {
        q.g(p0, "reader");
        p0.m();
        String s = null;
        DocumentInfo documentInfo0 = null;
        MediaProperties mediaProperties0 = null;
        QoeInfo qoeInfo0 = null;
        MediaMetadata mediaMetadata0 = null;
        List list0 = null;
        DrmInfo drmInfo0 = null;
        List list1 = null;
        List list2 = null;
        List list3 = null;
        List list4 = null;
        while(p0.r()) {
            switch(p0.M(this.options)) {
                case -1: {
                    p0.P();
                    p0.Q();
                    break;
                }
                case 0: {
                    s = (String)this.stringAdapter.fromJson(p0);
                    if(s == null) {
                        throw f.j("title", "title", p0);
                    }
                    continue;
                }
                case 1: {
                    documentInfo0 = (DocumentInfo)this.documentInfoAdapter.fromJson(p0);
                    if(documentInfo0 == null) {
                        throw f.j("documentInfo", "document_info", p0);
                    }
                    continue;
                }
                case 2: {
                    mediaProperties0 = (MediaProperties)this.mediaPropertiesAdapter.fromJson(p0);
                    if(mediaProperties0 == null) {
                        throw f.j("mediaProperties", "media_properties", p0);
                    }
                    continue;
                }
                case 3: {
                    qoeInfo0 = (QoeInfo)this.nullableQoeInfoAdapter.fromJson(p0);
                    break;
                }
                case 4: {
                    mediaMetadata0 = (MediaMetadata)this.nullableMediaMetadataAdapter.fromJson(p0);
                    break;
                }
                case 5: {
                    list0 = (List)this.nullableListOfThumbnailInfoAdapter.fromJson(p0);
                    break;
                }
                case 6: {
                    drmInfo0 = (DrmInfo)this.nullableDrmInfoAdapter.fromJson(p0);
                    break;
                }
                case 7: {
                    list1 = (List)this.listOfPlaybackUrlAdapter.fromJson(p0);
                    if(list1 == null) {
                        throw f.j("playbackUrls", "playback_urls", p0);
                    }
                    continue;
                }
                case 8: {
                    list2 = (List)this.listOfVideoTrackAdapter.fromJson(p0);
                    if(list2 == null) {
                        throw f.j("videoTracks", "video_tracks", p0);
                    }
                    continue;
                }
                case 9: {
                    list3 = (List)this.listOfAudioTrackAdapter.fromJson(p0);
                    if(list3 == null) {
                        throw f.j("audioTracks", "audio_tracks", p0);
                    }
                    continue;
                }
                case 10: {
                    list4 = (List)this.nullableListOfSubtitleTrackAdapter.fromJson(p0);
                }
            }
        }
        p0.p();
        if(s == null) {
            throw f.e("title", "title", p0);
        }
        if(documentInfo0 == null) {
            throw f.e("documentInfo", "document_info", p0);
        }
        if(mediaProperties0 == null) {
            throw f.e("mediaProperties", "media_properties", p0);
        }
        if(list1 == null) {
            throw f.e("playbackUrls", "playback_urls", p0);
        }
        if(list2 == null) {
            throw f.e("videoTracks", "video_tracks", p0);
        }
        if(list3 == null) {
            throw f.e("audioTracks", "audio_tracks", p0);
        }
        return new PlayerItem(s, documentInfo0, mediaProperties0, qoeInfo0, mediaMetadata0, list0, drmInfo0, list1, list2, list3, list4);
    }

    @Override  // Vd.k
    public Object fromJson(p p0) {
        return this.fromJson(p0);
    }

    public void toJson(@NotNull v v0, @Nullable PlayerItem playerItem0) {
        q.g(v0, "writer");
        if(playerItem0 == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        v0.m();
        v0.s("title");
        this.stringAdapter.toJson(v0, playerItem0.getTitle());
        v0.s("document_info");
        this.documentInfoAdapter.toJson(v0, playerItem0.getDocumentInfo());
        v0.s("media_properties");
        this.mediaPropertiesAdapter.toJson(v0, playerItem0.getMediaProperties());
        v0.s("qoe_info");
        this.nullableQoeInfoAdapter.toJson(v0, playerItem0.getQoeInfo());
        v0.s("media_metadata");
        this.nullableMediaMetadataAdapter.toJson(v0, playerItem0.getMediaMetadata());
        v0.s("thumbnail_info");
        this.nullableListOfThumbnailInfoAdapter.toJson(v0, playerItem0.getThumbnailInfo());
        v0.s("drm_info");
        this.nullableDrmInfoAdapter.toJson(v0, playerItem0.getDrmInfo());
        v0.s("playback_urls");
        this.listOfPlaybackUrlAdapter.toJson(v0, playerItem0.getPlaybackUrls());
        v0.s("video_tracks");
        this.listOfVideoTrackAdapter.toJson(v0, playerItem0.getVideoTracks());
        v0.s("audio_tracks");
        this.listOfAudioTrackAdapter.toJson(v0, playerItem0.getAudioTracks());
        v0.s("subtitle_tracks");
        this.nullableListOfSubtitleTrackAdapter.toJson(v0, playerItem0.getSubtitleTracks());
        v0.q();
    }

    @Override  // Vd.k
    public void toJson(v v0, Object object0) {
        this.toJson(v0, ((PlayerItem)object0));
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return "GeneratedJsonAdapter(PlayerItem)";
    }
}

