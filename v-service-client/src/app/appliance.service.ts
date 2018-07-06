import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { Appliance } from './appliance';

@Injectable({ providedIn: 'root' })
export class ApplianceService {

    private heroesUrl = 'api/appliances';  // URL to web api

    constructor(private http: HttpClient) { }

    getAppliances (): Observable<Appliance[]> {
        return this.http.get<Appliance[]>(this.heroesUrl);
    }
}