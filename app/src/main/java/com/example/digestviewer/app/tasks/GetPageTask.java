package com.example.digestviewer.app.tasks;

import com.example.digestviewer.app.network.Http;
import com.example.digestviewer.app.scheduler.Task;

/**
 * Created by SER on 25.08.2015.
 */
public class GetPageTask extends Task<String> {

    String url;

    public GetPageTask(String url) {
        this.url = url;
    }

    @Override
    public String doRequest() throws Exception {
        return Http.getInstance().getUrl(url);
    }
}
