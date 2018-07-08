import {Component, OnInit} from '@angular/core';
import {Appliance} from "../appliance";
import {ApplianceService} from "../appliance.service";
import {Category} from "../category";
import {State} from "../state";

@Component({
  selector: 'app-appliances',
  templateUrl: './appliances.component.html',
  styleUrls: ['./appliances.component.css']
})
export class AppliancesComponent implements OnInit {

  appliances: Appliance[];
  categories: Category[];
  isCollapsed = true;

  public state = State;

  constructor(private applianceService: ApplianceService) { }

  ngOnInit() {
    this.getAppliances();
    this.applianceService.getCategories()
        .subscribe(categories => {
            this.categories = categories;
        });
  }

  getAppliances(): void {
    this.applianceService.getAppliances()
        .subscribe(appliances => {
          this.appliances = appliances;
      });
  }

}
