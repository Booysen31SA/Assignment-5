package com.Booysen31SA.factory;

import com.Booysen31SA.domain.ResponseObj;

public class ResponseObjFactory {

    public static ResponseObj buildGenericResponseObj(String responseCode, String responseDescription) {
        return new ResponseObj(responseCode, responseDescription);
    }
}
