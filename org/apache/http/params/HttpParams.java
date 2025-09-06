package org.apache.http.params;

public interface HttpParams {
    HttpParams copy();

    boolean getBooleanParameter(String arg1, boolean arg2);

    double getDoubleParameter(String arg1, double arg2);

    int getIntParameter(String arg1, int arg2);

    long getLongParameter(String arg1, long arg2);

    Object getParameter(String arg1);

    boolean isParameterFalse(String arg1);

    boolean isParameterTrue(String arg1);

    boolean removeParameter(String arg1);

    HttpParams setBooleanParameter(String arg1, boolean arg2);

    HttpParams setDoubleParameter(String arg1, double arg2);

    HttpParams setIntParameter(String arg1, int arg2);

    HttpParams setLongParameter(String arg1, long arg2);

    HttpParams setParameter(String arg1, Object arg2);
}

