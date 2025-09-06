package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

final class SingleSampleMediaPeriod implements MediaPeriod, Callback {
    final class SampleStreamImpl implements SampleStream {
        private static final int STREAM_STATE_END_OF_STREAM = 2;
        private static final int STREAM_STATE_SEND_FORMAT = 0;
        private static final int STREAM_STATE_SEND_SAMPLE = 1;
        private boolean notifiedDownstreamFormat;
        private int streamState;

        private SampleStreamImpl() {
        }

        public SampleStreamImpl(com.google.android.exoplayer2.source.SingleSampleMediaPeriod.1 singleSampleMediaPeriod$10) {
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return SingleSampleMediaPeriod.this.loadingFinished;
        }

        private void maybeNotifyDownstreamFormat() {
            if(!this.notifiedDownstreamFormat) {
                int v = MimeTypes.getTrackType(SingleSampleMediaPeriod.this.format.sampleMimeType);
                SingleSampleMediaPeriod.this.eventDispatcher.downstreamFormatChanged(v, SingleSampleMediaPeriod.this.format, 0, null, 0L);
                this.notifiedDownstreamFormat = true;
            }
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
            SingleSampleMediaPeriod singleSampleMediaPeriod0 = SingleSampleMediaPeriod.this;
            if(!singleSampleMediaPeriod0.treatLoadErrorsAsEndOfStream) {
                singleSampleMediaPeriod0.loader.maybeThrowError();
            }
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder0, DecoderInputBuffer decoderInputBuffer0, boolean z) {
            this.maybeNotifyDownstreamFormat();
            int v = this.streamState;
            if(v == 2) {
                decoderInputBuffer0.addFlag(4);
                return -4;
            }
            if(!z && v != 0) {
                SingleSampleMediaPeriod singleSampleMediaPeriod0 = SingleSampleMediaPeriod.this;
                if(singleSampleMediaPeriod0.loadingFinished) {
                    if(singleSampleMediaPeriod0.sampleData == null) {
                        decoderInputBuffer0.addFlag(4);
                    }
                    else {
                        decoderInputBuffer0.addFlag(1);
                        decoderInputBuffer0.timeUs = 0L;
                        if(decoderInputBuffer0.isFlagsOnly()) {
                            return -4;
                        }
                        decoderInputBuffer0.ensureSpaceForWrite(SingleSampleMediaPeriod.this.sampleSize);
                        decoderInputBuffer0.data.put(SingleSampleMediaPeriod.this.sampleData, 0, SingleSampleMediaPeriod.this.sampleSize);
                    }
                    this.streamState = 2;
                    return -4;
                }
                return -3;
            }
            formatHolder0.format = SingleSampleMediaPeriod.this.format;
            this.streamState = 1;
            return -5;
        }

        public void reset() {
            if(this.streamState == 2) {
                this.streamState = 1;
            }
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long v) {
            this.maybeNotifyDownstreamFormat();
            if(v > 0L && this.streamState != 2) {
                this.streamState = 2;
                return 1;
            }
            return 0;
        }
    }

    static final class SourceLoadable implements Loadable {
        private final StatsDataSource dataSource;
        public final DataSpec dataSpec;
        private byte[] sampleData;

        public SourceLoadable(DataSpec dataSpec0, DataSource dataSource0) {
            this.dataSpec = dataSpec0;
            this.dataSource = new StatsDataSource(dataSource0);
        }

        public static StatsDataSource access$100(SourceLoadable singleSampleMediaPeriod$SourceLoadable0) {
            return singleSampleMediaPeriod$SourceLoadable0.dataSource;
        }

        public static byte[] access$200(SourceLoadable singleSampleMediaPeriod$SourceLoadable0) {
            return singleSampleMediaPeriod$SourceLoadable0.sampleData;
        }

        @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
        public void cancelLoad() {
        }

