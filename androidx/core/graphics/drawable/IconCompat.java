package androidx.core.graphics.drawable;

import P1.a;
import P1.b;
import U4.x;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class IconCompat extends CustomVersionedParcelable {
    public int a;
    public Object b;
    public byte[] c;
    public Parcelable d;
    public int e;
    public int f;
    public ColorStateList g;
    public PorterDuff.Mode h;
    public String i;
    public String j;
    public static final PorterDuff.Mode k;

    static {
        IconCompat.k = PorterDuff.Mode.SRC_IN;
    }

    public IconCompat() {
        this.a = -1;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = IconCompat.k;
        this.i = null;
    }

    public IconCompat(int v) {
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = null;
        this.h = IconCompat.k;
        this.i = null;
        this.a = v;
    }

    public static IconCompat b(Bundle bundle0) {
        int v = bundle0.getInt("type");
        IconCompat iconCompat0 = new IconCompat(v);
        iconCompat0.e = bundle0.getInt("int1");
        iconCompat0.f = bundle0.getInt("int2");
        iconCompat0.j = bundle0.getString("string1");
        if(bundle0.containsKey("tint_list")) {
            iconCompat0.g = (ColorStateList)bundle0.getParcelable("tint_list");
        }
        if(bundle0.containsKey("tint_mode")) {
            iconCompat0.h = PorterDuff.Mode.valueOf(bundle0.getString("tint_mode"));
        }
        switch(v) {
            case 3: {
                iconCompat0.b = bundle0.getByteArray("obj");
                return iconCompat0;
            }
            case -1: 
            case 1: 
            case 5: {
                iconCompat0.b = bundle0.getParcelable("obj");
                return iconCompat0;
            }
            case 2: 
            case 4: 
            case 6: {
                iconCompat0.b = bundle0.getString("obj");
                return iconCompat0;
            }
            default: {
                x.u(v, "Unknown type ", "IconCompat");
                return null;
            }
        }
    }

    public static IconCompat c(Context context0, int v) {
        context0.getClass();
        return IconCompat.d(context0.getResources(), "com.iloen.melon", v);
    }

    public static IconCompat d(Resources resources0, String s, int v) {
        s.getClass();
        if(v == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat0 = new IconCompat(2);
        iconCompat0.e = v;
        if(resources0 == null) {
            iconCompat0.b = s;
        }
        else {
            try {
                iconCompat0.b = resources0.getResourceName(v);
            }
            catch(Resources.NotFoundException unused_ex) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        }
        iconCompat0.j = s;
        return iconCompat0;
    }

    public final int e() {
        int v = this.a;
        if(v == -1) {
            Object object0 = this.b;
            if(Build.VERSION.SDK_INT >= 28) {
                return a.g(object0);
            }
            try {
                return (int)(((Integer)object0.getClass().getMethod("getResId", null).invoke(object0, null)));
            }
            catch(IllegalAccessException illegalAccessException0) {
                Log.e("IconCompat", "Unable to get icon resource", illegalAccessException0);
                return 0;
            }
            catch(InvocationTargetException invocationTargetException0) {
                Log.e("IconCompat", "Unable to get icon resource", invocationTargetException0);
                return 0;
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                Log.e("IconCompat", "Unable to get icon resource", noSuchMethodException0);
                return 0;
            }
        }
        if(v != 2) {
            throw new IllegalStateException("called getResId() on " + this);
        }
        return this.e;
    }

    public final String f() {
        int v = this.a;
        if(v == -1) {
            Object object0 = this.b;
            if(Build.VERSION.SDK_INT >= 28) {
                return a.h(object0);
            }
            try {
                return (String)object0.getClass().getMethod("getResPackage", null).invoke(object0, null);
            }
            catch(IllegalAccessException illegalAccessException0) {
                Log.e("IconCompat", "Unable to get icon package", illegalAccessException0);
                return null;
            }
            catch(InvocationTargetException invocationTargetException0) {
                Log.e("IconCompat", "Unable to get icon package", invocationTargetException0);
                return null;
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                Log.e("IconCompat", "Unable to get icon package", noSuchMethodException0);
                return null;
            }
        }
        if(v != 2) {
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        return this.j == null || TextUtils.isEmpty(this.j) ? ((String)this.b).split(":", -1)[0] : this.j;
    }

    public final int g() {
        int v = this.a;
        if(v == -1) {
            Object object0 = this.b;
            if(Build.VERSION.SDK_INT >= 28) {
                return a.n(object0);
            }
            try {
                return (int)(((Integer)object0.getClass().getMethod("getType", null).invoke(object0, null)));
            }
            catch(IllegalAccessException illegalAccessException0) {
                Log.e("IconCompat", "Unable to get icon type " + object0, illegalAccessException0);
                return -1;
            }
            catch(InvocationTargetException invocationTargetException0) {
                Log.e("IconCompat", "Unable to get icon type " + object0, invocationTargetException0);
                return -1;
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                Log.e("IconCompat", "Unable to get icon type " + object0, noSuchMethodException0);
                return -1;
            }
        }
        return v;
    }

    public final Uri h() {
        int v = this.a;
        if(v == -1) {
            Object object0 = this.b;
            if(Build.VERSION.SDK_INT >= 28) {
                return a.o(object0);
            }
            try {
                return (Uri)object0.getClass().getMethod("getUri", null).invoke(object0, null);
            }
            catch(IllegalAccessException illegalAccessException0) {
                Log.e("IconCompat", "Unable to get icon uri", illegalAccessException0);
                return null;
            }
            catch(InvocationTargetException invocationTargetException0) {
                Log.e("IconCompat", "Unable to get icon uri", invocationTargetException0);
                return null;
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                Log.e("IconCompat", "Unable to get icon uri", noSuchMethodException0);
                return null;
            }
        }
        if(v != 4 && v != 6) {
            throw new IllegalStateException("called getUri() on " + this);
        }
        return Uri.parse(((String)this.b));
    }

    public final InputStream i(Context context0) {
        Uri uri0 = this.h();
        String s = uri0.getScheme();
        if(!"content".equals(s) && !"file".equals(s)) {
            try {
                return new FileInputStream(new File(((String)this.b)));
            }
            catch(FileNotFoundException fileNotFoundException0) {
                Log.w("IconCompat", "Unable to load image from path: " + uri0, fileNotFoundException0);
                return null;
            }
        }
        try {
            return context0.getContentResolver().openInputStream(uri0);
        }
        catch(Exception exception0) {
            Log.w("IconCompat", "Unable to load image from URI: " + uri0, exception0);
            return null;
        }
    }

    public final Bundle j() {
        Bundle bundle0 = new Bundle();
        switch(this.a) {
            case -1: {
                bundle0.putParcelable("obj", ((Parcelable)this.b));
                break;
            }
            case 3: {
                bundle0.putByteArray("obj", ((byte[])this.b));
                break;
            }
            case 1: 
            case 5: {
                bundle0.putParcelable("obj", ((Bitmap)this.b));
                break;
            }
            case 2: 
            case 4: 
            case 6: {
                bundle0.putString("obj", ((String)this.b));
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid icon");
            }
        }
        bundle0.putInt("type", this.a);
        bundle0.putInt("int1", this.e);
        bundle0.putInt("int2", this.f);
        bundle0.putString("string1", this.j);
        ColorStateList colorStateList0 = this.g;
        if(colorStateList0 != null) {
            bundle0.putParcelable("tint_list", colorStateList0);
        }
        PorterDuff.Mode porterDuff$Mode0 = this.h;
        if(porterDuff$Mode0 != IconCompat.k) {
            bundle0.putString("tint_mode", porterDuff$Mode0.name());
        }
        return bundle0;
    }

    public final Icon k(Context context0) {
        Icon icon0;
        int v = Build.VERSION.SDK_INT;
        switch(this.a) {
            case -1: {
                return (Icon)this.b;
            }
            case 1: {
                icon0 = Icon.createWithBitmap(((Bitmap)this.b));
                goto label_21;
            }
            case 2: {
                icon0 = Icon.createWithResource(this.f(), this.e);
                goto label_21;
            }
            case 3: {
                icon0 = Icon.createWithData(((byte[])this.b), this.e, this.f);
                goto label_21;
            }
            case 4: {
                icon0 = Icon.createWithContentUri(((String)this.b));
                goto label_21;
            }
            case 5: {
                icon0 = Icon.createWithAdaptiveBitmap(((Bitmap)this.b));
                goto label_21;
            }
            case 6: {
                if(v >= 30) {
                    icon0 = b.b(this.h());
                }
                else {
                    if(context0 == null) {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + this.h());
                    }
                    InputStream inputStream0 = this.i(context0);
                    if(inputStream0 == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + this.h());
                    }
                    icon0 = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(inputStream0));
                }
            label_21:
                ColorStateList colorStateList0 = this.g;
                if(colorStateList0 != null) {
                    icon0.setTintList(colorStateList0);
                }
                PorterDuff.Mode porterDuff$Mode0 = this.h;
                if(porterDuff$Mode0 != IconCompat.k) {
                    icon0.setTintMode(porterDuff$Mode0);
                }
                return icon0;
            }
            default: {
                throw new IllegalArgumentException("Unknown type");
            }
        }
    }

    @Override
    public final String toString() {
        String s;
        if(this.a == -1) {
            return String.valueOf(this.b);
        }
        StringBuilder stringBuilder0 = new StringBuilder("Icon(typ=");
        switch(this.a) {
            case 1: {
                s = "BITMAP";
                break;
            }
            case 2: {
                s = "RESOURCE";
                break;
            }
            case 3: {
                s = "DATA";
                break;
            }
            case 4: {
                s = "URI";
                break;
            }
            case 5: {
                s = "BITMAP_MASKABLE";
                break;
            }
            case 6: {
                s = "URI_MASKABLE";
                break;
            }
            default: {
                s = "UNKNOWN";
            }
        }
        stringBuilder0.append(s);
        switch(this.a) {
            case 2: {
                stringBuilder0.append(" pkg=");
                stringBuilder0.append(this.j);
                stringBuilder0.append(" id=");
                stringBuilder0.append(String.format("0x%08x", this.e()));
                break;
            }
            case 3: {
                stringBuilder0.append(" len=");
                stringBuilder0.append(this.e);
                if(this.f != 0) {
                    stringBuilder0.append(" off=");
                    stringBuilder0.append(this.f);
                }
                break;
            }
            case 1: 
            case 5: {
                stringBuilder0.append(" size=");
                stringBuilder0.append(((Bitmap)this.b).getWidth());
                stringBuilder0.append("x");
                stringBuilder0.append(((Bitmap)this.b).getHeight());
                break;
            }
            case 4: 
            case 6: {
                stringBuilder0.append(" uri=");
                stringBuilder0.append(this.b);
            }
        }
        if(this.g != null) {
            stringBuilder0.append(" tint=");
            stringBuilder0.append(this.g);
        }
        if(this.h != IconCompat.k) {
            stringBuilder0.append(" mode=");
            stringBuilder0.append(this.h);
        }
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

