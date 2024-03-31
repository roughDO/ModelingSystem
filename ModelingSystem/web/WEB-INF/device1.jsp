<%--
  Created by IntelliJ IDEA.
  User: roughDO
  Date: 2024/2/5
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="utf-8">
    <title>device1</title>
    <link rel="stylesheet" href="static/css/device1.css"/>
    <%--script标签有bug--%>
    <script rel="script" src="static/js/device1.js"></script>
    <script rel="script" src="static/js/echarts.min.js"></script>
    <script rel="script" src="static/js/jquery.min.js"></script>
    <script>
        var contextPath = "${pageContext.request.contextPath}";
        console.log(contextPath);
    </script>

    <%--<script>--%>
        <%--var script = document.createElement('script');--%>
        <%--script.src = 'static/js/device1.js';--%>
        <%--document.body.appendChild(script);--%>
    <%--</script>--%>
</head>
<body>
<div class="header">
    <form action="showDevice1.action" method="post">
        <div>
            起始时间：<input type="datetime-local" id="start-time" name="start-time" />
            截至时间：<input type="datetime-local" id="end-time" name="end-time" />
            <input type="submit" class="button" value="Submit &raquo;" />
        </div>
    </form>
</div>
<%--隐藏在页面中心的表格--%>
<div class="container">
    <div class="chart" id="chart"></div>
</div>
    <%--仅显示一次页面在这里写div class=content--%>
<div class="content">
    <c:forEach varStatus="s" var="data" items="${dataList}">
        <%--单独显示每个页面在这里写div class=content--%>

            <c:forEach var="columnName" varStatus="idx" items="${columns}">
            <c:forEach varStatus="ss" var="column" items="${data.strings}">
                <c:choose>
                    <%--<c:when test="${idx.count == ss.count && s.count == 1}">--%>
                    <c:when test="${idx.count == ss.count && s.count == 1}">

                        <c:forEach varStatus="sss" var="warn" items="${data.warningList}">
                            <c:choose>
                                <c:when test="${idx.count - 2 == sss.count}">
                                    <div class="${columnName}" data-now="${data.now}" data-list="${dataStrings}" data-idx="${idx.count}">
                                        <div class="data_${warn}">${column}</div>
                                    </div>
                                </c:when>
                            </c:choose>
                        </c:forEach>

                    </c:when>
                </c:choose>
            </c:forEach>
            </c:forEach>

        <%--单独显示--%>
    </c:forEach>
</div>
    <%--<div class="TISA0901A"><div class="data_safe">111</div></div>--%>
    <%--<div class="TISA0901B"><div class="data_warn">111</div></div>--%>
    <%--<div class="TISA0902A"><div class="data_danger">111</div></div>--%>
<div class="footer">

</div>
</body>
</html>
