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
  selectedAppliance: Appliance;

  constructor(private applianceService: ApplianceService) { }

  ngOnInit() {
    this.getAppliances();
  }

  getAppliances(): void {
    this.applianceService.getAppliances()
        .subscribe(appliances => {
          this.appliances = appliances;
          this.selectedAppliance = this.appliances[0];
      });
  }

  comment(commentText): void {
    this.selectedAppliance.comments.push(this.applianceService.sendComment(commentText, this.selectedAppliance));
  }

  onSelect(appliance: Appliance) {
    this.selectedAppliance = appliance;
  }
}
