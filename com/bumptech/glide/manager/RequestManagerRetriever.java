package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import androidx.collection.f;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.lifecycle.t;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.Map;

public class RequestManagerRetriever implements Handler.Callback {
    public interface RequestManagerFactory {
        RequestManager build(Glide arg1, Lifecycle arg2, RequestManagerTreeNode arg3, Context arg4);
    }

    private static final RequestManagerFactory DEFAULT_FACTORY = null;
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private volatile RequestManager applicationManager;
    private final RequestManagerFactory factory;
    private final FrameWaiter frameWaiter;
    private final LifecycleRequestManagerRetriever lifecycleRequestManagerRetriever;
    private final f tempViewToSupportFragment;

    static {
        RequestManagerRetriever.DEFAULT_FACTORY = new RequestManagerFactory() {
            @Override  // com.bumptech.glide.manager.RequestManagerRetriever$RequestManagerFactory
            public RequestManager build(Glide glide0, Lifecycle lifecycle0, RequestManagerTreeNode requestManagerTreeNode0, Context context0) {
                return new RequestManager(glide0, lifecycle0, requestManagerTreeNode0, context0);
            }
        };
    }

    public RequestManagerRetriever(RequestManagerFactory requestManagerRetriever$RequestManagerFactory0) {
        this.tempViewToSupportFragment = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        if(requestManagerRetriever$RequestManagerFactory0 == null) {
            requestManagerRetriever$RequestManagerFactory0 = RequestManagerRetriever.DEFAULT_FACTORY;
        }
        this.factory = requestManagerRetriever$RequestManagerFactory0;
        this.lifecycleRequestManagerRetriever = new LifecycleRequestManagerRetriever(requestManagerRetriever$RequestManagerFactory0);
        this.frameWaiter = RequestManagerRetriever.buildFrameWaiter();
    }

    @TargetApi(17)
    private static void assertNotDestroyed(Activity activity0) {
        if(activity0.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static FrameWaiter buildFrameWaiter() {
        return HardwareConfigState.HARDWARE_BITMAPS_SUPPORTED && HardwareConfigState.BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED ? new FirstFrameWaiter() : new DoNothingFirstFrameWaiter();
    }

    private static Activity findActivity(Context context0) {
        if(context0 instanceof Activity) {
            return (Activity)context0;
        }
        return context0 instanceof ContextWrapper ? RequestManagerRetriever.findActivity(((ContextWrapper)context0).getBaseContext()) : null;
    }

    private static void findAllSupportFragmentsWithViews(Collection collection0, Map map0) {
        if(collection0 != null) {
            for(Object object0: collection0) {
                I i0 = (I)object0;
                if(i0 != null && i0.getView() != null) {
                    map0.put(i0.getView(), i0);
                    RequestManagerRetriever.findAllSupportFragmentsWithViews(i0.getChildFragmentManager().c.f(), map0);
                }
            }
        }
    }

    private I findSupportFragment(View view0, FragmentActivity fragmentActivity0) {
        this.tempViewToSupportFragment.clear();
        RequestManagerRetriever.findAllSupportFragmentsWithViews(fragmentActivity0.getSupportFragmentManager().c.f(), this.tempViewToSupportFragment);
        View view1 = fragmentActivity0.findViewById(0x1020002);
        I i0 = null;
        while(!view0.equals(view1)) {
            i0 = (I)this.tempViewToSupportFragment.get(view0);
            if(i0 != null || !(view0.getParent() instanceof View)) {
                break;
            }
            view0 = (View)view0.getParent();
        }
        this.tempViewToSupportFragment.clear();
        return i0;
    }

    @Deprecated
    public RequestManager get(Activity activity0) {
        return this.get(activity0.getApplicationContext());
    }

    @TargetApi(17)
    @Deprecated
    public RequestManager get(Fragment fragment0) {
        if(fragment0.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        return this.get(fragment0.getActivity().getApplicationContext());
    }

    public RequestManager get(Context context0) {
        if(context0 == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if(Util.isOnMainThread() && !(context0 instanceof Application)) {
            if(context0 instanceof FragmentActivity) {
                return this.get(((FragmentActivity)context0));
            }
            return !(context0 instanceof ContextWrapper) || ((ContextWrapper)context0).getBaseContext().getApplicationContext() == null ? this.getApplicationManager(context0) : this.get(((ContextWrapper)context0).getBaseContext());
        }
        return this.getApplicationManager(context0);
    }

    public RequestManager get(View view0) {
        if(Util.isOnBackgroundThread()) {
            return this.get(view0.getContext().getApplicationContext());
        }
        Preconditions.checkNotNull(view0);
        Preconditions.checkNotNull(view0.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activity0 = RequestManagerRetriever.findActivity(view0.getContext());
        if(activity0 == null) {
            return this.get(view0.getContext().getApplicationContext());
        }
        if(activity0 instanceof FragmentActivity) {
            I i0 = this.findSupportFragment(view0, ((FragmentActivity)activity0));
            return i0 == null ? this.get(((FragmentActivity)activity0)) : this.get(i0);
        }
        return this.get(view0.getContext().getApplicationContext());
    }

    public RequestManager get(FragmentActivity fragmentActivity0) {
        if(Util.isOnBackgroundThread()) {
            return this.get(fragmentActivity0.getApplicationContext());
        }
        RequestManagerRetriever.assertNotDestroyed(fragmentActivity0);
        this.frameWaiter.registerSelf(fragmentActivity0);
        boolean z = RequestManagerRetriever.isActivityVisible(fragmentActivity0);
        Glide glide0 = Glide.get(fragmentActivity0.getApplicationContext());
        t t0 = fragmentActivity0.getLifecycle();
        return this.lifecycleRequestManagerRetriever.getOrCreate(fragmentActivity0, glide0, t0, fragmentActivity0.getSupportFragmentManager(), z);
    }

    public RequestManager get(I i0) {
        Preconditions.checkNotNull(i0.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if(Util.isOnBackgroundThread()) {
            return this.get(i0.getContext().getApplicationContext());
        }
        if(i0.getActivity() != null) {
            FragmentActivity fragmentActivity0 = i0.getActivity();
            this.frameWaiter.registerSelf(fragmentActivity0);
        }
        l0 l00 = i0.getChildFragmentManager();
        Context context0 = i0.getContext();
        Glide glide0 = Glide.get(context0.getApplicationContext());
        boolean z = i0.isVisible();
        return this.lifecycleRequestManagerRetriever.getOrCreate(context0, glide0, i0.getLifecycle(), l00, z);
    }

    private RequestManager getApplicationManager(Context context0) {
        if(this.applicationManager == null) {
            synchronized(this) {
                if(this.applicationManager == null) {
                    Glide glide0 = Glide.get(context0.getApplicationContext());
                    ApplicationLifecycle applicationLifecycle0 = new ApplicationLifecycle();
                    EmptyRequestManagerTreeNode emptyRequestManagerTreeNode0 = new EmptyRequestManagerTreeNode();
                    Context context1 = context0.getApplicationContext();
                    this.applicationManager = this.factory.build(glide0, applicationLifecycle0, emptyRequestManagerTreeNode0, context1);
                }
            }
        }
        return this.applicationManager;
    }

    @Override  // android.os.Handler$Callback
    @Deprecated
    public boolean handleMessage(Message message0) {
        return false;
    }

    private static boolean isActivityVisible(Context context0) {
        Activity activity0 = RequestManagerRetriever.findActivity(context0);
        return activity0 == null || !activity0.isFinishing();
    }
}

