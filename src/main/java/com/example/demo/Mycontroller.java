package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Mycontroller {
 @Autowired
 MyService service;
 @RequestMapping("/")
 public String showhomepage(Model model) {
	
	 System.out.println("====display data====");
	  List<Product> li=service.display();
	 
	 
	 for(Product p:li) {
		 
	 System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice());
 }
	 model.addAttribute("abc",li);
	 return "show";
}
 @RequestMapping("/addData")
 public String newdata(Model model) {
	 Product product=new Product();
	 model.addAttribute("product",product);
	return "add-pro";
	 
 }
 @RequestMapping(value="/save",method = RequestMethod.POST)
 public String saveAfter(@ModelAttribute("product") Product product)
 {
     service.saveproduct(product);
     return "redirect:/";
 }
 @RequestMapping("/edit/{id}")
 public ModelAndView editData(@PathVariable(name = "id")int id)
 {
     ModelAndView modelAndView=new ModelAndView("edit_data");
     Product product=service.getProduct(id);
     modelAndView.addObject("product",product);
     return modelAndView;
 }
 @RequestMapping("/delete/{id}")
 public String deleteData(@PathVariable(name= "id") int id)
{
 service.delete(id);
 return "redirect:/";
 }

}
