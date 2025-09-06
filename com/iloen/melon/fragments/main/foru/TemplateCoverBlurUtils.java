package com.iloen.melon.fragments.main.foru;

import S1.c;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.image.ImageUtils;
import e.k;
import java.util.ArrayList;
import je.p;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import m4.e;
import m4.g;
import m4.h;
import m4.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/TemplateCoverBlurUtils;", "", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TemplateCoverBlurUtils {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007J\u001B\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0002¢\u0006\u0002\u0010\rJ!\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u00102\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0002¢\u0006\u0002\u0010\u0011J\u000E\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u0014R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/TemplateCoverBlurUtils$Companion;", "", "<init>", "()V", "TAG", "", "getBlurredBackground", "Lcom/iloen/melon/fragments/main/foru/TemplateCoverBlurData;", "srcBitmap", "Landroid/graphics/Bitmap;", "normalize", "", "color", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "getSubColor", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/Integer;)I", "getCapturedDrawableFromView", "view", "Landroid/view/View;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TemplateCoverBlurData getBlurredBackground(@NotNull Bitmap bitmap0) {
            q.g(bitmap0, "srcBitmap");
            Context context0 = Y.a(MelonAppBase.Companion);
            e e0 = new e(bitmap0);
            e0.a = 24;
            h h0 = e0.a();
            g g0 = h0.a(i.f);
            Integer integer0 = this.normalize((g0 == null ? null : g0.d));
            g g1 = h0.a(i.d);
            Integer integer1 = this.normalize((g1 == null ? null : g1.d));
            g g2 = h0.a(i.g);
            ArrayList arrayList0 = E9.h.W(p.i0(k.e(new Integer[]{integer0, integer1, this.normalize((g2 == null ? null : g2.d))})));
            if(arrayList0.size() < 1) {
                int v = ColorUtils.getColor(context0, 0x7F060082);  // color:color_303030
                for(int v1 = 0; v1 < 3; v1 = a.d(v, v1, 1, arrayList0)) {
                }
            }
            else if(arrayList0.size() < 2) {
                Integer integer2 = (Integer)arrayList0.get(0);
                arrayList0.add(TemplateCoverBlurUtils.Companion.getSubColor(context0, integer2));
                arrayList0.add(arrayList0.get(0));
            }
            else if(arrayList0.size() < 3) {
                arrayList0.add(arrayList0.get(0));
            }
            View view0 = LayoutInflater.from(context0).inflate(0x7F0D086C, null, false);  // layout:tab_music_top_curation_blur_bg_template
            ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A0601);  // id:iv_bg_circle1
            Object object0 = arrayList0.get(0);
            q.f(object0, "get(...)");
            imageView0.setColorFilter(((Number)object0).intValue());
            ImageView imageView1 = (ImageView)view0.findViewById(0x7F0A0602);  // id:iv_bg_circle2
            Object object1 = arrayList0.get(1);
            q.f(object1, "get(...)");
            imageView1.setColorFilter(((Number)object1).intValue());
            ImageView imageView2 = (ImageView)view0.findViewById(0x7F0A0603);  // id:iv_bg_circle3
            Object object2 = arrayList0.get(2);
            q.f(object2, "get(...)");
            imageView2.setColorFilter(((Number)object2).intValue());
            Bitmap bitmap1 = ImageUtils.createBlurredBitmap(context0, 5, 10, ImageUtils.createBlurredBitmap(context0, 25, 5, this.getCapturedDrawableFromView(view0)));
            q.d(bitmap1);
            Object object3 = arrayList0.get(2);
            q.f(object3, "get(...)");
            return new TemplateCoverBlurData(bitmap1, ((Number)object3).intValue());
        }

        @NotNull
        public final Bitmap getCapturedDrawableFromView(@NotNull View view0) {
            q.g(view0, "view");
            view0.measure(0, 0);
            view0.layout(0, 0, view0.getMeasuredWidth(), view0.getMeasuredHeight());
            Bitmap bitmap0 = Bitmap.createBitmap(view0.getMeasuredWidth(), view0.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            q.f(bitmap0, "createBitmap(...)");
            view0.draw(new Canvas(bitmap0));
            return bitmap0;
        }

        private final int getSubColor(Context context0, Integer integer0) {
            if(integer0 != null && ((int)integer0) != -1) {
                float[] arr_f = new float[3];
                c.b(Color.red(((int)integer0)), Color.green(((int)integer0)), Color.blue(((int)integer0)), arr_f);
                float f = arr_f[2];
                if(f > 0.7f) {
                    arr_f[2] = f * 0.7f;
                    return c.a(arr_f);
                }
                if(f < 0.7f) {
                    arr_f[2] = f * 1.3f;
                }
                return c.a(arr_f);
            }
            return ColorUtils.getColor(context0, 0x7F060082);  // color:color_303030
        }

        private final Integer normalize(Integer integer0) {
            if(integer0 != null && ((int)integer0) != -1) {
                float[] arr_f = new float[3];
                c.b(Color.red(((int)integer0)), Color.green(((int)integer0)), Color.blue(((int)integer0)), arr_f);
                float f = arr_f[1];
                float f1 = 0.8f;
                if(f > 0.8f) {
                    f = 0.8f;
                }
                arr_f[1] = f;
                float f2 = arr_f[2];
                if(f2 <= 0.8f) {
                    f1 = f2;
                }
                if(f1 < 0.3f) {
                    f1 = 0.3f;
                }
                arr_f[2] = f1;
                return c.a(arr_f);
            }
            return null;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "TemplateCoverBlurUtils";

    static {
        TemplateCoverBlurUtils.Companion = new Companion(null);
    }

    @NotNull
    public static final TemplateCoverBlurData getBlurredBackground(@NotNull Bitmap bitmap0) {
        return TemplateCoverBlurUtils.Companion.getBlurredBackground(bitmap0);
    }
}

