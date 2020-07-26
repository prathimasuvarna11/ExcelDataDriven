package DataDriven.ExcelDataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws IOException {
		ExcelDataDrivenTest data= new ExcelDataDrivenTest();
		ArrayList d=data.getData("Delete Profile");
		
		  for(int i=0;i<d.size();i++) 
		  { System.out.println(d.get(i)); 
		  }
		 
		  
	}

}
