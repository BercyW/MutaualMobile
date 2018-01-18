package security.bercy.com.week5weekendmutaualmobile.baseUtils;

/**
 * Created by Bercy on 1/17/18.
 */

public interface BasePresenter<V extends BaseView>{
    void attachView(V view);
    void detachView();
}
