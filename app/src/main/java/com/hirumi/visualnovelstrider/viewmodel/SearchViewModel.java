package com.hirumi.visualnovelstrider.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hirumi.visualnovelstrider.model.dbstats.Item;
import com.hirumi.visualnovelstrider.network.SocketService;

import java.util.ArrayList;

import javax.inject.Inject;

//this viewmodel is not injected by dagger
public class SearchViewModel extends ViewModel {

    private String title = "";
    private String images_url = "";
    private String released = "";
    private Double rating = 0.0;

    //TODO route branching tags
    private boolean isKineticNovel = false;
    private boolean hasMultipleEndings = false;
    private boolean linearPlot = false;
    private boolean moreThanSevenEndings = false;
    private boolean brancingPlot = false;

    private ArrayList<String> languages = new ArrayList<>();

    public SearchViewModel(Item item) {
        if (item != null) {
            this.title = item.getTitle();

            //TODO nsfw image handling
            this.images_url = item.getImageFlagging().sexualAvg + item.getImageFlagging().violenceAvg != 0 ? "" : item.getImage();

            this.rating = item.getRating();
            this.released = item.getReleased();
            this.languages = item.getLanguages();
        }
    }

    @BindingAdapter({"imgUrl"})
    public static void loadimage(ImageView imageView, String images_url) {
        Glide.with(imageView.getContext())
                .load(images_url)
                .into(imageView);
    }

    public String imgUrl() {
        return images_url;
    }

//    public MutableLiveData<SearchViewModel> getMutableLiveData() {
//        Gson gson = new Gson();
//        Result result;
////        if (!socketService.getMutableLiveData().getValue().equals("")) {
////            result = gson.fromJson(socketService.getMutableLiveData().getValue().substring(7), Result.class);
////        } else {
////            result = new Result();
////        }
//        if (socketService.getMutableLiveData().getValue().equals("")) {
//            Item item;
//            item = null;
//            SearchViewModel searchViewModel = new SearchViewModel(item);
//            mutableLiveData.setValue(searchViewModel);
//        } else {
//            result = gson.fromJson(socketService.getMutableLiveData().getValue().substring(7), Result.class);
//            SearchViewModel searchViewModel = new SearchViewModel(result);
//            mutableLiveData.setValue(searchViewModel);
//        }
//        return mutableLiveData;
//    }

//    public void getData() {
//        socketService.sendMessage("get vn basic (id = 26414)");
//    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }
}
