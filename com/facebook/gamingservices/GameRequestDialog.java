package com.facebook.gamingservices;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.I;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Validate;
import com.facebook.share.internal.GameRequestValidation;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.GameRequestContent;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameRequestDialog extends FacebookDialogBase {
    class ChromeCustomTabHandler extends ModeHandler {
        private ChromeCustomTabHandler() {
        }

        public ChromeCustomTabHandler(com.facebook.gamingservices.GameRequestDialog.1 gameRequestDialog$10) {
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

    class FacebookAppHandler extends ModeHandler {
        private FacebookAppHandler() {
        }

        public FacebookAppHandler(com.facebook.gamingservices.GameRequestDialog.1 gameRequestDialog$10) {
        }

        public boolean canShow(GameRequestContent gameRequestContent0, boolean z) {
            PackageManager packageManager0 = GameRequestDialog.this.getActivityContext().getPackageManager();
            Intent intent0 = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent0.setType("text/plain");
            boolean z1 = intent0.resolveActivity(packageManager0) != null;
            AccessToken accessToken0 = AccessToken.getCurrentAccessToken();
            return z1 && (accessToken0 != null && accessToken0.getGraphDomain() != null && "gaming".equals(accessToken0.getGraphDomain()));
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((GameRequestContent)object0), z);
        }

        public AppCall createAppCall(GameRequestContent gameRequestContent0) {
            AppCall appCall0 = GameRequestDialog.this.createBaseAppCall();
            Intent intent0 = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent0.setType("text/plain");
            AccessToken accessToken0 = AccessToken.getCurrentAccessToken();
            Bundle bundle0 = Y.b("deeplink", "GAME_REQUESTS");
            if(accessToken0 == null) {
                bundle0.putString("app_id", FacebookSdk.getApplicationId());
            }
            else {
                bundle0.putString("app_id", accessToken0.getApplicationId());
            }
            bundle0.putString("actionType", (gameRequestContent0.getActionType() == null ? null : gameRequestContent0.getActionType().name()));
            bundle0.putString("message", gameRequestContent0.getMessage());
            bundle0.putString("title", gameRequestContent0.getTitle());
            bundle0.putString("data", gameRequestContent0.getData());
            bundle0.putString("cta", gameRequestContent0.getCta());
            JSONArray jSONArray0 = new JSONArray();
            if(gameRequestContent0.getRecipients() != null) {
                for(Object object0: gameRequestContent0.getRecipients()) {
                    jSONArray0.put(((String)object0));
                }
            }
            bundle0.putString("to", jSONArray0.toString());
            NativeProtocol.setupProtocolRequestIntent(intent0, appCall0.getCallId().toString(), "", NativeProtocol.getLatestKnownVersion(), bundle0);
            appCall0.setRequestIntent(intent0);
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

        public Result(Bundle bundle0, com.facebook.gamingservices.GameRequestDialog.1 gameRequestDialog$10) {
            this(bundle0);
        }

        private Result(GraphResponse graphResponse0) {
            try {
                JSONObject jSONObject0 = graphResponse0.getJSONObject();
                JSONObject jSONObject1 = jSONObject0.optJSONObject("data");
                if(jSONObject1 != null) {
                    jSONObject0 = jSONObject1;
                }
                this.requestId = jSONObject0.getString("request_id");
                this.to = new ArrayList();
                JSONArray jSONArray0 = jSONObject0.getJSONArray("to");
                for(int v = 0; v < jSONArray0.length(); ++v) {
                    this.to.add(jSONArray0.getString(v));
                }
            }
            catch(JSONException unused_ex) {
                this.requestId = null;
                this.to = new ArrayList();
            }
        }

        public Result(GraphResponse graphResponse0, com.facebook.gamingservices.GameRequestDialog.1 gameRequestDialog$10) {
            this(graphResponse0);
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

        public WebHandler(com.facebook.gamingservices.GameRequestDialog.1 gameRequestDialog$10) {
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
    private FacebookCallback mCallback;

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
        ((ArrayList)list0).add(new FacebookAppHandler(this, null));
        ((ArrayList)list0).add(new ChromeCustomTabHandler(this, null));
        ((ArrayList)list0).add(new WebHandler(this, null));
        return list0;
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl0, FacebookCallback facebookCallback0) {
        this.mCallback = facebookCallback0;
        callbackManagerImpl0.registerCallback(this.getRequestCode(), new Callback() {
            @Override  // com.facebook.internal.CallbackManagerImpl$Callback
            public boolean onActivityResult(int v, Intent intent0) {
                return ShareInternalUtility.handleActivityResult(GameRequestDialog.this.getRequestCode(), v, intent0, (facebookCallback0 == null ? null : new com.facebook.gamingservices.GameRequestDialog.1(this, facebookCallback0, facebookCallback0)));
            }
        });

        class com.facebook.gamingservices.GameRequestDialog.1 extends ResultProcessor {
            public com.facebook.gamingservices.GameRequestDialog.1(FacebookCallback facebookCallback0, FacebookCallback facebookCallback1) {
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

    private void showForCloud(GameRequestContent gameRequestContent0, Object object0) {
        Activity activity0 = this.getActivityContext();
        AccessToken accessToken0 = AccessToken.getCurrentAccessToken();
        if(accessToken0 == null || accessToken0.isExpired()) {
            throw new FacebookException("Attempted to open GameRequestDialog with an invalid access token");
        }
        com.facebook.gamingservices.GameRequestDialog.3 gameRequestDialog$30 = new com.facebook.gamingservices.cloudgaming.DaemonRequest.Callback() {
            @Override  // com.facebook.gamingservices.cloudgaming.DaemonRequest$Callback
            public void onCompleted(GraphResponse graphResponse0) {
                if(GameRequestDialog.this.mCallback != null) {
                    if(graphResponse0.getError() != null) {
                        FacebookException facebookException0 = new FacebookException(graphResponse0.getError().getErrorMessage());
                        GameRequestDialog.this.mCallback.onError(facebookException0);
                        return;
                    }
                    Result gameRequestDialog$Result0 = new Result(graphResponse0, null);
                    GameRequestDialog.this.mCallback.onSuccess(gameRequestDialog$Result0);
                }
            }
        };
        String s = gameRequestContent0.getActionType() == null ? null : gameRequestContent0.getActionType().name();
        JSONObject jSONObject0 = new JSONObject();
        JSONArray jSONArray0 = new JSONArray();
        try {
            jSONObject0.put("appID", accessToken0.getApplicationId());
            jSONObject0.put("actionType", s);
            jSONObject0.put("message", gameRequestContent0.getMessage());
            jSONObject0.put("cta", gameRequestContent0.getCta());
            jSONObject0.put("title", gameRequestContent0.getTitle());
            jSONObject0.put("data", gameRequestContent0.getData());
            jSONObject0.put("options", gameRequestContent0.getFilters());
            if(gameRequestContent0.getRecipients() != null) {
                for(Object object1: gameRequestContent0.getRecipients()) {
                    jSONArray0.put(((String)object1));
                }
            }
            jSONObject0.put("to", jSONArray0);
            DaemonRequest.executeAsync(activity0, jSONObject0, gameRequestDialog$30, SDKMessageEnum.OPEN_GAME_REQUESTS_DIALOG);
        }
        catch(JSONException unused_ex) {
            FacebookCallback facebookCallback0 = this.mCallback;
            if(facebookCallback0 != null) {
                facebookCallback0.onError(new FacebookException("Couldn\'t prepare Game Request Dialog"));
            }
        }
    }

    public void showImpl(GameRequestContent gameRequestContent0, Object object0) {
        super.showImpl(gameRequestContent0, object0);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public void showImpl(Object object0, Object object1) {
        this.showImpl(((GameRequestContent)object0), object1);
    }
}

