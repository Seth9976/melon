package com.iloen.melon.fragments.artistchannel.topic;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes.RESPONSE.TOPICCONTENTSLIST;

public final class c implements View.OnClickListener {
    public final int a;
    public final TopicContentsSongViewHolder b;
    public final TOPICCONTENTSLIST c;

    public c(TopicContentsSongViewHolder topicContentsViewHolder$TopicContentsSongViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, int v) {
        this.a = v;
        this.b = topicContentsViewHolder$TopicContentsSongViewHolder0;
        this.c = artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            TopicContentsSongViewHolder.b(this.b, this.c, view0);
            return;
        }
        TopicContentsSongViewHolder.a(this.b, this.c, view0);
    }
}

