# Group 140 CSC207 project: Q/A forum

## Group members (alphabetical order by last name):

- Chihan Cui ([HermesCui](https://github.com/HermesCui))
- Qianjun Huang ([cang-xue](https://github.com/cang-xue))
- Liwei Yang ([Blair Yang](https://github.com/blairyeung))
- Jiawei Yu ([JY3150](https://github.com/JY3150))
- Gangquan Zhang ([jasongangquanzhang](https://github.com/jasongangquanzhang))
- Xiling Zhao ([Teinble](https://github.com/Teinble))
- Jiajie Zhu ([Christinjiajie](https://github.com/Christinjiajie))
- Yuyang Zhao ([NerverSoGoodStart](https://github.com/NeverSoGoodStart)) (***Dropped***)

## Delivery details
This ia a [link](https://utoronto-my.sharepoint.com/:p:/g/personal/scott_cui_mail_utoronto_ca/EaNCM-AuGAxLndhFiNJ-MIEBdH_ihSm2f20GNEqeOrXTew?e=fpbJAZ)
to our presentation file.
### Package Organization
Our code splitted the code into several compartments (packages), by clean architecture, being:
- Package `entities` contains all entity level classes 
- Package `database` contains all database-related classes 
- Package `use_cases` contains all use case level classes 
- Package `controllers` contains all controller classes 
- Package `presenter` contains all presenter classes 
- Package `UI` contains all UI level classes 
- Package `Exception` contains all exceptions
- Package `base` contains `Main` class

### Testing details
Our code has implemented the following test suites:
```
- CourseUsecaseInteractorTest
- UserUsecaseInteractorTest
- ReportUsecaseInteractorTest
```

### Use of GitHub Features
#### Issues 
- We used **issues** along with pull requests.
- Issues are addressed during discuss, and are resolved after suscessful
implementation.
- We also used issues to assign tasks to team members.


#### Pull Request
- We use **pull request** to discuss and determine whether the code is in good manner and
should be merged into Main.
- We also used it to perform code review to ensure code quality.
#### Auto Grading
- We used auto-grading to run the tests to ensure that our code is bug-free.

### Design patterns
We used the following design patterns in our project.
#### Observer pattern
Add ActionListener and MouseListener to the UI. When the user clicks the button, our program would use the
corresponding controller to call the functions related to that action.  For example, in `LoginForm`, when we click
`Login`, it will call `UserController` `loginUser` method without calling any other methods besides what methods are 
used in the `loginUser`.

#### Dependency injection
All of our posts are stored in some courses. But when we add a post to a course, we do not pass in relevant information 
and create a new post is inside of the course; rather, we pass in a post directly. This is also exhibited in posts and
comments. Additionally, in the database gateway, we need two `dataHandlers` to create a gateway, instead of creating 
those `dataHandlers` inside this `gateway`, we create them in Main class and inject them into the gateway.

#### Simple Factory Pattern *(not used)*
Since we have many report types, it makes more sense if we could have a Report factory responsible for creating 
various reports. We could use a simple factory pattern here to implement this in the future.

### Clean Architecture
- Our code follows a strict MVC Clean architecture, as mentioned in our slides.

### SOLID

- Single Responsibility Principle: 
\
Every class in our project has only one responsibility. Every non-attributive data
- Open and Closed Principle: 
\
Our project align with the principle, as the program is easily modifiable.
- Liskov Substitution Principle: 
\
Our subclasses do not alter the behavior of the general inherited behavior. Therefore, we can safely substitute objects of the super classes by the subclasses.
- Interface Segregation Principle:
\
We have specific interface for each task. The interfaces are small, concise.
- Dependency Inversion Principle: 
\
As long as the interface methods are implement correctly, our program runs without error.

# Introduction
YOU NEED TO DOWNLOAD THE JAVX.MAIL package. 


## 1. Entities

### 1.1 User.java

`User.java` is a class that is used to store the data of each individual user/administrator of the forum. It implements
the `Serializable` interface for serialization.

The user object has the following attributes:
* `username`
* `userid`
* `password`
* `email`

The entity provides interfaces for other functions to modify the username, password, and email. The userid, however,
is immutable once registration.
### 1.2 Course.java
Course.java is a class that is used to store the data of each specific course registrated on the forum.
\
The course object  has the following attributes:
* `name`
* `courseCode`
* `description`
* `instructors`
* `semester`
* `posts`

Most attributes for the course objects, once created, are immutable. The object only provides two
functions to add/remove students.
### 1.3 Post.java
Post.java is a class that is used to store the data of the posts in the forum. \
The posts has the following attributes:
* `topic`
* `texts`
* `comments`
* `user`
* `likedUser`
* `unlikedUser`

The post object, once created, are modifiable, and can be commented by other user objects. \
Some attributes, however, like the user who posted this thread, is immutable and viewable to everyone.
### 1.4 Comment.java
Comment.java is a class that used to store the data of each comment to a post.\
The posts has the following attributes.
* `texts`
* `comments`
* `user`

The comment object is very similar to a post. However, it must be attached to a post or another comment.
### 1.5 Report.java
Comment.java is a class that used to store the data of a report of a problem in a forum to be viewed and resolved by the administrator.\
The posts has the following attributes.
* `type`
* `content`
* `user`

All of the information of the Report object, once created, are immutable.
## 2. Use cases
### 2.1 Course use case
Course contains all relevant posts.
### 2.2 User use case
User can be registered with account name, password and email but not duplicate with other users.

There is verified_email feature, which can auto sent a random code email to the user. The verified code serves as the 
Random method to protect user accounts.
### 2.3 Post use case
Uses can post a Post under a course, and Post can contain the numbers of like and unlike, so that user can judge what 
the best relevant post is. 
### 2.4 Report use case
Administrator can send a report to modify some issue in the software.
## 3. Database
### 3.1 Data storage
We used three classes to handle the data, being `DatabaseDataHandler`, `RuntimeDataHandler`, and `DatabaseGateway`. \
\
The use cases andcontrollers interacts with `DatabaseGataway` to set, get, and edit the (non-attributive) data. \
\
`DatabaseGataway` implements three data interfaces, being 
`CourseDataInterface`, `UserDataInterface`, `ReportDataInterface`.
It has the following methods that could be called for data handling:
* `getAllUsers()`, `getAllCourses()`, `getAllReports()` \
Which fetches and returns all of the above data from the database.
* `getUser()`, `getCourse()`, `getPost()` \
Which gets the corresponding `user`, `course`, and `post` from their
`username`, `code`, and `title`, respectively, in ***O(1)***.
* `addUser`, `addReport`, `addCourse`
* `deleteUser`, `delete
### Use of data structure
The run-time data are stored in the `RuntimeDataHandler`, in the following way:
* `ArrayList<User> users`
* `ArrayList<Course> courses`
* `ArrayList<Report> reports `

The actual objects are stored in these `ArrayLists`. Furthermore, we
made use of `Hashmaps` to achieve a better `time-complexity`, and look up.
* `Hashmap name2User`
* `Hashmap email2User`
* `Hashmap code2Course`
* `Hashmap type2Report`

Using these `Hashmaps`, our database provides *O(1)* complexity for 
searching and fetching.

### Serialization
We serialized the data as a single object called 
`Hashmap<Integer, Object> Info`. The hashmap has the following structure.

| `key` | `value`     | `type`              | Serializable object | Non-native Attributes                   |
|-------|-------------|---------------------|---------------------|-----------------------------------------|
| `1`   | all users   | `ArrayList<User>`   | `User`              | `null`                                  |
| `2`   | all courses | `ArrayList<Course>` | `Course`            | `null`                                  |
| `3`   | all reports | `ArrayList<Report>` | `Report`            | `user`, `course`, `Arraylist<Comments>` |

## 4. Controllers

### 4.1 CourseController

CourseController can get the judgement from Course UseCase and return different integers to UI.
For example, there is three states in `removeInstructor`. The method will call course UseCase to judge the exception. 
- If return -1, it means not found the instructor in the courss.
- If return 1, it means successfully remove the instructor.

### 4.2 PostController
PostController can get the judgement from Post UseCase and return different integers to UI.
For example, there is three states in `editPost`. The method will call Post UseCase to judge the exception. 
- If return -1, it means not found the Post in the course
- If return 1, it means successfully edit the instructor.

### 4.3 ReportController
ReportController can get the judgement from Report UseCase and return different integers to UI.

### 4.4 UserController
UserController can get the judgement from User UseCase and return different integers to UI.
For example, there is three states in `registerUser`. The method will call User UseCase to judge the exception. If
return -6, which means the message contains email, otherwise return -1.
- if return -2, which means password is not correct.
- if return -3, which means is the error email format.
- if return -4, which means Wrong re-entered password !
- if return -5, which means wrong verification number.
- if return 1, which means successfully register.