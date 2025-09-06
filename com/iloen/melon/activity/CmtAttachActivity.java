package com.iloen.melon.activity;

import androidx.fragment.app.I;
import b.a;
import com.iloen.melon.fragments.comments.CmtAttachFragment.Param;
import com.iloen.melon.fragments.comments.CmtAttachFragment;
import com.iloen.melon.fragments.comments.CmtAttachTabFragment;
import com.iloen.melon.fragments.comments.CmtLinkVideoAttachFragment;
import com.iloen.melon.utils.system.CompatUtils;

public class CmtAttachActivity extends PopupFragmentActivity {
    public static final String ARG_CMT_ATTACH_TYPE = "argCmtAttachType";

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public I getAddFragment() {
        Param cmtAttachFragment$Param0 = (Param)CompatUtils.getSerializableExtra(this.getIntent(), "argCmtParam", Param.class);
        if(cmtAttachFragment$Param0 != null) {
            switch(cmtAttachFragment$Param0.viewType) {
                case 1: {
                    return CmtAttachFragment.newInstance(cmtAttachFragment$Param0);
                }
                case 2: {
                    return CmtLinkVideoAttachFragment.newInstance(cmtAttachFragment$Param0);
                }
                default: {
                    return CmtAttachTabFragment.newInstance(cmtAttachFragment$Param0);
                }
            }
        }
        return null;
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeCancelled() {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeCommitted(I i0, boolean z) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeProgressed(a a0) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeStarted(I i0, boolean z) {
    }
}

