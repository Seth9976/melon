package kotlinx.coroutines.android;

import kotlinx.coroutines.DisposableHandle;

public final class a implements DisposableHandle {
    public final HandlerContext a;
    public final Runnable b;

    public a(HandlerContext handlerContext0, Runnable runnable0) {
        this.a = handlerContext0;
        this.b = runnable0;
    }

    @Override  // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        HandlerContext.invokeOnTimeout$lambda$3(this.a, this.b);
    }
}

