package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.List;

public class TvProgramSimpleListRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        public static class Program implements Serializable {
            @b("ESPDYN")
            public String espdYn;
            @b("HOTYN")
            public String hotYn;
            @b("NEWYN")
            public String newYn;
            @b("PROGNAME")
            public String progName;
            @b("PROGSEQ")
            public String progSeq;
            @b("PROGTHUMBIMAGEURL")
            public String progThumbImgUrl;
            @b("PROGSIMPLDESC")
            public String progsImplDes;

        }

        @b("ENDPROGLIST")
        public List endProgList;
        @b("PROGLIST")
        public List progList;

    }

    public Response response;

}

