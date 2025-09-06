package com.iloen.melon.utils.shortcut;

import E9.w;
import Q1.c;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo.Builder;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import ie.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.q;

public class ShortcutManager {
    class AllowedShortcutReceiver extends BroadcastReceiver {
        public final ShortcutManager a;

        @Override  // android.content.BroadcastReceiver
        public void onReceive(Context context0, Intent intent0) {
            ShortcutManager.this.a();
        }
    }

    public interface OnRequestListener {
        void onRequestFinish(String arg1);
    }

    public static class ShortcutInfo {
        public Intent data;
        public Bitmap icon;
        public int iconResId;
        public String shortcutId;
        public String title;
        public int titleResId;

        public ShortcutInfo() {
            this.titleResId = -1;
            this.iconResId = -1;
        }
    }

    static class ShortcutManagerHolder {
        public static final ShortcutManager a;

        static {
            ShortcutManager shortcutManager0 = new ShortcutManager();  // 初始化器: Ljava/lang/Object;-><init>()V
            shortcutManager0.e = true;
            shortcutManager0.a = MelonAppBase.instance.getContext();
            ShortcutManagerHolder.a = shortcutManager0;
        }
    }

    public Context a;
    public LinkedList b;
    public AllowedShortcutReceiver c;
    public OnRequestListener d;
    public boolean e;
    public static final ShortCutItem[] f;

    static {
        ShortcutManager.f = new ShortCutItem[]{ShortCutItem.MELON_CHART, ShortCutItem.MELON_DJ, ShortCutItem.MELON_SEARCH, ShortCutItem.MELON};
    }

    public final void a() {
        ShortcutInfo shortcutManager$ShortcutInfo0 = this.b == null ? null : ((ShortcutInfo)this.b.poll());
        if(shortcutManager$ShortcutInfo0 != null) {
            this.requestShortcut(shortcutManager$ShortcutInfo0);
            OnRequestListener shortcutManager$OnRequestListener0 = this.d;
            if(shortcutManager$OnRequestListener0 != null) {
                shortcutManager$OnRequestListener0.onRequestFinish(shortcutManager$ShortcutInfo0.shortcutId);
            }
            return;
        }
        LogU.d("ShortcutManager", "Finish request all item");
    }

    public ShortcutInfo createShortcutData(ShortCutItem shortCutItem0) {
        String s = shortCutItem0.getShortcutId();
        ShortCutItem shortCutItem1 = ShortCutItem.MELON;
        if(s.equals(shortCutItem1.getShortcutId())) {
            return ShortcutManager.createShortcutInfo(s, shortCutItem0.getStringId(), 0x7F100000, ShortcutManager.createShortcutDataIntent(shortCutItem1.getShortcutUri()));  // mipmap:icon_launcher
        }
        ShortCutItem shortCutItem2 = ShortCutItem.MELON_DJ;
        if(s.equals(shortCutItem2.getShortcutId())) {
            return ShortcutManager.createShortcutInfo(s, shortCutItem0.getStringId(), 0x7F100003, ShortcutManager.createShortcutDataIntent(shortCutItem2.getShortcutUri()));  // mipmap:icon_launcher_dj
        }
        ShortCutItem shortCutItem3 = ShortCutItem.MELON_SEARCH;
        if(s.equals(shortCutItem3.getShortcutId())) {
            return ShortcutManager.createShortcutInfo(s, shortCutItem0.getStringId(), 0x7F100005, ShortcutManager.createShortcutDataIntent(shortCutItem3.getShortcutUri()));  // mipmap:icon_launcher_music
        }
        return s.equals(ShortCutItem.MELON_CHART.getShortcutId()) ? ShortcutManager.createShortcutInfo(s, shortCutItem0.getStringId(), 0x7F100002, ShortcutManager.createShortcutDataIntent(ShortCutItem.MELON_CHART.getShortcutUri())) : ShortcutManager.createShortcutInfo(s, shortCutItem0.getStringId(), -1, null);  // mipmap:icon_launcher_chart
    }

    public static Intent createShortcutDataIntent(Uri uri0) {
        Intent intent0 = new Intent(MelonAppBase.instance.getContext(), MusicBrowserActivity.class);
        intent0.setAction("android.intent.action.VIEW");
        intent0.addFlags(0x4000000);
        intent0.addFlags(0x10000000);
        intent0.setData(uri0);
        return intent0;
    }

    public static ShortcutInfo createShortcutInfo(String s, int v, int v1, Intent intent0) {
        ShortcutInfo shortcutManager$ShortcutInfo0 = new ShortcutInfo();
        shortcutManager$ShortcutInfo0.shortcutId = s;
        shortcutManager$ShortcutInfo0.titleResId = v;
        shortcutManager$ShortcutInfo0.iconResId = v1;
        shortcutManager$ShortcutInfo0.data = intent0;
        return shortcutManager$ShortcutInfo0;
    }

    public static ShortcutInfo createShortcutInfo(String s, String s1, Bitmap bitmap0, Intent intent0) {
        ShortcutInfo shortcutManager$ShortcutInfo0 = new ShortcutInfo();
        shortcutManager$ShortcutInfo0.shortcutId = s;
        shortcutManager$ShortcutInfo0.title = s1;
        shortcutManager$ShortcutInfo0.icon = bitmap0;
        shortcutManager$ShortcutInfo0.data = intent0;
        return shortcutManager$ShortcutInfo0;
    }

    public static ShortcutManager getInstance() {
        return ShortcutManagerHolder.a;
    }

