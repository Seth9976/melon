package org.apache.http.config;

import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import org.apache.http.Consts;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class ConnectionConfig implements Cloneable {
    public static class Builder {
        private int bufferSize;
        private Charset charset;
        private int fragmentSizeHint;
        private CodingErrorAction malformedInputAction;
        private MessageConstraints messageConstraints;
        private CodingErrorAction unmappableInputAction;

        public Builder() {
            this.fragmentSizeHint = -1;
        }

        public ConnectionConfig build() {
            Charset charset0 = this.charset != null || this.malformedInputAction == null && this.unmappableInputAction == null ? this.charset : Consts.ASCII;
            int v = this.bufferSize > 0 ? this.bufferSize : 0x2000;
            int v1 = this.fragmentSizeHint;
            return v1 < 0 ? new ConnectionConfig(v, v, charset0, this.malformedInputAction, this.unmappableInputAction, this.messageConstraints) : new ConnectionConfig(v, v1, charset0, this.malformedInputAction, this.unmappableInputAction, this.messageConstraints);
        }

        public Builder setBufferSize(int v) {
            this.bufferSize = v;
            return this;
        }

        public Builder setCharset(Charset charset0) {
            this.charset = charset0;
            return this;
        }

        public Builder setFragmentSizeHint(int v) {
            this.fragmentSizeHint = v;
            return this;
        }

        public Builder setMalformedInputAction(CodingErrorAction codingErrorAction0) {
            this.malformedInputAction = codingErrorAction0;
            if(codingErrorAction0 != null && this.charset == null) {
                this.charset = Consts.ASCII;
            }
            return this;
        }

        public Builder setMessageConstraints(MessageConstraints messageConstraints0) {
            this.messageConstraints = messageConstraints0;
            return this;
        }

        public Builder setUnmappableInputAction(CodingErrorAction codingErrorAction0) {
            this.unmappableInputAction = codingErrorAction0;
            if(codingErrorAction0 != null && this.charset == null) {
                this.charset = Consts.ASCII;
            }
            return this;
        }
    }

    public static final ConnectionConfig DEFAULT;
    private final int bufferSize;
    private final Charset charset;
    private final int fragmentSizeHint;
    private final CodingErrorAction malformedInputAction;
    private final MessageConstraints messageConstraints;
    private final CodingErrorAction unmappableInputAction;

    static {
        ConnectionConfig.DEFAULT = new Builder().build();
    }

    public ConnectionConfig(int v, int v1, Charset charset0, CodingErrorAction codingErrorAction0, CodingErrorAction codingErrorAction1, MessageConstraints messageConstraints0) {
        this.bufferSize = v;
        this.fragmentSizeHint = v1;
        this.charset = charset0;
        this.malformedInputAction = codingErrorAction0;
        this.unmappableInputAction = codingErrorAction1;
        this.messageConstraints = messageConstraints0;
    }

    @Override
    public Object clone() {
        return this.clone();
    }

    public ConnectionConfig clone() {
        return (ConnectionConfig)super.clone();
    }

    public static Builder copy(ConnectionConfig connectionConfig0) {
        Args.notNull(connectionConfig0, "Connection config");
        return new Builder().setCharset(connectionConfig0.getCharset()).setMalformedInputAction(connectionConfig0.getMalformedInputAction()).setUnmappableInputAction(connectionConfig0.getUnmappableInputAction()).setMessageConstraints(connectionConfig0.getMessageConstraints());
    }

    public static Builder custom() {
        return new Builder();
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public int getFragmentSizeHint() {
        return this.fragmentSizeHint;
    }

    public CodingErrorAction getMalformedInputAction() {
        return this.malformedInputAction;
    }

    public MessageConstraints getMessageConstraints() {
        return this.messageConstraints;
    }

    public CodingErrorAction getUnmappableInputAction() {
        return this.unmappableInputAction;
    }

    @Override
    public String toString() {
        return "[bufferSize=" + this.bufferSize + ", fragmentSizeHint=" + this.fragmentSizeHint + ", charset=" + this.charset + ", malformedInputAction=" + this.malformedInputAction + ", unmappableInputAction=" + this.unmappableInputAction + ", messageConstraints=" + this.messageConstraints + "]";
    }
}

