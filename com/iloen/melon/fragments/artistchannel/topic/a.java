package com.iloen.melon.fragments.artistchannel.topic;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes.RESPONSE.TOPICCONTENTSLIST;

public final class a implements View.OnClickListener {
    public final int a;
    public final TopicContentsLinkViewHolder b;
    public final TOPICCONTENTSLIST c;

    public a(TopicContentsLinkViewHolder topicContentsViewHolder$TopicContentsLinkViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, int v) {
        this.a = v;
        this.b = topicContentsViewHolder$TopicContentsLinkViewHolder0;
        this.c = artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                TopicContentsLinkViewHolder.c(this.b, this.c, view0);
                return;
            }
            case 1: {
                TopicContentsLinkViewHolder.b(this.b, this.c, view0);
                return;
            }
            default: {
                TopicContentsLinkViewHolder.d(this.b, this.c, view0);
            }
        }
    }
}

