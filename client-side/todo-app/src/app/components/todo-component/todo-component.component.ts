import { Component, OnInit } from '@angular/core';
import { Store,select } from '@ngrx/store';
import { TodoRemove } from 'src/app/actions/TodoActionType';
import { Todo } from 'src/app/models/Todo';
import { TodoReducer } from 'src/app/reducers/todo.reducers';

@Component({
  selector: 'app-todo-component',
  templateUrl: './todo-component.component.html',
  styleUrls: ['./todo-component.component.css']
})
export class TodoComponentComponent implements OnInit {

  todos: Todo[];
  
  constructor(private store :Store<{ todos :Todo[]}>) {
    store.pipe(select ('todos')).subscribe((values) => {
      this.todos = values;
      console.log(values);
    });
   }
   removeTodo(index : number){
     this.store.dispatch(new TodoRemove(index));
   }

  ngOnInit(): void {
  }

}
