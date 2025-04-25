public class Product {
    //AV1051|JBL Bluetooth Speaker|89.95|Audio Video

    String id;
    String name;
    double price;
    String department;

    public Product(String id, String name, double price, String department){
        this.id = id;
        this.name = name;
        this.price = price;
        this.department = department;
    }

    //region Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    //endregion




}
