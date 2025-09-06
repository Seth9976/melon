package com.facebook.appevents.codeless;

import Tf.o;
import Tf.v;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.ViewTreeObserver;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import b3.Z;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.c;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.regex.Pattern;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u001F2\u00020\u0001:\u0003\u001F !B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000B\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\u000B\u0010\nJ\u0017\u0010\f\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\nR\u0014\u0010\u000E\u001A\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00070\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R&\u0010\u0018\u001A\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00178\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019RF\u0010\u001D\u001A4\u0012\u0004\u0012\u00020\u001B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u001Aj\u001E\u0012\u0004\u0012\u00020\u001B\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017`\u001C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001D\u0010\u001E¨\u0006\""}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher;", "", "<init>", "()V", "Lie/H;", "startTracking", "matchViews", "Landroid/app/Activity;", "activity", "add", "(Landroid/app/Activity;)V", "remove", "destroy", "Landroid/os/Handler;", "uiThreadHandler", "Landroid/os/Handler;", "", "activitiesSet", "Ljava/util/Set;", "Lcom/facebook/appevents/codeless/CodelessMatcher$ViewMatcher;", "viewMatchers", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "listenerSet", "Ljava/util/HashSet;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "activityToListenerMap", "Ljava/util/HashMap;", "Companion", "MatchedView", "ViewMatcher", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CodelessMatcher {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001A\u00020\tH\u0007J\"\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$Companion;", "", "()V", "CURRENT_CLASS_NAME", "", "PARENT_CLASS_NAME", "TAG", "kotlin.jvm.PlatformType", "codelessMatcher", "Lcom/facebook/appevents/codeless/CodelessMatcher;", "getInstance", "getParameters", "Landroid/os/Bundle;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final CodelessMatcher getInstance() {
            synchronized(this) {
                if(CodelessMatcher.access$getCodelessMatcher$cp() == null) {
                    CodelessMatcher.access$setCodelessMatcher$cp(new CodelessMatcher(null));
                }
                CodelessMatcher codelessMatcher0 = CodelessMatcher.access$getCodelessMatcher$cp();
                q.e(codelessMatcher0, "null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessMatcher");
                return codelessMatcher0;
            }
        }

        @NotNull
        public final Bundle getParameters(@Nullable EventBinding eventBinding0, @NotNull View view0, @NotNull View view1) {
            String s2;
            List list1;
            q.g(view0, "rootView");
            q.g(view1, "hostView");
            Bundle bundle0 = new Bundle();
            if(eventBinding0 != null) {
                List list0 = eventBinding0.getViewParameters();
                if(list0 != null) {
                    Iterator iterator0 = list0.iterator();
                label_7:
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        ParameterComponent parameterComponent0 = (ParameterComponent)object0;
                        if(parameterComponent0.getValue() != null && parameterComponent0.getValue().length() > 0) {
                            bundle0.putString(parameterComponent0.getName(), parameterComponent0.getValue());
                        }
                        else if(parameterComponent0.getPath().size() > 0) {
                            if(q.b(parameterComponent0.getPathType(), "relative")) {
                                String s = view1.getClass().getSimpleName();
                                list1 = ViewMatcher.Companion.findViewByPath(eventBinding0, view1, parameterComponent0.getPath(), 0, -1, s);
                            }
                            else {
                                String s1 = view0.getClass().getSimpleName();
                                list1 = ViewMatcher.Companion.findViewByPath(eventBinding0, view0, parameterComponent0.getPath(), 0, -1, s1);
                            }
                            Iterator iterator1 = list1.iterator();
                            while(true) {
                                if(!iterator1.hasNext()) {
                                    continue label_7;
                                }
                                Object object1 = iterator1.next();
                                MatchedView codelessMatcher$MatchedView0 = (MatchedView)object1;
                                if(codelessMatcher$MatchedView0.getView() != null) {
                                    s2 = ViewHierarchy.getTextOfView(codelessMatcher$MatchedView0.getView());
                                    if(s2.length() > 0) {
                                        break;
                                    }
                                }
                            }
                            bundle0.putString(parameterComponent0.getName(), s2);
                        }
                    }
                }
            }
            return bundle0;
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001A\u0004\u0018\u00010\u0003R\u0016\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;", "", "view", "Landroid/view/View;", "viewMapKey", "", "(Landroid/view/View;Ljava/lang/String;)V", "Ljava/lang/ref/WeakReference;", "getViewMapKey", "()Ljava/lang/String;", "getView", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class MatchedView {
        @Nullable
        private final WeakReference view;
        @NotNull
        private final String viewMapKey;

        public MatchedView(@NotNull View view0, @NotNull String s) {
            q.g(view0, "view");
            q.g(s, "viewMapKey");
            super();
            this.view = new WeakReference(view0);
            this.viewMapKey = s;
        }

        @Nullable
        public final View getView() {
            return this.view == null ? null : ((View)this.view.get());
        }

        @NotNull
        public final String getViewMapKey() {
            return this.viewMapKey;
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B9\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0016\u0010\u000B\u001A\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0006\u0010\f\u001A\u00020\t\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001A\u00020\u000F2\b\u0010\u0013\u001A\u0004\u0018\u00010\u00122\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019J\'\u0010\u001A\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u001A\u0010\u0019J\'\u0010\u001B\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u001B\u0010\u0019J\'\u0010\u001C\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u001C\u0010\u0019J\u000F\u0010\u001D\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u0011J\u000F\u0010\u001E\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u0011J\u000F\u0010\u001F\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0011R\u001C\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040 8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010!R\u001E\u0010#\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\"8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010%R$\u0010\u000B\u001A\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000B\u0010&R\u0014\u0010\f\u001A\u00020\t8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\f\u0010\'\u00A8\u0006)"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$ViewMatcher;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Ljava/lang/Runnable;", "Landroid/view/View;", "rootView", "Landroid/os/Handler;", "handler", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "listenerSet", "activityName", "<init>", "(Landroid/view/View;Landroid/os/Handler;Ljava/util/HashSet;Ljava/lang/String;)V", "Lie/H;", "startMatch", "()V", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "mapping", "findView", "(Lcom/facebook/appevents/codeless/internal/EventBinding;Landroid/view/View;)V", "Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;", "matchedView", "attachListener", "(Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;Landroid/view/View;Lcom/facebook/appevents/codeless/internal/EventBinding;)V", "attachOnClickListener", "attachOnItemClickListener", "attachRCTListener", "run", "onGlobalLayout", "onScrollChanged", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "", "eventBindings", "Ljava/util/List;", "Landroid/os/Handler;", "Ljava/util/HashSet;", "Ljava/lang/String;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class ViewMatcher implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JH\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00042\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0010H\u0007J\u0016\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0012\u001A\u00020\u0013H\u0002J \u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0002¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$ViewMatcher$Companion;", "", "()V", "findViewByPath", "", "Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "view", "Landroid/view/View;", "path", "Lcom/facebook/appevents/codeless/internal/PathComponent;", "level", "", "index", "mapKey", "", "findVisibleChildren", "viewGroup", "Landroid/view/ViewGroup;", "isTheSameView", "", "targetView", "pathElement", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.Companion {
            private com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.Companion() {
            }

            public com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final List findViewByPath(@Nullable EventBinding eventBinding0, @Nullable View view0, @NotNull List list0, int v, int v1, @NotNull String s) {
                q.g(list0, "path");
                q.g(s, "mapKey");
                String s1 = s + '.' + v1;
                List list1 = new ArrayList();
                if(view0 != null) {
                    if(v >= list0.size()) {
                        list1.add(new MatchedView(view0, s1));
                        goto label_26;
                    }
                    else {
                        PathComponent pathComponent0 = (PathComponent)list0.get(v);
                        if(q.b(pathComponent0.getClassName(), "..")) {
                            ViewParent viewParent0 = view0.getParent();
                            if(viewParent0 instanceof ViewGroup) {
                                List list2 = this.findVisibleChildren(((ViewGroup)viewParent0));
                                int v2 = list2.size();
                                for(int v3 = 0; v3 < v2; ++v3) {
                                    list1.addAll(this.findViewByPath(eventBinding0, ((View)list2.get(v3)), list0, v + 1, v3, s1));
                                }
                                return list1;
                            }
                        }
                        else {
                            if(q.b(pathComponent0.getClassName(), ".")) {
                                list1.add(new MatchedView(view0, s1));
                                return list1;
                            }
                            if(this.isTheSameView(view0, pathComponent0, v1)) {
                                if(v == list0.size() - 1) {
                                    list1.add(new MatchedView(view0, s1));
                                }
                            label_26:
                                if(view0 instanceof ViewGroup) {
                                    List list3 = this.findVisibleChildren(((ViewGroup)view0));
                                    int v4 = list3.size();
                                    for(int v5 = 0; v5 < v4; ++v5) {
                                        list1.addAll(this.findViewByPath(eventBinding0, ((View)list3.get(v5)), list0, v + 1, v5, s1));
                                    }
                                }
                            }
                        }
                    }
                }
                return list1;
            }

            private final List findVisibleChildren(ViewGroup viewGroup0) {
                List list0 = new ArrayList();
                int v = viewGroup0.getChildCount();
                for(int v1 = 0; v1 < v; ++v1) {
                    View view0 = viewGroup0.getChildAt(v1);
                    if(view0.getVisibility() == 0) {
                        list0.add(view0);
                    }
                }
                return list0;
            }

            private final boolean isTheSameView(View view0, PathComponent pathComponent0, int v) {
                if(pathComponent0.getIndex() == -1 || v == pathComponent0.getIndex()) {
                    if(q.b(view0.getClass().getCanonicalName(), pathComponent0.getClassName())) {
                    label_11:
                        if((pathComponent0.getMatchBitmask() & MatchBitmaskType.ID.getValue()) <= 0 || pathComponent0.getId() == view0.getId()) {
                            if((pathComponent0.getMatchBitmask() & MatchBitmaskType.TEXT.getValue()) > 0) {
                                String s2 = pathComponent0.getText();
                                String s3 = ViewHierarchy.getTextOfView(view0);
                                String s4 = Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(s3), "");
                                if(q.b(s2, s3) || q.b(s2, s4)) {
                                    goto label_17;
                                }
                            }
                            else {
                            label_17:
                                if((pathComponent0.getMatchBitmask() & MatchBitmaskType.DESCRIPTION.getValue()) > 0) {
                                    String s5 = pathComponent0.getDescription();
                                    String s6 = view0.getContentDescription() == null ? "" : view0.getContentDescription().toString();
                                    String s7 = Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(s6), "");
                                    if(q.b(s5, s6) || q.b(s5, s7)) {
                                        goto label_22;
                                    }
                                }
                                else {
                                label_22:
                                    if((pathComponent0.getMatchBitmask() & MatchBitmaskType.HINT.getValue()) <= 0) {
                                        goto label_27;
                                    }
                                    String s8 = pathComponent0.getHint();
                                    String s9 = ViewHierarchy.getHintOfView(view0);
                                    String s10 = Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(s9), "");
                                    if(q.b(s8, s9) || q.b(s8, s10)) {
                                    label_27:
                                        if((pathComponent0.getMatchBitmask() & MatchBitmaskType.TAG.getValue()) > 0) {
                                            String s11 = pathComponent0.getTag();
                                            String s12 = view0.getTag() == null ? "" : view0.getTag().toString();
                                            String s13 = Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(s12), "");
                                            return q.b(s11, s12) || q.b(s11, s13);
                                        }
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                    else {
                        String s = pathComponent0.getClassName();
                        Pattern pattern0 = Pattern.compile(".*android\\..*");
                        q.f(pattern0, "compile(...)");
                        q.g(s, "input");
                        if(pattern0.matcher(s).matches()) {
                            List list0 = o.R0(pathComponent0.getClassName(), new String[]{"."}, 0, 6);
                            if(!list0.isEmpty()) {
                                String s1 = (String)Z.h(1, list0);
                                if(view0.getClass().getSimpleName().equals(s1)) {
                                    goto label_11;
                                }
                            }
                        }
                    }
                }
                return false;
            }
        }

        @NotNull
        public static final com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.Companion Companion;
        @NotNull
        private final String activityName;
        @Nullable
        private List eventBindings;
        @NotNull
        private final Handler handler;
        @NotNull
        private final HashSet listenerSet;
        @NotNull
        private final WeakReference rootView;

        static {
            ViewMatcher.Companion = new com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.Companion(null);
        }

        public ViewMatcher(@Nullable View view0, @NotNull Handler handler0, @NotNull HashSet hashSet0, @NotNull String s) {
            q.g(handler0, "handler");
            q.g(hashSet0, "listenerSet");
            q.g(s, "activityName");
            super();
            this.rootView = new WeakReference(view0);
            this.handler = handler0;
            this.listenerSet = hashSet0;
            this.activityName = s;
            handler0.postDelayed(this, 200L);
        }

        private final void attachListener(MatchedView codelessMatcher$MatchedView0, View view0, EventBinding eventBinding0) {
            if(eventBinding0 == null) {
                return;
            }
            else {
                try {
                    View view1 = codelessMatcher$MatchedView0.getView();
                    if(view1 != null) {
                        View view2 = ViewHierarchy.findRCTRootView(view1);
                        if(view2 != null && ViewHierarchy.INSTANCE.isRCTButton(view1, view2)) {
                            this.attachRCTListener(codelessMatcher$MatchedView0, view0, eventBinding0);
                            return;
                        }
                        if(!v.r0(view1.getClass().getName(), "com.facebook.react", false)) {
                            if(!(view1 instanceof AdapterView)) {
                                this.attachOnClickListener(codelessMatcher$MatchedView0, view0, eventBinding0);
                                return;
                            }
                            if(view1 instanceof ListView) {
                                this.attachOnItemClickListener(codelessMatcher$MatchedView0, view0, eventBinding0);
                            }
                        }
                    }
                    return;
                }
                catch(Exception exception0) {
                }
            }
            Utility.logd(CodelessMatcher.access$getTAG$cp(), exception0);
        }

        private final void attachOnClickListener(MatchedView codelessMatcher$MatchedView0, View view0, EventBinding eventBinding0) {
            boolean z;
            View view1 = codelessMatcher$MatchedView0.getView();
            if(view1 != null) {
                String s = codelessMatcher$MatchedView0.getViewMapKey();
                View.OnClickListener view$OnClickListener0 = ViewHierarchy.getExistingOnClickListener(view1);
                if(view$OnClickListener0 instanceof AutoLoggingOnClickListener) {
                    q.e(view$OnClickListener0, "null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener");
                    z = ((AutoLoggingOnClickListener)view$OnClickListener0).getSupportCodelessLogging();
                }
                else {
                    z = false;
                }
                if(!this.listenerSet.contains(s) && !z) {
                    view1.setOnClickListener(CodelessLoggingEventListener.getOnClickListener(eventBinding0, view0, view1));
                    this.listenerSet.add(s);
                }
            }
        }

        private final void attachOnItemClickListener(MatchedView codelessMatcher$MatchedView0, View view0, EventBinding eventBinding0) {
            boolean z;
            AdapterView adapterView0 = (AdapterView)codelessMatcher$MatchedView0.getView();
            if(adapterView0 != null) {
                String s = codelessMatcher$MatchedView0.getViewMapKey();
                AdapterView.OnItemClickListener adapterView$OnItemClickListener0 = adapterView0.getOnItemClickListener();
                if(adapterView$OnItemClickListener0 instanceof AutoLoggingOnItemClickListener) {
                    q.e(adapterView$OnItemClickListener0, "null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener");
                    z = ((AutoLoggingOnItemClickListener)adapterView$OnItemClickListener0).getSupportCodelessLogging();
                }
                else {
                    z = false;
                }
                if(!this.listenerSet.contains(s) && !z) {
                    adapterView0.setOnItemClickListener(CodelessLoggingEventListener.getOnItemClickListener(eventBinding0, view0, adapterView0));
                    this.listenerSet.add(s);
                }
            }
        }

        private final void attachRCTListener(MatchedView codelessMatcher$MatchedView0, View view0, EventBinding eventBinding0) {
            boolean z;
            View view1 = codelessMatcher$MatchedView0.getView();
            if(view1 != null) {
                String s = codelessMatcher$MatchedView0.getViewMapKey();
                View.OnTouchListener view$OnTouchListener0 = ViewHierarchy.getExistingOnTouchListener(view1);
                if(view$OnTouchListener0 instanceof AutoLoggingOnTouchListener) {
                    q.e(view$OnTouchListener0, "null cannot be cast to non-null type com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener");
                    z = ((AutoLoggingOnTouchListener)view$OnTouchListener0).getSupportCodelessLogging();
                }
                else {
                    z = false;
                }
                if(!this.listenerSet.contains(s) && !z) {
                    view1.setOnTouchListener(RCTCodelessLoggingEventListener.getOnTouchListener(eventBinding0, view0, view1));
                    this.listenerSet.add(s);
                }
            }
        }

        private final void findView(EventBinding eventBinding0, View view0) {
            if(eventBinding0 != null && view0 != null) {
                String s = eventBinding0.getActivityName();
                if(s == null || s.length() == 0 || q.b(eventBinding0.getActivityName(), this.activityName)) {
                    List list0 = eventBinding0.getViewPath();
                    if(list0.size() <= 25) {
                        for(Object object0: ViewMatcher.Companion.findViewByPath(eventBinding0, view0, list0, 0, -1, this.activityName)) {
                            this.attachListener(((MatchedView)object0), view0, eventBinding0);
                        }
                    }
                }
            }
        }

        @NotNull
        public static final List findViewByPath(@Nullable EventBinding eventBinding0, @Nullable View view0, @NotNull List list0, int v, int v1, @NotNull String s) {
            return ViewMatcher.Companion.findViewByPath(eventBinding0, view0, list0, v, v1, s);
        }

        @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.startMatch();
        }

        @Override  // android.view.ViewTreeObserver$OnScrollChangedListener
        public void onScrollChanged() {
            this.startMatch();
        }

        @Override
        public void run() {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            else {
                try {
                    FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
                    if(fetchedAppSettings0 != null && fetchedAppSettings0.getCodelessEventsEnabled()) {
                        List list0 = EventBinding.Companion.parseArray(fetchedAppSettings0.getEventBindings());
                        this.eventBindings = list0;
                        if(list0 != null) {
                            View view0 = (View)this.rootView.get();
                            if(view0 != null) {
                                ViewTreeObserver viewTreeObserver0 = view0.getViewTreeObserver();
                                if(viewTreeObserver0.isAlive()) {
                                    viewTreeObserver0.addOnGlobalLayoutListener(this);
                                    viewTreeObserver0.addOnScrollChangedListener(this);
                                }
                                this.startMatch();
                            }
                        }
                    }
                    return;
                }
                catch(Throwable throwable0) {
                }
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }

        private final void startMatch() {
            List list0 = this.eventBindings;
            if(list0 != null && this.rootView.get() != null) {
                int v = list0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    this.findView(((EventBinding)list0.get(v1)), ((View)this.rootView.get()));
                }
            }
        }
    }

    @NotNull
    private static final String CURRENT_CLASS_NAME = ".";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String PARENT_CLASS_NAME = "..";
    private static final String TAG;
    @NotNull
    private final Set activitiesSet;
    @NotNull
    private final HashMap activityToListenerMap;
    @Nullable
    private static CodelessMatcher codelessMatcher;
    @NotNull
    private HashSet listenerSet;
    @NotNull
    private final Handler uiThreadHandler;
    @NotNull
    private final Set viewMatchers;

    static {
        CodelessMatcher.Companion = new Companion(null);
        CodelessMatcher.TAG = CodelessMatcher.class.getCanonicalName();
    }

    private CodelessMatcher() {
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        Set set0 = Collections.newSetFromMap(new WeakHashMap());
        q.f(set0, "newSetFromMap(WeakHashMap())");
        this.activitiesSet = set0;
        this.viewMatchers = new LinkedHashSet();
        this.listenerSet = new HashSet();
        this.activityToListenerMap = new HashMap();
    }

    public CodelessMatcher(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    public static void a(CodelessMatcher codelessMatcher0) {
        CodelessMatcher.startTracking$lambda$1(codelessMatcher0);
    }

    // 去混淆评级： 低(20)
    public static final CodelessMatcher access$getCodelessMatcher$cp() {
        return CrashShieldHandler.isObjectCrashing(CodelessMatcher.class) ? null : CodelessMatcher.codelessMatcher;
    }

    // 去混淆评级： 低(20)
    public static final String access$getTAG$cp() {
        return CrashShieldHandler.isObjectCrashing(CodelessMatcher.class) ? null : CodelessMatcher.TAG;
    }

    public static final void access$setCodelessMatcher$cp(CodelessMatcher codelessMatcher0) {
        if(CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
            return;
        }
        CodelessMatcher.codelessMatcher = codelessMatcher0;
    }

    public final void add(@NotNull Activity activity0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                q.g(activity0, "activity");
                if(!InternalSettings.isUnityApp()) {
                    if(Thread.currentThread() != Looper.getMainLooper().getThread()) {
                        throw new FacebookException("Can\'t add activity to CodelessMatcher on non-UI thread");
                    }
                    this.activitiesSet.add(activity0);
                    this.listenerSet.clear();
                    HashSet hashSet0 = (HashSet)this.activityToListenerMap.get(activity0.hashCode());
                    if(hashSet0 != null) {
                        this.listenerSet = hashSet0;
                    }
                    this.startTracking();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public final void destroy(@NotNull Activity activity0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(activity0, "activity");
            this.activityToListenerMap.remove(activity0.hashCode());
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    @NotNull
    public static final CodelessMatcher getInstance() {
        Class class0 = CodelessMatcher.class;
        __monitor_enter(class0);
        int v = FIN.finallyOpen$NT();
        if(CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(class0);
            FIN.finallyCodeEnd$NT(v);
            return null;
        }
        try {
            CodelessMatcher codelessMatcher0 = CodelessMatcher.Companion.getInstance();
            FIN.finallyExec$NT(v);
            return codelessMatcher0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, CodelessMatcher.class);
            FIN.finallyExec$NT(v);
            return null;
        }
    }

    @NotNull
    public static final Bundle getParameters(@Nullable EventBinding eventBinding0, @NotNull View view0, @NotNull View view1) {
        Class class0 = CodelessMatcher.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return CodelessMatcher.Companion.getParameters(eventBinding0, view0, view1);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    private final void matchViews() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                for(Object object0: this.activitiesSet) {
                    Activity activity0 = (Activity)object0;
                    if(activity0 != null) {
                        View view0 = AppEventUtility.getRootView(activity0);
                        String s = activity0.getClass().getSimpleName();
                        ViewMatcher codelessMatcher$ViewMatcher0 = new ViewMatcher(view0, this.uiThreadHandler, this.listenerSet, s);
                        this.viewMatchers.add(codelessMatcher$ViewMatcher0);
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public final void remove(@NotNull Activity activity0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                q.g(activity0, "activity");
                if(!InternalSettings.isUnityApp()) {
                    if(Thread.currentThread() != Looper.getMainLooper().getThread()) {
                        throw new FacebookException("Can\'t remove activity from CodelessMatcher on non-UI thread");
                    }
                    this.activitiesSet.remove(activity0);
                    this.viewMatchers.clear();
                    Object object0 = this.listenerSet.clone();
                    q.e(object0, "null cannot be cast to non-null type java.util.HashSet<kotlin.String>{ kotlin.collections.TypeAliasesKt.HashSet<kotlin.String> }");
                    this.activityToListenerMap.put(activity0.hashCode(), ((HashSet)object0));
                    this.listenerSet.clear();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void startTracking() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if(Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.matchViews();
                return;
            }
            c c0 = new c(this, 2);
            this.uiThreadHandler.post(c0);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private static final void startTracking$lambda$1(CodelessMatcher codelessMatcher0) {
        Class class0 = CodelessMatcher.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(codelessMatcher0, "this$0");
            codelessMatcher0.matchViews();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }
}

