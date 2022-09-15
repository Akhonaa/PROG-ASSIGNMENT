
package application;


class Product {


// my created variables
private String prodCode;
private String prodName;
private String category;
private double price;
private int level;
private String supplier;
private String warranty;

    //constructor
        public Product() {
        this.warranty = "2 years"; // default warranty = 2 years
    }

                public String getProdCode() {
        
                return prodCode;
        }

    
                public void setProdCode(String prodCode) {

                this.prodCode = prodCode;
            }


            public String getProdName() {
            return prodName;
            }

public void setProdName(String prodName) {
this.prodName = prodName;
}

public String getCategory() {
return category;
}

public void setCategory(String category) {
this.category = category;
}

            public String getWarranty() {
    
            return warranty;
    }

public void setWarranty(String warranty) {
if(warranty.equals("1"))
this.warranty = "6 months";
}

public double getPrice() {
return price;
}

public void setPrice(double price) {
this.price = price;
}

public int getLevel() {
return level;
}

public void setLevel(int level) {
this.level = level;
}

    public String getSupplier() {
    return supplier;
    }

        public void setSupplier(String supplier) {
        this.supplier = supplier;
        }

    @Override
        public String toString() {
return "PRODUCT CODE >> \t" + prodCode + "\nPRODUCT NAME >> \t" + prodName + "\nPRODUCT CATEGORY >> \t" + category + "\nPRODUCT WARRANTY >> \t"
+ warranty + "\nPRODUCT PRICE >> \t" + price + "\nPRODUCT LEVEL >> \t" + level + "\nPRODUCT SUPPLIER >> \t" + supplier ;
        }
      
}