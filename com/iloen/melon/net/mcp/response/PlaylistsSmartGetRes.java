package com.iloen.melon.net.mcp.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import java.util.ArrayList;

public class PlaylistsSmartGetRes extends PlaylistsSmartRes {
    public static class Playlist implements Serializable {
        @b("addOption")
        public String addOption;
        @b("allowDuplicate")
        public boolean allowDuplicate;
        @b("deleteExisting")
        public boolean deleteExisting;
        @b("memberKey")
        public String memberKey;
        @b("registeredDate")
        public long registeredDate;
        @b("replaceThreshold")
        public int replaceThreshold;
        @b("seq")
        public int seq;
        private static final long serialVersionUID = 0x38F67DD7FA6D9603L;
        @b("trackList")
        public ArrayList trackList;
        @b("updatedDate")
        public long updatedDate;

        public Playlist() {
            this.memberKey = "";
            this.trackList = null;
            this.addOption = "";
            this.allowDuplicate = false;
            this.deleteExisting = false;
            this.registeredDate = 0L;
            this.updatedDate = 0L;
            this.replaceThreshold = 0;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public Playlist result;
    private static final long serialVersionUID = 0xB4C53E733B990513L;

    public PlaylistsSmartGetRes() {
        this.result = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

