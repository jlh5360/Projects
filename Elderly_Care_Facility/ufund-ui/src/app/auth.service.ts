import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of} from 'rxjs';
import {User} from './user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private needsUrl: string = "http://localhost:8080/ufundapi";

  httpOption = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }


  setCurrentUser(user: User) {
    localStorage.setItem("currentUser", JSON.stringify(user));
  }

  login(user: User): Observable<User> {
    return this.http.post<User>(`${this.needsUrl}/users/login`, user, this.httpOption)
    .pipe(
      catchError(this.handleError<User>('login'))
    )
  }

  signup(user: User): Observable<User> {
    return this.http.post<User>(`${this.needsUrl}/users/signup`, user, this.httpOption)
    .pipe(
      catchError(this.handleError<User>('signup'))
    );
  }

  logout(user: User): Observable<User> {
    return this.http.post<User>(`${this.needsUrl}/users/logout`, user, this.httpOption)
    .pipe(
      catchError(this.handleError<User>('logout'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(`${operation} failed: ${error.message}`); // log to console

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
