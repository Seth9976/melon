package com.iloen.melon.fragments.melontv;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST.MVLIST;

public final class a implements View.OnClickListener {
    public final int a;
    public final MelonTvLikedAdapter b;
    public final MVLIST c;

    public a(MelonTvLikedAdapter melonTvLikedFragment$MelonTvLikedAdapter0, MVLIST melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0, int v) {
        this.a = v;
        this.b = melonTvLikedFragment$MelonTvLikedAdapter0;
        this.c = melonTvLikedProgramRes$RESPONSE$CONTENTSLIST$MVLIST0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                this.b.lambda$onBindViewImpl$1(this.c, view0);
                return;
            }
            case 1: {
                this.b.lambda$onBindViewImpl$2(this.c, view0);
                return;
            }
            case 2: {
                this.b.lambda$onBindViewImpl$3(this.c, view0);
                return;
            }
            case 3: {
                this.b.lambda$onBindViewImpl$4(this.c, view0);
                return;
            }
            case 4: {
                this.b.lambda$onBindViewImpl$5(this.c, view0);
                return;
            }
            case 5: {
                this.b.lambda$onBindViewImpl$6(this.c, view0);
                return;
            }
            case 6: {
                this.b.lambda$onBindViewImpl$7(this.c, view0);
                return;
            }
            default: {
                this.b.lambda$onBindViewImpl$8(this.c, view0);
            }
        }
    }
}

