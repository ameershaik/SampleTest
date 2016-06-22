package com.test.poi.bean.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.test.poi.bean.Employee;
import com.test.poi.bean.service.POIService;
import com.test.poi.bean.service.POIServiceImpl;

public class POITestMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		   //Blank Document
		   XWPFDocument document= new XWPFDocument();
		        
		   //Write the Document in file system
		   FileOutputStream out = new FileOutputStream(new File("create_table.docx"));
		   
		   POIService poiService = new POIServiceImpl();
		   List<Employee> list = poiService.getEmployees();
		   XWPFTable empTable = document.createTable();
		   XWPFTableRow tableRowOne1 = empTable.getRow(0);
		   tableRowOne1.getCell(0).setText("NO");
		   tableRowOne1.addNewTableCell().setText("NAME");
		   tableRowOne1.addNewTableCell().setText("AGE");
		  // XWPFTableRow tableRowTwo2 = null;
		   for (int i=0; i<list.size();i++) {
			   Employee employee = (Employee)list.get(i);
			 //create first row
			   XWPFTableRow  tableRowTwo2 = empTable.createRow();
			   tableRowTwo2.getCell(0).setText(employee.getEno());
			   tableRowTwo2.getCell(1).setText(employee.getEname());
			   tableRowTwo2.getCell(2).setText(employee.getEage());
			}
		   
		   
		  /*      
		   //create table
		   XWPFTable table = document.createTable();
		   //create first row
		   XWPFTableRow tableRowOne = table.getRow(0);
		   tableRowOne.getCell(0).setText("col one, row one");
		   tableRowOne.addNewTableCell().setText("col two, row one");
		   tableRowOne.addNewTableCell().setText("col three, row one");
		   //create second row
		   XWPFTableRow tableRowTwo = table.createRow();
		   tableRowTwo.getCell(0).setText("col one, row two");
		   tableRowTwo.getCell(1).setText("col two, row two");
		   tableRowTwo.getCell(2).setText("col three, row two");
		   //create third row
		   XWPFTableRow tableRowThree = table.createRow();
		   tableRowThree.getCell(0).setText("col one, row three");
		   tableRowThree.getCell(1).setText("col two, row three");
		   tableRowThree.getCell(2).setText("col three, row three");*/
			
		   document.write(out);
		   out.close();
		   System.out.println("create_table.docx written successully");
		   
	}

}
