package org.minbox.framework.bulldog.storage;

import org.junit.jupiter.api.Test;
import org.minbox.framework.bulldog.storage.elasticsearch.ElasticSearchLogStorage;
import org.minbox.framework.fulldog.core.pojo.NonRequestLogDetails;
import org.minbox.framework.fulldog.core.pojo.RequestLogDetails;

import java.util.UUID;

/**
 * @author 恒宇少年
 */
public class ElasticSearchLogStorageTest {

    @Test
    public void testRequestLogAdd() {
        ElasticSearchLogStorage storage = new ElasticSearchLogStorage();
        RequestLogDetails details = new RequestLogDetails();
        details.setRequestIp("127.0.0.1")
                .setRequestUri("/user/15")
                .setLogId(UUID.randomUUID().toString())
                .setTraceId(UUID.randomUUID().toString())
                .setServiceId("8e2143be-b665-40e8-be96-01e96f9d3ae7")
                .setStartTime(System.currentTimeMillis())
                .setTimeConsuming(25L);
        String logId = storage.save(details);
        System.out.println(logId);
    }

    @Test
    public void testNonRequestLogAdd() {
        ElasticSearchLogStorage storage = new ElasticSearchLogStorage();
        NonRequestLogDetails details = new NonRequestLogDetails();
        details.setGroup("user")
                .setTag("admin")
                .setLogId(UUID.randomUUID().toString())
                .setStartTime(System.currentTimeMillis());
        storage.save(details);
    }
}
