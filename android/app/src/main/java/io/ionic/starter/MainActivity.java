package io.ionic.starter;

import android.content.Context;
import android.os.Bundle;

import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatConfig;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    initFreshChat(this);

    registerPlugin(FreshChatPlugin.class);
  }

  private void initFreshChat(Context ctx) {
    // this key will expired in 18 days from 27 jan.
    FreshchatConfig config = new FreshchatConfig(
      "1189b29c-d543-4b3d-98e2-32608d4b7a2d",
      "1a184698-ee61-441a-8bd2-cf3933a10957"
    );
    config.setDomain("msdk.freshchat.com");
    config.setCameraCaptureEnabled(true);
    config.setGallerySelectionEnabled(true);
    config.setResponseExpectationEnabled(true);
    Freshchat.getInstance(ctx.getApplicationContext()).init(config);
  }
}
