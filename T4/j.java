package T4;

import x1.a;

public final class j extends b {
    public final int e;

    public j(String s, String s1, int v) {
        this.e = v;
        super(s, s1, 2);
    }

    @Override  // T4.c
    public final boolean b() {
        if(this.e != 0) {
            return a.G("MULTI_PROFILE") ? super.b() : false;
        }
        if(super.b() && a.G("MULTI_PROCESS")) {
            if(!k.d.b()) {
                throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
            }
            return m.a.getStatics().isMultiProcessEnabled();
        }
        return false;
    }
}

