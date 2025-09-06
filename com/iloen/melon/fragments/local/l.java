package com.iloen.melon.fragments.local;

import android.view.View;
import com.iloen.melon.custom.J;
import com.iloen.melon.custom.K;
import com.iloen.melon.custom.S;

public final class l implements J, K {
    public final int a;
    public final LocalContentBaseUIFragment b;

    public l(LocalContentBaseUIFragment localContentBaseUIFragment0, int v) {
        this.a = v;
        this.b = localContentBaseUIFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.J
    public void a(S s0, boolean z) {
        if(this.a != 1) {
            LocalContentBaseUIFragment.setAllCheckButtonVisibility$lambda$1(this.b, s0, z);
            return;
        }
        LocalContentBaseUIFragment.setEditModeVisibility$lambda$4(this.b, s0, z);
    }

    @Override  // com.iloen.melon.custom.K
    public void onClick(View view0) {
        switch(this.a) {
            case 0: {
                LocalContentBaseUIFragment.setEditModeVisibility$lambda$3(this.b, view0);
                return;
            }
            case 2: {
                LocalContentBaseUIFragment.setEditModeVisibility$lambda$5(this.b, view0);
                return;
            }
            case 3: {
                LocalContentBaseUIFragment.setAllCheckButtonVisibility$lambda$0(this.b, view0);
                return;
            }
            default: {
                LocalContentBaseUIFragment.setAllCheckButtonVisibility$lambda$2(this.b, view0);
            }
        }
    }
}

