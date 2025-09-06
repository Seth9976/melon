package com.iloen.melon.fragments.detail;

import Cb.i;
import Cb.j;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v5x.response.MyMusicLikeListContentsLikeRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.net.v5x.response.MyMusicLikeListContentsLikeRes;
import java.util.ArrayList;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u0004\u0018\u00010\u0002H\u0002\u001A\f\u0010\u0003\u001A\u00020\u0001*\u00020\u0004H\u0002\u001A\f\u0010\u0005\u001A\u00020\u0001*\u00020\u0004H\u0002¨\u0006\u0006"}, d2 = {"isValidResponse", "", "Lcom/iloen/melon/net/HttpResponse;", "hasValidData", "Lcom/iloen/melon/net/v5x/response/MyMusicLikeListContentsLikeRes;", "isSubscribeProgram", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class StationEpisodeDetailFragmentKt {
    private static final boolean hasValidData(MyMusicLikeListContentsLikeRes myMusicLikeListContentsLikeRes0) {
        if(!StationEpisodeDetailFragmentKt.isValidResponse(myMusicLikeListContentsLikeRes0)) {
            return false;
        }
        ArrayList arrayList0 = myMusicLikeListContentsLikeRes0.response.contentslist;
        return arrayList0 != null && !arrayList0.isEmpty();
    }

    private static final boolean isSubscribeProgram(MyMusicLikeListContentsLikeRes myMusicLikeListContentsLikeRes0) {
        if(StationEpisodeDetailFragmentKt.hasValidData(myMusicLikeListContentsLikeRes0)) {
            ArrayList arrayList0 = myMusicLikeListContentsLikeRes0.response.contentslist;
            q.f(arrayList0, "contentslist");
            return q.b(((CONTENTSLIST)p.k0(arrayList0)).likeyn, "Y");
        }
        return false;
    }

    private static final boolean isValidResponse(HttpResponse httpResponse0) {
        if(httpResponse0 != null) {
            j.b(httpResponse0.notification, false, 2);
            return j.d(httpResponse0) && i.l(httpResponse0.getResponse());
        }
        return false;
    }
}

