package com.iloen.melon.fragments.local;

import a9.d;
import android.view.View;
import com.iloen.melon.custom.J;
import com.iloen.melon.custom.K;
import com.iloen.melon.custom.S;

public final class e implements d, J, K {
    public final int a;
    public final LocalContentAllSongFragment b;

    public e(LocalContentAllSongFragment localContentAllSongFragment0, int v) {
        this.a = v;
        this.b = localContentAllSongFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.J
    public void a(S s0, boolean z) {
        if(this.a != 1) {
            LocalContentAllSongFragment.setAllCheckButtonVisibility$lambda$6$lambda$3(this.b, s0, z);
            return;
        }
        LocalContentAllSongFragment.setEditModeVisibility$lambda$8(this.b, s0, z);
    }

    @Override  // com.iloen.melon.custom.K
    public void onClick(View view0) {
        switch(this.a) {
            case 0: {
                LocalContentAllSongFragment.setEditModeVisibility$lambda$7(this.b, view0);
                return;
            }
            case 2: {
                LocalContentAllSongFragment.setEditModeVisibility$lambda$10(this.b, view0);
                return;
            }
            case 4: {
                LocalContentAllSongFragment.setAllCheckButtonVisibility$lambda$2(this.b, view0);
                return;
            }
            default: {
                LocalContentAllSongFragment.setAllCheckButtonVisibility$lambda$6$lambda$5(this.b, view0);
            }
        }
    }

    @Override  // a9.d
    public void onSelected(int v) {
        LocalContentAllSongFragment.onViewCreated$lambda$1$lambda$0(this.b, v);
    }
}

