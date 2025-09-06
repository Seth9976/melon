package com.iloen.melon.sns.model;

import A8.M;
import android.os.Parcelable;
import android.text.TextUtils;
import b3.Z;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.request.ShortenUrlReq;
import com.iloen.melon.net.v4x.response.ShortenUrlRes.RESPONSE;
import com.iloen.melon.net.v4x.response.ShortenUrlRes;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.log.LogU;
import java.io.Serializable;

public abstract class SharableBase implements Parcelable, Sharable, Serializable {
    protected static final String BASE_GATE_PAGE_URL = "https://m2.melon.com/pda/msvc/snsGatePage.jsp?";
    protected static final String DEFAULT_POST_EDIT_ARTIST_IMAGE_URL = null;
    protected static final String DEFAULT_POST_EDIT_IMAGE_URL = null;
    protected static final String DEFAULT_POST_EDIT_RADIO_IMAGE_URL = null;
    private static final String DEFAULT_POST_IMAGE_URL = null;
    protected static final String DEFAULT_POST_RADIO_IMAGE_URL = null;
    protected static final String KAKAO_STORY_URL = "https://www.melon.com/restful/cds/facebook/web/facebook_posting/";
    public static final String PARCELABLE_EXTRA_KEY = "parcelable_extra_key";
    protected static final String STREAMING_CARD_URL = "https://m2.melon.com/m6/chart/streaming/card/sns.htm?";
    protected static String TAG = "SharableBase";
    protected static final String TEMPERATRUE_MEMOLIAL_CARD_URL = "https://m2.melon.com/m6/artist/temperature/share.htm?";
    protected static final int TEXT_LIMIT_MAX_130 = 0x7F;
    protected static final int TEXT_LIMIT_MAX_15 = 12;
    protected static final int TEXT_LIMIT_MAX_30 = 27;
    protected static final int TEXT_LIMIT_MAX_50 = 0x2F;
    protected static final int TEXT_LIMIT_MAX_60 = 57;
    protected static final int TEXT_LIMIT_MAX_70 = 67;
    protected static final int TEXT_LIMIT_MAX_90 = 87;
    private static final long serialVersionUID = 1L;

    static {
        SharableBase.DEFAULT_POST_IMAGE_URL = "null/sns_post_default_500.jpg";
        SharableBase.DEFAULT_POST_RADIO_IMAGE_URL = "null/mobile2/melonRadio_200.jpg";
        SharableBase.DEFAULT_POST_EDIT_IMAGE_URL = M.t + "/sns_edit_default_96.png";
        SharableBase.DEFAULT_POST_EDIT_ARTIST_IMAGE_URL = M.t + "/sns_edit_art_default_96.png";
        SharableBase.DEFAULT_POST_EDIT_RADIO_IMAGE_URL = M.t + "/sns_edit_rdo_default_96.png";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public void addExtraReport() {
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBaseOutPostingLogParam(SnsTarget snsTarget0) {
        return "?page=" + this.getPageTypeCode() + "&responseYn=Y&ref=" + snsTarget0.getId();
    }

    // 去混淆评级： 低(20)
    public String getDefaultPostEditArtistImageUrl() {
        return SharableBase.DEFAULT_POST_EDIT_ARTIST_IMAGE_URL + "?tm=" + "2025090611";
    }

    // 去混淆评级： 低(20)
    public String getDefaultPostEditImageUrl() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public String getDefaultPostEditRadioImageUrl() {
        return SharableBase.DEFAULT_POST_EDIT_RADIO_IMAGE_URL + "?tm=" + "2025090611";
    }

    // 去混淆评级： 低(20)
    public String getDefaultPostImageUrl() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public String getDefaultPostRadioImageUrl() {
        return SharableBase.DEFAULT_POST_RADIO_IMAGE_URL + "?tm=" + "2025090611";
    }

    public String getDefaultShareLinkPageUrl(SnsTarget snsTarget0) {
        String s = snsTarget0.getId();
        StringBuilder stringBuilder0 = new StringBuilder("https://m2.melon.com/pda/msvc/snsGatePage.jsp?type=");
        stringBuilder0.append(this.getPageTypeCode());
        stringBuilder0.append("&sId=");
        stringBuilder0.append(this.getContentId());
        stringBuilder0.append("&ref=");
        stringBuilder0.append(s);
        if(TextUtils.equals("facebook", s)) {
            stringBuilder0.append("&timestamp=");
            stringBuilder0.append(System.currentTimeMillis());
        }
        return stringBuilder0.toString();
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public String getDisplayImageUrl(SnsTarget snsTarget0) {
        return this.getShareImageUrl(snsTarget0);
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public String getDisplayTitle(SnsTarget snsTarget0) {
        return this.getShareTitle(snsTarget0);
    }

    public String getNewsSeq() {
        return "";
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public String getOutPostingLogParam(SnsTarget snsTarget0) {
        return this.getBaseOutPostingLogParam(snsTarget0) + "&sId=" + this.getContentId();
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public String getShareGatePageUrl(SnsTarget snsTarget0, boolean z) {
        LogU.d("SharableBase", "getShareGatePageUrl target : " + snsTarget0 + ", isShortenUrl : " + z);
        String s = this.getDefaultShareLinkPageUrl(snsTarget0);
        Z.w("getShareGatePageUrl shareLinkPageUrl : ", s, "SharableBase");
        return z ? this.getShortenUrl(s) : s;
    }

    public String getShareLinkFacebook() {
        return null;
    }

    public String getShareLinkKakao() {
        return null;
    }

    public String getShareLinkNormal() {
        return null;
    }

    public String getShareLinkTwitter() {
        return null;
    }

    public String getShortenUrl(String s) {
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        try {
            ShortenUrlRes shortenUrlRes0 = (ShortenUrlRes)RequestBuilder.newInstance(new ShortenUrlReq(MelonAppBase.instance.getContext(), s)).tag("SharableBase").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
            if(shortenUrlRes0 != null && shortenUrlRes0.isSuccessful()) {
                RESPONSE shortenUrlRes$RESPONSE0 = shortenUrlRes0.response;
                if(shortenUrlRes$RESPONSE0 != null) {
                    String s1 = shortenUrlRes$RESPONSE0.shortUrl;
                    LogU.d("SharableBase", "originUrl: " + shortenUrlRes$RESPONSE0.originUrl);
                    LogU.d("SharableBase", "shortUrl: " + s1);
                    return s1;
                }
            }
        }
        catch(VolleyError volleyError0) {
            LogU.w("SharableBase", "getShortenUrl() " + volleyError0);
        }
        return "";
    }

    public String getTextLimitForLength(String s, int v) [...] // 潜在的解密器

    public boolean isDisplayTitleWeb() {
        return false;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public boolean isShowFacebook() {
        return true;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public boolean isShowInstagram() {
        return this instanceof SharableAlbum;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public boolean isShowKakaoTalk() {
        return true;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public boolean isShowMore() {
        return true;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public boolean isShowMusicMessage() {
        return true;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public boolean isShowTwitter() {
        return true;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public boolean isShowUrlCopy() {
        return true;
    }

    public boolean isVideoContent() {
        return false;
    }

    public String makeMessage(SnsTarget snsTarget0, String s) {
        LogU.w("SharableBase", "makeMessage() : " + s);
        return s;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

