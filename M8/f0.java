package m8;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.melon.ui.popup.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class f0 extends i implements n {
    public final Activity r;

    public f0(Activity activity0, Continuation continuation0) {
        this.r = activity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f0(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((f0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        AppCompatActivity appCompatActivity0 = this.r instanceof AppCompatActivity ? ((AppCompatActivity)this.r) : null;
        b.l(this.r, (appCompatActivity0 == null ? null : appCompatActivity0.getSupportFragmentManager()), null, 12);
        return H.a;
    }
}

