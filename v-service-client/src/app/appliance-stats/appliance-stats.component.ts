import {Component, Input, OnInit} from '@angular/core';
import {Appliance} from "../shared/appliance";
import {State} from "../shared/state";

@Component({
  selector: 'app-appliance-stats',
  templateUrl: './appliance-stats.component.html',
  styleUrls: ['./appliance-stats.component.css']
})
export class ApplianceStatsComponent implements OnInit {

  @Input() appliances: Appliance[] = [];
  public state = State;

  constructor() { }

  ngOnInit() {
  }

  count(s: State) {
    return this.appliances.filter(a => a.state.valueOf() === s.valueOf()).length;
  }

}
