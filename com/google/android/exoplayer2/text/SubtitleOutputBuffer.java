package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;

public abstract class SubtitleOutputBuffer extends OutputBuffer implements Subtitle {
    private long subsampleOffsetUs;
    private Subtitle subtitle;

    @Override  // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        this.subtitle = null;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public List getCues(long v) {
        return ((Subtitle)Assertions.checkNotNull(this.subtitle)).getCues(v - this.subsampleOffsetUs);
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int v) {
        return ((Subtitle)Assertions.checkNotNull(this.subtitle)).getEventTime(v) + this.subsampleOffsetUs;
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return ((Subtitle)Assertions.checkNotNull(this.subtitle)).getEventTimeCount();
    }

    @Override  // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long v) {
        return ((Subtitle)Assertions.checkNotNull(this.subtitle)).getNextEventTimeIndex(v - this.subsampleOffsetUs);
    }

    @Override  // com.google.android.exoplayer2.decoder.OutputBuffer
    public abstract void release();

    public void setContent(long v, Subtitle subtitle0, long v1) {
        this.timeUs = v;
        this.subtitle = subtitle0;
        if(v1 != 0x7FFFFFFFFFFFFFFFL) {
            v = v1;
        }
        this.subsampleOffsetUs = v;
    }
}