        @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
        public void load() {
            this.dataSource.resetBytesRead();
            try {
                this.dataSource.open(this.dataSpec);
                for(int v1 = 0; v1 != -1; v1 = this.dataSource.read(this.sampleData, v2, this.sampleData.length - v2)) {
                    int v2 = (int)this.dataSource.getBytesRead();
                    byte[] arr_b = this.sampleData;
                    if(arr_b == null) {
                        this.sampleData = new byte[0x400];
                    }
                    else if(v2 == arr_b.length) {
                        this.sampleData = Arrays.copyOf(arr_b, arr_b.length * 2);
                    }
                }
            }
            finally {
                Util.closeQuietly(this.dataSource);
            }
        }
    }

    private static final int INITIAL_SAMPLE_SIZE = 0x400;
    private final Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    private final EventDispatcher eventDispatcher;
    final Format format;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    final Loader loader;
    boolean loadingFinished;
    boolean notifiedReadingStarted;
    byte[] sampleData;
    int sampleSize;
    private final ArrayList sampleStreams;
    private final TrackGroupArray tracks;
    private final TransferListener transferListener;
    final boolean treatLoadErrorsAsEndOfStream;

    public SingleSampleMediaPeriod(DataSpec dataSpec0, Factory dataSource$Factory0, TransferListener transferListener0, Format format0, long v, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, EventDispatcher mediaSourceEventListener$EventDispatcher0, boolean z) {
        this.dataSpec = dataSpec0;
        this.dataSourceFactory = dataSource$Factory0;
        this.transferListener = transferListener0;
        this.format = format0;
        this.durationUs = v;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy0;
        this.eventDispatcher = mediaSourceEventListener$EventDispatcher0;
        this.treatLoadErrorsAsEndOfStream = z;
        this.tracks = new TrackGroupArray(new TrackGroup[]{new TrackGroup(new Format[]{format0})});
        this.sampleStreams = new ArrayList();
        this.loader = new Loader("Loader:SingleSampleMediaPeriod");
        mediaSourceEventListener$EventDispatcher0.mediaPeriodCreated();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public boolean continueLoading(long v) {
        if(!this.loadingFinished && !this.loader.isLoading() && !this.loader.hasFatalError()) {
            DataSource dataSource0 = this.dataSourceFactory.createDataSource();
            TransferListener transferListener0 = this.transferListener;
            if(transferListener0 != null) {
                dataSource0.addTransferListener(transferListener0);
            }
            SourceLoadable singleSampleMediaPeriod$SourceLoadable0 = new SourceLoadable(this.dataSpec, dataSource0);
            int v1 = this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(1);
            long v2 = this.loader.startLoading(singleSampleMediaPeriod$SourceLoadable0, this, v1);
            this.eventDispatcher.loadStarted(this.dataSpec, 1, -1, this.format, 0, null, 0L, this.durationUs, v2);
            return true;
        }
        return false;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long v, boolean z) {
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long v, SeekParameters seekParameters0) {
        return v;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getBufferedPositionUs() {
        return this.loadingFinished ? 0x8000000000000000L : 0L;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getNextLoadPositionUs() {
        return this.loadingFinished || this.loader.isLoading() ? 0x8000000000000000L : 0L;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public boolean isLoading() {
        return this.loader.isLoading();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
    }

    public void onLoadCanceled(SourceLoadable singleSampleMediaPeriod$SourceLoadable0, long v, long v1, boolean z) {
        this.eventDispatcher.loadCanceled(singleSampleMediaPeriod$SourceLoadable0.dataSpec, SourceLoadable.access$100(singleSampleMediaPeriod$SourceLoadable0).getLastOpenedUri(), SourceLoadable.access$100(singleSampleMediaPeriod$SourceLoadable0).getLastResponseHeaders(), 1, -1, null, 0, null, 0L, this.durationUs, v, v1, SourceLoadable.access$100(singleSampleMediaPeriod$SourceLoadable0).getBytesRead());
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public void onLoadCanceled(Loadable loader$Loadable0, long v, long v1, boolean z) {
        this.onLoadCanceled(((SourceLoadable)loader$Loadable0), v, v1, z);
    }

    public void onLoadCompleted(SourceLoadable singleSampleMediaPeriod$SourceLoadable0, long v, long v1) {
        this.sampleSize = (int)SourceLoadable.access$100(singleSampleMediaPeriod$SourceLoadable0).getBytesRead();
        this.sampleData = (byte[])Assertions.checkNotNull(SourceLoadable.access$200(singleSampleMediaPeriod$SourceLoadable0));
        this.loadingFinished = true;
        this.eventDispatcher.loadCompleted(singleSampleMediaPeriod$SourceLoadable0.dataSpec, SourceLoadable.access$100(singleSampleMediaPeriod$SourceLoadable0).getLastOpenedUri(), SourceLoadable.access$100(singleSampleMediaPeriod$SourceLoadable0).getLastResponseHeaders(), 1, -1, this.format, 0, null, 0L, this.durationUs, v, v1, ((long)this.sampleSize));
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public void onLoadCompleted(Loadable loader$Loadable0, long v, long v1) {
        this.onLoadCompleted(((SourceLoadable)loader$Loadable0), v, v1);
    }

    public LoadErrorAction onLoadError(SourceLoadable singleSampleMediaPeriod$SourceLoadable0, long v, long v1, IOException iOException0, int v2) {
        LoadErrorAction loader$LoadErrorAction0;
        long v3 = this.loadErrorHandlingPolicy.getRetryDelayMsFor(1, v1, iOException0, v2);
        int v4 = Long.compare(v3, 0x8000000000000001L);
        boolean z = v4 == 0 || v2 >= this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(1);
        if(!this.treatLoadErrorsAsEndOfStream || !z) {
            loader$LoadErrorAction0 = v4 == 0 ? Loader.DONT_RETRY_FATAL : Loader.createRetryAction(false, v3);
        }
        else {
            this.loadingFinished = true;
            loader$LoadErrorAction0 = Loader.DONT_RETRY;
        }
        boolean z1 = loader$LoadErrorAction0.isRetry();
        this.eventDispatcher.loadError(singleSampleMediaPeriod$SourceLoadable0.dataSpec, SourceLoadable.access$100(singleSampleMediaPeriod$SourceLoadable0).getLastOpenedUri(), SourceLoadable.access$100(singleSampleMediaPeriod$SourceLoadable0).getLastResponseHeaders(), 1, -1, this.format, 0, null, 0L, this.durationUs, v, v1, SourceLoadable.access$100(singleSampleMediaPeriod$SourceLoadable0).getBytesRead(), iOException0, !z1);
        return loader$LoadErrorAction0;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public LoadErrorAction onLoadError(Loadable loader$Loadable0, long v, long v1, IOException iOException0, int v2) {
        return this.onLoadError(((SourceLoadable)loader$Loadable0), v, v1, iOException0, v2);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback mediaPeriod$Callback0, long v) {
        mediaPeriod$Callback0.onPrepared(this);
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
    }

    public void release() {
        this.loader.release();
        this.eventDispatcher.mediaPeriodReleased();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long v) {
        for(int v1 = 0; v1 < this.sampleStreams.size(); ++v1) {
            ((SampleStreamImpl)this.sampleStreams.get(v1)).reset();
        }
        return v;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] arr_trackSelection, boolean[] arr_z, SampleStream[] arr_sampleStream, boolean[] arr_z1, long v) {
        for(int v1 = 0; v1 < arr_trackSelection.length; ++v1) {
            SampleStream sampleStream0 = arr_sampleStream[v1];
            if(sampleStream0 != null && (arr_trackSelection[v1] == null || !arr_z[v1])) {
                this.sampleStreams.remove(sampleStream0);
                arr_sampleStream[v1] = null;
            }
            if(arr_sampleStream[v1] == null && arr_trackSelection[v1] != null) {
                SampleStreamImpl singleSampleMediaPeriod$SampleStreamImpl0 = new SampleStreamImpl(this, null);
                this.sampleStreams.add(singleSampleMediaPeriod$SampleStreamImpl0);
                arr_sampleStream[v1] = singleSampleMediaPeriod$SampleStreamImpl0;
                arr_z1[v1] = true;
            }
        }
        return v;
    }

    class com.google.android.exoplayer2.source.SingleSampleMediaPeriod.1 {
    }

}

