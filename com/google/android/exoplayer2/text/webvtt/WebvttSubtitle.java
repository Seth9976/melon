package com.google.android.exoplayer2.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class WebvttSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final List cues;
    private final int numCues;
    private final long[] sortedCueTimesUs;

    public WebvttSubtitle(List list0) {
        this.cues = list0;
        int v = list0.size();
        this.numCues = v;
        this.cueTimesUs = new long[v * 2];
        for(int v1 = 0; v1 < this.numCues; ++v1) {
            WebvttCue webvttCue0 = (WebvttCue)list0.get(v1);
            this.cueTimesUs[v1 * 2] = webvttCue0.startTime;
            this.cueTimesUs[v1 * 2 + 1] = webvttCue0.endTime;
        }
        long[] arr_v = Arrays.copyOf(this.cueTimesUs, this.cueTimesUs.length);
        this.sortedCueTimesUs = arr_v;
        Arrays.sort(arr_v);
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public List getCues(long v) {
        List list0 = new ArrayList();
        CharSequence charSequence0 = null;
        WebvttCue webvttCue0 = null;
        for(int v1 = 0; v1 < this.numCues; ++v1) {
            if(this.cueTimesUs[v1 * 2] <= v && v < this.cueTimesUs[v1 * 2 + 1]) {
                WebvttCue webvttCue1 = (WebvttCue)this.cues.get(v1);
                if(!webvttCue1.isNormalCue()) {
                    ((ArrayList)list0).add(webvttCue1);
                }
                else if(webvttCue0 == null) {
                    webvttCue0 = webvttCue1;
                }
                else if(charSequence0 == null) {
                    charSequence0 = new SpannableStringBuilder();
                    ((SpannableStringBuilder)charSequence0).append(((CharSequence)Assertions.checkNotNull(webvttCue0.text))).append("\n").append(((CharSequence)Assertions.checkNotNull(webvttCue1.text)));
                }
                else {
                    ((SpannableStringBuilder)charSequence0).append("\n").append(((CharSequence)Assertions.checkNotNull(webvttCue1.text)));
                }
            }
        }
        if(charSequence0 != null) {
            ((ArrayList)list0).add(new Builder().setText(charSequence0).build());
            return list0;
        }
        if(webvttCue0 != null) {
            ((ArrayList)list0).add(webvttCue0);
        }
        return list0;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int v) {
        boolean z = false;
        Assertions.checkArgument(v >= 0);
        if(v < this.sortedCueTimesUs.length) {
            z = true;
        }
        Assertions.checkArgument(z);
        return this.sortedCueTimesUs[v];
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.sortedCueTimesUs.length;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long v) {
        int v1 = Util.binarySearchCeil(this.sortedCueTimesUs, v, false, false);
        return v1 >= this.sortedCueTimesUs.length ? -1 : v1;
    }
}

