package io.ionic.starter;

import android.Manifest;
import android.util.Log;

import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatConfig;
import com.freshchat.consumer.sdk.FreshchatUser;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;

@CapacitorPlugin(
  name = "FreshChat",
  permissions = {
    @Permission(
      alias = "camera",
      strings = { Manifest.permission.CAMERA }
    ),
    @Permission(
      alias = "storage",
      strings = {
          Manifest.permission.READ_EXTERNAL_STORAGE,
          Manifest.permission.WRITE_EXTERNAL_STORAGE
      }
    )
  }
)
public class FreshChatPlugin extends Plugin
{
    @PluginMethod()
    public void init(PluginCall call)
    {
      // this key will expired in 18 days from 27 jan.
      FreshchatConfig config = new FreshchatConfig(
        "1189b29c-d543-4b3d-98e2-32608d4b7a2d",
        "1a184698-ee61-441a-8bd2-cf3933a10957"
      );
      config.setDomain("msdk.freshchat.com");
      config.setCameraCaptureEnabled(true);
      config.setGallerySelectionEnabled(true);
      config.setResponseExpectationEnabled(true);
      Freshchat.getInstance(
        getActivity()
          .getApplicationContext())
        .init(config);
    }

    @PluginMethod()
    public void setUser(PluginCall call)
    {

    }

    @PluginMethod()
    public void setUserProperties(PluginCall call)
    {

    }

    @PluginMethod()
    public void trackEvent(PluginCall call)
    {

    }

    @PluginMethod()
    public void resetUser(PluginCall call)
    {

    }

    @PluginMethod()
    public void showConversations(PluginCall call)
    {
      Freshchat.showConversations(getActivity().getApplicationContext());
      String id = Freshchat.getInstance(getActivity().getApplicationContext()).getFreshchatUserId();
      Log.d("user_id", id);
    }

    @PluginMethod()
    public void echo(PluginCall call) {
      String value = call.getString("value");
      JSObject ret = new JSObject();
      ret.put("value", value);
      call.resolve(ret);
    }
}
