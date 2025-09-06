package com.facebook.appevents;

import A8.M;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.b;
import androidx.media3.session.legacy.V;
import com.facebook.GraphRequest;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.bolts.CancellationTokenSource;
import com.facebook.bolts.Task.Companion;
import com.facebook.bolts.TaskCompletionSource;
import com.facebook.internal.FacebookWebFallbackDialog;
import com.facebook.internal.FetchedAppGateKeepersManager.Callback;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.FileLruCache;
import com.facebook.login.DeviceAuthDialog;
import com.facebook.login.widget.ToolTipPopup;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.h;
import com.iloen.melon.custom.G1;
import com.iloen.melon.custom.TypeAnimationText;
import com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment;
import com.iloen.melon.utils.NameValuePairList;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.kakao.emoticon.ui.widget.EmptyRetryView;
import d5.m;
import f1.A;
import f1.z;
import f2.d;
import g0.e;
import i.n.i.b.a.s.e.Sd;
import i.n.i.b.a.s.e.r1;
import i.n.i.b.a.s.e.sa;
import i.n.i.b.a.s.e.u8;
import i.n.i.b.a.s.e.z0;
import ie.j;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.q;

public final class c implements Runnable {
    public final int a;
    public final Object b;

    public c(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void run() {
        String s;
        switch(this.a) {
            case 0: {
                UserDataStore.setUserDataAndHash$lambda$1(((Bundle)this.b));
                return;
            }
            case 1: {
                AppEventsConversionsAPITransformerWebRequests.a(((GraphRequest)this.b));
                return;
            }
            case 2: {
                CodelessMatcher.a(((CodelessMatcher)this.b));
                return;
            }
            case 3: {
                CancellationTokenSource.c(((CancellationTokenSource)this.b));
                return;
            }
            case 4: {
                Companion.f(((TaskCompletionSource)this.b));
                return;
            }
            case 5: {
                FacebookWebFallbackDialog.d(((FacebookWebFallbackDialog)this.b));
                return;
            }
            case 6: {
                FetchedAppGateKeepersManager.b(((Callback)this.b));
                return;
            }
            case 7: {
                FetchedAppSettingsManager.b(((FetchedAppSettingsCallback)this.b));
                return;
            }
            case 8: {
                FileLruCache.a(((File[])this.b));
                return;
            }
            case 9: {
                FileLruCache.b(((FileLruCache)this.b));
                return;
            }
            case 10: {
                DeviceAuthDialog.q(((DeviceAuthDialog)this.b));
                return;
            }
            case 11: {
                ToolTipPopup.a(((ToolTipPopup)this.b));
                return;
            }
            case 12: {
                ((AdsLoader)this.b).stop();
                return;
            }
            case 13: {
                DefaultTimeBar.b(((DefaultTimeBar)this.b));
                return;
            }
            case 14: {
                ((V)this.b).z(true);
                return;
            }
            case 15: {
                ((com.google.android.material.textfield.c)this.b).t(true);
                return;
            }
            case 16: {
                boolean z = ((h)this.b).h.isPopupShowing();
                ((h)this.b).t(z);
                ((h)this.b).m = z;
                return;
            }
            case 17: {
                ((TextInputLayout)this.b).d.requestLayout();
                return;
            }
            case 18: {
                TypeAnimationText.d(((TypeAnimationText)this.b));
                return;
            }
            case 19: {
                ((G1)this.b).c = false;
                return;
            }
            case 20: {
                MusicMessageEditorFragment.s0(((MusicMessageEditorFragment)this.b));
                return;
            }
            case 21: {
                Navigator.openUrl(null, M.b0, OpenType.DefaultWebView, ((NameValuePairList)this.b), true);
                return;
            }
            case 22: {
                EmptyRetryView.b(((EmptyRetryView)this.b));
                return;
            }
            case 23: {
                m m0 = ((A)this.b).b;
                Boolean boolean0 = null;
                ((A)this.b).n = null;
                e e0 = ((A)this.b).m;
                View view0 = ((A)this.b).a;
                if(!view0.isFocused()) {
                    View view1 = view0.getRootView().findFocus();
                    if(view1 != null && view1.onCheckIsTextEditor()) {
                        e0.g();
                        return;
                    }
                }
                Object[] arr_object = e0.a;
                int v2 = e0.c;
                Boolean boolean1 = null;
                for(int v3 = 0; v3 < v2; ++v3) {
                    z z1 = (z)arr_object[v3];
                    int v4 = z1.ordinal();
                    switch(v4) {
                        case 0: {
                            boolean0 = Boolean.TRUE;
                            boolean1 = Boolean.TRUE;
                            break;
                        }
                        case 1: {
                            boolean0 = Boolean.FALSE;
                            boolean1 = Boolean.FALSE;
                            break;
                        }
                        default: {
                            if((v4 == 2 || v4 == 3) && !q.b(boolean0, Boolean.FALSE)) {
                                boolean1 = Boolean.valueOf(z1 == z.c);
                            }
                        }
                    }
                }
                e0.g();
                if(q.b(boolean0, Boolean.TRUE)) {
                    ((InputMethodManager)((j)m0.c).getValue()).restartInput(((View)m0.b));
                }
                if(boolean1 != null) {
                    if(boolean1.booleanValue()) {
                        ((N4.z)((b)m0.d).b).d();
                    }
                    else {
                        ((N4.z)((b)m0.d).b).c();
                    }
                }
                if(q.b(boolean0, Boolean.FALSE)) {
                    ((InputMethodManager)((j)m0.c).getValue()).restartInput(((View)m0.b));
                }
                return;
            }
            case 24: {
                f2.b b0 = ((d)this.b).a;
                ViewParent viewParent0 = b0.getParent();
                if(viewParent0 instanceof ViewGroup) {
                    ((ViewGroup)viewParent0).removeView(b0);
                }
                return;
            }
            case 25: {
                boolean z2 = false;
                H8.q q0 = (H8.q)this.b;
                synchronized(((AtomicMarkableReference)q0.g)) {
                    if(((AtomicMarkableReference)q0.g).isMarked()) {
                        s = (String)((AtomicMarkableReference)q0.g).getReference();
                        ((AtomicMarkableReference)q0.g).set(s, false);
                        z2 = true;
                    }
                    else {
                        s = null;
                    }
                }
                if(z2) {
                    ((g7.h)q0.a).j(((String)q0.c), s);
                }
                return;
            }
            case 26: {
                A3.c c0 = (A3.c)this.b;
                Map map0 = null;
                ((AtomicReference)c0.c).set(null);
                synchronized(c0) {
                    if(((AtomicMarkableReference)c0.b).isMarked()) {
                        g7.e e1 = (g7.e)((AtomicMarkableReference)c0.b).getReference();
                        synchronized(e1) {
                            map0 = Collections.unmodifiableMap(new HashMap(e1.a));
                        }
                        g7.e e2 = (g7.e)((AtomicMarkableReference)c0.b).getReference();
                        ((AtomicMarkableReference)c0.b).set(e2, false);
                    }
                }
                if(map0 != null) {
                    H8.q q1 = (H8.q)c0.d;
                    ((g7.h)q1.a).h(((String)q1.c), map0, c0.a);
                }
                return;
            }
            case 27: {
                ((z0)this.b).u();
                return;
            }
            case 28: {
                ((r1)this.b).i();
                return;
            }
            default: {
                sa sa0 = ((u8)this.b).j;
                int v = ((u8)this.b).e.a(4);
                long v1 = sa0.e(((u8)this.b).c, ((u8)this.b).g, v);
                Sd sd0 = new Sd(((u8)this.b).c.a, v1);
                ((u8)this.b).d.q(sd0, 4);
            }
        }
    }
}

