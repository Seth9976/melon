package b;

import J8.t3;
import U4.x;
import V4.s;
import Z4.b;
import a5.a;
import a5.c;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.activity.ComponentActivity;
import b5.e;
import com.facebook.AccessToken.AccessTokenRefreshCallback;
import com.facebook.AccessTokenManager;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest.Companion;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.GraphRequestBatch;
import com.facebook.ProgressOutputStream;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.SessionEventsState;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.bolts.TaskCompletionSource;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.login.widget.LoginButton;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import com.google.android.material.datepicker.E;
import com.google.android.material.datepicker.h;
import com.iloen.melon.fragments.comments.CmtBaseFragment;
import com.iloen.melon.fragments.comments.CmtWriteFragment;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.kakao.emoticon.util.SoftInputHelper;
import e3.o;
import e5.i;
import e7.k;
import f7.d;
import i.n.i.b.a.s.e.S3;
import i.n.i.b.a.s.e.n4;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicMarkableReference;
import kotlin.jvm.internal.q;

public final class l implements Runnable {
    public final int a;
    public final Object b;
    public final Object c;

    public l(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override
    public final void run() {
        boolean z;
        switch(this.a) {
            case 0: {
                ((ComponentActivity)this.b).addObserverForBackInvoker(((t)this.c));
                return;
            }
            case 1: {
                e e0 = (e)this.c;
                for(Object object0: ((List)this.b)) {
                    Object object1 = e0.e;
                    c c0 = ((a)object0).a;
                    b b0 = c0.e(object1) ? new b(c0.d()) : Z4.a.a;
                    ((a)object0).b.getChannel().trySend-JP2dKIU(b0);
                }
                return;
            }
            case 2: {
                AccessTokenManager.c(((AccessTokenManager)this.b), ((AccessTokenRefreshCallback)this.c));
                return;
            }
            case 3: {
                FacebookSdk.d(((Context)this.b), ((String)this.c));
                return;
            }
            case 4: {
                Companion.a(((ArrayList)this.b), ((GraphRequestBatch)this.c));
                return;
            }
            case 5: {
                ProgressOutputStream.c(((Callback)this.b), ((ProgressOutputStream)this.c));
                return;
            }
            case 6: {
                AppEventQueue.d(((AccessTokenAppIdPair)this.b), ((AppEvent)this.c));
                return;
            }
            case 7: {
                AppEventQueue.a(((AccessTokenAppIdPair)this.b), ((SessionEventsState)this.c));
                return;
            }
            case 8: {
                com.facebook.appevents.AppEventsLoggerImpl.Companion.b(((Context)this.b), ((AppEventsLoggerImpl)this.c));
                return;
            }
            case 9: {
                CodelessLoggingEventListener.a(((Bundle)this.c), ((String)this.b));
                return;
            }
            case 10: {
                ViewIndexer.b(((ViewIndexer)this.b), ((com.facebook.appevents.codeless.ViewIndexer.schedule.indexingTask.1)this.c));
                return;
            }
            case 11: {
                ViewIndexer.a(((String)this.b), ((ViewIndexer)this.c));
                return;
            }
            case 12: {
                com.facebook.bolts.Task.Companion.b(((ScheduledFuture)this.b), ((TaskCompletionSource)this.c));
                return;
            }
            case 13: {
                LoginButton.b(((LoginButton)this.b), ((FetchedAppSettings)this.c));
                return;
            }
            case 14: {
                LoginButton.c(((String)this.b), ((LoginButton)this.c));
                return;
            }
            case 15: {
                return;
            }
            case 16: {
                SphericalGLSurfaceView.b(((SphericalGLSurfaceView)this.b), ((SurfaceTexture)this.c));
                return;
            }
            case 17: {
                return;
            }
            case 18: {
                return;
            }
            case 19: {
                ((h)this.b).a.getContext();
                Date date0 = new Date(E.f().getTimeInMillis());
                String s = String.format("Example: %1$s", ((h)this.b).c.format(date0).replace(' ', ' '));
                ((h)this.b).a.setError(x.l("Invalid format.", "\n", String.format("Use: %1$s", ((String)this.c).replace(' ', ' ')), "\n", s));
                ((h)this.b).a();
                return;
            }
            case 20: {
                CmtBaseFragment.t0(((CmtBaseFragment)this.b), ((cmtList)this.c));
                return;
            }
            case 21: {
                CmtWriteFragment.x0(((CmtWriteFragment)this.b), ((EditText)this.c));
                return;
            }
            case 22: {
                DetailContentsTopicItemHolder.b(((t3)this.b), ((DetailContentsTopicItemHolder)this.c));
                return;
            }
            case 23: {
                SoftInputHelper.a(((Context)this.b), ((View)this.c));
                return;
            }
            case 24: {
                int v = ((o)this.b).c();
                ((w3.e)this.c).a(v);
                return;
            }
            case 25: {
                String s1 = ((UUID)this.c).toString();
                q.f(s1, "id.toString()");
                i.a(((s)this.b), s1);
                return;
            }
            case 26: {
                ((k)this.b).c(((String)this.c), Boolean.FALSE);
                return;
            }
            case 27: {
                H8.q q0 = ((e7.o)this.b).g.d;
                q0.getClass();
                String s2 = g7.e.a(0x400, ((String)this.c));
                synchronized(((AtomicMarkableReference)q0.g)) {
                    String s3 = (String)((AtomicMarkableReference)q0.g).getReference();
                    if(s2 != null) {
                        z = s2.equals(s3);
                    }
                    else if(s3 == null) {
                        z = true;
                    }
                    else {
                        z = false;
                    }
                    if(z) {
                        return;
                    }
                    ((AtomicMarkableReference)q0.g).set(s2, true);
                }
                ((d)q0.b).b.a(new com.facebook.appevents.c(q0, 25));
                return;
            }
            case 28: {
                ((g7.h)((H8.q)this.b).a).i(((String)((H8.q)this.b).c), ((List)this.c));
                return;
            }
            default: {
                ((S3)((ea.c)this.b).c).f(((n4)this.c));
            }
        }
    }
}

