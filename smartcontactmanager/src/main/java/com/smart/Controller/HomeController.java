package com.smart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.UserRepository;
import com.smart.entities.User;
import com.smart.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
//	@Autowired
	//private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
	public String Home(Model model)
	{
		model.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}
	
	@RequestMapping("/about")
	public String About(Model model)
	{
		model.addAttribute("title", "About - Smart Contact Manager");
		return "about";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("title", "Register - Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	//handler for regoster user
	@RequestMapping(value="/do_register",method=RequestMethod.POST)
	public String registerUser(@Valid  @ModelAttribute("user")User user,BindingResult result1, @RequestParam(value="agreement",defaultValue="false")boolean agreement,Model model,
			 HttpSession session)
	{
		try
		{
			if(!agreement)
			{
				System.out.println(" please accept the Terms and Condition");
				throw new Exception(" please accept the Terms and Condition");
			}
			
			if(result1.hasErrors())
			{
				System.out.println("ERROR"+ result1.toString());
				model.addAttribute("user", user);
				return "signup";
			}
			user.setRole("ROLE_USER");
			user.setEnabled(true);	
			user.setImageUrl("default.png");
			//user.setPassword(passwordEncoder.encode(user.getPassword()));
			
			System.out.println("Agreement"+agreement);
			System.out.println("USER"+user);
			User result = this.userRepository.save(user);
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully regesterd","alert-success"));
			return"signup";
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			model.addAttribute("user", user);
		
			session.setAttribute("message", new Message("Something went wrong"+e.getMessage(),"alert-danger"));
			return"signup";
		}
		
	}
	
	//handler for custom login
	@GetMapping("/signin")
	public String customLogin(Model model)
	{
		model.addAttribute("title", "Login page- Smart Contact Manager");
		return "login";
	}
}
