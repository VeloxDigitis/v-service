import {Parameter} from "./parameter";

export class Appliance {
    id: number;
    name: string;
    parameters: Parameter[];
    comments: Comment[];
    category: string;
}