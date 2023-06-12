package com.example.thymeleaf;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("basic")
@Controller
public class BasicController {

	@GetMapping("text-basic")
	public String testBasic(Model model) {
		model.addAttribute("data", "Hello World");
		return "basic/text-basic";

	}

	@GetMapping("text-unescaped")
	public String textUnescaped(Model model) {
		model.addAttribute("data", "Hello <b>World</b>");
		return "basic/text-unescaped";
	}

	@GetMapping("variable")
	public String variable(Model model) {
		User userA = new User("홍길동", 20);
		User userB = new User("유동환", 27);
		model.addAttribute("user1", userA);
		model.addAttribute("user2", userB);

		List<User> list = new ArrayList<>();
		list.add(userA);
		list.add(userB);
		model.addAttribute("users", list);

		Map<String, User> map = new HashMap<>();
		map.put("userA", userA);
		map.put("userB", userB);
		model.addAttribute("userMap", map);

		return "basic/variable";
	}

	@GetMapping("basic-objects")
	public String basicObject(HttpSession session) {
		session.setAttribute("sessionData", "Hello Session");
		return "basic/basic-objects";
	}

	@GetMapping("date")
	public String date(Model model) {
		model.addAttribute("localDateTime", LocalDateTime.now());
		return "basic/date";
	}

	@GetMapping("link")
	public String link(Model model) {
		model.addAttribute("param1", "data1");
		model.addAttribute("param2", "data2");
		return "basic/link";
	}

	@GetMapping("literal")
	public String literal(Model model) {
		model.addAttribute("data", "Spring");
		return "basic/literal";
	}

	@GetMapping("operation")
	public String operation(Model model) {
		return "basic/operation";
	}

	@GetMapping("attribute")
	public String attribute() {
		return "basic/attribute";
	}

	@GetMapping("each")
	public String each(Model model) {
		addUsers(model);
		return "basic/each";
	}

	@GetMapping("condition")
	public String condition(Model model) {
		addUsers(model);
		return "basic/condition";
	}

	@GetMapping("comments")
	public String comments(Model model) {
		model.addAttribute("data", "Hello Spring");
		return "basic/comments";
	}

	@GetMapping("block")
	public String block(Model model) {
		addUsers(model);
		return "basic/block";
	}

	@GetMapping("javascript")
	public String javascript(Model model) {
		model.addAttribute("user", new User("YooDonghwan", 27));
		addUsers(model);
		return "basic/javascript";
	}

	private void addUsers(Model model) {
		List<User> users = new ArrayList<>();
		users.add(new User("Yoo", 27));
		users.add(new User("Kim", 25));
		users.add(new User("Lee", 26));
		model.addAttribute("users", users);
	}

}
