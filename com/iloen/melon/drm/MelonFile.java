package com.iloen.melon.drm;

import U4.x;
import android.content.Context;
import android.net.Uri;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import e1.G;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import r2.a;

public class MelonFile implements Serializable {
    public String a;
    public String b;
    public CType c;
    public final int d;
    public final String e;
    public final File f;
    public transient a g;
    public transient Uri h;
    private static final long serialVersionUID = 1L;

    public MelonFile(Context context0, Uri uri0) {
        this.c = CType.SONG;
        this.d = 1;
        this.e = uri0.toString();
        this.h = uri0;
        this.g = a.d(context0, uri0);
    }

    public MelonFile(String s) {
        this.c = CType.SONG;
        this.d = 2;
        this.e = s;
        this.f = new File(s);
    }

    public final String a() {
        String s = this.a;
        if(s != null) {
            if(s.startsWith("mmp")) {
                return "mlr" + this.a.substring(3);
            }
            return this.a.startsWith("lmp") ? "llr" + this.a.substring(3) : "";
        }
        return "";
    }

    public final String b() {
        File file0 = this.f;
        if(file0 != null) {
            return file0.getName();
        }
        return this.g == null ? "" : this.g.e();
    }

    public final String c() {
        File file0 = this.f;
        if(file0 != null) {
            return file0.getPath();
        }
        return this.g == null ? "" : this.g.c.toString();
    }

    public final long d() {
        File file0 = this.f;
        if(file0 != null) {
            return file0.lastModified();
        }
        return this.g == null ? 0L : G.y(this.g.b, this.g.c, "last_modified", 0L);
    }

    public final void e(String s) {
        Z.w("setCid:", s, "MelonFile");
        this.b = s;
    }

    public final void f(String s) {
        Z.w("setLcode:", s, "MelonFile");
        this.a = s;
        if(s != null) {
            if(s.startsWith("mmp")) {
                this.c = CType.SONG;
                return;
            }
            if(s.startsWith("lmp")) {
                this.c = CType.EDU;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream0) {
        objectInputStream0.defaultReadObject();
        if(1 == this.d) {
            this.h = Uri.parse(this.e);
            this.g = a.d(MelonAppBase.instance.getContext(), this.h);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("{name=");
        stringBuilder0.append(this.b());
        stringBuilder0.append(", cid=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", ctype=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", lcode=");
        return x.m(stringBuilder0, this.a, "}");
    }
}

