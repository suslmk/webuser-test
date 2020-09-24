package org.paasta.container.platform.web.user.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Property Service 클래스
 *
 * @author jjy
 * @version 1.0
 * @since 2020.08.25
 */
@Service
@Data
public class PropertyService {

    @Value("${cp.url}")
    private String cpUrl;

    @Value("${cp.cluster-name}")
    private String cpClusterName;

    @Value("${cpApi.url}")
    private String cpApiUrl;

    @Value("${commonApi.url}")
    private String commonApiUrl;

    @Value("${roleSet.administratorCode}")
    private String administratorCode;

    @Value("${roleSet.regularUserCode}")
    private String regularUserCode;

    @Value("${roleSet.initUserCode}")
    private String initUserCode;

    @Value("${roleSet.administratorName}")
    private String administratorName;

    @Value("${roleSet.regularUserName}")
    private String regularUserName;

    @Value("${roleSet.initUserName}")
    private String initUserName;

    @Value("${private.registry.imageName}")
    private String privateRegistryImageName;

    @Value("${private.registry.url}")
    private String privateRegistryUrl;
}
