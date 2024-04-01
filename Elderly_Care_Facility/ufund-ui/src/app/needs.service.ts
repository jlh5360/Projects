import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, of} from 'rxjs';
import {Need} from './need';

@Injectable({
  providedIn: 'root'
})
export class NeedsService {
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
    return this.http.get<Need[]>(`${this.needsUrl}/all`)
    .pipe(
      catchError(this.handleError<Need[]>('getNeeds', []))
    );
  }
  /**
    * GET Search needs
   * @returns An array of needs
   */
  searchNeeds(name: string): Observable<Need[]> {
    return this.http.get<Need[]>(`${this.needsUrl}/search/?name=` + name)
    .pipe(
      catchError(this.handleError<Need[]>('searchNeeds', []))
    );
  }

  addCart(need: Need): Observable<Need> {
    return this.http.post<Need>(`${this.needsUrl}/cart/needs`, need, this.httpOption)
    .pipe(
      catchError(this.handleError<Need>('addCart'))
    );
  }

  updateNeed(need: Need): Observable<Need> {
    return this.http.put<Need>(`${this.needsUrl}/needs/${need.id}`, need, this.httpOption)
    .pipe(
      catchError(this.handleError<Need>('updateNeed'))
    );
  }

  createNeed(need: Need): Observable<Need> {
    return this.http.post<Need>(`${this.needsUrl}/needs`, need, this.httpOption)
    .pipe(
      catchError(this.handleError<Need>('createNeed'))
    )
  }

  deleteNeed(need: Need): Observable<Need> {
    return this.http.delete<Need>(`${this.needsUrl}/needs/${need.id}`, this.httpOption)
    .pipe(
      catchError(this.handleError<Need>('deleteNeed'))
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
