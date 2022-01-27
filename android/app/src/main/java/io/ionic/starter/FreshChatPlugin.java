package io.ionic.starter;

import android.Manifest;

import com.freshchat.consumer.sdk.Freshchat;
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
    }

    @PluginMethod()
    public void echo(PluginCall call) {
      String value = call.getString("value");
      System.out.println(value);
      JSObject ret = new JSObject();
      ret.put("value", value);
      call.resolve(ret);
    }
}
