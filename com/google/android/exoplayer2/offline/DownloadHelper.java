package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.TrackSelection.Definition;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class DownloadHelper {
    public interface Callback {
        void onPrepareError(DownloadHelper arg1, IOException arg2);

        void onPrepared(DownloadHelper arg1);
    }

    static final class DownloadTrackSelection extends BaseTrackSelection {
        static final class Factory implements com.google.android.exoplayer2.trackselection.TrackSelection.Factory {
            private Factory() {
            }

            public Factory(com.google.android.exoplayer2.offline.DownloadHelper.1 downloadHelper$10) {
            }

            @Override  // com.google.android.exoplayer2.trackselection.TrackSelection$Factory
            public TrackSelection[] createTrackSelections(Definition[] arr_trackSelection$Definition, BandwidthMeter bandwidthMeter0) {
                TrackSelection[] arr_trackSelection = new TrackSelection[arr_trackSelection$Definition.length];
                for(int v = 0; v < arr_trackSelection$Definition.length; ++v) {
                    Definition trackSelection$Definition0 = arr_trackSelection$Definition[v];
                    arr_trackSelection[v] = trackSelection$Definition0 == null ? null : new DownloadTrackSelection(trackSelection$Definition0.group, trackSelection$Definition0.tracks);
                }
                return arr_trackSelection;
            }
        }

        public DownloadTrackSelection(TrackGroup trackGroup0, int[] arr_v) {
            super(trackGroup0, arr_v);
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            return 0;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
        public Object getSelectionData() {
            return null;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            return 0;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long v, long v1, long v2, List list0, MediaChunkIterator[] arr_mediaChunkIterator) {
        }
    }

    static final class DummyBandwidthMeter implements BandwidthMeter {
        private DummyBandwidthMeter() {
        }

        public DummyBandwidthMeter(com.google.android.exoplayer2.offline.DownloadHelper.1 downloadHelper$10) {
        }

        @Override  // com.google.android.exoplayer2.upstream.BandwidthMeter
        public void addEventListener(Handler handler0, EventListener bandwidthMeter$EventListener0) {
        }

        @Override  // com.google.android.exoplayer2.upstream.BandwidthMeter
        public long getBitrateEstimate() {
            return 0L;
        }

        @Override  // com.google.android.exoplayer2.upstream.BandwidthMeter
        public TransferListener getTransferListener() {
            return null;
        }

        @Override  // com.google.android.exoplayer2.upstream.BandwidthMeter
        public void removeEventListener(EventListener bandwidthMeter$EventListener0) {
        }
    }

    public static class LiveContentUnsupportedException extends IOException {
    }

    static final class MediaPreparer implements Handler.Callback, com.google.android.exoplayer2.source.MediaPeriod.Callback, MediaSourceCaller {
        private static final int DOWNLOAD_HELPER_CALLBACK_MESSAGE_FAILED = 1;
        private static final int DOWNLOAD_HELPER_CALLBACK_MESSAGE_PREPARED = 0;
        private static final int MESSAGE_CHECK_FOR_FAILURE = 1;
        private static final int MESSAGE_CONTINUE_LOADING = 2;
        private static final int MESSAGE_PREPARE_SOURCE = 0;
        private static final int MESSAGE_RELEASE = 3;
        private final Allocator allocator;
        private final DownloadHelper downloadHelper;
        private final Handler downloadHelperHandler;
        public MediaPeriod[] mediaPeriods;
        private final MediaSource mediaSource;
        private final Handler mediaSourceHandler;
        private final HandlerThread mediaSourceThread;
        private final ArrayList pendingMediaPeriods;
        private boolean released;
        public Timeline timeline;

        public MediaPreparer(MediaSource mediaSource0, DownloadHelper downloadHelper0) {
            this.mediaSource = mediaSource0;
            this.downloadHelper = downloadHelper0;
            this.allocator = new DefaultAllocator(true, 0x10000);
            this.pendingMediaPeriods = new ArrayList();
            this.downloadHelperHandler = Util.createHandler(new b(this, 0));
            HandlerThread handlerThread0 = new HandlerThread("DownloadHelper");
            this.mediaSourceThread = handlerThread0;
            handlerThread0.start();
            Handler handler0 = Util.createHandler(handlerThread0.getLooper(), this);
            this.mediaSourceHandler = handler0;
            handler0.sendEmptyMessage(0);
        }

        private boolean handleDownloadHelperCallbackMessage(Message message0) {
            if(this.released) {
                return false;
            }
            switch(message0.what) {
                case 0: {
                    this.downloadHelper.onMediaPrepared();
                    return true;
                }
                case 1: {
                    this.release();
                    this.downloadHelper.onMediaPreparationFailed(((IOException)message0.obj));
                    return true;
                }
                default: {
                    return false;
                }
            }
        }

        @Override  // android.os.Handler$Callback
        public boolean handleMessage(Message message0) {
            int v = 0;
            switch(message0.what) {
                case 0: {
                    this.mediaSource.prepareSource(this, null);
                    this.mediaSourceHandler.sendEmptyMessage(1);
                    return true;
                }
                case 1: {
                    try {
                        if(this.mediaPeriods == null) {
                            this.mediaSource.maybeThrowSourceInfoRefreshError();
                        }
                        else {
                            while(v < this.pendingMediaPeriods.size()) {
                                ((MediaPeriod)this.pendingMediaPeriods.get(v)).maybeThrowPrepareError();
                                ++v;
                            }
                        }
                        this.mediaSourceHandler.sendEmptyMessageDelayed(1, 100L);
                        return true;
                    }
                    catch(IOException iOException0) {
                    }
                    this.downloadHelperHandler.obtainMessage(1, iOException0).sendToTarget();
                    return true;
                }
                case 2: {
                    MediaPeriod mediaPeriod0 = (MediaPeriod)message0.obj;
                    if(this.pendingMediaPeriods.contains(mediaPeriod0)) {
                        mediaPeriod0.continueLoading(0L);
                    }
                    return true;
                }
                case 3: {
                    MediaPeriod[] arr_mediaPeriod = this.mediaPeriods;
                    if(arr_mediaPeriod != null) {
                        while(v < arr_mediaPeriod.length) {
                            this.mediaSource.releasePeriod(arr_mediaPeriod[v]);
                            ++v;
                        }
                    }
                    this.mediaSource.releaseSource(this);
                    this.mediaSourceHandler.removeCallbacksAndMessages(null);
                    this.mediaSourceThread.quit();
                    return true;
                }
                default: {
                    return false;
                }
            }
        }

        public void onContinueLoadingRequested(MediaPeriod mediaPeriod0) {
            if(this.pendingMediaPeriods.contains(mediaPeriod0)) {
                this.mediaSourceHandler.obtainMessage(2, mediaPeriod0).sendToTarget();
            }
        }

        @Override  // com.google.android.exoplayer2.source.SequenceableLoader$Callback
        public void onContinueLoadingRequested(SequenceableLoader sequenceableLoader0) {
            this.onContinueLoadingRequested(((MediaPeriod)sequenceableLoader0));
        }

        @Override  // com.google.android.exoplayer2.source.MediaPeriod$Callback
        public void onPrepared(MediaPeriod mediaPeriod0) {
            this.pendingMediaPeriods.remove(mediaPeriod0);
            if(this.pendingMediaPeriods.isEmpty()) {
                this.mediaSourceHandler.removeMessages(1);
                this.downloadHelperHandler.sendEmptyMessage(0);
            }
        }

        @Override  // com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller
        public void onSourceInfoRefreshed(MediaSource mediaSource0, Timeline timeline0) {
            MediaPeriod[] arr_mediaPeriod;
            if(this.timeline == null) {
                if(timeline0.getWindow(0, new Window()).isLive) {
                    LiveContentUnsupportedException downloadHelper$LiveContentUnsupportedException0 = new LiveContentUnsupportedException();
                    this.downloadHelperHandler.obtainMessage(1, downloadHelper$LiveContentUnsupportedException0).sendToTarget();
                    return;
                }
                this.timeline = timeline0;
                this.mediaPeriods = new MediaPeriod[timeline0.getPeriodCount()];
                for(int v1 = 0; true; ++v1) {
                    arr_mediaPeriod = this.mediaPeriods;
                    if(v1 >= arr_mediaPeriod.length) {
                        break;
                    }
                    MediaPeriodId mediaSource$MediaPeriodId0 = new MediaPeriodId(timeline0.getUidOfPeriod(v1));
                    MediaPeriod mediaPeriod0 = this.mediaSource.createPeriod(mediaSource$MediaPeriodId0, this.allocator, 0L);
                    this.mediaPeriods[v1] = mediaPeriod0;
                    this.pendingMediaPeriods.add(mediaPeriod0);
                }
                for(int v = 0; v < arr_mediaPeriod.length; ++v) {
                    arr_mediaPeriod[v].prepare(this, 0L);
                }
            }
        }

        public void release() {
            if(this.released) {
                return;
            }
            this.released = true;
            this.mediaSourceHandler.sendEmptyMessage(3);
        }
    }

    private static final Constructor DASH_FACTORY_CONSTRUCTOR;
    @Deprecated
    public static final Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS;
    public static final Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT;
    @Deprecated
    public static final Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT;
    private static final Constructor HLS_FACTORY_CONSTRUCTOR;
    private static final Constructor SS_FACTORY_CONSTRUCTOR;
    private final String cacheKey;
    private Callback callback;
    private final Handler callbackHandler;
    private final String downloadType;
    private List[][] immutableTrackSelectionsByPeriodAndRenderer;
    private boolean isPreparedWithMedia;
    private MappedTrackInfo[] mappedTrackInfos;
    private MediaPreparer mediaPreparer;
    private final MediaSource mediaSource;
    private final RendererCapabilities[] rendererCapabilities;
    private final SparseIntArray scratchSet;
    private TrackGroupArray[] trackGroupArrays;
    private List[][] trackSelectionsByPeriodAndRenderer;
    private final DefaultTrackSelector trackSelector;
    private final Uri uri;
    private final Window window;

    static {
        Parameters defaultTrackSelector$Parameters0 = Parameters.DEFAULT_WITHOUT_CONTEXT.buildUpon().setForceHighestSupportedBitrate(true).build();
        DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT = defaultTrackSelector$Parameters0;
        DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT = defaultTrackSelector$Parameters0;
        DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS = defaultTrackSelector$Parameters0;
        DownloadHelper.DASH_FACTORY_CONSTRUCTOR = DownloadHelper.getConstructor("com.google.android.exoplayer2.source.dash.DashMediaSource$Factory");
        DownloadHelper.SS_FACTORY_CONSTRUCTOR = DownloadHelper.getConstructor("com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory");
        DownloadHelper.HLS_FACTORY_CONSTRUCTOR = DownloadHelper.getConstructor("com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory");
    }

    public DownloadHelper(String s, Uri uri0, String s1, MediaSource mediaSource0, Parameters defaultTrackSelector$Parameters0, RendererCapabilities[] arr_rendererCapabilities) {
        this.downloadType = s;
        this.uri = uri0;
        this.cacheKey = s1;
        this.mediaSource = mediaSource0;
        DefaultTrackSelector defaultTrackSelector0 = new DefaultTrackSelector(defaultTrackSelector$Parameters0, new Factory(null));
        this.trackSelector = defaultTrackSelector0;
        this.rendererCapabilities = arr_rendererCapabilities;
        this.scratchSet = new SparseIntArray();
        defaultTrackSelector0.init(new a(), new DummyBandwidthMeter(null));  // 初始化器: Ljava/lang/Object;-><init>()V
        this.callbackHandler = new Handler(Util.getLooper());
        this.window = new Window();
    }

    public void addAudioLanguagesToSelection(String[] arr_s) {
        this.assertPreparedWithMedia();
        for(int v = 0; v < this.mappedTrackInfos.length; ++v) {
            ParametersBuilder defaultTrackSelector$ParametersBuilder0 = DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            MappedTrackInfo mappingTrackSelector$MappedTrackInfo0 = this.mappedTrackInfos[v];
            int v1 = mappingTrackSelector$MappedTrackInfo0.getRendererCount();
            for(int v2 = 0; v2 < v1; ++v2) {
                if(mappingTrackSelector$MappedTrackInfo0.getRendererType(v2) != 1) {
                    defaultTrackSelector$ParametersBuilder0.setRendererDisabled(v2, true);
                }
            }
            for(int v3 = 0; v3 < arr_s.length; ++v3) {
                defaultTrackSelector$ParametersBuilder0.setPreferredAudioLanguage(arr_s[v3]);
                this.addTrackSelection(v, defaultTrackSelector$ParametersBuilder0.build());
            }
        }
    }

    public void addTextLanguagesToSelection(boolean z, String[] arr_s) {
        this.assertPreparedWithMedia();
        for(int v = 0; v < this.mappedTrackInfos.length; ++v) {
            ParametersBuilder defaultTrackSelector$ParametersBuilder0 = DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            MappedTrackInfo mappingTrackSelector$MappedTrackInfo0 = this.mappedTrackInfos[v];
            int v1 = mappingTrackSelector$MappedTrackInfo0.getRendererCount();
            for(int v2 = 0; v2 < v1; ++v2) {
                if(mappingTrackSelector$MappedTrackInfo0.getRendererType(v2) != 3) {
                    defaultTrackSelector$ParametersBuilder0.setRendererDisabled(v2, true);
                }
            }
            defaultTrackSelector$ParametersBuilder0.setSelectUndeterminedTextLanguage(z);
            for(int v3 = 0; v3 < arr_s.length; ++v3) {
                defaultTrackSelector$ParametersBuilder0.setPreferredTextLanguage(arr_s[v3]);
                this.addTrackSelection(v, defaultTrackSelector$ParametersBuilder0.build());
            }
        }
    }

    public void addTrackSelection(int v, Parameters defaultTrackSelector$Parameters0) {
        this.assertPreparedWithMedia();
        this.trackSelector.setParameters(defaultTrackSelector$Parameters0);
        this.runTrackSelection(v);
    }

    public void addTrackSelectionForSingleRenderer(int v, int v1, Parameters defaultTrackSelector$Parameters0, List list0) {
        this.assertPreparedWithMedia();
        ParametersBuilder defaultTrackSelector$ParametersBuilder0 = defaultTrackSelector$Parameters0.buildUpon();
        for(int v3 = 0; v3 < this.mappedTrackInfos[v].getRendererCount(); ++v3) {
            defaultTrackSelector$ParametersBuilder0.setRendererDisabled(v3, v3 != v1);
        }
        if(list0.isEmpty()) {
            this.addTrackSelection(v, defaultTrackSelector$ParametersBuilder0.build());
            return;
        }
        TrackGroupArray trackGroupArray0 = this.mappedTrackInfos[v].getTrackGroups(v1);
        for(int v2 = 0; v2 < list0.size(); ++v2) {
            defaultTrackSelector$ParametersBuilder0.setSelectionOverride(v1, trackGroupArray0, ((SelectionOverride)list0.get(v2)));
            this.addTrackSelection(v, defaultTrackSelector$ParametersBuilder0.build());
        }
    }

    @EnsuresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    private void assertPreparedWithMedia() {
        Assertions.checkState(this.isPreparedWithMedia);
    }

    public void clearTrackSelections(int v) {
        this.assertPreparedWithMedia();
        for(int v1 = 0; v1 < this.rendererCapabilities.length; ++v1) {
            this.trackSelectionsByPeriodAndRenderer[v][v1].clear();
        }
    }

    public static MediaSource createMediaSource(DownloadRequest downloadRequest0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0) {
        return DownloadHelper.createMediaSource(downloadRequest0, dataSource$Factory0, null);
    }

    public static MediaSource createMediaSource(DownloadRequest downloadRequest0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, DrmSessionManager drmSessionManager0) {
        downloadRequest0.type.getClass();
        switch(downloadRequest0.type) {
            case "dash": {
                return DownloadHelper.createMediaSourceInternal(DownloadHelper.DASH_FACTORY_CONSTRUCTOR, downloadRequest0.uri, dataSource$Factory0, drmSessionManager0, downloadRequest0.streamKeys);
            }
            case "hls": {
                return DownloadHelper.createMediaSourceInternal(DownloadHelper.HLS_FACTORY_CONSTRUCTOR, downloadRequest0.uri, dataSource$Factory0, drmSessionManager0, downloadRequest0.streamKeys);
            }
            case "progressive": {
                return new com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory(dataSource$Factory0).setCustomCacheKey(downloadRequest0.customCacheKey).createMediaSource(downloadRequest0.uri);
            }
            case "ss": {
                return DownloadHelper.createMediaSourceInternal(DownloadHelper.SS_FACTORY_CONSTRUCTOR, downloadRequest0.uri, dataSource$Factory0, drmSessionManager0, downloadRequest0.streamKeys);
            }
            default: {
                String s = String.valueOf(downloadRequest0.type);
                throw new IllegalStateException((s.length() == 0 ? new String("Unsupported type: ") : "Unsupported type: " + s));
            }
        }
    }

    private static MediaSource createMediaSourceInternal(Constructor constructor0, Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, DrmSessionManager drmSessionManager0, List list0) {
        if(constructor0 != null) {
            try {
                MediaSourceFactory mediaSourceFactory0 = (MediaSourceFactory)constructor0.newInstance(dataSource$Factory0);
                if(drmSessionManager0 != null) {
                    mediaSourceFactory0.setDrmSessionManager(drmSessionManager0);
                }
                if(list0 != null) {
                    mediaSourceFactory0.setStreamKeys(list0);
                }
                return (MediaSource)Assertions.checkNotNull(mediaSourceFactory0.createMediaSource(uri0));
            }
            catch(Exception exception0) {
                throw new IllegalStateException("Failed to instantiate media source.", exception0);
            }
        }
        throw new IllegalStateException("Module missing to create media source.");
    }

    public static void d() {
    }

    public static DownloadHelper forDash(Context context0, Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, RenderersFactory renderersFactory0) {
        return DownloadHelper.forDash(uri0, dataSource$Factory0, renderersFactory0, null, DownloadHelper.getDefaultTrackSelectorParameters(context0));
    }

    @Deprecated
    public static DownloadHelper forDash(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, RenderersFactory renderersFactory0) {
        return DownloadHelper.forDash(uri0, dataSource$Factory0, renderersFactory0, null, DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT);
    }

    public static DownloadHelper forDash(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, RenderersFactory renderersFactory0, DrmSessionManager drmSessionManager0, Parameters defaultTrackSelector$Parameters0) {
        return new DownloadHelper("dash", uri0, null, DownloadHelper.createMediaSourceInternal(DownloadHelper.DASH_FACTORY_CONSTRUCTOR, uri0, dataSource$Factory0, drmSessionManager0, null), defaultTrackSelector$Parameters0, Util.getRendererCapabilities(renderersFactory0));
    }

    public static DownloadHelper forHls(Context context0, Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, RenderersFactory renderersFactory0) {
        return DownloadHelper.forHls(uri0, dataSource$Factory0, renderersFactory0, null, DownloadHelper.getDefaultTrackSelectorParameters(context0));
    }

    @Deprecated
    public static DownloadHelper forHls(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, RenderersFactory renderersFactory0) {
        return DownloadHelper.forHls(uri0, dataSource$Factory0, renderersFactory0, null, DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT);
    }

    public static DownloadHelper forHls(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, RenderersFactory renderersFactory0, DrmSessionManager drmSessionManager0, Parameters defaultTrackSelector$Parameters0) {
        return new DownloadHelper("hls", uri0, null, DownloadHelper.createMediaSourceInternal(DownloadHelper.HLS_FACTORY_CONSTRUCTOR, uri0, dataSource$Factory0, drmSessionManager0, null), defaultTrackSelector$Parameters0, Util.getRendererCapabilities(renderersFactory0));
    }

    public static DownloadHelper forProgressive(Context context0, Uri uri0) {
        return DownloadHelper.forProgressive(context0, uri0, null);
    }

    public static DownloadHelper forProgressive(Context context0, Uri uri0, String s) {
        return new DownloadHelper("progressive", uri0, s, null, DownloadHelper.getDefaultTrackSelectorParameters(context0), new RendererCapabilities[0]);
    }

    @Deprecated
    public static DownloadHelper forProgressive(Uri uri0) {
        return DownloadHelper.forProgressive(uri0, null);
    }

    @Deprecated
    public static DownloadHelper forProgressive(Uri uri0, String s) {
        return new DownloadHelper("progressive", uri0, s, null, DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT, new RendererCapabilities[0]);
    }

    public static DownloadHelper forSmoothStreaming(Context context0, Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, RenderersFactory renderersFactory0) {
        return DownloadHelper.forSmoothStreaming(uri0, dataSource$Factory0, renderersFactory0, null, DownloadHelper.getDefaultTrackSelectorParameters(context0));
    }

    @Deprecated
    public static DownloadHelper forSmoothStreaming(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, RenderersFactory renderersFactory0) {
        return DownloadHelper.forSmoothStreaming(uri0, dataSource$Factory0, renderersFactory0, null, DownloadHelper.DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT);
    }

    public static DownloadHelper forSmoothStreaming(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, RenderersFactory renderersFactory0, DrmSessionManager drmSessionManager0, Parameters defaultTrackSelector$Parameters0) {
        return new DownloadHelper("ss", uri0, null, DownloadHelper.createMediaSourceInternal(DownloadHelper.SS_FACTORY_CONSTRUCTOR, uri0, dataSource$Factory0, drmSessionManager0, null), defaultTrackSelector$Parameters0, Util.getRendererCapabilities(renderersFactory0));
    }

    private static Constructor getConstructor(String s) {
        try {
            return Class.forName(s).asSubclass(MediaSourceFactory.class).getConstructor(com.google.android.exoplayer2.upstream.DataSource.Factory.class);
        }
        catch(ClassNotFoundException unused_ex) {
            return null;
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new IllegalStateException(noSuchMethodException0);
        }
    }

    public static Parameters getDefaultTrackSelectorParameters(Context context0) {
        return Parameters.getDefaults(context0).buildUpon().setForceHighestSupportedBitrate(true).build();
    }

    public DownloadRequest getDownloadRequest(String s, byte[] arr_b) {
        if(this.mediaSource == null) {
            return new DownloadRequest(s, this.downloadType, this.uri, Collections.EMPTY_LIST, this.cacheKey, arr_b);
        }
        this.assertPreparedWithMedia();
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        for(int v = 0; v < this.trackSelectionsByPeriodAndRenderer.length; ++v) {
            arrayList1.clear();
            int v1 = this.trackSelectionsByPeriodAndRenderer[v].length;
            for(int v2 = 0; v2 < v1; ++v2) {
                arrayList1.addAll(this.trackSelectionsByPeriodAndRenderer[v][v2]);
            }
            arrayList0.addAll(this.mediaPreparer.mediaPeriods[v].getStreamKeys(arrayList1));
        }
        return new DownloadRequest(s, this.downloadType, this.uri, arrayList0, this.cacheKey, arr_b);
    }

    public DownloadRequest getDownloadRequest(byte[] arr_b) {
        return this.getDownloadRequest(this.uri.toString(), arr_b);
    }

    public Object getManifest() {
        if(this.mediaSource == null) {
            return null;
        }
        this.assertPreparedWithMedia();
        return this.mediaPreparer.timeline.getWindowCount() <= 0 ? null : this.mediaPreparer.timeline.getWindow(0, this.window).manifest;
    }

    public MappedTrackInfo getMappedTrackInfo(int v) {
        this.assertPreparedWithMedia();
        return this.mappedTrackInfos[v];
    }

    public int getPeriodCount() {
        if(this.mediaSource == null) {
            return 0;
        }
        this.assertPreparedWithMedia();
        return this.trackGroupArrays.length;
    }

    public TrackGroupArray getTrackGroups(int v) {
        this.assertPreparedWithMedia();
        return this.trackGroupArrays[v];
    }

    public List getTrackSelections(int v, int v1) {
        this.assertPreparedWithMedia();
        return this.immutableTrackSelectionsByPeriodAndRenderer[v][v1];
    }

    private static void lambda$new$0() {
    }

    private void lambda$onMediaPreparationFailed$3(IOException iOException0) {
        ((Callback)Assertions.checkNotNull(this.callback)).onPrepareError(this, iOException0);
    }

    private void lambda$onMediaPrepared$2() {
        ((Callback)Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    private void lambda$prepare$1(Callback downloadHelper$Callback0) {
        downloadHelper$Callback0.onPrepared(this);
    }

    private void onMediaPreparationFailed(IOException iOException0) {
        ((Handler)Assertions.checkNotNull(this.callbackHandler)).post(new e(1, this, iOException0));
    }

    private void onMediaPrepared() {
        Assertions.checkNotNull(this.mediaPreparer);
        Assertions.checkNotNull(this.mediaPreparer.mediaPeriods);
        Assertions.checkNotNull(this.mediaPreparer.timeline);
        int v = this.mediaPreparer.mediaPeriods.length;
        int[] arr_v = new int[2];
        arr_v[1] = this.rendererCapabilities.length;
        arr_v[0] = v;
        this.trackSelectionsByPeriodAndRenderer = (List[][])Array.newInstance(List.class, arr_v);
        this.immutableTrackSelectionsByPeriodAndRenderer = new List[v][this.rendererCapabilities.length];
        for(int v2 = 0; v2 < v; ++v2) {
            for(int v3 = 0; v3 < this.rendererCapabilities.length; ++v3) {
                List[] arr_list = this.trackSelectionsByPeriodAndRenderer[v2];
                arr_list[v3] = new ArrayList();
                List[] arr_list1 = this.immutableTrackSelectionsByPeriodAndRenderer[v2];
                arr_list1[v3] = Collections.unmodifiableList(this.trackSelectionsByPeriodAndRenderer[v2][v3]);
            }
        }
        this.trackGroupArrays = new TrackGroupArray[v];
        this.mappedTrackInfos = new MappedTrackInfo[v];
        for(int v1 = 0; v1 < v; ++v1) {
            TrackGroupArray[] arr_trackGroupArray = this.trackGroupArrays;
            arr_trackGroupArray[v1] = this.mediaPreparer.mediaPeriods[v1].getTrackGroups();
            TrackSelectorResult trackSelectorResult0 = this.runTrackSelection(v1);
            this.trackSelector.onSelectionActivated(trackSelectorResult0.info);
            MappedTrackInfo[] arr_mappingTrackSelector$MappedTrackInfo = this.mappedTrackInfos;
            arr_mappingTrackSelector$MappedTrackInfo[v1] = (MappedTrackInfo)Assertions.checkNotNull(this.trackSelector.getCurrentMappedTrackInfo());
        }
        this.setPreparedWithMedia();
        ((Handler)Assertions.checkNotNull(this.callbackHandler)).post(new f(this, 1));
    }

    public void prepare(Callback downloadHelper$Callback0) {
        Assertions.checkState(this.callback == null);
        this.callback = downloadHelper$Callback0;
        MediaSource mediaSource0 = this.mediaSource;
        if(mediaSource0 != null) {
            this.mediaPreparer = new MediaPreparer(mediaSource0, this);
            return;
        }
        e e0 = new e(2, this, downloadHelper$Callback0);
        this.callbackHandler.post(e0);
    }

    public void release() {
        MediaPreparer downloadHelper$MediaPreparer0 = this.mediaPreparer;
        if(downloadHelper$MediaPreparer0 != null) {
            downloadHelper$MediaPreparer0.release();
        }
    }

    public void replaceTrackSelections(int v, Parameters defaultTrackSelector$Parameters0) {
        this.clearTrackSelections(v);
        this.addTrackSelection(v, defaultTrackSelector$Parameters0);
    }

    @RequiresNonNull({"trackGroupArrays", "trackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline"})
    private TrackSelectorResult runTrackSelection(int v) {
        try {
            TrackGroupArray trackGroupArray0 = this.trackGroupArrays[v];
            MediaPeriodId mediaSource$MediaPeriodId0 = new MediaPeriodId(this.mediaPreparer.timeline.getUidOfPeriod(v));
            TrackSelectorResult trackSelectorResult0 = this.trackSelector.selectTracks(this.rendererCapabilities, trackGroupArray0, mediaSource$MediaPeriodId0, this.mediaPreparer.timeline);
            int v1 = 0;
            while(v1 < trackSelectorResult0.length) {
                TrackSelection trackSelection0 = trackSelectorResult0.selections.get(v1);
                if(trackSelection0 != null) {
                    List list0 = this.trackSelectionsByPeriodAndRenderer[v][v1];
                    int v2 = 0;
                    while(true) {
                        if(v2 < list0.size()) {
                            TrackSelection trackSelection1 = (TrackSelection)list0.get(v2);
                            if(trackSelection1.getTrackGroup() == trackSelection0.getTrackGroup()) {
                                this.scratchSet.clear();
                                for(int v3 = 0; v3 < trackSelection1.length(); ++v3) {
                                    int v4 = trackSelection1.getIndexInTrackGroup(v3);
                                    this.scratchSet.put(v4, 0);
                                }
                                for(int v5 = 0; v5 < trackSelection0.length(); ++v5) {
                                    int v6 = trackSelection0.getIndexInTrackGroup(v5);
                                    this.scratchSet.put(v6, 0);
                                }
                                int[] arr_v = new int[this.scratchSet.size()];
                                for(int v7 = 0; v7 < this.scratchSet.size(); ++v7) {
                                    arr_v[v7] = this.scratchSet.keyAt(v7);
                                }
                                list0.set(v2, new DownloadTrackSelection(trackSelection1.getTrackGroup(), arr_v));
                                break;
                            }
                            else {
                                ++v2;
                                continue;
                            }
                        }
                        list0.add(trackSelection0);
                        break;
                    }
                }
                ++v1;
            }
            return trackSelectorResult0;
        }
        catch(ExoPlaybackException exoPlaybackException0) {
        }
        throw new UnsupportedOperationException(exoPlaybackException0);
    }

    @RequiresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    private void setPreparedWithMedia() {
        this.isPreparedWithMedia = true;
    }

    class com.google.android.exoplayer2.offline.DownloadHelper.1 {
    }

}

