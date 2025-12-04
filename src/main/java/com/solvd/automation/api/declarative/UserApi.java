package com.solvd.automation.api.declarative;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class UserApi implements IUserApi {

    @Override
    public AbstractApiMethodV2 getUsers() {
        AbstractApiMethodV2 apiMethod = new AbstractApiMethodV2() {};
        apiMethod.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        return apiMethod;
    }

    @Override
    public AbstractApiMethodV2 getUserById(String id) {
        AbstractApiMethodV2 apiMethod = new AbstractApiMethodV2() {};
        apiMethod.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        apiMethod.replaceUrlPlaceholder("id", id);
        return apiMethod;
    }

    @Override
    public AbstractApiMethodV2 createUser() {
        AbstractApiMethodV2 apiMethod = new AbstractApiMethodV2(
            "api/users/_post/rq.json",
            "api/users/_post/rs.json",
            "api/users/user.properties"
        ) {};
        apiMethod.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        return apiMethod;
    }

    @Override
    public AbstractApiMethodV2 updateUser(String id) {
        AbstractApiMethodV2 apiMethod = new AbstractApiMethodV2(
            "api/users/_put/rq.json",
            "api/users/_put/rs.json",
            "api/users/user.properties"
        ) {};
        apiMethod.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        apiMethod.replaceUrlPlaceholder("id", id);
        return apiMethod;
    }

    @Override
    public AbstractApiMethodV2 patchUser(String id) {
        AbstractApiMethodV2 apiMethod = new AbstractApiMethodV2(
            "api/users/_patch/rq.json",
            "api/users/_patch/rs.json",
            "api/users/user.properties"
        ) {};
        apiMethod.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        apiMethod.replaceUrlPlaceholder("id", id);
        return apiMethod;
    }

    @Override
    public AbstractApiMethodV2 deleteUser(String id) {
        AbstractApiMethodV2 apiMethod = new AbstractApiMethodV2(
            "api/users/_delete/rq.json",
            "api/users/_delete/rs.json",
            "api/users/user.properties"
        ) {};
        apiMethod.replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        apiMethod.replaceUrlPlaceholder("id", id);
        return apiMethod;
    }
}

