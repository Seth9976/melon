package k8;

import T3.e;
import android.support.v4.view.NonSwipeableViewPager;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.userstore.MelonDb;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.MusicBrowserPopupHelper;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import oe.i;
import w9.a;
import we.n;

public final class c1 extends i implements n {
    public boolean r;
    public final MusicBrowserActivity w;

    public c1(MusicBrowserActivity musicBrowserActivity0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new c1(this.w, continuation0);
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((c1)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.r;
        d5.n.D(object0);
        LogU logU0 = new LogU("MusicBrowserActivity");
        logU0.setCategory(Category.Login);
        logU0.setUseThreadInfo(true);
        LogU.debug$default(logU0, "MusicBrowserActivity - isLogin: " + z, null, false, 6, null);
        e e0 = a.a;
        MelonDb melonDb0 = e0.h();
        if(melonDb0 != null) {
            melonDb0.deleteAllResponseCache();
            e0.d();
        }
        TimeExpiredCache.getInstance().clear();
        MusicBrowserActivity musicBrowserActivity0 = this.w;
        if(z) {
            LogU.debug$default(c9.i.b, "TmpCall skipped. tmpCall: , skipTmpCall: " + musicBrowserActivity0.getSkipTmpCall(), null, false, 6, null);
            goto label_19;
        }
        NonSwipeableViewPager nonSwipeableViewPager0 = musicBrowserActivity0.viewPager;
        if(nonSwipeableViewPager0 != null) {
            musicBrowserActivity0.clearAllTabStackWithoutIndex(nonSwipeableViewPager0.getCurrentItem());
        label_19:
            musicBrowserActivity0.handlePendingIntentAsync();
            MusicBrowserPopupHelper musicBrowserPopupHelper0 = musicBrowserActivity0.musicBrowserPopupHelper;
            if(musicBrowserPopupHelper0 != null) {
                musicBrowserPopupHelper0.onEventLogin();
            }
            LogU.debug$default(c9.i.b, "set skipTmpCall false in loginFlow", null, false, 6, null);
            musicBrowserActivity0.setSkipTmpCall(false);
            return H.a;
        }
        q.m("viewPager");
        throw null;
    }
}

