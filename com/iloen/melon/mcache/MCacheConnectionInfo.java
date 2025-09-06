package com.iloen.melon.mcache;

import f9.d;

public class MCacheConnectionInfo {
    private String cid;
    private String xmStream;

    public void clear() {
        this.xmStream = null;
        this.cid = null;
    }

    public String getCid() {
        return this.cid;
    }

    public static MCacheConnectionInfo getInstance() {
        return d.a;
    }

    public String getStringInfo() {
        return "cid: " + this.cid + "\nxmStream: " + this.xmStream;
    }

    public String getXmStream() {
        return this.xmStream;
    }

    public void setCid(String s) {
        this.cid = s;
    }

    public void setXmStream(String s) {
        this.xmStream = s;
    }
}

