import java.util.ArrayList;

/**
 * Created by tomer on 9/4/15.
 */
public class Shop implements Tomer {

    private ArrayList<Product> products;

    private int totalQuant = 0;

    public Shop() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public int getTotalQuant() {
        return totalQuant;
    }

    protected void createProduct(int code, int quantity, String name, Date d1) {
        products.add(new Product(name, code, quantity, d1));
    }

    protected void updateQuantity() {
        totalQuant = 0;
        for (Product product : products) {
            totalQuant += product.getQuantity();
        }
    }

    protected void removeQty(int code, int qty) {
        try {
            getProductById(code).remove(qty);
        } catch (NullPointerException e) {
            println("Item not found");
        }
    }

    protected boolean checkProduct(int code, int qty) {
        try {
            return getProductById(code).getQuantity() >= qty;
        } catch (NullPointerException e) {
            println("Item not found");
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
                println("Clearing " + product.getName() + " Because it will go bad in: " + Date.getDatesDifference(product.getD1(), todaysDate) + " Days");
                product.setQuantity(0);
            }
        }
    }

}
