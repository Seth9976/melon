package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class SnsHlyricsUploadRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class INFO implements Serializable {
            @b("ext")
            public String ext;
            @b("filename")
            public String filename;
            @b("orgname")
            public String orgname;
            private static final long serialVersionUID = 0xF784080BEE5557FL;
            @b("size")
            public String size;

        }

        @b("ACCESS_KEY")
        public String accessKey;
        @b("IMGURL")
        public String imgUrl;
        @b("INFO")
        public INFO info;
        private static final long serialVersionUID = 0x1A1C36677EA7D093L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x78AD64C7879F67CCL;

    public SnsHlyricsUploadRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

