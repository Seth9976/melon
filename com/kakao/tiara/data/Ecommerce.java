package com.kakao.tiara.data;

public class Ecommerce {
    public static class Builder {
        Ecommerce ecommerce;

        public Builder() {
            this.ecommerce = new Ecommerce(null);
        }

        public Ecommerce build() {
            return this.ecommerce;
        }

        public Builder couponAmt(String s) {
            this.ecommerce.coupon_amt = s;
            return this;
        }

        public Builder currency(String s) {
            this.ecommerce.currency = s;
            return this;
        }

        public Builder feeAmt(String s) {
            this.ecommerce.fee_amt = s;
            return this;
        }

        public Builder orderNo(String s) {
            this.ecommerce.order_no = s;
            return this;
        }

        public Builder payment(String s) {
            this.ecommerce.payment = s;
            return this;
        }

        public Builder paymentId(String s) {
            this.ecommerce.payment_id = s;
            return this;
        }

        public Builder pointAmt(String s) {
            this.ecommerce.point_amt = s;
            return this;
        }

        public Builder priceAmt(String s) {
            this.ecommerce.price_amt = s;
            return this;
        }

        public Builder shipAmt(String s) {
            this.ecommerce.ship_amt = s;
            return this;
        }

        public Builder subscription(boolean z) {
            this.ecommerce.subscribe_yn = z ? "y" : "n";
            return this;
        }

        public Builder totalAmt(String s) {
            this.ecommerce.total_amt = s;
            return this;
        }
    }

    private String coupon_amt;
    private String currency;
    private String fee_amt;
    private String order_no;
    private String payment;
    private String payment_id;
    private String point_amt;
    private String price_amt;
    private String ship_amt;
    private String subscribe_yn;
    private String total_amt;

    private Ecommerce() {
    }

    public Ecommerce(com.kakao.tiara.data.Ecommerce.1 ecommerce$10) {
    }

    class com.kakao.tiara.data.Ecommerce.1 {
    }

}

