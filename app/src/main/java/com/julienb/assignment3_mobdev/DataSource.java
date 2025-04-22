package com.julienb.assignment3_mobdev;

import java.util.ArrayList;

public class DataSource {

    private static ArrayList<CartEntry> cart= new ArrayList();

    // setting up autobiography menu items
    public static ArrayList<Book> getAutobiography(){

        ArrayList<Book> autobiography= new ArrayList();
        autobiography.add(new Book("Steve Jobs","Steve Jobs", "Steve Jobs is the authorized self-titled biography of American business magnate and Apple co-founder Steve Jobs", "10.00", "steve_jobs"));
        autobiography.add(new Book("Autobiography of a Yogi","Paramahansa Yogananda" ,"Autobiography of a Yogi is at once a beautifully written account of an exceptional life and a profound introduction to the ancient science of Yoga","11.00", "yogi_autobiography"));
        autobiography.add(new Book("Long Walk to Freedom", "Nelson Mandela","Autobiography credited to South African President Nelson Mandela", "12.00", "long_walk_to_freedom"));
        autobiography.add(new Book("The Autobiography of Benjamin Franklin", "Benjamin Franklin","The Autobiography of Benjamin Franklin is the traditional name for the unfinished record of his own life written by Benjamin Franklin from 1771 to 1790", "13.00", "autobiography_benjamin"));
        return autobiography;
    }
    // setting up Fiction menu items
    public static ArrayList<Book> getFiction(){

        ArrayList<Book> fiction= new ArrayList();
        fiction.add(new Book("To Kill a Mockingbird", "Harper Lee","A Pulitzer Prize-winning novel set in the 1930s, it tells the story of a young girl named Scout Finch and her father, a lawyer named Atticus Finch", "22.10", "to_kill_a_mockingbird"));
        fiction.add(new Book("The Great Gatsby","F. Scott Fitzgerald ", "Set in the roaring 20s, it tells the story of a mysterious and wealthy man named Jay Gatsby who throws extravagant parties to win back his lost love, Daisy Buchanan.", "18.20", "the_great_gatsby"));
        fiction.add(new Book("Brave New World", "Aldous Huxley","Another dystopian novel, set in a world where people are genetically engineered and conditioned to conform to a strict social hierarchy.", "20.30", "brave_new_world"));
        fiction.add(new Book("The Catcher in the Rye", "J.D. Salinger","A coming-of-age story that follows the rebellious and alienated teenager Holden Caulfield as he navigates his way through adolescence.", "21.30", "the_cather_in_the_rye"));
        return fiction;
    }
    // setting up Comics menu items
    public static ArrayList<Book> getComics(){
        ArrayList<Book> comics= new ArrayList();
        comics.add(new Book("Watchmen", "Alan Moore and Dave Gibbons","A graphic novel that explores the complex themes of power, morality, and humanity through the lens of a group of retired superheroes investigating a murder.", "15.10", "watch_men"));
        comics.add(new Book("Batman", "Frank Miller","A dark and gritty comic that imagines a future in which an older Bruce Wayne returns to the role of Batman to fight crime and corruption in a deteriorating Gotham City.", "13.20", "batman"));
        return comics;
    }
    // setting up SelfHelp books menu items
    public static ArrayList<Book> getSelfHelpBook(){

        ArrayList<Book> selfHelp= new ArrayList();
        selfHelp.add(new Book("The 7 Habits of Highly Effective People", "Stephen R. Covey","his book presents seven habits that can help individuals become more productive and successful in their personal and professional lives.", "6.10", "habit"));
        selfHelp.add(new Book("How to Win Friends and Influence People", "Dale Carnegie","A classic self-help book that provides tips and strategies for improving interpersonal communication and building strong relationships.", "5.80", "friends"));
        selfHelp.add(new Book("Think and Grow Rich", "Napoleon Hill","A motivational book that outlines the steps individuals can take to achieve financial success and abundance.", "4.70", "think_grow"));
        return selfHelp;
    }

    public static String[] getBookNames(ArrayList<Book> menuList){
        String[] bookNames = new String[menuList.size()];
        // Just loop through each menu item and returning an array of names
        for (int i = 0; i < menuList.size(); i++){
            bookNames[i] = menuList.get(i).name;
        }
        return bookNames;
    }

    public static Book getItemDetailsByName(ArrayList<Book> menuList, String itemName){
        Book itemRequested = null;
        // Looping through each menu items
        for (Book book : menuList) {
            // If we find the item requested, we break the loop and return it
            if (book.name.equals(itemName)) {
                itemRequested = book;
                break;
            }
        }
        return itemRequested;
    }

    public static void addToCart(Book book, int quantity){
        for (int i = 0; i < cart.size(); i++) {
            // Checking if we already added that item to the cart
            if(cart.get(i).name.equals(book.name)){
                cart.get(i).quantity+=quantity;
                return;
            }
        }
        // If nothing has been found (no return) then we add the item to the cart
        cart.add(new CartEntry(book.name, quantity, book.price));
    }

    // Calculating the cart total
    public static Double getCartTotal(){
        Double total = 0.0;
        for (CartEntry cartEntry : cart) {
            total += cartEntry.quantity * Double.parseDouble(cartEntry.price);
        }
        return total;
    }

    public static ArrayList<CartEntry> getCart(){
        return cart;
    }

    public static void clearCart(){
        cart.clear();
    }

}
