import {Component, Input, OnInit} from '@angular/core';
import {Appliance} from "../shared/appliance";
import {ApplianceService} from "../shared/appliance.service";
import {Category} from "../shared/category";
import {Parameter} from "../shared/parameter";

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
      subscribe(appliance => {
        this.appliances.unshift(appliance);
        this.parameters = [];
    });
  }

}
