package com.solvd.ApiAutomation.api.declarative;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.EndpointTemplate;
import com.zebrunner.carina.api.annotation.PathParam;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.annotation.method.DeleteMethod;
import com.zebrunner.carina.api.annotation.method.GetMethod;
import com.zebrunner.carina.api.annotation.method.PatchMethod;
import com.zebrunner.carina.api.annotation.method.PostMethod;
import com.zebrunner.carina.api.annotation.method.PutMethod;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@EndpointTemplate(url = "${base_url}/users")
public interface IUserApi {

    @GetMethod(url = "/")
    @ResponseTemplatePath(path = "api/users/_get/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getUsers();

    @GetMethod(url = "/${id}")
    @ResponseTemplatePath(path = "api/users/_get_by_id/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 getUserById(@PathParam(key = "id") String id);

    @PostMethod(url = "/")
    @RequestTemplatePath(path = "api/users/_post/rq.json")
    @ResponseTemplatePath(path = "api/users/_post/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
    AbstractApiMethodV2 createUser();

    @PutMethod(url = "/${id}")
    @RequestTemplatePath(path = "api/users/_put/rq.json")
    @ResponseTemplatePath(path = "api/users/_put/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 updateUser(@PathParam(key = "id") String id);

    @PatchMethod(url = "/${id}")
    @RequestTemplatePath(path = "api/users/_patch/rq.json")
    @ResponseTemplatePath(path = "api/users/_patch/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 patchUser(@PathParam(key = "id") String id);

    @DeleteMethod(url = "/${id}")
    @RequestTemplatePath(path = "api/users/_delete/rq.json")
    @ResponseTemplatePath(path = "api/users/_delete/rs.json")
    @SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
    AbstractApiMethodV2 deleteUser(@PathParam(key = "id") String id);
}
