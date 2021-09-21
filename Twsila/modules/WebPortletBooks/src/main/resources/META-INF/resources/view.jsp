<%--
  Created by IntelliJ IDEA.
  User: RPWD4823
  Date: 21/090/2021
  Time: 01:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/init.jsp" %>
<portlet:defineObjects />
<portlet:renderURL var="addAuthorsRenderURL">
	<portlet:param name="mvcPath" value="/add-authors.jsp"/>
</portlet:renderURL>

<aui:row>
    <aui:col width="50">
        <div class="card" style="width: 18rem;">
          <img src="..." class="card-img-top" alt="..." href="<%= addAuthorsRenderURL %>"  />
        </div>
    </aui:col>

    <aui:col width="50">
        <div class="card" style="width: 18rem;">
          <img src="..." class="card-img-top" alt="..." href="<%= addAuthorsRenderURL %>"  />
        </div>
    </aui:col>
</aui:row>




