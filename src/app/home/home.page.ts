import { Component, OnInit } from '@angular/core';
import freshChat from './freshchat';
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  constructor() {}


  ngOnInit(): void {
    console.log('hello world');
  }

  async openConversation() {
    console.log('hello wold ceeesss');
    const { value } = await freshChat.echo({ value: 'Hello World!' });
    console.log('Response from native:', value);
    freshChat.showConversations();
  }

}
