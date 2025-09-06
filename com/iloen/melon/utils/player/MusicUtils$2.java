package com.iloen.melon.utils.player;

import android.app.RecoverableSecurityException;
import b3.Z;
import e9.a;

class MusicUtils.2 implements a {
    @Override  // e9.a
    public void onRemoveComplete(int v, Object object0) {
        Z.r(v, "cleanupJunkData - nResult: ", "MusicUtils");
    }

    @Override  // e9.a
    public void onThrowRecoverableSecurityException(RecoverableSecurityException recoverableSecurityException0) {
    }
}

