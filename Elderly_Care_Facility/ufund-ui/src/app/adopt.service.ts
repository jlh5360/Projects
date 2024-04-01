import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, of} from 'rxjs';
import { Elderly } from './elderly';

@Injectable({
  providedIn: 'root'
})
export class AdoptService {
  private elderliesUrl: string = "http://localhost:8080/ufundapi/adoption";

  httpOption = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  
  /**
    * GET Elderlies from server
   * @returns An array of elderlies
   */
  getElderlies(): Observable<Elderly[]> {
    return this.http.get<Elderly[]>(`${this.elderliesUrl}/all`)
    .pipe(
      catchError(this.handleError<Elderly[]>('getElderlies', []))
    )
  }

  addElderly(elderly: Elderly): Observable<Elderly> {
    return this.http.post<Elderly>(`${this.elderliesUrl}/elderly`, elderly, this.httpOption)
      .pipe(
        catchError(this.handleError<Elderly>('addElderly'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.error(`${operation} failed: ${error.message}`); // log to console

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  updateElderly(elderly: Elderly): Observable<Elderly> {
    const id = elderly.id; // Assuming you have an id property in the Elderly model
    const url = `${this.elderliesUrl}/elderly/${id}`;

    return this.http.put<Elderly>(url, elderly, this.httpOption)
      .pipe(
        catchError(this.handleError<Elderly>('updateElderly'))
      );
  }
  
  removeElderly(id: number): Observable<any> {
    const url = `${this.elderliesUrl}/elderly/${id}`;
    return this.http.delete(url, this.httpOption)
      .pipe(
        catchError(this.handleError<any>('removeElderly'))
      );
  }
}
