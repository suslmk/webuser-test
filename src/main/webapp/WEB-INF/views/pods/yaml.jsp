<%--
  Pods yaml
  @author kjhoon
  @version 1.0
  @since 2020.09.01
--%>
<%@ page import="org.paasta.container.platform.web.user.common.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/commonYaml.jsp"/>

<script type="text/javascript">
    // GET POD'S YAML
    var getYaml = function() {
        var resourceName = '<c:out value="${podName}" default="" />';

        var reqUrl = '<%= Constants.API_URL %><%= Constants.URI_API_PODS_YAML %>'
            .replace('{namespace:.+}', NAME_SPACE).replace('{podName:.+}', resourceName);

        procGetCommonDetailYaml(reqUrl, resourceName);
    };

    // ON LOAD
    $(document.body).ready(function() {
        getYaml();
    });
</script>
