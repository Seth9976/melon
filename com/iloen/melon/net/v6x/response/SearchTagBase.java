package com.iloen.melon.net.v6x.response;

import S7.b;
import java.io.Serializable;

public class SearchTagBase implements Serializable {
    @b("ARTISTID")
    public String artistId;
    @b("ARTISTIMAGEPATH")
    public String artistImagePath;
    @b("DISPLAYKEYWORD")
    public String disPlayKeyword;
    @b("GENRETYPE")
    public String genreType;
    @b("GENRETYPEGROUPNAME")
    public String genreTypeGroupName;
    @b("IMAGEYN")
    public String imageYn;
    @b("LANDINGURL")
    public String landingUrl;
    @b("PRIORITYYN")
    public String priorityYn;
    @b("PROMOTIONIMAGEPATH")
    public String promotionImagePath;
    @b("PROMOTIONSEQ")
    public String promotionSeq;
    @b("PROMOTIONYN")
    public String promotionYn;
    @b("RANGECODE")
    public String rangeCode;
    private static final long serialVersionUID = 0xB6A390C0D904FB30L;
    @b("TAGSEQ")
    public String tagSeq;
    @b("TAGTYPE")
    public String tagType;

}

