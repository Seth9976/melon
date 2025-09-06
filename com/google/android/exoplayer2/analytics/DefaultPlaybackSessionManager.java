package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public final class DefaultPlaybackSessionManager implements PlaybackSessionManager {
    final class SessionDescriptor {
        private MediaPeriodId adMediaPeriodId;
        private boolean isActive;
        private boolean isCreated;
        private final String sessionId;
        private int windowIndex;
        private long windowSequenceNumber;

        public SessionDescriptor(String s, int v, MediaPeriodId mediaSource$MediaPeriodId0) {
            this.sessionId = s;
            this.windowIndex = v;
            this.windowSequenceNumber = mediaSource$MediaPeriodId0 == null ? -1L : mediaSource$MediaPeriodId0.windowSequenceNumber;
            if(mediaSource$MediaPeriodId0 != null && mediaSource$MediaPeriodId0.isAd()) {
                this.adMediaPeriodId = mediaSource$MediaPeriodId0;
            }
        }

        public static int access$200(SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor0) {
            return defaultPlaybackSessionManager$SessionDescriptor0.windowIndex;
        }

        public static boolean access$300(SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor0) {
            return defaultPlaybackSessionManager$SessionDescriptor0.isCreated;
        }

        public static boolean access$302(SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor0, boolean z) {
            defaultPlaybackSessionManager$SessionDescriptor0.isCreated = z;
            return z;
        }

        public static boolean access$400(SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor0) {
            return defaultPlaybackSessionManager$SessionDescriptor0.isActive;
        }

        public static boolean access$402(SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor0, boolean z) {
            defaultPlaybackSessionManager$SessionDescriptor0.isActive = z;
            return z;
        }

        public static MediaPeriodId access$500(SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor0) {
            return defaultPlaybackSessionManager$SessionDescriptor0.adMediaPeriodId;
        }

        public boolean belongsToSession(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
            if(mediaSource$MediaPeriodId0 == null) {
                return v == this.windowIndex;
            }
            return this.adMediaPeriodId == null ? !mediaSource$MediaPeriodId0.isAd() && mediaSource$MediaPeriodId0.windowSequenceNumber == this.windowSequenceNumber : mediaSource$MediaPeriodId0.windowSequenceNumber == this.adMediaPeriodId.windowSequenceNumber && mediaSource$MediaPeriodId0.adGroupIndex == this.adMediaPeriodId.adGroupIndex && mediaSource$MediaPeriodId0.adIndexInAdGroup == this.adMediaPeriodId.adIndexInAdGroup;
        }

        public boolean isFinishedAtEventTime(EventTime analyticsListener$EventTime0) {
            long v = this.windowSequenceNumber;
            if(Long.compare(v, -1L) == 0) {
                return false;
            }
            MediaPeriodId mediaSource$MediaPeriodId0 = analyticsListener$EventTime0.mediaPeriodId;
            if(mediaSource$MediaPeriodId0 == null) {
                return this.windowIndex != analyticsListener$EventTime0.windowIndex;
            }
            if(mediaSource$MediaPeriodId0.windowSequenceNumber > v) {
                return true;
            }
            if(this.adMediaPeriodId == null) {
                return false;
            }
            int v1 = analyticsListener$EventTime0.timeline.getIndexOfPeriod(mediaSource$MediaPeriodId0.periodUid);
            int v2 = analyticsListener$EventTime0.timeline.getIndexOfPeriod(this.adMediaPeriodId.periodUid);
            MediaPeriodId mediaSource$MediaPeriodId1 = analyticsListener$EventTime0.mediaPeriodId;
            if(mediaSource$MediaPeriodId1.windowSequenceNumber >= this.adMediaPeriodId.windowSequenceNumber && v1 >= v2) {
                if(v1 > v2) {
                    return true;
                }
                if(mediaSource$MediaPeriodId1.isAd()) {
                    int v3 = analyticsListener$EventTime0.mediaPeriodId.adGroupIndex;
                    int v4 = this.adMediaPeriodId.adGroupIndex;
                    return v3 > v4 || v3 == v4 && analyticsListener$EventTime0.mediaPeriodId.adIndexInAdGroup > this.adMediaPeriodId.adIndexInAdGroup;
                }
                int v5 = analyticsListener$EventTime0.mediaPeriodId.nextAdGroupIndex;
                return v5 == -1 || v5 > this.adMediaPeriodId.adGroupIndex;
            }
            return false;
        }

        public void maybeSetWindowSequenceNumber(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
            if(this.windowSequenceNumber == -1L && v == this.windowIndex && mediaSource$MediaPeriodId0 != null) {
                this.windowSequenceNumber = mediaSource$MediaPeriodId0.windowSequenceNumber;
            }
        }

        private int resolveWindowIndexToNewTimeline(Timeline timeline0, Timeline timeline1, int v) {
            if(v >= timeline0.getWindowCount()) {
                return v >= timeline1.getWindowCount() ? -1 : v;
            }
            timeline0.getWindow(v, DefaultPlaybackSessionManager.this.window);
            for(int v1 = DefaultPlaybackSessionManager.this.window.firstPeriodIndex; v1 <= DefaultPlaybackSessionManager.this.window.lastPeriodIndex; ++v1) {
                int v2 = timeline1.getIndexOfPeriod(timeline0.getUidOfPeriod(v1));
                if(v2 != -1) {
                    return timeline1.getPeriod(v2, DefaultPlaybackSessionManager.this.period).windowIndex;
                }
            }
            return -1;
        }

        public boolean tryResolvingToNewTimeline(Timeline timeline0, Timeline timeline1) {
            int v = this.resolveWindowIndexToNewTimeline(timeline0, timeline1, this.windowIndex);
            this.windowIndex = v;
            if(v == -1) {
                return false;
            }
            return this.adMediaPeriodId == null ? true : timeline1.getIndexOfPeriod(this.adMediaPeriodId.periodUid) != -1;
        }
    }

    private static final Random RANDOM = null;
    private static final int SESSION_ID_LENGTH = 12;
    private String currentSessionId;
    private Timeline currentTimeline;
    private Listener listener;
    private final Period period;
    private final HashMap sessions;
    private final Window window;

    static {
        DefaultPlaybackSessionManager.RANDOM = new Random();
    }

    public DefaultPlaybackSessionManager() {
        this.window = new Window();
        this.period = new Period();
        this.sessions = new HashMap();
        this.currentTimeline = Timeline.EMPTY;
    }

    @Override  // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public boolean belongsToSession(EventTime analyticsListener$EventTime0, String s) {
        synchronized(this) {
            SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor0 = (SessionDescriptor)this.sessions.get(s);
            if(defaultPlaybackSessionManager$SessionDescriptor0 == null) {
                return false;
            }
            defaultPlaybackSessionManager$SessionDescriptor0.maybeSetWindowSequenceNumber(analyticsListener$EventTime0.windowIndex, analyticsListener$EventTime0.mediaPeriodId);
            return defaultPlaybackSessionManager$SessionDescriptor0.belongsToSession(analyticsListener$EventTime0.windowIndex, analyticsListener$EventTime0.mediaPeriodId);
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public void finishAllSessions(EventTime analyticsListener$EventTime0) {
        this.currentSessionId = null;
        Iterator iterator0 = this.sessions.values().iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor0 = (SessionDescriptor)object0;
            iterator0.remove();
            if(SessionDescriptor.access$300(defaultPlaybackSessionManager$SessionDescriptor0)) {
                Listener playbackSessionManager$Listener0 = this.listener;
                if(playbackSessionManager$Listener0 != null) {
                    playbackSessionManager$Listener0.onSessionFinished(analyticsListener$EventTime0, SessionDescriptor.access$000(defaultPlaybackSessionManager$SessionDescriptor0), false);
                }
            }
        }
    }

    private static String generateSessionId() [...] // 潜在的解密器

    private SessionDescriptor getOrAddSession(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
        SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor0 = null;
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        for(Object object0: this.sessions.values()) {
            SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor1 = (SessionDescriptor)object0;
            defaultPlaybackSessionManager$SessionDescriptor1.maybeSetWindowSequenceNumber(v, mediaSource$MediaPeriodId0);
            if(defaultPlaybackSessionManager$SessionDescriptor1.belongsToSession(v, mediaSource$MediaPeriodId0)) {
                long v2 = defaultPlaybackSessionManager$SessionDescriptor1.windowSequenceNumber;
                if(v2 != -1L) {
                    int v3 = Long.compare(v2, v1);
                    if(v3 >= 0) {
                        if(v3 != 0 || SessionDescriptor.access$500(defaultPlaybackSessionManager$SessionDescriptor0) == null || SessionDescriptor.access$500(defaultPlaybackSessionManager$SessionDescriptor1) == null) {
                            continue;
                        }
                        defaultPlaybackSessionManager$SessionDescriptor0 = defaultPlaybackSessionManager$SessionDescriptor1;
                        continue;
                    }
                }
                defaultPlaybackSessionManager$SessionDescriptor0 = defaultPlaybackSessionManager$SessionDescriptor1;
                v1 = v2;
            }
        }
        if(defaultPlaybackSessionManager$SessionDescriptor0 == null) {
            defaultPlaybackSessionManager$SessionDescriptor0 = new SessionDescriptor(this, "Jkrri7KBHvD7ciuy", v, mediaSource$MediaPeriodId0);
            this.sessions.put("Jkrri7KBHvD7ciuy", defaultPlaybackSessionManager$SessionDescriptor0);
        }
        return defaultPlaybackSessionManager$SessionDescriptor0;
    }

    @Override  // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public String getSessionForMediaPeriodId(Timeline timeline0, MediaPeriodId mediaSource$MediaPeriodId0) {
        synchronized(this) {
            return SessionDescriptor.access$000(this.getOrAddSession(timeline0.getPeriodByUid(mediaSource$MediaPeriodId0.periodUid, this.period).windowIndex, mediaSource$MediaPeriodId0));
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public void handlePositionDiscontinuity(EventTime analyticsListener$EventTime0, int v) {
        synchronized(this) {
            Assertions.checkNotNull(this.listener);
            Iterator iterator0 = this.sessions.values().iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor0 = (SessionDescriptor)object0;
                if(defaultPlaybackSessionManager$SessionDescriptor0.isFinishedAtEventTime(analyticsListener$EventTime0)) {
                    iterator0.remove();
                    if(SessionDescriptor.access$300(defaultPlaybackSessionManager$SessionDescriptor0)) {
                        boolean z = defaultPlaybackSessionManager$SessionDescriptor0.sessionId.equals(this.currentSessionId);
                        boolean z1 = (v == 0 || v == 3) && z && SessionDescriptor.access$400(defaultPlaybackSessionManager$SessionDescriptor0);
                        if(z) {
                            this.currentSessionId = null;
                        }
                        this.listener.onSessionFinished(analyticsListener$EventTime0, defaultPlaybackSessionManager$SessionDescriptor0.sessionId, z1);
                    }
                }
            }
            SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor1 = (SessionDescriptor)this.sessions.get(this.currentSessionId);
            SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor2 = this.getOrAddSession(analyticsListener$EventTime0.windowIndex, analyticsListener$EventTime0.mediaPeriodId);
            this.currentSessionId = defaultPlaybackSessionManager$SessionDescriptor2.sessionId;
            if(analyticsListener$EventTime0.mediaPeriodId != null && analyticsListener$EventTime0.mediaPeriodId.isAd() && (defaultPlaybackSessionManager$SessionDescriptor1 == null || defaultPlaybackSessionManager$SessionDescriptor1.windowSequenceNumber != analyticsListener$EventTime0.mediaPeriodId.windowSequenceNumber || SessionDescriptor.access$500(defaultPlaybackSessionManager$SessionDescriptor1) == null || SessionDescriptor.access$500(defaultPlaybackSessionManager$SessionDescriptor1).adGroupIndex != analyticsListener$EventTime0.mediaPeriodId.adGroupIndex || SessionDescriptor.access$500(defaultPlaybackSessionManager$SessionDescriptor1).adIndexInAdGroup != analyticsListener$EventTime0.mediaPeriodId.adIndexInAdGroup)) {
                MediaPeriodId mediaSource$MediaPeriodId0 = new MediaPeriodId(analyticsListener$EventTime0.mediaPeriodId.periodUid, analyticsListener$EventTime0.mediaPeriodId.windowSequenceNumber);
                SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor3 = this.getOrAddSession(analyticsListener$EventTime0.windowIndex, mediaSource$MediaPeriodId0);
                if(SessionDescriptor.access$300(defaultPlaybackSessionManager$SessionDescriptor3) && SessionDescriptor.access$300(defaultPlaybackSessionManager$SessionDescriptor2)) {
                    this.listener.onAdPlaybackStarted(analyticsListener$EventTime0, defaultPlaybackSessionManager$SessionDescriptor3.sessionId, defaultPlaybackSessionManager$SessionDescriptor2.sessionId);
                }
            }
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public void handleTimelineUpdate(EventTime analyticsListener$EventTime0) {
        synchronized(this) {
            Assertions.checkNotNull(this.listener);
            Timeline timeline0 = this.currentTimeline;
            this.currentTimeline = analyticsListener$EventTime0.timeline;
            Iterator iterator0 = this.sessions.values().iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor0 = (SessionDescriptor)object0;
                if(!defaultPlaybackSessionManager$SessionDescriptor0.tryResolvingToNewTimeline(timeline0, this.currentTimeline)) {
                    iterator0.remove();
                    if(SessionDescriptor.access$300(defaultPlaybackSessionManager$SessionDescriptor0)) {
                        if(SessionDescriptor.access$000(defaultPlaybackSessionManager$SessionDescriptor0).equals(this.currentSessionId)) {
                            this.currentSessionId = null;
                        }
                        this.listener.onSessionFinished(analyticsListener$EventTime0, SessionDescriptor.access$000(defaultPlaybackSessionManager$SessionDescriptor0), false);
                    }
                }
            }
            this.handlePositionDiscontinuity(analyticsListener$EventTime0, 4);
        }
    }

    @Override  // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public void setListener(Listener playbackSessionManager$Listener0) {
        this.listener = playbackSessionManager$Listener0;
    }

    @Override  // com.google.android.exoplayer2.analytics.PlaybackSessionManager
    public void updateSessions(EventTime analyticsListener$EventTime0) {
        synchronized(this) {
            Assertions.checkNotNull(this.listener);
            SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor0 = (SessionDescriptor)this.sessions.get(this.currentSessionId);
            if(analyticsListener$EventTime0.mediaPeriodId != null && defaultPlaybackSessionManager$SessionDescriptor0 != null) {
                if(defaultPlaybackSessionManager$SessionDescriptor0.windowSequenceNumber != -1L) {
                    if(analyticsListener$EventTime0.mediaPeriodId.windowSequenceNumber < defaultPlaybackSessionManager$SessionDescriptor0.windowSequenceNumber) {
                        return;
                    }
                }
                else if(SessionDescriptor.access$200(defaultPlaybackSessionManager$SessionDescriptor0) != analyticsListener$EventTime0.windowIndex) {
                    return;
                }
            }
            SessionDescriptor defaultPlaybackSessionManager$SessionDescriptor1 = this.getOrAddSession(analyticsListener$EventTime0.windowIndex, analyticsListener$EventTime0.mediaPeriodId);
            if(this.currentSessionId == null) {
                this.currentSessionId = defaultPlaybackSessionManager$SessionDescriptor1.sessionId;
            }
            if(!SessionDescriptor.access$300(defaultPlaybackSessionManager$SessionDescriptor1)) {
                SessionDescriptor.access$302(defaultPlaybackSessionManager$SessionDescriptor1, true);
                this.listener.onSessionCreated(analyticsListener$EventTime0, defaultPlaybackSessionManager$SessionDescriptor1.sessionId);
            }
            if(defaultPlaybackSessionManager$SessionDescriptor1.sessionId.equals(this.currentSessionId) && !SessionDescriptor.access$400(defaultPlaybackSessionManager$SessionDescriptor1)) {
                SessionDescriptor.access$402(defaultPlaybackSessionManager$SessionDescriptor1, true);
                this.listener.onSessionActive(analyticsListener$EventTime0, defaultPlaybackSessionManager$SessionDescriptor1.sessionId);
            }
        }
    }
}

