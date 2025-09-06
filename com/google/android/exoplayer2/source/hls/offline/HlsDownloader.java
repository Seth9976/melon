package com.google.android.exoplayer2.source.hls.offline;

import android.net.Uri;
import com.google.android.exoplayer2.offline.DownloaderConstructorHelper;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.UriUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class HlsDownloader extends SegmentDownloader {
    public HlsDownloader(Uri uri0, List list0, DownloaderConstructorHelper downloaderConstructorHelper0) {
        super(uri0, list0, downloaderConstructorHelper0);
    }

    private void addMediaPlaylistDataSpecs(List list0, List list1) {
        for(int v = 0; v < list0.size(); ++v) {
            list1.add(SegmentDownloader.getCompressibleDataSpec(((Uri)list0.get(v))));
        }
    }

    private void addSegment(HlsMediaPlaylist hlsMediaPlaylist0, Segment hlsMediaPlaylist$Segment0, HashSet hashSet0, ArrayList arrayList0) {
        String s = hlsMediaPlaylist0.baseUri;
        long v = hlsMediaPlaylist0.startTimeUs + hlsMediaPlaylist$Segment0.relativeStartTimeUs;
        String s1 = hlsMediaPlaylist$Segment0.fullSegmentEncryptionKeyUri;
        if(s1 != null) {
            Uri uri0 = UriUtil.resolveToUri(s, s1);
            if(hashSet0.add(uri0)) {
                arrayList0.add(new com.google.android.exoplayer2.offline.SegmentDownloader.Segment(v, SegmentDownloader.getCompressibleDataSpec(uri0)));
            }
        }
        arrayList0.add(new com.google.android.exoplayer2.offline.SegmentDownloader.Segment(v, new DataSpec(UriUtil.resolveToUri(s, hlsMediaPlaylist$Segment0.url), hlsMediaPlaylist$Segment0.byterangeOffset, hlsMediaPlaylist$Segment0.byterangeLength, null)));
    }

    @Override  // com.google.android.exoplayer2.offline.SegmentDownloader
    public FilterableManifest getManifest(DataSource dataSource0, DataSpec dataSpec0) {
        return this.getManifest(dataSource0, dataSpec0);
    }

    public HlsPlaylist getManifest(DataSource dataSource0, DataSpec dataSpec0) {
        return HlsDownloader.loadManifest(dataSource0, dataSpec0);
    }

    @Override  // com.google.android.exoplayer2.offline.SegmentDownloader
    public List getSegments(DataSource dataSource0, FilterableManifest filterableManifest0, boolean z) {
        return this.getSegments(dataSource0, ((HlsPlaylist)filterableManifest0), z);
    }

    public List getSegments(DataSource dataSource0, HlsPlaylist hlsPlaylist0, boolean z) {
        Segment hlsMediaPlaylist$Segment0;
        List list1;
        HlsMediaPlaylist hlsMediaPlaylist0;
        ArrayList arrayList0 = new ArrayList();
        if(hlsPlaylist0 instanceof HlsMasterPlaylist) {
            this.addMediaPlaylistDataSpecs(((HlsMasterPlaylist)hlsPlaylist0).mediaPlaylistUrls, arrayList0);
        }
        else {
            arrayList0.add(SegmentDownloader.getCompressibleDataSpec(Uri.parse(hlsPlaylist0.baseUri)));
        }
        List list0 = new ArrayList();
        HashSet hashSet0 = new HashSet();
        for(Object object0: arrayList0) {
            DataSpec dataSpec0 = (DataSpec)object0;
            ((ArrayList)list0).add(new com.google.android.exoplayer2.offline.SegmentDownloader.Segment(0L, dataSpec0));
            try {
                hlsMediaPlaylist0 = (HlsMediaPlaylist)HlsDownloader.loadManifest(dataSource0, dataSpec0);
                list1 = hlsMediaPlaylist0.segments;
                hlsMediaPlaylist$Segment0 = null;
            }
            catch(IOException iOException0) {
                if(!z) {
                    throw iOException0;
                }
                continue;
            }
            for(int v = 0; v < list1.size(); ++v) {
                Segment hlsMediaPlaylist$Segment1 = (Segment)list1.get(v);
                Segment hlsMediaPlaylist$Segment2 = hlsMediaPlaylist$Segment1.initializationSegment;
                if(hlsMediaPlaylist$Segment2 != null && hlsMediaPlaylist$Segment2 != hlsMediaPlaylist$Segment0) {
                    this.addSegment(hlsMediaPlaylist0, hlsMediaPlaylist$Segment2, hashSet0, ((ArrayList)list0));
                    hlsMediaPlaylist$Segment0 = hlsMediaPlaylist$Segment2;
                }
                this.addSegment(hlsMediaPlaylist0, hlsMediaPlaylist$Segment1, hashSet0, ((ArrayList)list0));
            }
        }
        return list0;
    }

    private static HlsPlaylist loadManifest(DataSource dataSource0, DataSpec dataSpec0) {
        return (HlsPlaylist)ParsingLoadable.load(dataSource0, new HlsPlaylistParser(), dataSpec0, 4);
    }
}

