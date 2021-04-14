package com.servlet.web.frontcontroller.v3.controller;

import com.servlet.web.frontcontroller.ModelView;
import com.servlet.web.frontcontroller.MyView;
import com.servlet.web.frontcontroller.v2.ControllerV2;
import com.servlet.web.frontcontroller.v3.ControllerV3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) throws ServletException, IOException {
        return new ModelView("new-form");
    }
}
