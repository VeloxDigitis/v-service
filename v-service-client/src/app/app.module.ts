import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { AppliancesComponent } from './appliances/appliances.component';
import { ApplianceFormComponent } from './appliance-form/appliance-form.component';
import { ApplianceDetailsComponent } from './appliance-details/appliance-details.component';
import { FooterComponent } from "./shared/layout/footer.component";
import { LoginComponent } from './login/login.component';
import {routing} from "./app.routing";
import {AuthGuard} from "./login/auth.guard";
import {AlertService} from "./alert/alert.service";
import { ApplianceStatsComponent } from './appliance-stats/appliance-stats.component';

@NgModule({
  declarations: [
    AppComponent,
    AppliancesComponent,
    ApplianceFormComponent,
    ApplianceDetailsComponent,
    FooterComponent,
    LoginComponent,
    ApplianceStatsComponent
  ],
  imports: [
    NgbModule.forRoot(),
    FormsModule,
    BrowserModule,
    HttpClientModule,
    routing
  ],
  providers: [
      AuthGuard,
      AlertService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
