package com.codepath.apps.restclienttemplate.models;

import com.codepath.apps.restclienttemplate.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tweet {
    private static String createdAt;
    public String body;

    public User user;
    public long id;

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.id = jsonObject.getLong("id");

        return tweet;
    }
    public static List<Tweet> fromJsonArray (JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for(int i =0; i<jsonArray.length();i++){
            tweets.add(fromJson((jsonArray.getJSONObject(i))));
        }
        return tweets;
    }


    public String getFormattedTimestamp() {
        return TimeFormatter.getTimeDifference(createdAt);
    }
}
