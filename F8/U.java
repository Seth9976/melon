package F8;

import Cc.y2;
import Ic.n;
import Rc.H;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.system.AndroidSettings;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import m4.e;
import m4.g;
import m4.i;
import x1.a;

public final class u extends CustomTarget {
    public final int a;
    public final Object b;
    public final Object c;

    public u(int v, Object object0, Object object1) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        super();
    }

    public u(ImageView imageView0, Object object0, int v) {
        this.a = v;
        this.b = imageView0;
        this.c = object0;
        super();
    }

    private final void a(Drawable drawable0) {
    }

    private final void b(Drawable drawable0) {
    }

    private final void c(Drawable drawable0) {
    }

    private final void d(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.CustomTarget
    public void onLoadFailed(Drawable drawable0) {
        switch(this.a) {
            case 1: {
                Glide.with(((MelonImageView)this.b)).load(((n)this.c).c).into(((MelonImageView)this.b));
                return;
            }
            case 2: {
                K0 k00 = (K0)(((a0)this.c));
                ValueAnimator valueAnimator0 = ValueAnimator.ofInt(new int[]{k00.m(), 0});
                if(valueAnimator0 != null) {
                    valueAnimator0.setEvaluator(new ArgbEvaluator());
                    valueAnimator0.addUpdateListener(new H(((ImageView)this.b), 0));
                    valueAnimator0.setDuration(400L);
                    valueAnimator0.start();
                }
                k00.n(0);
                return;
            }
            default: {
                super.onLoadFailed(drawable0);
            }
        }
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object object0, Transition transition0) {
        switch(this.a) {
            case 0: {
                q.g(((Drawable)object0), "drawable");
                if(((Drawable)object0) instanceof WebpDrawable) {
                    ((WebpDrawable)(((Drawable)object0))).setLoopCount(0);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new t(((Context)this.c), ((Drawable)object0), ((ImageView)this.b), null), 3, null);
                }
                return;
            }
            case 1: {
                q.g(((Drawable)object0), "resource");
                ((MelonImageView)this.b).setImageDrawable(((Drawable)object0));
                return;
            }
            case 2: {
                a0 a00 = (a0)this.c;
                q.g(((Bitmap)object0), "bitmap");
                e e0 = new e(((Bitmap)object0));
                i i0 = y2.a;
                ArrayList arrayList0 = (ArrayList)e0.e;
                if(!arrayList0.contains(i0)) {
                    arrayList0.add(i0);
                }
                e0.a = 24;
                g g0 = e0.a().e;
                int v = g0 == null ? 0 : g0.d;
                ValueAnimator valueAnimator0 = ValueAnimator.ofInt(new int[]{((K0)a00).m(), v});
                if(valueAnimator0 != null) {
                    valueAnimator0.setEvaluator(new ArgbEvaluator());
                    valueAnimator0.addUpdateListener(new H(((ImageView)this.b), 1));
                    valueAnimator0.setDuration(400L);
                    valueAnimator0.start();
                }
                ((K0)a00).n(v);
                return;
            }
            default: {
                q.g(((Drawable)object0), "resource");
                if(((Drawable)object0) instanceof WebpDrawable && !MelonSettingInfo.isLowMemoryMode() && !AndroidSettings.isAnimationDisabled(((Context)this.c))) {
                    ((WebpDrawable)(((Drawable)object0))).setLoopCount(0);
                    a.l(((Animatable)(((Drawable)object0))));
                }
                ((b0)this.b).setValue(((Drawable)object0));
            }
        }
    }
}

