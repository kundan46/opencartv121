package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        
        // Path to the Excel file containing the data
        String path = "./testData/Opencart_LoginData.xlsx"; 

        // Creating an object for ExcelUtility to access Excel methods
        ExcelUtility xlutil = new ExcelUtility(path); 

        // Get the total number of rows (last row index)
        int totalrows = xlutil.getRowCount("Sheet1"); 
        
        // Get the total number of columns in the first row (assuming header is in row 0)
        // The code in the screenshot uses row index 1 to get cell count, but row index 0 is common for headers.
        // I will use row index 1 as per the screenshot, which means totalcols is the count of columns in the first data row.
        int totalcols = xlutil.getCellCount("Sheet1", 1); 

        // Create a two-dimensional array to store the data (String[][])
        // The size is (total rows to read) x (total columns). 
        // We use (totalrows) as the count is 0-based index from getRowCount(), 
        // but the data reading loop starts from row 1, so the array size is correct for the data rows (1 to totalrows).
        String logindata[][] = new String[totalrows][totalcols]; 

        // Read the data from the Excel file and store it in the two-dimensional array
        // Start reading from row 1 (i=1), assuming row 0 is the header/titles
        for (int i = 1; i <= totalrows; i++) { // i is the row index in the Excel sheet (starts from 1)
            for (int j = 0; j < totalcols; j++) { // j is the column index in the Excel sheet (starts from 0)
                // Read cell data from Excel
                String data = xlutil.getCellData("Sheet1", i, j);
                
                // Store the data in the array. 
                // We use [i-1] for the row index in the array because the array index is 0-based 
                // but the Excel row reading starts from row index 1.
                logindata[i - 1][j] = data; 
            }
        }
        
        // Return the two-dimensional array
        return logindata; 
    }

    // You can add more DataProviders here for other test methods
    // //DataProvider 2
    // //DataProvider 3
    // //DataProvider 4 

}