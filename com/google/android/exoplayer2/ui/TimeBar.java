package com.google.android.exoplayer2.ui;

public interface TimeBar {
    public interface OnScrubListener {
        void onScrubMove(TimeBar arg1, long arg2);

        void onScrubStart(TimeBar arg1, long arg2);

        void onScrubStop(TimeBar arg1, long arg2, boolean arg3);
    }

    void addListener(OnScrubListener arg1);

    long getPreferredUpdateDelay();

    void removeListener(OnScrubListener arg1);

    void setAdGroupTimesMs(long[] arg1, boolean[] arg2, int arg3);

    void setBufferedPosition(long arg1);

    void setDuration(long arg1);

    void setEnabled(boolean arg1);

    void setKeyCountIncrement(int arg1);

    void setKeyTimeIncrement(long arg1);

    void setPosition(long arg1);
}

