/**
 * Created by tomer on 9/4/15.
 */
public class Test implements Tomer {
    public static void main(String[] arguments) {
        Shop shop = new Shop();
        UserInput userInput = new UserInput();

        Date todaysDate = new Date(2000,9,28);

        String[] names = {"Fish", "Eggs", "Water", "Soda", "Milk", "Chicken", "Pizza", "Burger", "Beans", "Corn", "Chocolate", "Coffee"};

        for (int i = 0; i < 10; i++) {
            shop.createProduct(i, 10 * (i+1), names[i], new Date(2000, 10, i));
            new Test().println(i+"."+shop.products.get(i).getName()+" : "+shop.products.get(i).getQuantity());
        }

        shop.stock(todaysDate);
        shop.updateQuantity();
        while (shop.totalQuant > 0) {
            main(shop, userInput);
        }
        new Test().println("No more items in the store :)");
    }

    private static void main(Shop shop, UserInput userInput) {
        new Test().println("What Item Do You Want To Remove");
        String input1 = userInput.getUserInput();
        new Test().println("You chose " + shop.getProductById(Integer.parseInt(input1)).getName());
        new Test().println("How much of the item would you want to remove");
        String input2 = userInput.getUserInput();
        if (shop.checkProduct(Integer.parseInt(input1), Integer.parseInt(input2))) {
            new Test().println("Removing...");
            shop.removeQty(Integer.parseInt(input1), Integer.parseInt(input2));
            new Test().println(shop.getProductById(Integer.parseInt(input1)).getName() + " now has " + shop.getProductById(Integer.parseInt(input1)).getQuantity());
            shop.updateQuantity();
        } else {
            new Test().println("Error removing, Not enough");
        }
    }
}
