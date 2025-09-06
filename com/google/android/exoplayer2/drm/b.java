package com.google.android.exoplayer2.drm;

import android.media.MediaDrm.OnKeyStatusChangeListener;
import android.media.MediaDrm;
import java.util.List;

public final class b implements MediaDrm.OnKeyStatusChangeListener {
    public final FrameworkMediaDrm a;
    public final OnKeyStatusChangeListener b;

    public b(FrameworkMediaDrm frameworkMediaDrm0, OnKeyStatusChangeListener exoMediaDrm$OnKeyStatusChangeListener0) {
        this.a = frameworkMediaDrm0;
        this.b = exoMediaDrm$OnKeyStatusChangeListener0;
    }

    @Override  // android.media.MediaDrm$OnKeyStatusChangeListener
    public final void onKeyStatusChange(MediaDrm mediaDrm0, byte[] arr_b, List list0, boolean z) {
        this.a.lambda$setOnKeyStatusChangeListener$2(this.b, mediaDrm0, arr_b, list0, z);
    }
}

