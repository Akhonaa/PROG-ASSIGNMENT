
package application;

import java.util.Scanner;


public class Application {
  
static ReportData newReport;

public static void main(String[] args) {
// scanner object for reading input
Scanner in = new Scanner(System.in);
// object for ReportData
newReport = new ReportData();
//loop for welcome message
while (true) {
showWelcomeMessage();
String choice = in.nextLine();
if (!choice.equals("1")) {
break;
}
//loop for mrnu
while (true) {
showMenu();
choice = in.nextLine();
if(choice.equals("6"))
break;
switch(choice){
case "1":
newReport.addProduct(in);
break;
case "2":
Product p = newReport.searchProduct(in);
if( p!= null)
System.out.println(p);
else
System.out.println("The product canot be located. Invalid product.");
break;
case "3":
newReport.update(in);
break;
case "4":
newReport.delete(in);
break;
case "5":
newReport.report();
break;
default:
System.out.println("Invalid entry...");
}
}

}
}

//method to display welcome message
private static void showWelcomeMessage() {
System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
System.out.println("**************************************");
System.out.println("Enter (1) to launch menu or any other key to exit");
}

//method to display menu
private static void showMenu() {
System.out.println("\nPlease select one of the menu item: ");
System.out.println("(1). Capture a new product");
System.out.println("(2). Search for a product");
System.out.println("(3). Update a product");
System.out.println("(4). Delete a product");
System.out.println("(5). Print report");
System.out.println("(6). Exit application");
}
}