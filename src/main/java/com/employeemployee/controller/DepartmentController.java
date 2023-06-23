package com.employeemployee.controller;


import com.employeemployee.dto.DepartmentDTO;
import com.employeemployee.dto.EmployeeDTO;
import com.employeemployee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/depIndex")

    public  String viewHomePage(Model model){
        model.addAttribute("alllist",departmentService.getAll());
        return "department";
    }

    @GetMapping("/add_dep")
    public String addNewDep(Model model){
        DepartmentDTO departmentDTO =new DepartmentDTO();
        model.addAttribute("department",departmentDTO);
        return "addDepartment";
    }
    @PostMapping("/save_dep")
    public String saveEmployee(@ModelAttribute("department") DepartmentDTO departmentDTO){
        departmentService.save(departmentDTO);
        return "redirect:/depIndex";
    }
    @GetMapping("update_dep/{id}")
    public String updateForm(@PathVariable(value = "id")long id , Model model){
        DepartmentDTO departmentDTO=departmentService.getById(id);
        model.addAttribute("department",departmentDTO);
        return "updateDep";
    }
    @PostMapping("updateDep/{id}")
    public String updateEmp(@PathVariable long id , DepartmentDTO dto){
        departmentService.updateDep(id,dto);
        return "redirect:/depIndex";
    }
    @GetMapping("delete_dep/{id}") //returnig homepage so getmapping in deletemapping
    public String deleteById(@PathVariable(value = "id") long id ){
        departmentService.deleteById(id);
        return "redirect:/depIndex";
    }
}
