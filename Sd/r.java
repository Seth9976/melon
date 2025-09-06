package sd;

import P0.d0;
import com.iloen.melon.playback.Playable;
import ie.H;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;
import q8.a;
import q8.c;
import we.k;

public final class r implements k {
    public final int a;
    public final d0 b;
    public final Playable c;

    public r(d0 d00, Playable playable0, int v) {
        this.a = v;
        this.b = d00;
        this.c = playable0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((c)object0), "$this$customProps");
            LinkedHashMap linkedHashMap0 = ((c)object0).a;
            linkedHashMap0.put("menuid", "1000003234");
            d0 d00 = this.b;
            String s = (String)((x)d00.g).invoke();
            if(s != null) {
                linkedHashMap0.put("recmd_key", s);
            }
            String s1 = (String)((y)d00.h).invoke(this.c);
            if(s1 != null) {
                linkedHashMap0.put("recmd_offer_timestamp", s1);
            }
            return H.a;
        }
        q.g(((a)object0), "$this$click");
        d0 d01 = this.b;
        Playable playable0 = this.c;
        String s2 = (String)((y)d01.e).invoke(playable0);
        if(s2 != null) {
            ((a)object0).h = s2;
        }
        String s3 = (String)((y)d01.f).invoke(playable0);
        if(s3 != null) {
            ((a)object0).i = s3;
        }
        return H.a;
    }
}

