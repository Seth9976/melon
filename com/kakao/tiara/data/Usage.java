package com.kakao.tiara.data;

public class Usage {
    public static class Builder {
        Usage usage;

        public Builder() {
            this.usage = new Usage(null);
        }

        public Usage build() {
            return this.usage;
        }

        public Builder duration(String s) {
            this.usage.duration = s;
            return this;
        }

        public Builder scrollBottom(String s) {
            this.usage.scroll_bottom = s;
            return this;
        }

        public Builder scrollHeight(String s) {
            this.usage.scroll_height = s;
            return this;
        }

        public Builder scrollInnerHeight(String s) {
            this.usage.scroll_inner_height = s;
            return this;
        }

        public Builder scrollPercent(String s) {
            this.usage.scroll_percent = s;
            return this;
        }

        public Builder scrollTop(String s) {
            this.usage.scroll_top = s;
            return this;
        }
    }

    private String duration;
    private String scroll_bottom;
    private String scroll_height;
    private String scroll_inner_height;
    private String scroll_percent;
    private String scroll_top;

    private Usage() {
    }

    public Usage(com.kakao.tiara.data.Usage.1 usage$10) {
    }

    class com.kakao.tiara.data.Usage.1 {
    }

}

