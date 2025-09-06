package l2;

import androidx.compose.foundation.w;
import gd.y1;
import kb.D;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

public final class e0 {
    public final CoroutineScope a;
    public final J b;
    public final Channel c;
    public final D d;

    public e0(CoroutineScope coroutineScope0, w w0, J j0) {
        q.g(coroutineScope0, "scope");
        super();
        this.a = coroutineScope0;
        this.b = j0;
        this.c = ChannelKt.Channel$default(0x7FFFFFFF, null, null, 6, null);
        this.d = new D(2);
        Job job0 = (Job)coroutineScope0.getCoroutineContext().get(Job.Key);
        if(job0 != null) {
            job0.invokeOnCompletion(new y1(23, w0, this));
        }
    }
}

