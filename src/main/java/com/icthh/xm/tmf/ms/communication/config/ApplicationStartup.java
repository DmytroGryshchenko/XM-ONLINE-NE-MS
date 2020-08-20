package com.icthh.xm.tmf.ms.communication.config;

import com.icthh.xm.commons.logging.util.MdcUtils;
import com.icthh.xm.commons.permission.inspector.PrivilegeInspector;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@SuppressWarnings("unused")
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    private ApplicationProperties applicationProperties;
    private PrivilegeInspector privilegeInspector;

    public ApplicationStartup(ApplicationProperties applicationProperties, PrivilegeInspector privilegeInspector) {
        this.applicationProperties = applicationProperties;
        this.privilegeInspector = privilegeInspector;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (true) {
            privilegeInspector.readPrivileges(MdcUtils.getRid());
        } else {
//            log.warn("WARNING! Privileges inspection is disabled by "
//                + "configuration parameter 'application.kafka-enabled'");
        }
    }
}
