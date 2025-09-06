package com.iloen.melon.net;

import Ge.s;
import S7.b;
import android.text.TextUtils;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventNotificationScheme;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.AppUtils;
import com.melon.net.res.common.ResponseBase;
import e1.u;
import ie.d;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.o;
import x1.a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001A\u0004\u0018\u00010\tH\u0016J\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u000EH\u0007J\b\u0010\u0011\u001A\u00020\u000EH\u0007J\b\u0010\u0012\u001A\u00020\u000EH\u0007J\u0012\u0010\u0013\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001A\u00020\u0016H\u0007R\u0014\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001A\u00020\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\u000E8WX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000F¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/net/HttpResponse;", "Ljava/io/Serializable;", "<init>", "()V", "notification", "Lcom/iloen/melon/net/HttpResponse$Notification;", "logging", "", "getResponse", "Lcom/melon/net/res/common/ResponseBase;", "menuId", "getMenuId", "()Ljava/lang/String;", "isSuccessful", "", "()Z", "handleNotification", "hasNotification", "hasNotificationButtons", "getNotificationButton", "Lcom/iloen/melon/net/HttpResponse$Notification$Buttons;", "position", "", "Companion", "Notification", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class HttpResponse implements Serializable {
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000F\u001A\u00020\u000E2\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000F\u0010\u0010J\u0019\u0010\u0011\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u0011\u0010\rJ9\u0010\u0018\u001A\u0004\u0018\u00010\u00132\u001E\u0010\u0015\u001A\u001A\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001`\u00142\u0006\u0010\u0017\u001A\u00020\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001C\u001A\u00020\u00042\b\u0010\u001B\u001A\u0004\u0018\u00010\u001AH\u0007¢\u0006\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0014\u0010!\u001A\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/iloen/melon/net/HttpResponse$Companion;", "", "<init>", "()V", "", "logging", "menuId", "replacePvLogReservedWords", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "hasNotification", "(Lcom/iloen/melon/net/HttpResponse;)Z", "Lie/H;", "handleRedirectScheme", "(Lcom/iloen/melon/net/HttpResponse;)V", "hasNotificationButtons", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/HttpResponse$Notification$Buttons;", "Lkotlin/collections/ArrayList;", "buttons", "", "position", "getNotificationButton", "(Ljava/util/ArrayList;I)Lcom/iloen/melon/net/HttpResponse$Notification$Buttons;", "Lcom/android/volley/VolleyError;", "error", "getErrorMessage", "(Lcom/android/volley/VolleyError;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "", "serialVersionUID", "J", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final String getErrorMessage(@Nullable VolleyError volleyError0) {
            if(volleyError0 == null) {
                return "unknown error";
            }
            String s = volleyError0.getMessage();
            if(s == null) {
                s = "";
            }
            if(!TextUtils.isEmpty(s)) {
                return s;
            }
            NetworkResponse networkResponse0 = volleyError0.networkResponse;
            if(networkResponse0 != null) {
                try {
                    String s1 = VolleyRequest.parseResponse(networkResponse0);
                    q.f(s1, "parseResponse(...)");
                    s = s1;
                    return TextUtils.isEmpty(s) ? "statusCode: " + volleyError0.networkResponse.statusCode : s;
                }
                catch(UnsupportedEncodingException unsupportedEncodingException0) {
                    unsupportedEncodingException0.printStackTrace();
                    return TextUtils.isEmpty(s) ? "statusCode: " + volleyError0.networkResponse.statusCode : s;
                }
            }
            return volleyError0.toString();
        }

        @d
        @Nullable
        public final Buttons getNotificationButton(@Nullable ArrayList arrayList0, int v) {
            if(arrayList0 != null && !arrayList0.isEmpty()) {
                try {
                    return (Buttons)arrayList0.get(v);
                }
                catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                    LogU.Companion.w("HttpResponse", "getNotificationButton() " + indexOutOfBoundsException0);
                    return null;
                }
            }
            LogU.Companion.w("HttpResponse", "getNotificationButton() invalid buttons");
            return null;
        }

        @d
        public final void handleRedirectScheme(@Nullable HttpResponse httpResponse0) {
            String s = null;
            if((httpResponse0 == null ? null : httpResponse0.notification) != null) {
                Notification httpResponse$Notification0 = httpResponse0.notification;
                if(httpResponse$Notification0 != null) {
                    s = httpResponse$Notification0.getRedirectScheme();
                }
                if(!TextUtils.isEmpty(s)) {
                    LogU.Companion.v("HttpResponse", "handleRedirectScheme() redirectScheme: " + s);
                    EventNotificationScheme eventNotificationScheme0 = new EventNotificationScheme();
                    eventNotificationScheme0.scheme = s;
                    EventBusHelper.post(eventNotificationScheme0);
                }
            }
        }

        @d
        public final boolean hasNotification(@Nullable HttpResponse httpResponse0) {
            return httpResponse0 != null && httpResponse0.notification != null;
        }

        @d
        public final boolean hasNotificationButtons(@Nullable HttpResponse httpResponse0) {
            if(httpResponse0 != null) {
                Notification httpResponse$Notification0 = httpResponse0.notification;
                if(httpResponse$Notification0 != null) {
                    return httpResponse$Notification0.buttons == null ? false : !httpResponse$Notification0.buttons.isEmpty();
                }
            }
            return false;
        }

        @NotNull
        public final String replacePvLogReservedWords(@NotNull String s, @Nullable String s1) {
            q.g(s, "logging");
            if(TextUtils.isEmpty(s)) {
                LogU.Companion.w("HttpResponse", "replacePvLogReservedWords() invalid logging");
                return "";
            }
            Pattern pattern0 = Pattern.compile("\\@CR1\\@");
            q.f(pattern0, "compile(...)");
            if(s1 == null) {
                s1 = "";
            }
            String s2 = pattern0.matcher(s).replaceFirst(s1);
            q.f(s2, "replaceFirst(...)");
            Pattern pattern1 = Pattern.compile("\\@CR2\\@");
            q.f(pattern1, "compile(...)");
            String s3 = u.v(((e0)o.a()).j());
            String s4 = pattern1.matcher(s2).replaceFirst(s3);
            q.f(s4, "replaceFirst(...)");
            Pattern pattern2 = Pattern.compile("\\@CR3\\@");
            q.f(pattern2, "compile(...)");
            MelonAppBase.Companion.getClass();
            String s5 = t.a().getMelonCpId();
            q.g(s5, "replacement");
            String s6 = pattern2.matcher(s4).replaceFirst(s5);
            q.f(s6, "replaceFirst(...)");
            Pattern pattern3 = Pattern.compile("\\@CR4\\@");
            q.f(pattern3, "compile(...)");
            String s7 = AppUtils.getVersionName(t.a().getContext());
            q.g(s7, "replacement");
            String s8 = pattern3.matcher(s6).replaceFirst(s7);
            q.f(s8, "replaceFirst(...)");
            Pattern pattern4 = Pattern.compile("\\@CR5\\@");
            q.f(pattern4, "compile(...)");
            String s9 = pattern4.matcher(s8).replaceFirst("");
            q.f(s9, "replaceFirst(...)");
            return s9;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001A\u00020\u0005H\u0016R\u0014\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R \u0010\b\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR*\u0010\r\u001A\u001A\u0012\u0006\u0012\u0004\u0018\u00010\u000F\u0018\u00010\u000Ej\f\u0012\u0006\u0012\u0004\u0018\u00010\u000F\u0018\u0001`\u00108\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/net/HttpResponse$Notification;", "Ljava/io/Serializable;", "<init>", "()V", "actionType", "", "message", "subMessage", "redirectScheme", "getRedirectScheme", "()Ljava/lang/String;", "setRedirectScheme", "(Ljava/lang/String;)V", "buttons", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/HttpResponse$Notification$Buttons;", "Lkotlin/collections/ArrayList;", "toString", "Companion", "Buttons", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Notification implements Serializable {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R \u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/net/HttpResponse$Notification$Buttons;", "Ljava/io/Serializable;", "<init>", "()V", "label", "", "buttonType", "getButtonType", "()Ljava/lang/String;", "setButtonType", "(Ljava/lang/String;)V", "linkUri", "Companion", "ButtonType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Buttons implements Serializable {
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/net/HttpResponse$Notification$Buttons$ButtonType;", "", "<init>", "()V", "DEFAULT", "", "LIST", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class ButtonType {
                public static final int $stable = 0;
                @NotNull
                public static final String DEFAULT = "BTN_0000";
                @NotNull
                public static final ButtonType INSTANCE = null;
                @NotNull
                public static final String LIST = "BTN_1000";

                static {
                    ButtonType.INSTANCE = new ButtonType();
                }
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/HttpResponse$Notification$Buttons$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.iloen.melon.net.HttpResponse.Notification.Buttons.Companion {
                private com.iloen.melon.net.HttpResponse.Notification.Buttons.Companion() {
                }

                public com.iloen.melon.net.HttpResponse.Notification.Buttons.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.iloen.melon.net.HttpResponse.Notification.Buttons.Companion Companion = null;
            @b("buttonType")
            @Nullable
            private String buttonType;
            @b("label")
            @Nullable
            public String label;
            @b("linkUri")
            @Nullable
            public String linkUri;
            private static final long serialVersionUID = 0x16543CF0774BEAF9L;

            static {
                Buttons.Companion = new com.iloen.melon.net.HttpResponse.Notification.Buttons.Companion(null);
                Buttons.$stable = 8;
            }

            @Nullable
            public final String getButtonType() {
                return this.buttonType;
            }

            public final void setButtonType(@Nullable String s) {
                this.buttonType = s;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/net/HttpResponse$Notification$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.net.HttpResponse.Notification.Companion {
            private com.iloen.melon.net.HttpResponse.Notification.Companion() {
            }

            public com.iloen.melon.net.HttpResponse.Notification.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.net.HttpResponse.Notification.Companion Companion = null;
        @b("actionType")
        @Nullable
        public String actionType;
        @b("buttons")
        @Nullable
        public ArrayList buttons;
        @b("message")
        @NotNull
        public String message;
        @b("redirectScheme")
        @Nullable
        private String redirectScheme;
        private static final long serialVersionUID = 0xAF8E8F47F9C5C277L;
        @b("subMessage")
        @NotNull
        public String subMessage;

        static {
            Notification.Companion = new com.iloen.melon.net.HttpResponse.Notification.Companion(null);
            Notification.$stable = 8;
        }

        public Notification() {
            this.message = "";
            this.subMessage = "";
        }

        @Nullable
        public final String getRedirectScheme() {
            return this.redirectScheme;
        }

        public final void setRedirectScheme(@Nullable String s) {
            this.redirectScheme = s;
        }

        @Override
        @NotNull
        public String toString() {
            String s = ToStringUtil.toStringFields(this);
            q.f(s, "toStringFields(...)");
            return s;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "HttpResponse";
    @b("logging")
    @NotNull
    public String logging;
    @b("notification")
    @Nullable
    public Notification notification;
    private static final long serialVersionUID = 0x36550C7483103A17L;

    static {
        HttpResponse.Companion = new Companion(null);
        HttpResponse.$stable = 8;
    }

    public HttpResponse() {
        this.logging = "";
    }

    @NotNull
    public static final String getErrorMessage(@Nullable VolleyError volleyError0) {
        return HttpResponse.Companion.getErrorMessage(volleyError0);
    }

    @NotNull
    public String getMenuId() {
        ResponseBase responseBase0 = this.getResponse();
        if(responseBase0 != null) {
            String s = responseBase0.menuId;
            LogU.Companion.v("HttpResponse", "getMenuId() " + s);
            return s == null ? "" : s;
        }
        return "";
    }

    @d
    @Nullable
    public static final Buttons getNotificationButton(@Nullable ArrayList arrayList0, int v) {
        return HttpResponse.Companion.getNotificationButton(arrayList0, v);
    }

    // 去混淆评级： 低(30)
    @d
    @Nullable
    public final Buttons getNotificationButton(int v) {
        return null;
    }

    @Nullable
    public ResponseBase getResponse() {
        try {
            Object object0 = null;
            Class class0 = this.getClass();
            for(Object object1: a.C(I.a.b(class0))) {
                if(q.b(((De.t)object1).getName(), "response")) {
                    object0 = object1;
                    break;
                }
            }
            if(((De.t)object0) != null) {
                Object object2 = ((s)((De.t)object0).getGetter()).call(new Object[]{this});
                return object2 instanceof ResponseBase ? ((ResponseBase)object2) : null;
            }
            return null;
        }
        catch(Exception exception0) {
        }
        LogU.Companion.w("HttpResponse", "getResponse() - " + exception0);
        return null;
    }

    @d
    public static final void handleRedirectScheme(@Nullable HttpResponse httpResponse0) {
        HttpResponse.Companion.handleRedirectScheme(httpResponse0);
    }

    @d
    public static final boolean hasNotification(@Nullable HttpResponse httpResponse0) {
        return HttpResponse.Companion.hasNotification(httpResponse0);
    }

    @d
    public final boolean hasNotification() [...] // 潜在的解密器

    @d
    public static final boolean hasNotificationButtons(@Nullable HttpResponse httpResponse0) {
        return HttpResponse.Companion.hasNotificationButtons(httpResponse0);
    }

    @d
    public final boolean hasNotificationButtons() {
        return HttpResponse.Companion.hasNotificationButtons(this);
    }

    @d
    public boolean isSuccessful() {
        return this.isSuccessful(true);
    }

    // 去混淆评级： 低(33)
    @d
    public final boolean isSuccessful(boolean z) {
        Class class0 = this.getClass();
        LogU.Companion.d("HttpResponse", "isSuccessful() handleNotification:" + z + (", " + class0));
        return true;
    }

    @NotNull
    public static final String replacePvLogReservedWords(@NotNull String s, @Nullable String s1) {
        return HttpResponse.Companion.replacePvLogReservedWords(s, s1);
    }
}

