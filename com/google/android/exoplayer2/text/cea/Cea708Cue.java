package com.google.android.exoplayer2.text.cea;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.text.Cue;

final class Cea708Cue extends Cue implements Comparable {
    public final int priority;

    public Cea708Cue(CharSequence charSequence0, Layout.Alignment layout$Alignment0, float f, int v, int v1, float f1, int v2, float f2, boolean z, int v3, int v4) {
        super(charSequence0, layout$Alignment0, f, v, v1, f1, v2, f2, z, v3);
        this.priority = v4;
    }

    public int compareTo(Cea708Cue cea708Cue0) {
        int v = cea708Cue0.priority;
        int v1 = this.priority;
        if(v < v1) {
            return -1;
        }
        return v <= v1 ? 0 : 1;
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((Cea708Cue)object0));
    }
}

