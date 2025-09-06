package com.google.android.exoplayer2.drm;

import java.util.UUID;

public final class c implements Provider {
    @Override  // com.google.android.exoplayer2.drm.ExoMediaDrm$Provider
    public final ExoMediaDrm acquireExoMediaDrm(UUID uUID0) {
        return FrameworkMediaDrm.lambda$static$0(uUID0);
    }
}

