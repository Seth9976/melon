package com.iloen.melon.drm;

import U4.x;
import com.iloen.melon.utils.log.LogU;

public class DcfFile extends MelonFile {
    public long i;
    private static final long serialVersionUID = 0x262CEFE8B8A51FAAL;

    public final void g(long v) {
        LogU.d("DcfFile", "setErrorCode:" + v);
        this.i = v;
    }

    @Override  // com.iloen.melon.drm.MelonFile
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DcfFile [expiryYYMMDD=null, errorCode=");
        stringBuilder0.append(this.i);
        return x.m(stringBuilder0, super.toString(), "]");
    }
}

