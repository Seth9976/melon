package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GlideException extends Exception {
    static final class IndentedAppendable implements Appendable {
        private static final String EMPTY_SEQUENCE = "";
        private static final String INDENT = "  ";
        private final Appendable appendable;
        private boolean printedNewLine;

        public IndentedAppendable(Appendable appendable0) {
            this.printedNewLine = true;
            this.appendable = appendable0;
        }

        @Override
        public Appendable append(char c) {
            boolean z = false;
            if(this.printedNewLine) {
                this.printedNewLine = false;
                this.appendable.append("  ");
            }
            if(c == 10) {
                z = true;
            }
            this.printedNewLine = z;
            this.appendable.append(c);
            return this;
        }

        @Override
        public Appendable append(CharSequence charSequence0) {
            CharSequence charSequence1 = this.safeSequence(charSequence0);
            return this.append(charSequence1, 0, charSequence1.length());
        }

        @Override
        public Appendable append(CharSequence charSequence0, int v, int v1) {
            CharSequence charSequence1 = this.safeSequence(charSequence0);
            boolean z = false;
            if(this.printedNewLine) {
                this.printedNewLine = false;
                this.appendable.append("  ");
            }
            if(charSequence1.length() > 0 && charSequence1.charAt(v1 - 1) == 10) {
                z = true;
            }
            this.printedNewLine = z;
            this.appendable.append(charSequence1, v, v1);
            return this;
        }

        private CharSequence safeSequence(CharSequence charSequence0) {
            return charSequence0 == null ? "" : charSequence0;
        }
    }

    private static final StackTraceElement[] EMPTY_ELEMENTS = null;
    private final List causes;
    private Class dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private Key key;
    private static final long serialVersionUID = 1L;

    static {
        GlideException.EMPTY_ELEMENTS = new StackTraceElement[0];
    }

    public GlideException(String s) {
        this(s, Collections.EMPTY_LIST);
    }

    public GlideException(String s, Throwable throwable0) {
        this(s, Collections.singletonList(throwable0));
    }

    public GlideException(String s, List list0) {
        this.detailMessage = s;
        this.setStackTrace(GlideException.EMPTY_ELEMENTS);
        this.causes = list0;
    }

    private void addRootCauses(Throwable throwable0, List list0) {
        if(throwable0 instanceof GlideException) {
            for(Object object0: ((GlideException)throwable0).getCauses()) {
                this.addRootCauses(((Throwable)object0), list0);
            }
            return;
        }
        list0.add(throwable0);
    }

    private static void appendCauses(List list0, Appendable appendable0) {
        try {
            GlideException.appendCausesWrapped(list0, appendable0);
        }
        catch(IOException iOException0) {
            throw new RuntimeException(iOException0);
        }
    }

    private static void appendCausesWrapped(List list0, Appendable appendable0) {
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            appendable0.append("Cause (").append(String.valueOf(v1 + 1)).append(" of ").append(String.valueOf(v)).append("): ");
            Throwable throwable0 = (Throwable)list0.get(v1);
            if(throwable0 instanceof GlideException) {
                ((GlideException)throwable0).printStackTrace(appendable0);
            }
            else {
                GlideException.appendExceptionMessage(throwable0, appendable0);
            }
        }
    }

    private static void appendExceptionMessage(Throwable throwable0, Appendable appendable0) {
        try {
            appendable0.append(throwable0.getClass().toString()).append(": ").append(throwable0.getMessage()).append('\n');
        }
        catch(IOException unused_ex) {
            throw new RuntimeException(throwable0);
        }
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public List getCauses() {
        return this.causes;
    }

    @Override
    public String getMessage() {
        StringBuilder stringBuilder0 = new StringBuilder(71);
        stringBuilder0.append(this.detailMessage);
        String s = "";
        stringBuilder0.append((this.dataClass == null ? "" : ", " + this.dataClass));
        stringBuilder0.append((this.dataSource == null ? "" : ", " + this.dataSource));
        if(this.key != null) {
            s = ", " + this.key;
        }
        stringBuilder0.append(s);
        List list0 = this.getRootCauses();
        if(list0.isEmpty()) {
            return stringBuilder0.toString();
        }
        if(list0.size() == 1) {
            stringBuilder0.append("\nThere was 1 root cause:");
        }
        else {
            stringBuilder0.append("\nThere were ");
            stringBuilder0.append(list0.size());
            stringBuilder0.append(" root causes:");
        }
        for(Object object0: list0) {
            stringBuilder0.append('\n');
            stringBuilder0.append(((Throwable)object0).getClass().getName());
            stringBuilder0.append('(');
            stringBuilder0.append(((Throwable)object0).getMessage());
            stringBuilder0.append(')');
        }
        stringBuilder0.append("\n call GlideException#logRootCauses(String) for more detail");
        return stringBuilder0.toString();
    }

    public Exception getOrigin() {
        return this.exception;
    }

    public List getRootCauses() {
        List list0 = new ArrayList();
        this.addRootCauses(this, list0);
        return list0;
    }

    public void logRootCauses(String s) {
        List list0 = this.getRootCauses();
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            Log.i(s, "Root cause (" + (v1 + 1) + " of " + v + ")", ((Throwable)list0.get(v1)));
        }
    }

    private void printStackTrace(Appendable appendable0) {
        GlideException.appendExceptionMessage(this, appendable0);
        GlideException.appendCauses(this.getCauses(), new IndentedAppendable(appendable0));
    }

    @Override
    public void printStackTrace() {
        this.printStackTrace(System.err);
    }

    @Override
    public void printStackTrace(PrintStream printStream0) {
        this.printStackTrace(printStream0);
    }

    @Override
    public void printStackTrace(PrintWriter printWriter0) {
        this.printStackTrace(printWriter0);
    }

    public void setLoggingDetails(Key key0, DataSource dataSource0) {
        this.setLoggingDetails(key0, dataSource0, null);
    }

    public void setLoggingDetails(Key key0, DataSource dataSource0, Class class0) {
        this.key = key0;
        this.dataSource = dataSource0;
        this.dataClass = class0;
    }

    public void setOrigin(Exception exception0) {
        this.exception = exception0;
    }
}

