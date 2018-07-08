import {RouterModule, Routes} from "@angular/router";
import {LoginComponent} from "./login/login.component";
import {AppliancesComponent} from "./appliances/appliances.component";
import {AuthGuard} from "./login/auth.guard";

const appRoutes: Routes = [
    { path: '', component: AppliancesComponent, canActivate: [AuthGuard]},
    { path: 'login', component: LoginComponent },

    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);