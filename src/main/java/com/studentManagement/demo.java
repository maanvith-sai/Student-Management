package com.studentManagement;

import com.studentManagement.entity.Student;
import com.studentManagement.entity.semester.Fees;
import com.studentManagement.entity.semester.TransactionId;
import com.studentManagement.repository.StudentRepository;
import com.studentManagement.repository.TransactionInterface;
import com.studentManagement.repository.semester.FeesInterface;
import com.studentManagement.service.excelService.FeesExcelFileService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class demo {
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("1234"));
	}
}


//
//package com.studentManagement.service.excelService.impl;
//
//
//		import com.studentManagement.entity.Student;
//		import com.studentManagement.entity.semester.Fees;
//		import com.studentManagement.entity.semester.TransactionId;
//		import com.studentManagement.entity.semester.first;
//		import com.studentManagement.repository.StudentRepository;
//		import com.studentManagement.repository.TransactionInterface;
//		import com.studentManagement.repository.semester.FeesInterface;
//		import com.studentManagement.repository.semester.FirstSemesterInterface;
//		import com.studentManagement.service.excelService.FeesExcelFileService;
//		import com.studentManagement.service.excelService.FirstExcelFileService;
//		import jakarta.persistence.EntityNotFoundException;
//		import org.apache.poi.ss.usermodel.*;
//		import org.springframework.beans.factory.annotation.Autowired;
//		import org.springframework.dao.DataIntegrityViolationException;
//		import org.springframework.stereotype.Service;
//		import org.springframework.transaction.annotation.Transactional;
//		import org.springframework.web.multipart.MultipartFile;
//
//		import java.io.IOException;
//		import java.util.ArrayList;
//		import java.util.Iterator;
//		import java.util.List;
//
//@Service
//@Transactional
//public class FeesExcelFIleServiceImpl implements FeesExcelFileService {
//
//	@Autowired
//	FeesInterface feesRepository;
//
//	@Autowired
//	StudentRepository studentRepository;
//
//	@Autowired
//	TransactionInterface transid;
//
//	@Override
//	public List<Fees> processExcelFile(MultipartFile file) throws IOException
//	{
//		try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
//			List<Fees> feesList = new ArrayList<>();
//			Sheet sheet = workbook.getSheetAt(0);
//			Iterator<Row> rowIterator = sheet.iterator();
//
//			if (rowIterator.hasNext())
//			{
//				rowIterator.next();
//			}
//			while (rowIterator.hasNext())
//			{
//				Row row = rowIterator.next();
//				Fees entity = new Fees();
//				try
//				{
//					populateEntityFromRow(entity, row);
//					List<TransactionId> lis1=transid.findAll();
//					for(TransactionId lis:lis1)
//					{
//						if(lis.getTransactionid().contains(String.valueOf(getStringCellValue(row.getCell(4)))))
//						{
//							throw new IOException("duplicate data found in the Excel file.");
//						}
//					}
//					feesRepository.save(entity);
//					transid.save(new TransactionId(String.valueOf(getStringCellValue(row.getCell(4)))));
//				}
//				catch(IOException e)
//				{
//					System.out.print("duplcate data found");
//				}
//			}
//
//			return feesRepository.findAll();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			throw new IOException("Error processing the Excel file.", e);
//		}
//	}
//
//	private void populateEntityFromRow(Fees entity, Row row) {
//		String studentId = String.valueOf(getStringCellValue(row.getCell(0)).toUpperCase());
//		Student student = studentRepository.findById(studentId)
//				.orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + studentId));
//		entity.setId1(studentId);
//		entity.setDate(String.valueOf(row.getCell(1)));
//		entity.setPaid(String.valueOf(getStringCellValue(row.getCell(2))));
//		entity.setBalance(String.valueOf(getStringCellValue(row.getCell(3))));
//		entity.setTransactionId(String.valueOf(getStringCellValue(row.getCell(4))));
//		entity.setFees(student);
//		student.getFees().add(entity);
//	}
//
//	private String getStringCellValue(Cell cell) {
//		if (cell == null) {
//			return null;
//		}
//		switch (cell.getCellType()) {
//			case STRING:
//				return cell.getStringCellValue();
//			case NUMERIC:
//				return String.valueOf(cell.getNumericCellValue());
//			case BOOLEAN:
//				return String.valueOf(cell.getBooleanCellValue());
//			case FORMULA:
//				// Handle formula cells if needed
//				return cell.getCellFormula();
//		}
//		return null;
//	}
//}




