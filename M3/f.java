package m3;

import I6.V;
import I6.p0;
import androidx.media3.common.DrmInitData;
import java.util.List;

public final class f extends g {
    public final String l;
    public final V m;

    public f(String s, long v, long v1, String s1, String s2) {
        this(s, null, "", 0L, -1, 0x8000000000000001L, null, s1, s2, v, v1, false, p0.e);
    }

    public f(String s, f f0, String s1, long v, int v1, long v2, DrmInitData drmInitData0, String s2, String s3, long v3, long v4, boolean z, List list0) {
        super(s, f0, v, v1, v2, drmInitData0, s2, s3, v3, v4, z);
        this.l = s1;
        this.m = V.p(list0);
    }
}

