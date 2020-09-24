package org.paasta.container.platform.web.user.managements;

import lombok.Data;

import java.util.List;

/**
 * ResourceQuotaList Model 클래스
 *
 * @author jjy
 * @version 1.0
 * @since 2020.09.03
 */
@Data
public class ResourceQuotaList {

  private String resultCode;
  private String resultMessage;
  private List<ResourceQuota> items;

}

