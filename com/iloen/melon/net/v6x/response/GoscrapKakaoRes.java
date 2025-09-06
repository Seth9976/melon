package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.HttpResponse;
import java.io.Serializable;
import java.util.List;

public class GoscrapKakaoRes extends HttpResponse {
    public static class FAVICON implements Serializable {
        @b("height")
        public String height;
        private static final long serialVersionUID = 0x713A24AB3A61CA66L;
        @b("url")
        public String url;
        @b("width")
        public String width;

        public FAVICON() {
            this.url = "";
            this.width = "";
            this.height = "";
        }
    }

    public static class IMAGE implements Serializable {
        @b("height")
        public String height;
        private static final long serialVersionUID = -7524131552200073014L;
        @b("url")
        public String url;
        @b("width")
        public String width;

        public IMAGE() {
            this.url = "";
            this.width = "";
            this.height = "";
        }
    }

    public static class META implements Serializable {
        @b("cached")
        public boolean cached;
        private static final long serialVersionUID = 0x40FD27B851AED26FL;

    }

    public static class OPENGRAPH implements Serializable {
        @b("og:description")
        public String ogDescription;
        @b("og:image")
        public List ogImage;
        @b("og:site_name")
        public String ogSiteName;
        @b("og:title")
        public String ogTitle;
        @b("og:type")
        public String ogType;
        @b("og:url")
        public String ogUrl;
        private static final long serialVersionUID = 0x34DDD2922F5E0972L;

        public OPENGRAPH() {
            this.ogDescription = "";
            this.ogSiteName = "";
            this.ogTitle = "";
            this.ogType = "";
            this.ogUrl = "";
        }
    }

    @b("code")
    public String code;
    @b("content_type")
    public String contentType;
    @b("description")
    public String description;
    @b("duration")
    public String duration;
    @b("favicon")
    public FAVICON favicon;
    @b("host")
    public String host;
    @b("image")
    public IMAGE image;
    @b("Message")
    public String message;
    @b("meta")
    public META meta;
    @b("opengraph")
    public OPENGRAPH opengraph;
    @b("requested_url")
    public String requestedUrl;
    private static final long serialVersionUID = 0x5809831F54106283L;
    @b("suspected")
    public String suspected;
    @b("title")
    public String title;
    @b("url")
    public String url;

    public GoscrapKakaoRes() {
        this.code = "";
        this.message = "";
        this.contentType = "";
        this.description = "";
        this.duration = "";
        this.host = "";
        this.requestedUrl = "";
        this.suspected = "";
        this.title = "";
        this.url = "";
    }
}

