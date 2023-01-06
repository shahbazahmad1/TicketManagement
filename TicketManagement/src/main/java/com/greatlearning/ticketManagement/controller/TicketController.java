package com.greatlearning.ticketManagement.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ticketManagement.entity.Ticket;
import com.greatlearning.ticketManagement.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	private TicketService ticketService;

	public TicketController(TicketService theTicketService) {
		ticketService = theTicketService;
	}

	@GetMapping("/list")
	public String listBooks(ModelMap theModel) {
		List<Ticket> theTicket = ticketService.findAll();
		theModel.addAttribute("ticket", theTicket);

		return "ticket/list-ticket";
	}

	@GetMapping("/addTicket")
	public String showFormForAdd(Model theModel) {
		Ticket theTicket = new Ticket();
		theModel.addAttribute("ticket", theTicket);
		return "ticket/add-ticket";
	}

	@PostMapping("/editTicket")
	public String showFormForUpdate(@RequestParam("ticketId") int theId, Model theModel) {
		Ticket theTicket = ticketService.findById(theId);
		theModel.addAttribute("ticket", theTicket);
		return "ticket/ticket-form";
	}

	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket theTicket) {
		ticketService.save(theTicket);
		return "redirect:/tickets/list";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("ticketId") int theId) {
		ticketService.deleteById(theId);
		return "redirect:/tickets/list";
	}

	@GetMapping("/viewTicket")
	public String viewTicket(@ModelAttribute("ticket") Ticket ticket) {
		return "ticket/view-ticket";
	}

	@GetMapping("/search")
	public String searchTicket(@RequestParam("ticket") String keyword, Model model) {
		if (keyword != null) {
			model.addAttribute("ticket", ticketService.findByKeyword(keyword));

		} else {
			return "ticket/list-ticket";
		}
		return "ticket/list-ticket";
	}
}
