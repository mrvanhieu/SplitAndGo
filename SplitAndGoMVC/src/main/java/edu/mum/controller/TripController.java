package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Trip;
import edu.mum.service.TripService;

@Controller
@RequestMapping("/trips")
public class TripController {

	@Autowired
	TripService tripService;

	@RequestMapping()
	public String getTrips(Model model) {
		model.addAttribute("trips", tripService.findAll());
		return "trip/trips";
	}

	@RequestMapping("/addTrip")
	public String addTrip(@ModelAttribute("trip") Trip trip) {
		return "trip/addTrip";
	}

	@RequestMapping(value = "/addTrip", method = RequestMethod.POST)
	public String addTrip(@ModelAttribute("trip") @Valid Trip trip, BindingResult result) {
		if (result.hasErrors()) {
			return "trip/addTrip";
		}
		tripService.save(trip);
		return "redirect:/trips";
	}

	@RequestMapping("/editTrip/{id}")
	public String editTrip(Model model, @PathVariable("id") Long id) {
		model.addAttribute("trip", tripService.findOne(id));
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

}
