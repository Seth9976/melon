package com.kakao.tiara.data;

import java.util.Map;

public class ViewImpContent {
    public static class Builder {
        ViewImpContent content;

        public Builder() {
            this.content = new ViewImpContent(null);
        }

        public Builder author(String s) {
            this.content.author = s;
            return this;
        }

        public ViewImpContent build() {
            return this.content;
        }

        public Builder category(String s) {
            this.content.category = s;
            return this;
        }

        public Builder clickUrl(String s) {
            this.content.click_url = s;
            return this;
        }

        public Builder copy(String s) {
            this.content.copy = s;
            return this;
        }

        public Builder id(String s) {
            this.content.id = s;
            return this;
        }

        public Builder image(String s) {
            this.content.image = s;
            return this;
        }

        public Builder impArea(String s) {
            this.content.imp_area = s;
            return this;
        }

        public Builder impAreaOrdNum(String s) {
            this.content.imp_area_ordnum = s;
            return this;
        }

        public Builder impExtraInfo(String s) {
            this.content.imp_extra_info = s;
            return this;
        }

        public Builder impId(String s) {
            this.content.imp_id = s;
            return this;
        }

        public Builder impOrdNum(String s) {
            this.content.imp_ordnum = s;
            return this;
        }

        public Builder impProvider(String s) {
            this.content.imp_provider = s;
            return this;
        }

        public Builder impType(String s) {
            this.content.imp_type = s;
            return this;
        }

        public Builder layer1(String s) {
            this.content.layer1 = s;
            return this;
        }

        public Builder layer2(String s) {
            this.content.layer2 = s;
            return this;
        }

        public Builder layer3(String s) {
            this.content.layer3 = s;
            return this;
        }

        public Builder name(String s) {
            this.content.name = s;
            return this;
        }

        public Builder ordNum(String s) {
            this.content.ordnum = s;
            return this;
        }

        public Builder props(Map map0) {
            this.content.props = map0;
            return this;
        }

        public Builder provider(String s) {
            this.content.provider = s;
            return this;
        }

        public Builder setNum(String s) {
            this.content.setnum = s;
            return this;
        }

        public Builder type(String s) {
            this.content.type = s;
            return this;
        }
    }

    private String author;
    private String category;
    private String click_url;
    private String copy;
    private String id;
    private String image;
    private String imp_area;
    private String imp_area_ordnum;
    private String imp_extra_info;
    private String imp_id;
    private String imp_ordnum;
    private String imp_provider;
    private String imp_type;
    private String layer1;
    private String layer2;
    private String layer3;
    private String name;
    private String ordnum;
    private Map props;
    private String provider;
    private String setnum;
    private String type;

    private ViewImpContent() {
    }

    public ViewImpContent(com.kakao.tiara.data.ViewImpContent.1 viewImpContent$10) {
    }

    class com.kakao.tiara.data.ViewImpContent.1 {
    }

}

