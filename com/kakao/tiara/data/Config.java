package com.kakao.tiara.data;

public class Config {
    public static class Builder {
        private final Config config;

        public Builder() {
            this.config = new Config(null);
        }

        public Config build() {
            return this.config;
        }

        public Builder excludeCollection(ExcludeType excludeType0) {
            this.config.exclude_collection = excludeType0.getName();
            return this;
        }
    }

    String exclude_collection;

    private Config() {
    }

    public Config(com.kakao.tiara.data.Config.1 config$10) {
    }

    class com.kakao.tiara.data.Config.1 {
    }

}

