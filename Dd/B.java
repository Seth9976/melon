package dd;

import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.HEADER;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.THEME;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import we.a;

public final class b implements a {
    public final int a;
    public final HEADER b;
    public final THEME c;
    public final c d;
    public final int e;

    public b(HEADER mainMusicRes$RESPONSE$HEADER0, THEME mainMusicRes$RESPONSE$THEME0, c c0, int v, int v1) {
        this.a = v1;
        this.b = mainMusicRes$RESPONSE$HEADER0;
        this.c = mainMusicRes$RESPONSE$THEME0;
        this.d = c0;
        this.e = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            HEADER mainMusicRes$RESPONSE$HEADER0 = this.b;
            if(mainMusicRes$RESPONSE$HEADER0.isLinkable()) {
                H.o(this.d, "", null, "", this.c.getStatsElements(), this.e, 0x9E);
                MelonLinkExecutor.open(MelonLinkInfo.b(mainMusicRes$RESPONSE$HEADER0));
            }
            return ie.H.a;
        }
        HEADER mainMusicRes$RESPONSE$HEADER1 = this.b;
        if(mainMusicRes$RESPONSE$HEADER1.isLinkable()) {
            H.o(this.d, "", null, "", this.c.getStatsElements(), this.e, 0x9E);
            MelonLinkExecutor.open(MelonLinkInfo.b(mainMusicRes$RESPONSE$HEADER1));
        }
        return ie.H.a;
    }
}

