package com.action;

import com.form.UserForm;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SampleService;

import javax.annotation.Resource;

/**
 * User: Anish
 * Date: 3/18/14
 * Time: 11:05 AM
 */
public class SampleAction extends ActionSupport {

    private UserForm userForm;
    private SampleService sampleService;

    public String execute(){
        System.out.println("######### execute ##############");
        return SUCCESS;
    }

    public String saveUser() {
        System.out.println("######### saveUser ##############");
        sampleService.saveUser(userForm);
        return SUCCESS;
    }

    public UserForm getUserForm() {
        return userForm;
    }

    public void setUserForm(UserForm userForm) {
        this.userForm = userForm;
    }

    @Resource
    public void setSampleService(SampleService sampleService) {
        this.sampleService = sampleService;
    }
}
