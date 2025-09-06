package com.iloen.melon.fragments.mymusic;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import com.iloen.melon.fragments.MetaContentBaseFragment;

public final class m implements DialogInterface.OnClickListener {
    public final int a;
    public final MetaContentBaseFragment b;

    public m(MetaContentBaseFragment metaContentBaseFragment0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        if(this.a != 0) {
            SeriesPlaylistMakeFragment.initTitleBar$lambda$4$lambda$3$lambda$2(((SeriesPlaylistMakeFragment)this.b), dialogInterface0, v);
            return;
        }
        MemberProfileEditFragment.showCleanPopUp$lambda$2(((MemberProfileEditFragment)this.b), dialogInterface0, v);
    }
}

