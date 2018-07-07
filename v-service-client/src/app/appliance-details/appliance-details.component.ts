import {Component, Input, OnInit} from '@angular/core';
import {Appliance} from '../appliance';
import {ApplianceService} from "../appliance.service";

@Component({
  selector: 'app-appliance-details',
  templateUrl: './appliance-details.component.html',
  styleUrls: ['./appliance-details.component.css']
})
export class ApplianceDetailsComponent implements OnInit {

  @Input() appliance: Appliance;
  @Input() appliances: Appliance[];

  constructor(private applianceService: ApplianceService) { }

  ngOnInit() {
  }

  delete(): void {
      this.applianceService.delete(this.appliance);
      this.appliances.splice(this.appliances.indexOf(this.appliance), 1);
  }

  comment(commentText): void {
      this.appliance.comments.push(this.applianceService.sendComment(commentText, this.appliance));
  }

}
