package edu.mum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Member;
import edu.mum.domain.Trip;
import edu.mum.service.MemberService;
import edu.mum.service.TripService;

@Controller
@RequestMapping("/trips")
public class TripController {

	@Autowired
	TripService tripService;
	
	@Autowired
	MemberService memberService;

	@RequestMapping()
	public String getTrips(Model model) {
		model.addAttribute("trips", tripService.findAll());
		return "trip/trips";
	}

	@RequestMapping("/addTrip")
	public String addTrip(@ModelAttribute("trip") Trip trip, Model model) {
		model.addAttribute("members", memberService.findAll());
		return "trip/addTrip";
	}

	@RequestMapping(value = "/addTrip", method = RequestMethod.POST)
	public String addTrip(@ModelAttribute("trip") @Valid Trip trip, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("members", memberService.findAll());
			return "trip/addTrip";
		}
		tripService.save(trip);
		return "redirect:/trips";
	}

	@RequestMapping("/editTrip/{id}")
	public String editTrip(Model model, @PathVariable("id") Long id) {
		model.addAttribute("trip", tripService.findOne(id));
		model.addAttribute("members", memberService.findAll());
		return "trip/editTrip";
	}

	@RequestMapping(value = "/editTrip", method = RequestMethod.POST)
	public String editTrip(@ModelAttribute("trip") @Valid Trip trip, BindingResult result) {
		if (result.hasErrors()) {
			return "trip/editTrip";
		}
		tripService.update(trip);
		return "redirect:/trips";
	}

	@RequestMapping("/deleteTrip/{id}")
	public String deleteTrip(@PathVariable("id") Long id) {
		tripService.delete(id);
		return "redirect:/trips";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(List.class, "members", new CustomCollectionEditor(List.class) {
			protected Object convertElement(Object element) {
				if (element instanceof Member) {
					System.out.println("Converting from Member to Member: " + element);
					return element;
				}
				if (element instanceof Long) {
					Member member = memberService.findOne((Long)element);
					System.out.println("Looking up member for id " + element + ": " + member);
					return member;
				}
				if (element instanceof String) {
					if (StringUtils.isEmpty(element) || "0".equals(element)) {
						return null;
					}
					Member member = memberService.findOne(Long.parseLong((String)element));
					System.out.println("Looking up member for id " + element + ": " + member);
					return member;
				}
				System.out.println("Don't know what to do with: " + element);
				return null;
			}
		});
	}
}
