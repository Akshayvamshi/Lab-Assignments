/**
 * @author ry6d3
 *
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/mtogrservices")
public class CtoFService {
	@GET
	@Produces("application/xml")
	public String convertCtoF() {
 
		int kg = 10;
		double p;

		p=(0.453*kg);




		
		String result = "@Produces(\"application/xml\") Output: \n\nkg to pounds Output: \n\n" + p ;
		return "<htosecservices>" + "<kgs>" + kg + "</kgs>" + "<htosecoutput>" + result +  "</htosecoutput>" + "</htosecservices>";
		}
	
	
 
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String convertCtoFfromInput(@PathParam("c") Double c) {
		Double fahrenheit;
		Double celsius = c;
		fahrenheit = ((celsius * 9) / 5) + 32;
 
		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}
}