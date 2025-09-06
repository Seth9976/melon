package com.facebook.gamingservices;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.I;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.List;

@AutoHandleExceptions
public class GamingGroupIntegration extends FacebookDialogBase {
    public static class Result {
    }

    private static final int DEFAULT_REQUEST_CODE = 0;
    private static final String ERROR_KEY = "error";

    static {
        GamingGroupIntegration.DEFAULT_REQUEST_CODE = RequestCodeOffset.GamingGroupIntegration.toRequestCode();
    }

    public GamingGroupIntegration(Activity activity0) {
        super(activity0, GamingGroupIntegration.DEFAULT_REQUEST_CODE);
    }

    public GamingGroupIntegration(Fragment fragment0) {
        super(new FragmentWrapper(fragment0), GamingGroupIntegration.DEFAULT_REQUEST_CODE);
    }

    public GamingGroupIntegration(I i0) {
        super(new FragmentWrapper(i0), GamingGroupIntegration.DEFAULT_REQUEST_CODE);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return null;
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public List getOrderedModeHandlers() {
        return null;
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl0, FacebookCallback facebookCallback0) {
        callbackManagerImpl0.registerCallback(this.getRequestCode(), new Callback() {
            @Override  // com.facebook.internal.CallbackManagerImpl$Callback
            public boolean onActivityResult(int v, Intent intent0) {
                if(intent0 != null && intent0.hasExtra("error")) {
                    FacebookException facebookException0 = ((FacebookRequestError)intent0.getParcelableExtra("error")).getException();
                    facebookCallback0.onError(facebookException0);
                    return true;
                }
                Result gamingGroupIntegration$Result0 = new Result();
                facebookCallback0.onSuccess(gamingGroupIntegration$Result0);
                return true;
            }
        });
    }

    public void show() {
        this.showImpl();
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public void show(Object object0) {
        this.show(((Void)object0));
    }

    public void show(Void void0) {
        this.showImpl();
    }

    public void showImpl() {
        this.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(("https://fb.gg/me/community/" + FacebookSdk.getApplicationId()))), this.getRequestCode());
    }
}

