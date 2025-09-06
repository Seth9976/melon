package com.iloen.melon.constants;

import U4.x;

public class DownloadBuyType {
    public final String a;
    public static final DownloadBuyType b;
    public static final DownloadBuyType c;
    public static final DownloadBuyType d;
    public static final DownloadBuyType e;

    static {
        DownloadBuyType.b = new DownloadBuyType("");
        DownloadBuyType.c = new DownloadBuyType("0");
        DownloadBuyType.d = new DownloadBuyType("8");
        DownloadBuyType.e = new DownloadBuyType("100");
    }

    public DownloadBuyType(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof DownloadBuyType)) {
            return false;
        }
        String s = ((DownloadBuyType)object0).a;
        return s != null && s.equals(this.a);
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0x20F : this.a.hashCode() + 0x20F;
    }

    @Override
    public final String toString() {
        return x.m(new StringBuilder("type["), this.a, "]");
    }
}

