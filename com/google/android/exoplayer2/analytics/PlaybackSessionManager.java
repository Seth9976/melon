package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;

public interface PlaybackSessionManager {
    public interface Listener {
        void onAdPlaybackStarted(EventTime arg1, String arg2, String arg3);

        void onSessionActive(EventTime arg1, String arg2);

        void onSessionCreated(EventTime arg1, String arg2);

        void onSessionFinished(EventTime arg1, String arg2, boolean arg3);
    }

    boolean belongsToSession(EventTime arg1, String arg2);

    void finishAllSessions(EventTime arg1);

    String getSessionForMediaPeriodId(Timeline arg1, MediaPeriodId arg2);

    void handlePositionDiscontinuity(EventTime arg1, int arg2);

    void handleTimelineUpdate(EventTime arg1);

    void setListener(Listener arg1);

    void updateSessions(EventTime arg1);
}

