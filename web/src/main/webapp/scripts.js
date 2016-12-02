(function() {

    'use strict';

    angular.module('app', []);

    angular.module('app').
        component('todos', {
            templateUrl: 'html/todo.component.html',
            controller: TodoController
        });

    function TodoController($http) {

        //agh...
        var self = this;

        self.getViewContent = function() {
            //get list of all todos from api
            $http.get('/api/todo').then(function(response) {
                self.todos = response.data;
            });
        };

        self.getViewContent();

        self.changeState = function(todo) {

            //reverse state
            todo.completed = !todo.completed;

            $http.put('/api/todo', todo).then(function(response) {
                self.getViewContent();
            }, function(error) {
                alert(error);
            });
        };

        self.createTodo = function(todo) {

            $http.post('/api/todo', todo).then(function(response) {
                self.getViewContent();
            }, function(error) {
                alert(error);
            });
        };

    }

    TodoController.$inject = ['$http'];

})();