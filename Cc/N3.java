package Cc;

import android.content.Context;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import coil.memory.MemoryCache.Key;
import coil.request.ImageRequest.Builder;
import com.iloen.melon.utils.image.CrossFadeTransitionIncludeCacheLoadFactory;
import ea.b;
import kotlin.jvm.internal.q;
import t5.j;

public final class n3 {
    public final int a;
    public String b;
    public final b0 c;

    public n3(int v) {
        this.a = v;
        this.c = w.s(null);
    }

    public final void a(Context context0, String s) {
        j j0;
        q.g(context0, "context");
        if(q.b(this.b, s)) {
            return;
        }
        b b0 = new b(this, s);
        if(this.b == null || this.b.length() == 0) {
            ImageRequest.Builder imageRequest$Builder1 = new ImageRequest.Builder(context0);
            imageRequest$Builder1.c = s;
            imageRequest$Builder1.e = b0;
            j0 = imageRequest$Builder1.a();
        }
        else {
            ImageRequest.Builder imageRequest$Builder0 = new ImageRequest.Builder(context0);
            MemoryCache.Key memoryCache$Key0 = null;
            imageRequest$Builder0.f = s == null ? null : new MemoryCache.Key(s);
            imageRequest$Builder0.c = s;
            String s1 = this.b;
            if(s1 != null) {
                memoryCache$Key0 = new MemoryCache.Key(s1);
            }
            imageRequest$Builder0.q = memoryCache$Key0;
            int v = this.a;
            if(v > 0) {
                imageRequest$Builder0.j = new CrossFadeTransitionIncludeCacheLoadFactory(v);
            }
            imageRequest$Builder0.e = b0;
            j0 = imageRequest$Builder0.a();
        }
        ((O0)this.c).setValue(j0);
    }
}

