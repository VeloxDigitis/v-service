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
        localStorage.setItem('auth', "Basic " + btoa(username + ":" + password));
        return this.http.get('api/ping', this.getHeaders());
    }

    getAppliances (): Observable<Appliance[]> {
        return this.http.get<Appliance[]>(this.applaianceUrl, this.getHeaders());
    }

    getCategories (): Observable<Category[]> {
        return this.http.get<Category[]>(this.categoriesUrl, this.getHeaders());
    }

    sendComment(commentText: string, appliance: Appliance) {
        let comment: Comment = new Comment(commentText);
        return this.http.post<Comment>(this.applaianceUrl + appliance.id + this.commentsUrl, comment, this.getHeaders());
    }

    delete(appliance: Appliance) {
        return this.http.delete(this.applaianceUrl + appliance.id, this.getHeaders());
    }

    register(appliance: Appliance) {
        return this.http.post<Appliance>(this.applaianceUrl, appliance, this.getHeaders());
    }

    updateState(appliance: Appliance, state: State) {
        console.log(this.headers);
        return this.http.patch<Appliance>(this.applaianceUrl + appliance.id, state, this.getHeaders());
    }

    getHeaders() {
        if(this.headers.get('Authorization') == null) {
            this.headers = this.headers.append("Authorization", localStorage.getItem('auth'));
            this.headers = this.headers.append("Content-Type", "application/json");
        }
        return {headers: this.headers};
    }

    logout() {
        this.headers = new HttpHeaders();
        localStorage.removeItem('auth');
    }
}