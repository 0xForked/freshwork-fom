import { Injectable } from '@angular/core';
import { PushNotifications } from '@capacitor/push-notifications';
import { Capacitor  } from '@capacitor/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class FcmService {

  constructor(private router: Router) { }

  initPush() {
    if (Capacitor.getPlatform() !== 'web') {
      this.registerPush();
    }
  }

  private async registerPush() {
    await PushNotifications.addListener('registration', token => {
      console.log('Registration token: ', token.value);
    });

    await PushNotifications.addListener('registrationError', err => {
      console.error('Registration error: ', err.error);
    });

    await PushNotifications.addListener('pushNotificationReceived', notification => {
      console.log('Push notification received: ', notification.body);
    });

    await PushNotifications.addListener('pushNotificationActionPerformed', notification => {
      console.log('Push notification action performed', notification.actionId, notification.inputValue);
    });

    let permStatus = await PushNotifications.checkPermissions();

    if (permStatus.receive === 'prompt') {
      permStatus = await PushNotifications.requestPermissions();
    }

    if (permStatus.receive !== 'granted') {
      throw new Error('User denied permissions!');
    }

    await PushNotifications.register();

    const notificationList = await PushNotifications.getDeliveredNotifications();
    console.log('delivered notifications', notificationList);
  }
}
