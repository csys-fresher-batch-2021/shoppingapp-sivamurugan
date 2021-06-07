
# VEGETABLE SHOPPING APP 
#### Description :
      This project is a online vegetable shopping shop. By using this project customer can select required vegetables and can buy those project. To purchase vegetables user account required. user has to enter name, age, gender, email, username, password, mobile number and role(customer, salesman, admin). Customer can update mobile number, email and name. While purchasing user can use discount coupons for discount. This discount coupon is obtained when user purchases above 1000rs. While purchasing user has to enter delivery date, address, and payment method after entering these user has to click order now to confirm order.  
      After placing order salesman will deliver the order to the entered address. If customer is not found in the address, salesman can set the order status as hold. After sometime deliveryman can deliver the order again. If the order's delivery date is past then the status of order is set as expired. 
      Admin can view order details by entering username of customer, orders of a specific order date, orders of a specific delivery date, admin sort by status. Admin can view users, remove user by username, add vegetables with details of name, quantity and price, remove vegetables, and can view vegetable details.
## Validations
      1) Password must contain Uppercase, lowercase, number and special character
      2) Name should not contain numbers
      3) Customer can select delivery date only for 5 days in future
      4) Mobile number length should be 10
      5) Payment methods
            1) Net banking
            2) UPI Id
            3) Credit card
            4) Debit card
            5) Cash on delivery
### PURCHASE BY CUSTOMER
      1) This purchase requires login/ registration. 
      2) Customer can select and buy vegetables. 
      3) Price, Availability and amount of entered quantity is shown for customer. 
      4) Customer can select a specific delivery date. 
      5) Customer can pay through UPI ID, Credit card, Debit Card, Cash On Delivery, Net Banking 
      6) Customer can update personal details
### SALE BY SALESPERSON
      1) Sales Person can sell vegetables and mark as delivered or if customer cancels it he can mark as canceled
      2) Only Current date and pending deliveries will be shown in selling page. (Delivered / Canceled orders and other day deliveries will not be shown)
### ADMIN
      1) Admin can view order details by entering username, ordered date, delivery date and view all orders
      2) Admin can view registered users, admins and salespersons
      3) Admin can add vegetable, delete vegeatable by entering name of vegetable
      4) Admin can remove a customer by entering username of the user

## Important Points
      * Username is case sensitive (customer can use "Siva" as one customer and "siva" as another customer).
      * By view users feature admin can view customer's name, age, username, mobile number and email.
      * Delivery man can only view pending and holding orders of current delivery date. 
      * By view order details feature admin can view order's status, buyer's username, vegetable details, bill, ordered date and time, delivery date and payment method
