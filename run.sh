# Complete a fresh build of your Ionic project, fixing any errors that it reports:
ionic build

# Every time you perform a build,  you'll need to copy those changes into your native projects:
ionic cap copy

# Note: After making updates to the native portion of the code (such as adding a new plugin), use the sync command:
ionic cap sync

# Live Reload​: when `ionic serve` was live reload working in the browser, let use capacitor to do it with native app
ionic cap run android -l --external