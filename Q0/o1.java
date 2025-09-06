package Q0;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings.Global;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import we.n;

public final class o1 extends i implements n {
    public Object B;
    public final ContentResolver D;
    public final Uri E;
    public final p1 G;
    public final Channel I;
    public final Context M;
    public ChannelIterator r;
    public int w;

    public o1(ContentResolver contentResolver0, Uri uri0, p1 p10, Channel channel0, Context context0, Continuation continuation0) {
        this.D = contentResolver0;
        this.E = uri0;
        this.G = p10;
        this.I = channel0;
        this.M = context0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new o1(this.D, this.E, this.G, this.I, this.M, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o1)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        FlowCollector flowCollector1;
        ChannelIterator channelIterator0;
        FlowCollector flowCollector0;
        a a0 = a.a;
        p1 p10 = this.G;
        ContentResolver contentResolver0 = this.D;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                flowCollector0 = (FlowCollector)this.B;
                contentResolver0.registerContentObserver(this.E, false, p10);
                try {
                    channelIterator0 = this.I.iterator();
                    goto label_18;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                channelIterator0 = this.r;
                flowCollector1 = (FlowCollector)this.B;
                try {
                    d5.n.D(object0);
                    goto label_25;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 2: {
                channelIterator0 = this.r;
                flowCollector1 = (FlowCollector)this.B;
                try {
                    d5.n.D(object0);
                    while(true) {
                        flowCollector0 = flowCollector1;
                    label_18:
                        this.B = flowCollector0;
                        this.r = channelIterator0;
                        this.w = 1;
                        Object object1 = channelIterator0.hasNext(this);
                        if(object1 != a0) {
                            flowCollector1 = flowCollector0;
                            object0 = object1;
                        label_25:
                            if(!((Boolean)object0).booleanValue()) {
                                goto label_36;
                            }
                            channelIterator0.next();
                            Float float0 = new Float(Settings.Global.getFloat(this.M.getContentResolver(), "animator_duration_scale", 1.0f));
                            this.B = flowCollector1;
                            this.r = channelIterator0;
                            this.w = 2;
                            if(flowCollector1.emit(float0, this) != a0) {
                                continue;
                            }
                        }
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        contentResolver0.unregisterContentObserver(p10);
        throw throwable0;
    label_36:
        contentResolver0.unregisterContentObserver(p10);
        return H.a;
    }
}

