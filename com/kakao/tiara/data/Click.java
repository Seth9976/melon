package com.kakao.tiara.data;

public class Click {
    public static class Builder {
        Click click;

        public Builder() {
            this.click = new Click(null);
        }

        public Click build() {
            return this.click;
        }

        public Builder clickUrl(String s) {
            this.click.click_url = s;
            return this;
        }

        public Builder copy(String s) {
            this.click.copy = s;
            return this;
        }

        public Builder image(String s) {
            this.click.image = s;
            return this;
        }

        public Builder impressionId(String s) {
            this.click.imp_id = s;
            return this;
        }

        public Builder impressionProvider(String s) {
            this.click.imp_provider = s;
            return this;
        }

        public Builder impressionType(String s) {
            this.click.imp_type = s;
            return this;
        }

        public Builder layer1(String s) {
            this.click.layer1 = s;
            return this;
        }

        public Builder layer2(String s) {
            this.click.layer2 = s;
            return this;
        }

        public Builder layer3(String s) {
            this.click.layer3 = s;
            return this;
        }

        public Builder ordNum(String s) {
            this.click.ordnum = s;
            return this;
        }

        public Builder posX(String s) {
            this.click.posx = s;
            return this;
        }

        public Builder posY(String s) {
            this.click.posy = s;
            return this;
        }

        public Builder setNum(String s) {
            this.click.setnum = s;
            return this;
        }
    }

    private String click_url;
    private String copy;
    private String image;
    private String imp_id;
    private String imp_provider;
    private String imp_type;
    private String layer1;
    private String layer2;
    private String layer3;
    private String ordnum;
    private String posx;
    private String posy;
    private String setnum;

    private Click() {
    }

    public Click(com.kakao.tiara.data.Click.1 click$10) {
    }

    class com.kakao.tiara.data.Click.1 {
    }

}

