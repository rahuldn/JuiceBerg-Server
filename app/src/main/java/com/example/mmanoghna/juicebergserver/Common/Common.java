package com.example.mmanoghna.juicebergserver.Common;

import com.example.mmanoghna.juicebergserver.Model.User;

/**
 * Created by m.manoghna on 1/17/2018.
 */

public class Common {
    public static User CurrentUser;
    public static final String UPDATE="Update";
    public static final String DELETE="Delete";
    public static final int PICK_IMAGE_REQUEST=71;
    public static String convertcodetoStatus(String code)
    {
        if(code.equals("0"))
            return "Placed";
        else
            return "Not Placed";
    }
}
