package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.R.drawable;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.R.style;
import d5.w;

public final class ShareButton extends ShareButtonBase {
    public ShareButton(Context context0) {
        super(context0, null, 0, "fb_share_button_create", "fb_share_button_did_tap");
    }

    public ShareButton(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0, 0, "fb_share_button_create", "fb_share_button_did_tap");
    }

    public ShareButton(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v, "fb_share_button_create", "fb_share_button_did_tap");
    }

    @Override  // com.facebook.share.widget.ShareButtonBase
    public void configureButton(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super.configureButton(context0, attributeSet0, v, v1);
        this.setCompoundDrawablesWithIntrinsicBounds(w.B(this.getContext(), drawable.com_facebook_button_icon), null, null, null);
    }

    @Override  // com.facebook.FacebookButtonBase
    public int getDefaultRequestCode() {
        return RequestCodeOffset.Share.toRequestCode();
    }

    @Override  // com.facebook.FacebookButtonBase
    public int getDefaultStyleResource() {
        return style.com_facebook_button_share;
    }

    @Override  // com.facebook.share.widget.ShareButtonBase
    public ShareDialog getDialog() {
        ShareDialog shareDialog0;
        if(this.getFragment() == null) {
            shareDialog0 = this.getNativeFragment() == null ? new ShareDialog(this.getActivity(), this.getRequestCode()) : new ShareDialog(this.getNativeFragment(), this.getRequestCode());
        }
        else {
            shareDialog0 = new ShareDialog(this.getFragment(), this.getRequestCode());
        }
        shareDialog0.setCallbackManager(this.getCallbackManager());
        return shareDialog0;
    }
}

