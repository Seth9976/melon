package com.iloen.melon.net.v4x.request;

import android.content.Context;
import java.io.Serializable;

public abstract class SearchPhotoViewBaseReq extends SearchRequestBaseReq {
    public static class Params implements Serializable {
        public int orderBy;
        public String photoId;
        public int photoIndex;
        public String searchKeyword;
        private static final long serialVersionUID = 0x2F9AEC091B45829L;

    }

    public SearchPhotoViewBaseReq(Context context0, int v, Class class0) {
        super(context0, v, class0);
    }
}

