package com.iloen.melon.utils.viewable;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import com.iloen.melon.utils.log.LogU;
import i.n.i.b.a.s.e.M3;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0003\u0007\b\u0006J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/iloen/melon/utils/viewable/ViewableCheck;", "", "Lie/H;", "start", "()V", "stop", "Companion", "NonLeakHandle", "Builder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ViewableCheck {
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001B\u0010\t\u001A\u00020\u00002\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rR%\u0010\u0014\u001A\u0010\u0012\f\u0012\n \u000F*\u0004\u0018\u00010\u00020\u00020\u000E8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R\"\u0010\u001C\u001A\u00020\u00158\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\"\u0010$\u001A\u00020\u001D8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010,\u001A\u00020%8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b&\u0010\'\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00100\u001A\u00020%8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b-\u0010\'\u001A\u0004\b.\u0010)\"\u0004\b/\u0010+R\"\u00104\u001A\u00020\u001D8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b1\u0010\u001F\u001A\u0004\b2\u0010!\"\u0004\b3\u0010#R\"\u0010<\u001A\u0002058\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b6\u00107\u001A\u0004\b8\u00109\"\u0004\b:\u0010;R0\u0010A\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u000E8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b=\u0010\u0011\u001A\u0004\b>\u0010\u0013\"\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lcom/iloen/melon/utils/viewable/ViewableCheck$Builder;", "", "Landroid/view/View;", "targetView", "<init>", "(Landroid/view/View;)V", "Lkotlin/Function0;", "Lie/H;", "onViewable", "setCallback", "(Lwe/a;)Lcom/iloen/melon/utils/viewable/ViewableCheck$Builder;", "Lcom/iloen/melon/utils/viewable/ViewableCheck;", "build", "()Lcom/iloen/melon/utils/viewable/ViewableCheck;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "a", "Ljava/lang/ref/WeakReference;", "getTargetViewRef", "()Ljava/lang/ref/WeakReference;", "targetViewRef", "", "b", "J", "getMinExposedTime", "()J", "setMinExposedTime", "(J)V", "minExposedTime", "", "c", "F", "getMinExposedArea", "()F", "setMinExposedArea", "(F)V", "minExposedArea", "", "d", "I", "getMinWidth", "()I", "setMinWidth", "(I)V", "minWidth", "e", "getMinHeight", "setMinHeight", "minHeight", "f", "getOverlayMaxAlpha", "setOverlayMaxAlpha", "overlayMaxAlpha", "", "g", "Z", "getIgnoreIntersectionChecker", "()Z", "setIgnoreIntersectionChecker", "(Z)V", "ignoreIntersectionChecker", "h", "getOnViewableRef", "setOnViewableRef", "(Ljava/lang/ref/WeakReference;)V", "onViewableRef", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Builder {
        public static final int $stable = 8;
        public final WeakReference a;
        public long b;
        public float c;
        public int d;
        public int e;
        public float f;
        public boolean g;
        public WeakReference h;

        public Builder(@NotNull View view0) {
            q.g(view0, "targetView");
            float f;
            int v1;
            super();
            WeakReference weakReference0 = new WeakReference(view0);
            this.a = weakReference0;
            this.b = 1000L;
            this.c = 0.5f;
            View view1 = (View)weakReference0.get();
            int v = 0;
            if(view1 == null) {
                v1 = 0;
            }
            else {
                Context context0 = view1.getContext();
                v1 = context0 == null ? 0 : ((int)(100.0f * context0.getResources().getDisplayMetrics().density));
            }
            this.d = v1;
            View view2 = (View)weakReference0.get();
            if(view2 != null) {
                Context context1 = view2.getContext();
                if(context1 != null) {
                    v = (int)(50.0f * context1.getResources().getDisplayMetrics().density);
                }
            }
            this.e = v;
            View view3 = (View)weakReference0.get();
            if(view3 == null) {
                f = 0.0f;
            }
            else {
                Context context2 = view3.getContext();
                f = context2 == null ? 0.0f : ViewableCheck.Companion.getOverlayLayerMaxAlpha(context2);
            }
            this.f = f;
        }

        @NotNull
        public final ViewableCheck build() {
            return new ViewableCheck(this, null);
        }

        public final boolean getIgnoreIntersectionChecker() {
            return this.g;
        }

        public final float getMinExposedArea() {
            return this.c;
        }

        public final long getMinExposedTime() {
            return this.b;
        }

        public final int getMinHeight() {
            return this.e;
        }

        public final int getMinWidth() {
            return this.d;
        }

        @Nullable
        public final WeakReference getOnViewableRef() {
            return this.h;
        }

        public final float getOverlayMaxAlpha() {
            return this.f;
        }

        @NotNull
        public final WeakReference getTargetViewRef() {
            return this.a;
        }

        @NotNull
        public final Builder setCallback(@NotNull a a0) {
            q.g(a0, "onViewable");
            this.h = new WeakReference(a0);
            return this;
        }

        public final void setIgnoreIntersectionChecker(boolean z) {
            this.g = z;
        }

        public final void setMinExposedArea(float f) {
            this.c = f;
        }

        public final void setMinExposedTime(long v) {
            this.b = v;
        }

        public final void setMinHeight(int v) {
            this.e = v;
        }

        public final void setMinWidth(int v) {
            this.d = v;
        }

        public final void setOnViewableRef(@Nullable WeakReference weakReference0) {
            this.h = weakReference0;
        }

        public final void setOverlayMaxAlpha(float f) {
            this.f = f;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000B\u0010\fR\u0014\u0010\u000E\u001A\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001A\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001A\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000FR\u0014\u0010\u0015\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\tR\u0014\u0010\u0018\u001A\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/utils/viewable/ViewableCheck$Companion;", "", "Landroid/content/Context;", "context", "", "getOverlayLayerMaxAlpha", "(Landroid/content/Context;)F", "", "TAG", "Ljava/lang/String;", "", "MSG_CHECK", "I", "", "DEFAULT_MIN_EXPOSED_TIME", "J", "DEFAULT_MIN_EXPOSED_AREA", "F", "DEFAULT_MIN_WIDTH", "DEFAULT_MIN_HEIGHT", "MIN_CHECK_INTERVAL", "OVERLAY_LAYER_MAX_ALPHA_IF_ALLOWED", "META_ALLOW_ALPHA", "Ljava/util/concurrent/atomic/AtomicInteger;", "ID_GENERATOR", "Ljava/util/concurrent/atomic/AtomicInteger;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final float getOverlayLayerMaxAlpha(@NotNull Context context0) {
            q.g(context0, "context");
            boolean z = false;
            try {
                ApplicationInfo applicationInfo0 = context0.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80);
                q.f(applicationInfo0, "getApplicationInfo(...)");
                z = applicationInfo0.metaData.getBoolean("com.kakao.adfit.alphalayer", false);
            }
            catch(Exception exception0) {
                LogU.Companion.v("ViewableCheck", "Failed to get a meta-data: " + exception0);
            }
            switch(z) {
                case 0: {
                    return 0.0f;
                }
                case 1: {
                    return 0.72f;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\"\u0010\u0016\u001A\u00020\u000F8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/utils/viewable/ViewableCheck$NonLeakHandle;", "Landroid/os/Handler;", "Lcom/iloen/melon/utils/viewable/ViewableCheck$Builder;", "builder", "<init>", "(Lcom/iloen/melon/utils/viewable/ViewableCheck$Builder;)V", "Landroid/os/Message;", "msg", "Lie/H;", "handleMessage", "(Landroid/os/Message;)V", "a", "Lcom/iloen/melon/utils/viewable/ViewableCheck$Builder;", "getBuilder", "()Lcom/iloen/melon/utils/viewable/ViewableCheck$Builder;", "", "b", "J", "getStartExposedTime", "()J", "setStartExposedTime", "(J)V", "startExposedTime", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class NonLeakHandle extends Handler {
        public final Builder a;
        public long b;
        public final long c;
        public final long d;

        public NonLeakHandle(@NotNull Builder viewableCheck$Builder0) {
            q.g(viewableCheck$Builder0, "builder");
            super(Looper.getMainLooper());
            this.a = viewableCheck$Builder0;
            this.b = -1L;
            long v = Math.max(viewableCheck$Builder0.getMinExposedTime(), 0L);
            this.c = v;
            this.d = Math.max(v / 5L, 1000L);
        }

        @NotNull
        public final Builder getBuilder() {
            return this.a;
        }

        public final long getStartExposedTime() {
            return this.b;
        }

        @Override  // android.os.Handler
        public void handleMessage(@NotNull Message message0) {
            q.g(message0, "msg");
            if(message0.what == 0) {
                boolean z = true;
                Builder viewableCheck$Builder0 = this.a;
                View view0 = (View)viewableCheck$Builder0.getTargetViewRef().get();
                if(view0 == null || !view0.hasWindowFocus()) {
                    this.b = -1L;
                    z = false;
                }
                else {
                    Object object0 = viewableCheck$Builder0.getTargetViewRef().get();
                    if((((View)object0) == null ? false : ViewableInspector.isViewable(((View)object0), viewableCheck$Builder0.getMinWidth(), viewableCheck$Builder0.getMinHeight(), viewableCheck$Builder0.getMinExposedArea(), viewableCheck$Builder0.getOverlayMaxAlpha(), viewableCheck$Builder0.getIgnoreIntersectionChecker()))) {
                        long v = SystemClock.elapsedRealtime();
                        long v1 = this.b;
                        if(v1 <= 0L) {
                            this.b = v;
                            z = false;
                        }
                        else if(v - v1 < this.c) {
                            z = false;
                        }
                    }
                    else {
                        this.b = -1L;
                        z = false;
                    }
                }
                if(z) {
                    WeakReference weakReference0 = viewableCheck$Builder0.getOnViewableRef();
                    if(weakReference0 != null) {
                        a a0 = (a)weakReference0.get();
                        if(a0 != null) {
                            a0.invoke();
                        }
                    }
                }
                else {
                    this.sendEmptyMessageDelayed(0, this.d);
                }
            }
        }

        public final void setStartExposedTime(long v) {
            this.b = v;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final NonLeakHandle a;
    public static final String b;
    public static final AtomicInteger c;

    static {
        ViewableCheck.Companion = new Companion(null);
        ViewableCheck.$stable = 8;
        ViewableCheck.b = "ViewableCheck";
        ViewableCheck.c = new AtomicInteger();
    }

    public ViewableCheck(Builder viewableCheck$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        ViewableCheck.c.incrementAndGet();
        this.a = new NonLeakHandle(viewableCheck$Builder0);
    }

    // 去混淆评级： 低(20)
    public static final String access$getTAG$cp() [...] // 潜在的解密器

    public static final float getOverlayLayerMaxAlpha(@NotNull Context context0) {
        return ViewableCheck.Companion.getOverlayLayerMaxAlpha(context0);
    }

    public final void start() {
        NonLeakHandle viewableCheck$NonLeakHandle0 = this.a;
        if(!viewableCheck$NonLeakHandle0.hasMessages(0)) {
            viewableCheck$NonLeakHandle0.sendEmptyMessage(0);
        }
    }

    public final void stop() {
        this.a.removeMessages(0);
        this.a.setStartExposedTime(-1L);
    }
}

