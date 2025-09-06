package B9;

import android.view.View.OnClickListener;
import android.view.View;
import com.melon.net.res.common.DjPlayListInfoBase;

public final class o implements View.OnClickListener {
    public final int a;
    public final t b;
    public final DjPlayListInfoBase c;
    public final int d;

    public o(t t0, DjPlayListInfoBase djPlayListInfoBase0, int v, int v1) {
        this.a = v1;
        this.b = t0;
        this.c = djPlayListInfoBase0;
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
                this.b.playDjPlaylist(this.c, this.d);
                return;
            }
            default: {
                this.b.clickThumbnail(this.c, this.d);
            }
        }
    }
}

