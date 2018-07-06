import { Component, OnInit } from '@angular/core';
import {Appliance} from "../appliance";
import {ApplianceService} from "../appliance.service";

@Component({
  selector: 'app-appliances',
  templateUrl: './appliances.component.html',
  styleUrls: ['./appliances.component.css']
})
export class AppliancesComponent implements OnInit {

  appliances: Appliance[];

  constructor(private applianceService: ApplianceService) { }

  constructor() { }

  ngOnInit() {
    this.getAppliances();
  }

  getAppliances(): void {
    this.applianceService.getAppliances()
        .subscribe(appliances => this.appliances = appliances);
  }

}