    public boolean hasRegistedReceiver() {
        return this.c != null;
    }

    public boolean hasShortcutInHomeScreen(String s, boolean z) {
        boolean z1;
        if(!TextUtils.isEmpty(s)) {
            android.content.pm.ShortcutManager shortcutManager0 = (android.content.pm.ShortcutManager)this.a.getSystemService(android.content.pm.ShortcutManager.class);
            if(z) {
                z1 = false;
                for(Object object0: shortcutManager0.getManifestShortcuts()) {
                    if(((android.content.pm.ShortcutInfo)object0).getId().startsWith(s)) {
                        z1 = true;
                    }
                }
            }
            else {
                z1 = false;
            }
            for(Object object1: shortcutManager0.getPinnedShortcuts()) {
                if(((android.content.pm.ShortcutInfo)object1).getId().equals(s)) {
                    return true;
                }
                if(z1 && ((android.content.pm.ShortcutInfo)object1).getId().startsWith(s)) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }

    public List makeShortCutListItems() {
        List list0 = new ArrayList();
        ShortCutItem[] arr_shortCutItem = ShortcutManager.f;
        for(int v = 0; v < arr_shortCutItem.length; ++v) {
            ShortCutItem shortCutItem0 = arr_shortCutItem[v];
            ((ArrayList)list0).add(new m(shortCutItem0, Boolean.valueOf(!ShortcutManager.getInstance().hasShortcutInHomeScreen(shortCutItem0.getShortcutId(), true))));
        }
        return list0;
    }

    public void requestShortcut(ShortcutInfo shortcutManager$ShortcutInfo0) {
        Context context0 = this.a;
        if(shortcutManager$ShortcutInfo0 == null) {
            LogU.d("ShortcutManager", "[WARNING] :: param is null.");
            return;
        }
        if(this.hasShortcutInHomeScreen(shortcutManager$ShortcutInfo0.shortcutId, this.e)) {
            LogU.d("ShortcutManager", "Already exist shortcut");
            this.a();
            return;
        }
        String s = shortcutManager$ShortcutInfo0.titleResId == -1 ? shortcutManager$ShortcutInfo0.title : context0.getString(shortcutManager$ShortcutInfo0.titleResId);
        int v = shortcutManager$ShortcutInfo0.iconResId;
        Icon icon0 = v == -1 ? Icon.createWithBitmap(shortcutManager$ShortcutInfo0.icon) : Icon.createWithResource(context0, v);
        android.content.pm.ShortcutInfo shortcutInfo0 = new ShortcutInfo.Builder(context0, shortcutManager$ShortcutInfo0.shortcutId).setIntent(shortcutManager$ShortcutInfo0.data).setShortLabel(s).setIcon(icon0).build();
        Intent intent0 = new Intent();
        c.Y(intent0, "action_create_shortcut_success", true);
        intent0.putExtra("extra_shortcut_title", s);
        PendingIntent pendingIntent0 = PendingIntent.getBroadcast(context0, 0, intent0, 0x44000000);
        if(pendingIntent0 != null) {
            try {
                ((android.content.pm.ShortcutManager)context0.getSystemService(android.content.pm.ShortcutManager.class)).requestPinShortcut(shortcutInfo0, pendingIntent0.getIntentSender());
            }
            catch(Exception unused_ex) {
                this.a();
            }
            return;
        }
        this.a();
    }

    public void requestShortcut(List list0, OnRequestListener shortcutManager$OnRequestListener0) {
        if(list0 != null && !list0.isEmpty()) {
            this.d = shortcutManager$OnRequestListener0;
            if(this.c == null) {
                AllowedShortcutReceiver shortcutManager$AllowedShortcutReceiver0 = new AllowedShortcutReceiver(this);
                this.c = shortcutManager$AllowedShortcutReceiver0;
                Context context0 = this.a;
                IntentFilter intentFilter0 = new IntentFilter("action_create_shortcut_success");
                q.g(context0, "<this>");
                w.S(context0, shortcutManager$AllowedShortcutReceiver0, intentFilter0, null);
            }
            if(this.b == null) {
                this.b = new LinkedList();
            }
            this.b.clear();
            this.b.addAll(list0);
            ShortcutInfo shortcutManager$ShortcutInfo0 = (ShortcutInfo)this.b.poll();
            this.requestShortcut(shortcutManager$ShortcutInfo0);
            OnRequestListener shortcutManager$OnRequestListener1 = this.d;
            if(shortcutManager$OnRequestListener1 != null) {
                shortcutManager$OnRequestListener1.onRequestFinish(shortcutManager$ShortcutInfo0.shortcutId);
            }
            return;
        }
        LogU.d("ShortcutManager", "[WARNING] :: param is null.");
    }

    public void sendClickLog(String s) {
        String s1;
        if(s.equals(ShortCutItem.MELON.getShortcutId())) {
            s1 = "M01";
        }
        else if(s.equals(ShortCutItem.MELON_DJ.getShortcutId())) {
            s1 = "S04";
        }
        else {
            s1 = s.equals(ShortCutItem.MELON_SEARCH.getShortcutId()) ? "S22" : "";
        }
        g.a0("5", s1, "A3");
    }

    public void unregisterReceiver() {
        AllowedShortcutReceiver shortcutManager$AllowedShortcutReceiver0 = this.c;
        if(shortcutManager$AllowedShortcutReceiver0 != null) {
            this.a.unregisterReceiver(shortcutManager$AllowedShortcutReceiver0);
            this.c = null;
        }
    }
}

