package org.paasta.container.platform.web.user.clusters.nodes;

import org.paasta.container.platform.web.user.common.Constants;
import org.paasta.container.platform.web.user.common.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

/**
 * Nodes Service 클래스
 *
 * @author jjy
 * @version 1.0
 * @since 2020.09.01
 */
@Service
public class NodesService {
    private final RestTemplateService restTemplateService;

    /**
     * Instantiates a new Nodes service.
     *
     * @param restTemplateService the rest template service
     */
    @Autowired
    public NodesService(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }


    /**
     * Nodes 상세 정보를 조회한다.
     *
     * @param nodeName the node name
     * @return the node
     */
    Nodes getNodes(String nodeName) {
        return restTemplateService.send(Constants.TARGET_CP_API,
                Constants.URI_API_NODES_LIST.replace("{nodeName:.+}", nodeName), HttpMethod.GET, null, Nodes.class);
    }

}
