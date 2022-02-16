import { registerPlugin } from '@capacitor/core';

export interface LiveChatPlugin {
  init(): Promise<{ value: object }>;

  setUser(options: object): Promise<{ value: object }>;

  getUser(): Promise<{ value: object }>;

  showConversations(): Promise<{ value: object }>;
}

const liveChat = registerPlugin<LiveChatPlugin>('LiveChat');

export default liveChat;
