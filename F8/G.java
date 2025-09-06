package F8;

import android.app.Activity;
import android.view.View;
import com.iloen.melon.MusicBrowserActivity;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class g extends i implements n {
    public final Activity r;

    public g(Activity activity0, Continuation continuation0) {
        this.r = activity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        View view0 = ((MusicBrowserActivity)this.r).getCtlBottom();
        if(view0 != null) {
            view0.setImportantForAccessibility(1);
        }
        return H.a;
    }
}

