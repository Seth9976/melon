package com.iloen.melon.viewholders;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.common.TagInfoBase;

public final class f implements View.OnClickListener {
    public final TagInfoBase a;
    public final DjPlaylistNewHolderImpl b;

    public f(DjPlaylistNewHolderImpl djPlaylistNewHolderImpl0, TagInfoBase tagInfoBase0) {
        this.b = djPlaylistNewHolderImpl0;
        this.a = tagInfoBase0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        DjPlaylistNewHolderImpl djPlaylistNewHolderImpl0 = this.b;
        if(djPlaylistNewHolderImpl0.mOnClickListener != null) {
            djPlaylistNewHolderImpl0.mOnClickListener.clickTag1(this.a.tagSeq);
        }
    }
}

