package com.cabbiemagnet.webservices;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cabbiemagnet.model.Company;
import com.cabbiemagnet.dao.*;

// POJO, no interface no extends

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /companies

@Path("/companies")
public class CompaniesResource {

	// @Context
	// UriInfo uriInfo;
	// @Context
	// Request request;

//	ApplicationContext context;

	ICompanyDao compDao;
	
	// default constructor that gets the DAO bean
	public CompaniesResource()
	{
		compDao = (ICompanyDao) Common.getContext().getBean("compDao");
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Company> getCompanies() {

		ArrayList<Company> companies = compDao.readAll();	// retrieve companies

		// throw runtime exception with information if no companies were found
		if (companies.size() == 0) {
			throw new RuntimeException("No companies found!");
		}

		return companies;
	}

	@GET
	@Path("{location}")
	@Produces({ MediaType.APPLICATION_JSON })
	public ArrayList<Company> getCompaniesByLocation(
			@PathParam("location") String location) {
		
		ArrayList<Company> companies = compDao.findByLocation(location);	// retrieve companies
		
		// throw runtime exception with information if no companies were found
		if (companies.size() == 0) {
			throw new RuntimeException("No companies found from " + location + "!");
		}

		return companies;
	}
}