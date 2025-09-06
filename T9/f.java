package t9;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import ne.a;
import oe.i;
import we.n;

public final class f extends i implements n {
    public final Context B;
    public final String D;
    public final o E;
    public int r;
    public Object w;

    public f(Context context0, String s, o o0, Continuation continuation0) {
        this.B = context0;
        this.D = s;
        this.E = o0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new f(this.B, this.D, this.E, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((ProducerScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ProducerScope producerScope0 = (ProducerScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                RequestBuilder requestBuilder0 = Glide.with(this.B).load(this.D).listener(new e(producerScope0));
                q.f(requestBuilder0, "listener(...)");
                if(this.E.a == 3) {
                    requestBuilder0.apply(RequestOptions.circleCropTransform());
                }
                requestBuilder0.submit(0x80000000, 0x80000000);
                this.w = null;
                this.r = 1;
                return ProduceKt.awaitClose$default(producerScope0, null, this, 1, null) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

