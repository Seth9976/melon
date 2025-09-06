package B9;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.net.v6x.response.MyMusicRecentListPlylstRecntRes.RESPONSE.RECNTPLYLSTLIST;
import kotlin.jvm.internal.q;

public final class j extends CustomTarget {
    public final k a;
    public final RECNTPLYLSTLIST b;
    public final CoverView c;

    public j(k k0, RECNTPLYLSTLIST myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, CoverView coverView0) {
        this.a = k0;
        this.b = myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0;
        this.c = coverView0;
        super();
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object object0, Transition transition0) {
        q.g(((Drawable)object0), "resource");
        Boolean boolean0 = this.b.isMelonLogo;
        q.f(boolean0, "isMelonLogo");
        this.a.b.b(boolean0.booleanValue());
        this.c.getThumbnailView().setImageDrawable(((Drawable)object0));
    }
}

