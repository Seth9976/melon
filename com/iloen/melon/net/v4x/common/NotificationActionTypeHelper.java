package com.iloen.melon.net.v4x.common;

import android.text.TextUtils;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventNotificationDialog;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;

public class NotificationActionTypeHelper {
    private static final String TAG = "NotificationActionTypeHelper";

    public static boolean hasInteractionNotification(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.hasInteractionNotification(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    // 去混淆评级： 低(30)
    public static boolean hasInteractionNotification(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : NotificationActionTypeHelper.isViewTypePopup(notificationActionType0) || NotificationActionTypeHelper.isViewTypeToast(notificationActionType0);
    }

    // 去混淆评级： 低(20)
    public static boolean hasInteractionNotification(String s) {
        return TextUtils.isEmpty(s) ? false : NotificationActionTypeHelper.hasInteractionNotification(NotificationActionType.valueOf(s));
    }

    public static boolean isExtraValue1Default(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isExtraValue1Default(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isExtraValue1Default(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ExtraValue1.Default.equals(notificationActionType0.extraValue1);
    }

    public static boolean isExtraValue1Player(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isExtraValue1Player(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isExtraValue1Player(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ExtraValue1.Player.equals(notificationActionType0.extraValue1);
    }

    public static boolean isExtraValue2BGStreaming(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isExtraValue2BGStreaming(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isExtraValue2BGStreaming(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ExtraValue2.BGStreaming.equals(notificationActionType0.extraValue2);
    }

    public static boolean isExtraValue2Buy(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isExtraValue2Buy(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isExtraValue2Buy(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ExtraValue2.Buy.equals(notificationActionType0.extraValue2);
    }

    public static boolean isExtraValue2Login(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isExtraValue2Login(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isExtraValue2Login(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ExtraValue2.Login.equals(notificationActionType0.extraValue2);
    }

    public static boolean isExtraValue2MultiStreaming(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isExtraValue2MultiStreaming(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isExtraValue2MultiStreaming(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ExtraValue2.MultiStreaming.equals(notificationActionType0.extraValue2);
    }

    public static boolean isExtraValue2NoLoginAdult(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isExtraValue2NoLoginAdult(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isExtraValue2NoLoginAdult(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ExtraValue2.NoLoginAdult.equals(notificationActionType0.extraValue2);
    }

    public static boolean isExtraValue2TrackZeroDeleted(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isExtraValue2TrackZeroDeleted(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isExtraValue2TrackZeroDeleted(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ExtraValue2.TrackZeroDeleted.equals(notificationActionType0.extraValue2);
    }

    public static boolean isStatusError(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isStatusError(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isStatusError(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : Status.Error.equals(notificationActionType0.status);
    }

    public static boolean isStatusNormal(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isStatusNormal(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isStatusNormal(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : Status.Normal.equals(notificationActionType0.status);
    }

    public static boolean isStatusNull(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isStatusNull(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isStatusNull(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : Status.Null.equals(notificationActionType0.status);
    }

    public static boolean isViewAreaApp(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isViewAreaApp(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isViewAreaApp(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ViewArea.App.equals(notificationActionType0.viewArea);
    }

    public static boolean isViewAreaNull(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isViewAreaNull(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isViewAreaNull(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ViewArea.Null.equals(notificationActionType0.viewArea);
    }

    public static boolean isViewAreaWebView(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isViewAreaWebView(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isViewAreaWebView(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ViewArea.WebView.equals(notificationActionType0.viewArea);
    }

    public static boolean isViewTypeLog(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isViewTypeLog(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isViewTypeLog(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ViewType.Log.equals(notificationActionType0.viewType);
    }

    public static boolean isViewTypeNotifyScreen(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isViewTypeNotifyScreen(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isViewTypeNotifyScreen(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ViewType.NotifyScreen.equals(notificationActionType0.viewType);
    }

    public static boolean isViewTypeNull(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isViewTypeNull(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isViewTypeNull(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ViewType.Null.equals(notificationActionType0.viewType);
    }

    public static boolean isViewTypePopup(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isViewTypePopup(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isViewTypePopup(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ViewType.Popup.equals(notificationActionType0.viewType);
    }

    public static boolean isViewTypeSubBlock(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isViewTypeSubBlock(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isViewTypeSubBlock(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ViewTypeSub.Block.equals(notificationActionType0.viewTypeSub);
    }

    public static boolean isViewTypeSubNonBlock(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isViewTypeSubNonBlock(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isViewTypeSubNonBlock(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ViewTypeSub.NonBlock.equals(notificationActionType0.viewTypeSub);
    }

    public static boolean isViewTypeSubNull(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isViewTypeSubNull(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isViewTypeSubNull(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ViewTypeSub.Null.equals(notificationActionType0.viewTypeSub);
    }

    public static boolean isViewTypeToast(Notification httpResponse$Notification0) {
        return httpResponse$Notification0 == null ? false : NotificationActionTypeHelper.isViewTypeToast(NotificationActionType.valueOf(httpResponse$Notification0.actionType));
    }

    public static boolean isViewTypeToast(NotificationActionType notificationActionType0) {
        return notificationActionType0 == null ? false : ViewType.Toast.equals(notificationActionType0.viewType);
    }

    public static void performActionType(Notification httpResponse$Notification0) {
        if(httpResponse$Notification0 == null) {
            LogU.w("NotificationActionTypeHelper", "performActionType() invalid notification");
            return;
        }
        NotificationActionType notificationActionType0 = NotificationActionType.valueOf(httpResponse$Notification0.actionType);
        if(NotificationActionTypeHelper.isViewTypePopup(notificationActionType0)) {
            EventNotificationDialog eventNotificationDialog0 = new EventNotificationDialog();
            eventNotificationDialog0.message = httpResponse$Notification0.message;
            eventNotificationDialog0.isCancelable = false;
            eventNotificationDialog0.buttons = httpResponse$Notification0.buttons;
            EventBusHelper.post(eventNotificationDialog0);
            return;
        }
        if(NotificationActionTypeHelper.isViewTypeToast(notificationActionType0)) {
            ToastManager.show(httpResponse$Notification0.message);
            return;
        }
        LogU.w("NotificationActionTypeHelper", "performActionType() actionType ignored - " + notificationActionType0);
    }
}

