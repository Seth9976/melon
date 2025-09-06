package com.facebook.appevents.codeless;

import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\bH\u0007¨\u0006\u000B"}, d2 = {"Lcom/facebook/appevents/codeless/RCTCodelessLoggingEventListener;", "", "()V", "getOnTouchListener", "Lcom/facebook/appevents/codeless/RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "AutoLoggingOnTouchListener", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RCTCodelessLoggingEventListener {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u0013H\u0016R\u0010\u0010\b\u001A\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/codeless/RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener;", "Landroid/view/View$OnTouchListener;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;Landroid/view/View;)V", "existingOnTouchListener", "Ljava/lang/ref/WeakReference;", "supportCodelessLogging", "", "getSupportCodelessLogging", "()Z", "setSupportCodelessLogging", "(Z)V", "onTouch", "view", "motionEvent", "Landroid/view/MotionEvent;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class AutoLoggingOnTouchListener implements View.OnTouchListener {
        @Nullable
        private final View.OnTouchListener existingOnTouchListener;
        @NotNull
        private final WeakReference hostView;
        @NotNull
        private final EventBinding mapping;
        @NotNull
        private final WeakReference rootView;
        private boolean supportCodelessLogging;

        public AutoLoggingOnTouchListener(@NotNull EventBinding eventBinding0, @NotNull View view0, @NotNull View view1) {
            q.g(eventBinding0, "mapping");
            q.g(view0, "rootView");
            q.g(view1, "hostView");
            super();
            this.mapping = eventBinding0;
            this.hostView = new WeakReference(view1);
            this.rootView = new WeakReference(view0);
            this.existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view1);
            this.supportCodelessLogging = true;
        }

        public final boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        @Override  // android.view.View$OnTouchListener
        public boolean onTouch(@NotNull View view0, @NotNull MotionEvent motionEvent0) {
            q.g(view0, "view");
            q.g(motionEvent0, "motionEvent");
            View view1 = (View)this.rootView.get();
            View view2 = (View)this.hostView.get();
            if(view1 != null && view2 != null && motionEvent0.getAction() == 1) {
                CodelessLoggingEventListener.logEvent$facebook_core_release(this.mapping, view1, view2);
            }
            return this.existingOnTouchListener != null && this.existingOnTouchListener.onTouch(view0, motionEvent0);
        }

        public final void setSupportCodelessLogging(boolean z) {
            this.supportCodelessLogging = z;
        }
    }

    @NotNull
    public static final RCTCodelessLoggingEventListener INSTANCE;

    static {
        RCTCodelessLoggingEventListener.INSTANCE = new RCTCodelessLoggingEventListener();
    }

    @NotNull
    public static final AutoLoggingOnTouchListener getOnTouchListener(@NotNull EventBinding eventBinding0, @NotNull View view0, @NotNull View view1) {
        Class class0 = RCTCodelessLoggingEventListener.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(eventBinding0, "mapping");
            q.g(view0, "rootView");
            q.g(view1, "hostView");
            return new AutoLoggingOnTouchListener(eventBinding0, view0, view1);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }
}

