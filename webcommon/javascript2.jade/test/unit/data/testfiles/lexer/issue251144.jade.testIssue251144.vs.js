'text/javascript';
      window.habitrpg
      .controller('StaticAvatarCtrl', ['$scope', function($scope){
        $scope.profile = window.env.user;
      }])
      
      