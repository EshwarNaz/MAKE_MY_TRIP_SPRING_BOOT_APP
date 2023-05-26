package in.eshwar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.eshwar.request.Passanger;
import in.eshwar.responce.Ticket;
import in.eshwar.service.BookingService;

@Controller
public class BookingController {

	@Autowired
	private BookingService boookingService;

	@GetMapping("/getTicket")
	public String getTicket(@RequestParam Integer ticketNum, Model model) {
		Ticket ticket = boookingService.geTicket(ticketNum);
		model.addAttribute("ticket", ticket);
		return "ticket";
	}

	@GetMapping("/ticket")
	public String loadTicket(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "ticket";
	}

	@GetMapping("/")
	public String loadTicketForm(Model model) {
		model.addAttribute("passanger", new Passanger());
		return "index";

	}

	@PostMapping("/book")
	public String bookTicket(@ModelAttribute("passanger") Passanger passanger, Model model) {
		Ticket ticket = boookingService.bookTicket(passanger);
		model.addAttribute("msg", "Your ticket is booked with ticket number" + ticket.getTicketNumber());
		return "index";
	}
}
