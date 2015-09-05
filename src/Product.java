/**
 * Created by tomer on 9/4/15.
 */
public class Product {
    private int code, quantity;
    private String name;
    private Date d1;

    public Product(String name, int code, int quantity, Date d1) {
        this.quantity = quantity;
        this.d1 = d1;
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    protected void remove(int quantity) {
        this.quantity -= quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getD1() {
        return d1;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
