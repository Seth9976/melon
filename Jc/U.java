package Jc;

import com.iloen.melon.custom.MediaAttachmentLayout;
import com.iloen.melon.custom.MediaAttachmentView;
import com.iloen.melon.custom.c0;
import com.iloen.melon.types.MediaAttachInfo;
import com.iloen.melon.utils.log.LogU;

public final class u implements c0 {
    public final MediaAttachInfo a;
    public final K b;

    public u(MediaAttachInfo mediaAttachInfo0, K k0) {
        this.a = mediaAttachInfo0;
        this.b = k0;
    }

    @Override  // com.iloen.melon.custom.c0
    public final void onAttachmentBtnClick(MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) {
        this.b.m0.invoke(this.a);
    }

    @Override  // com.iloen.melon.custom.c0
    public final void onAttachmentClick(MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) {
        LogU.Companion.d("DetailCommentHolder", "onAttachmentClick type : " + this.a.a);
        this.b.l0.invoke(this.a);
    }

    @Override  // com.iloen.melon.custom.c0
    public final void onAttachmentImageClick(MediaAttachmentLayout mediaAttachmentLayout0, MediaAttachmentView mediaAttachmentView0) {
        LogU.Companion.d("DetailCommentHolder", "onAttachmentImageClick type : " + this.a.a);
        this.b.l0.invoke(this.a);
    }
}

