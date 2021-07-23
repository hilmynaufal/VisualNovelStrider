package com.hirumi.visualnovelstrider.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hirumi.visualnovelstrider.model.dbstats.Item;
import com.hirumi.visualnovelstrider.network.SocketService;

import javax.inject.Inject;

//this viewmodel is not injected by dagger
public class SearchViewModel extends ViewModel {

    private String title = "";
    private String images_url = "";

    public SearchViewModel(Item item) {
        if (item != null) {
            this.title = item.getTitle();
            if (item.getImageFlagging().sexualAvg + item.getImageFlagging().violenceAvg != 0) {
                //TODO: nsfw image handling
            } else {
                this.images_url = item.getImage();
            }
        }
    }

    @Inject
    public SearchViewModel() {
    }

    @BindingAdapter({"imgUrl"})
    public static void loadimage(ImageView imageView, String images_url) {
        Glide.with(imageView.getContext())
                .load(images_url)
                .apply(RequestOptions.overrideOf(300))
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public void getData() {
//        socketService.sendMessage("get vn basic (id = 26414)");
//    }
}
