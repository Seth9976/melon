package com.iloen.melon.fragments.local;

import androidx.activity.result.ActivityResult;
import com.iloen.melon.custom.J;
import com.iloen.melon.custom.S;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.popup.ContextListPopup.OnMenuItemClickListener;
import com.iloen.melon.types.ContextItemInfo.Params;
import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.ContextItemType;
import e.a;

public final class p implements J, OnMenuItemClickListener, a {
    public final int a;
    public final MetaContentBaseFragment b;

    public p(MetaContentBaseFragment metaContentBaseFragment0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        super();
    }

    @Override  // com.iloen.melon.custom.J
    public void a(S s0, boolean z) {
        LocalPlaylistDetailEditFragment.setAllCheckButtonVisibility$lambda$4(((LocalPlaylistDetailEditFragment)this.b), s0, z);
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        if(this.a != 0) {
            LocalContentNewDbBaseFragment.activityResult$lambda$0(((LocalContentNewDbBaseFragment)this.b), ((ActivityResult)object0));
            return;
        }
        LocalContentListFragment.activityResult$lambda$0(((LocalContentListFragment)this.b), ((ActivityResult)object0));
    }

    @Override  // com.iloen.melon.popup.ContextListPopup$OnMenuItemClickListener
    public void onItemClick(ContextItemInfo contextItemInfo0, ContextItemType contextItemType0, Params contextItemInfo$Params0) {
        LocalFolderListFragment.showContextListPopup$lambda$2(((LocalFolderListFragment)this.b), contextItemInfo0, contextItemType0, contextItemInfo$Params0);
    }
}