//<!DOCTYPE html>
//<html lang="en" xmlns:th="http://www.thymeleaf.org"
//		th:replace="admin_base::layout(~{::section})">
//
//<head>
//<meta charset="ISO-8859-1">
//<title>User Login</title>
//
//</head>
//<body>
//
//<section>
//<style>
//			* {
//					margin: 0;
//					padding: 0;
//					box-sizing: border-box;
//					font-family: 'Poppins', sans-serif;
//					}
//
//					body {
//<!--                display: flex;-->
//<!--                justify-content: center;-->
//<!--                align-items: center;-->
//<!--                min-height: 100vh;-->
//		background: #dfdfdf;
//		}
//
//		.login-box {
//		display: flex;
//		justify-content: center;
//		flex-direction: column;
//		width: 440px;
//		height: 480px;
//		padding: 30px;
//		border-radius: 50px;
//		border: none;
//		box-shadow: 0px 5px 10px 1px rgba(0,0,0, 0.05);
//		}
//
//		.login-header {
//		text-align: center;
//		margin: 20px 0 40px 0;
//		}
//
//		.login-header header {
//		color: #333;
//		font-size: 30px;
//		font-weight: 600;
//		}
//
//		.input-box .input-field {
//		width: 100%;
//		height: 60px;
//		font-size: 17px;
//		padding: 0 25px;
//		margin-bottom: 15px;
//		border-radius: 30px;
//		border: none;
//		box-shadow: 0px 5px 10px 1px rgba(0,0,0, 0.05);
//		outline: none;
//		transition: .3s;
//		}
//
//		::placeholder {
//		font-weight: 20;
//		color: #9EA2A4;
//		}
//
//		.input-field:focus {
//		width: 105%;
//		border: 2px solid black;
//		}
//
//		.forgot {
//		display: flex;
//		justify-content: space-between;
//		margin-bottom: 40px;
//		}
//
//		section {
//		display: flex;
//		align-items: center;
//		font-size: 14px;
//		color: #555;
//		}
//
//		#check {
//		margin-right: 10px;
//		}
//
//		a {
//		text-decoration: none;
//		}
//
//		a:hover {
//		text-decoration: underline;
//		}
//
//		section a {
//		color: #555;
//		}
//
//		.input-submit {
//		position: relative;
//		}
//
//		.submit-btn {
//		width: 100%;
//		height: 60px;
//		background: #222;
//		border: none;
//		border-radius: 30px;
//		cursor: pointer;
//		transition: .3s;
//		}
//
//		.input-submit label {
//		position: absolute;
//		top: 50%;
//		left: 50%;
//		color: #fff;
//		transform: translate(-50%, -50%);
//		cursor: pointer;
//		}
//
//		.submit-btn:hover {
//		background: #000;
//		transform: scale(1.05, 1);
//		}
//
//		.sign-up-link {
//		text-align: center;
//		font-size: 15px;
//		margin-top: 20px;
//		}
//
//		.sign-up-link a {
//		color: #000;
//		font-weight: 600;
//		}
//
///* Add this style to center the login box on small screens */
//@media (max-width: 600px) {
//		.login-box {
//		width: 80%;
//		}
//		}
//</style>
//
//<div class="container p-3">
//<br>
//<br>
//<br>
//<br>
//<br>
//<br>
//<div class="row">
//<div class="col-md-6 offset-md-3">
//<div class="card">
//<div class="card-header text-center fs-4">Login Page</div>
//<br>
//<th:block th:if="${param.error}">
//<p class="text-center text-danger fs-5">[[${session.SPRING_SECURITY_LAST_EXCEPTION.message}]]</p>
//</th:block>
//<th:block th:if="${param.logout}">
//<p class="text-center text-success fs-5">Logout Sucessfully</p>
//</th:block>
//<div class="card-body">
//<form action="userLogin" method="post">
//
//<!--								<div class="mb-3">-->
//<!--									<label>Enter UserId</label> <input type="text" name="username"-->
//<!--										class="form-control">-->
//<!--								</div>-->
//<!--								<div class="mb-3">-->
//<!--									<label>Enter Password</label> <input type="text"-->
//<!--										name="password" class="form-control">-->
//<!--								</div>-->
//<!--								<button class="btn btn-primary col-md-12">Login</button>-->
//<div class="input-box">
//<input type="text" name="username" class="input-field" placeholder="Username" autocomplete="on" required>
//</div>
//<div class="input-box">
//<input type="password" name="password" class="input-field" placeholder="Password" autocomplete="off" required>
//</div>
//<div class="forgot">
//<section>
//<input type="checkbox" id="check" name="rememberMe">
//<label for="check">Remember me</label>
//</section>
//</div>
//<div class="input-submit">
//<button type="submit" class="submit-btn" id="submit"></button>
//<label for="submit">Log In</label>
//</div>
//</form>
//</div>
//</div>
//</div>
//</div>
//</div>
//</section>
//<footer style="position: fixed; bottom: 20px; right: 20px;">
//<b><u>Under the esteemed guidance of</u><br><br><span style="font-size: 1.2em;">Mr. Syed Zaheer Ahammed, <sub>M.Tech Ph.D.</sub>,</span></b>
//</footer>
//</body>
//</html>