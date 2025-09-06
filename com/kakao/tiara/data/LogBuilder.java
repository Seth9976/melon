package com.kakao.tiara.data;

import android.content.Context;
import com.kakao.tiara.TiaraSettings;
import com.kakao.tiara.TiaraTracker;
import h5.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogBuilder {
    private Boolean accountAgreement;
    private String adTrackId;
    private ContentList ecommerceContentList;
    private TiaraLog log;
    private String page;
    private String section;
    private TiaraTracker tracker;
    private TrafficSource trafficSource;
    private ContentList viewImpContentList;

    public LogBuilder(TiaraTracker tiaraTracker0, String s) {
        TiaraLog tiaraLog0 = new TiaraLog();
        this.log = tiaraLog0;
        this.tracker = tiaraTracker0;
        tiaraLog0.action = new Action();
        this.log.action.name = s;
    }

    public LogBuilder actionKind(ActionKind actionKind0) {
        this.log.action.kind = actionKind0.name();
        return this;
    }

    public void actionType(ActionType actionType0) {
        this.log.action.type = actionType0.name();
    }

    public LogBuilder adTrackId(String s) {
        this.adTrackId = s;
        return this;
    }

    public LogBuilder bucket(String s, String s1) {
        TiaraLog tiaraLog0 = this.log;
        Bucket bucket0 = tiaraLog0.bucket;
        if(bucket0 == null) {
            tiaraLog0.bucket = new Bucket(s, s1);
            return this;
        }
        bucket0.setNameAndGroup(s, s1);
        return this;
    }

    private TiaraLog build() {
        TiaraSettings tiaraSettings0 = this.tracker.getSettings();
        Context context0 = this.tracker.getContext();
        this.tracker.startNewSessionIfExpired();
        TiaraLog tiaraLog0 = this.log;
        tiaraLog0.sdk = new Sdk();
        TiaraLog tiaraLog1 = this.log;
        tiaraLog1.common = Common.from(tiaraSettings0, this.page, this.section, this.adTrackId, this.accountAgreement, this.trafficSource);
        TiaraLog tiaraLog2 = this.log;
        tiaraLog2.user = User.from(tiaraSettings0, this.tracker.getSessionId(), this.accountAgreement);
        TiaraLog tiaraLog3 = this.log;
        tiaraLog3.env = Env.from(context0, tiaraSettings0);
        this.log.install = this.tracker.getInstall();
        this.log.user_ex_anonymous = tiaraSettings0.getUserExAnonymous();
        if(this.accountAgreement == null || this.accountAgreement.booleanValue()) {
            this.log.user_ex_account = tiaraSettings0.getUserExAccount();
        }
        ContentList contentList0 = this.ecommerceContentList;
        if(contentList0 != null) {
            this.log.ecommerce_contents = contentList0.getContents();
        }
        ContentList contentList1 = this.viewImpContentList;
        if(contentList1 != null) {
            this.log.viewimp_contents = contentList1.getContents();
        }
        Map map0 = this.mergeMap(this.tracker.getGlobalCustomProps(), this.log.custom_props);
        if(!map0.isEmpty()) {
            this.log.custom_props = map0;
        }
        return this.log;
    }

    public LogBuilder click(Click click0) {
        this.log.click = click0;
        return this;
    }

    public LogBuilder config(Config config0) {
        this.log.config = config0;
        return this;
    }

    public LogBuilder customItems(List list0) {
        this.log.custom_items = list0;
        return this;
    }

    public LogBuilder customObjects(Map map0) {
        this.log.custom_objs = map0;
        return this;
    }

    public LogBuilder customProps(Map map0) {
        this.log.custom_props = map0;
        return this;
    }

    public LogBuilder ecommerce(Ecommerce ecommerce0) {
        this.log.ecommerce = ecommerce0;
        return this;
    }

    public LogBuilder ecommerceContents(ContentList contentList0) {
        this.ecommerceContentList = contentList0;
        return this;
    }

    public LogBuilder eventMeta(Meta meta0) {
        this.log.event_meta = meta0;
        return this;
    }

    public LogBuilder experiment(String s, String s1, IdType idType0) {
        TiaraLog tiaraLog0 = this.log;
        Bucket bucket0 = tiaraLog0.bucket;
        if(bucket0 == null) {
            tiaraLog0.bucket = new Bucket(s, s1, idType0);
            return this;
        }
        bucket0.setExperimentInfo(s, s1, idType0);
        return this;
    }

    public LogBuilder location(Map map0) {
        TiaraLog tiaraLog0 = this.log;
        if(tiaraLog0.location_props == null) {
            tiaraLog0.location_props = new HashMap();
        }
        if(map0 != null) {
            this.log.location_props.putAll(map0);
        }
        return this;
    }

    public LogBuilder location(boolean z, double f, double f1, Map map0) {
        String s;
        this.accountAgreement = Boolean.valueOf(z);
        TiaraLog tiaraLog0 = this.log;
        if(tiaraLog0.location_props == null) {
            tiaraLog0.location_props = new HashMap();
        }
        if(map0 != null) {
            this.log.location_props.putAll(map0);
        }
        try {
            s = "";
            s = b.b(f, f1);
        }
        catch(Exception unused_ex) {
        }
        this.log.location_props.put("geohash6", s);
        if(z) {
            this.log.location_props.put("latitude", String.valueOf(f));
            this.log.location_props.put("longitude", String.valueOf(f1));
        }
        return this;
    }

    private Map mergeMap(Map map0, Map map1) {
        if(map1 != null) {
            map0.putAll(map1);
        }
        return map0;
    }

    public LogBuilder page(String s) {
        this.page = s;
        return this;
    }

    public LogBuilder pageMeta(Meta meta0) {
        this.log.page_meta = meta0;
        return this;
    }

    public LogBuilder search(Search search0) {
        this.log.search = search0;
        return this;
    }

    public LogBuilder section(String s) {
        this.section = s;
        return this;
    }

    public TiaraTracker track() {
        this.tracker.enqueue(this.build());
        return this.tracker;
    }

    public LogBuilder trafficSource(TrafficSource trafficSource0) {
        this.trafficSource = trafficSource0;
        return this;
    }

    public LogBuilder usage(Usage usage0) {
        this.log.usage = usage0;
        return this;
    }

    public LogBuilder viewImpContents(ContentList contentList0) {
        this.viewImpContentList = contentList0;
        return this;
    }
}

