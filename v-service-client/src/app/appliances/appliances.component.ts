import {Component, OnInit} from '@angular/core';
import {Appliance} from "../shared/appliance";
import {ApplianceService} from "../shared/appliance.service";
import {Category} from "../shared/category";
import {State} from "../shared/state";
import {Router} from "@angular/router";

@Component({
  selector: 'app-appliances',
  templateUrl: './appliances.component.html',
  styleUrls: ['./appliances.component.css']
})
export class AppliancesComponent implements OnInit {

  appliances: Appliance[] = [];
  categories: Category[] = [];
  isCollapsed = true;

  public state = State;

  constructor(private applianceService: ApplianceService,
              private router: Router) { }

  ngOnInit() {
    this.getAppliances();
    this.applianceService.getCategories()
        .subscribe(categories => {
            this.categories = categories;
        });
    this.applianceService.login("admin", "admin");
  }

  getAppliances(): void {
    this.applianceService.getAppliances()
        .subscribe(
            (appliances: Appliance[]) => this.appliances = appliances,
            () => this.router.navigate(['login'])
      );
  }

  logout(): void {
    this.applianceService.logout();
    this.router.navigate(['login']);
  }

}
