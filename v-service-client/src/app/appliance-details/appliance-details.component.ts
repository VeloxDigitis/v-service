import {Component, Input, OnInit} from '@angular/core';
import {Appliance} from '../appliance';
import {State} from '../state';
import {ApplianceService} from "../appliance.service";

@Component({
  selector: 'app-appliance-details',
  templateUrl: './appliance-details.component.html',
  styleUrls: ['./appliance-details.component.css']
})
export class ApplianceDetailsComponent implements OnInit {

  @Input() appliance: Appliance;
  @Input() appliances: Appliance[];

  public state = State;

  constructor(private applianceService: ApplianceService) { }

  ngOnInit() {
  }

  delete(): void {
      if(confirm("Are you sure to delete " + this.appliance.name + "?"))
          this.applianceService.delete(this.appliance).
            subscribe(() => this.appliances.splice(this.appliances.indexOf(this.appliance), 1));
  }

  comment(commentText): void {
      this.applianceService.sendComment(commentText, this.appliance).
        subscribe(c => this.appliance.comments.push(c));
  }

  report() {
      this.applianceService.updateState(this.appliance,
          this.appliance.state === State.OUT_OF_ORDER ? State.WORKING : State.OUT_OF_ORDER).
            subscribe(a => this.appliance.state = a.state);
  }

}
