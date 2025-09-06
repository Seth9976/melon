package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class BaseTrackSelection implements TrackSelection {
    static final class DecreasingBandwidthComparator implements Comparator {
        private DecreasingBandwidthComparator() {
        }

        public DecreasingBandwidthComparator(com.google.android.exoplayer2.trackselection.BaseTrackSelection.1 baseTrackSelection$10) {
        }

        public int compare(Format format0, Format format1) {
            return format1.bitrate - format0.bitrate;
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((Format)object0), ((Format)object1));
        }
    }

    private final long[] blacklistUntilTimes;
    private final Format[] formats;
    protected final TrackGroup group;
    private int hashCode;
    protected final int length;
    protected final int[] tracks;

    public BaseTrackSelection(TrackGroup trackGroup0, int[] arr_v) {
        Assertions.checkState(arr_v.length > 0);
        int v2;
        this.group = (TrackGroup)Assertions.checkNotNull(trackGroup0);
        this.length = arr_v.length;
        this.formats = new Format[arr_v.length];
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            this.formats[v1] = trackGroup0.getFormat(arr_v[v1]);
        }
        DecreasingBandwidthComparator baseTrackSelection$DecreasingBandwidthComparator0 = new DecreasingBandwidthComparator(null);
        Arrays.sort(this.formats, baseTrackSelection$DecreasingBandwidthComparator0);
        this.tracks = new int[this.length];
        for(int v = 0; true; ++v) {
            v2 = this.length;
            if(v >= v2) {
                break;
            }
            this.tracks[v] = trackGroup0.indexOf(this.formats[v]);
        }
        this.blacklistUntilTimes = new long[v2];
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public final boolean blacklist(int v, long v1) {
        long v2 = SystemClock.elapsedRealtime();
        boolean z = this.isBlacklisted(v, v2);
        for(int v3 = 0; v3 < this.length && !z; ++v3) {
            z = v3 != v && !this.isBlacklisted(v3, v2);
        }
        if(!z) {
            return false;
        }
        this.blacklistUntilTimes[v] = Math.max(this.blacklistUntilTimes[v], Util.addWithOverflowDefault(v2, v1, 0x7FFFFFFFFFFFFFFFL));
        return true;
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public void disable() {
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public void enable() {
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && this.getClass() == object0.getClass() && this.group == ((BaseTrackSelection)object0).group && Arrays.equals(this.tracks, ((BaseTrackSelection)object0).tracks);
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public int evaluateQueueSize(long v, List list0) {
        return list0.size();
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getFormat(int v) {
        return this.formats[v];
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getIndexInTrackGroup(int v) {
        return this.tracks[v];
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public final Format getSelectedFormat() {
        return this.formats[this.getSelectedIndex()];
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int getSelectedIndexInTrackGroup() {
        return this.tracks[this.getSelectedIndex()];
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public final TrackGroup getTrackGroup() {
        return this.group;
    }

    @Override
    public int hashCode() {
        if(this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.tracks) + System.identityHashCode(this.group) * 0x1F;
        }
        return this.hashCode;
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(int v) {
        for(int v1 = 0; v1 < this.length; ++v1) {
            if(this.tracks[v1] == v) {
                return v1;
            }
        }
        return -1;
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int indexOf(Format format0) {
        for(int v = 0; v < this.length; ++v) {
            if(this.formats[v] == format0) {
                return v;
            }
        }
        return -1;
    }

    public final boolean isBlacklisted(int v, long v1) {
        return this.blacklistUntilTimes[v] > v1;
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public final int length() {
        return this.tracks.length;
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
    public void onPlaybackSpeed(float f) {
    }

    class com.google.android.exoplayer2.trackselection.BaseTrackSelection.1 {
    }

}

