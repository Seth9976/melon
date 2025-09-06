package com.iloen.melon.adapters;

import W5.e;
import android.view.View.OnClickListener;
import android.view.View;
import androidx.fragment.app.I;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonFragmentManager;
import vd.a;
import vd.b;

public final class d implements View.OnClickListener {
    public final int a;
    public final e b;

    public d(int v, e e0) {
        this.a = v;
        this.b = e0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        I i0 = MelonFragmentManager.getInstance().getFragment();
        int v = this.a;
        e e0 = this.b;
        if(i0 instanceof MelonBaseFragment) {
            if(v == 8) {
                ((MelonBaseFragment)i0).showAddToNormalPlaylistPositionSettingPopup(e0);
                return;
            }
            ((MelonBaseFragment)i0).showAddToDjPlaylistPositionSettingPopup(e0);
            return;
        }
        if(i0 != null) {
            b b0 = new b((v == 8 ? a.b : a.c));
            b0.b = e0;
            b0.show(i0.getChildFragmentManager(), "PopupTextListAdapter");
        }
    }
}

