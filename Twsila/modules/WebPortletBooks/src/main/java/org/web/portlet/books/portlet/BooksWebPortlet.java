package org.web.portlet.books.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.LogWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import org.books.model.Author;
import org.books.service.AuthorLocalService;
import org.books.service.AuthorLocalServiceUtil;
import org.books.service.impl.AuthorLocalServiceImpl;
import org.web.portlet.books.constants.BooksWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.management.Query;
import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * @author allal
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=BooksWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BooksWebPortletKeys.BOOKSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BooksWebPortlet extends MVCPortlet {

	CounterLocalServiceUtil _counterLocalServiceUtil;

	/**
	 *
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 *
	 * Method Add Auteur
	 */
	@ProcessAction(name = "addAuteur")
	public void addAuteur(ActionRequest actionRequest,
						  ActionResponse actionResponse) throws
			PortalException {

		User currentUser = PortalUtil.getUser(actionRequest);
		long auteurId = _counterLocalServiceUtil.increment(Author.class.getName());
		String nom = ParamUtil.getString(actionRequest,"firstName");
		String prenom = ParamUtil.getString(actionRequest,"lastName");
		String email = ParamUtil.getString(actionRequest,"email");
		String autobiographie = ParamUtil.getString(actionRequest,"autobiographie");
		Date dateNaissance = ParamUtil.getDate(actionRequest,"dateNaissance", DateFormat.getDateInstance());
		boolean status = ParamUtil.getBoolean(actionRequest,"status");
		Author author = AuthorLocalServiceUtil.createAuthor(auteurId);
				author.setAuthorId(auteurId);
				author.setNom(nom);
				author.setPrenom(prenom);
				author.setAutobiographie(autobiographie);
				author.setEmail(email);
				author.setDateNaissance(dateNaissance);
				if(currentUser != null){
					author.setCompanyId(currentUser.getCompanyId());
				}
		AuthorLocalServiceUtil.addAuthor(author);
	}



}