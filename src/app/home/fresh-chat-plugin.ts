import { registerPlugin } from '@capacitor/core';

export interface FreshChatPlugin {
  init();

  showConversations();

  echo(options: { value: string }): Promise<{ value: string }>;
}

const freshChat = registerPlugin<FreshChatPlugin>('FreshChat');

export default freshChat;
