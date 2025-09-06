package F8;

import android.app.Activity;
import androidx.fragment.app.I;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonBaseFragment;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import we.n;

public final class h extends i implements n {
    public final TitleBar B;
    public final I D;
    public final Activity E;
    public int r;
    public int w;

    public h(TitleBar titleBar0, I i0, Activity activity0, Continuation continuation0) {
        this.B = titleBar0;
        this.D = i0;
        this.E = activity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h(this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v;
        a a0 = a.a;
        TitleBar titleBar0 = this.B;
    alab1:
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.w = 1;
                if(DelayKt.delay(1000L, this) != a0) {
                label_17:
                    f f0 = new f(titleBar0, null);
                    this.w = 2;
                    if(BuildersKt.withContext(Dispatchers.getMain(), f0, this) != a0) {
                        v = 1;
                    label_21:
                        while(v < 11 && (titleBar0.h == null || !titleBar0.h.isAccessibilityFocused())) {
                            MelonBaseFragment melonBaseFragment0 = this.D instanceof MelonBaseFragment ? ((MelonBaseFragment)this.D) : null;
                            if(melonBaseFragment0 != null && !melonBaseFragment0.isFragmentValid()) {
                                break;
                            }
                            this.r = v;
                            this.w = 3;
                            if(DelayKt.delay(200L, this) == a0) {
                                break alab1;
                            }
                        label_27:
                            ++v;
                        }
                        g g0 = new g(this.E, null);
                        this.w = 4;
                        if(BuildersKt.withContext(Dispatchers.getMain(), g0, this) != a0) {
                            return H.a;
                        }
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                goto label_17;
            }
            case 2: {
                d5.n.D(object0);
                v = 1;
                goto label_21;
            }
            case 3: {
                v = this.r;
                d5.n.D(object0);
                goto label_27;
            }
            case 4: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

