Ticket Viewer displays tickets pertaining to the user whose id and password have been set.

Backend APIs, model and test cases are in Java.
Frontend has been built in Javascript.
Follow the steps mentioned at the bottom to run the development backend and frontend servers.

If the credentials are wrong or there are no tickets in your account, you'll be redirected to the home page with an alert message.
If the credentials are worng, please specify correct details using the steps mentioned at the bottom.
If there are no tickets, please add tickets to your account and then check using ticket viewer.

On accessing an unspecified URL, you'll be redirected to the home page.

Once you see a list of tickets, you can click on any ticket's 'view' button to view more details. If there are more than 25 tickets, you can scroll down to the bottom, to navigate through the pages using buttons provided.


**Set Authorization**
Make sure to go to Authentication.java:
```
set userId = "<User email address>"
set password = "<User password>"
```

**Run the tests**
Make sure to go to ticketsTest.java:
```
right click and run java
```

**Run the backend application and API**
Make sure to go to app.java:
```
right click and run java
```

***Run the frontend***
In the frontend directory:
```
npm run start
```