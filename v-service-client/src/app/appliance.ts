import {Parameter} from "./parameter";
import {Category} from "./category";

export class Appliance {
    constructor(name: string, category: Category, parameters: Parameter[]) {
        this.name = name;
        this.category = category.name;
        this.parameters = parameters;
    }

    id: number;
    name: string;
    parameters: Parameter[];
    comments: Comment[];
    category: string;
}