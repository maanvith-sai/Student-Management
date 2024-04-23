package com.studentManagement.controller.semester;


import com.studentManagement.entity.Student;
import com.studentManagement.entity.semester.Fees;
import com.studentManagement.entity.semester.first;
import com.studentManagement.repository.semester.FeesInterface;
import com.studentManagement.service.excelService.FeesExcelFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/fees")
public class FeesController {


    @Autowired
    FeesInterface repo;
    private final FeesExcelFileService excelFileService;

    public FeesController(FeesExcelFileService excelFileService) {
        this.excelFileService = excelFileService;
    }

    public String showUploadForm()
    {
        return "uploadfees";
    }

    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model)
    {
        try
        {
            List<Fees> entities = excelFileService.processExcelFile(file);
            model.addAttribute("entities", entities);
            model.addAttribute("message", "File uploaded and data saved successfully!");
        } catch (IOException e)
        {
            e.printStackTrace();
            model.addAttribute("error", "Error processing the file.");
        }
        return "result544";
    }

    public String method1(Model model)
    {
        List<Student> results = repo.findAllUsersWithAddressfirst();
        model.addAttribute("first", results);
        return "firstMarks";
    }

    public String method2(@PathVariable String value, Model model)
    {
        List<first> std2=repo.findUsersWithId(value);
        model.addAttribute("entities",std2);
        return "result544";
    }
}
