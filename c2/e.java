package c2;

import U4.x;
import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;

public final class e implements d, f {
    public final int a;
    public ClipData b;
    public int c;
    public int d;
    public Uri e;
    public Bundle f;

    public e() {
        this.a = 0;
        super();
    }

    public e(e e0) {
        this.a = 1;
        super();
        ClipData clipData0 = e0.b;
        clipData0.getClass();
        this.b = clipData0;
        int v = e0.c;
        if(v < 0) {
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if(v > 5) {
            throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
        }
        this.c = v;
        int v1 = e0.d;
        if((v1 & 1) != v1) {
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(v1) + ", but only 0x" + "1" + " are allowed");
        }
        this.d = v1;
        this.e = e0.e;
        this.f = e0.f;
    }

    @Override  // c2.d
    public void b(Uri uri0) {
        this.e = uri0;
    }

    @Override  // c2.d
    public g build() {
        return new g(new e(this));
    }

    @Override  // c2.f
    public int getFlags() {
        return this.d;
    }

    @Override  // c2.f
    public int getSource() {
        return this.c;
    }

    @Override  // c2.f
    public ContentInfo h() {
        return null;
    }

    @Override  // c2.f
    public ClipData l() {
        return this.b;
    }

    @Override  // c2.d
    public void setExtras(Bundle bundle0) {
        this.f = bundle0;
    }

    @Override  // c2.d
    public void setFlags(int v) {
        this.d = v;
    }

    @Override
    public String toString() {
        String s;
        if(this.a != 1) {
            return super.toString();
        }
        Uri uri0 = this.e;
        StringBuilder stringBuilder0 = new StringBuilder("ContentInfoCompat{clip=");
        stringBuilder0.append(this.b.getDescription());
        stringBuilder0.append(", source=");
        int v = this.c;
        switch(v) {
            case 0: {
                s = "SOURCE_APP";
                break;
            }
            case 1: {
                s = "SOURCE_CLIPBOARD";
                break;
            }
            case 2: {
                s = "SOURCE_INPUT_METHOD";
                break;
            }
            case 3: {
                s = "SOURCE_DRAG_AND_DROP";
                break;
            }
            case 4: {
                s = "SOURCE_AUTOFILL";
                break;
            }
            case 5: {
                s = "SOURCE_PROCESS_TEXT";
                break;
            }
            default: {
                s = String.valueOf(v);
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append(", flags=");
        stringBuilder0.append(((this.d & 1) == 0 ? String.valueOf(this.d) : "FLAG_CONVERT_TO_PLAIN_TEXT"));
        String s1 = "";
        stringBuilder0.append((uri0 == null ? "" : ", hasLinkUri(" + uri0.toString().length() + ")"));
        if(this.f != null) {
            s1 = ", hasExtras";
        }
        return x.m(stringBuilder0, s1, "}");
    }
}

