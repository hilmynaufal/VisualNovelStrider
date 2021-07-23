package com.hirumi.visualnovelstrider.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.hirumi.visualnovelstrider.model.dbstats.Item;
import com.hirumi.visualnovelstrider.model.dbstats.Result;
import com.hirumi.visualnovelstrider.network.SocketService;
import com.hirumi.visualnovelstrider.viewmodel.SearchViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.inject.Inject;

public class VnRepository {
//    @Inject
//    public SocketClient socketClient;

    @Inject
    public SocketService socketService;

    private Result result;
    private String asw = "asw";
    private ArrayList<SearchViewModel> arrayList;
    private MutableLiveData<ArrayList<SearchViewModel>> mutableLiveData = new MutableLiveData<>();

    @Inject
    public VnRepository() {

    }

//    public MutableLiveData<Result> getMutableLiveData() {
//        String temp = socketService.getMutableLiveData().getValue();
//        Gson gson = new Gson();
//        mutableLiveData.setValue(gson.fromJson(temp.substring(7), Result.class));
//        return mutableLiveData;
//    }

    public MutableLiveData<ArrayList<SearchViewModel>> getAsw() {
        arrayList = new ArrayList<>();
        socketService.sendMessage("get vn basic,details (search~\"gyakuten saiban\")", new SocketService.Callback() {
            @Override
            public void onComplete(String s) {
                Gson gson = new Gson();

//                //testing
//                Log.e("asw", s);
//                String testJson = "{\"more\":false,\"num\":3,\"items\":[{\"image_flagging\":{\"sexual_avg\":0,\"violence_avg\":0,\"votecount\":12},\"id\":17,\"links\":{\"wikipedia\":\"Ever_17:_The_Out_of_Infinity\",\"renai\":null,\"wikidata\":\"Q954766\",\"encubed\":null},\"original\":null,\"orig_lang\":[\"ja\"],\"image_nsfw\":false,\"length\":4,\"released\":\"2002-08-29\",\"title\":\"Ever17 -The Out of Infinity-\",\"image\":\"https://s2.vndb.org/cv/60/24260.jpg\",\"languages\":[\"en\",\"es\",\"ja\",\"ru\",\"zh\"],\"platforms\":[\"win\",\"ios\",\"and\",\"psp\",\"ps2\",\"drc\",\"vnd\"],\"description\":\"Ever17 is the tale of seven individuals who become trapped 51 meters below the surface in the underwater marine theme park 'LeMU'. After an incident, almost half of LeMU becomes flooded, and the path to the surface and the communication lines are cut off. In addition, LeMU is under constant assault by severe water pressure, limiting time to find a means of escape to 119 hours. Escape is not the only concern, however; many questions arise as to the legitimacy of the accident and whether or not those trapped there were brought there for a purpose.\\n\\n[From [url=http://en.wikipedia.org/wiki/Ever_17:_The_Out_of_Infinity]Wikipedia[/url]]\",\"aliases\":\"Ever 17\\nEbaa Sebuntiin\\nエバー・セブンティーン\\nE17\"},{\"released\":\"2005-12-30\",\"image\":\"https://s2.vndb.org/cv/03/38903.jpg\",\"languages\":[\"ja\"],\"title\":\"Ever17 CrossOver Impression\",\"description\":\"Protagonist - the brother of Sara, Hokuto. \\nThe action takes place two months after the events of \\\"Ever17 ~the out of Infinity~\\\".\\nLife Takeshi returned to it's normal, peaceful course. In a quiet and measured life burst hot summer, however, is not bringing anything new in it.\\nHowever, this daily routine collapsed after a strange incident. It all started with the fact that in a nearby street, was found dead of a woman with signs of violent death. The air at the scene soaked unusual smell of rot ... from the decaying corpse. In the chest - a huge hole, and internal organs turned out. Strange murder suddenly roused harmonious life of the city. This event has attracted the attention of Sara, and she decided to conduct their own investigation. \\\"Why do not we organize a duet <Ninja and Detective> !?.\\\" This is the phrase Sara identified developments. So, the duo Ninja-Detective got its birth. In the process of searching for them will be new facts of this mysterious case, and then the secret will be revealed. What unites this event from the past and present heroes? ... It was a period of time, slightly changed the course of the boring summer vacation.\",\"platforms\":[\"win\"],\"aliases\":null,\"id\":3794,\"image_flagging\":{\"sexual_avg\":0,\"violence_avg\":0,\"votecount\":11},\"image_nsfw\":false,\"orig_lang\":[\"ja\"],\"length\":null,\"links\":{\"wikipedia\":null,\"renai\":null,\"wikidata\":null,\"encubed\":null},\"original\":null},{\"id\":19373,\"image_flagging\":{\"sexual_avg\":0,\"violence_avg\":0,\"votecount\":11},\"length\":4,\"image_nsfw\":false,\"orig_lang\":[\"ja\"],\"original\":null,\"links\":{\"encubed\":null,\"wikidata\":\"Q954766\",\"wikipedia\":\"Ever_17:_The_Out_of_Infinity\",\"renai\":null},\"released\":\"2011-12-01\",\"platforms\":[\"xb3\"],\"description\":\"Ever17 is the tale of seven individuals who come to be trapped 153 feet within the underwater marine theme park, LeMU. During an apparently normal day at the park, a massive accident happens, placing almost half of the facility underwater. The path to the surface and the communication lines are cut off. In addition, LeMU is under constant assault by severe water pressure, limiting time to find a means of escape to 119 hours. Escape is not the only concern, however; many questions arise as to the legitimacy of the accident and whether or not those trapped there were brought there for a purpose.\\n\\n[From [url=http://en.wikipedia.org/wiki/Ever_17:_The_Out_of_Infinity]Wikipedia[/url]]\\n\\n* Entirely rewritten scenario with shortened/swapped scenes (amount of Deus Ex Machina tragically increased)\\n* Extra happy-even-after-bad-end scenes\\n* Completely revoiced dialogs\\n* Few extra tunes (Faraway Lemuria and Aqua Stripe are gone)\\n* 3D models instead of character sprites\\n* Cropped 16:9 CGs instead of original 4:3 with addition of several moe/school life comedy images\\n* Redesigned room/LeMU layout (new Control Center room, no more Cosmic Whale room, etc.)\",\"aliases\":\"エバー・セブンティーン\",\"image\":\"https://s2.vndb.org/cv/35/29335.jpg\",\"languages\":[\"ja\"],\"title\":\"Ever17\"}]}";
//                Result resulttest = gson.fromJson(testJson, Result.class);
//                Log.e("asw", resulttest.getItems().get(0).getTitle());

                int delimiter = s.indexOf("{");
                result = gson.fromJson(s.substring(delimiter), Result.class);
                ArrayList<Item> items = result.getItems();
                for (int i = 0; i < items.size(); i++) {
                    Item item = items.get(i);
                    SearchViewModel searchViewModel = new SearchViewModel(item);
                    arrayList.add(searchViewModel);
                    mutableLiveData.postValue(arrayList);
                }
            }
        });
        return mutableLiveData;
    }

//    public void getData() {
//        socketService.sendMessage("get vn basic (id = 17)", new SocketService.Callback() {
//            @Override
//            public void onComplete(String s) {
//                Log.d("asw", s);
//                Gson gson = new Gson();
//                int delimiter = s.indexOf("{");
//                Result result = gson.fromJson(s.substring(delimiter), Result.class);
//                SearchViewModel searchViewModel = new SearchViewModel(result);
//                mutableLiveData.postValue(searchViewModel);
//            }
//        });
//    }
}
