package com.melon.net.res;

import S7.b;
import com.melon.net.res.common.LinkInfoBase;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0004\n\u000B\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000E"}, d2 = {"Lcom/melon/net/res/InfoCommerceAndBtnVer6Res;", "", "<init>", "()V", "response", "Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$Response;", "getResponse", "()Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$Response;", "setResponse", "(Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$Response;)V", "Response", "ProductInfo", "CashInfo", "BUTTON", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class InfoCommerceAndBtnVer6Res {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001A\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER \u0010\u000F\u001A\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000ER \u0010\u0012\u001A\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000E¨\u0006\u0015"}, d2 = {"Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$BUTTON;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "isShow", "", "()Z", "setShow", "(Z)V", "label", "", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "linkTypeToBuyInfo", "getLinkTypeToBuyInfo", "setLinkTypeToBuyInfo", "linkUrlToBuyInfo", "getLinkUrlToBuyInfo", "setLinkUrlToBuyInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class BUTTON extends LinkInfoBase {
        public static final int $stable = 8;
        @b("isShow")
        private boolean isShow;
        @b("label")
        @Nullable
        private String label;
        @b("linkTypeToBuyInfo")
        @Nullable
        private String linkTypeToBuyInfo;
        @b("linkUrlToBuyInfo")
        @Nullable
        private String linkUrlToBuyInfo;

        public BUTTON() {
            this.isShow = true;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final String getLinkTypeToBuyInfo() {
            return this.linkTypeToBuyInfo;
        }

        @Nullable
        public final String getLinkUrlToBuyInfo() {
            return this.linkUrlToBuyInfo;
        }

        public final boolean isShow() {
            return this.isShow;
        }

        public final void setLabel(@Nullable String s) {
            this.label = s;
        }

        public final void setLinkTypeToBuyInfo(@Nullable String s) {
            this.linkTypeToBuyInfo = s;
        }

        public final void setLinkUrlToBuyInfo(@Nullable String s) {
            this.linkUrlToBuyInfo = s;
        }

        public final void setShow(boolean z) {
            this.isShow = z;
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001E\u0010\n\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$CashInfo;", "", "<init>", "()V", "button", "Lcom/melon/net/res/common/LinkInfoBase;", "getButton", "()Lcom/melon/net/res/common/LinkInfoBase;", "setButton", "(Lcom/melon/net/res/common/LinkInfoBase;)V", "cash", "", "getCash", "()I", "setCash", "(I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class CashInfo {
        public static final int $stable = 8;
        @b("BUTTON")
        @Nullable
        private LinkInfoBase button;
        @b("CASH")
        private int cash;

        @Nullable
        public final LinkInfoBase getButton() {
            return this.button;
        }

        public final int getCash() {
            return this.cash;
        }

        public final void setButton(@Nullable LinkInfoBase linkInfoBase0) {
            this.button = linkInfoBase0;
        }

        public final void setCash(int v) {
            this.cash = v;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001E\u0010\u0010\u001A\u00020\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$ProductInfo;", "", "<init>", "()V", "button", "Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$BUTTON;", "getButton", "()Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$BUTTON;", "setButton", "(Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$BUTTON;)V", "productName", "", "getProductName", "()Ljava/lang/String;", "setProductName", "(Ljava/lang/String;)V", "productCount", "", "getProductCount", "()I", "setProductCount", "(I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ProductInfo {
        public static final int $stable = 8;
        @b("BUTTON")
        @Nullable
        private BUTTON button;
        @b("PRODUCTCNT")
        private int productCount;
        @b("PRODUCTNAME")
        @Nullable
        private String productName;

        @Nullable
        public final BUTTON getButton() {
            return this.button;
        }

        public final int getProductCount() {
            return this.productCount;
        }

        @Nullable
        public final String getProductName() {
            return this.productName;
        }

        public final void setButton(@Nullable BUTTON infoCommerceAndBtnVer6Res$BUTTON0) {
            this.button = infoCommerceAndBtnVer6Res$BUTTON0;
        }

        public final void setProductCount(int v) {
            this.productCount = v;
        }

        public final void setProductName(@Nullable String s) {
            this.productName = s;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR \u0010\u0010\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$Response;", "", "<init>", "()V", "productInfo", "Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$ProductInfo;", "getProductInfo", "()Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$ProductInfo;", "setProductInfo", "(Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$ProductInfo;)V", "cashInfo", "Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$CashInfo;", "getCashInfo", "()Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$CashInfo;", "setCashInfo", "(Lcom/melon/net/res/InfoCommerceAndBtnVer6Res$CashInfo;)V", "userGrade", "", "getUserGrade", "()Ljava/lang/String;", "setUserGrade", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response {
        public static final int $stable = 8;
        @b("CASHINFO")
        @Nullable
        private CashInfo cashInfo;
        @b("PRODUCTINFO")
        @Nullable
        private ProductInfo productInfo;
        @b("USERGRADE")
        @Nullable
        private String userGrade;

        @Nullable
        public final CashInfo getCashInfo() {
            return this.cashInfo;
        }

        @Nullable
        public final ProductInfo getProductInfo() {
            return this.productInfo;
        }

        @Nullable
        public final String getUserGrade() {
            return this.userGrade;
        }

        public final void setCashInfo(@Nullable CashInfo infoCommerceAndBtnVer6Res$CashInfo0) {
            this.cashInfo = infoCommerceAndBtnVer6Res$CashInfo0;
        }

        public final void setProductInfo(@Nullable ProductInfo infoCommerceAndBtnVer6Res$ProductInfo0) {
            this.productInfo = infoCommerceAndBtnVer6Res$ProductInfo0;
        }

        public final void setUserGrade(@Nullable String s) {
            this.userGrade = s;
        }
    }

    public static final int $stable = 8;
    @b("response")
    @NotNull
    private Response response;

    public InfoCommerceAndBtnVer6Res() {
        this.response = new Response();
    }

    @NotNull
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@NotNull Response infoCommerceAndBtnVer6Res$Response0) {
        q.g(infoCommerceAndBtnVer6Res$Response0, "<set-?>");
        this.response = infoCommerceAndBtnVer6Res$Response0;
    }
}

