package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;

public abstract class ShareButtonBase extends FacebookButtonBase {
    private CallbackManager callbackManager;
    private boolean enabledExplicitlySet;
    private int requestCode;
    private ShareContent shareContent;

    public ShareButtonBase(Context context0, AttributeSet attributeSet0, int v, String s, String s1) {
        super(context0, attributeSet0, v, 0, s, s1);
        this.enabledExplicitlySet = false;
        this.requestCode = this.isInEditMode() ? 0 : this.getDefaultRequestCode();
        this.internalSetEnabled(false);
    }

    public boolean canShare() {
        return this.getDialog().canShow(this.getShareContent());
    }

    @Override  // com.facebook.FacebookButtonBase
    public void configureButton(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super.configureButton(context0, attributeSet0, v, v1);
        this.setInternalOnClickListener(this.getShareOnClickListener());
    }

    public CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    public abstract ShareDialog getDialog();

    @Override  // com.facebook.FacebookButtonBase
    public int getRequestCode() {
        return this.requestCode;
    }

    public ShareContent getShareContent() {
        return this.shareContent;
    }

    public View.OnClickListener getShareOnClickListener() {
        return new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(CrashShieldHandler.isObjectCrashing(this)) {
                    return;
                }
                try {
                    ShareButtonBase.this.callExternalOnClickListener(view0);
                    ShareButtonBase.this.getDialog().show(ShareButtonBase.this.getShareContent());
                }
                catch(Throwable throwable0) {
                    CrashShieldHandler.handleThrowable(throwable0, this);
                }
            }
        };
    }

    private void internalSetEnabled(boolean z) {
        this.setEnabled(z);
        this.enabledExplicitlySet = false;
    }

    private void memorizeCallbackManager(CallbackManager callbackManager0) {
        CallbackManager callbackManager1 = this.callbackManager;
        if(callbackManager1 == null) {
            this.callbackManager = callbackManager0;
            return;
        }
        if(callbackManager1 != callbackManager0) {
            Log.w(ShareButtonBase.class.toString(), "You\'re registering a callback on a Facebook Share Button with two different callback managers. It\'s almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    public void registerCallback(CallbackManager callbackManager0, FacebookCallback facebookCallback0) {
        this.memorizeCallbackManager(callbackManager0);
        ShareInternalUtility.registerSharerCallback(this.getRequestCode(), callbackManager0, facebookCallback0);
    }

    public void registerCallback(CallbackManager callbackManager0, FacebookCallback facebookCallback0, int v) {
        this.setRequestCode(v);
        this.registerCallback(callbackManager0, facebookCallback0);
    }

    @Override  // android.widget.TextView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.enabledExplicitlySet = true;
    }

    public void setRequestCode(int v) {
        if(FacebookSdk.isFacebookRequestCode(v)) {
            throw new IllegalArgumentException("Request code " + v + " cannot be within the range reserved by the Facebook SDK.");
        }
        this.requestCode = v;
    }

    public void setShareContent(ShareContent shareContent0) {
        this.shareContent = shareContent0;
        if(!this.enabledExplicitlySet) {
            this.internalSetEnabled(this.canShare());
        }
    }
}

