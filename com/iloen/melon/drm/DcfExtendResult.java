package com.iloen.melon.drm;

import java.io.Serializable;

public class DcfExtendResult implements Serializable {
    public final DcfFile a;
    public final DcfError b;
    private static final long serialVersionUID = 0xDB9E2AD91428E720L;

    static {
    }

    public DcfExtendResult(DcfFile dcfFile0, DcfError dcfError0) {
        this.a = dcfFile0;
        this.b = dcfError0;
    }

    @Override
    public final String toString() {
        return "DcfExtendResult {file=" + this.a + ", error:" + this.b + "}";
    }
}

