Project Overview
This E-commerce System is a console-based Java application designed to simulate a shopping experience. The system includes:

Management of products with various attributes such as expiry, shippability, and weight.
Shopping cart functionality that enforces quantity limits based on stock.
Checkout process with calculated totals, shipping costs, and balance deductions.
Integration with a ShippingService for shipping eligible items.
Features
Product Management:

Define products with attributes:
Name, price, and quantity.
Expiry (applicable to certain products like cheese and biscuits).
Shipping requirements (some products require weight if shippable).
Products can be categorized into:
Expiring and Non-Expiring products.
Shippable and Non-Shippable products.
Cart Management:

Add products to a cart with a specific quantity (not exceeding stock availability).
Validate stock availability and expiry before checkout.
Checkout Process:

Calculate and display:
Order subtotal (sum of all item prices in the cart).
Shipping fees (based on the weights of shippable items).
Total paid amount (subtotal + shipping fees).
Customer's updated balance after payment.
Handle error scenarios:
Cart is empty.
Insufficient customer balance.
Stock or expired product issues.
Shipping Service:

Collect all shippable items and send them to a ShippingService.
The ShippingService accepts items implementing a Shippable interface containing:
String getName()
double getWeight()
Tech Stack
Programming Language: Java
Build Tool: Maven (optional)
Testing Framework: JUnit
IDE: IntelliJ IDEA or Eclipse
System Design
Class Structure
Product (Base Class)

Attributes: name, price, quantity.
Abstract methods: boolean isExpired() (implemented by subclasses).
Shippable Interface

Methods: String getName(), double getWeight().
Subclasses of Product:

ExpiringProduct:
Example: Cheese, Biscuits.
Attributes: expiryDate.
NonExpiringProduct:
Example: TV, Mobile.
ShippableProduct:
Adds weight attribute for products requiring shipping.
Customer:

Attributes: name, balance.
Cart:

Manages CartItem objects (product and quantity pairs).
Methods:
add(Product product, int quantity)
remove(Product product)
getItems() (returns a list of products in the cart).
ShippingService:

Method: void processShipping(List<Shippable> items).
CheckoutService:

Handles the checkout process:
Calculates subtotal, shipping fees, total amount, and validates the cart.
How to Run
Pre-Requisites
Install Java 17 or higher.
Set up your IDE (IntelliJ IDEA, Eclipse, etc.).
(Optional) Install Maven for dependency management.
Setup
Clone the repository:
bash
نسخ الكود
git clone https://github.com/your-username/ecommerce-system.git
cd ecommerce-system
Run the main application:
java
نسخ الكود
public static void main(String[] args) {
    // Sample Data
    Customer customer = new Customer("John", 500);
    Product cheese = new ExpiringProduct("Cheese", 100, 10, LocalDate.now().plusDays(5));
    Product tv = new ShippableProduct("TV", 300, 5, 20.5);
    Product scratchCard = new NonExpiringProduct("Mobile Scratch Card", 50, 100);

    Cart cart = new Cart();
    cart.add(cheese, 2);
    cart.add(tv, 1);
    cart.add(scratchCard, 1);

    CheckoutService checkoutService = new CheckoutService();
    checkoutService.checkout(customer, cart);
}
Assumptions
Products that expire will have an expiry date checked during checkout.
Shipping fees are calculated as $10 per kg for shippable items.
Customers must maintain sufficient balance for payment, including shipping fees.
Empty cart or expired products will block the checkout process.
Example Console Output
text
نسخ الكود
** Shipment Notice **
2x Cheese (Weight: 400g)
1x TV (Weight: 20.5kg)
Total package weight: 20.9kg

** Checkout Receipt **
2x Cheese @ $100 each = $200
1x TV @ $300 each = $300
1x Mobile Scratch Card @ $50 each = $50
----------------------------------------
Subtotal: $550
Shipping: $209
Total Paid: $759
Remaining Balance: $0
Testing
Unit Tests
Test adding products to the cart.
Test invalid scenarios like:
Adding quantities exceeding available stock.
Checkout with an empty cart.
Insufficient customer balance.
Validate shipping weight calculations.
Sample Test Case
java
@Test
void testCheckoutWithValidCart() {
    Customer customer = new Customer("John", 1000);
    Product cheese = new ExpiringProduct("Cheese", 100, 10, LocalDate.now().plusDays(5));
    Product tv = new ShippableProduct("TV", 300, 5, 20.5);

    Cart cart = new Cart();
    cart.add(cheese, 2);
    cart.add(tv, 1);

    CheckoutService checkoutService = new CheckoutService();
    checkoutService.checkout(customer, cart);

    assertEquals(470, customer.getBalance());
}
Future Enhancements
Add a user-friendly UI (web or mobile-based) with frameworks like React or Angular.
Implement a database (e.g., MySQL) for product persistence.
Add payment gateways for online payments.
Add promotions or discount codes for checkout.
