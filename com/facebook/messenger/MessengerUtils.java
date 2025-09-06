package com.facebook.messenger;

import Tf.o;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.bolts.AppLinks;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import d8.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0014\b\u00C6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\u001D\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00060\u000F2\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0014\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00120\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u0012H\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019J\'\u0010\u001A\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\u001A\u0010\fJ\u0019\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\u0006\u0010\u001C\u001A\u00020\u001BH\u0007\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u001D\u0010 \u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b \u0010!J\u0015\u0010#\u001A\u00020\"2\u0006\u0010\u000E\u001A\u00020\r\u00A2\u0006\u0004\b#\u0010$J\u0017\u0010%\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\rH\u0007\u00A2\u0006\u0004\b%\u0010&R\u0014\u0010\'\u001A\u00020\u00128\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\'\u0010(R\u0014\u0010)\u001A\u00020\u00128\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001A\u00020\u00128\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001A\u00020\u00128\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010,\u001A\u00020\u00128\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010-\u001A\u00020\u00128\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b-\u0010(R\u0014\u0010.\u001A\u00020\u00128\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b.\u0010(R\u0014\u0010/\u001A\u00020\u00128\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b/\u0010(R\u0014\u00100\u001A\u00020\u00128\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b0\u0010(R\u0014\u00101\u001A\u00020\u00128\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b1\u0010(R\u0014\u00102\u001A\u00020\u00128\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b2\u0010(R\u0014\u00103\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001A\u00020\u00128\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b5\u0010(\u00A8\u00066"}, d2 = {"Lcom/facebook/messenger/MessengerUtils;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "", "requestCode", "Lcom/facebook/messenger/ShareToMessengerParams;", "shareToMessengerParams", "Lie/H;", "shareToMessenger20150314", "(Landroid/app/Activity;ILcom/facebook/messenger/ShareToMessengerParams;)V", "Landroid/content/Context;", "context", "", "getAllAvailableProtocolVersions", "(Landroid/content/Context;)Ljava/util/Set;", "", "uri", "startViewUri", "(Landroid/content/Context;Ljava/lang/String;)V", "s", "", "parseParticipants", "(Ljava/lang/String;)Ljava/util/List;", "shareToMessenger", "Landroid/content/Intent;", "intent", "Lcom/facebook/messenger/MessengerThreadParams;", "getMessengerThreadParamsForIntent", "(Landroid/content/Intent;)Lcom/facebook/messenger/MessengerThreadParams;", "finishShareToMessenger", "(Landroid/app/Activity;Lcom/facebook/messenger/ShareToMessengerParams;)V", "", "hasMessengerInstalled", "(Landroid/content/Context;)Z", "openMessengerInPlayStore", "(Landroid/content/Context;)V", "TAG", "Ljava/lang/String;", "PACKAGE_NAME", "EXTRA_PROTOCOL_VERSION", "EXTRA_APP_ID", "EXTRA_REPLY_TOKEN_KEY", "EXTRA_THREAD_TOKEN_KEY", "EXTRA_METADATA", "EXTRA_EXTERNAL_URI", "EXTRA_PARTICIPANTS", "EXTRA_IS_REPLY", "EXTRA_IS_COMPOSE", "PROTOCOL_VERSION_20150314", "I", "ORCA_THREAD_CATEGORY_20150314", "facebook-messenger_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MessengerUtils {
    @NotNull
    public static final String EXTRA_APP_ID = "com.facebook.orca.extra.APPLICATION_ID";
    @NotNull
    public static final String EXTRA_EXTERNAL_URI = "com.facebook.orca.extra.EXTERNAL_URI";
    @NotNull
    public static final String EXTRA_IS_COMPOSE = "com.facebook.orca.extra.IS_COMPOSE";
    @NotNull
    public static final String EXTRA_IS_REPLY = "com.facebook.orca.extra.IS_REPLY";
    @NotNull
    public static final String EXTRA_METADATA = "com.facebook.orca.extra.METADATA";
    @NotNull
    public static final String EXTRA_PARTICIPANTS = "com.facebook.orca.extra.PARTICIPANTS";
    @NotNull
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.orca.extra.PROTOCOL_VERSION";
    @NotNull
    public static final String EXTRA_REPLY_TOKEN_KEY = "com.facebook.orca.extra.REPLY_TOKEN";
    @NotNull
    public static final String EXTRA_THREAD_TOKEN_KEY = "com.facebook.orca.extra.THREAD_TOKEN";
    @NotNull
    public static final MessengerUtils INSTANCE = null;
    @NotNull
    public static final String ORCA_THREAD_CATEGORY_20150314 = "com.facebook.orca.category.PLATFORM_THREAD_20150314";
    @NotNull
    public static final String PACKAGE_NAME = "com.facebook.orca";
    public static final int PROTOCOL_VERSION_20150314 = 20150314;
    @NotNull
    private static final String TAG = "MessengerUtils";

    static {
        MessengerUtils.INSTANCE = new MessengerUtils();
    }

    public final void finishShareToMessenger(@NotNull Activity activity0, @NotNull ShareToMessengerParams shareToMessengerParams0) {
        q.g(activity0, "activity");
        q.g(shareToMessengerParams0, "shareToMessengerParams");
        Intent intent0 = activity0.getIntent();
        Set set0 = intent0.getCategories();
        if(set0 == null) {
            activity0.setResult(0, null);
            activity0.finish();
            return;
        }
        if(set0.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314")) {
            Bundle bundle0 = AppLinks.getAppLinkExtras(intent0);
            Intent intent1 = new Intent();
            if(bundle0 == null || !set0.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314")) {
                throw new RuntimeException();
            }
            intent1.putExtra("com.facebook.orca.extra.PROTOCOL_VERSION", 20150314);
            intent1.putExtra("com.facebook.orca.extra.THREAD_TOKEN", bundle0.getString("com.facebook.orca.extra.THREAD_TOKEN"));
            intent1.setDataAndType(shareToMessengerParams0.getUri(), shareToMessengerParams0.getMimeType());
            intent1.setFlags(1);
            intent1.putExtra("com.facebook.orca.extra.APPLICATION_ID", FacebookSdk.getApplicationId());
            intent1.putExtra("com.facebook.orca.extra.METADATA", shareToMessengerParams0.getMetaData());
            intent1.putExtra("com.facebook.orca.extra.EXTERNAL_URI", shareToMessengerParams0.getExternalUri());
            activity0.setResult(-1, intent1);
            activity0.finish();
            return;
        }
        activity0.setResult(0, null);
        activity0.finish();
    }

    private final Set getAllAvailableProtocolVersions(Context context0) {
        ContentResolver contentResolver0 = context0.getContentResolver();
        Set set0 = new HashSet();
        Cursor cursor0 = contentResolver0.query(Uri.parse("content://com.facebook.orca.provider.MessengerPlatformProvider/versions"), new String[]{"version"}, null, null, null);
        if(cursor0 != null) {
            try {
                int v = cursor0.getColumnIndex("version");
                while(cursor0.moveToNext()) {
                    set0.add(cursor0.getInt(v));
                }
            }
            catch(Throwable throwable0) {
                d.l(cursor0, throwable0);
                throw throwable0;
            }
            cursor0.close();
            return set0;
        }
        return set0;
    }

    @Nullable
    public final MessengerThreadParams getMessengerThreadParamsForIntent(@NotNull Intent intent0) {
        Origin messengerThreadParams$Origin0;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            q.g(intent0, "intent");
            Set set0 = intent0.getCategories();
            if(set0 == null) {
                return null;
            }
            if(set0.contains("com.facebook.orca.category.PLATFORM_THREAD_20150314")) {
                Bundle bundle0 = AppLinks.getAppLinkExtras(intent0);
                String s = bundle0 == null ? null : bundle0.getString("com.facebook.orca.extra.THREAD_TOKEN");
                String s1 = bundle0 == null ? null : bundle0.getString("com.facebook.orca.extra.METADATA");
                String s2 = bundle0 == null ? null : bundle0.getString("com.facebook.orca.extra.PARTICIPANTS");
                Boolean boolean0 = bundle0 == null ? null : Boolean.valueOf(bundle0.getBoolean("com.facebook.orca.extra.IS_REPLY"));
                Boolean boolean1 = bundle0 == null ? null : Boolean.valueOf(bundle0.getBoolean("com.facebook.orca.extra.IS_COMPOSE"));
                if(q.b(boolean0, Boolean.TRUE)) {
                    messengerThreadParams$Origin0 = Origin.REPLY_FLOW;
                }
                else {
                    messengerThreadParams$Origin0 = q.b(boolean1, Boolean.TRUE) ? Origin.COMPOSE_FLOW : Origin.UNKNOWN;
                }
                return s == null || s1 == null ? null : new MessengerThreadParams(messengerThreadParams$Origin0, s, s1, this.parseParticipants(s2));
            }
            return null;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    public final boolean hasMessengerInstalled(@NotNull Context context0) {
        q.g(context0, "context");
        return FacebookSignatureValidator.validateSignature(context0, "com.facebook.orca");
    }

    public final void openMessengerInPlayStore(@NotNull Context context0) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                q.g(context0, "context");
                try {
                    this.startViewUri(context0, "market://details?id=com.facebook.orca");
                }
                catch(ActivityNotFoundException unused_ex) {
                    this.startViewUri(context0, "http://play.google.com/store/apps/details?id=com.facebook.orca");
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    private final List parseParticipants(String s) {
        if(s != null && s.length() != 0) {
            String[] arr_s = (String[])o.R0(s, new String[]{","}, 0, 6).toArray(new String[0]);
            List list0 = new ArrayList(arr_s.length);
            for(int v = 0; v < arr_s.length; ++v) {
                String s1 = arr_s[v];
                int v1 = s1.length() - 1;
                int v2 = 0;
                boolean z = false;
                while(v2 <= v1) {
                    boolean z1 = q.h(s1.charAt((z ? v1 : v2)), 0x20) <= 0;
                    if(z) {
                        if(!z1) {
                            break;
                        }
                        --v1;
                    }
                    else if(z1) {
                        ++v2;
                    }
                    else {
                        z = true;
                    }
                }
                ((ArrayList)list0).add(s1.subSequence(v2, v1 + 1).toString());
            }
            return list0;
        }
        return w.a;
    }

    public final void shareToMessenger(@NotNull Activity activity0, int v, @NotNull ShareToMessengerParams shareToMessengerParams0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(activity0, "activity");
            q.g(shareToMessengerParams0, "shareToMessengerParams");
            if(!this.hasMessengerInstalled(activity0)) {
                this.openMessengerInPlayStore(activity0);
                return;
            }
            if(this.getAllAvailableProtocolVersions(activity0).contains(20150314)) {
                this.shareToMessenger20150314(activity0, v, shareToMessengerParams0);
                return;
            }
            this.openMessengerInPlayStore(activity0);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void shareToMessenger20150314(Activity activity0, int v, ShareToMessengerParams shareToMessengerParams0) {
        try {
            Intent intent0 = new Intent("android.intent.action.SEND");
            intent0.setFlags(1);
            intent0.setPackage("com.facebook.orca");
            intent0.putExtra("android.intent.extra.STREAM", shareToMessengerParams0.getUri());
            intent0.setType(shareToMessengerParams0.getMimeType());
            intent0.putExtra("com.facebook.orca.extra.PROTOCOL_VERSION", 20150314);
            intent0.putExtra("com.facebook.orca.extra.APPLICATION_ID", FacebookSdk.getApplicationId());
            intent0.putExtra("com.facebook.orca.extra.METADATA", shareToMessengerParams0.getMetaData());
            intent0.putExtra("com.facebook.orca.extra.EXTERNAL_URI", shareToMessengerParams0.getExternalUri());
            activity0.startActivityForResult(intent0, v);
        }
        catch(ActivityNotFoundException unused_ex) {
            activity0.startActivity(activity0.getPackageManager().getLaunchIntentForPackage("com.facebook.orca"));
        }
    }

    private final void startViewUri(Context context0, String s) {
        context0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
    }
}

