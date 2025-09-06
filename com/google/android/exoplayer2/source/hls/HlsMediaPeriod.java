package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Rendition;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class HlsMediaPeriod implements MediaPeriod, Callback, PlaylistEventListener {
    private final Allocator allocator;
    private final boolean allowChunklessPreparation;
    private com.google.android.exoplayer2.source.MediaPeriod.Callback callback;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final DrmSessionManager drmSessionManager;
    private HlsSampleStreamWrapper[] enabledSampleStreamWrappers;
    private final EventDispatcher eventDispatcher;
    private final HlsExtractorFactory extractorFactory;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private int[][] manifestUrlIndicesPerWrapper;
    private final TransferListener mediaTransferListener;
    private final int metadataType;
    private boolean notifiedReadingStarted;
    private int pendingPrepareCount;
    private final HlsPlaylistTracker playlistTracker;
    private HlsSampleStreamWrapper[] sampleStreamWrappers;
    private final IdentityHashMap streamWrapperIndices;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    private TrackGroupArray trackGroups;
    private final boolean useSessionKeys;

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory0, HlsPlaylistTracker hlsPlaylistTracker0, HlsDataSourceFactory hlsDataSourceFactory0, TransferListener transferListener0, DrmSessionManager drmSessionManager0, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, EventDispatcher mediaSourceEventListener$EventDispatcher0, Allocator allocator0, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory0, boolean z, int v, boolean z1) {
        this.extractorFactory = hlsExtractorFactory0;
        this.playlistTracker = hlsPlaylistTracker0;
        this.dataSourceFactory = hlsDataSourceFactory0;
        this.mediaTransferListener = transferListener0;
        this.drmSessionManager = drmSessionManager0;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy0;
        this.eventDispatcher = mediaSourceEventListener$EventDispatcher0;
        this.allocator = allocator0;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory0;
        this.allowChunklessPreparation = z;
        this.metadataType = v;
        this.useSessionKeys = z1;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory0.createCompositeSequenceableLoader(new SequenceableLoader[0]);
        this.streamWrapperIndices = new IdentityHashMap();
        this.timestampAdjusterProvider = new TimestampAdjusterProvider();
        this.sampleStreamWrappers = new HlsSampleStreamWrapper[0];
        this.enabledSampleStreamWrappers = new HlsSampleStreamWrapper[0];
        this.manifestUrlIndicesPerWrapper = new int[0][];
        mediaSourceEventListener$EventDispatcher0.mediaPeriodCreated();
    }

    private void buildAndPrepareAudioSampleStreamWrappers(long v, List list0, List list1, List list2, Map map0) {
        ArrayList arrayList0 = new ArrayList(list0.size());
        ArrayList arrayList1 = new ArrayList(list0.size());
        ArrayList arrayList2 = new ArrayList(list0.size());
        HashSet hashSet0 = new HashSet();
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            String s = ((Rendition)list0.get(v1)).name;
            if(hashSet0.add(s)) {
                arrayList0.clear();
                arrayList1.clear();
                arrayList2.clear();
                int v3 = 1;
                for(int v2 = 0; v2 < list0.size(); ++v2) {
                    if(Util.areEqual(s, ((Rendition)list0.get(v2)).name)) {
                        Rendition hlsMasterPlaylist$Rendition0 = (Rendition)list0.get(v2);
                        arrayList2.add(v2);
                        arrayList0.add(hlsMasterPlaylist$Rendition0.url);
                        arrayList1.add(hlsMasterPlaylist$Rendition0.format);
                        v3 &= (hlsMasterPlaylist$Rendition0.format.codecs == null ? 0 : 1);
                    }
                }
                HlsSampleStreamWrapper hlsSampleStreamWrapper0 = this.buildSampleStreamWrapper(1, ((Uri[])arrayList0.toArray(new Uri[0])), ((Format[])arrayList1.toArray(new Format[0])), null, Collections.EMPTY_LIST, map0, v);
                list2.add(Util.toArray(arrayList2));
                list1.add(hlsSampleStreamWrapper0);
                if(this.allowChunklessPreparation && v3 != 0) {
                    hlsSampleStreamWrapper0.prepareWithMasterPlaylistInfo(new TrackGroup[]{new TrackGroup(((Format[])arrayList1.toArray(new Format[0])))}, 0, new int[0]);
                }
            }
        }
    }

    private void buildAndPrepareMainSampleStreamWrapper(HlsMasterPlaylist hlsMasterPlaylist0, long v, List list0, List list1, Map map0) {
        boolean z1;
        boolean z;
        int v1 = hlsMasterPlaylist0.variants.size();
        int[] arr_v = new int[v1];
        int v3 = 0;
        int v4 = 0;
        for(int v2 = 0; v2 < hlsMasterPlaylist0.variants.size(); ++v2) {
            Format format0 = ((Variant)hlsMasterPlaylist0.variants.get(v2)).format;
            if(format0.height > 0 || Util.getCodecsOfType(format0.codecs, 2) != null) {
                arr_v[v2] = 2;
                ++v3;
            }
            else if(Util.getCodecsOfType(format0.codecs, 1) == null) {
                arr_v[v2] = -1;
            }
            else {
                arr_v[v2] = 1;
                ++v4;
            }
        }
        if(v3 > 0) {
            v1 = v3;
            z = true;
            z1 = false;
        }
        else if(v4 < v1) {
            v1 -= v4;
            z = false;
            z1 = true;
        }
        else {
            z = false;
            z1 = false;
        }
        Uri[] arr_uri = new Uri[v1];
        Format[] arr_format = new Format[v1];
        int[] arr_v1 = new int[v1];
        int v6 = 0;
        for(int v5 = 0; v5 < hlsMasterPlaylist0.variants.size(); ++v5) {
            if((!z || arr_v[v5] == 2) && (!z1 || arr_v[v5] != 1)) {
                Variant hlsMasterPlaylist$Variant0 = (Variant)hlsMasterPlaylist0.variants.get(v5);
                arr_uri[v6] = hlsMasterPlaylist$Variant0.url;
                arr_format[v6] = hlsMasterPlaylist$Variant0.format;
                arr_v1[v6] = v5;
                ++v6;
            }
        }
        String s = arr_format[0].codecs;
        HlsSampleStreamWrapper hlsSampleStreamWrapper0 = this.buildSampleStreamWrapper(0, arr_uri, arr_format, hlsMasterPlaylist0.muxedAudioFormat, hlsMasterPlaylist0.muxedCaptionFormats, map0, v);
        list0.add(hlsSampleStreamWrapper0);
        list1.add(arr_v1);
        if(this.allowChunklessPreparation && s != null) {
            boolean z2 = Util.getCodecsOfType(s, 2) != null;
            boolean z3 = Util.getCodecsOfType(s, 1) != null;
            ArrayList arrayList0 = new ArrayList();
            if(z2) {
                Format[] arr_format1 = new Format[v1];
                for(int v7 = 0; v7 < v1; ++v7) {
                    arr_format1[v7] = HlsMediaPeriod.deriveVideoFormat(arr_format[v7]);
                }
                arrayList0.add(new TrackGroup(arr_format1));
                if(z3 && (hlsMasterPlaylist0.muxedAudioFormat != null || hlsMasterPlaylist0.audios.isEmpty())) {
                    arrayList0.add(new TrackGroup(new Format[]{HlsMediaPeriod.deriveAudioFormat(arr_format[0], hlsMasterPlaylist0.muxedAudioFormat, false)}));
                }
                List list2 = hlsMasterPlaylist0.muxedCaptionFormats;
                if(list2 == null) {
                    goto label_78;
                }
                for(int v8 = 0; v8 < list2.size(); ++v8) {
                    arrayList0.add(new TrackGroup(new Format[]{((Format)list2.get(v8))}));
                }
            }
            else if(z3) {
                Format[] arr_format2 = new Format[v1];
                for(int v9 = 0; v9 < v1; ++v9) {
                    arr_format2[v9] = HlsMediaPeriod.deriveAudioFormat(arr_format[v9], hlsMasterPlaylist0.muxedAudioFormat, true);
                }
                arrayList0.add(new TrackGroup(arr_format2));
            }
            else {
                throw new IllegalArgumentException((s.length() == 0 ? new String("Unexpected codecs attribute: ") : "Unexpected codecs attribute: " + s));
            }
        label_78:
            TrackGroup trackGroup0 = new TrackGroup(new Format[]{Format.createSampleFormat("ID3", "application/id3", null, -1, null)});
            arrayList0.add(trackGroup0);
            hlsSampleStreamWrapper0.prepareWithMasterPlaylistInfo(((TrackGroup[])arrayList0.toArray(new TrackGroup[0])), 0, new int[]{arrayList0.indexOf(trackGroup0)});
        }
    }

    private void buildAndPrepareSampleStreamWrappers(long v) {
        Object object0 = Assertions.checkNotNull(this.playlistTracker.getMasterPlaylist());
        Map map0 = this.useSessionKeys ? HlsMediaPeriod.deriveOverridingDrmInitData(((HlsMasterPlaylist)object0).sessionKeyDrmInitData) : Collections.EMPTY_MAP;
        List list0 = ((HlsMasterPlaylist)object0).audios;
        List list1 = ((HlsMasterPlaylist)object0).subtitles;
        this.pendingPrepareCount = 0;
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        if(!((HlsMasterPlaylist)object0).variants.isEmpty()) {
            this.buildAndPrepareMainSampleStreamWrapper(((HlsMasterPlaylist)object0), v, arrayList0, arrayList1, map0);
        }
        this.buildAndPrepareAudioSampleStreamWrappers(v, list0, arrayList0, arrayList1, map0);
        for(int v2 = 0; v2 < list1.size(); ++v2) {
            Object object1 = list1.get(v2);
            HlsSampleStreamWrapper hlsSampleStreamWrapper0 = this.buildSampleStreamWrapper(3, new Uri[]{((Rendition)object1).url}, new Format[]{((Rendition)object1).format}, null, Collections.EMPTY_LIST, map0, v);
            arrayList1.add(new int[]{v2});
            arrayList0.add(hlsSampleStreamWrapper0);
            hlsSampleStreamWrapper0.prepareWithMasterPlaylistInfo(new TrackGroup[]{new TrackGroup(new Format[]{((Rendition)object1).format})}, 0, new int[0]);
        }
        this.sampleStreamWrappers = (HlsSampleStreamWrapper[])arrayList0.toArray(new HlsSampleStreamWrapper[0]);
        this.manifestUrlIndicesPerWrapper = (int[][])arrayList1.toArray(new int[0][]);
        this.pendingPrepareCount = this.sampleStreamWrappers.length;
        this.sampleStreamWrappers[0].setIsTimestampMaster(true);
        HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper = this.sampleStreamWrappers;
        for(int v1 = 0; v1 < arr_hlsSampleStreamWrapper.length; ++v1) {
            arr_hlsSampleStreamWrapper[v1].continuePreparing();
        }
        this.enabledSampleStreamWrappers = this.sampleStreamWrappers;
    }

    private HlsSampleStreamWrapper buildSampleStreamWrapper(int v, Uri[] arr_uri, Format[] arr_format, Format format0, List list0, Map map0, long v1) {
        return new HlsSampleStreamWrapper(v, this, new HlsChunkSource(this.extractorFactory, this.playlistTracker, arr_uri, arr_format, this.dataSourceFactory, this.mediaTransferListener, this.timestampAdjusterProvider, list0), map0, this.allocator, v1, format0, this.drmSessionManager, this.loadErrorHandlingPolicy, this.eventDispatcher, this.metadataType);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public boolean continueLoading(long v) {
        if(this.trackGroups == null) {
            HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper = this.sampleStreamWrappers;
            for(int v1 = 0; v1 < arr_hlsSampleStreamWrapper.length; ++v1) {
                arr_hlsSampleStreamWrapper[v1].continuePreparing();
            }
            return false;
        }
        return this.compositeSequenceableLoader.continueLoading(v);
    }

    private static Format deriveAudioFormat(Format format0, Format format1, boolean z) {
        String s2;
        String s1;
        int v3;
        int v2;
        int v1;
        Metadata metadata0;
        String s;
        String s5;
        int v6;
        int v5;
        int v4;
        Metadata metadata1;
        String s4;
        String s3;
        int v = -1;
        if(format1 == null) {
            s = Util.getCodecsOfType(format0.codecs, 1);
            metadata0 = format0.metadata;
            if(z) {
                v1 = format0.channelCount;
                v2 = format0.selectionFlags;
                v3 = format0.roleFlags;
                s1 = format0.language;
                s2 = format0.label;
            label_18:
                s3 = s2;
                s4 = s;
                metadata1 = metadata0;
                v4 = v1;
                v5 = v2;
                v6 = v3;
                s5 = s1;
            }
            else {
                v4 = -1;
                s4 = s;
                metadata1 = metadata0;
                v5 = 0;
                v6 = 0;
                s3 = null;
                s5 = null;
            }
        }
        else {
            s = format1.codecs;
            metadata0 = format1.metadata;
            v1 = format1.channelCount;
            v2 = format1.selectionFlags;
            v3 = format1.roleFlags;
            s1 = format1.language;
            s2 = format1.label;
            goto label_18;
        }
        String s6 = MimeTypes.getMediaMimeType(s4);
        if(z) {
            v = format0.bitrate;
        }
        return Format.createAudioContainerFormat(format0.id, s3, format0.containerMimeType, s6, s4, metadata1, v, v4, -1, null, v5, v6, s5);
    }

    private static Map deriveOverridingDrmInitData(List list0) {
        ArrayList arrayList0 = new ArrayList(list0);
        Map map0 = new HashMap();
        int v = 0;
        while(v < arrayList0.size()) {
            DrmInitData drmInitData0 = (DrmInitData)list0.get(v);
            String s = drmInitData0.schemeType;
            ++v;
            int v1 = v;
            while(v1 < arrayList0.size()) {
                DrmInitData drmInitData1 = (DrmInitData)arrayList0.get(v1);
                if(TextUtils.equals(drmInitData1.schemeType, s)) {
                    drmInitData0 = drmInitData0.merge(drmInitData1);
                    arrayList0.remove(v1);
                }
                else {
                    ++v1;
                }
            }
            ((HashMap)map0).put(s, drmInitData0);
        }
        return map0;
    }

    private static Format deriveVideoFormat(Format format0) {
        String s = Util.getCodecsOfType(format0.codecs, 2);
        String s1 = MimeTypes.getMediaMimeType(s);
        return Format.createVideoContainerFormat(format0.id, format0.label, format0.containerMimeType, s1, s, format0.metadata, format0.bitrate, format0.width, format0.height, format0.frameRate, null, format0.selectionFlags, format0.roleFlags);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long v, boolean z) {
        HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper = this.enabledSampleStreamWrappers;
        for(int v1 = 0; v1 < arr_hlsSampleStreamWrapper.length; ++v1) {
            arr_hlsSampleStreamWrapper[v1].discardBuffer(v, z);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long v, SeekParameters seekParameters0) {
        return v;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public List getStreamKeys(List list0) {
        int v2;
        TrackGroupArray trackGroupArray0;
        int[] arr_v;
        HlsMasterPlaylist hlsMasterPlaylist0 = (HlsMasterPlaylist)Assertions.checkNotNull(this.playlistTracker.getMasterPlaylist());
        boolean z = hlsMasterPlaylist0.variants.isEmpty();
        int v = this.sampleStreamWrappers.length;
        int v1 = hlsMasterPlaylist0.subtitles.size();
        if(z) {
            arr_v = new int[0];
            trackGroupArray0 = TrackGroupArray.EMPTY;
            v2 = 0;
        }
        else {
            HlsSampleStreamWrapper hlsSampleStreamWrapper0 = this.sampleStreamWrappers[0];
            arr_v = this.manifestUrlIndicesPerWrapper[0];
            trackGroupArray0 = hlsSampleStreamWrapper0.getTrackGroups();
            v2 = hlsSampleStreamWrapper0.getPrimaryTrackGroupIndex();
        }
        List list1 = new ArrayList();
        boolean z1 = false;
        boolean z2 = false;
        Iterator iterator0 = list0.iterator();
    label_17:
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            TrackSelection trackSelection0 = (TrackSelection)object0;
            TrackGroup trackGroup0 = trackSelection0.getTrackGroup();
            int v3 = trackGroupArray0.indexOf(trackGroup0);
            if(v3 == -1) {
                int v5 = !z;
                while(true) {
                    HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper = this.sampleStreamWrappers;
                    if(v5 >= arr_hlsSampleStreamWrapper.length) {
                        continue label_17;
                    }
                    if(arr_hlsSampleStreamWrapper[v5].getTrackGroups().indexOf(trackGroup0) != -1) {
                        break;
                    }
                    ++v5;
                }
                int v6 = v5 >= v - v1 ? 2 : 1;
                int[] arr_v1 = this.manifestUrlIndicesPerWrapper[v5];
                for(int v7 = 0; v7 < trackSelection0.length(); ++v7) {
                    ((ArrayList)list1).add(new StreamKey(v6, arr_v1[trackSelection0.getIndexInTrackGroup(v7)]));
                }
            }
            else if(v3 == v2) {
                for(int v4 = 0; v4 < trackSelection0.length(); ++v4) {
                    ((ArrayList)list1).add(new StreamKey(0, arr_v[trackSelection0.getIndexInTrackGroup(v4)]));
                }
                z2 = true;
            }
            else {
                z1 = true;
            }
        }
        if(z1 && !z2) {
            int v8 = arr_v[0];
            int v9 = ((Variant)hlsMasterPlaylist0.variants.get(v8)).format.bitrate;
            for(int v10 = 1; v10 < arr_v.length; ++v10) {
                int v11 = ((Variant)hlsMasterPlaylist0.variants.get(arr_v[v10])).format.bitrate;
                if(v11 < v9) {
                    v8 = arr_v[v10];
                    v9 = v11;
                }
            }
            ((ArrayList)list1).add(new StreamKey(0, v8));
        }
        return list1;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return (TrackGroupArray)Assertions.checkNotNull(this.trackGroups);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public boolean isLoading() {
        return this.compositeSequenceableLoader.isLoading();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
        HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper = this.sampleStreamWrappers;
        for(int v = 0; v < arr_hlsSampleStreamWrapper.length; ++v) {
            arr_hlsSampleStreamWrapper[v].maybeThrowPrepareError();
        }
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader$Callback
    public void onContinueLoadingRequested(SequenceableLoader sequenceableLoader0) {
        this.onContinueLoadingRequested(((HlsSampleStreamWrapper)sequenceableLoader0));
    }

    public void onContinueLoadingRequested(HlsSampleStreamWrapper hlsSampleStreamWrapper0) {
        this.callback.onContinueLoadingRequested(this);
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PlaylistEventListener
    public void onPlaylistChanged() {
        this.callback.onContinueLoadingRequested(this);
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PlaylistEventListener
    public boolean onPlaylistError(Uri uri0, long v) {
        HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper = this.sampleStreamWrappers;
        boolean z = true;
        for(int v1 = 0; v1 < arr_hlsSampleStreamWrapper.length; ++v1) {
            z &= arr_hlsSampleStreamWrapper[v1].onPlaylistError(uri0, v);
        }
        this.callback.onContinueLoadingRequested(this);
        return z;
    }

    @Override  // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$Callback
    public void onPlaylistRefreshRequired(Uri uri0) {
        this.playlistTracker.refreshPlaylist(uri0);
    }

    @Override  // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$Callback
    public void onPrepared() {
        int v = this.pendingPrepareCount - 1;
        this.pendingPrepareCount = v;
        if(v > 0) {
            return;
        }
        HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper = this.sampleStreamWrappers;
        int v2 = 0;
        for(int v1 = 0; v1 < arr_hlsSampleStreamWrapper.length; ++v1) {
            v2 += arr_hlsSampleStreamWrapper[v1].getTrackGroups().length;
        }
        TrackGroup[] arr_trackGroup = new TrackGroup[v2];
        HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper1 = this.sampleStreamWrappers;
        for(int v3 = 0; v3 < arr_hlsSampleStreamWrapper1.length; ++v3) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper0 = arr_hlsSampleStreamWrapper1[v3];
            int v5 = hlsSampleStreamWrapper0.getTrackGroups().length;
            int v6 = 0;
            for(int v4 = 0; v6 < v5; ++v4) {
                arr_trackGroup[v4] = hlsSampleStreamWrapper0.getTrackGroups().get(v6);
                ++v6;
            }
        }
        this.trackGroups = new TrackGroupArray(arr_trackGroup);
        this.callback.onPrepared(this);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback mediaPeriod$Callback0, long v) {
        this.callback = mediaPeriod$Callback0;
        this.playlistTracker.addListener(this);
        this.buildAndPrepareSampleStreamWrappers(v);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if(!this.notifiedReadingStarted) {
            this.eventDispatcher.readingStarted();
            this.notifiedReadingStarted = true;
        }
        return 0x8000000000000001L;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void reevaluateBuffer(long v) {
        this.compositeSequenceableLoader.reevaluateBuffer(v);
    }

    public void release() {
        this.playlistTracker.removeListener(this);
        HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper = this.sampleStreamWrappers;
        for(int v = 0; v < arr_hlsSampleStreamWrapper.length; ++v) {
            arr_hlsSampleStreamWrapper[v].release();
        }
        this.callback = null;
        this.eventDispatcher.mediaPeriodReleased();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long v) {
        HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper = this.enabledSampleStreamWrappers;
        if(arr_hlsSampleStreamWrapper.length > 0) {
            boolean z = arr_hlsSampleStreamWrapper[0].seekToUs(v, false);
            for(int v1 = 1; true; ++v1) {
                HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper1 = this.enabledSampleStreamWrappers;
                if(v1 >= arr_hlsSampleStreamWrapper1.length) {
                    break;
                }
                arr_hlsSampleStreamWrapper1[v1].seekToUs(v, z);
            }
            if(z) {
                this.timestampAdjusterProvider.reset();
            }
        }
        return v;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] arr_trackSelection, boolean[] arr_z, SampleStream[] arr_sampleStream, boolean[] arr_z1, long v) {
        int[] arr_v = new int[arr_trackSelection.length];
        int[] arr_v1 = new int[arr_trackSelection.length];
        for(int v1 = 0; v1 < arr_trackSelection.length; ++v1) {
            SampleStream sampleStream0 = arr_sampleStream[v1];
            arr_v[v1] = sampleStream0 == null ? -1 : ((int)(((Integer)this.streamWrapperIndices.get(sampleStream0))));
            arr_v1[v1] = -1;
            TrackSelection trackSelection0 = arr_trackSelection[v1];
            if(trackSelection0 != null) {
                TrackGroup trackGroup0 = trackSelection0.getTrackGroup();
                for(int v2 = 0; true; ++v2) {
                    HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper = this.sampleStreamWrappers;
                    if(v2 >= arr_hlsSampleStreamWrapper.length) {
                        break;
                    }
                    if(arr_hlsSampleStreamWrapper[v2].getTrackGroups().indexOf(trackGroup0) != -1) {
                        arr_v1[v1] = v2;
                        break;
                    }
                }
            }
        }
        this.streamWrapperIndices.clear();
        SampleStream[] arr_sampleStream1 = new SampleStream[arr_trackSelection.length];
        SampleStream[] arr_sampleStream2 = new SampleStream[arr_trackSelection.length];
        TrackSelection[] arr_trackSelection1 = new TrackSelection[arr_trackSelection.length];
        HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper1 = new HlsSampleStreamWrapper[this.sampleStreamWrappers.length];
        int v4 = 0;
        boolean z = false;
        for(int v3 = 0; v3 < this.sampleStreamWrappers.length; v3 = v6 + 1) {
            for(int v5 = 0; true; ++v5) {
                TrackSelection trackSelection1 = null;
                if(v5 >= arr_trackSelection.length) {
                    break;
                }
                arr_sampleStream2[v5] = arr_v[v5] == v3 ? arr_sampleStream[v5] : null;
                if(arr_v1[v5] == v3) {
                    trackSelection1 = arr_trackSelection[v5];
                }
                arr_trackSelection1[v5] = trackSelection1;
            }
            int v6 = v3;
            int v7 = v4;
            HlsSampleStreamWrapper hlsSampleStreamWrapper0 = this.sampleStreamWrappers[v3];
            boolean z1 = hlsSampleStreamWrapper0.selectTracks(arr_trackSelection1, arr_z, arr_sampleStream2, arr_z1, v, z);
            boolean z2 = false;
            for(int v8 = 0; v8 < arr_trackSelection.length; ++v8) {
                SampleStream sampleStream1 = arr_sampleStream2[v8];
                if(arr_v1[v8] == v6) {
                    Assertions.checkNotNull(sampleStream1);
                    arr_sampleStream1[v8] = sampleStream1;
                    this.streamWrapperIndices.put(sampleStream1, v6);
                    z2 = true;
                }
                else if(arr_v[v8] == v6) {
                    Assertions.checkState(sampleStream1 == null);
                }
            }
            if(z2) {
                arr_hlsSampleStreamWrapper1[v4] = hlsSampleStreamWrapper0;
                ++v4;
                if(v7 == 0) {
                    hlsSampleStreamWrapper0.setIsTimestampMaster(true);
                    if(z1 || (this.enabledSampleStreamWrappers.length == 0 || hlsSampleStreamWrapper0 != this.enabledSampleStreamWrappers[0])) {
                        this.timestampAdjusterProvider.reset();
                        z = true;
                    }
                }
                else {
                    hlsSampleStreamWrapper0.setIsTimestampMaster(false);
                }
            }
        }
        System.arraycopy(arr_sampleStream1, 0, arr_sampleStream, 0, arr_trackSelection.length);
        HlsSampleStreamWrapper[] arr_hlsSampleStreamWrapper2 = (HlsSampleStreamWrapper[])Util.nullSafeArrayCopy(arr_hlsSampleStreamWrapper1, v4);
        this.enabledSampleStreamWrappers = arr_hlsSampleStreamWrapper2;
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(arr_hlsSampleStreamWrapper2);
        return v;
    }
}

