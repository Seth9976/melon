package com.iloen.melon.fragments.comments;

import androidx.activity.result.ActivityResult;
import e.a;

public final class g implements E8.g, a {
    public final CmtBaseFragment a;

    public g(CmtBaseFragment cmtBaseFragment0) {
        this.a = cmtBaseFragment0;
        super();
    }

    @Override  // E8.g
    public void b(int v) {
        CommentListRenewalFragment.initAlyacFilter$lambda$11(((CommentListRenewalFragment)this.a), v);
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        ((CmtWriteFragment)this.a).lambda$new$0(((ActivityResult)object0));
    }
}

