import { Component, OnInit } from '@angular/core';
import {AlertService} from "../alert/alert.service";
import {ApplianceService} from "../shared/appliance.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router,
              private alertService: AlertService,
              private applianceService: ApplianceService) { }

  ngOnInit() {
  }

  login(username, password) {
    this.applianceService.login(username, password).subscribe(
        () => this.router.navigate(['/']));
  }

}
