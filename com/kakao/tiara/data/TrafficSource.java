package com.kakao.tiara.data;

public class TrafficSource {
    public static class Builder {
        TrafficSource trafficSource;

        public Builder() {
            this.trafficSource = new TrafficSource();
        }

        public TrafficSource build() {
            return this.trafficSource;
        }

        public Builder channel(String s) {
            this.trafficSource.channel = s;
            return this;
        }

        public Builder messageId(String s) {
            this.trafficSource.messageId = s;
            return this;
        }

        public Builder object(String s) {
            this.trafficSource.object = s;
            return this;
        }

        public Builder source(String s) {
            this.trafficSource.source = s;
            return this;
        }
    }

    String channel;
    String messageId;
    String object;
    String source;

}

