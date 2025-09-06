package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.I;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Validate;
import com.facebook.share.internal.GameRequestValidation;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.GameRequestContent;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class GameRequestDialog extends FacebookDialogBase {
    class ChromeCustomTabHandler extends ModeHandler {
        private ChromeCustomTabHandler() {
        }

        public ChromeCustomTabHandler(com.facebook.share.widget.GameRequestDialog.1 gameRequestDialog$10) {
        }

        public boolean canShow(GameRequestContent gameRequestContent0, boolean z) {
            return CustomTabUtils.getChromePackage() != null && Validate.hasCustomTabRedirectActivity(GameRequestDialog.this.getActivityContext(), CustomTabUtils.getDefaultRedirectURI());
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((GameRequestContent)object0), z);
        }

        public AppCall createAppCall(GameRequestContent gameRequestContent0) {
            GameRequestValidation.validate(gameRequestContent0);
            AppCall appCall0 = GameRequestDialog.this.createBaseAppCall();
            Bundle bundle0 = WebDialogParameters.create(gameRequestContent0);
            AccessToken accessToken0 = AccessToken.getCurrentAccessToken();
            if(accessToken0 == null) {
                bundle0.putString("app_id", FacebookSdk.getApplicationId());
            }
            else {
                bundle0.putString("app_id", accessToken0.getApplicationId());
            }
            bundle0.putString("redirect_uri", CustomTabUtils.getDefaultRedirectURI());
            DialogPresenter.setupAppCallForCustomTabDialog(appCall0, "apprequests", bundle0);
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((GameRequestContent)object0));
        }
    }

    public static final class Result {
        String requestId;
        List to;

        private Result(Bundle bundle0) {
            this.requestId = bundle0.getString("request");
            this.to = new ArrayList();
            while(bundle0.containsKey(String.format("to[%d]", new Object[]{this.to.size()}))) {
                this.to.add(bundle0.getString(String.format("to[%d]", this.to.size())));
            }
        }

        public Result(Bundle bundle0, com.facebook.share.widget.GameRequestDialog.1 gameRequestDialog$10) {
            this(bundle0);
        }

        public String getRequestId() {
            return this.requestId;
        }

        public List getRequestRecipients() {
            return this.to;
        }
    }

    class WebHandler extends ModeHandler {
        private WebHandler() {
        }

        public WebHandler(com.facebook.share.widget.GameRequestDialog.1 gameRequestDialog$10) {
        }

        public boolean canShow(GameRequestContent gameRequestContent0, boolean z) {
            return true;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((GameRequestContent)object0), z);
        }

        public AppCall createAppCall(GameRequestContent gameRequestContent0) {
            GameRequestValidation.validate(gameRequestContent0);
            AppCall appCall0 = GameRequestDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebDialog(appCall0, "apprequests", WebDialogParameters.create(gameRequestContent0));
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((GameRequestContent)object0));
        }
    }

    private static final int DEFAULT_REQUEST_CODE = 0;
    private static final String GAME_REQUEST_DIALOG = "apprequests";

    static {
        GameRequestDialog.DEFAULT_REQUEST_CODE = RequestCodeOffset.GameRequest.toRequestCode();
    }

    public GameRequestDialog(Activity activity0) {
        super(activity0, GameRequestDialog.DEFAULT_REQUEST_CODE);
    }

    public GameRequestDialog(Fragment fragment0) {
        this(new FragmentWrapper(fragment0));
    }

    public GameRequestDialog(I i0) {
        this(new FragmentWrapper(i0));
    }

    private GameRequestDialog(FragmentWrapper fragmentWrapper0) {
        super(fragmentWrapper0, GameRequestDialog.DEFAULT_REQUEST_CODE);
    }

    public static boolean canShow() {
        return true;
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public AppCall createBaseAppCall() {
        return new AppCall(this.getRequestCode());
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public List getOrderedModeHandlers() {
        List list0 = new ArrayList();
        ((ArrayList)list0).add(new ChromeCustomTabHandler(this, null));
        ((ArrayList)list0).add(new WebHandler(this, null));
        return list0;
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl0, FacebookCallback facebookCallback0) {
        callbackManagerImpl0.registerCallback(this.getRequestCode(), new Callback() {
            @Override  // com.facebook.internal.CallbackManagerImpl$Callback
            public boolean onActivityResult(int v, Intent intent0) {
                return ShareInternalUtility.handleActivityResult(GameRequestDialog.this.getRequestCode(), v, intent0, (facebookCallback0 == null ? null : new com.facebook.share.widget.GameRequestDialog.1(this, facebookCallback0, facebookCallback0)));
            }
        });

        class com.facebook.share.widget.GameRequestDialog.1 extends ResultProcessor {
            public com.facebook.share.widget.GameRequestDialog.1(FacebookCallback facebookCallback0, FacebookCallback facebookCallback1) {
            }

            @Override  // com.facebook.share.internal.ResultProcessor
            public void onSuccess(AppCall appCall0, Bundle bundle0) {
                if(bundle0 != null) {
                    Result gameRequestDialog$Result0 = new Result(bundle0, null);
                    this.val$callback.onSuccess(gameRequestDialog$Result0);
                    return;
                }
                this.onCancel(appCall0);
            }
        }

    }

    public static void show(Activity activity0, GameRequestContent gameRequestContent0) {
        new GameRequestDialog(activity0).show(gameRequestContent0);
    }

    public static void show(Fragment fragment0, GameRequestContent gameRequestContent0) {
        GameRequestDialog.show(new FragmentWrapper(fragment0), gameRequestContent0);
    }

    public static void show(I i0, GameRequestContent gameRequestContent0) {
        GameRequestDialog.show(new FragmentWrapper(i0), gameRequestContent0);
    }

    private static void show(FragmentWrapper fragmentWrapper0, GameRequestContent gameRequestContent0) {
        new GameRequestDialog(fragmentWrapper0).show(gameRequestContent0);
    }
}

