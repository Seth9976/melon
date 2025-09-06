package com.iloen.melon.viewholders;

import android.view.View.OnClickListener;
import android.view.View;
import com.melon.net.res.common.DjPlayListInfoBase;

public final class e implements View.OnClickListener {
    public final DjPlayListInfoBase a;
    public final DjPlaylistNewHolderImpl b;

    public e(DjPlaylistNewHolderImpl djPlaylistNewHolderImpl0, DjPlayListInfoBase djPlayListInfoBase0) {
        this.b = djPlaylistNewHolderImpl0;
        this.a = djPlayListInfoBase0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        DjPlaylistNewHolderImpl djPlaylistNewHolderImpl0 = this.b;
        if(djPlaylistNewHolderImpl0.mOnMoreClickListener != null) {
            djPlaylistNewHolderImpl0.mOnMoreClickListener.b(this.a);
        }
    }
}

