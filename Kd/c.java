package kd;

import B0.e;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import androidx.compose.runtime.b0;
import com.iloen.melon.utils.image.ImageUtils;
import ie.H;
import jd.m3;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;
import y0.M;

public final class c extends i implements n {
    public final e B;
    public final Context D;
    public final b0 E;
    public int r;
    public final m3 w;

    public c(m3 m30, e e0, Context context0, b0 b00, Continuation continuation0) {
        this.w = m30;
        this.B = e0;
        this.D = context0;
        this.E = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                if(this.w != m3.a) {
                    this.r = 1;
                    object0 = this.B.i(this);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_10;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
            label_10:
                Bitmap bitmap0 = M.j(((y0.e)object0)).copy(Bitmap.Config.ARGB_8888, true);
                Bitmap bitmap1 = ImageUtils.blurRenderScript(this.D, bitmap0, 24, 0.1f);
                Bitmap bitmap2 = Bitmap.createScaledBitmap(bitmap1, bitmap1.getWidth() * 10, bitmap1.getHeight() * 10, true);
                q.f(bitmap2, "createScaledBitmap(...)");
                this.E.setValue(bitmap2);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

