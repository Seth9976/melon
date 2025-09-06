package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.MyMusicLyricListLyricHighlightRes.RESPONSE.LYRICHIGHLIGHTLIST;

public final class k implements View.OnClickListener {
    public final int a;
    public final LYRICHIGHLIGHTLIST b;

    public k(LYRICHIGHLIGHTLIST myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0, int v) {
        this.a = v;
        this.b = myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                DetailContentsLyricHighlightItemHolder.bind$lambda$2(this.b, view0);
                return;
            }
            case 1: {
                DetailContentsLyricHighlightItemHolder.bind$lambda$3(this.b, view0);
                return;
            }
            case 2: {
                DetailContentsLyricHighlightItemHolder.bind$lambda$4(this.b, view0);
                return;
            }
            case 3: {
                DetailContentsLyricHighlightItemHolder.bind$lambda$5(this.b, view0);
                return;
            }
            default: {
                DetailContentsLyricHighlightItemHolder.bind$lambda$6(this.b, view0);
            }
        }
    }
}

