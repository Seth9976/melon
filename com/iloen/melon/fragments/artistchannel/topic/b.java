package com.iloen.melon.fragments.artistchannel.topic;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes.RESPONSE.TOPICCONTENTSLIST;
import com.iloen.melon.net.v6x.response.GoscrapKakaoRes;

public final class b implements ErrorListener, Listener {
    public final TOPICCONTENTSLIST a;
    public final TopicContentsLinkViewHolder b;

    public b(TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, TopicContentsLinkViewHolder topicContentsViewHolder$TopicContentsLinkViewHolder0) {
        this.a = artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0;
        this.b = topicContentsViewHolder$TopicContentsLinkViewHolder0;
        super();
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        TopicContentsLinkViewHolder.e(this.a, this.b, volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        TopicContentsLinkViewHolder.bind$lambda$1(this.a, this.b, ((GoscrapKakaoRes)object0));
    }
}

