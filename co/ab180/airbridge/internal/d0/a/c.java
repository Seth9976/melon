package co.ab180.airbridge.internal.d0.a;

public class c extends co.ab180.airbridge.internal.d0.b.b.c {
    private static final String c = "com.android.billingclient.api.BillingResult";
    private static final String d = "getResponseCode";
    private static final String e = "getDebugMessage";

    public c(Object object0) {
        super("com.android.billingclient.api.BillingResult", object0);
    }

    public String c() {
        return (String)this.a("getDebugMessage");
    }

    public int d() {
        return (int)(((Integer)this.a("getResponseCode")));
    }
}

