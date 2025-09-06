package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.SongInfoBase;

public class BroadcastInfoBase extends SongInfoBase {
    @b("BPCHNLID")
    public String bpChnlId;
    @b("BPCHNLNAME")
    public String bpChnlName;
    @b("BPCHNLMEDIATYPE")
    public String bpChnlType;
    @b("BPID")
    public String bpId;
    @b("BPMEDIATYPE")
    public String bpMediaType;
    @b("BPNAME")
    public String bpName;
    @b("BROADCASTDATE")
    public String broadcastDate;

    public BroadcastInfoBase() {
        this.bpId = "";
        this.bpMediaType = "";
        this.bpName = "";
        this.bpChnlId = "";
        this.bpChnlType = "";
        this.bpChnlName = "";
        this.broadcastDate = "";
    }
}

