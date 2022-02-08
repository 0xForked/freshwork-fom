import { Component, OnInit } from '@angular/core';
import freshChat from './fresh-chat-plugin';
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  constructor() {}

  ngOnInit(): void {
    freshChat.init();
  }

  async openConversation() {
    const { value } = await freshChat.echo({ value: 'Hello World!' });
    console.log('Response from native:', value);
    freshChat.showConversations();
  }

}
