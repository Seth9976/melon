package com.iloen.melon.fragments.comments;

import com.iloen.melon.custom.MediaAttachmentLayout;
import com.iloen.melon.custom.MediaAttachmentView;
import we.a;

public final class h implements a {
    public final com.iloen.melon.fragments.comments.CmtWriteFragment.5 a;
    public final MediaAttachmentLayout b;
    public final MediaAttachmentView c;

    public h(com.iloen.melon.fragments.comments.CmtWriteFragment.5 cmtWriteFragment$50, MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) {
        this.a = cmtWriteFragment$50;
        this.b = mediaAttachmentLayout0;
        this.c = mediaAttachmentView0;
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a.lambda$onAttachmentBtnClick$0(this.b, this.c);
    }
}

