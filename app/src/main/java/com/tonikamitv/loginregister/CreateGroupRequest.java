package com.tonikamitv.loginregister;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CreateGroupRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://10.0.2.2/android//createGroup.php";
    private Map<String, String> params;

    public CreateGroupRequest(String name_group, int id_user, int id_parennt_group, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener,null );

        params = new HashMap<>();
        params.put("name_group", name_group);
        params.put("id_parent_group", 0 +"");
        params.put("id_user", id_user +"");
        System.out.println("test");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
