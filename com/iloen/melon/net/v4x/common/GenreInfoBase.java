package com.iloen.melon.net.v4x.common;

import S7.b;
import java.io.Serializable;

public class GenreInfoBase implements Serializable {
    @b("GENRECODE")
    public String genreCode;
    @b("GENRENAME")
    public String genreName;
    private static final long serialVersionUID = 0x5118874263F48B22L;

    public GenreInfoBase() {
        this.genreCode = "";
        this.genreName = "";
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

