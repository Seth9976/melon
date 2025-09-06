package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DefaultHlsPlaylistTracker implements HlsPlaylistTracker, Callback {
    final class MediaPlaylistBundle implements Callback, Runnable {
        private long blacklistUntilMs;
        private long earliestNextLoadTimeMs;
        private long lastSnapshotChangeMs;
        private long lastSnapshotLoadMs;
        private boolean loadPending;
        private final ParsingLoadable mediaPlaylistLoadable;
        private final Loader mediaPlaylistLoader;
        private IOException playlistError;
        private HlsMediaPlaylist playlistSnapshot;
        private final Uri playlistUrl;

        public MediaPlaylistBundle(Uri uri0) {
            this.playlistUrl = uri0;
            this.mediaPlaylistLoader = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
            this.mediaPlaylistLoadable = new ParsingLoadable(defaultHlsPlaylistTracker0.dataSourceFactory.createDataSource(4), uri0, 4, defaultHlsPlaylistTracker0.mediaPlaylistParser);
        }

        public static void access$000(MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle0, HlsMediaPlaylist hlsMediaPlaylist0, long v) {
            defaultHlsPlaylistTracker$MediaPlaylistBundle0.processLoadedPlaylist(hlsMediaPlaylist0, v);
        }

        public static long access$100(MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle0) {
            return defaultHlsPlaylistTracker$MediaPlaylistBundle0.blacklistUntilMs;
        }

        public static Uri access$200(MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle0) {
            return defaultHlsPlaylistTracker$MediaPlaylistBundle0.playlistUrl;
        }

        private boolean blacklistPlaylist(long v) {
            this.blacklistUntilMs = SystemClock.elapsedRealtime() + v;
            return this.playlistUrl.equals(DefaultHlsPlaylistTracker.this.primaryMediaPlaylistUrl) && !DefaultHlsPlaylistTracker.this.maybeSelectNewPrimaryUrl();
        }

        public HlsMediaPlaylist getPlaylistSnapshot() {
            return this.playlistSnapshot;
        }

        public boolean isSnapshotValid() {
            if(this.playlistSnapshot == null) {
                return false;
            }
            long v = SystemClock.elapsedRealtime();
            long v1 = Math.max(30000L, C.usToMs(this.playlistSnapshot.durationUs));
            return this.playlistSnapshot.hasEndTag || (this.playlistSnapshot.playlistType == 1 || this.playlistSnapshot.playlistType == 2) || this.lastSnapshotLoadMs + v1 > v;
        }

        public void loadPlaylist() {
            this.blacklistUntilMs = 0L;
            if(!this.loadPending && !this.mediaPlaylistLoader.isLoading() && !this.mediaPlaylistLoader.hasFatalError()) {
                long v = SystemClock.elapsedRealtime();
                if(v < this.earliestNextLoadTimeMs) {
                    this.loadPending = true;
                    DefaultHlsPlaylistTracker.this.playlistRefreshHandler.postDelayed(this, this.earliestNextLoadTimeMs - v);
                    return;
                }
                this.loadPlaylistImmediately();
            }
        }

        private void loadPlaylistImmediately() {
            int v = DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.mediaPlaylistLoadable.type);
            long v1 = this.mediaPlaylistLoader.startLoading(this.mediaPlaylistLoadable, this, v);
            DefaultHlsPlaylistTracker.this.eventDispatcher.loadStarted(this.mediaPlaylistLoadable.dataSpec, this.mediaPlaylistLoadable.type, v1);
        }

        public void maybeThrowPlaylistRefreshError() {
            this.mediaPlaylistLoader.maybeThrowError();
            IOException iOException0 = this.playlistError;
            if(iOException0 != null) {
                throw iOException0;
            }
        }

        @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
        public void onLoadCanceled(Loadable loader$Loadable0, long v, long v1, boolean z) {
            this.onLoadCanceled(((ParsingLoadable)loader$Loadable0), v, v1, z);
        }

        public void onLoadCanceled(ParsingLoadable parsingLoadable0, long v, long v1, boolean z) {
            Uri uri0 = parsingLoadable0.getUri();
            Map map0 = parsingLoadable0.getResponseHeaders();
            long v2 = parsingLoadable0.bytesLoaded();
            DefaultHlsPlaylistTracker.this.eventDispatcher.loadCanceled(parsingLoadable0.dataSpec, uri0, map0, 4, v, v1, v2);
        }

        @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
        public void onLoadCompleted(Loadable loader$Loadable0, long v, long v1) {
            this.onLoadCompleted(((ParsingLoadable)loader$Loadable0), v, v1);
        }

        public void onLoadCompleted(ParsingLoadable parsingLoadable0, long v, long v1) {
            HlsPlaylist hlsPlaylist0 = (HlsPlaylist)parsingLoadable0.getResult();
            if(hlsPlaylist0 instanceof HlsMediaPlaylist) {
                this.processLoadedPlaylist(((HlsMediaPlaylist)hlsPlaylist0), v1);
                Uri uri0 = parsingLoadable0.getUri();
                Map map0 = parsingLoadable0.getResponseHeaders();
                long v2 = parsingLoadable0.bytesLoaded();
                DefaultHlsPlaylistTracker.this.eventDispatcher.loadCompleted(parsingLoadable0.dataSpec, uri0, map0, 4, v, v1, v2);
                return;
            }
            this.playlistError = new ParserException("Loaded playlist has unexpected type.");
        }

        @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
        public LoadErrorAction onLoadError(Loadable loader$Loadable0, long v, long v1, IOException iOException0, int v2) {
            return this.onLoadError(((ParsingLoadable)loader$Loadable0), v, v1, iOException0, v2);
        }

        public LoadErrorAction onLoadError(ParsingLoadable parsingLoadable0, long v, long v1, IOException iOException0, int v2) {
            LoadErrorAction loader$LoadErrorAction0;
            long v3 = DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(parsingLoadable0.type, v1, iOException0, v2);
            boolean z = Long.compare(v3, 0x8000000000000001L) != 0;
            boolean z1 = DefaultHlsPlaylistTracker.this.notifyPlaylistError(this.playlistUrl, v3) || !z;
            if(z) {
                z1 |= this.blacklistPlaylist(v3);
            }
            if(z1) {
                long v4 = DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getRetryDelayMsFor(parsingLoadable0.type, v1, iOException0, v2);
                loader$LoadErrorAction0 = v4 == 0x8000000000000001L ? Loader.DONT_RETRY_FATAL : Loader.createRetryAction(false, v4);
            }
            else {
                loader$LoadErrorAction0 = Loader.DONT_RETRY;
            }
            Uri uri0 = parsingLoadable0.getUri();
            Map map0 = parsingLoadable0.getResponseHeaders();
            long v5 = parsingLoadable0.bytesLoaded();
            boolean z2 = loader$LoadErrorAction0.isRetry();
            DefaultHlsPlaylistTracker.this.eventDispatcher.loadError(parsingLoadable0.dataSpec, uri0, map0, 4, v, v1, v5, iOException0, !z2);
            return loader$LoadErrorAction0;
        }

        private void processLoadedPlaylist(HlsMediaPlaylist hlsMediaPlaylist0, long v) {
            HlsMediaPlaylist hlsMediaPlaylist1 = this.playlistSnapshot;
            long v1 = SystemClock.elapsedRealtime();
            this.lastSnapshotLoadMs = v1;
            HlsMediaPlaylist hlsMediaPlaylist2 = DefaultHlsPlaylistTracker.this.getLatestPlaylistSnapshot(hlsMediaPlaylist1, hlsMediaPlaylist0);
            this.playlistSnapshot = hlsMediaPlaylist2;
            if(hlsMediaPlaylist2 != hlsMediaPlaylist1) {
                this.playlistError = null;
                this.lastSnapshotChangeMs = v1;
                DefaultHlsPlaylistTracker.this.onPlaylistUpdated(this.playlistUrl, hlsMediaPlaylist2);
            }
            else if(!hlsMediaPlaylist2.hasEndTag) {
                HlsMediaPlaylist hlsMediaPlaylist3 = this.playlistSnapshot;
                if(Long.compare(hlsMediaPlaylist0.mediaSequence + ((long)hlsMediaPlaylist0.segments.size()), hlsMediaPlaylist3.mediaSequence) < 0) {
                    this.playlistError = new PlaylistResetException(this.playlistUrl);
                    DefaultHlsPlaylistTracker.this.notifyPlaylistError(this.playlistUrl, 0x8000000000000001L);
                }
                else {
                    double f = (double)(v1 - this.lastSnapshotChangeMs);
                    double f1 = (double)C.usToMs(hlsMediaPlaylist3.targetDurationUs);
                    if(f > DefaultHlsPlaylistTracker.this.playlistStuckTargetDurationCoefficient * f1) {
                        this.playlistError = new PlaylistStuckException(this.playlistUrl);
                        long v2 = DefaultHlsPlaylistTracker.this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(4, v, this.playlistError, 1);
                        DefaultHlsPlaylistTracker.this.notifyPlaylistError(this.playlistUrl, v2);
                        if(v2 != 0x8000000000000001L) {
                            this.blacklistPlaylist(v2);
                        }
                    }
                }
            }
            this.earliestNextLoadTimeMs = C.usToMs((this.playlistSnapshot == hlsMediaPlaylist1 ? this.playlistSnapshot.targetDurationUs / 2L : this.playlistSnapshot.targetDurationUs)) + v1;
            if(this.playlistUrl.equals(DefaultHlsPlaylistTracker.this.primaryMediaPlaylistUrl) && !this.playlistSnapshot.hasEndTag) {
                this.loadPlaylist();
            }
        }

        public void release() {
            this.mediaPlaylistLoader.release();
        }

        @Override
        public void run() {
            this.loadPending = false;
            this.loadPlaylistImmediately();
        }
    }

    public static final double DEFAULT_PLAYLIST_STUCK_TARGET_DURATION_COEFFICIENT = 3.5;
    public static final Factory FACTORY;
    private final HlsDataSourceFactory dataSourceFactory;
    private EventDispatcher eventDispatcher;
    private Loader initialPlaylistLoader;
    private long initialStartTimeUs;
    private boolean isLive;
    private final List listeners;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private HlsMasterPlaylist masterPlaylist;
    private Parser mediaPlaylistParser;
    private final HashMap playlistBundles;
    private final HlsPlaylistParserFactory playlistParserFactory;
    private Handler playlistRefreshHandler;
    private final double playlistStuckTargetDurationCoefficient;
    private HlsMediaPlaylist primaryMediaPlaylistSnapshot;
    private Uri primaryMediaPlaylistUrl;
    private PrimaryPlaylistListener primaryPlaylistListener;

    static {
        DefaultHlsPlaylistTracker.FACTORY = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory0, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, HlsPlaylistParserFactory hlsPlaylistParserFactory0) {
        this(hlsDataSourceFactory0, loadErrorHandlingPolicy0, hlsPlaylistParserFactory0, 3.5);
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory0, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, HlsPlaylistParserFactory hlsPlaylistParserFactory0, double f) {
        this.dataSourceFactory = hlsDataSourceFactory0;
        this.playlistParserFactory = hlsPlaylistParserFactory0;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy0;
        this.playlistStuckTargetDurationCoefficient = f;
        this.listeners = new ArrayList();
        this.playlistBundles = new HashMap();
        this.initialStartTimeUs = 0x8000000000000001L;
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void addListener(PlaylistEventListener hlsPlaylistTracker$PlaylistEventListener0) {
        this.listeners.add(hlsPlaylistTracker$PlaylistEventListener0);
    }

    private void createBundles(List list0) {
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            Uri uri0 = (Uri)list0.get(v1);
            MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle0 = new MediaPlaylistBundle(this, uri0);
            this.playlistBundles.put(uri0, defaultHlsPlaylistTracker$MediaPlaylistBundle0);
        }
    }

    private static Segment getFirstOldOverlappingSegment(HlsMediaPlaylist hlsMediaPlaylist0, HlsMediaPlaylist hlsMediaPlaylist1) {
        int v = (int)(hlsMediaPlaylist1.mediaSequence - hlsMediaPlaylist0.mediaSequence);
        return v >= hlsMediaPlaylist0.segments.size() ? null : ((Segment)hlsMediaPlaylist0.segments.get(v));
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long getInitialStartTimeUs() {
        return this.initialStartTimeUs;
    }

    private HlsMediaPlaylist getLatestPlaylistSnapshot(HlsMediaPlaylist hlsMediaPlaylist0, HlsMediaPlaylist hlsMediaPlaylist1) {
        if(!hlsMediaPlaylist1.isNewerThan(hlsMediaPlaylist0)) {
            return hlsMediaPlaylist1.hasEndTag ? hlsMediaPlaylist0.copyWithEndTag() : hlsMediaPlaylist0;
        }
        return hlsMediaPlaylist1.copyWith(this.getLoadedPlaylistStartTimeUs(hlsMediaPlaylist0, hlsMediaPlaylist1), this.getLoadedPlaylistDiscontinuitySequence(hlsMediaPlaylist0, hlsMediaPlaylist1));
    }

    private int getLoadedPlaylistDiscontinuitySequence(HlsMediaPlaylist hlsMediaPlaylist0, HlsMediaPlaylist hlsMediaPlaylist1) {
        if(hlsMediaPlaylist1.hasDiscontinuitySequence) {
            return hlsMediaPlaylist1.discontinuitySequence;
        }
        int v = this.primaryMediaPlaylistSnapshot == null ? 0 : this.primaryMediaPlaylistSnapshot.discontinuitySequence;
        if(hlsMediaPlaylist0 != null) {
            Segment hlsMediaPlaylist$Segment0 = DefaultHlsPlaylistTracker.getFirstOldOverlappingSegment(hlsMediaPlaylist0, hlsMediaPlaylist1);
            if(hlsMediaPlaylist$Segment0 != null) {
                int v1 = ((Segment)hlsMediaPlaylist1.segments.get(0)).relativeDiscontinuitySequence;
                return hlsMediaPlaylist0.discontinuitySequence + hlsMediaPlaylist$Segment0.relativeDiscontinuitySequence - v1;
            }
        }
        return v;
    }

    private long getLoadedPlaylistStartTimeUs(HlsMediaPlaylist hlsMediaPlaylist0, HlsMediaPlaylist hlsMediaPlaylist1) {
        if(hlsMediaPlaylist1.hasProgramDateTime) {
            return hlsMediaPlaylist1.startTimeUs;
        }
        long v = this.primaryMediaPlaylistSnapshot == null ? 0L : this.primaryMediaPlaylistSnapshot.startTimeUs;
        if(hlsMediaPlaylist0 != null) {
            int v1 = hlsMediaPlaylist0.segments.size();
            Segment hlsMediaPlaylist$Segment0 = DefaultHlsPlaylistTracker.getFirstOldOverlappingSegment(hlsMediaPlaylist0, hlsMediaPlaylist1);
            if(hlsMediaPlaylist$Segment0 != null) {
                return hlsMediaPlaylist0.startTimeUs + hlsMediaPlaylist$Segment0.relativeStartTimeUs;
            }
            return ((long)v1) == hlsMediaPlaylist1.mediaSequence - hlsMediaPlaylist0.mediaSequence ? hlsMediaPlaylist0.getEndTimeUs() : v;
        }
        return v;
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public HlsMasterPlaylist getMasterPlaylist() {
        return this.masterPlaylist;
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public HlsMediaPlaylist getPlaylistSnapshot(Uri uri0, boolean z) {
        HlsMediaPlaylist hlsMediaPlaylist0 = ((MediaPlaylistBundle)this.playlistBundles.get(uri0)).getPlaylistSnapshot();
        if(hlsMediaPlaylist0 != null && z) {
            this.maybeSetPrimaryUrl(uri0);
        }
        return hlsMediaPlaylist0;
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isLive() {
        return this.isLive;
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean isSnapshotValid(Uri uri0) {
        return ((MediaPlaylistBundle)this.playlistBundles.get(uri0)).isSnapshotValid();
    }

    private boolean isVariantUrl(Uri uri0) {
        List list0 = this.masterPlaylist.variants;
        for(int v = 0; v < list0.size(); ++v) {
            if(uri0.equals(((Variant)list0.get(v)).url)) {
                return true;
            }
        }
        return false;
    }

    private boolean maybeSelectNewPrimaryUrl() {
        List list0 = this.masterPlaylist.variants;
        int v = list0.size();
        long v1 = SystemClock.elapsedRealtime();
        for(int v2 = 0; v2 < v; ++v2) {
            Uri uri0 = ((Variant)list0.get(v2)).url;
            MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle0 = (MediaPlaylistBundle)this.playlistBundles.get(uri0);
            if(v1 > MediaPlaylistBundle.access$100(defaultHlsPlaylistTracker$MediaPlaylistBundle0)) {
                this.primaryMediaPlaylistUrl = MediaPlaylistBundle.access$200(defaultHlsPlaylistTracker$MediaPlaylistBundle0);
                defaultHlsPlaylistTracker$MediaPlaylistBundle0.loadPlaylist();
                return true;
            }
        }
        return false;
    }

    private void maybeSetPrimaryUrl(Uri uri0) {
        if(!uri0.equals(this.primaryMediaPlaylistUrl) && this.isVariantUrl(uri0) && (this.primaryMediaPlaylistSnapshot == null || !this.primaryMediaPlaylistSnapshot.hasEndTag)) {
            this.primaryMediaPlaylistUrl = uri0;
            ((MediaPlaylistBundle)this.playlistBundles.get(uri0)).loadPlaylist();
        }
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPlaylistRefreshError(Uri uri0) {
        ((MediaPlaylistBundle)this.playlistBundles.get(uri0)).maybeThrowPlaylistRefreshError();
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void maybeThrowPrimaryPlaylistRefreshError() {
        Loader loader0 = this.initialPlaylistLoader;
        if(loader0 != null) {
            loader0.maybeThrowError();
        }
        Uri uri0 = this.primaryMediaPlaylistUrl;
        if(uri0 != null) {
            this.maybeThrowPlaylistRefreshError(uri0);
        }
    }

    private boolean notifyPlaylistError(Uri uri0, long v) {
        int v1 = this.listeners.size();
        boolean z = false;
        for(int v2 = 0; v2 < v1; ++v2) {
            z |= !((PlaylistEventListener)this.listeners.get(v2)).onPlaylistError(uri0, v);
        }
        return z;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public void onLoadCanceled(Loadable loader$Loadable0, long v, long v1, boolean z) {
        this.onLoadCanceled(((ParsingLoadable)loader$Loadable0), v, v1, z);
    }

    public void onLoadCanceled(ParsingLoadable parsingLoadable0, long v, long v1, boolean z) {
        EventDispatcher mediaSourceEventListener$EventDispatcher0 = this.eventDispatcher;
        Uri uri0 = parsingLoadable0.getUri();
        Map map0 = parsingLoadable0.getResponseHeaders();
        long v2 = parsingLoadable0.bytesLoaded();
        mediaSourceEventListener$EventDispatcher0.loadCanceled(parsingLoadable0.dataSpec, uri0, map0, 4, v, v1, v2);
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public void onLoadCompleted(Loadable loader$Loadable0, long v, long v1) {
        this.onLoadCompleted(((ParsingLoadable)loader$Loadable0), v, v1);
    }

    public void onLoadCompleted(ParsingLoadable parsingLoadable0, long v, long v1) {
        HlsPlaylist hlsPlaylist0 = (HlsPlaylist)parsingLoadable0.getResult();
        HlsMasterPlaylist hlsMasterPlaylist0 = hlsPlaylist0 instanceof HlsMediaPlaylist ? HlsMasterPlaylist.createSingleVariantMasterPlaylist(hlsPlaylist0.baseUri) : ((HlsMasterPlaylist)hlsPlaylist0);
        this.masterPlaylist = hlsMasterPlaylist0;
        this.mediaPlaylistParser = this.playlistParserFactory.createPlaylistParser(hlsMasterPlaylist0);
        this.primaryMediaPlaylistUrl = ((Variant)hlsMasterPlaylist0.variants.get(0)).url;
        this.createBundles(hlsMasterPlaylist0.mediaPlaylistUrls);
        MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle0 = (MediaPlaylistBundle)this.playlistBundles.get(this.primaryMediaPlaylistUrl);
        if(hlsPlaylist0 instanceof HlsMediaPlaylist) {
            MediaPlaylistBundle.access$000(defaultHlsPlaylistTracker$MediaPlaylistBundle0, ((HlsMediaPlaylist)hlsPlaylist0), v1);
        }
        else {
            defaultHlsPlaylistTracker$MediaPlaylistBundle0.loadPlaylist();
        }
        EventDispatcher mediaSourceEventListener$EventDispatcher0 = this.eventDispatcher;
        Uri uri0 = parsingLoadable0.getUri();
        Map map0 = parsingLoadable0.getResponseHeaders();
        long v2 = parsingLoadable0.bytesLoaded();
        mediaSourceEventListener$EventDispatcher0.loadCompleted(parsingLoadable0.dataSpec, uri0, map0, 4, v, v1, v2);
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public LoadErrorAction onLoadError(Loadable loader$Loadable0, long v, long v1, IOException iOException0, int v2) {
        return this.onLoadError(((ParsingLoadable)loader$Loadable0), v, v1, iOException0, v2);
    }

    public LoadErrorAction onLoadError(ParsingLoadable parsingLoadable0, long v, long v1, IOException iOException0, int v2) {
        long v3 = this.loadErrorHandlingPolicy.getRetryDelayMsFor(parsingLoadable0.type, v1, iOException0, v2);
        boolean z = Long.compare(v3, 0x8000000000000001L) == 0;
        EventDispatcher mediaSourceEventListener$EventDispatcher0 = this.eventDispatcher;
        Uri uri0 = parsingLoadable0.getUri();
        Map map0 = parsingLoadable0.getResponseHeaders();
        long v4 = parsingLoadable0.bytesLoaded();
        mediaSourceEventListener$EventDispatcher0.loadError(parsingLoadable0.dataSpec, uri0, map0, 4, v, v1, v4, iOException0, z);
        return z ? Loader.DONT_RETRY_FATAL : Loader.createRetryAction(false, v3);
    }

    private void onPlaylistUpdated(Uri uri0, HlsMediaPlaylist hlsMediaPlaylist0) {
        if(uri0.equals(this.primaryMediaPlaylistUrl)) {
            if(this.primaryMediaPlaylistSnapshot == null) {
                this.isLive = !hlsMediaPlaylist0.hasEndTag;
                this.initialStartTimeUs = hlsMediaPlaylist0.startTimeUs;
            }
            this.primaryMediaPlaylistSnapshot = hlsMediaPlaylist0;
            this.primaryPlaylistListener.onPrimaryPlaylistRefreshed(hlsMediaPlaylist0);
        }
        int v = this.listeners.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((PlaylistEventListener)this.listeners.get(v1)).onPlaylistChanged();
        }
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void refreshPlaylist(Uri uri0) {
        ((MediaPlaylistBundle)this.playlistBundles.get(uri0)).loadPlaylist();
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void removeListener(PlaylistEventListener hlsPlaylistTracker$PlaylistEventListener0) {
        this.listeners.remove(hlsPlaylistTracker$PlaylistEventListener0);
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void start(Uri uri0, EventDispatcher mediaSourceEventListener$EventDispatcher0, PrimaryPlaylistListener hlsPlaylistTracker$PrimaryPlaylistListener0) {
        this.playlistRefreshHandler = new Handler();
        this.eventDispatcher = mediaSourceEventListener$EventDispatcher0;
        this.primaryPlaylistListener = hlsPlaylistTracker$PrimaryPlaylistListener0;
        ParsingLoadable parsingLoadable0 = new ParsingLoadable(this.dataSourceFactory.createDataSource(4), uri0, 4, this.playlistParserFactory.createPlaylistParser());
        Assertions.checkState(this.initialPlaylistLoader == null);
        Loader loader0 = new Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.initialPlaylistLoader = loader0;
        long v = loader0.startLoading(parsingLoadable0, this, this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(parsingLoadable0.type));
        mediaSourceEventListener$EventDispatcher0.loadStarted(parsingLoadable0.dataSpec, parsingLoadable0.type, v);
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.primaryMediaPlaylistUrl = null;
        this.primaryMediaPlaylistSnapshot = null;
        this.masterPlaylist = null;
        this.initialStartTimeUs = 0x8000000000000001L;
        this.initialPlaylistLoader.release();
        this.initialPlaylistLoader = null;
        for(Object object0: this.playlistBundles.values()) {
            ((MediaPlaylistBundle)object0).release();
        }
        this.playlistRefreshHandler.removeCallbacksAndMessages(null);
        this.playlistRefreshHandler = null;
        this.playlistBundles.clear();
    }
}

