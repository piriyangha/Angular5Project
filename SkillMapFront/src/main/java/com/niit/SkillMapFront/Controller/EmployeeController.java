package com.niit.SkillMapFront.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.SkillMapBackend.model.Employee;
import com.niit.SkillMapBackend.service.EmployeeServiceDao;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeServiceDao employeeService;
	
	@GetMapping("/")
	public String register(Model model) {
		model.addAttribute("employee",new Employee());
		model.addAttribute("employees",employeeService.getAllEmployee());
		model.addAttribute("check",true);
		return "register";
	}
	
	@RequestMapping(value="/saveregister")
	//@RequestMapping(value="/saveregister",params="add")
	public String addEmployee(@ModelAttribute("employee") Employee employee)
	 {
     		employeeService.addEmployeeService(employee);
			return "redirect:/";
		}
	@RequestMapping(value="/saveregister",params="update")
	public String updateEmployee(@ModelAttribute("employee") Employee employee)
	 {
		  employeeService.updateEmployee(employee);
			return "redirect:/";
		}

	@GetMapping("/remove/{employeeId}")
	public String removeEmployee(@PathVariable("employeeId") int employeeId)
	{
		employeeService.deleteEmployee(employeeId);
        return "redirect:/";
    }
	
	 @GetMapping("/edit")
	    public String editEmployee(@RequestParam("employeeId") int employeeId, Model model){
	        model.addAttribute("employee", employeeService.getEmployeeByid(employeeId));
	        model.addAttribute("employees",employeeService.getAllEmployee());
	        return "register";
	    }
}
	



