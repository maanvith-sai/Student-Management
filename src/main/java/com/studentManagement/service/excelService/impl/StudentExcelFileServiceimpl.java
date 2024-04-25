package com.studentManagement.service.excelService.impl;

import com.studentManagement.entity.Student;
import com.studentManagement.entity.User;
import com.studentManagement.repository.StudentRepository;
import com.studentManagement.repository.UserRepo;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class StudentExcelFileServiceimpl
{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepo userrespository;


    public List<Student> processExcelFile(MultipartFile file) throws IOException
    {
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream()))
        {
            List<Student> stdList = new ArrayList<>();
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext())
            {
                rowIterator.next();
            }
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                Student entity = new Student();
                User user=new User();
                populateEntityFromRow(entity,user,row);
                studentRepository.save(entity);
                userrespository.save(user);
            }
            return studentRepository.findAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new IOException("Error processing the Excel file.", e);
        }
    }

    private void populateEntityFromRow(Student entity,User user,Row row) throws IOException
    {
        String password=String.valueOf(getStringCellValue(row.getCell(9)));
        entity.setId(String.valueOf(getStringCellValue(row.getCell(0))));
        entity.setFirstName(String.valueOf(row.getCell(1)));
        entity.setLastName(String.valueOf(getStringCellValue(row.getCell(2))));
        entity.setEmail(String.valueOf(getStringCellValue(row.getCell(3))));
        entity.setTeacherId(String.valueOf(getStringCellValue(row.getCell(4))));
        entity.setDateofbirth(String.valueOf(getStringCellValue(row.getCell(5))));
        entity.setMobileno(String.valueOf(getStringCellValue(row.getCell(6))));
        entity.setRegulation(String.valueOf(getStringCellValue(row.getCell(7))));
        entity.setDepartment(String.valueOf(getStringCellValue(row.getCell(8))));
        entity.setPassword(password);

//        if (authentication != null && authentication.isAuthenticated())
//        {
//            Object principal = authentication.getPrincipal();
//            if (principal instanceof UserDetails) {
//                // Retrieve user roles
//                UserDetails userDetails = (UserDetails) principal;
//                role= String.valueOf(userDetails.getAuthorities());
//            }
//        }


//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role="ROLE_USER";
        user.setUserId(String.valueOf(getStringCellValue(row.getCell(0))));
        user.setRole(role);
        user.setName(String.valueOf(row.getCell(1))+String.valueOf(getStringCellValue(row.getCell(2))));
        user.setPassword(password);
    }
    private String getStringCellValue(Cell cell)
    {
        if (cell == null)
        {
            return null;
        }
        switch (cell.getCellType())
        {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                // Handle formula cells if needed
                return cell.getCellFormula();
        }
        return null;
    }
}

//    public List<Student> processExcelFile(MultipartFile file) throws IOException
//    {
//        try (Workbook workbook = WorkbookFactory.create(file.getInputStream()))
//        {
//            List<Student> stdList = new ArrayList<>();
//            Sheet sheet = workbook.getSheetAt(0);
//            Iterator<Row> rowIterator = sheet.iterator();
//            if (rowIterator.hasNext())
//            {
//                rowIterator.next();
//            }
//            while (rowIterator.hasNext())
//            {
//                Row row = rowIterator.next();
//                Student entity = new Student();
//                populateEntityFromRow(entity,row);
//                studentRepository.save(entity);
//            }
//            return studentRepository.findAll();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            throw new IOException("Error processing the Excel file.", e);
//        }
//    }
//
//    private void populateEntityFromRow(Student entity,Row row) throws IOException {
//        String studentId = String.valueOf(getStringCellValue(row.getCell(0)));
////        String filePath="src//main//resources//Logo.drawio.png.jpeg";
//
////        Student student = studentRepository.findById(studentId)
////                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + studentId));
////        entity.setImage(path);
////        Blob[] imageBytes = Files.readAllBytes(Paths.get(filePath));
//        entity.setId(studentId);
//        entity.setFirstName(String.valueOf(row.getCell(1)));
//        entity.setLastName(String.valueOf(getStringCellValue(row.getCell(2))));
//        entity.setEmail(String.valueOf(getStringCellValue(row.getCell(3))));
//        entity.setTeacherId(String.valueOf(getStringCellValue(row.getCell(4))));
//        entity.setDateofbirth(String.valueOf(getStringCellValue(row.getCell(5))));
//        entity.setMobileno(String.valueOf(getStringCellValue(row.getCell(6))).substring(1));
//        entity.setRegulation(String.valueOf(getStringCellValue(row.getCell(7))));
//        entity.setDepartment(String.valueOf(getStringCellValue(row.getCell(6))));
//    }
//    private String getStringCellValue(Cell cell)
//    {
//        if (cell == null)
//        {
//            return null;
//        }
//        switch (cell.getCellType())
//        {
//            case STRING:
//                return cell.getStringCellValue();
//            case NUMERIC:
//                return String.valueOf(cell.getNumericCellValue());
//            case BOOLEAN:
//                return String.valueOf(cell.getBooleanCellValue());
//            case FORMULA:
//                // Handle formula cells if needed
//                return cell.getCellFormula();
//        }
//        return null;
//    }
//}
