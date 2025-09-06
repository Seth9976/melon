package zd;

import com.melon.net.res.common.DjPlayListInfoBase;

public abstract class n0 extends m {
    @Override  // zd.m
    public String q() {
        String s = this.y().ownernickname;
        return s == null ? "" : s;
    }

    public abstract DjPlayListInfoBase y();
}

