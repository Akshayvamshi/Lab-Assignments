angular.module('app.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider
    
  

      .state('page', {
    url: '/page1',
    templateUrl: 'templates/page.html',
    controller: 'pageCtrl'
  })

  .state('ionicApp', {
    url: '/page2',
    templateUrl: 'templates/ionicApp.html',
    controller: 'ionicAppCtrl'
  })

  .state('signup', {
    url: '/page3',
    templateUrl: 'templates/signup.html',
    controller: 'signupCtrl'
  })

  .state('homePage', {
    url: '/page4',
    templateUrl: 'templates/homePage.html',
    controller: 'homePageCtrl'
  })

$urlRouterProvider.otherwise('/page1')

  

});