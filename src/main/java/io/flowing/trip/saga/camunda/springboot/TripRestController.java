package io.flowing.trip.saga.camunda.springboot;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripRestController {
  
  @Autowired
  private TripBookingSaga tripBookingSaga; 
  
  @RequestMapping(path = "/trip", method = PUT)
  public void bookTrip(HttpServletRequest request, HttpServletResponse response) {    
    tripBookingSaga.bookTrip(request.getParameter("tripName"));
    // we do it asynchronously, so send a 202 (see https://github.com/berndruecker/flowing-retail/tree/master/rest/ for more details on this)
    // curl -X PUT "http://localhost:8100/trip?tripName=trip3"
    response.setStatus(HttpServletResponse.SC_ACCEPTED);    
  }

}