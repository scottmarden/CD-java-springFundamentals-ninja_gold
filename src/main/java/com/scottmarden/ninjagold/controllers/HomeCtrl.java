package com.scottmarden.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeCtrl {
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		return "index.jsp";
	}
	
	@RequestMapping(path="find_gold", method=RequestMethod.POST)
	public String index(HttpSession session, @RequestParam(value="location", required=false) String location) {
		Random rand = new Random();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d yyyy HH:mm a");
		Date now = new Date();
		String nowStr =sdf.format(now);
		if(session.getAttribute("activities") == null) {
			ArrayList<String> activities = new ArrayList<String>();
			session.setAttribute("activities", activities);
		}
		System.out.println("location: " + location);
		
		if(location.equals("farm")) {
			int foundGold = rand.nextInt(10) + 11; //Generate integer between 10 and 20
			int gold = (int) session.getAttribute("gold");
			session.setAttribute("gold", (gold += foundGold));
			
			String action = "Visited the " + location + " and earned " + foundGold + " gold!" + " (" + nowStr + ")";
			@SuppressWarnings("unchecked")
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(0, action);
			session.setAttribute("activities", activities);
		}
		else if(location.equals("cave")) {
			int foundGold = rand.nextInt(5) + 6; //Generate integer between 5 and 10
			int gold = (int) session.getAttribute("gold");
			session.setAttribute("gold", (gold += foundGold));
			
			String action = "Visited the " + location + " and earned " + foundGold + " gold!" + " (" + nowStr + ")";
			@SuppressWarnings("unchecked")
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(0, action);
			session.setAttribute("activities", activities);
		}
		else if(location.equals("house")) {
			int foundGold = rand.nextInt(4) + 2; //Generates integer between 2 and 5
			int gold = (int) session.getAttribute("gold");
			session.setAttribute("gold", (gold += foundGold));
			
			String action = "Visited the " + location + " and earned " + foundGold + " gold!" + " (" + nowStr + ")";
			@SuppressWarnings("unchecked")
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			activities.add(0, action);
			session.setAttribute("activities", activities);
		}
		else if(location.equals("casino")) {
			int foundGold = rand.nextInt(101) -50; //Generates integer between -50 and 50
			int gold = (int) session.getAttribute("gold");
			session.setAttribute("gold", (gold += foundGold));
			
			@SuppressWarnings("unchecked")
			ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
			if(foundGold >= 0) {
				String action = "Visited the " + location + " and earned " + foundGold + " gold!" + " (" + nowStr + ")";
				activities.add(0, action);
				session.setAttribute("activities", activities);
			}else {
				String action = "Visited the " + location + " and lost " + foundGold + " gold....ouch!" + " (" + nowStr + ")";
				activities.add(0, action);
				session.setAttribute("activities", activities);
			}
			
			
		}
		return "redirect:/";
	}
	
	
}


