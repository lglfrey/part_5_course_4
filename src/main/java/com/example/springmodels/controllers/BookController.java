package com.example.springmodels.controllers;

import com.example.springmodels.models.*;
import com.example.springmodels.repos.DepartmentRepository;
import com.example.springmodels.repos.EmployeeRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;



//    @GetMapping("/human")
//    public String humanMain(Model model)
//    {
//        Iterable<Human> humans = humanRepository.findAll();
//        model.addAttribute("humans", humans);
//        Iterable<University> universities = universityRepository.findAll();
//        model.addAttribute("universities", universities);
//        return "human-main";
//    }

    @GetMapping("/employee")
    public String employeeMain(Model model)
    {
        Iterable<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employee-main";
    }


    @GetMapping("/employee/add")
    public String employeeAdd(@ModelAttribute("employees") Employee employee, Model departmentt)
    {
        Iterable<Department> department = departmentRepository.findAll();
        departmentt.addAttribute("department", department);
        return "employee-add";
    }



    @PostMapping("/employee/add")
    public String employeePostAdd(@ModelAttribute("employees") @Valid Employee employee, BindingResult bindingResult,
                                  @RequestParam String nameDep, Model departmentt)
    {
        if(bindingResult.hasErrors()) {
            Iterable<Department> department = departmentRepository.findAll();
            departmentt.addAttribute("department", department);
            return "employee-add";
        }
        employee.setDepartment(departmentRepository.findByNameDep(nameDep));
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}/edit")
    public  String employeeDetails(@PathVariable(value = "id") long id, Model model, Model departmentt)
    {
        Iterable<Department> department = departmentRepository.findAll();
        departmentt.addAttribute("department", department);
        Employee res1 = employeeRepository.findById(id).orElseThrow();
        model.addAttribute("employee",res1);
        return "employee-edit";
    }


    @PostMapping ("/employee/{id}/edit")
    public  String employeeUpdate(@ModelAttribute("employee") @Valid Employee employee,
                               BindingResult bindingResult,
                               @PathVariable(value = "id") long id)
    {
        if(bindingResult.hasErrors())
            return "employee-edit";
        employeeRepository.save(employee);
        return "redirect:/employee";
    }


    @GetMapping("/employee/{id}/remove")
    public  String employeeDelete(@PathVariable(value = "id") long id, Model model)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(employee);
        return "redirect:/employee";
    }





}