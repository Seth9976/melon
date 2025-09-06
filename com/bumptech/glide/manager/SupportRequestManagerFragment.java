package com.bumptech.glide.manager;

import androidx.fragment.app.I;
import com.bumptech.glide.RequestManager;

@Deprecated
public class SupportRequestManagerFragment extends I {
    @Deprecated
    public RequestManager getRequestManager() {
        return null;
    }

    @Deprecated
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return new EmptyRequestManagerTreeNode();
    }

    @Deprecated
    public void setRequestManager(RequestManager requestManager0) {
    }
}

