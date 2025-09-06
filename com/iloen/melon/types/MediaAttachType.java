package com.iloen.melon.types;

import U4.x;
import java.io.Serializable;

public class MediaAttachType implements Serializable {
    public final int a;
    public final String b;
    public static final MediaAttachType c = null;
    public static final MediaAttachType d = null;
    public static final MediaAttachType e = null;
    public static final MediaAttachType f = null;
    public static final MediaAttachType g = null;
    public static final MediaAttachType h = null;
    public static final MediaAttachType i = null;
    public static final MediaAttachType j = null;
    public static final MediaAttachType k = null;
    public static final MediaAttachType[] l = null;
    private static final long serialVersionUID = 1L;

    static {
        MediaAttachType mediaAttachType0 = new MediaAttachType(0, "");
        MediaAttachType mediaAttachType1 = new MediaAttachType(1, "song");
        MediaAttachType.c = mediaAttachType1;
        MediaAttachType mediaAttachType2 = new MediaAttachType(3, "album");
        MediaAttachType.d = mediaAttachType2;
        MediaAttachType mediaAttachType3 = new MediaAttachType(4, "artist");
        MediaAttachType.e = mediaAttachType3;
        MediaAttachType mediaAttachType4 = new MediaAttachType(5, "photo_small");
        MediaAttachType.f = mediaAttachType4;
        MediaAttachType mediaAttachType5 = new MediaAttachType(6, "photo_large");
        MediaAttachType.g = mediaAttachType5;
        MediaAttachType mediaAttachType6 = new MediaAttachType(7, "video");
        MediaAttachType.h = mediaAttachType6;
        MediaAttachType mediaAttachType7 = new MediaAttachType(8, "link_video");
        MediaAttachType.i = mediaAttachType7;
        MediaAttachType mediaAttachType8 = new MediaAttachType(9, "kakao_emoticon");
        MediaAttachType.j = mediaAttachType8;
        MediaAttachType mediaAttachType9 = new MediaAttachType(10, "link_genrl");
        MediaAttachType.k = mediaAttachType9;
        MediaAttachType.l = new MediaAttachType[]{mediaAttachType0, mediaAttachType1, mediaAttachType2, mediaAttachType3, mediaAttachType4, mediaAttachType5, mediaAttachType6, mediaAttachType7, mediaAttachType8, mediaAttachType9};
    }

    public MediaAttachType(int v, String s) {
        this.a = v;
        this.b = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != null) {
            if(object0 == this) {
                return true;
            }
            if(object0 instanceof MediaAttachType && ((MediaAttachType)object0).a == this.a) {
                String s = ((MediaAttachType)object0).b;
                return s != null && s.equals(this.b);
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = (this.a + 0x20F) * 0x1F;
        return this.b == null ? v : v + this.b.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("{type[");
        stringBuilder0.append(this.a);
        stringBuilder0.append("] name[");
        return x.m(stringBuilder0, this.b, "]}");
    }
}

