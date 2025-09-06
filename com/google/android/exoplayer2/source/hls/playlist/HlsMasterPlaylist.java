package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class HlsMasterPlaylist extends HlsPlaylist {
    public static final class Rendition {
        public final Format format;
        public final String groupId;
        public final String name;
        public final Uri url;

        public Rendition(Uri uri0, Format format0, String s, String s1) {
            this.url = uri0;
            this.format = format0;
            this.groupId = s;
            this.name = s1;
        }
    }

    public static final class Variant {
        public final String audioGroupId;
        public final String captionGroupId;
        public final Format format;
        public final String subtitleGroupId;
        public final Uri url;
        public final String videoGroupId;

        public Variant(Uri uri0, Format format0, String s, String s1, String s2, String s3) {
            this.url = uri0;
            this.format = format0;
            this.videoGroupId = s;
            this.audioGroupId = s1;
            this.subtitleGroupId = s2;
            this.captionGroupId = s3;
        }

        public Variant copyWithFormat(Format format0) {
            return new Variant(this.url, format0, this.videoGroupId, this.audioGroupId, this.subtitleGroupId, this.captionGroupId);
        }

        public static Variant createMediaPlaylistVariantUrl(Uri uri0) {
            return new Variant(uri0, Format.createContainerFormat("0", null, "application/x-mpegURL", null, null, -1, 0, 0, null), null, null, null, null);
        }
    }

    public static final HlsMasterPlaylist EMPTY = null;
    public static final int GROUP_INDEX_AUDIO = 1;
    public static final int GROUP_INDEX_SUBTITLE = 2;
    public static final int GROUP_INDEX_VARIANT;
    public final List audios;
    public final List closedCaptions;
    public final List mediaPlaylistUrls;
    public final Format muxedAudioFormat;
    public final List muxedCaptionFormats;
    public final List sessionKeyDrmInitData;
    public final List subtitles;
    public final Map variableDefinitions;
    public final List variants;
    public final List videos;

    static {
        HlsMasterPlaylist.EMPTY = new HlsMasterPlaylist("", Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, null, Collections.EMPTY_LIST, false, Collections.EMPTY_MAP, Collections.EMPTY_LIST);
    }

    public HlsMasterPlaylist(String s, List list0, List list1, List list2, List list3, List list4, List list5, Format format0, List list6, boolean z, Map map0, List list7) {
        super(s, list0, z);
        this.mediaPlaylistUrls = Collections.unmodifiableList(HlsMasterPlaylist.getMediaPlaylistUrls(list1, list2, list3, list4, list5));
        this.variants = Collections.unmodifiableList(list1);
        this.videos = Collections.unmodifiableList(list2);
        this.audios = Collections.unmodifiableList(list3);
        this.subtitles = Collections.unmodifiableList(list4);
        this.closedCaptions = Collections.unmodifiableList(list5);
        this.muxedAudioFormat = format0;
        this.muxedCaptionFormats = list6 == null ? null : Collections.unmodifiableList(list6);
        this.variableDefinitions = Collections.unmodifiableMap(map0);
        this.sessionKeyDrmInitData = Collections.unmodifiableList(list7);
    }

    private static void addMediaPlaylistUrls(List list0, List list1) {
        for(int v = 0; v < list0.size(); ++v) {
            Uri uri0 = ((Rendition)list0.get(v)).url;
            if(uri0 != null && !list1.contains(uri0)) {
                list1.add(uri0);
            }
        }
    }

    public HlsMasterPlaylist copy(List list0) {
        List list1 = HlsMasterPlaylist.copyStreams(this.variants, 0, list0);
        List list2 = Collections.EMPTY_LIST;
        List list3 = HlsMasterPlaylist.copyStreams(this.audios, 1, list0);
        List list4 = HlsMasterPlaylist.copyStreams(this.subtitles, 2, list0);
        return new HlsMasterPlaylist(this.baseUri, this.tags, list1, list2, list3, list4, list2, this.muxedAudioFormat, this.muxedCaptionFormats, this.hasIndependentSegments, this.variableDefinitions, this.sessionKeyDrmInitData);
    }

    @Override  // com.google.android.exoplayer2.offline.FilterableManifest
    public Object copy(List list0) {
        return this.copy(list0);
    }

    private static List copyStreams(List list0, int v, List list1) {
        List list2 = new ArrayList(list1.size());
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            Object object0 = list0.get(v1);
            for(int v2 = 0; v2 < list1.size(); ++v2) {
                StreamKey streamKey0 = (StreamKey)list1.get(v2);
                if(streamKey0.groupIndex == v && streamKey0.trackIndex == v1) {
                    ((ArrayList)list2).add(object0);
                    break;
                }
            }
        }
        return list2;
    }

    public static HlsMasterPlaylist createSingleVariantMasterPlaylist(String s) {
        List list0 = Collections.singletonList(Variant.createMediaPlaylistVariantUrl(Uri.parse(s)));
        return new HlsMasterPlaylist("", Collections.EMPTY_LIST, list0, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, null, null, false, Collections.EMPTY_MAP, Collections.EMPTY_LIST);
    }

    private static List getMediaPlaylistUrls(List list0, List list1, List list2, List list3, List list4) {
        List list5 = new ArrayList();
        for(int v = 0; v < list0.size(); ++v) {
            Uri uri0 = ((Variant)list0.get(v)).url;
            if(!((ArrayList)list5).contains(uri0)) {
                ((ArrayList)list5).add(uri0);
            }
        }
        HlsMasterPlaylist.addMediaPlaylistUrls(list1, list5);
        HlsMasterPlaylist.addMediaPlaylistUrls(list2, list5);
        HlsMasterPlaylist.addMediaPlaylistUrls(list3, list5);
        HlsMasterPlaylist.addMediaPlaylistUrls(list4, list5);
        return list5;
    }
}

