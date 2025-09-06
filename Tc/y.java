package tc;

import com.iloen.melon.net.v5x.response.CastDetailRes.CAST;
import com.iloen.melon.net.v5x.response.CastDetailRes.PROGRAM;
import com.iloen.melon.net.v5x.response.CastDetailRes.RESPONSE;
import com.melon.playlist.station.CastData;
import kotlin.jvm.internal.q;

public abstract class y {
    public static final CastData a(RESPONSE castDetailRes$RESPONSE0) {
        String s;
        q.g(castDetailRes$RESPONSE0, "<this>");
        CAST castDetailRes$CAST0 = castDetailRes$RESPONSE0.cast;
        if(castDetailRes$CAST0 == null) {
            s = "";
        }
        else {
            s = castDetailRes$CAST0.castSeq;
            if(s == null) {
                s = "";
            }
        }
        PROGRAM castDetailRes$PROGRAM0 = castDetailRes$RESPONSE0.program;
        String s1 = castDetailRes$RESPONSE0.bbsChannelSeq == null ? "" : castDetailRes$RESPONSE0.bbsChannelSeq;
        return castDetailRes$RESPONSE0.bbsContsId == null ? new CastData(s, castDetailRes$CAST0, castDetailRes$PROGRAM0, s1, "") : new CastData(s, castDetailRes$CAST0, castDetailRes$PROGRAM0, s1, castDetailRes$RESPONSE0.bbsContsId);
    }
}

