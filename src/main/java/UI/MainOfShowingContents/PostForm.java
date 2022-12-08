package UI.MainOfShowingContents;

import Presenter.GeneralPresenter;
import UI.PostingStuff.MakeAComment;
import UI.PostingStuff.MakeAPost;
import UI.PostingStuff.MakeAReport;
import UI.UserdataRelated.ProfilePage;
import base.main;
import controllers.CourseController;
import controllers.PostController;
import entities.Course;
import entities.Post;
import entities.User;

import java.util.ArrayList;

/**
 *
 * @author zhaoxiling
 */
public class PostForm extends javax.swing.JFrame {
    private final User user;
    private final Course course;

    private Post viewPost = null;
    private final CourseController courseController = main.courseController;
    private final PostController postController = main.postController;
    /**
     * Creates new form PostForm
     */
    public PostForm(User user, Course course) {
        this.user = user;
        this.course = course;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    jList2 = new javax.swing.JList();
        javax.swing.JPanel jPanel7 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
    nameLabel = new javax.swing.JLabel();
    descriptionLabel = new javax.swing.JLabel();
        javax.swing.JButton showcommentButton = new javax.swing.JButton();
        javax.swing.JButton reportButton = new javax.swing.JButton();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
    authorLabel = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JButton commentButton = new javax.swing.JButton();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    commentNumberLabel = new javax.swing.JLabel();
    reputationLabel = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
    likesLabel = new javax.swing.JLabel();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JRadioButton dislikeButton = new javax.swing.JRadioButton();
        javax.swing.JRadioButton likeButton = new javax.swing.JRadioButton();
        javax.swing.JButton checkProfileButton = new javax.swing.JButton();
        javax.swing.JButton backButton = new javax.swing.JButton();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel userNameLabel = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel courseNameLabel = new javax.swing.JLabel();
        javax.swing.JButton postButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList2.setBorder(javax.swing.BorderFactory.createTitledBorder("List of All Posts"));

        jList2.setModel(new javax.swing.AbstractListModel() {
            final String[] strings = courseController.getAllPostTitles(course).toArray(new String[0]);
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });

        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jList2MouseClicked();
        }
    });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Post Information"));

        jLabel8.setText("topic:");

        nameLabel.setText("Name of the Course");

        descriptionLabel.setText("Post Content");

        showcommentButton.setText("Show All Comments");
        showcommentButton.addActionListener(this::showCommentButtonActionPerformed);

        reportButton.setText("Report this Post");
        reportButton.addActionListener(this::reportButtonActionPerformed);

        jLabel9.setText("Author Name:");

        authorLabel.setText("Name of Author");

        jLabel2.setText("Post Content:");

        commentButton.setText("Comment on this Post");
        commentButton.addActionListener(this::commentButtonActionPerformed);

        jLabel3.setText("Number of Comments:");

        commentNumberLabel.setText("Number of Comments");

        reputationLabel.setText("reputation");

        jLabel7.setText("Like number:");

        likesLabel.setText("Number of Likes");


        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(dislikeButton);
        dislikeButton.setText("DisLike");
        dislikeButton.addActionListener(this::dislikeButtonActionPerformed);

        buttonGroup1.add(likeButton);
        likeButton.setText("Like");
        likeButton.addActionListener(this::likeButtonActionPerformed);


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(likeButton)
                    .addComponent(dislikeButton))
            .addContainerGap())
            );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(likeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dislikeButton)
                .addContainerGap())
            );

        checkProfileButton.setText("check Profile");
        checkProfileButton.addActionListener(this::checkProfileButtonActionPerformed);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nameLabel)
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addComponent(authorLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(reputationLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(checkProfileButton))
                                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(46, 46, 46))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jLabel3))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(commentNumberLabel)
                                                                        .addComponent(likesLabel)))
                                                        .addComponent(showcommentButton, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(commentButton)
                                                .addGap(214, 214, 214))))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(reportButton)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(nameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(authorLabel)
                                        .addComponent(reputationLabel)
                                        .addComponent(checkProfileButton))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel2))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(commentNumberLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(likesLabel))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(showcommentButton)
                                        .addComponent(commentButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addComponent(reportButton)
                                .addGap(21, 21, 21))
        );

        backButton.setText("Back to Courses Page");
        backButton.addActionListener(this::backButtonActionPerformed);

        jLabel1.setText("User:");

        userNameLabel.setText(this.user.getUsername());

        jLabel4.setText("Course:");

        courseNameLabel.setText(this.course.getName());

        postButton.setText("Post a Post");
        postButton.addActionListener(this::postButtonActionPerformed);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(courseNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userNameLabel)
                        .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jList2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backButton))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(postButton)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 94, Short.MAX_VALUE))))
            );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userNameLabel)
                    .addComponent(jLabel4)
                    .addComponent(courseNameLabel))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(postButton))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jList2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
            );
    pack();
}

    private void showCommentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(this.viewPost==null){
            GeneralPresenter.showNotSelectError("Post");
        }
        else {
            CommentsForm commentsForm = new CommentsForm(user, course, viewPost);
            commentsForm.setVisible(true);
            this.setVisible(false);
        }
    }

    private void commentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.viewPost == null) {
            GeneralPresenter.showNotSelectError("Post");
        } else {
            MakeAComment makeAComment = new MakeAComment(user, course, viewPost);
            makeAComment.setVisible(true);
            this.setVisible(false);
        }
    }

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.viewPost == null) {
            GeneralPresenter.showNotSelectError("Post");
        } else {
            MakeAReport makeAReport = new MakeAReport(this.user, this.course, viewPost);
            makeAReport.setVisible(true);
            this.setVisible(false);
        }
    }

    private void postButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<Post> posts = courseController.getAllPosts(this.course.getCode());
        MakeAPost makeAPost = new MakeAPost(user, course, posts);
        makeAPost.setVisible(true);
        this.setVisible(false);
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<Course> courses = courseController.getAllCourses();
        CoursesForm coursesForm = new CoursesForm(user, courses);
        coursesForm.setVisible(true);
        this.setVisible(false);

    }

    private void jList2MouseClicked(){
        int chosenPostIndex = jList2.getSelectedIndex();
        if (chosenPostIndex == -1){
            GeneralPresenter.showNotSelectError("Post");
        }
        else {
            ArrayList<Post> posts = courseController.getAllPosts(this.course.getCode());
            Post selectPost = posts.get(chosenPostIndex);
            this.viewPost = selectPost;
            changePanel(selectPost);
        }
    }

    private void changePanel(Post post){
        nameLabel.setText(post.getTopic());
        authorLabel.setText(post.getPostedBy().getUsername());
        //descriptionLabel.setText("fajowefpoajwpo");
        descriptionLabel.setText("<html>"+post.getTexts()+ "</html>");
        String numberComments = String.valueOf(viewPost.getComments().size());
        commentNumberLabel.setText(numberComments);
        likesLabel.setText(String.valueOf(post.getLikeNumber()));
        reputationLabel.setText(post.getPostedBy().getReputation());
        buttonGroup1.clearSelection();
    }

    private void checkProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(this.viewPost==null){
            GeneralPresenter.showNotFoundError("Post");
        }else {
            ProfilePage profilePage = new ProfilePage(this.user, viewPost.getPostedBy(), this.course, this.viewPost);
            profilePage.setVisible(true);
            this.setVisible(false);
        }
    }

    private void likeButtonActionPerformed(java.awt.event.ActionEvent evt) {
       if(this.viewPost==null){
           GeneralPresenter.showNotFoundError("Post");
       }else{
           int result = postController.likePost(viewPost, this.user);
           if(result == -1){
               GeneralPresenter.showDuplicateLikeError("like");
           }else{
               likesLabel.setText(String.valueOf(viewPost.getLikeNumber()));
           }
       }

    }

    private void dislikeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(this.viewPost==null){
            GeneralPresenter.showNotFoundError("Post");
        }else {
            int result = postController.dislikePost(viewPost, this.user);
            if (result == -1) {
                GeneralPresenter.showDuplicateLikeError("dislike");
            } else {
                likesLabel.setText(String.valueOf(viewPost.getLikeNumber()));
            }
        }
    }

    private javax.swing.JLabel authorLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel likesLabel;
    private javax.swing.JLabel commentNumberLabel;
    private javax.swing.JLabel reputationLabel;
    private javax.swing.JList jList2;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration
}
