package t9;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel.DefaultImpls;

public final class e implements RequestListener {
    public final ProducerScope a;

    public e(ProducerScope producerScope0) {
        this.a = producerScope0;
    }

    @Override  // com.bumptech.glide.request.RequestListener
    public final boolean onLoadFailed(GlideException glideException0, Object object0, Target target0, boolean z) {
        q.g(target0, "target");
        DefaultImpls.close$default(this.a, null, 1, null);
        return false;
    }

    @Override  // com.bumptech.glide.request.RequestListener
    public final boolean onResourceReady(Object object0, Object object1, Target target0, DataSource dataSource0, boolean z) {
        q.g(((Drawable)object0), "resource");
        q.g(object1, "model");
        q.g(target0, "target");
        q.g(dataSource0, "dataSource");
        this.a.trySend-JP2dKIU(((Drawable)object0));
        DefaultImpls.close$default(this.a, null, 1, null);
        return false;
    }
}

