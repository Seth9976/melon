package androidx.window.area;

import androidx.window.extensions.area.ExtensionWindowAreaStatus;
import androidx.window.reflection.Consumer2;
import kotlinx.coroutines.channels.ProducerScope;

public final class d implements Consumer2 {
    public final WindowAreaControllerImpl a;
    public final ProducerScope b;

    public d(WindowAreaControllerImpl windowAreaControllerImpl0, ProducerScope producerScope0) {
        this.a = windowAreaControllerImpl0;
        this.b = producerScope0;
    }

    @Override  // androidx.window.reflection.Consumer2
    public final void accept(Object object0) {
        androidx.window.area.WindowAreaControllerImpl.windowAreaInfos.1.invokeSuspend$lambda$1(this.a, this.b, ((ExtensionWindowAreaStatus)object0));
    }
}

