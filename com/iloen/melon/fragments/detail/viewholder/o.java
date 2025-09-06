package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.common.TopicInfoBase;

public final class o implements View.OnClickListener {
    public final int a;
    public final DetailContentsTopicItemHolder b;
    public final TopicInfoBase c;
    public final int d;

    public o(DetailContentsTopicItemHolder detailContentsTopicItemHolder0, TopicInfoBase topicInfoBase0, int v, int v1) {
        this.a = v1;
        this.b = detailContentsTopicItemHolder0;
        this.c = topicInfoBase0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                DetailContentsTopicItemHolder.bind$lambda$3(this.b, this.c, this.d, view0);
                return;
            }
            case 1: {
                DetailContentsTopicItemHolder.bind$lambda$4(this.b, this.c, this.d, view0);
                return;
            }
            default: {
                DetailContentsTopicItemHolder.bind$lambda$7$lambda$6(this.b, this.c, this.d, view0);
            }
        }
    }
}

