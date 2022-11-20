# Group 140 CSC207 project: Q/A forum
## Group members (alphabetical order by last name):
Chihan Cui(HermesCui), Qianjun Huang(cang-xue), Liwei Yang(Blair Yang), Jiawei Yu(JY3150),  Gangquan Zhang(jasongangquanzhang), Xiling Zhao(Teinble), Yuyang Zhao(NerverSoGoodStart), Jiajie Zhu(Christinjiajie)
### Task assignment
# Project introduction
## 1. Entities
### 1.1 User.java
User.java is a class that is used to store the data of each individual user/administrator of the forum. \
\
The user object has the following attributes:
* username
* userid
* password
* email

The entity provides interfaces for other functions to modify the username, password, and email. The userid, however,
is immutable once registration.
### 1.2 Course.java
Course.java is a class that is used to store the data of each specific course registrated on the forum.
\
The course object  has the following attributes:
* course name
* course code
* course description
* semester offering
* course instructor(s)
* students

Most attributes for the course objects, once created, are immutable. The object only provides two
functions to add/remove students.
### 1.3 Post.java
Post.java is a class that is used to store the data of the posts in the forum. \
The posts has the following attributes:
* topic
* texts
* images
* comments
* posted by which user

The post object, once created, are modifiable, and can be commented by other user objects. \
Some attributes, however, like the user who posted this thread, is immutable and viewable to everyone.
### 1.4 Comment.java
Comment.java is a class that used to store the data of each comment to a post.\
The posts has the following attributes.
* texts
* images
* comments
* posted by which user

The comment object is very similar to a post. However, it must be attached to a post or another comment.
### 1.5 Report.java
Comment.java is a class that used to store the data of a report of a problem in a forum to be viewed and resolved by the administrator.\
The posts has the following attributes.
* report type
* content
* posted by which user

All of the information of the Report object, once created, are immutable.
## 2. Use cases
### 2.1 Course use case
The course use case provides interface to create, modify, and delete course information. It has following functions:
* addCourse()
Function **addCourse()** takes in the course information and attempt to create the course and 
return *true*. If the course already exist, do nothing and return *false*. 


* modifyCourse()
Function **modifyCourse()** takes in the course information and attempt to modify the course and
  return *true*. If the course does not exist, do nothing and return *false*.


* deleteCourse()
Function **deleteCourse()** takes some in the course information and attempt to create the course and
  return *true*. If the course information does not match, do nothing and return *false*.

### 2.2 Login use case
### 2.3 User use case
### 2.4 Post use case
### 2.5 report use case

## 3. Controllers
## 4. Graphical User Interface
### Figure 1.1 Login InterFace
![](ScreenShot/LoginForm.png)

This is the First interface showed when opening the project 
The User should enter Their **UserName**, their **Password** and press
.Then they need to press **Login** to Enter to the CoursesPage

If they don't have any account yet, then press **Register** to enter the RegisterPage.

### Figure 1.2 Register InterFace
![](ScreenShot/RegisterForm/RegisterAUser.png)

After click **Register** and enter the RegisterPage. Then user should fill 
the first four information into the TextField, including enter Username, Password and Re-EnterPassword

After Enter the Email, then click **Send Verification**, Then, it will check 
whether the entered email is valid or no. If valid, the label under the **Send Verification**
would have text and tell user an email contain verification code have already send email to the given email.
If the verification code match with the sending code, then the user account would be created and go back to the 
LoginPage. Otherwise, an error message would raise.

### Figure 2.1 Courses Page
![](ScreenShot/MainForm(showingContent)/CoursesForm.png)
After Login successfully from Login Page, then entered to the courses page. 
In the left panel of the page, it shows all the courses with their titles stored in the system.
Click one of the courses, the description of the course would appear on the right. 

To see all posts in the chosen course, click **Show all Posts** to enter the Postpage. 

If there are any problem of the courses, click **Report this Course** to enter the ReportPage.


In this page, User could click the top left button, **Register A new Course** and go to the MakeACourse Page.




### Figure 2.2 Post Page
![](ScreenShot/MainForm(showingContent)/PostForm.png)

In this page, 
In the top left of the page, it shows this is the posts page of the chosen course.

In the left panel of the page, it shows all the posts in the course. 

Click one of the post, the information of that post would appear on the right.

To see all comments in the chosen course, click **Show all Posts** to enter the Postpage.

If user want to do more discussion, they could click **Comment this Post** button to go to **CommentPage**

If there are any problem of the posts, click **Report this post** to enter the ReportPage.


In this page, User could click the top button, **Post a Post** and go to the MakeAPost Page.

### Figure 2.3 Comments Page
![](ScreenShot/MainForm(showingContent)/CommentsForm.png)

In this page,
In the top left of the page, it shows this is the comments page of the chosen post or comment.

In the left panel of the page, it shows all the comments with their title in post/comment.

Click one of the comment, the information of that comment would appear on the right.

If user want to do more discussion, they could click **Comment this Post** button to go to **CommentPage**

If there are any problem of the comment, click **Report this Comment** to enter the ReportPage.


In this page, User could click the top button, **Back to upper-level** and go to the MakeAPost Page.


### Figure 3.1 Register A Course
![](ScreenShot/RegisterForm/MakeACourse.png)

User enter all needed information and select the "Fall", "Winter", "Summer"
from the Semester ComboBox. 

After filled all information, usr could click the **Register the Course** to register the Course
and go back to CoursePage.

If user want to skip register the course, they also could go back to CoursePage by click **Back to the Course Page** 


### Figure 3.2 Make A Post
![](ScreenShot/RegisterForm/MakeAPost.png)

User enter all needed information for a post. In the top label, it shows it is under which course in the top label

After filled all information, usr could click the **Post the post** to register the Course
and go back to CoursePage.

User also could choose post as the username or anonymous by selecting the comboButtons.

If user want to skip Make the Post, they also could go back to PostPage by click **Back to the Course Page** 


### Figure 3.3 Make A Comment
![](ScreenShot/RegisterForm/MakeAComment.png)

User enter all needed information for a comment. In the top label, it shows it is under which post/comment the top label

After filled all information, usr could click the **Make the comment** to make a commment
and go back to PostPage/CommentPage.

User also could choose post as the username or anonymous by selecting the comboButtons.


If user want to skip make the comment, they also could go back to PostPage by click **Back to the Course Page** 



### Figure 3.4 Make A Report
![](ScreenShot/RegisterForm/MakeAReportUI.png)

User enter all needed information for a report. In the top label, it shows it is under which course/post/comment the top label

After filled all information, usr could click the **Report** to send the report
and go back to CoursePage.

User also could choose post as the username or anonymous by selecting the comboButtons.


If user want to skip register the course, they also could go back to CoursePage by click **Back to the Course Page** 


### 4.1 Profile Page
![](ScreenShot/ProfilePage.png)

This page shows all profile information related to the user.

Moreover, it support edit the username by clicking
**Edit**.

Also, it could change the password by clicking **Change Password**.

User can go back to the main page **Back to Main Page** by clicking button. 


### Figure 4.2 Change Password
![](ScreenShot/ChangePassWordForm.png)

If user doesn't feel good about their password, they just typing the OldPassword
and enter twice of their NewPassword. After click **Change Password**, if all
password are valid. Then the Password would be reset and return to the profile page.

If user doesn't want to change, they also can go back by clicking the **Back to Profile Page**

