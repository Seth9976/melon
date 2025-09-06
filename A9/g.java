package A9;

import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.RESPONSE;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.SONG;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public abstract class g {
    public static final SONG a(RESPONSE liveTimedMetaSongRes$RESPONSE0) {
        q.g(liveTimedMetaSongRes$RESPONSE0, "<this>");
        ArrayList arrayList0 = liveTimedMetaSongRes$RESPONSE0.songList;
        q.f(arrayList0, "songList");
        for(Object object0: arrayList0) {
            SONG liveTimedMetaSongRes$SONG0 = (SONG)object0;
            if(liveTimedMetaSongRes$SONG0.isPick) {
                return liveTimedMetaSongRes$SONG0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }
}

