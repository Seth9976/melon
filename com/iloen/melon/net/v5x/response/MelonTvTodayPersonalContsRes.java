package com.iloen.melon.net.v5x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MelonTvTodayPersonalContsRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class PERSONALCONTS implements Serializable {
            @b("MVLIST")
            public ArrayList mvList;
            @b("MYPAGEIMG")
            public String myPageImg;
            private static final long serialVersionUID = 0x60A2F86ABD30448DL;
            @b("TITLE")
            public String title;

            public PERSONALCONTS() {
                this.title = "";
                this.myPageImg = "";
                this.mvList = null;
            }
        }

        @b("PERSONALCONTS")
        public PERSONALCONTS personalConts;
        private static final long serialVersionUID = 6965400979192487053L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3E33F77DB2270533L;

}

