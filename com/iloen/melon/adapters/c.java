package com.iloen.melon.adapters;

import android.view.View.OnClickListener;
import android.view.View;
import androidx.fragment.app.I;
import androidx.media3.session.H0;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonFragmentManager;
import vd.a;
import vd.b;

public final class c implements View.OnClickListener {
    public final H0 a;

    public c(H0 h00) {
        this.a = h00;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        I i0 = MelonFragmentManager.getInstance().getFragment();
        H0 h00 = this.a;
        if(i0 instanceof MelonBaseFragment) {
            ((MelonBaseFragment)i0).showAddPositionSettingPopup(h00);
            return;
        }
        if(i0 != null) {
            b b0 = new b(a.a);
            b0.b = h00;
            b0.show(i0.getChildFragmentManager(), "PopupTextListAdapter");
        }
    }
}

