package androidx.window.area;

import androidx.window.reflection.Consumer2;
import kotlinx.coroutines.channels.ProducerScope;

public final class c implements Consumer2 {
    public final WindowAreaControllerImpl a;
    public final ProducerScope b;

    public c(WindowAreaControllerImpl windowAreaControllerImpl0, ProducerScope producerScope0) {
        this.a = windowAreaControllerImpl0;
        this.b = producerScope0;
    }

    @Override  // androidx.window.reflection.Consumer2
    public final void accept(Object object0) {
        androidx.window.area.WindowAreaControllerImpl.windowAreaInfos.1.invokeSuspend$lambda$0(this.a, this.b, ((int)(((Integer)object0))));
    }
}

