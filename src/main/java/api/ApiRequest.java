package api;

import api.models.ResponseModelJson;
import api.models.User;
import api.models.Post;
import aquality.selenium.core.logging.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static utils.ApiUtils.sendGetRequest;
import static utils.ApiUtils.sendPostRequest;
import static utils.ConfigUtils.getSettingsDataString;
import static utils.JsonUtils.deserializationObject;


public class ApiRequest {
    public static ResponseModelJson RESPONSE_JSON = null;
    private final static String POSTS_POSTFIX = "posts";
    private final static String USERS_POSTFIX = "users";
    private final static String BASE_HTTP = getSettingsDataString("http");

    public static Post getJsonPerson(int number) {
        RESPONSE_JSON = sendGetRequest(BASE_HTTP, String.format("%s/%d", POSTS_POSTFIX, number));
        Post person = null;
        try {
            person = new ObjectMapper().readValue(RESPONSE_JSON.getBody().toString(), Post.class);
        } catch (IOException e) {
            Logger.getInstance().debug("Doesn't get Json File 'Person'");
            e.printStackTrace();
        }
        return person;
    }

    public static Post[] getJsonPersons() {
        RESPONSE_JSON = sendGetRequest(BASE_HTTP, POSTS_POSTFIX);
        Post[] persons = null;
        try {
            persons = new ObjectMapper().readValue(RESPONSE_JSON.getBody().toString(), Post[].class);
        } catch (IOException e) {
            Logger.getInstance().debug("Doesn't get Json File 'Person'");
            e.printStackTrace();
        }
        return persons;
    }

    public static User getJsonUser(int number) {
        RESPONSE_JSON = sendGetRequest(BASE_HTTP, USERS_POSTFIX + "/" + number);
        User userModel = null;
        try {
            userModel = new ObjectMapper().readValue(RESPONSE_JSON.getBody().toString(), User.class);
        } catch (IOException e) {
            Logger.getInstance().debug("Doesn't get Json File 'User'");
            e.printStackTrace();
        }
        return userModel;
    }

    public static User[] getJsonUsers() {
        RESPONSE_JSON = sendGetRequest(BASE_HTTP, USERS_POSTFIX);
        User[] userModels = null;
        try {
            userModels = new ObjectMapper().readValue(RESPONSE_JSON.getBody().toString(), User[].class);
        } catch (IOException e) {
            Logger.getInstance().debug("Doesn't get Json 'User'");
            e.printStackTrace();
        }
        return userModels;
    }

    public static Post postJsonPerson(Post personPost) {
        RESPONSE_JSON = sendPostRequest(BASE_HTTP, POSTS_POSTFIX, deserializationObject(personPost));
        Post person = null;
        try {
            person = new ObjectMapper().readValue(RESPONSE_JSON.getBody().toString(), Post.class);
        } catch (IOException e) {
            Logger.getInstance().debug("Can't post new 'Person'");
            e.printStackTrace();
        }
        return person;
    }
}
