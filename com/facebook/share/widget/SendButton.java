package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.R.style;

public final class SendButton extends ShareButtonBase {
    public SendButton(Context context0) {
        super(context0, null, 0, "fb_send_button_create", "fb_send_button_did_tap");
    }

    public SendButton(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0, 0, "fb_send_button_create", "fb_send_button_did_tap");
    }

    public SendButton(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v, "fb_send_button_create", "fb_send_button_did_tap");
    }

    @Override  // com.facebook.FacebookButtonBase
    public int getDefaultRequestCode() {
        return RequestCodeOffset.Message.toRequestCode();
    }

    @Override  // com.facebook.FacebookButtonBase
    public int getDefaultStyleResource() {
        return style.com_facebook_button_send;
    }

    @Override  // com.facebook.share.widget.ShareButtonBase
    public ShareDialog getDialog() {
        ShareDialog shareDialog0;
        if(this.getFragment() == null) {
            shareDialog0 = this.getNativeFragment() == null ? new MessageDialog(this.getActivity(), this.getRequestCode()) : new MessageDialog(this.getNativeFragment(), this.getRequestCode());
        }
        else {
            shareDialog0 = new MessageDialog(this.getFragment(), this.getRequestCode());
        }
        shareDialog0.setCallbackManager(this.getCallbackManager());
        return shareDialog0;
    }
}

