Hello world, 


Current implementation is only able to display data from the DB, and do a GET request to each url in the DB when starting up the page. 
The 'Add new url' button does not work. 

Launch instructions: 
- clone source code 
- import datadump file to mysql in folder 'database'
- open source code in IDE (I use IntelliJ)
- edit database connection settings in src/main/java/com/krydb/persistence/UrlPersister.java
- Run App.java to launch backend server
- Run 'npm start' in commandline (from within KryDB/src/main/frontend) to start dev server
- launch page in browser: http://localhost:3000/



Missing MVP implementation: 
- Call poller method at regular interval while server is running 
- Handling of different types of http response status codes (currently only 200 is accepted, everything else is 'BAD')
- Add React implementation to 'Create new url' button and connect it to backend java code to persist to DB
- More test classes

Difficulties encountered: 
- Learning about and setting up basic connection between separate components: MySQL, Vertx, JSX, React
- Refining and customizing behavior between different components 
- Work computer has proxy and is often out of space (harddisk upgrade due)

Conclusion: 
I loved the project overall and learned a lot as I went. But I lack the fundamental knowledge of these different web technologies as I have done very limited web development before. It is however one of the first things that I am planning on expanding my knowledge on. For this assignment I felt a little pressed on time and didnt want to take too long to deliver. With more time I would have gone through each technology slower and completing several tutorials to get a better understanding of the fundamentals. But otherwise I found it to be a great introduction project. 


Best, 
Bernard
