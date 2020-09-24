package org.paasta.container.platform.web.user.common.model;

import lombok.Data;

import java.util.Map;

/**
 * Common Resource Requirement Model 클래스
 *
 * @author jjy
 * @version 1.0
 * @since 2020.08.26
 */
@Data
public class CommonResourceRequirement {
    // TODO :: USE MODEL
    private Map<String, String> limits;
    private Map<String, String> requests;
}
