package org.paasta.container.platform.web.user.workloads.deployments.support;

import lombok.Data;

/**
 * DeploymentsStrategy Model 클래스
 *
 * @author jjy
 * @version 1.0
 * @since 2020.09.07
 */
@Data
public class DeploymentsStrategy {
    private String type;
    private RollingUpdateDeployments rollingUpdate;
}