import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";
import {ApplianceService} from "../shared/appliance.service";

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(private router: Router, private service: ApplianceService) { }

    canActivate(route: ActivatedRouteSnapshot) {
        if(localStorage.getItem('auth') != null)
            return true;

        this.router.navigate(['/login']);
        return false;
    }
}