package frompythontojava.onlineshop.part3;

import frompythontojava.onlineshop.part1.*;
import frompythontojava.onlineshop.part2.*;
import java.text.ParseException;
import java .util.ArrayList;

public class Application {
    View view = new View();
    Basket basket = new Basket();
    private ArrayList<ProductCategory> categoryList = new ArrayList<>();
    
    public void handleCreatingProduct() {
        String name = view.askUser("Product name:");
        Float defaultPrice = Float.valueOf(view.askUser("DefaultPrice: "));
        String productCategory = view.askUser("Category: ");
        for(ProductCategory item : this.categoryList) {
            if(productCategory.equals(item.getName())) {
                new Product(name, defaultPrice, item);
                return;
            }    
        }
        ProductCategory item = new ProductCategory(productCategory);
        this.categoryList.add(item);
        new Product(name, defaultPrice, item);

    }

    public void handleCreatingFeaturedCategory() throws ParseException {
        String name = view.askUser("Category name:");
        String expirationDate = view.askUser("Expiration date(yyyy.MM.dd): ");
        this.categoryList.add(new FeaturedProductCategory (name, expirationDate));
    }

     public void handleCreatingCategory(){
        String name = view.askUser("Category name:");
        this.categoryList.add(new ProductCategory(name));
    }

    public void displayAvailableProducts() {
        view.displayList(Product.getAllProduct());
        view.waitForAction();
    }

    public void handleAddingToBasket() {
        this.displayAvailableProducts();
        Integer product = Integer.valueOf(view.askUser("Which product would you like to add?(number)"));
        for(int i=0; i<Product.getAllProduct().size(); i++) {
            if(i == (product-1)) {
                this.basket.addProduct(Product.getAllProduct().get(i));
            }
        }
    }

    public void displayAllProductsInBasket() {
        view.displayList(basket.getProductList());
        view.waitForAction();
    }

    public void handleRemovingFromBasket() {
        this.displayAllProductsInBasket();
        Integer product = Integer.valueOf(view.askUser("Which product would you like to remove?(number)"));
        for(int i=0; i < basket.getProductList().size(); i++) {
            if(i == (product-1)) {
                this.basket.removeProduct(basket.getProductList().get(i));
            }
        }
    }
    public void handleDisplayingFromCategoty() {
        this.displayAvailableProducts();
        String categoryName = view.askUser("Category name:");
        view.displayList(Product.getAllProductBy(new ProductCategory(categoryName)));
        view.waitForAction();
    }

    public boolean handleCheckingIfAvailable() {
        String name = view.askUser("Product name:");
        for(int i=0; i<Product.getAllProduct().size(); i++) {
            if(name.equals(Product.getAllProduct().get(i).getName())) {
                view.printLine("There's such product");
                view.waitForAction();
                return true;
            } else {
                view.printLine("There's no such product");
                view.waitForAction();
                return false;
            }
        }
        return false;
    }

    public void handlePaying() {
        Order order = new Order();
        CheckoutProcess chekout = new CheckoutProcess();
        chekout.process(order);
        PaymentProcess pay = new PaymentProcess();
        pay.process(order);
        this.basket.clearProductList();
        view.printLine("You have paid.");
        view.waitForAction();
    }

    public static void main(String[] args) throws ParseException {
        String choice;
        
        Application app = new Application();
        

        do {
            app.view.clearScreen();
            app.view.printMenu();
            choice = app.view.askUser("\n\nWhat would you like to do ? (Choose number)");
            switch(choice) {
                case "1":
                    app.handleCreatingProduct();
                break;
                case "2":
                    app.handleCreatingCategory();
                break;
                case "3":
                    app.handleCreatingFeaturedCategory();
                break;
                case "4":
                    app.handleAddingToBasket();
                break;
                case "5":
                    app.displayAllProductsInBasket();
                break;
                case "6":
                    app.handleRemovingFromBasket();
                break;
                case "7":
                    app.displayAvailableProducts();
                break;
                case "8":
                    app.handleDisplayingFromCategoty();
                break;
                case "9":
                    app.handleCheckingIfAvailable();
                break;
                case "10":
                    app.handlePaying();
                break;
                case "11":
                    app.view.printLine("BYE BYE");
                break;
                default:
                    app.view.printLine("There's no such option");
            }
        } while(!choice.equals("11"));
	
    }
}
