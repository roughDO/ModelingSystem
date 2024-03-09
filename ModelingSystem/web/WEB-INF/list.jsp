<%--
  Created by IntelliJ IDEA.
  User: roughDO
  Date: 2023/11/28
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<meta http-equiv="refresh" content="10;url=showList.action">--%>
<%--<script src="js/jquery.js"></script>--%>
<!DOCTYPE html>
<html>
<head>
    <title>title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<link rel="stylesheet" href="css/style.css"/>--%>
    <%--<style type="text/css"> @import url('<c:url value="../WEB-INF/css/style.css"/>'); </style>--%>
</head>
<%--<style type="text/css">@import "../static/css/style.css";</style>--%>
<body>
<div class="header">
    <form action="showList.action" method="post">
        <div>
            <%--<input type="text" id="numsInput" name="nums"/>--%>
             输入列：<input type="text" id="numsInput" name="nums" value="<%= session.getAttribute("userInput") %>"/>
             <input type="hidden" id="hiddenNums" name="hiddenNums" value="<%= session.getAttribute("userInput") %>"/>
             起始时间：<input type="datetime-local" id="start-time" name="start-time" />
             截至时间：<input type="datetime-local" id="end-time" name="end-time" />
                <input type="submit" class="button" value="Submit &raquo;" />
        </div>
    </form>
</div>
<div class="content">
    <table class="table">
        <tr class="table_header">
            <td>
                时间
            </td>
            <c:forEach var="column" varStatus="idx" items="${columns}">
                <c:forEach items="${numArr}" var="num">
                    <c:choose>
                        <c:when test="${num == idx.count}">
                            <td>${column}</td>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </c:forEach>
        </tr>
        <c:forEach varStatus="s" var="data" items="${dataList}">
            <tr class="table_line">
                <td>
                    ${data.now}
                </td>

                <c:forEach varStatus="ss" var="column" items="${data.strings}">
                    <c:forEach items="${numArr}" var="num">
                        <c:choose>
                            <c:when test="${num == ss.count}">
                                <c:forEach varStatus="sss" var="warn" items="${data.warningList}">
                                    <c:choose>
                                        <c:when test="${num == sss.count}">
                                            <td class="data_${warn}">${column}</td>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </c:forEach>
            </tr>
        </c:forEach>

    </table>
</div>
<div class="footer">

</div>
</body>
</html>
<%--存在静态资源无法正常读取的bug，先暂时用html标签写--%>
<style>
    .header{
        margin: auto;
        width: 960px;
        border: 1px solid black;
    }
    .content{
        margin: auto;
        width: 960px;
        height: 540px;
        border: 1px solid black;
        overflow-x: auto; /* 横向溢出时显示滚动条 */
        overflow-y: auto;
        white-space: nowrap; /* 表格内容不换行 */
    }
    .table{
        width: 100%;
        table-layout: fixed; /* 固定表格布局，平均分配列宽 */
    }
    .table_header>td{
        width: 160px;
        border: 1px solid black;
        margin: 0px;
        padding: 0px;
    }
    .table_line>td{
        width: 160px;
        border: 1px solid black;
        margin: 0px;
        padding: 0px;
    }
    .footer{
        margin: auto;
        width: 960px;
        border: 1px solid black;
    }
    .data_save{
        color: black;
    }
    .data_warn{
        color: red;
    }
</style>
<%--<script>--%>
    <%--// 5秒后刷新页面--%>
    <%--setTimeout(function() {--%>
        <%--location.reload();--%>
    <%--}, 5000);--%>
<%--</script>--%>
<%--<script>--%>
    <%--setInterval(function() {--%>
        <%--$.ajax({--%>
            <%--url: 'showList.action',--%>
            <%--method: 'GET',--%>
            <%--success: function(data) {--%>
                <%--// 请求成功，更新页面数据--%>
                <%--updatePageData(data.dataList);--%>
            <%--},--%>
            <%--error: function() {--%>
                <%--console.log('请求失败');--%>
            <%--}--%>
        <%--});--%>
    <%--}, 5000);--%>

    <%--function updatePageData(dataList) {--%>
        <%--// 更新页面上的数据展示逻辑，可以使用 jQuery 或者其他前端框架提供的数据绑定功能--%>
        <%--// 例如，更新表格内容、列表项等--%>
    <%--}--%>
<%--</script>--%>
