## Run

Complete a fresh build of your Ionic project, fixing any errors that it reports:
```bash
$ ionic build
```

Every time you perform a build,  you'll need to copy those changes into your native projects:
```bash
$ ionic cap copy
```

Note: After making updates to the native portion of the code (such as adding a new plugin), use the sync command:
```bash
$ ionic cap sync
```

## The other things

1. If you want to opens the native Android/iOS project in Android Studio/X-Code

    Run the Capacitor open command:
    ```bash
    $ ionic cap open {android/ios}
    ```

2. Live Reload​: when `ionic serve` was live reload working in the browser, let use capacitor to do it with native app

    ```bash
    $ ionic cap run {android/ios} -l --external
    ```


## Ionic page life cycle 

----> ngOnInit : Fired once during component initialization. 

----> ngOnDestroy : Fired right before Angular destroys the view. 

## Ionic page events

----> ionViewWillEnter: Fired when the component routing to is about to animate into view.

----> ionViewDidEnter: Fired when the component routing to has finished animating.

----> ionViewWillLeave: Fired when the component routing from is about to animate.

----> ionViewDidLeave: Fired when the component routing to has finished animating.



TODO
1. Impl FCM Push Notify (requred by fresh chat)
2. Impl Fresh-Messanging