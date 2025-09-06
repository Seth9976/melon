package androidx.window.layout;

import kotlinx.coroutines.channels.ProducerScope;

public final class a implements b2.a {
    public final int a;
    public final ProducerScope b;

    public a(ProducerScope producerScope0, int v) {
        this.a = v;
        this.b = producerScope0;
        super();
    }

    @Override  // b2.a
    public final void accept(Object object0) {
        if(this.a != 0) {
            androidx.window.layout.WindowInfoTrackerImpl.windowLayoutInfo.2.invokeSuspend$lambda$0(this.b, ((WindowLayoutInfo)object0));
            return;
        }
        androidx.window.layout.WindowInfoTrackerImpl.windowLayoutInfo.1.invokeSuspend$lambda$0(this.b, ((WindowLayoutInfo)object0));
    }
}

