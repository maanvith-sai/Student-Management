package com.studentManagement.service.excelService.impl;


import com.studentManagement.entity.Student;
import com.studentManagement.entity.semester.Fees;
import com.studentManagement.entity.semester.TransactionId;
import com.studentManagement.entity.semester.first;
import com.studentManagement.repository.StudentRepository;
import com.studentManagement.repository.TransactionInterface;
import com.studentManagement.repository.semester.FeesInterface;
import com.studentManagement.repository.semester.FirstSemesterInterface;
import com.studentManagement.service.excelService.FeesExcelFileService;
import com.studentManagement.service.excelService.FirstExcelFileService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class FeesExcelFIleServiceImpl implements FeesExcelFileService {

    @Autowired
    FeesInterface feesRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TransactionInterface transid;

    @Override
    public List<Fees> processExcelFile(MultipartFile file) throws IOException
    {
        try (Workbook workbook = WorkbookFactory.create(file.getInputStream()))
        {
            List<Fees> feesList = new ArrayList<>();
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext())
            {
                rowIterator.next();
            }
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                Fees entity = new Fees();
                populateEntityFromRow(entity, row);
                List<TransactionId> lis1=transid.findAll();
                boolean flag=true;
                for(TransactionId lis:lis1)
                {
                    if((lis.getTransactionid().equals(String.valueOf(getStringCellValue(row.getCell(4))))))
                    {
                       flag=false;
                    }
                }
                if(flag) feesRepository.save(entity);
                transid.save(new TransactionId(String.valueOf(getStringCellValue(row.getCell(4)))));
            }
            return feesRepository.findAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new IOException("Error processing the Excel file.", e);
        }
    }

    private void populateEntityFromRow(Fees entity, Row row)
    {
        String studentId = String.valueOf(getStringCellValue(row.getCell(0)).toUpperCase());
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + studentId));

        entity.setId1(studentId);
        entity.setDate(String.valueOf(row.getCell(1)));
        entity.setPaid(String.valueOf(getStringCellValue(row.getCell(2))));
        entity.setBalance(String.valueOf(getStringCellValue(row.getCell(3))));
        entity.setTransactionId(String.valueOf(getStringCellValue(row.getCell(4))));
        entity.setFees(student);
        student.getFees().add(entity);
    }

    private String getStringCellValue(Cell cell) {
        if (cell == null)
        {
            return null;
        }
        switch (cell.getCellType()) {
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