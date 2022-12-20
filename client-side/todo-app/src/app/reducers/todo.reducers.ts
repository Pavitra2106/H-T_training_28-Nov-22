import { ActionParent } from "../actions/TodoActionType";
import { Todo } from "../models/Todo";
import { TodoActionType } from "../shared/todo-action-type.enum";

const intitialState :Todo[] =[
    {title:"title 1"},
    {title:"title 2"},
    {title:"title 2"}
];

export function TodoReducer (state = intitialState, action : ActionParent){
    switch(action.type){
        case TodoActionType.Add:
        return[...state, action.payload]
        case TodoActionType.Remove:
            let newState =[...state];
            newState.splice(action.payload,1)
        return newState;
        default:return state;

    }
}

