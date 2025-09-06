package com.bumptech.glide.manager;

import android.app.Fragment;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.Set;

@Deprecated
public class RequestManagerFragment extends Fragment {
    @Deprecated
    public RequestManager getRequestManager() {
        return null;
    }

    @Deprecated
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return new RequestManagerTreeNode() {
            @Override  // com.bumptech.glide.manager.RequestManagerTreeNode
            public Set getDescendants() {
                return Collections.EMPTY_SET;
            }
        };
    }

    @Deprecated
    public void setRequestManager(RequestManager requestManager0) {
    }
}

