package org.paasta.container.platform.web.user.workloads.deployments.support;

import lombok.Data;
import org.paasta.container.platform.web.user.common.model.CommonCondition;

import java.util.List;

/**
 * DeploymentsStatus Model 클래스
 *
 * @author jjy
 * @version 1.0
 * @since 2020.09.07
 */
@Data
public class DeploymentsStatus {
    private int availableReplicas;
    private int collisionCount;
    private List<CommonCondition> conditions;
    private long observedGeneration;
    private int readyReplicas;
    private int replicas;
    private int unavailableReplicas;
    private int updatedReplicas;
}
