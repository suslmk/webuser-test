package org.paasta.container.platform.web.user.common.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * CommonContainer Model 클래스
 *
 * @author jjy
 * @version 1.0
 * @since 2020.08.25
 */
@Data
public class CommonContainer {
    private String name;
    private String image;
    private List<String> args;
    private List<Map> env;
    private List<CommonPort> ports;
    private CommonResourceRequirement resources;
    private List<String> command;
}
