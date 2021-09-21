<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/init.jsp" %>
<portlet:defineObjects />

<liferay-portlet:actionURL var="addAuteurActionURL" windowState="normal" name="addAuteur"/>

<aui:form action="<%=addAuteurActionURL%>" name="auteurForm"  method="POST">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset label="Auteur Form">
			<aui:row>
				<aui:col width="50">
					<aui:input label="First Name" name="firstName" type="text" />
				</aui:col>
				<aui:col width="50">
					<aui:input label="Last Name" name="lastName" type="text" />
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="50">
					<aui:input label="Date" name="dateNaissance" type="date" />
				</aui:col>
				<aui:col width="50">
					<aui:input label="Email" name="email" type="email" />
				</aui:col>
			</aui:row>
		</aui:fieldset>
	</aui:fieldset-group>
		<aui:fieldset label="Miscellaneous">
			<aui:input label="Autobiographie" name="autobiographie" type="textarea" />
			<aui:input label="Receive email updates" name="status" type="checkbox" />
		</aui:fieldset>
	<aui:button-row>
		<aui:button name="submitButton" type="submit" value="Submit" />
	</aui:button-row>
</aui:form>
