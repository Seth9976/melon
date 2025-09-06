package com.iloen.melon.sns.model;

import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.target.SnsTarget;

public interface Sharable {
    void addExtraReport();

    String getContentId();

    ContsTypeCode getContsTypeCode();

    String getDisplayImageUrl(SnsTarget arg1);

    String getDisplayMessage(SnsTarget arg1);

    String[] getDisplayMultiLineTitle(SnsTarget arg1);

    String getDisplayTitle(SnsTarget arg1);

    String getOutPostingLogParam(SnsTarget arg1);

    String getPageTypeCode();

    String getShareGatePageUrl(SnsTarget arg1, boolean arg2);

    String getShareImageUrl(SnsTarget arg1);

    String getShareTitle(SnsTarget arg1);

    boolean isShowFacebook();

    boolean isShowInstagram();

    boolean isShowKakaoTalk();

    boolean isShowMore();

    boolean isShowMusicMessage();

    boolean isShowTwitter();

    boolean isShowUrlCopy();
}

