package com.iloen.melon.net.v4x.common;

import android.text.TextUtils;
import com.iloen.melon.utils.log.LogU;

public class NotificationActionType {
    public static class ExtraValue1 extends NotificationActionTypeValue {
        public static final ExtraValue1 Default;
        public static final ExtraValue1 Null;
        public static final ExtraValue1 Player;

        static {
            ExtraValue1.Null = new ExtraValue1("", "");
            ExtraValue1.Default = new ExtraValue1("Default", "0");
            ExtraValue1.Player = new ExtraValue1("Player", "1");
        }

        private ExtraValue1(String s, String s1) {
            super(s, s1);
        }

        public static ExtraValue1 valueOf(char c) {
            ExtraValue1 notificationActionType$ExtraValue10 = ExtraValue1.Default;
            if(notificationActionType$ExtraValue10.isCodeEquals(c)) {
                return notificationActionType$ExtraValue10;
            }
            return ExtraValue1.Player.isCodeEquals(c) ? ExtraValue1.Player : ExtraValue1.Null;
        }
    }

    public static class ExtraValue2 extends NotificationActionTypeValue {
        public static final ExtraValue2 BGStreaming;
        public static final ExtraValue2 Buy;
        public static final ExtraValue2 Login;
        public static final ExtraValue2 MultiStreaming;
        public static final ExtraValue2 NoLoginAdult;
        public static final ExtraValue2 Null;
        public static final ExtraValue2 TrackZeroDeleted;

        static {
            ExtraValue2.Null = new ExtraValue2("", "");
            ExtraValue2.MultiStreaming = new ExtraValue2("MultiStreaming", "0");
            ExtraValue2.Login = new ExtraValue2("Login", "1");
            ExtraValue2.Buy = new ExtraValue2("Buy", "2");
            ExtraValue2.NoLoginAdult = new ExtraValue2("NoLoginAdult", "3");
            ExtraValue2.BGStreaming = new ExtraValue2("BGStreaming", "4");
            ExtraValue2.TrackZeroDeleted = new ExtraValue2("TrackZeroDeleted", "5");
        }

        private ExtraValue2(String s, String s1) {
            super(s, s1);
        }

        public static ExtraValue2 valueOf(char c) {
            ExtraValue2 notificationActionType$ExtraValue20 = ExtraValue2.MultiStreaming;
            if(notificationActionType$ExtraValue20.isCodeEquals(c)) {
                return notificationActionType$ExtraValue20;
            }
            ExtraValue2 notificationActionType$ExtraValue21 = ExtraValue2.Login;
            if(notificationActionType$ExtraValue21.isCodeEquals(c)) {
                return notificationActionType$ExtraValue21;
            }
            ExtraValue2 notificationActionType$ExtraValue22 = ExtraValue2.Buy;
            if(notificationActionType$ExtraValue22.isCodeEquals(c)) {
                return notificationActionType$ExtraValue22;
            }
            ExtraValue2 notificationActionType$ExtraValue23 = ExtraValue2.NoLoginAdult;
            if(notificationActionType$ExtraValue23.isCodeEquals(c)) {
                return notificationActionType$ExtraValue23;
            }
            ExtraValue2 notificationActionType$ExtraValue24 = ExtraValue2.BGStreaming;
            if(notificationActionType$ExtraValue24.isCodeEquals(c)) {
                return notificationActionType$ExtraValue24;
            }
            return ExtraValue2.TrackZeroDeleted.isCodeEquals(c) ? ExtraValue2.TrackZeroDeleted : ExtraValue2.Null;
        }
    }

    public static class NullNotificationActionType extends NotificationActionType {
        public NullNotificationActionType() {
            this.status = Status.Null;
            this.viewArea = ViewArea.Null;
            this.viewType = ViewType.Null;
            this.viewTypeSub = ViewTypeSub.Null;
            this.extraValue1 = ExtraValue1.Null;
            this.extraValue2 = ExtraValue2.Null;
        }
    }

    public static class Status extends NotificationActionTypeValue {
        public static final Status Error;
        public static final Status Normal;
        public static final Status Null;

        static {
            Status.Null = new Status("", "");
            Status.Normal = new Status("Normal", "N");
            Status.Error = new Status("Error", "E");
        }

        private Status(String s, String s1) {
            super(s, s1);
        }

        public static Status valueOf(char c) {
            Status notificationActionType$Status0 = Status.Normal;
            if(notificationActionType$Status0.isCodeEquals(c)) {
                return notificationActionType$Status0;
            }
            return Status.Error.isCodeEquals(c) ? Status.Error : Status.Null;
        }
    }

    public static class ViewArea extends NotificationActionTypeValue {
        public static final ViewArea App;
        public static final ViewArea Null;
        public static final ViewArea WebView;

        static {
            ViewArea.Null = new ViewArea("", "");
            ViewArea.App = new ViewArea("App", "A");
            ViewArea.WebView = new ViewArea("WebView", "W");
        }

        private ViewArea(String s, String s1) {
            super(s, s1);
        }

