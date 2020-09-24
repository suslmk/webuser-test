package org.paasta.container.platform.web.user.common.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * ListMeta Model 클래스
 *
 * @author jjy
 * @version 1.0
 * @since 2020.08.26
 */
@Data
public class CommonMetaData {
    private Map<String, String> labels;
    private String name;
    private String namespace;
    private Map<String, String> annotations;
    private String clusterName;
    private String creationTimestamp;
    private long deletionGracePeriodSeconds;
    private String deletionTimestamp;
    private List<String> finalizers;
    private String generateName;
    private long generation;
    private String uid;
    private String resourceVersion;
    private String selfLink;
    private List<CommonOwnerReferences> ownerReferences;

    @Accessors(prefix = "_")
    @SerializedName("continue")
    private String _continue;
}
