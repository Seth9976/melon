package org.apache.http.config;

import U4.x;
import org.apache.http.util.Args;

public class MessageConstraints implements Cloneable {
    public static class Builder {
        private int maxHeaderCount;
        private int maxLineLength;

        public Builder() {
            this.maxLineLength = -1;
            this.maxHeaderCount = -1;
        }

        public MessageConstraints build() {
            return new MessageConstraints(this.maxLineLength, this.maxHeaderCount);
        }

        public Builder setMaxHeaderCount(int v) {
            this.maxHeaderCount = v;
            return this;
        }

        public Builder setMaxLineLength(int v) {
            this.maxLineLength = v;
            return this;
        }
    }

    public static final MessageConstraints DEFAULT;
    private final int maxHeaderCount;
    private final int maxLineLength;

    static {
        MessageConstraints.DEFAULT = new Builder().build();
    }

    public MessageConstraints(int v, int v1) {
        this.maxLineLength = v;
        this.maxHeaderCount = v1;
    }

    @Override
    public Object clone() {
        return this.clone();
    }

    public MessageConstraints clone() {
        return (MessageConstraints)super.clone();
    }

    public static Builder copy(MessageConstraints messageConstraints0) {
        Args.notNull(messageConstraints0, "Message constraints");
        return new Builder().setMaxHeaderCount(messageConstraints0.getMaxHeaderCount()).setMaxLineLength(messageConstraints0.getMaxLineLength());
    }

    public static Builder custom() {
        return new Builder();
    }

    public int getMaxHeaderCount() {
        return this.maxHeaderCount;
    }

    public int getMaxLineLength() {
        return this.maxLineLength;
    }

    public static MessageConstraints lineLen(int v) {
        return new MessageConstraints(Args.notNegative(v, "Max line length"), -1);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[maxLineLength=");
        stringBuilder0.append(this.maxLineLength);
        stringBuilder0.append(", maxHeaderCount=");
        return x.g(this.maxHeaderCount, "]", stringBuilder0);
    }
}

