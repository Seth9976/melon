package com.iloen.melon.fragments.melontv.program;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ProgramMoreMvRes.Response.MvList;
import com.melon.net.res.common.AlbumInfoBase;

public final class l implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final AlbumInfoBase c;
    public final Object d;
    public final int e;

    public l(TvProgramMoreAlbumFragment tvProgramMoreAlbumFragment0, AlbumInfoBase albumInfoBase0, TvProgramRelativeAlbumAdapter tvProgramMoreAlbumFragment$TvProgramRelativeAlbumAdapter0, int v) {
        this.a = 1;
        super();
        this.b = tvProgramMoreAlbumFragment0;
        this.c = albumInfoBase0;
        this.d = tvProgramMoreAlbumFragment$TvProgramRelativeAlbumAdapter0;
        this.e = v;
    }

    public l(AlbumInfoBase albumInfoBase0, Object object0, Object object1, int v, int v1) {
        this.a = v1;
        this.c = albumInfoBase0;
        this.b = object0;
        this.d = object1;
        this.e = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                TvProgramRelativeAlbumAdapter.a(((TvProgramMoreAlbumFragment)this.b), this.c, ((TvProgramRelativeAlbumAdapter)this.d), this.e, view0);
                return;
            }
            case 1: {
                TvProgramRelativeAlbumAdapter.onBindViewImpl$lambda$1(((TvProgramMoreAlbumFragment)this.b), this.c, ((TvProgramRelativeAlbumAdapter)this.d), this.e, view0);
                return;
            }
            default: {
                TvProgramMoreVideoAdapter.onBindViewImpl$lambda$0(((MvList)this.c), ((TvProgramMoreVideoAdapter)this.b), ((TvProgramMoreVideoFragment)this.d), this.e, view0);
            }
        }
    }
}

