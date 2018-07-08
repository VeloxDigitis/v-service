import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { Appliance } from './appliance';
import { Comment } from './comment';
import { Category } from './category';
import { State } from './state';
import {AlertService} from "../alert/alert.service";

@Injectable({ providedIn: 'root' })
export class ApplianceService {

    private applaianceUrl = 'api/appliances/';  // URL to web api
    private commentsUrl = '/comment';  // URL to web api

    private categoriesUrl = 'api/categories';  // URL to web api

    public headers = new HttpHeaders();

    constructor(private http: HttpClient, private a: AlertService) {}

    login (username: string, password: string) {
        this.logout();
        this.headers = this.headers.append("Authorization", "Basic " + btoa(username + ":" + password));
        this.headers = this.headers.append("Content-Type", "application/json");
    }

    logout() {
        this.headers = new HttpHeaders();
    }

    getAppliances (): Observable<Appliance[]> {
        return this.http.get<Appliance[]>(this.applaianceUrl, {headers: this.headers});
    }

    getCategories (): Observable<Category[]> {
        return this.http.get<Category[]>(this.categoriesUrl, {headers: this.headers});
    }

    sendComment(commentText: string, appliance: Appliance) {
        let comment: Comment = new Comment(commentText);
        return this.http.post<Comment>(this.applaianceUrl + appliance.id + this.commentsUrl, comment, {headers: this.headers});
    }

    delete(appliance: Appliance) {
        return this.http.delete(this.applaianceUrl + appliance.id, {headers: this.headers});
    }

    register(appliance: Appliance) {
        return this.http.post<Appliance>(this.applaianceUrl, appliance, {headers: this.headers});
    }

    updateState(appliance: Appliance, state: State) {
        console.log(this.headers);
        return this.http.patch<Appliance>(this.applaianceUrl + appliance.id, state, {headers: this.headers});
    }
}