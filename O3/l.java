package o3;

import android.media.MediaCodec.CodecException;
import i.n.i.b.a.s.e.pd;

public class l extends pd {
    public final int a;

    public l(IllegalStateException illegalStateException0, m m0) {
        super("Decoder failed: " + (m0 == null ? null : m0.a), illegalStateException0);
        if(illegalStateException0 instanceof MediaCodec.CodecException) {
            ((MediaCodec.CodecException)illegalStateException0).getDiagnosticInfo();
        }
        this.a = illegalStateException0 instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException)illegalStateException0).getErrorCode() : 0;
    }
}

