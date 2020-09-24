<%--
  Footer

  @author kjhoon
  @version 1.0
  @since 2020.08.21
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="footer">Copyright © 2020 PaaS-TA. All rights reserved</div>

<script type="text/javascript">
    // SET EVENT FOR ESCAPE KEY
    $(document).keyup(function(e) {
        if (e.keyCode === 27) {
            var tableSearchOn = $('.table-search-on');
            tableSearchOn.siblings('.table-search').css('display', 'none');
            tableSearchOn.removeClass('on');
            tableSearchOn.find('i').removeClass('fa-times').addClass('fa-search');
        }
    });


    // ON LOAD
    $(document.body).ready(function () {
        // SET MENU CURSOR
        procSetMenuCursor();

        // REMOVE UNNECESSARY EVENTS
        $(".sortable_wrap,.sortable_line > li").unbind();
    });

</script>