        public static ViewArea valueOf(char c) {
            ViewArea notificationActionType$ViewArea0 = ViewArea.App;
            if(notificationActionType$ViewArea0.isCodeEquals(c)) {
                return notificationActionType$ViewArea0;
            }
            return ViewArea.WebView.isCodeEquals(c) ? ViewArea.WebView : ViewArea.Null;
        }
    }

    public static class ViewType extends NotificationActionTypeValue {
        public static final ViewType Log;
        public static final ViewType NotifyScreen;
        public static final ViewType Null;
        public static final ViewType Popup;
        public static final ViewType Toast;

        static {
            ViewType.Null = new ViewType("", "");
            ViewType.Log = new ViewType("Log", "1");
            ViewType.Popup = new ViewType("Popup", "2");
            ViewType.Toast = new ViewType("Toast", "3");
            ViewType.NotifyScreen = new ViewType("NotifyScreen", "4");
        }

        private ViewType(String s, String s1) {
            super(s, s1);
        }

        public static ViewType valueOf(char c) {
            ViewType notificationActionType$ViewType0 = ViewType.Log;
            if(notificationActionType$ViewType0.isCodeEquals(c)) {
                return notificationActionType$ViewType0;
            }
            ViewType notificationActionType$ViewType1 = ViewType.Popup;
            if(notificationActionType$ViewType1.isCodeEquals(c)) {
                return notificationActionType$ViewType1;
            }
            ViewType notificationActionType$ViewType2 = ViewType.Toast;
            if(notificationActionType$ViewType2.isCodeEquals(c)) {
                return notificationActionType$ViewType2;
            }
            return ViewType.NotifyScreen.isCodeEquals(c) ? ViewType.NotifyScreen : ViewType.Null;
        }
    }

    public static class ViewTypeSub extends NotificationActionTypeValue {
        public static final ViewTypeSub Block;
        public static final ViewTypeSub NonBlock;
        public static final ViewTypeSub Null;

        static {
            ViewTypeSub.Null = new ViewTypeSub("", "");
            ViewTypeSub.NonBlock = new ViewTypeSub("NonBlock", "0");
            ViewTypeSub.Block = new ViewTypeSub("Block", "1");
        }

        private ViewTypeSub(String s, String s1) {
            super(s, s1);
        }

        public static ViewTypeSub valueOf(char c) {
            ViewTypeSub notificationActionType$ViewTypeSub0 = ViewTypeSub.NonBlock;
            if(notificationActionType$ViewTypeSub0.isCodeEquals(c)) {
                return notificationActionType$ViewTypeSub0;
            }
            return ViewTypeSub.Block.isCodeEquals(c) ? ViewTypeSub.Block : ViewTypeSub.Null;
        }
    }

    private static final NotificationActionType NULL_TYPE = null;
    private static final String TAG = "NotificationActionType";
    private static final int TYPE_EXTRA_VALUE1 = 4;
    private static final int TYPE_EXTRA_VALUE2 = 5;
    private static final int TYPE_MAX_LENGTH = 6;
    private static final int TYPE_STATUS = 0;
    private static final int TYPE_VIEW_AREA = 1;
    private static final int TYPE_VIEW_TYPE = 2;
    private static final int TYPE_VIEW_TYPE_SUB = 3;
    public ExtraValue1 extraValue1;
    public ExtraValue2 extraValue2;
    public Status status;
    public ViewArea viewArea;
    public ViewType viewType;
    public ViewTypeSub viewTypeSub;

    static {
        NotificationActionType.NULL_TYPE = new NullNotificationActionType();
    }

    @Override
    public String toString() {
        return "NotificationActionType <Status" + this.status + ", ViewArea" + this.viewArea + ", ViewType" + this.viewType + ", ViewTypeSub" + this.viewTypeSub + ">";
    }

    public static NotificationActionType valueOf(String s) {
        if(TextUtils.isEmpty(s)) {
            return NotificationActionType.NULL_TYPE;
        }
        if(s.length() != 6) {
            LogU.w("NotificationActionType", "valueOf() invalid length");
            return NotificationActionType.NULL_TYPE;
        }
        NotificationActionType notificationActionType0 = new NotificationActionType();
        for(int v = 0; v < 6; ++v) {
            int v1 = s.charAt(v);
            if(v == 0) {
                notificationActionType0.status = Status.valueOf(((char)v1));
            }
            else if(1 == v) {
                notificationActionType0.viewArea = ViewArea.valueOf(((char)v1));
            }
            else if(2 == v) {
                notificationActionType0.viewType = ViewType.valueOf(((char)v1));
            }
            else if(3 == v) {
                notificationActionType0.viewTypeSub = ViewTypeSub.valueOf(((char)v1));
            }
            else if(4 == v) {
                notificationActionType0.extraValue1 = ExtraValue1.valueOf(((char)v1));
            }
            else if(5 == v) {
                notificationActionType0.extraValue2 = ExtraValue2.valueOf(((char)v1));
            }
        }
        LogU.v("NotificationActionType", "valueOf() " + notificationActionType0);
        return notificationActionType0;
    }
}

