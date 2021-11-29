package com.tickets;

import java.io.IOException;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;

import com.model.response;
import com.model.ticketModel;

@JsonIgnoreProperties(ignoreUnknown = true)
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
public class tickets {
    Authentication authentication = new Authentication();
    String authStr = authentication.authStr;
    int pageNumber = 1;
    int pageSize = 25;



    @GetMapping("/tickets")
    public List<ticketModel> getAllTickets(@RequestParam int page, @RequestParam int per_page) {
        String json = null;
        HttpHeaders headersResponse = new HttpHeaders();
        ResponseEntity<String> response = null;
        ObjectMapper mapper = new ObjectMapper();
        response user1 = null;

        try {
            // request url
            String url = "https://zendeskcodingchallenge5011.zendesk.com/api/v2/tickets?page="+page+"&per_page="+per_page;
        
            // create auth credentials
            String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
        
            // create headers
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);
        
            // create request
            HttpEntity<String> request = new HttpEntity<>(headers);
        
            // make a request
            response = new RestTemplate().exchange(url, HttpMethod.GET, request, String.class); 
        
            // get JSON response
            json = response.getBody();
        
        }catch(HttpClientErrorException.Unauthorized ex){
            ticketModel ticket = new ticketModel();
            ticket.id = 0;
            ticket.description = "AuthorizationError";
            ticket.status = "401";

            user1 = new response();
            user1.tickets = new LinkedList<>();
            user1.tickets.add(0, ticket);
            
            return user1.tickets;
        }
         catch (Exception ex) {
            ex.printStackTrace();
        }

        
        headersResponse.add("Access-Control-Allow-Origin", "http://localhost:3000");
        headersResponse.add("Access-Control-Allow-Credentials", "true");
        headersResponse.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
        headersResponse.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            user1 = mapper.readValue(json, response.class);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user1.tickets;
        //return (new ResponseEntity<String>(json, HttpStatus.OK));
    }


    
    @GetMapping("/tickets/count")
    public int getTicketsCount() {
        String json = null;
        HttpHeaders headersResponse = new HttpHeaders();
        try {
            // request url
            String url = "https://zendeskcodingchallenge5011.zendesk.com/api/v2/tickets/count";
        
            // create auth credentials
            String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
        
            // create headers
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);
        
            // create request
            HttpEntity<String> request = new HttpEntity<>(headers);
        
            // make a request
            ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, request, String.class);
            
        
            // get JSON response
            json = response.getBody();
        
        } catch(HttpClientErrorException.Unauthorized ex){
            return 0;
        }
        
        catch (Exception ex) {
            
            ex.printStackTrace();
        }
        headersResponse.add("Access-Control-Allow-Origin", "http://localhost:3000");
        headersResponse.add("Access-Control-Allow-Credentials", "true");
        headersResponse.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
        headersResponse.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

        String[] strTemp = json.split(":");
        String[] strValue = strTemp[2].trim().split(",");
        return Integer.parseInt(strValue[0].trim());
        //return (new ResponseEntity<String>(json, HttpStatus.OK));
    }



    @GetMapping("/ticketDetails")
    public ticketModel getTicketDetails(@RequestParam int id) {
        String json = null;
        HttpHeaders headersResponse = new HttpHeaders();
        ResponseEntity<String> response = null;
        ObjectMapper mapper = new ObjectMapper();
        response user1 = null;

        try {
            // request url
            String url = "https://zendeskcodingchallenge5011.zendesk.com/api/v2/tickets/"+id;

            // create auth credentials
            String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
        
            // create headers
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);
        
            // create request
            HttpEntity<String> request = new HttpEntity<>(headers);
        
            // make a request
            response = new RestTemplate().exchange(url, HttpMethod.GET, request, String.class); 
        
            // get JSON response
            json = response.getBody();
        
        } catch(HttpClientErrorException.Unauthorized ex){
            ticketModel ticket = new ticketModel();
            ticket.id = 0;
            ticket.description = "AuthorizationError";
            ticket.status = "401";
            
            return ticket;
        }
        
        catch (Exception ex) {
            ex.printStackTrace();
        }

        
        headersResponse.add("Access-Control-Allow-Origin", "http://localhost:3000");
        headersResponse.add("Access-Control-Allow-Credentials", "true");
        headersResponse.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
        headersResponse.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            user1 = mapper.readValue(json, response.class);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user1.ticket;
    }
}
