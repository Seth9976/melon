package com.facebook.gamingservices;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.I;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.List;

@AutoHandleExceptions
public class FriendFinderDialog extends FacebookDialogBase {
    public static class Result {
    }

    private static final int DEFAULT_REQUEST_CODE;
    private FacebookCallback mCallback;

    static {
        FriendFinderDialog.DEFAULT_REQUEST_CODE = RequestCodeOffset.GamingFriendFinder.toRequestCode();
    }

    public FriendFinderDialog(Activity activity0) {
        super(activity0, FriendFinderDialog.DEFAULT_REQUEST_CODE);
    }

    public FriendFinderDialog(Fragment fragment0) {
        super(new FragmentWrapper(fragment0), FriendFinderDialog.DEFAULT_REQUEST_CODE);
    }

    public FriendFinderDialog(I i0) {
        super(new FragmentWrapper(i0), FriendFinderDialog.DEFAULT_REQUEST_CODE);
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
        this.mCallback = facebookCallback0;
        callbackManagerImpl0.registerCallback(this.getRequestCode(), new Callback() {
            @Override  // com.facebook.internal.CallbackManagerImpl$Callback
            public boolean onActivityResult(int v, Intent intent0) {
                if(intent0 != null && intent0.hasExtra("error")) {
                    FacebookException facebookException0 = ((FacebookRequestError)intent0.getParcelableExtra("error")).getException();
                    facebookCallback0.onError(facebookException0);
                    return true;
                }
                Result friendFinderDialog$Result0 = new Result();
                facebookCallback0.onSuccess(friendFinderDialog$Result0);
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
        AccessToken accessToken0 = AccessToken.getCurrentAccessToken();
        if(accessToken0 == null || accessToken0.isExpired()) {
            throw new FacebookException("Attempted to open GamingServices FriendFinder with an invalid access token");
        }
        this.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(("https://fb.gg/me/friendfinder/" + accessToken0.getApplicationId()))), this.getRequestCode());

        class com.facebook.gamingservices.FriendFinderDialog.1 implements com.facebook.gamingservices.cloudgaming.DaemonRequest.Callback {
            @Override  // com.facebook.gamingservices.cloudgaming.DaemonRequest$Callback
            public void onCompleted(GraphResponse graphResponse0) {
                if(FriendFinderDialog.this.mCallback != null) {
                    if(graphResponse0.getError() != null) {
                        FacebookException facebookException0 = new FacebookException(graphResponse0.getError().getErrorMessage());
                        FriendFinderDialog.this.mCallback.onError(facebookException0);
                        return;
                    }
                    Result friendFinderDialog$Result0 = new Result();
                    FriendFinderDialog.this.mCallback.onSuccess(friendFinderDialog$Result0);
                }
            }
        }

    }
}

