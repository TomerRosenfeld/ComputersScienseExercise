import java.util.ArrayList;

/**
 * Created by tomer on 9/4/15.
 */
public class Shop implements Tomer {

    ArrayList<Product> products;
    int totalQuant = 0;

    public Shop() {
        products = new ArrayList<>();
    }

    protected void createProduct(int code, int quantity, String name, Date d1) {
        products.add(new Product(name, code, quantity, d1));
    }

    protected void updateQuantity() {
        totalQuant = 0;
        for (Product product : products){
            totalQuant += product.getQuantity();
        }
    }

    protected void removeQty(int code, int qty) {
        try {
            getProductById(code).remove(qty);
        } catch (NullPointerException e) {
            print("Item not found");
        }
    }

    protected boolean checkProduct(int code, int qty) {
        try {
            return getProductById(code).getQuantity() >= qty;
        } catch (NullPointerException e) {
            print("Item with that id not found");
        }
        return false;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getCode() == id) {
                return product;
            }
        }
        return null;
    }

    void stock(Date todaysDate) {
        for (Product product : products) {
            if (Date.getDatesDifference(product.getD1(), todaysDate) < 10) {
                product.setQuantity(0);
            }
        }
    }

}
