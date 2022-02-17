package com.tngtech.flink.connector.email.common;

import java.io.Serializable;
import javax.annotation.Nullable;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.apache.flink.annotation.Internal;

@Internal
@Data
@SuperBuilder(toBuilder = true)
public class ConnectorOptions implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String host;

    @Nullable
    private final Long port;

    @Nullable
    private final String user;

    @Nullable
    private final String password;

    private final Protocol protocol;

    public boolean usesAuthentication() {
        return password != null;
    }
}
