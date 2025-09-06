package w8;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.runtime.b0;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.iloen.melon.utils.ui.LyricHighlightUtils.Companion;
import com.iloen.melon.utils.ui.LyricHighlightUtils;
import kotlin.jvm.internal.q;

public final class c0 implements RequestListener {
    public final Context a;
    public final b0 b;
    public final b0 c;

    public c0(Context context0, b0 b00, b0 b01) {
        this.a = context0;
        this.b = b00;
        this.c = b01;
    }

    @Override  // com.bumptech.glide.request.RequestListener
    public final boolean onLoadFailed(GlideException glideException0, Object object0, Target target0, boolean z) {
        q.g(target0, "target");
        this.b.setValue(null);
        this.c.setValue(null);
        return true;
    }

    @Override  // com.bumptech.glide.request.RequestListener
    public final boolean onResourceReady(Object object0, Object object1, Target target0, DataSource dataSource0, boolean z) {
        q.g(((Bitmap)object0), "resource");
        q.g(object1, "model");
        q.g(dataSource0, "dataSource");
        this.b.setValue(((Bitmap)object0));
        Bitmap bitmap0 = Companion.drawPalette$default(LyricHighlightUtils.Companion, this.a, ((Bitmap)object0), false, false, 4, null);
        this.c.setValue(bitmap0);
        return true;
    }
}

