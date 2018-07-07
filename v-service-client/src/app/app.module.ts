import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { AppliancesComponent } from './appliances/appliances.component';
import { ApplianceFormComponent } from './appliance-form/appliance-form.component';
import { ApplianceDetailsComponent } from './appliance-details/appliance-details.component';

@NgModule({
  declarations: [
    AppComponent,
    AppliancesComponent,
    ApplianceFormComponent,
    ApplianceDetailsComponent
  ],
  imports: [
    NgbModule.forRoot(),
    FormsModule,
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
