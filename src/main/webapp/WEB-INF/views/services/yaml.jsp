<%--
  Services yaml
  @author kjhoon
  @version 1.0
  @since 2020.08.27
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.paasta.container.platform.web.user.common.Constants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../common/commonYaml.jsp"/>


<script type="text/javascript">

    // GET DETAIL
    var getDetail = function () {
        var resourceName = "<c:out value='${serviceName}' default='' />";

        var reqUrl = "<%= Constants.API_URL %><%= Constants.URI_API_SERVICES_YAML %>"
            .replace("{namespace:.+}", NAME_SPACE)
            .replace("{serviceName:.+}", resourceName);

        procGetCommonDetailYaml(reqUrl, resourceName);
    };


    // ON LOAD
    $(document.body).ready(function () {
        getDetail();
    });

</script>
