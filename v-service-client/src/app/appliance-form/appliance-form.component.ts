import {Component, Input, OnInit} from '@angular/core';
import {Appliance} from "../appliance";
import {ApplianceService} from "../appliance.service";
import {Category} from "../category";
import {Parameter} from "../parameter";

@Component({
  selector: 'app-appliance-form',
  templateUrl: './appliance-form.component.html',
  styleUrls: ['./appliance-form.component.css']
})

export class ApplianceFormComponent implements OnInit {

  @Input() appliances: Appliance[];
  @Input() categories: Category[];

  parameters: Parameter[] = [];

  constructor(private applianceService: ApplianceService) { }

  ngOnInit() {
  }


  addParameter(paramName: string, paramValue: string) {
    this.parameters.push(new Parameter(paramName, paramValue));
  }

  add(name: string, category: Category, parameters: Parameter[]): void {
    this.applianceService.register(new Appliance(name, category, parameters)).
      subscribe(appliance => this.appliances.unshift(appliance));
  }

}
