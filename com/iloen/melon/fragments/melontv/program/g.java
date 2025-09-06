package com.iloen.melon.fragments.melontv.program;

import com.iloen.melon.custom.MelonTextView;
import we.k;

public final class g implements k {
    public final MelonTextView a;
    public final NoticeViewHolder b;
    public final Object c;

    public g(MelonTextView melonTextView0, NoticeViewHolder tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0, String s) {
        this.a = melonTextView0;
        this.b = tvProgramHomeFragment$TvProgramHomeAdapter$NoticeViewHolder0;
        this.c = s;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return TvProgramHomeAdapter.b(this.a, this.b, this.c, ((int)(((Integer)object0))));
    }
}

