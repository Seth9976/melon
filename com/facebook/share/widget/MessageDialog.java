package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.I;
import com.facebook.FacebookCallback;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.Sharer;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.MessageDialogFeature;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import java.util.ArrayList;
import java.util.List;
import k8.Y;

public final class MessageDialog extends ShareDialog implements Sharer {
    class NativeHandler extends ModeHandler {
        private NativeHandler() {
        }

        public NativeHandler(com.facebook.share.widget.MessageDialog.1 messageDialog$10) {
        }

        public boolean canShow(ShareContent shareContent0, boolean z) {
            return shareContent0 != null && MessageDialog.canShow(shareContent0.getClass());
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((ShareContent)object0), z);
        }

        public AppCall createAppCall(ShareContent shareContent0) {
            ShareContentValidation.validateForMessage(shareContent0);
            AppCall appCall0 = MessageDialog.this.createBaseAppCall();
            MessageDialog.logDialogShare(MessageDialog.this.getActivityContext(), shareContent0, appCall0);
            DialogPresenter.setupAppCallForNativeDialog(appCall0, new ParameterProvider() {
                @Override  // com.facebook.internal.DialogPresenter$ParameterProvider
                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(appCall0.getCallId(), shareContent0, MessageDialog.this.getShouldFailOnDataError());
                }

                @Override  // com.facebook.internal.DialogPresenter$ParameterProvider
                public Bundle getParameters() {
                    return NativeDialogParameters.create(appCall0.getCallId(), shareContent0, MessageDialog.this.getShouldFailOnDataError());
                }
            }, MessageDialog.getFeature(shareContent0.getClass()));
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((ShareContent)object0));
        }
    }

    private static final int DEFAULT_REQUEST_CODE;
    private boolean shouldFailOnDataError;

    static {
        MessageDialog.DEFAULT_REQUEST_CODE = RequestCodeOffset.Message.toRequestCode();
    }

    public MessageDialog(Activity activity0) {
        super(activity0, MessageDialog.DEFAULT_REQUEST_CODE);
        this.shouldFailOnDataError = false;
        ShareInternalUtility.registerStaticShareCallback(MessageDialog.DEFAULT_REQUEST_CODE);
    }

    public MessageDialog(Activity activity0, int v) {
        super(activity0, v);
        this.shouldFailOnDataError = false;
        ShareInternalUtility.registerStaticShareCallback(v);
    }

    public MessageDialog(Fragment fragment0) {
        this(new FragmentWrapper(fragment0));
    }

    public MessageDialog(Fragment fragment0, int v) {
        this(new FragmentWrapper(fragment0), v);
    }

    public MessageDialog(I i0) {
        this(new FragmentWrapper(i0));
    }

    public MessageDialog(I i0, int v) {
        this(new FragmentWrapper(i0), v);
    }

    private MessageDialog(FragmentWrapper fragmentWrapper0) {
        super(fragmentWrapper0, MessageDialog.DEFAULT_REQUEST_CODE);
        this.shouldFailOnDataError = false;
        ShareInternalUtility.registerStaticShareCallback(MessageDialog.DEFAULT_REQUEST_CODE);
    }

    private MessageDialog(FragmentWrapper fragmentWrapper0, int v) {
        super(fragmentWrapper0, v);
        this.shouldFailOnDataError = false;
        ShareInternalUtility.registerStaticShareCallback(v);
    }

    @Override  // com.facebook.share.widget.ShareDialog
    public static boolean canShow(Class class0) {
        DialogFeature dialogFeature0 = MessageDialog.getFeature(class0);
        return dialogFeature0 != null && DialogPresenter.canPresentNativeDialogWithFeature(dialogFeature0);
    }

    @Override  // com.facebook.share.widget.ShareDialog
    public AppCall createBaseAppCall() {
        return new AppCall(this.getRequestCode());
    }

    private static DialogFeature getFeature(Class class0) {
        return ShareLinkContent.class.isAssignableFrom(class0) ? MessageDialogFeature.MESSAGE_DIALOG : null;
    }

    @Override  // com.facebook.share.widget.ShareDialog
    public List getOrderedModeHandlers() {
        List list0 = new ArrayList();
        ((ArrayList)list0).add(new NativeHandler(this, null));
        return list0;
    }

    @Override  // com.facebook.share.widget.ShareDialog, com.facebook.share.Sharer
    public boolean getShouldFailOnDataError() {
        return this.shouldFailOnDataError;
    }

    private static void logDialogShare(Context context0, ShareContent shareContent0, AppCall appCall0) {
        String s;
        DialogFeature dialogFeature0 = MessageDialog.getFeature(shareContent0.getClass());
        if(dialogFeature0 == MessageDialogFeature.MESSAGE_DIALOG) {
            s = "status";
        }
        else if(dialogFeature0 == MessageDialogFeature.MESSENGER_GENERIC_TEMPLATE) {
            s = "GenericTemplate";
        }
        else {
            s = dialogFeature0 == MessageDialogFeature.MESSENGER_MEDIA_TEMPLATE ? "MediaTemplate" : "unknown";
        }
        InternalAppEventsLogger internalAppEventsLogger0 = new InternalAppEventsLogger(context0);
        Bundle bundle0 = Y.b("fb_share_dialog_content_type", s);
        bundle0.putString("fb_share_dialog_content_uuid", appCall0.getCallId().toString());
        bundle0.putString("fb_share_dialog_content_page_id", shareContent0.getPageId());
        internalAppEventsLogger0.logEventImplicitly("fb_messenger_share_dialog_show", bundle0);
    }

    @Override  // com.facebook.share.widget.ShareDialog
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl0, FacebookCallback facebookCallback0) {
        ShareInternalUtility.registerSharerCallback(this.getRequestCode(), callbackManagerImpl0, facebookCallback0);
    }

    @Override  // com.facebook.share.widget.ShareDialog, com.facebook.share.Sharer
    public void setShouldFailOnDataError(boolean z) {
        this.shouldFailOnDataError = z;
    }

    @Override  // com.facebook.share.widget.ShareDialog
    public static void show(Activity activity0, ShareContent shareContent0) {
        new MessageDialog(activity0).show(shareContent0);
    }

    @Override  // com.facebook.share.widget.ShareDialog
    public static void show(Fragment fragment0, ShareContent shareContent0) {
        MessageDialog.show(new FragmentWrapper(fragment0), shareContent0);
    }

    @Override  // com.facebook.share.widget.ShareDialog
    public static void show(I i0, ShareContent shareContent0) {
        MessageDialog.show(new FragmentWrapper(i0), shareContent0);
    }

    private static void show(FragmentWrapper fragmentWrapper0, ShareContent shareContent0) {
        new MessageDialog(fragmentWrapper0).show(shareContent0);
    }

    class com.facebook.share.widget.MessageDialog.1 {
    }

}

