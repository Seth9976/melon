package androidx.window.embedding;

import java.util.List;
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
        switch(this.a) {
            case 0: {
                androidx.window.embedding.ActivityEmbeddingController.embeddedActivityWindowInfo.1.invokeSuspend$lambda$0(this.b, ((EmbeddedActivityWindowInfo)object0));
                return;
            }
            case 1: {
                androidx.window.embedding.OverlayController.overlayInfo.1.invokeSuspend$lambda$0(this.b, ((OverlayInfo)object0));
                return;
            }
            default: {
                androidx.window.embedding.SplitController.splitInfoList.1.invokeSuspend$lambda$0(this.b, ((List)object0));
            }
        }
    }
}

