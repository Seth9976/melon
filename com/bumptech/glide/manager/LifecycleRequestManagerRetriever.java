package com.bumptech.glide.manager;

import android.content.Context;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.lifecycle.t;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class LifecycleRequestManagerRetriever {
    final class SupportRequestManagerTreeNode implements RequestManagerTreeNode {
        private final l0 childFragmentManager;

        public SupportRequestManagerTreeNode(l0 l00) {
            this.childFragmentManager = l00;
        }

        private void getChildFragmentsRecursive(l0 l00, Set set0) {
            List list0 = l00.c.f();
            int v = list0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                I i0 = (I)list0.get(v1);
                this.getChildFragmentsRecursive(i0.getChildFragmentManager(), set0);
                RequestManager requestManager0 = LifecycleRequestManagerRetriever.this.getOnly(i0.getLifecycle());
                if(requestManager0 != null) {
                    set0.add(requestManager0);
                }
            }
        }

        @Override  // com.bumptech.glide.manager.RequestManagerTreeNode
        public Set getDescendants() {
            Set set0 = new HashSet();
            this.getChildFragmentsRecursive(this.childFragmentManager, set0);
            return set0;
        }
    }

    private final RequestManagerFactory factory;
    final Map lifecycleToRequestManager;

    public LifecycleRequestManagerRetriever(RequestManagerFactory requestManagerRetriever$RequestManagerFactory0) {
        this.lifecycleToRequestManager = new HashMap();
        this.factory = requestManagerRetriever$RequestManagerFactory0;
    }

    public RequestManager getOnly(t t0) {
        Util.assertMainThread();
        return (RequestManager)this.lifecycleToRequestManager.get(t0);
    }

    public RequestManager getOrCreate(Context context0, Glide glide0, t t0, l0 l00, boolean z) {
        Util.assertMainThread();
        RequestManager requestManager0 = this.getOnly(t0);
        if(requestManager0 == null) {
            LifecycleLifecycle lifecycleLifecycle0 = new LifecycleLifecycle(t0);
            SupportRequestManagerTreeNode lifecycleRequestManagerRetriever$SupportRequestManagerTreeNode0 = new SupportRequestManagerTreeNode(this, l00);
            RequestManager requestManager1 = this.factory.build(glide0, lifecycleLifecycle0, lifecycleRequestManagerRetriever$SupportRequestManagerTreeNode0, context0);
            this.lifecycleToRequestManager.put(t0, requestManager1);
            lifecycleLifecycle0.addListener(new LifecycleListener() {
                @Override  // com.bumptech.glide.manager.LifecycleListener
                public void onDestroy() {
                    LifecycleRequestManagerRetriever.this.lifecycleToRequestManager.remove(t0);
                }

                @Override  // com.bumptech.glide.manager.LifecycleListener
                public void onStart() {
                }

                @Override  // com.bumptech.glide.manager.LifecycleListener
                public void onStop() {
                }
            });
            if(z) {
                requestManager1.onStart();
            }
            return requestManager1;
        }
        return requestManager0;
    }
}

