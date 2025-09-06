package com.iloen.melon.utils.shortcut;

import H0.b;
import Q1.a;
import Q1.c;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import com.iloen.melon.MusicBrowserActivity;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0015\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/content/Context;", "context", "Lie/H;", "pushMelonDynamicShortcut", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class DynamicShortcutKt {
    public static final void pushMelonDynamicShortcut(@NotNull Context context0) {
        q.g(context0, "context");
        Class class0 = ShortcutManager.class;
        ((ShortcutManager)context0.getSystemService(class0)).removeAllDynamicShortcuts();
        c.E(context0).getClass();
        Iterator iterator0 = ((ArrayList)c.D(context0)).iterator();
        if(iterator0.hasNext()) {
            throw b.b(iterator0);
        }
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.a = context0;
        a0.c = "음악검색";
        a0.d = "음악검색";
        a0.e = IconCompat.c(context0, 0x7F100005);  // mipmap:icon_launcher_music
        Intent intent0 = new Intent(context0, MusicBrowserActivity.class);
        intent0.setAction("com.iloen.melon.intent.action.appshortcut.search");
        intent0.setData(Uri.parse("melonapp://recordandsearch/shortcut?ref=W51001"));
        a0.b = new Intent[]{intent0};
        if(TextUtils.isEmpty(a0.c)) {
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }
        if(a0.b == null || a0.b.length == 0) {
            throw new IllegalArgumentException("Shortcut must have an intent");
        }
        int v = Build.VERSION.SDK_INT;
        int v1 = ((ShortcutManager)context0.getSystemService(class0)).getMaxShortcutCountPerActivity();
        if(v1 != 0) {
            if(v <= 29) {
                IconCompat iconCompat0 = a0.e;
                int v2 = iconCompat0.a;
                if(v2 == 4 || v2 == 6) {
                    InputStream inputStream0 = iconCompat0.i(context0);
                    if(inputStream0 != null) {
                        Bitmap bitmap0 = BitmapFactory.decodeStream(inputStream0);
                        if(bitmap0 != null) {
                            IconCompat iconCompat1 = v2 == 6 ? new IconCompat(5) : new IconCompat(1);
                            iconCompat1.b = bitmap0;
                            a0.e = iconCompat1;
                        }
                    }
                }
            }
            int v3 = -1;
            if(v >= 30) {
                ((ShortcutManager)context0.getSystemService(class0)).pushDynamicShortcut(a0.a());
                goto label_55;
            }
            ShortcutManager shortcutManager0 = (ShortcutManager)context0.getSystemService(class0);
            if(!shortcutManager0.isRateLimitingActive()) {
                List list0 = shortcutManager0.getDynamicShortcuts();
                if(list0.size() >= v1) {
                    String s = null;
                    int v4 = -1;
                    for(Object object0: list0) {
                        ShortcutInfo shortcutInfo0 = (ShortcutInfo)object0;
                        if(shortcutInfo0.getRank() > v4) {
                            s = shortcutInfo0.getId();
                            v4 = shortcutInfo0.getRank();
                        }
                    }
                    shortcutManager0.removeDynamicShortcuts(Arrays.asList(new String[]{s}));
                }
                shortcutManager0.addDynamicShortcuts(Arrays.asList(new ShortcutInfo[]{a0.a()}));
            label_55:
                Q1.b b0 = c.E(context0);
                try {
                    b0.getClass();
                    ArrayList arrayList0 = new ArrayList();
                    if(arrayList0.size() >= v1) {
                        String s1 = null;
                        for(Object object1: arrayList0) {
                            ((a)object1).getClass();
                            if(v3 < 0) {
                                s1 = "id_melon_search";
                                v3 = 0;
                            }
                        }
                        Arrays.asList(new String[]{s1});
                    }
                    Arrays.asList(new a[]{a0});
                    goto label_91;
                }
                catch(Exception unused_ex) {
                }
                catch(Throwable throwable0) {
                    goto label_82;
                }
                Iterator iterator3 = ((ArrayList)c.D(context0)).iterator();
                if(!iterator3.hasNext()) {
                    c.O(context0);
                    return;
                }
                Object object2 = iterator3.next();
                if(object2 != null) {
                    throw new ClassCastException();
                }
                Collections.singletonList(a0);
                throw null;
            label_82:
                Iterator iterator4 = ((ArrayList)c.D(context0)).iterator();
                if(iterator4.hasNext()) {
                    Object object3 = iterator4.next();
                    if(object3 != null) {
                        throw new ClassCastException();
                    }
                    Collections.singletonList(a0);
                    throw null;
                }
                c.O(context0);
                throw throwable0;
            label_91:
                Iterator iterator5 = ((ArrayList)c.D(context0)).iterator();
                if(!iterator5.hasNext()) {
                    c.O(context0);
                    return;
                }
                Object object4 = iterator5.next();
                if(object4 != null) {
                    throw new ClassCastException();
                }
                Collections.singletonList(a0);
                throw null;
            }
        }
    }
}

