package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DcfExtensionExpireDateRes extends ResponseV4Res {
    public static final class Response extends ResponseBase {
        public static class AcceptList {
            @b("LCODE")
            public String lcode;
            @b("MUSICCODE")
            public String musiccode;

            public AcceptList() {
                this.lcode = "";
                this.musiccode = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class HeaderList {
            @b("USAGE")
            public String usage;

            public HeaderList() {
                this.usage = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class RejectList {
            @b("LCODE")
            public String lcode;
            @b("MUSICCODE")
            public String musiccode;
            @b("REJECTCD")
            public String rejectcd;
            @b("REJECTMSG")
            public String rejectmsg;

            public RejectList() {
                this.lcode = "";
                this.musiccode = "";
                this.rejectcd = "";
                this.rejectmsg = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("ACCEPTCOUNT")
        public int acceptCount;
        @b("ACCEPTLIST")
        public ArrayList acceptList;
        @b("EXPIREDATE")
        public String expireDate;
        @b("HEADERLIST")
        public ArrayList headerList;
        @b("REJECTCOUNT")
        public int rejectCount;
        @b("REJECTLIST")
        public ArrayList rejectList;
        @b("TOTALCOUNT")
        public int totalCount;

        public Response() {
            this.expireDate = "";
            this.totalCount = 0;
            this.acceptCount = 0;
            this.rejectCount = 0;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

