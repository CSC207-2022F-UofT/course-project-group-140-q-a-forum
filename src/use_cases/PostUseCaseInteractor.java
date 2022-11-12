package use_cases;
import entities.Post;
import entities.PostInfo;
import use_cases.DataBaseAccess.PostDataInterface;

public class PostUseCaseInteractor {

    final PostDataInterface postDataInterface;

    public PostUseCaseInteractor(PostDataInterface postDataInterface) {
        this.postDataInterface = postDataInterface;
    }

    /**
     * Post a post using the given information.
     * If the post can be succesfully posted, create such entity and return Ture
     * If the process cannot be completed, return False
     * @param information
     * @return boo
     */

    public boolean createPost(PostInfo information){

        boolean boo = false;
        return boo;
    }

    /**
     * Edit the given post using the post information.
     * Return true is the post can be edited, and false otherwise.
     * @param post
     * @param info
     * @return boo
     */

    public boolean editPost(Post post, PostInfo info){
        boolean boo = false;
        return boo;
    }
}