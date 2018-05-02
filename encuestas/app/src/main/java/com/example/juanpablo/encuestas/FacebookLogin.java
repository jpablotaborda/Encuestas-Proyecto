package com.example.juanpablo.encuestas;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.facebook.*;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class FacebookLogin extends FragmentActivity
{
    private TextView tvfirst_name, tvlast_namee, tvfull_name, tvEmail;
    private CallbackManager callbackManager;
    LoginButton login_button;
    String email,name,first_name,last_name;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.fragment_facebooklogin);

        tvfirst_name        = (TextView) findViewById(R.id.first_name);
        tvlast_namee        = (TextView) findViewById(R.id.last_name);
        tvfull_name         = (TextView) findViewById(R.id.full_name);
        tvEmail             = (TextView) findViewById(R.id.email);
        login_button        = (LoginButton) findViewById(R.id.login_button);

        login_button.setReadPermissions(Arrays.asList("public_profile","email"));
        login_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>()
        {
            @Override
            public void onSuccess(LoginResult loginResult)
            {
                login_button.setVisibility(View.GONE);

                GraphRequest graphRequest   =   GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback()
                {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response)
                    {
                        Log.d("JSON", ""+response.getJSONObject().toString());

                        try
                        {
                            email       =   object.getString("email");
                            name        =   object.getString("name");
                            first_name  =   object.optString("first_name");
                            last_name   =   object.optString("last_name");

                            tvEmail.setText(email);
                            tvfirst_name.setText(first_name);
                            tvlast_namee.setText(last_name);
                            tvfull_name.setText(name);
                            LoginManager.getInstance().logOut();
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,first_name,last_name,email");
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();
            }

            @Override
            public void onCancel()
            {

            }

            @Override
            public void onError(FacebookException exception)
            {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}