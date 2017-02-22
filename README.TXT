
****** Guideline for run the project ******
Run on Chrome browser for better experince. 

Database
create DB schema : nycsports
 username : root
 Password : “”

Click Run on server
Sample data load : sql query file will insert some data when load the project. 

Functionalities 
Click product for buy ,Then load login page

Admin credential : username : admin , password : admin 
Admin can add / delete member 
If  new user then click create new nyc account on login page and fill details 

Check internationalization 

Member
Member credential : username : guest , password : guest 
Member can search product by category on home page
Click Detail of a product and go to product detail 
Click Order after fill quantity text box. 
If quantity if not number then show ajax error message 
If quantity is number when click order button then item will be added in cart by Ajax call
Click view cart and remove some items 

Advertisment 
click advertisment item on cart page and add quantity. Then cart will be updated at the same time by Ajax. 

Continue by clicking check out button
When click checkout button Interceptor will get username from security and load user address and set to customer billing address and load customer entry page. 
re type Zipcode only numbers in order to pass validation error.

Then Order will continue as session and load shipping entry form 
Then system load credit card form . 
Creditcard constraint validate credit card number by checking database value.
 Credit Card number work only below number 
1111222233334444
Then Order will save in database and load thank you page and show order number and shipping date. 

Product can be search by categories on home page

