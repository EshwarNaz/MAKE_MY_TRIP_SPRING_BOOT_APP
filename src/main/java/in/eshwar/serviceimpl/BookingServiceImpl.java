package in.eshwar.serviceimpl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.eshwar.request.Passanger;
import in.eshwar.responce.Ticket;
import in.eshwar.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	private String BOOK_TICKET_URL = "http://localhost:2021/ticket";
	private String GET_TICKET_URL = "http://localhost:2021/get/{ticketNumber}";

	public Ticket bookTicket(Passanger passanger) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> respEntity = rt.postForEntity(BOOK_TICKET_URL, passanger, Ticket.class);
		Ticket ticket = respEntity.getBody();
		return ticket;
	}

	public Ticket geTicket(Integer ticketNumber) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.getForEntity(GET_TICKET_URL, Ticket.class, ticketNumber);
		Ticket ticket = responseEntity.getBody();
		return ticket;
	}
}
