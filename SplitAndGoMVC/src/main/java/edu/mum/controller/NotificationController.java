package edu.mum.controller;

import edu.mum.domain.Notification;
import edu.mum.service.MemberService;
import edu.mum.service.NotificationService;
import edu.mum.service.ReportService;
import edu.mum.service.TripService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes("notifications")
@RequestMapping({"/notifications"})
public class NotificationController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	private NotificationService notificationService;

	@RequestMapping
	public String listReports(@ModelAttribute("notifications") List<Notification> notifications,  Model model) {
		//Get all notification of logged-in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean isAuthenticated = auth.isAuthenticated();
		String userName = auth.getName();

		List<Notification> dbNotifications = notificationService.findAll();
		if(notifications.equals(dbNotifications)){
			System.out.println("Info already sent to User, skip the sending");
			model.addAttribute("notificationResults",null);
		}else{
			notifications = dbNotifications;
			//store the notifications return back to ajax
			model.addAttribute("notificationResults",notifications);
			//store the notifications using for session management
			model.addAttribute("notifications", notifications);
		}

		return "notification/notificationsDetail";
	}

	@ModelAttribute("notifications")
	public List<Notification> initNotification() {
		return new ArrayList<Notification>();
	}
}
