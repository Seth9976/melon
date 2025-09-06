package B9;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;

public final class n implements View.OnLongClickListener {
    public final int a;
    public final int b;
    public final Object c;
    public final DjPlayListInfoBase d;

    public n(Object object0, DjPlayListInfoBase djPlayListInfoBase0, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.d = djPlayListInfoBase0;
        this.b = v;
        super();
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        return this.a == 0 ? ((t)this.c).longClickBody(this.d, this.b) : ((s)this.c).longClickBody(((ArtistPlayListInfoBase)this.d), this.b);
    }
}

