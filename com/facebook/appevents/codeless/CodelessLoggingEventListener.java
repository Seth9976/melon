package com.facebook.appevents.codeless;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import b.l;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0019\u001AB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\n\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000BJ+\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\fH\u0007¢\u0006\u0004\b\u000E\u0010\u000FJ\'\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001B"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessLoggingEventListener;", "", "<init>", "()V", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "mapping", "Landroid/view/View;", "rootView", "hostView", "Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnClickListener;", "getOnClickListener", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;Landroid/view/View;)Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnClickListener;", "Landroid/widget/AdapterView;", "Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnItemClickListener;", "getOnItemClickListener", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;Landroid/widget/AdapterView;)Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnItemClickListener;", "Lie/H;", "logEvent$facebook_core_release", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;Landroid/view/View;)V", "logEvent", "Landroid/os/Bundle;", "parameters", "updateParameters$facebook_core_release", "(Landroid/os/Bundle;)V", "updateParameters", "AutoLoggingOnClickListener", "AutoLoggingOnItemClickListener", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CodelessLoggingEventListener {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000B\u0010\fR\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u001C\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00040\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0006\u0010\u000FR\u001C\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0005\u0010\u000FR\u0018\u0010\u0010\u001A\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001A\u00020\u00128\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnClickListener;", "Landroid/view/View$OnClickListener;", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "mapping", "Landroid/view/View;", "rootView", "hostView", "<init>", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;Landroid/view/View;)V", "view", "Lie/H;", "onClick", "(Landroid/view/View;)V", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "existingOnClickListener", "Landroid/view/View$OnClickListener;", "", "supportCodelessLogging", "Z", "getSupportCodelessLogging", "()Z", "setSupportCodelessLogging", "(Z)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class AutoLoggingOnClickListener implements View.OnClickListener {
        @Nullable
        private View.OnClickListener existingOnClickListener;
        @NotNull
        private WeakReference hostView;
        @NotNull
        private EventBinding mapping;
        @NotNull
        private WeakReference rootView;
        private boolean supportCodelessLogging;

        public AutoLoggingOnClickListener(@NotNull EventBinding eventBinding0, @NotNull View view0, @NotNull View view1) {
            q.g(eventBinding0, "mapping");
            q.g(view0, "rootView");
            q.g(view1, "hostView");
            super();
            this.mapping = eventBinding0;
            this.hostView = new WeakReference(view1);
            this.rootView = new WeakReference(view0);
            this.existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view1);
            this.supportCodelessLogging = true;
        }

        public final boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        @Override  // android.view.View$OnClickListener
        public void onClick(@NotNull View view0) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            else {
                try {
                    q.g(view0, "view");
                    View.OnClickListener view$OnClickListener0 = this.existingOnClickListener;
                    if(view$OnClickListener0 != null) {
                        view$OnClickListener0.onClick(view0);
                    }
                    View view1 = (View)this.rootView.get();
                    View view2 = (View)this.hostView.get();
                    if(view1 != null && view2 != null) {
                        EventBinding eventBinding0 = this.mapping;
                        q.e(eventBinding0, "null cannot be cast to non-null type com.facebook.appevents.codeless.internal.EventBinding");
                        CodelessLoggingEventListener.logEvent$facebook_core_release(eventBinding0, view1, view2);
                    }
                    return;
                }
                catch(Throwable throwable0) {
                }
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }

        public final void setSupportCodelessLogging(boolean z) {
            this.supportCodelessLogging = z;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\b\u0010\tJ5\u0010\u0011\u001A\u00020\u00102\f\u0010\n\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u000B\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R \u0010\u0007\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00148\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u001C\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u00148\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0018\u0010\u0016\u001A\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001A\u00020\u00188\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessLoggingEventListener$AutoLoggingOnItemClickListener;", "Landroid/widget/AdapterView$OnItemClickListener;", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "mapping", "Landroid/view/View;", "rootView", "Landroid/widget/AdapterView;", "hostView", "<init>", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;Landroid/widget/AdapterView;)V", "parent", "view", "", "position", "", "id", "Lie/H;", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "existingOnItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "", "supportCodelessLogging", "Z", "getSupportCodelessLogging", "()Z", "setSupportCodelessLogging", "(Z)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class AutoLoggingOnItemClickListener implements AdapterView.OnItemClickListener {
        @Nullable
        private AdapterView.OnItemClickListener existingOnItemClickListener;
        @NotNull
        private WeakReference hostView;
        @NotNull
        private EventBinding mapping;
        @NotNull
        private WeakReference rootView;
        private boolean supportCodelessLogging;

        public AutoLoggingOnItemClickListener(@NotNull EventBinding eventBinding0, @NotNull View view0, @NotNull AdapterView adapterView0) {
            q.g(eventBinding0, "mapping");
            q.g(view0, "rootView");
            q.g(adapterView0, "hostView");
            super();
            this.mapping = eventBinding0;
            this.hostView = new WeakReference(adapterView0);
            this.rootView = new WeakReference(view0);
            this.existingOnItemClickListener = adapterView0.getOnItemClickListener();
            this.supportCodelessLogging = true;
        }

        public final boolean getSupportCodelessLogging() {
            return this.supportCodelessLogging;
        }

        @Override  // android.widget.AdapterView$OnItemClickListener
        public void onItemClick(@Nullable AdapterView adapterView0, @NotNull View view0, int v, long v1) {
            q.g(view0, "view");
            AdapterView.OnItemClickListener adapterView$OnItemClickListener0 = this.existingOnItemClickListener;
            if(adapterView$OnItemClickListener0 != null) {
                adapterView$OnItemClickListener0.onItemClick(adapterView0, view0, v, v1);
            }
            View view1 = (View)this.rootView.get();
            AdapterView adapterView1 = (AdapterView)this.hostView.get();
            if(view1 != null && adapterView1 != null) {
                CodelessLoggingEventListener.logEvent$facebook_core_release(this.mapping, view1, adapterView1);
            }
        }

        public final void setSupportCodelessLogging(boolean z) {
            this.supportCodelessLogging = z;
        }
    }

    @NotNull
    public static final CodelessLoggingEventListener INSTANCE;

    static {
        CodelessLoggingEventListener.INSTANCE = new CodelessLoggingEventListener();
    }

    public static void a(Bundle bundle0, String s) {
        CodelessLoggingEventListener.logEvent$lambda$0(s, bundle0);
    }

    @NotNull
    public static final AutoLoggingOnClickListener getOnClickListener(@NotNull EventBinding eventBinding0, @NotNull View view0, @NotNull View view1) {
        Class class0 = CodelessLoggingEventListener.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(eventBinding0, "mapping");
            q.g(view0, "rootView");
            q.g(view1, "hostView");
            return new AutoLoggingOnClickListener(eventBinding0, view0, view1);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @NotNull
    public static final AutoLoggingOnItemClickListener getOnItemClickListener(@NotNull EventBinding eventBinding0, @NotNull View view0, @NotNull AdapterView adapterView0) {
        Class class0 = CodelessLoggingEventListener.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(eventBinding0, "mapping");
            q.g(view0, "rootView");
            q.g(adapterView0, "hostView");
            return new AutoLoggingOnItemClickListener(eventBinding0, view0, adapterView0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final void logEvent$facebook_core_release(@NotNull EventBinding eventBinding0, @NotNull View view0, @NotNull View view1) {
        Class class0 = CodelessLoggingEventListener.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(eventBinding0, "mapping");
            q.g(view0, "rootView");
            q.g(view1, "hostView");
            Bundle bundle0 = CodelessMatcher.Companion.getParameters(eventBinding0, view0, view1);
            CodelessLoggingEventListener.INSTANCE.updateParameters$facebook_core_release(bundle0);
            FacebookSdk.getExecutor().execute(new l(9, eventBinding0.getEventName(), bundle0));
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private static final void logEvent$lambda$0(String s, Bundle bundle0) {
        Class class0 = CodelessLoggingEventListener.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(s, "$eventName");
            q.g(bundle0, "$parameters");
            Context context0 = FacebookSdk.getApplicationContext();
            AppEventsLogger.Companion.newLogger(context0).logEvent(s, bundle0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public final void updateParameters$facebook_core_release(@NotNull Bundle bundle0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(bundle0, "parameters");
            String s = bundle0.getString("_valueToSum");
            if(s != null) {
                bundle0.putDouble("_valueToSum", AppEventUtility.normalizePrice(s));
            }
            bundle0.putString("_is_fb_codeless", "1");
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }
}

