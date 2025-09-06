package com.iloen.melon.utils.ui;

import S1.c;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.LayoutInflater;
import android.view.View;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.utils.image.ImageUtils;
import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import m4.e;
import m4.g;
import m4.h;
import m4.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/utils/ui/LyricHighlightUtils;", "", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LyricHighlightUtils {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J1\u0010\t\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\b\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\r\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\r\u0010\u000FR\u0014\u0010\u0011\u001A\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/utils/ui/LyricHighlightUtils$Companion;", "", "Landroid/content/Context;", "context", "Landroid/graphics/Bitmap;", "bitmap", "", "useDoubleBlur", "hasDim", "drawPalette", "(Landroid/content/Context;Landroid/graphics/Bitmap;ZZ)Landroid/graphics/Bitmap;", "", "value", "getPaletteColor", "([I)[I", "(Landroid/graphics/Bitmap;)[I", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static Bitmap a(View view0) {
            view0.measure(0, 0);
            view0.layout(0, 0, view0.getMeasuredWidth(), view0.getMeasuredHeight());
            Bitmap bitmap0 = Bitmap.createBitmap(view0.getMeasuredWidth(), view0.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            q.f(bitmap0, "createBitmap(...)");
            view0.draw(new Canvas(bitmap0));
            return bitmap0;
        }

        public static void b(float[] arr_f) {
            if(arr_f.length < 3) {
                LogU.Companion.d("LyricHighlightUtils", "setPaletteHSL() - invalid color");
                return;
            }
            if(arr_f[1] >= 0.8f) {
                arr_f[1] = 0.5f;
            }
            float f = arr_f[2];
            if(f < 0.65f) {
                arr_f[2] = 0.65f;
                return;
            }
            if(f > 0.8f) {
                arr_f[2] = 0.8f;
            }
        }

        @NotNull
        public final Bitmap drawPalette(@NotNull Context context0, @NotNull Bitmap bitmap0, boolean z, boolean z1) {
            q.g(context0, "context");
            q.g(bitmap0, "bitmap");
            try {
                e e0 = new e(bitmap0);
                e0.a = 24;
                h h0 = e0.a();
                g g0 = h0.a(i.e);
                int v = -1;
                int v1 = g0 == null ? -1 : g0.d;
                g g1 = h0.a(i.d);
                int v2 = g1 == null ? -1 : g1.d;
                g g2 = h0.a(i.h);
                if(g2 != null) {
                    v = g2.d;
                }
                int[] arr_v = this.getPaletteColor(new int[]{v1, v2, v});
                int v3 = 0;
                View view0 = LayoutInflater.from(context0).inflate(0x7F0D04C2, null, false);  // layout:lyric_highlight_template
                View view1 = view0.findViewById(0x7F0A065B);  // id:iv_palette1
                q.f(view1, "findViewById(...)");
                View view2 = view0.findViewById(0x7F0A065C);  // id:iv_palette2
                q.f(view2, "findViewById(...)");
                View view3 = view0.findViewById(0x7F0A065D);  // id:iv_palette3
                q.f(view3, "findViewById(...)");
                ((MelonImageView)view1).setColorFilter(arr_v[0]);
                PorterDuff.Mode porterDuff$Mode0 = PorterDuff.Mode.SRC_IN;
                ((MelonImageView)view2).setColorFilter(arr_v[1], porterDuff$Mode0);
                ((MelonImageView)view3).setColorFilter(arr_v[2], porterDuff$Mode0);
                ((MelonImageView)view2).setImageBitmap(ImageUtils.blurRenderScript(context0, Companion.a(((MelonImageView)view2)), 12, 1.0f));
                ((MelonImageView)view3).setImageBitmap(ImageUtils.blurRenderScript(context0, Companion.a(((MelonImageView)view3)), 4, 1.0f));
                ((MelonImageView)view3).setAlpha(0.7f);
                View view4 = view0.findViewById(0x7F0A0B48);  // id:template_container
                q.f(view4, "findViewById(...)");
                Bitmap bitmap1 = ImageUtils.createBlurredBitmap(context0, 25, 10, Companion.a(view4));
                View view5 = view0.findViewById(0x7F0A0102);  // id:bg_blur
                q.f(view5, "findViewById(...)");
                if(!z1) {
                    v3 = 8;
                }
                view5.setVisibility(v3);
                if(z) {
                    Bitmap bitmap2 = ImageUtils.createBlurredBitmap(context0, 5, 4, bitmap1);
                    q.d(bitmap2);
                    return bitmap2;
                }
                q.d(bitmap1);
                return bitmap1;
            }
            catch(OutOfMemoryError unused_ex) {
                Bitmap bitmap3 = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                q.f(bitmap3, "createBitmap(...)");
                return bitmap3;
            }
        }

        public static Bitmap drawPalette$default(Companion lyricHighlightUtils$Companion0, Context context0, Bitmap bitmap0, boolean z, boolean z1, int v, Object object0) {
            if((v & 4) != 0) {
                z = false;
            }
            if((v & 8) != 0) {
                z1 = true;
            }
            return lyricHighlightUtils$Companion0.drawPalette(context0, bitmap0, z, z1);
        }

        @NotNull
        public final int[] getPaletteColor(@NotNull Bitmap bitmap0) {
            q.g(bitmap0, "bitmap");
            e e0 = new e(bitmap0);
            e0.a = 24;
            h h0 = e0.a();
            g g0 = h0.a(i.e);
            int v = -1;
            int v1 = g0 == null ? -1 : g0.d;
            g g1 = h0.a(i.d);
            int v2 = g1 == null ? -1 : g1.d;
            g g2 = h0.a(i.h);
            if(g2 != null) {
                v = g2.d;
            }
            return new int[]{v1, v2, v};
        }

        @NotNull
        public final int[] getPaletteColor(@NotNull int[] arr_v) {
            q.g(arr_v, "value");
            for(int v = 0; v < arr_v.length; ++v) {
                if(arr_v[v] == -1) {
                    for(int v1 = 0; v1 < arr_v.length; ++v1) {
                        arr_v[v1] = 0xFF000000;
                    }
                    break;
                }
            }
            int v2 = arr_v[0];
            float[] arr_f = new float[3];
            int v3 = arr_v[1];
            float[] arr_f1 = new float[3];
            int v4 = arr_v[2];
            float[] arr_f2 = new float[3];
            c.b(Color.red(v2), Color.green(v2), Color.blue(v2), arr_f);
            c.b(Color.red(v3), Color.green(v3), Color.blue(v3), arr_f1);
            c.b(Color.red(v4), Color.green(v4), Color.blue(v4), arr_f2);
            Companion.b(arr_f);
            Companion.b(arr_f1);
            Companion.b(arr_f2);
            if(v4 == v2) {
                float f = arr_f2[2];
                if(f >= 0.7f) {
                    arr_f[2] += 0.1f;
                    return new int[]{c.a(arr_f), c.a(arr_f1), c.a(arr_f2)};
                }
                arr_f2[2] = f - 0.15f;
                return new int[]{c.a(arr_f), c.a(arr_f1), c.a(arr_f2)};
            }
            if(v4 == v3) {
                float f1 = arr_f2[2];
                if(f1 >= 0.7f) {
                    arr_f1[2] += 0.1f;
                    return new int[]{c.a(arr_f), c.a(arr_f1), c.a(arr_f2)};
                }
                arr_f2[2] = f1 - 0.15f;
            }
            return new int[]{c.a(arr_f), c.a(arr_f1), c.a(arr_f2)};
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;

    static {
        LyricHighlightUtils.Companion = new Companion(null);
    }
}

