package f;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import com.google.android.material.internal.F;
import com.kakao.sdk.common.util.a;
import e.j;
import e.k;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import je.w;
import kotlin.jvm.internal.q;

public final class c extends b {
    public final int a;

    public c(int v) {
        this.a = v;
        if(v <= 1) {
            throw new IllegalArgumentException("Max items must be higher than 1");
        }
    }

    @Override  // f.b
    public final Intent createIntent(Context context0, Object object0) {
        q.g(((j)object0), "input");
        int v = this.a;
        if(Build.VERSION.SDK_INT >= 33 || Build.VERSION.SDK_INT >= 30 && F.x() >= 2) {
            Intent intent0 = new Intent("android.provider.action.PICK_IMAGES");
            intent0.setType(k.x(((j)object0).a));
            int v1 = Math.min(v, ((j)object0).b);
            if(v1 <= 1 || v1 > a.a()) {
                throw new IllegalArgumentException("Max items must be greater than 1 and lesser than or equal to MediaStore.getPickImagesMaxLimit()");
            }
            intent0.putExtra("android.provider.extra.PICK_IMAGES_MAX", v1);
            ((j)object0).c.getClass();
            intent0.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", 1);
            intent0.putExtra("android.provider.extra.PICK_IMAGES_IN_ORDER", false);
            return intent0;
        }
        if(context0.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 0x110000) != null) {
            ResolveInfo resolveInfo0 = context0.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 0x110000);
            if(resolveInfo0 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ActivityInfo activityInfo0 = resolveInfo0.activityInfo;
            Intent intent1 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
            intent1.setClassName(activityInfo0.applicationInfo.packageName, activityInfo0.name);
            intent1.setType(k.x(((j)object0).a));
            int v2 = Math.min(v, ((j)object0).b);
            if(v2 <= 1) {
                throw new IllegalArgumentException("Max items must be greater than 1");
            }
            intent1.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_MAX", v2);
            ((j)object0).c.getClass();
            intent1.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", 1);
            intent1.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_IN_ORDER", false);
            return intent1;
        }
        Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent2.setType(k.x(((j)object0).a));
        intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        if(intent2.getType() == null) {
            intent2.setType("*/*");
            intent2.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        }
        return intent2;
    }

    @Override  // f.b
    public final f.a getSynchronousResult(Context context0, Object object0) {
        q.g(context0, "context");
        q.g(((j)object0), "input");
        return null;
    }

    @Override  // f.b
    public final Object parseResult(int v, Intent intent0) {
        if(v != -1) {
            intent0 = null;
        }
        if(intent0 != null) {
            LinkedHashSet linkedHashSet0 = new LinkedHashSet();
            Uri uri0 = intent0.getData();
            if(uri0 != null) {
                linkedHashSet0.add(uri0);
            }
            ClipData clipData0 = intent0.getClipData();
            if(clipData0 != null || !linkedHashSet0.isEmpty()) {
                if(clipData0 != null) {
                    int v1 = clipData0.getItemCount();
                    for(int v2 = 0; v2 < v1; ++v2) {
                        Uri uri1 = clipData0.getItemAt(v2).getUri();
                        if(uri1 != null) {
                            linkedHashSet0.add(uri1);
                        }
                    }
                }
                return new ArrayList(linkedHashSet0);
            }
        }
        return w.a;
    }
}

