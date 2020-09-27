package org.minbox.framework.fulldog.core.pojo.instance;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * The service instance
 *
 * @author 恒宇少年
 */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class ServiceInstance {
    /**
     * Log Service details id
     */
    private String id;
    /**
     * Log Service ID
     * <p>
     * Used to divide the service to which the log belongs
     */
    private String serviceId;
    /**
     * Log Service Ipv4 address
     */
    private String serviceIp;
    /**
     * Log Service hostname
     */
    private String serviceHostname;
    /**
     * Log Service port
     */
    private int servicePort;
    /**
     * The last report time
     */
    private LocalDateTime lastReportTime;
    /**
     * service create time
     */
    private LocalDateTime createTime;

    public static ServiceInstance instance() {
        return new ServiceInstance();
    }
}
