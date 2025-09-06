package com.kakao.tiara.data;

public class Meta {
    public static class Builder {
        Meta meta;

        public Builder() {
            this.meta = new Meta(null);
        }

        public Builder author(String s) {
            this.meta.author = s;
            return this;
        }

        public Builder authorId(String s) {
            this.meta.author_id = s;
            return this;
        }

        public Meta build() {
            return this.meta;
        }

        public Builder category(String s) {
            this.meta.category = s;
            return this;
        }

        public Builder categoryId(String s) {
            this.meta.category_id = s;
            return this;
        }

        public Builder contentType(String s) {
            this.meta.content_type = s;
            return this;
        }

        public Builder ecommerceYn(boolean z) {
            this.meta.ecommerce_yn = z ? "y" : "n";
            return this;
        }

        public Builder id(String s) {
            this.meta.id = s;
            return this;
        }

        public Builder image(String s) {
            this.meta.image = s;
            return this;
        }

        public Builder name(String s) {
            this.meta.name = s;
            return this;
        }

        public Builder plink(String s) {
            this.meta.plink = s;
            return this;
        }

        public Builder provider(String s) {
            this.meta.provider = s;
            return this;
        }

        public Builder providerId(String s) {
            this.meta.provider_id = s;
            return this;
        }

        public Builder providerType(String s) {
            this.meta.provider_type = s;
            return this;
        }

        public Builder series(String s) {
            this.meta.series = s;
            return this;
        }

        public Builder seriesId(String s) {
            this.meta.series_id = s;
            return this;
        }

        public Builder subcategory(String s) {
            this.meta.subcategory = s;
            return this;
        }

        public Builder subcategoryId(String s) {
            this.meta.subcategory_id = s;
            return this;
        }

        public Builder tags(String s) {
            this.meta.tags = s;
            return this;
        }

        public Builder type(String s) {
            this.meta.type = s;
            return this;
        }
    }

    private String author;
    private String author_id;
    private String category;
    private String category_id;
    private String content_type;
    private String ecommerce_yn;
    private String id;
    private String image;
    private String name;
    private String plink;
    private String provider;
    private String provider_id;
    private String provider_type;
    private String series;
    private String series_id;
    private String subcategory;
    private String subcategory_id;
    private String tags;
    private String type;

    private Meta() {
    }

    public Meta(com.kakao.tiara.data.Meta.1 meta$10) {
    }

    class com.kakao.tiara.data.Meta.1 {
    }

}

