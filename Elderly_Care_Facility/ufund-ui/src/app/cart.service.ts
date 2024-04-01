import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, of} from 'rxjs';
import {Need} from './need';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private needsUrl: string = "http://localhost:8080/ufundapi";

  httpOption = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }


  /**
    * GET Needs from server
   * @returns An array of needs
   */
  getNeeds(): Observable<Need[]> {
    return this.http.get<Need[]>(`${this.needsUrl}/cart/all`)
    .pipe(
      catchError(this.handleError<Need[]>('getNeeds', []))
    )
  }

  removeItem(id: number): Observable<Need> {
    return this.http.delete<Need>(`${this.needsUrl}/cart/needs/` + id)
    .pipe(
      catchError(this.handleError<Need>('removeItem'))
    )
  }

  submitCart(): Observable<Need> {
    return this.http.delete<Need>(`${this.needsUrl}/cart/needs`)
    .pipe(
      catchError(this.handleError<Need>('submitCart'))
    )
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(`${operation} failed: ${error.message}`); // log to console

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
