
package application;

import java.util.ArrayList;
import java.util.Scanner;


class ReportData {

// list of products
private ArrayList<Product> products ;
// array for categories
private String[] categories;

public ReportData() {
this.categories = new String[] {"Desktop Computer", "Laptop", "Tablet", "Printer", "Gaming console"};
products = new ArrayList<>();
}
  
//method to add a new product
void addProduct(Scanner in) {
System.out.println("CAPTURE A NEW PRODUCT");
System.out.println("**********************");
Product newProduct = new Product();
System.out.print("Enter the product code: ");
newProduct.setProdCode(in.nextLine());
System.out.print("Enter the product name: ");
newProduct.setProdName(in.nextLine());
System.out.println("Enter the product category: ");
int choice;


// loop for category selection
        while (true) {
        for (int i = 0; i < categories.length; i++) {
        System.out.println(categories[i] + " - " + (i + 1));
        }
        System.out.print("Product category: ");
                try{
        
                    choice = Integer.parseInt(in.nextLine());

                if(choice>0 && choice<=categories.length)
        break;
            }
        
                catch(NumberFormatException e){
        System.out.println("Incorrect category selection..");
        }
    }

            newProduct.setCategory(categories[choice-1]);
    setWarranty(newProduct, in);
        setPrice(newProduct, in);
            setStockLevel(newProduct, in);
    System.out.print("Enter supplier for "+newProduct.getProdName()+": ");
    newProduct.setSupplier(in.nextLine());
    products.add(newProduct);
    System.out.println("Product details has been saved successfully!!!\n");
  
    }



//method for setting the stock level of a product
    private void setStockLevel(Product newProduct, Scanner in) throws NumberFormatException {
        System.out.print("Enter stock level for "+newProduct.getProdName()+": ");
    newProduct.setLevel(Integer.parseInt(in.nextLine()));
        }

//method for setting the price of a product
private void setPrice(Product newProduct, Scanner in) throws NumberFormatException {
System.out.print("Enter price for "+newProduct.getProdName()+": ");
newProduct.setPrice(Double.parseDouble(in.nextLine()));
}

//method for setting the warranty for a product
private void setWarranty(Product newProduct, Scanner in) {
System.out.print("Indicate product warranty. Enter (1) for 6 months or any other keys for 2 years: ");
newProduct.setWarranty(in.nextLine());
}

// method for searching a product in the products list
Product searchProduct(Scanner in) {
        System.out.println("Please enter product code: ");
        String prodCode = in.nextLine();
        System.out.println("\nPRODUCT SEARCH RESULT");
        System.out.println("*************************");
        for(int i=0; i<products.size(); i++){
if(products.get(i).getProdCode().equals(prodCode)){
return products.get(i);
            }
        }
return null;
        }

// method for updating the details of a product
void update(Scanner in) {
        Product p = searchProduct(in);
            if(p!=null){
    System.out.print("Update the warranty? (y)yes (n)no: ");
String choice = in.nextLine();

        if(choice.equalsIgnoreCase("y")){
setWarranty(p, in);
    }
System.out.print("Update the price? (y)yes (n)no: ");
choice = in.nextLine();
    
    if(choice.equalsIgnoreCase("y")){
    setPrice(p, in);
        }
System.out.print("Update the stock level? (y)yes (n)no: ");
choice = in.nextLine();
        
        if(choice.equalsIgnoreCase("y")){
        setStockLevel(p, in);
       
        }
System.out.println("Product details has been updated successfully!!!");
        }
        else{
System.out.println("The product cannot be located.");
    
            }
}

// method to delete a product
void delete(Scanner in) {
Product p = searchProduct(in);
if(p!=null){
System.out.print("Do you want to delete "+ p.getProdCode()+"? (y)yes (n)no: ");
String choice = in.nextLine();
if(choice.equalsIgnoreCase("y")){
products.remove(p);
System.out.println(p.getProdCode() +" deleted.");
}
  
}
else{
System.out.println("The product canot be located. Invalid product.");
}
}

// method for displaying the report
void report() {
        double total = 0;
        System.out.println("PRODUCT REPORT");
        System.out.println("*************************************************");
        for(int i=0; i<products.size(); i++){
        System.out.println("PRODUCT "+(i+1));
        System.out.println("--------------------------------------------------");
        System.out.println(products.get(i));
        total += products.get(i).getPrice();
        System.out.println("--------------------------------------------------");
            }
        
System.out.println("TOTAL PRODUCT COUNT: "+products.size());
System.out.println("TOTAL PRODUCT VALUE: R "+total);
System.out.printf("AVERAGE PRODUCT VALUE: R %.2f",total/products.size());

        }

    

}
