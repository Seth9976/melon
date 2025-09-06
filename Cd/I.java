package cd;

import X0.u;
import X0.x;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS;
import ie.H;
import java.util.Arrays;
import kotlin.jvm.internal.q;
import we.k;

public final class i implements k {
    public final int a;
    public final CONTENTS b;

    public i(CONTENTS mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0, int v) {
        this.a = v;
        this.b = mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((x)object0), "$this$semantics");
            u.h(((x)object0), String.format("", Arrays.copyOf(new Object[]{ProtocolUtils.getArtistNames(this.b.artistList)}, 1)));
            return H.a;
        }
        q.g(((x)object0), "$this$semantics");
        u.h(((x)object0), String.format("", Arrays.copyOf(new Object[]{this.b.getCurrentRank()}, 1)));
        return H.a;
    }
}

