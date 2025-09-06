package B9;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;

public final class p implements View.OnClickListener {
    public final int a;
    public final s b;
    public final ArtistPlayListInfoBase c;
    public final int d;

    public p(s s0, ArtistPlayListInfoBase artistPlayListInfoBase0, int v, int v1) {
        this.a = v1;
        this.b = s0;
        this.c = artistPlayListInfoBase0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                this.b.clickBody(this.c, this.d);
                return;
            }
            case 1: {
                this.b.playPlaylist(this.c, this.d);
                return;
            }
            default: {
                this.b.clickThumbnail(this.c, this.d);
            }
        }
    }
}

