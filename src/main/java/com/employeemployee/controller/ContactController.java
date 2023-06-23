package com.employeemployee.controller;

import com.employeemployee.dto.ContactDTO;
import com.employeemployee.dto.DepartmentDTO;
import com.employeemployee.service.ContactService;
import com.employeemployee.service.DepartmentService;
import com.employeemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/conIndex")

    public  String viewHomePage(Model model){
        model.addAttribute("alllistcon",contactService.getAllContact());
        model.addAttribute("employeeList",employeeService.getAllEmployee());
        return "contact";
    }

    @GetMapping("/add_con")
    public String addNewCon(Model model){
        ContactDTO contactDTO =new ContactDTO();
        model.addAttribute("contact",contactDTO);
        return "addContact";
    }
    @PostMapping("/save_con")
    public String save(@ModelAttribute("contact") ContactDTO contactDTO){
        contactService.saveCon(contactDTO);
        return "redirect:/conIndex";
    }
    @GetMapping("update_con/{id}")
    public String updateForm(@PathVariable(value = "id")long id , Model model){
        ContactDTO contactDTO=contactService.getById(id);
        model.addAttribute("contact",contactDTO);
        return "updateCon";
    }
    @PostMapping("updateCon/{id}")
    public String updateCon(@PathVariable long id , ContactDTO dto){
        contactService.updateCon(id,dto);
        return "redirect:/conIndex";
    }
    @GetMapping("delete_con/{id}") //returnig homepage so getmapping in deletemapping
    public String deleteById(@PathVariable(value = "id") long id ){
        contactService.deleteById(id);
        return "redirect:/conIndex";
    }
}
