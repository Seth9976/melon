package S1;

import R1.d;
import R1.e;
import Z1.i;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface.CustomFallbackBuilder;
import android.graphics.Typeface;
import android.graphics.fonts.Font.Builder;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily.Builder;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import d5.f;
import java.io.IOException;
import java.util.List;

public final class j extends f {
    public static Font Z(FontFamily fontFamily0, int v) {
        FontStyle fontStyle0 = new FontStyle(((v & 1) == 0 ? 400 : 700), ((v & 2) == 0 ? 0 : 1));
        Font font0 = fontFamily0.getFont(0);
        int v2 = j.b0(fontStyle0, font0.getStyle());
        for(int v1 = 1; v1 < fontFamily0.getSize(); ++v1) {
            Font font1 = fontFamily0.getFont(v1);
            int v3 = j.b0(fontStyle0, font1.getStyle());
            if(v3 < v2) {
                font0 = font1;
                v2 = v3;
            }
        }
        return font0;
    }

    public static FontFamily a0(i[] arr_i, ContentResolver contentResolver0) {
        FontFamily.Builder fontFamily$Builder0 = null;
        for(int v = 0; v < arr_i.length; ++v) {
            i i0 = arr_i[v];
            try(ParcelFileDescriptor parcelFileDescriptor0 = contentResolver0.openFileDescriptor(i0.a, "r", null)) {
                if(parcelFileDescriptor0 != null) {
                    Font font0 = new Font.Builder(parcelFileDescriptor0).setWeight(i0.c).setSlant(((int)i0.d)).setTtcIndex(i0.b).build();
                    if(fontFamily$Builder0 == null) {
                        fontFamily$Builder0 = new FontFamily.Builder(font0);
                    }
                    else {
                        fontFamily$Builder0.addFont(font0);
                    }
                }
            }
            catch(IOException iOException0) {
                Log.w("TypefaceCompatApi29Impl", "Font load failed", iOException0);
            }
        }
        return fontFamily$Builder0 == null ? null : fontFamily$Builder0.build();
    }

    public static int b0(FontStyle fontStyle0, FontStyle fontStyle1) {
        int v = Math.abs(fontStyle0.getWeight() - fontStyle1.getWeight());
        return fontStyle0.getSlant() == fontStyle1.getSlant() ? v / 100 : v / 100 + 2;
    }

    @Override  // d5.f
    public final Typeface o(Context context0, d d0, Resources resources0, int v) {
        try {
            e[] arr_e = d0.a;
            FontFamily.Builder fontFamily$Builder0 = null;
            for(int v1 = 0; true; ++v1) {
                if(v1 >= arr_e.length) {
                    if(fontFamily$Builder0 != null) {
                        FontFamily fontFamily0 = fontFamily$Builder0.build();
                        return new Typeface.CustomFallbackBuilder(fontFamily0).setStyle(j.Z(fontFamily0, v).getStyle()).build();
                    }
                    return null;
                }
                e e0 = arr_e[v1];
                try {
                    Font font0 = new Font.Builder(resources0, e0.f).setWeight(e0.b).setSlant(((int)e0.c)).setTtcIndex(e0.e).setFontVariationSettings(e0.d).build();
                    if(fontFamily$Builder0 == null) {
                        fontFamily$Builder0 = new FontFamily.Builder(font0);
                    }
                    else {
                        fontFamily$Builder0.addFont(font0);
                    }
                }
                catch(IOException unused_ex) {
                }
            }
        }
        catch(Exception exception0) {
        }
        Log.w("TypefaceCompatApi29Impl", "Font load failed", exception0);
        return null;
    }

    @Override  // d5.f
    public final Typeface p(Context context0, i[] arr_i, int v) {
        ContentResolver contentResolver0 = context0.getContentResolver();
        try {
            FontFamily fontFamily0 = j.a0(arr_i, contentResolver0);
            return fontFamily0 == null ? null : new Typeface.CustomFallbackBuilder(fontFamily0).setStyle(j.Z(fontFamily0, v).getStyle()).build();
        }
        catch(Exception exception0) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", exception0);
            return null;
        }
    }

    @Override  // d5.f
    public final Typeface q(Context context0, List list0, int v) {
        ContentResolver contentResolver0 = context0.getContentResolver();
        try {
            FontFamily fontFamily0 = j.a0(((i[])list0.get(0)), contentResolver0);
            if(fontFamily0 == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder typeface$CustomFallbackBuilder0 = new Typeface.CustomFallbackBuilder(fontFamily0);
            for(int v1 = 1; v1 < list0.size(); ++v1) {
                FontFamily fontFamily1 = j.a0(((i[])list0.get(v1)), contentResolver0);
                if(fontFamily1 != null) {
                    typeface$CustomFallbackBuilder0.addCustomFallback(fontFamily1);
                }
            }
            return typeface$CustomFallbackBuilder0.setStyle(j.Z(fontFamily0, v).getStyle()).build();
        }
        catch(Exception exception0) {
        }
        Log.w("TypefaceCompatApi29Impl", "Font load failed", exception0);
        return null;
    }

    @Override  // d5.f
    public final Typeface r(Context context0, Resources resources0, int v, String s, int v1) {
        try {
            Font font0 = new Font.Builder(resources0, v).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(font0).build()).setStyle(font0.getStyle()).build();
        }
        catch(Exception exception0) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", exception0);
            return null;
        }
    }

    @Override  // d5.f
    public final i x(i[] arr_i, int v) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}

