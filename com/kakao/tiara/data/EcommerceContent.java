package com.kakao.tiara.data;

import java.util.Map;

public class EcommerceContent {
    public static class Builder {
        EcommerceContent ecommerceContent;

        public Builder() {
            this.ecommerceContent = new EcommerceContent(null);
        }

        public Builder affiliate(String s) {
            this.ecommerceContent.affiliate = s;
            return this;
        }

        public Builder affiliateId(String s) {
            this.ecommerceContent.affiliate_id = s;
            return this;
        }

        public EcommerceContent build() {
            return this.ecommerceContent;
        }

        public Builder category(String s) {
            this.ecommerceContent.category = s;
            return this;
        }

        public Builder categoryId(String s) {
            this.ecommerceContent.category_id = s;
            return this;
        }

        public Builder contentType(String s) {
            this.ecommerceContent.content_type = s;
            return this;
        }

        public Builder coupon(String s) {
            this.ecommerceContent.coupon = s;
            return this;
        }

        public Builder couponId(String s) {
            this.ecommerceContent.coupon_id = s;
            return this;
        }

        public Builder id(String s) {
            this.ecommerceContent.id = s;
            return this;
        }

        public Builder name(String s) {
            this.ecommerceContent.name = s;
            return this;
        }

        public Builder orderNo(String s) {
            this.ecommerceContent.order_no = s;
            return this;
        }

        public Builder paymentId(String s) {
            this.ecommerceContent.payment_id = s;
            return this;
        }

        public Builder pointAmt(String s) {
            this.ecommerceContent.point_amt = s;
            return this;
        }

        public Builder price(String s) {
            this.ecommerceContent.price = s;
            return this;
        }

        public Builder priceAmt(String s) {
            this.ecommerceContent.price_amt = s;
            return this;
        }

        public Builder promotion(String s) {
            this.ecommerceContent.promotion = s;
            return this;
        }

        public Builder promotionId(String s) {
            this.ecommerceContent.promotion_id = s;
            return this;
        }

        public Builder props(Map map0) {
            this.ecommerceContent.props = map0;
            return this;
        }

        public Builder provider(String s) {
            this.ecommerceContent.provider = s;
            return this;
        }

        public Builder providerId(String s) {
            this.ecommerceContent.provider_id = s;
            return this;
        }

        public Builder providerType(String s) {
            this.ecommerceContent.provider_type = s;
            return this;
        }

        public Builder quantity(String s) {
            this.ecommerceContent.quantity = s;
            return this;
        }

        public Builder subcategory(String s) {
            this.ecommerceContent.subcategory = s;
            return this;
        }

        public Builder subcategoryId(String s) {
            this.ecommerceContent.subcategory_id = s;
            return this;
        }

        public Builder type(String s) {
            this.ecommerceContent.type = s;
            return this;
        }
    }

    private String affiliate;
    private String affiliate_id;
    private String category;
    private String category_id;
    private String content_type;
    private String coupon;
    private String coupon_id;
    private String id;
    private String name;
    private String order_no;
    private String payment_id;
    private String point_amt;
    private String price;
    private String price_amt;
    private String promotion;
    private String promotion_id;
    private Map props;
    private String provider;
    private String provider_id;
    private String provider_type;
    private String quantity;
    private String subcategory;
    private String subcategory_id;
    private String type;

    private EcommerceContent() {
    }

    public EcommerceContent(com.kakao.tiara.data.EcommerceContent.1 ecommerceContent$10) {
    }

    class com.kakao.tiara.data.EcommerceContent.1 {
    }

}

