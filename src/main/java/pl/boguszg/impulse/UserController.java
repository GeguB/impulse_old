package pl.boguszg.impulse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.boguszg.impulse.model.User;
import pl.boguszg.impulse.services.UserService;

@Controller
public class UserController {

	private UserService userService;
	
	@Autowired
	@Qualifier("userService")
	public void setUserService(UserService us){
		this.userService = us;
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public String addUser(@ModelAttribute("user") User u){
		
		if(u.getId() == 0){
			this.userService.addUser(u);
		}else{
			this.userService.updateUser(u);
		}
		return "redirect:/users";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeUse(@PathVariable("id") int id){
		this.userService.removeUser(id);
		return "redirect:/users";
	}
	
	@RequestMapping("/edit/{id}")
	public String editUser(@PathVariable("id") int id, Model model){
		model.addAttribute("user", this.userService.getUserById(id));
		model.addAttribute("listUsers", this.userService.listUser());
		
		return "user";
	}
	
	
}
