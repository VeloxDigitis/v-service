import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { Appliance } from './appliance';
import { Comment } from './comment';

@Injectable({ providedIn: 'root' })
export class ApplianceService {

    private heroesUrl = 'api/appliances/';  // URL to web api
    private commentsUrl = '/comment';  // URL to web api

    constructor(private http: HttpClient) { }

    getAppliances (): Observable<Appliance[]> {
        return this.http.get<Appliance[]>(this.heroesUrl);
    }

    sendComment(commentText: string, appliance: Appliance) {
        var comment: Comment = new Comment(commentText);
        this.http.post(this.heroesUrl + appliance.id + this.commentsUrl, comment).subscribe();
        return comment;
    }

    delete(appliance: Appliance) {
        this.http.delete(this.heroesUrl + appliance.id).subscribe();
    }
}