import {Parameter} from "./parameter";
import {Category} from "./category";
import {State} from "./state";

export class Appliance {

    id: number;
    name: string;
    parameters: Parameter[];
    comments: Comment[];
    category: string;
    state: State = State.WORKING;

    constructor(name: string, category: Category, parameters: Parameter[]) {
        this.name = name;
        this.category = category.name;
        this.parameters = parameters;
    }

}
