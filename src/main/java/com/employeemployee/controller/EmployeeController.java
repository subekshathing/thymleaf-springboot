package com.employeemployee.controller;

import com.employeemployee.dto.EmployeeDTO;
import com.employeemployee.model.FContact;
import com.employeemployee.repository.ContactRepository;
import com.employeemployee.service.ContactService;
import com.employeemployee.service.DepartmentService;
import com.employeemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ContactService contactService;

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/")
    
    public  String viewHomePage(Model model){
        model.addAttribute("allemplist",employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/add_emp")
    public String addNewEmployee(Model model){
        EmployeeDTO employeeDTO=new EmployeeDTO();
        model.addAttribute("employee",employeeDTO);
        model.addAttribute("department",departmentService.getAll());
        model.addAttribute("contact",contactService.getAllContact());
        return "addEmployee";


}

//    public String createEmployee(ModelMap map) {
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        map.put(ParameterConstant.EMPLOYEE, employeeDTO);
//        return "employee/create";
//    }
   @PostMapping("/save")
   public String saveEmployee(@ModelAttribute("employee") EmployeeDTO employeeDTO,@RequestParam("contacts") String[] contacts){
        employeeService.save(employeeDTO);
       for (String phone : contacts) {
           FContact contact = new FContact();
           contact.setEmployeeId(employeeDTO.getId());

           contactRepository.save(contact);
       }
        return "redirect:/";
   }
   @GetMapping("update/{id}")
    public String updateForm(@PathVariable(value = "id")long id ,Model model){
        EmployeeDTO employeeDTO=employeeService.getById(id);
      model.addAttribute("department",departmentService.getAll());
      model.addAttribute("employee",employeeDTO);
        return "update";
   }

   @PostMapping("updateEmp/{id}")
   public String updateEmp(@PathVariable long id ,EmployeeDTO dto){
        employeeService.updateEmp(id,dto);
        return "redirect:/";
   }
   @GetMapping("delete/{id}") //returnig homepage so getmapping in deletemapping
    public String deleteById(@PathVariable(value = "id") long id ){
        employeeService.deleteById(id);
        return "redirect:/";
   }
}
