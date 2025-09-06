package com.kakao.emoticon.util;

import A7.d;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.view.View;
import com.iloen.melon.fragments.present.a;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.R.drawable;
import com.kakao.emoticon.R.string;
import com.kakao.emoticon.controller.EmoticonManager;
import com.kakao.emoticon.controller.EmoticonPreference;
import com.kakao.emoticon.ui.EmoticonDialog;
import java.util.List;

public class IntentUtils {
    public static void a(String s, String s1, View view0) {
        IntentUtils.lambda$goToEmoticonStoreAlert$0(s, s1, view0);
    }

    private static Intent getPackageMarketDetailIntent(Context context0, String s) {
        Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse(("market://details?id=" + s)));
        intent0.addFlags(0x80000);
        return IntentUtils.isIntentAvailable(context0, intent0) ? intent0 : new Intent("android.intent.action.VIEW", Uri.parse(("https://play.google.com/store/apps/details?id=" + s))).addFlags(0x80000);
    }

    public static void goToEmoticonStore(String s, String s1) {
        Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse(("kakaotalk://store?referer=e_sdk_" + s + "_" + s1)));
        if(!IntentUtils.isIntentAvailable(KakaoEmoticon.getApplication(), intent0)) {
            intent0 = IntentUtils.getPackageMarketDetailIntent(KakaoEmoticon.getApplication(), "com.kakao.talk");
        }
        intent0.setFlags(0x10800000);
        EmoticonManager.INSTANCE.setNeedSyncKeyboard(true);
        KakaoEmoticon.getApplication().startActivity(intent0);
    }

    public static void goToEmoticonStoreAlert(Context context0, String s, String s1) {
        if(EmoticonPreference.getInstance().isStoreGuideNeverAskAgain()) {
            if(s1.equals("my")) {
                ActionTracker.pushLog("A002", "02", null);
            }
            else {
                ActionTracker.pushLog("A001", "05", null);
            }
            IntentUtils.goToEmoticonStore(s, s1);
            return;
        }
        if(s1.equals("my")) {
            ActionTracker.pushLog("A002", "01", null);
        }
        else {
            ActionTracker.pushLog("A001", "04", null);
        }
        EmoticonDialog emoticonDialog0 = new EmoticonDialog(context0);
        emoticonDialog0.setTitle(string.label_store_guide_title);
        emoticonDialog0.setMessage(string.label_store_guide_msg);
        int v = ScreenUtils.INSTANCE.dp2px(65.0f);
        int v1 = ScreenUtils.INSTANCE.dp2px(60.0f);
        emoticonDialog0.setMsgIcon(drawable.icon_dialog_rian, v, v1);
        emoticonDialog0.setNegativeButton(string.label_cancel, null);
        a a0 = new a(6, s1, s);
        emoticonDialog0.setPositiveButton(string.label_go_to_store, a0);
        emoticonDialog0.show();
    }

    public static void goToEmoticonStoreAndShowItem(String s, String s1, String s2) {
        StringBuilder stringBuilder0 = d.o("kakaotalk://store/emoticon/", s, "?referer=e_sdk_", s1, "_");
        stringBuilder0.append(s2);
        stringBuilder0.append("&calltime=");
        stringBuilder0.append(System.currentTimeMillis());
        Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder0.toString()));
        if(!IntentUtils.isIntentAvailable(KakaoEmoticon.getApplication(), intent0)) {
            intent0 = IntentUtils.getPackageMarketDetailIntent(KakaoEmoticon.getApplication(), "com.kakao.talk");
        }
        intent0.setFlags(0x10800000);
        EmoticonManager.INSTANCE.setNeedSyncKeyboard(true);
        KakaoEmoticon.getApplication().startActivity(intent0);
    }

    public static boolean isInstalledApplication(Context context0, String s) {
        try {
            if(context0.getPackageManager().getApplicationInfo(s, 0x80) != null) {
                return true;
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return false;
    }

    private static boolean isIntentAvailable(Context context0, Intent intent0) {
        List list0 = context0.getPackageManager().queryIntentActivities(intent0, 0x10000);
        return list0 == null ? false : !list0.isEmpty();
    }

    private static void lambda$goToEmoticonStoreAlert$0(String s, String s1, View view0) {
        EmoticonPreference.getInstance().setStoreGuideNeverAskAgain(true);
        if(s.equals("my")) {
            ActionTracker.pushLog("A002", "03", null);
        }
        else {
            ActionTracker.pushLog("A001", "06", null);
        }
        IntentUtils.goToEmoticonStore(s1, s);
    }

    public static void shareItemUrl(Context context0, String s) {
        Intent intent0 = new Intent("android.intent.action.SEND");
        intent0.setType("text/plain");
        intent0.putExtra("android.intent.extra.TEXT", s);
        context0.startActivity(Intent.createChooser(intent0, "Kakao Emoticon"));
    }
}

