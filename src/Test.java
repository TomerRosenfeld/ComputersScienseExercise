/**
 * Created by tomer on 9/4/15.
 * This Program uses a custom library I created called JavaTomer8 including simple print/println , random functions and simple userinput class
 */

public class Test implements Tomer {
    public static void main(String[] arguments) {

        //Creating a new shop object
        Shop shop = new Shop();

        //Creating custom userinput object using custom library I made
        UserInput userInput = new UserInput();

        //Creating an example "current" date
        Date todaysDate = new Date(2000, 9, 24);

        //Creating an example array of names
        String[] productsNamesExample = {"Fish", "Eggs", "Water", "Soda", "Milk", "Chicken", "Pizza", "Burger", "Beans", "Corn", "Chocolate", "Coffee"};

        new Test().println("This is the stock before update");
        for (int i = 0; i < 10; i++) {
            //Create products and add them to the store
            shop.createProduct(i, 10 * (i + 1), productsNamesExample[i], new Date(2000, 10, i));
            //Print current product data
            new Test().println(i + "." + shop.getProducts().get(i).getName() + " : " + shop.getProducts().get(i).getQuantity());
        }

        new Test().println("\nUpdating stock..");
        //Updating the stock for the current date
        shop.stock(todaysDate);
        //Letting the store know that we changed the stock items so it can recalculate the quantity
        shop.updateQuantity();

        new Test().println("\nThis is the stock after update");

        //Printing the stock after the changes
        for (int i = 0; i < shop.getProducts().size(); i++) {
            new Test().println(i + "." + shop.getProducts().get(i).getName() + " : " + shop.getProducts().get(i).getQuantity());
        }

        //Running the dialog with the user until total quantity reaches 0
        while (shop.getTotalQuant() > 0) {
            main(shop, userInput);
        }
        //Letting the user know the stock is finished
        new Test().println("No more items in the store :)");
    }

    private static void main(Shop shop, UserInput userInput) {
        new Test().println("What Item Number Do You Want To Remove");
        //Getting the item number from the custom userInput object
        String input1 = userInput.getUserInput();
        new Test().println("How much of the item would you want to remove");
        //Getting the numbers of item to remove from the product using the custom userInput object
        String input2 = userInput.getUserInput();
        //Checking the product details before removing
        if (shop.checkProduct(Integer.parseInt(input1), Integer.parseInt(input2))) {
            new Test().println("You chose to remove" + input2 + " From " + shop.getProductById(Integer.parseInt(input1)).getName());
            new Test().println("Removing...");
            //Removing the required quantity from the product
            shop.removeQty(Integer.parseInt(input1), Integer.parseInt(input2));
            new Test().println(shop.getProductById(Integer.parseInt(input1)).getName() + " now has " + shop.getProductById(Integer.parseInt(input1)).getQuantity());
            //Letting the store know that we changed the stock items so it can recalculate the quantity
            shop.updateQuantity();
        } else {
            //An error has occurred, either item not found or not enough of the item, user will get a detailed response from the system
            new Test().println("Error removing");
        }
    }
}
