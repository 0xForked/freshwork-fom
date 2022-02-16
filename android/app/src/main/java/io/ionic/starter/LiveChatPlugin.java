package io.ionic.starter;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.livechatinc.inappchat.ChatWindowConfiguration;
import com.livechatinc.inappchat.ChatWindowErrorType;
import com.livechatinc.inappchat.ChatWindowView;
import com.livechatinc.inappchat.models.NewMessageModel;

@CapacitorPlugin(
  name = "LiveChat",
  permissions = {
    @Permission(
      alias = "storage",
      strings = {
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
      }
    )
  }
)
public class LiveChatPlugin extends Plugin implements ChatWindowView.ChatWindowEventsListener {
  private ChatWindowConfiguration  configuration;
  private ChatWindowView fullScreenChatWindow;

  @PluginMethod()
  public void init(PluginCall call) {
    configuration = new ChatWindowConfiguration(
      "13527432",
      "0",
      "Visitor name",
      "visitor@email.com",
      null);
  }

  @PluginMethod()
  public void showConversations(PluginCall call)
  {
      if (fullScreenChatWindow == null) {
        fullScreenChatWindow = ChatWindowView.createAndAttachChatWindowInstance(getActivity());
        fullScreenChatWindow.setUpWindow(configuration);
        fullScreenChatWindow.setUpListener(LiveChatPlugin.this);
        fullScreenChatWindow.initialize();
      }
      fullScreenChatWindow.showChatWindow();
  }

  @Override
  public void onChatWindowVisibilityChanged(boolean visible) {

  }

  @Override
  public void onNewMessage(NewMessageModel message, boolean windowVisible) {

  }

  @Override
  public void onStartFilePickerActivity(Intent intent, int requestCode) {

  }

  @Override
  public boolean onError(ChatWindowErrorType errorType, int errorCode, String errorDescription) {
    return false;
  }

  @Override
  public boolean handleUri(Uri uri) {
    return false;
  }
}
